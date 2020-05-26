package Research_Project;

public class Bid_Ask {
	private int date;
	private double seconds, bid, ask;
	public Bid_Ask(int date, double seconds, double bid, double ask) {
		this.date = date;
		this.seconds = seconds;
		this.bid = bid;
		this.ask = ask;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public double getSeconds() {
		return seconds;
	}
	public void setSeconds(double seconds) {
		this.seconds = seconds;
	}
	public double getBid() {
		return bid;
	}
	public void setBid(double bid) {
		this.bid = bid;
	}
	public double getAsk() {
		return ask;
	}
	public void setAsk(double ask) {
		this.ask = ask;
	}
	
}
