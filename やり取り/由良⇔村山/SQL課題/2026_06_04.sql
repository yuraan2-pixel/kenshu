--chapter2-1
--SELECT 口座番号,名義,種別,残高,更新日 From 口座;

--chapter2-2
--SELECT 口座番号 FROM 口座;

--chapter2-3
--SELECT 口座番号,残高 FROM 口座;

--chapter2-4
--SELECT * FROM 口座; 

--chapter2-5
--UPDATE 口座 SET 名義='X X X X X';

--chapter2-6
--UPDATE 口座 SET 残高='99999999',更新日='2024-03-01';

--chapter2-7
--INSERT INTO 口座 (口座番号,名義,種別,残高,更新日)VALUES ('0642191','アオキ　ハルカ','1','3640551','2024-03-13')
--INSERT INTO 口座 (口座番号,名義,種別,残高,更新日)VALUES ('1039410','キノシタ　リュウジ','1','259017','2023-11-30')
--INSERT INTO 口座 (口座番号,名義,種別,残高,更新日)VALUES ('1239855','タカシナ　ミツル','2','6509773','')

--chapter2-8
--DELETE from 口座;

--chapter3-9
--SELECT 口座番号 FROM 口座 WHERE 口座番号='0037651';
--truncate table 口座;

--chapter3-10
--SELECT 残高 FROM 口座 WHERE 残高>0;

--chapter3-11
--SELECT 口座番号 FROM 口座 WHERE 口座番号<'1000000';

--chapter3-12
--SELECT 更新日 FROM 口座 WHERE 更新日<'2023-01-01';

--chapter3-13
--SELECT 残高 FROM 口座 WHERE 残高>='1000000';

--chapter3-14
--SELECT 種別 FROM 口座 WHERE 種別!='1';

--chapter3-15
--SELECT 更新日 FROM 口座 WHERE 更新日 IS NULL;

--chapter3-16
--SELECT 名義 FROM 口座 WHERE 名義 LIKE '%ハシ%';

--chapter3-17
--SELECT 更新日 FROM 口座 WHERE 更新日 BETWEEN '24-01-01' AND '24-01-31';

--chapter3-18
--SELECT 種別 FROM 口座 WHERE 種別!=1;

--chapter3-19
--SELECT 名義 FROM 口座 WHERE 名義 = 'サカタ　リョウヘイ' OR 名義 = 'マツモト　ミワコ' OR 名義 = 'ハマダ　サトシ';

--chapter3-20
--SELECT 更新日 FROM 口座 WHERE '23-12-30'< 更新日 AND 更新日<'24-01-04';

--chapter3-21
--SELECT 残高,更新日 FROM 口座 WHERE 残高<'10000' AND 更新日 IS NOT NULL;

--chapter3-22
--SELECT 口座番号,名義 FROM 口座 WHERE (口座番号 BETWEEN '2000000' AND '2999999') OR (名義 LIKE 'エ__　%コ');

--chapter3-23
--口座番号、取引番号、取引事由ID
