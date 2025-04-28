package kr.or.ddit.overdueList.dao;

import java.util.List;
import java.util.Map;

public interface IOverdueListDao {
	
	public List<Map<String, Object>> selectBanUserMap();
	
	Map<String,Object> selectLoanContact(int loanNo);
	
	int insertWarningHistory(int loanNo);
}