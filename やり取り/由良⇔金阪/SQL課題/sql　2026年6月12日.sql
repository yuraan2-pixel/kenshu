CREATE TABLE 口座 (
口座番号 CHAR(7) PRIMARY KEY,
名義    VARCHAR(40) NOT NULL,
種別    CHAR(1) NOT NULL,
残高    INTEGER CHECK (残高 >= 0),
更新日  DATE
);

CREATE TABLE 廃止口座 (
口座番号  CHAR(7) PRIMARY KEY,
名義      VARCHAR(40) NOT NULL,
種別      CHAR(1) NOT NULL,
解約時残高 INTEGER CHECK (解約時残高 >= 0),
更新日    DATE
);

CREATE TABLE 取引 (
取引番号 INTEGER PRIMARY KEY,
取引事由ID INTEGER REFERENCES 取引事由,
日付 DATE NOT NULL,
口座番号 CHAR(7) NOT NULL,
入金額 INTEGER,
出金額 INTEGER
);

CREATE TABLE 取引事由 (
取引事由ID INTEGER PRIMARY KEY,
取引事由名 VARCHAR(20) NOT NULL
);

CREATE TABLE PRODUCT (
商品コード CHAR(3) PRIMARY KEY,
商品名 VARCHAR(20),
単価 NUMBER
);

CREATE TABLE STOCK (
商品コード CHAR(3)REFERENCES PRODUCT,
在庫数 INTEGER NOT NULL,
入出庫履歴 DATE NOT NULL
);

-----Chapter2-----

--c.1.1.1
SELECT 口座番号,名義,種別,残高,更新日 FROM 口座;

--c.1.1.2
SELECT 口座番号 FROM 口座;

--c.1.1.3
SELECT 口座番号,残高 FROM 口座;

--c.1.1.4
SELECT * FROM 口座;

--c.1.1.5
--UPDATE 口座 SET 名義 = 'X X X X X';

--c.1.1.6
--UPDATE 口座 SET 残高 = 99999999, 更新日 = '2024-03-01';

--c.1.1.7
--INSERT INTO 口座 VALUES ('0642191', 'アオキ　ハルカ', '1', 3640551, '2024-03-13');
--INSERT INTO 口座 VALUES ('1039410', 'キノシタ　リュウジ', '1', 259017, '2023-11-30');
--INSERT INTO 口座 VALUES ('1239855', 'タカシナ　ミツル', '2', 6509773, 'null');

--c.1.1.8
--DELETE FROM 口座;

-----Chapter3-----

--c.1.1.9
SELECT * FROM 口座 WHERE 口座番号 = '0037651';

--c.1.1.10
SELECT * FROM 口座 WHERE 残高 > 0;

--c.1.1.11
SELECT * FROM 口座 WHERE 口座番号 <= 1000000;

--c.1.1.12
SELECT * FROM 口座 WHERE 更新日 <= '23-12-31';

--c.1.1.13
SELECT * FROM 口座 WHERE 残高 >= 1000000;

--c.1.1.14
SELECT * FROM 口座 WHERE 種別 != 1;

--c.1.1.15
SELECT * FROM 口座 WHERE 更新日 IS NULL;

--c.1.1.16
SELECT * FROM 口座 WHERE 名義 LIKE '%ハシ%';

--c.1.1.17
SELECT * FROM 口座 WHERE 更新日 LIKE '24-01-%';

--c.1.1.18
SELECT * FROM 口座 WHERE 種別 != 1;

--c.1.1.19
SELECT * FROM 口座 WHERE 名義 = 'サカタ　リョウヘイ'
    OR 名義 = 'マツモト　ミワコ' OR 名義 = 'ハマダ　サトシ';

--c.1.1.20
SELECT * FROM 口座 WHERE 更新日 BETWEEN '23-12-30' AND '24-01-04';

--c.1.1.21
SELECT * FROM 口座 WHERE 残高 < 10000 AND 更新日 IS NOT NULL;

--c.1.1.22
SELECT * FROM 口座 WHERE 口座番号 >= 2000000 
    AND 口座番号 < 3000000 OR 名義 LIKE 'エ__%コ';

--c.1.1.23
--SELECT * FROM 口座 WHERE PRIMARY KEY;?

