package xyz.talentboy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.talentboy.dao.ISalesInfoDao;
import xyz.talentboy.service.ISalesInfoService;

@Service
public class SalesInfoServiceImpl implements ISalesInfoService {
	
	@Autowired
	private ISalesInfoDao salesInfoDao;
	
	@Override
	public void insertSalesInfo(String info) {
		salesInfoDao.insertSalesInfo(info);
	}

}
