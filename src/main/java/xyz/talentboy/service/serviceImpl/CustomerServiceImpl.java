/**
 * 
 */
package xyz.talentboy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.talentboy.dao.ICustomerInfoDao;
import xyz.talentboy.service.ICustomerInfoService;

/**
 * @author yuaneg 2017年1月17日上午11:25:03
 *
 */
@Service
public class CustomerServiceImpl implements ICustomerInfoService {
	
	@Autowired
	private ICustomerInfoDao customerInfoDao;
	
	@Override
	public void insertCustomerInfo(String info) {
		customerInfoDao.insertCustomerInfo(info);
	}

	@Override
	public void deleteCustomerAll() {
		customerInfoDao.deleteCustomerAll();
	}

}
