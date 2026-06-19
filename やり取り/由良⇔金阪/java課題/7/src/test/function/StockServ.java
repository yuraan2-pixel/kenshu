package test.function;

import java.text.ParseException;
import java.util.Date;

import test.bean.StockBean;

public class StockServ extends StockBean {
	static StockBean sb = new StockBean();
	
	public StockServ(String info) throws ParseException {
		setBean(info);
	}
	
	public StockServ(int code, int amount, Date history) {
		seter(code, amount, history);
	}
	
	public StockServ() {}
	
	@Override
	public String toString() {
		return sb.getInformation();
	}
	
	static void seter(int code, int amount, Date history) {
		sb.setCode(code);
		sb.setAmount(amount);
		sb.setHistory(history);
		sb.setInformation(compileInfo(code, amount, history));
	}

	static void setBean(String info) throws ParseException {
		String[] word = info.split(",");
		int code = Integer.parseInt(word[0]);
		int amount = Integer.parseInt(word[1]);
		Date history = dateform.parse(word[2]);
		seter(code, amount, history);
	}
	
	static String compileInfo(int code, int amount, Date history) {
		String form = "%03d,%d,%s";	// koko
		return String.format(form, code, amount, history);
	}
	
	static Date compileDay(String day) throws ParseException {
		String[] word = day.split("[.,/-| 年月日]");
		String form = "%s/%s/%s 00:00:00";
		String year = parse(word[0]);
		String history = String.format(form, year, word[1], word[2]);
		return dateform.parse(history);
	}
	
	static String parse(String word) {
		String[] num = word.split("");
		String sei = num[0] + num[1];
		if(num.length == 2) {
			return "20" + sei;
		}
		String nen = num[2] + num[3];
		int year = Integer.parseInt(nen);
		switch(sei) {
			case "令和" -> {year+=2018;}
			case "平成" -> {year+=1988;}
			case "昭和" -> {year+=1925;}
			case "20", "19"-> {return sei + nen;}
			default -> {year = 2000;}
		}
		return String.format("%d", year);
	}
	
	
}
