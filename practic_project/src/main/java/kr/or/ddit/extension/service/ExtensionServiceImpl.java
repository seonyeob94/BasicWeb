package kr.or.ddit.extension.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.extension.dao.ExtensionDaoImpl;
import kr.or.ddit.extension.dao.IExtensionDao;
import kr.or.ddit.vo.BookLoanApprovalVo;

public class ExtensionServiceImpl implements IExtensionService {

	//dao 객체 필요
	private IExtensionDao dao;
	
	private ExtensionServiceImpl() {
		dao = ExtensionDaoImpl.getDao();
	}
	
	//자신의 객체 생성 리턴
	private static IExtensionService service;
	public static IExtensionService getIExtensionService() {
		if( service == null) service = new ExtensionServiceImpl();
		
		return service;
	}
 	
	@Override
	public List<Map<String, Object>> extentionListMap() {
		// TODO Auto-generated method stub
		return dao.extentionListMap();
	}

	@Override
	public boolean approveExtension(BookLoanApprovalVo vo) {
			
			int up1 = dao.approveLoanExtension(vo);
			int up2 = dao.extendDueDate(vo);

		return up1>0&&up2>0;
	}

	@Override
	public int rejectLoanExtension(BookLoanApprovalVo vo) {
		// TODO Auto-generated method stub
		return dao.rejectLoanExtension(vo);
	}

}
