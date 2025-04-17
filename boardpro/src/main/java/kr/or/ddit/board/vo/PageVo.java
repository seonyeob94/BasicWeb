package kr.or.ddit.board.vo;

public class PageVo {
	private int start;
	private int end;
	
	private int startPage;
	private int endPage;
	private int totalPage;
	
	private static int perList =3; //한페이지에 출력되는 글 갯수
	private static int perPage =2; //한화면에 보이는 페이지 갯수
	
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public static int getPerList() {
		return perList;
	}
	public static void setPerList(int perList) {
		PageVo.perList = perList;
	}
	public static int getPerPage() {
		return perPage;
	}
	public static void setPerPage(int perPage) {
		PageVo.perPage = perPage;
	}


	
}
