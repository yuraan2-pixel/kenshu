package test.function.Before;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import test.bean.ProductBean;
import test.bean.ReProduct;

//	2026年5月28日	作成
//	2026年6月4日	追記
//	2026年6月9日	追加及びコメント完了	追加しない(これ以上はややこしい)
public class SQLManager {
	static String SELECT = "SELECT * FROM PRODUCT";
	static String INSERT = "INSERT INTO PRODUCT VALUES( ?, ?, ?)";	
	static String UPDATE = "UPDATE PRODUCT SET 商品名 = ?, 単価 = ? WHERE 商品コード = ?";
	static String DELETE = "DELETE FROM PRODUCT WHERE 商品コード = ?";
	
	static boolean done = true;
	
	/**
	 * すること：SQL文を作動させる	<P>
	 * 1、con情報と SQL文を受け取る	<P>
	 * 2、Statment.executeQueryを起動、SQL文を代入	<P>
	 * 3、ResaltSetを返す
	 * @param con	接続情報
	 * @param SQL	作動させるSQL文
	 * @return	ResultSet	動作結果
	 * @throws SQLException	Conが違う、接続先が見つからない場合エラー
	 */
	public static ResultSet getConection(Connection con, String SQL) throws SQLException {
		try {
			Statement sta = con.createStatement();
			ResultSet res = sta.executeQuery(SQL);
			return res;
			
		} catch (SQLException e) {
			System.out.println("SQLへの接続が失敗しました。");
			return null;
		}
	}
	
	/**
	 * すること：SQLのPRODUCTからデータを抜き出してListに代入	<P>
	 * 1、this.getConectionにSQL(SELECT * FROM PRODUCT)を代入	<P>
	 * 2、帰ってきたデータをListに代入	<P>
	 * @param con	接続情報
	 * @param al	格納するList
	 * @throws SQLException	Conが違う、接続先が見つからない場合エラー
	 */
	public static void selectALProBe(Connection con, ArrayList<ProductBean> al) throws SQLException {
		ResultSet res = getConection(con, SELECT);
		while(res.next()) al.add(new ProductBean(information(res)));
	}
	
	/**
	 * すること：SQLのPRODUCTからデータを抜き出してSetに代入	<P>
	 * 1、this.getConectionにSQL(SELECT * FROM PRODUCT)を代入	<P>
	 * 2、帰ってきたデータをSetに代入	<P>
	 * @param con	接続情報
	 * @param set	格納するSet
	 * @throws SQLException	Conが違う、接続先が見つからない場合エラー
	 */
	public static void selectSProBe(Connection con, Set<String> set) throws SQLException {
		ResultSet res = SQLManager.getConection(con, SELECT);
		while(res.next()) set.add(information(res));
	}
	
	/**
	 * すること：受け取ったSetとListを比較してSetにだけ格納されたデータをPRODUCTに追加
	 * 1、con.prepareStatementにSQL(INSERT INTO PRODUCT VALUES( ?, ?, ?))を代入
	 * 2、ListとSetのcodeを比較、双方に入っていた場合falseを返す
	 * 3、trueの場合、SQLを実行、データを格納する
	 * @param con	接続情報
	 * @param set	保存用Set
	 * @param al	比較用List	これメソッド内で作ってもよかった、もう使わんし変えもせんけど
	 * @throws SQLException	Conが違う、接続先が見つからない場合エラー
	 */
	public static void insertProBe(Connection con, Set<String> set, ArrayList<ProductBean> al) throws SQLException {
		for(String word : set) {
			ProductBean pb = new ProductBean(word);
			PreparedStatement ps = con.prepareStatement(INSERT);
			
			for(ProductBean alpb : al) {
				if(pb.getCode() == alpb.getCode()) {
					done = false;
					break;
				}
			}
			if(done) {
				setUp(ps, pb);
			}
		}
	}
	
	/**
	 * すること：受け取ったListと元々入ってたデータを比較して新しいデータなら登録、同じコードなら更新
	 * @param con	接続情報
	 * @param al	入力分含む全データ
	 * @throws SQLException	Conが違う、接続先が見つからない場合エラー
	 */
	public static void updateProBe(Connection con, ArrayList<ProductBean> al) throws SQLException {
		ArrayList<ProductBean> former = new ArrayList<>();
		SQLManager.selectALProBe(con, former);
		
		for(ProductBean pb : al) {
			PreparedStatement inps = con.prepareStatement(INSERT);
			PreparedStatement udps = con.prepareStatement(UPDATE);
			
			for(ProductBean alpb : former) {
				if(pb.getCode() == alpb.getCode()) {
					done = false;
					break;
				}
			}
			if(done) {
				setUp(inps, pb);
			} else {
				setUp(udps, pb);
			}
		}
	}
	
