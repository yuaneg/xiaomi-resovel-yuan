/**
 * 
 */
package xyz.talentboy.service.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.talentboy.dao.ICommonDao;
import xyz.talentboy.service.ICommonService;

/**
 * @author yuaneg 2017年1月17日下午5:52:50
 *
 */
@Service
public class CommonServiceImpl implements ICommonService {
	
	@Autowired
	private ICommonDao commonDao;
	
	@Override
	public List<Map<String, Object>> combineSalesAndCustomer() {
		return commonDao.combineSalesAndCustomer();
	}

}
