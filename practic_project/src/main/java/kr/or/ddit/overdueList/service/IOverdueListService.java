package kr.or.ddit.overdueList.service;

import java.util.List;
import java.util.Map;

public interface IOverdueListService {

	public List<Map<String, Object>> selectBanUserMap();
	
	boolean sendWarning(int loanNo);
}