	/**
	 * すること：コード入力を受付、一致したものがあれば消去
	 * @param con	接続情報
	 * @param al	消去するList	よく考えたらここで完結できるわ呼び出しても問題ないけども
	 * @throws SQLException	Conが違う、接続先が見つからない場合エラー
	 */
	public static void deleteProBe(Connection con, ArrayList<ProductBean> al) throws SQLException {
		ArrayList<ProductBean> del = new ArrayList<>();
		boolean beg = false;
		int code = 0;
		
		while(true) {
			code = MondaiFunction.input("削除する商品コード");
			if(code == 999) {
				System.out.println("入力終了\n");
				break;
			}
			for(ProductBean pb : al) {
				if(code == pb.getCode()) {
					del.add(pb);
					beg = true;
					break;
				}
			}
			if(!beg) {
				System.out.println("指定された商品コードは存在しません。");
			}
		}
		PreparedStatement ps = con.prepareStatement(DELETE);
		for(int i = 0; i < del.size(); i++) {
			ps.setInt(1, del.get(i).getCode());
			ps.executeUpdate();
		}
	}
	
	/**
	 * 受け取ったSQL文に値を代入して更新
	 * @param ps	処理情報	UPDATE、INSERTのみ
	 * @param pb	登録する情報
	 * @throws SQLException	Conが違う、接続先が見つからない、関係ないSQL文の入力の場合エラー
	 */
	static void setUp(PreparedStatement ps, ProductBean pb) throws SQLException {
		for (int i = 0; i < 3; i++) {
			ps.setString(1, pb.getCode(""));
			ps.setString(2, pb.getName());
			ps.setInt(3, pb.getPrice());
		}
		ps.executeUpdate();
	}
	
//	---|---|---|---|--- ReProduct用 ---|---|---|---|---
	
	/**
	 * SELECT文の値を代入して返却
	 * @param res	SQL文入りの動作データ(SELECT)
	 * @return	String	,区切りの商品情報
	 * @throws SQLException	Conが違う、接続先が見つからない、関係ないSQL文の場合エラー
	 */
	static String information(ResultSet res) throws SQLException {
		return res.getInt("商品コード") + "," + res.getString("商品名") + "," + res.getInt("単価");
	}
	
	/**
	 * 受け取ったSQL文に値を代入して更新	list
	 * @param ps	処理情報	INSERTのみ
	 * @param list	登録する情報
	 * @throws SQLException	Conが違う、接続先が見つからない、関係ないSQL文の入力の場合エラー
	 */
	static void setIn(PreparedStatement ps, ArrayList<ReProduct> list) throws SQLException {
		for(ReProduct rp : list) {
			ps.setString(1, rp.getCode(""));
			ps.setString(2, rp.getName());
			ps.setInt(3, rp.getPrice());
			ps.executeUpdate();
		}
	}
	
	/**
	 * 受け取ったSQL文に値を代入して更新	list
	 * @param ps	処理情報	UPDATEのみ
	 * @param list	登録する情報
	 * @throws SQLException	Conが違う、接続先が見つからない、関係ないSQL文の入力の場合エラー
	 */
	static void setUp(PreparedStatement ps, ArrayList<ReProduct> list) throws SQLException {
		for(ReProduct rp : list) {
			ps.setString(1, rp.getName());
			ps.setInt	(2, rp.getPrice());
			ps.setString(3, rp.getCode(""));
			ps.executeUpdate();
		}
	}
	
	/**
	 * 受け取ったSQL文に値を代入して更新	RePro
	 * @param ps	処理情報	INSERTのみ
	 * @param rp	登録する情報
	 * @throws SQLException	Conが違う、接続先が見つからない、関係ないSQL文の入力の場合エラー
	 */
	static void setIn(PreparedStatement ps, ReProduct rp) throws SQLException {
		ps.setString(1, rp.getCode(""));
		ps.setString(2, rp.getName());
		ps.setInt	(3, rp.getPrice());
		ps.executeUpdate();
	}
	/**
	 * 受け取ったSQL文に値を代入して更新	RePro
	 * @param ps	処理情報	UPDATEのみ
	 * @param rp	登録する情報
	 * @throws SQLException	Conが違う、接続先が見つからない、関係ないSQL文の入力の場合エラー
	 */
	static void setUp(PreparedStatement ps, ReProduct rp) throws SQLException {
		ps.setString(1, rp.getName());
		ps.setInt	(2, rp.getPrice());
		ps.setString(3, rp.getCode(""));
		ps.executeUpdate();
	}
	
