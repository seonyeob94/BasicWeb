package kr.or.ddit.returnCa.vo;

public class ReturnVo {
	private String memberName;
	private String bookTitle;
	private String loanDate; 
	private String returnDate;
	private String dueDate;
	public String getMemberName() {
		return memberName;
	}
	
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}


	public String getLoanDate() {
		return loanDate;
	}


	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}


	public String getDueDate() {
		return dueDate;
	}


	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	
	
}
