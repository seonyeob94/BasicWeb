package kr.or.ddit.returnCa.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.returnCa.dao.IReturnDao;
import kr.or.ddit.returnCa.dao.ReturnDaoImpl;
import kr.or.ddit.returnCa.vo.ReturnVo;

public class ReturnServiceImpl implements IReturnService {
	
	private IReturnDao dao;
	
	private ReturnServiceImpl() {
		dao = ReturnDaoImpl.getDao();
	}
	
	private static IReturnService service;
	public static IReturnService getService() {
		if(service ==null) service = new ReturnServiceImpl();
		
		return service;
	}



	@Override
	public List<Map<String, Object>> returnListMap() {
		// TODO Auto-generated method stub
		return dao.returnListMap();
	}

}