SELECT COLUMN_NAME FROM USER_CONS_COLUMNS UCC
WHERE TABLE_NAME IN ('口座', '廃止口座', '取引')
AND EXISTS (
  SELECT * FROM USER_CONSTRAINTS UC WHERE UCC.OWNER = UC.OWNER
  AND UCC.CONSTRAINT_NAME = UC.CONSTRAINT_NAME AND UC.CONSTRAINT_TYPE = 'P');

-----Chapter4-----

--c.1.1.24
SELECT * FROM 口座 ORDER BY 更新日;

--c.1.1.25
SELECT DISTINCT 名義 FROM 口座 ORDER BY "名義";

--c.1.1.26
SELECT * FROM 口座 ORDER BY 4 DESC , 1 DESC;

--c.1.1.27
SELECT 更新日 FROM 口座 WHERE 更新日 IS NOT NULL
    ORDER BY 1 OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;

--c.1.1.28
SELECT 更新日, 残高 FROM 口座 WHERE "残高" != 0 AND 更新日 IS NOT NULL
    ORDER BY "残高" , "更新日" DESC OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY; 

--c.1.1.29
SELECT 口座番号 FROM 口座 UNION SELECT 口座番号 FROM 廃止口座 ORDER BY 口座番号;

--c.1.1.30
SELECT 名義 FROM 口座 MINUS SELECT 名義 FROM 廃止口座 ORDER BY 名義;

--c.1.1.31
SELECT 名義 FROM 口座 INTERSECT SELECT 名義 FROM 廃止口座 ORDER BY 名義;

--c.1.1.32
SELECT 口座番号, 残高 FROM 口座 WHERE 残高 != 0 UNION
    SELECT 口座番号, 残高 FROM 廃止口座 WHERE 解約時残高 != 0 ORDER BY 口座番号;

-----Chapter5-----

--c.1.1.33
SELECT 口座番号, 名義, CASE WHEN 残高 >= 0 THEN '○' END AS 口座状況 
    FROM 口座 UNION SELECT 口座番号, 名義, CASE WHEN 
        解約時残高 >= 0 THEN '×' END AS 口座状況 FROM 廃止口座 ORDER BY 名義;

--c.1.1.34
SELECT 口座番号, ROUND("残高", -3) AS "千円単位の残高" FROM 口座 WHERE "残高" >= 1000000;

--c.1.1.35
--INSERT INTO 口座 VALUES (0652281, 'タカギ　ノブオ', 1, 100000 + 3000, '2024-04-01');
--INSERT INTO 口座 VALUES (1026413, 'マツモト　サワコ', 1, 300000 + 3000, '2024-04-02');
--INSERT INTO 口座 VALUES (2239710, 'ササキ　シゲノリ', 1, 1000000 + 3000, '2024-04-03');

--c.1.1.36
--UPDATE 口座 SET 残高 = 残高 - 3000 + (残高 - 3000) * 0.003 WHERE "更新日" = '2024-04-01'
--    OR "更新日" = '2024-04-02' OR "更新日" = '2024-04-03';

--c.1.1.37
SELECT 口座番号, 更新日, 更新日 + 180 AS 通帳期限日 FROM 口座 WHERE "更新日" <= '2022';

--c.1.1.38
SELECT 口座番号, CONCAT('カ)', 名義) FROM 口座 WHERE 種別 = 3;

--c.1.1.39
SELECT DISTINCT 種別 AS 種別コード, CASE WHEN 種別 = '1' THEN '普通' 
    WHEN 種別 = '2' THEN '当座' WHEN 種別 = '3' THEN '別段' END AS 種別名 FROM 口座;

--c.1.1.40
SELECT 口座番号, 名義, CASE WHEN 残高 < 100000 THEN 'C' WHEN 残高 >= 100000 
    AND 残高 < 1000000 THEN 'B' ELSE 'A' END AS "残高ランク" FROM 口座;

--c.1.1.41
SELECT LENGTH(口座番号), LENGTH(REPLACE(名義, '　', '')), LENGTH(残高) FROM 口座;

--c.1.1.42
SELECT * FROM 口座 WHERE SUBSTR(名義, 1, 5) LIKE '%カワ%';

--c.1.1.43
SELECT * FROM 口座 WHERE LENGTH(残高) >= 4 AND TRUNC(残高, -3) = "残高";

--c.1.1.44
SELECT 口座番号, 残高, TRUNC(("残高" * 0.0002), 0) AS 利息 FROM 口座;

