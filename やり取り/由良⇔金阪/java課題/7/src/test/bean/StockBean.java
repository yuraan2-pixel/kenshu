package test.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StockBean {
	private int code;
	private int amount;
	private Date history;
	private String information;
	private String day;
	
	final protected static SimpleDateFormat dateform = 
		new SimpleDateFormat("YYYY-MM-DD HH24:MI:SS");
	
	public StockBean() {}
	
	protected static String compileHist(Date history) {
		return dateform.format(history);
	}
		
	public int 	getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int 	getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getHistory() {
		return history;
	}
	public void setHistory(Date history) {
		this.history = history;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	
}