	/**
	 * すること：SQLのPRODUCTからデータを抜き出してListに代入	<P>
	 * 1、this.getConectionにSQL(SELECT * FROM PRODUCT)を代入	<P>
	 * 2、帰ってきたデータをListに代入	<P>
	 * @param con	接続情報
	 * @param al	格納するList
	 * @throws SQLException	Conが違う、接続先が見つからない場合エラー
	 */
	public static void selectALRePro(Connection con, ArrayList<ReProduct> al) throws SQLException {
		ResultSet res = SQLManager.getConection(con, SELECT);
		while(res.next()) al.add(new ReProduct(information(res)));
	}
	
	/**
	 * すること：SQLのPRODUCTからデータを抜き出してSetに代入	<P>
	 * 1、this.getConectionにSQL(SELECT * FROM PRODUCT)を代入	<P>
	 * 2、帰ってきたデータをSetに代入	<P>
	 * @param 接続情報
	 * @param set	格納するSet
	 * @throws SQLException	Conが違う、接続先が見つからない場合エラー
	 */
	public static void selectSRePro(Connection con, Set<String> set) throws SQLException {
		ResultSet res = SQLManager.getConection(con, SELECT);
		while(res.next()) set.add(information(res));
	}
	
	/**
	 * すること：入力の受付後、更新分を反映
	 * <p>	1、con.prepareStatementにSQL(INSERT INTO PRODUCT VALUES( ?, ?, ?))を代入
	 * <p>	2、ループして入力の受付、同コードは弾いて新規コードのみSet
	 * <p>	3、SetしたものをSQL文に代入して実行更新
	 * @param con	接続情報
	 * @param list	既存の判定
	 * @throws SQLException	Conが違う、接続先が見つからない、関係ないSQL文の場合エラー
	 */
	public static void insertRePro(Connection con, ArrayList<ReProduct> list) throws SQLException {
		ArrayList<ReProduct> rpal = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement(INSERT);
		rpal = BeforeInput.setUpLoop(list);
		setIn(ps, rpal);
	}
	
	/**
	 * すること：入力の受付後、更新分を反映	
	 * <p>	1、	con.prepareStatementにSQL(INSERT INTO PRODUCT VALUES( ?, ?, ?))を代入
	 * <p>		con.prepareStatementにSQL(UPDATE PRODUCT SET 商品名 = ?, 単価 = ? WHERE 商品コード = ?)を代入
	 * <p>	2、商品情報の入力受付、更新登録可
	 * <p>	3、変更部分のみ取り出して、同コードがある場合UPDATE、無ければINSERT
	 * @param con	接続情報
	 * @param list	格納するList
	 * @throws SQLException	Conが違う、接続先が見つからない場合エラー
	 */
	
	public static void updateRePro(Connection con, ArrayList<ReProduct> list) throws SQLException {
		Set<Integer> codes = new TreeSet<>();
		ArrayList<ReProduct> befo = new ArrayList<>();
		selectALRePro(con, befo);
		PreparedStatement inps = con.prepareStatement(INSERT);
		PreparedStatement upps = con.prepareStatement(UPDATE);
		codes = BeforeInput.dataLoop(list);

		for(int i : codes) {
			if(BeforeInput.distinction(befo, i)) {
				setUp(upps, list.get(BeforeInput.counter(befo, i)));
			} else setIn(inps, list.get(BeforeInput.counter(list, i)));
		}
	}
	
	/**
	 * すること：入力の受付後、指定コードを消去
	 * <p>	1、con.prepareStatementにSQL(DELETE FROM PRODUCT WHERE 商品コード = ?)を代入
	 * <p>	2、入力を受付、コードの有無を判定
	 * <p>	3、存在していればSQL文実行、無ければエラー文実行
	 * @param con	接続情報
	 * @param list	既存の判定
	 * @throws SQLException	Conが違う、接続先が見つからない、関係ないSQL文の場合エラー
	 */
	public static void deleteRePro(Connection con, ArrayList<ReProduct> list) throws SQLException {
		PreparedStatement ps = con.prepareStatement(DELETE);
		int code = BeforeInput.digit("消去コード", 3);
		if(BeforeInput.distinction(list, code)) {
			ps.setInt(1, code);
			ps.executeUpdate();
		} else System.out.println(code + "は存在しないコードです。");
	}
	
}
