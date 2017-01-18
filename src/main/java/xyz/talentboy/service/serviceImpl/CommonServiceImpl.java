/**
 * 
 */
package xyz.talentboy.service.serviceImpl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.talentboy.common.constant.Province;
import xyz.talentboy.common.constant.Territory;
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
		// 对人的数据进行组合判断
		// 年龄 // 地域 // 城市 //
		List<Map<String, Object>> list = commonDao.combineSalesAndCustomer();
		for (Map<String, Object> map : list) {
			// 获取身份证号
			String cardNumber = null == map.get("card_number") ? "" : map.get("card_number").toString();
			if (cardNumber.length() < 18) {
				map.put("age", "无");
			} else {
				String birthday = cardNumber.substring(6, 10);
				Calendar ca = Calendar.getInstance();
				int year = ca.get(Calendar.YEAR);
				String age = (year - Integer.valueOf(birthday)) + "";
				map.put("age", age);
			}
			//城市分析 + 地域分析
			if (cardNumber.length() < 18) {
				map.put("province", "无");
				map.put("area", "无");
			} else {
				String f = cardNumber.substring(0,2);
				String province = Province.valueOf(Integer.valueOf(f));
				map.put("province", province);
				map.put("area", Territory.getTerritoryByProvince(province));
			}
			String buyTime = null == map.get("buy_time") ? "" : map.get("buy_time").toString().substring(0, 4);
			map.put("buy_year", buyTime);
		}
		return list;
	}

}
