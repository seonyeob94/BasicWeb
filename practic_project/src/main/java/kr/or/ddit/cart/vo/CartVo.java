package kr.or.ddit.cart.vo;

public class CartVo {
	private String monthNo;
	private int totalLoans;
	private int totalReturns;
	private int notReturned;
	private int onTimeReturns;
	private int overdueReturns;
	public String getMonthNo() {
		return monthNo;
	}
	public void setMonthNo(String monthNo) {
		this.monthNo = monthNo;
	}
	public int getTotalLoans() {
		return totalLoans;
	}
	public void setTotalLoans(int totalLoans) {
		this.totalLoans = totalLoans;
	}
	public int getTotalReturns() {
		return totalReturns;
	}
	public void setTotalReturns(int totalReturns) {
		this.totalReturns = totalReturns;
	}
	public int getNotReturned() {
		return notReturned;
	}
	public void setNotReturned(int notReturned) {
		this.notReturned = notReturned;
	}
	public int getOnTimeReturns() {
		return onTimeReturns;
	}
	public void setOnTimeReturns(int onTimeReturns) {
		this.onTimeReturns = onTimeReturns;
	}
	public int getOverdueReturns() {
		return overdueReturns;
	}
	public void setOverdueReturns(int overdueReturns) {
		this.overdueReturns = overdueReturns;
	}
	
	
	
	
	
}
