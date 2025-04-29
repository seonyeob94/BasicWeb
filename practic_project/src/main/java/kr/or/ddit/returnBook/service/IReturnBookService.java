package kr.or.ddit.returnBook.service;

import java.util.List;
import java.util.Map;

public interface IReturnBookService {
	
	public List<Map<String, Object>> returnListMap();
	
	public List<Map<String, Object>> selectReturnedList();
	
	public boolean returnLoan(int loanNo);

}