--c.1.1.45
SELECT 口座番号, 残高, CASE WHEN 残高 < 500000 THEN TRUNC(("残高" * 0.0001), 0) 
    WHEN 残高 >= 500000 AND 残高 < 2000000 THEN TRUNC(("残高" * 0.0002), 0) 
        WHEN 残高 >= 2000000 THEN TRUNC(("残高" * 0.0003), 0) END AS 残高別利息
            FROM 口座 ORDER BY 残高別利息 DESC, "口座番号";

--c.1.1.46
INSERT INTO 口座 VALUES (0351262, 'イトカワ　ダイ', 2, 635110, CURRENT_DATE);
INSERT INTO 口座 VALUES (1015513, 'アキツ　ジュンジ', 1, 88463, CURRENT_DATE);
INSERT INTO 口座 VALUES (1739298, 'ホシノ　サトミ', 1, 704610, CURRENT_DATE);

--c.1.1.47
SELECT 口座番号, "名義", "種別", "残高", TO_CHAR(更新日, 'YYYY"年"MM"月"DD"日"') AS "更新日" 
    FROM 口座 WHERE "更新日" >= TO_DATE('2024-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS');

--c.1.1.48
SELECT COALESCE(TO_CHAR(更新日), '設定なし') AS "更新日" FROM 口座;

-----Chapter6-----

--c.1.1.49
SELECT SUM(残高) AS 合計, MAX(残高) AS 最大, MIN(残高) AS 最小, 
    AVG(残高) AS 平均, COUNT(残高) AS 登録データ件数 FROM 口座;

--c.1.1.50
SELECT COUNT(*) AS データ件数 FROM 口座 WHERE "種別" != 1 AND "残高" >= 1000000 AND 
    "更新日" < TO_DATE('2024-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS');

--c.1.1.51
SELECT COUNT(*) - COUNT(更新日) AS データ件数 FROM 口座;

--c.1.1.52
SELECT MAX(名義), MIN(名義) FROM 口座;

--c.1.1.53
SELECT MAX(更新日), MIN(更新日) FROM 口座;

--c.1.1.54
SELECT SUM(残高) AS 合計, MAX(残高) AS 最大, MIN(残高) AS 最小, 
    AVG(残高) AS 平均, COUNT(残高) AS 登録データ件数 FROM 口座 GROUP BY "種別";

--c.1.1.55
SELECT SUBSTR(口座番号, -1, 1) AS 名義, COUNT(*) FROM 口座 
    GROUP BY SUBSTR(口座番号, -1, 1) ORDER BY COUNT(*) DESC;

--c.1.1.56
SELECT SUBSTR(COALESCE(TO_CHAR(更新日), 'XXXX年'), 1, 2) AS 更新年, 
    SUM(残高) AS 合計, MAX(残高) AS 最大, MIN(残高) AS 最小,  AVG(残高) AS 平均, 
        COUNT(残高) AS 登録データ件数 FROM 口座 GROUP BY SUBSTR(COALESCE(TO_CHAR(更新日), 'XXXX年'), 1, 2);

--c.1.1.57
SELECT SUM(残高) AS 合計, COUNT(*) AS 件数 FROM 口座 GROUP BY "種別" HAVING SUM(残高) >= 3000000;

--c.1.1.58
SELECT SUBSTR(REPLACE(名義, '　', ''), 1, 1) AS 名義, COUNT(*) AS 件数, 
    AVG(LENGTH(名義)) AS 名義文字数平均 FROM 口座 GROUP BY SUBSTR(REPLACE
        (名義, '　', ''), 1, 1) HAVING COUNT(*) >= 10 OR AVG(LENGTH(名義)) >= 5;

-----Chapter7-----

--c.1.1.59




SELECT * FROM PRODUCT;

--SELECT TABLE_NAME, COLUMN_NAME 
--FROM USER_CONS_COLUMNS 
--WHERE CONSTRAINT_NAME = 'SYS_C007433';
--
--SELECT * FROM 口座 WHERE 口座番号 = '0037651';

--INSERT INTO PRODUCT VALUES('001', 'りんご', 150);
--INSERT INTO 廃止口座 VALUES ('0051432', 'オダ　シンタロウ', 1, 41310, '2023-12-24');
--INSERT INTO 取引 VALUES (1, 9, '2022-01-05', '0051432', 0, 41310);
--INSERT INTO 取引事由 VALUES (9, 'その他');