/**
 * 
 */
package xyz.talentboy.dao.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import xyz.talentboy.dao.ICustomerInfoDao;

/**
 * @author yuaneg 2017年1月17日上午11:18:00
 *
 */
@Repository
public class CustomerInfoDaoImpl implements ICustomerInfoDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertCustomerInfo(String info) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into `customer_info` (`customer_name`, `card_type`, `card_number`, `gender`, ");
		sb.append("`email`, `wechat`, `qq`, `phone`, `mobile_f`, `mobile_s`, `birth`, `address`,");
		sb.append("`marriage`, `relationship_level`, `risk_trend`, `principal`, `customer_property`, ");
		sb.append("`buy_amount`, `add_time`, `mark`, `department`, `return_visit`) values ");
		sb.append("(");
		sb.append(info);
		sb.append(")");
		jdbcTemplate.execute(sb.toString());
	}

	@Override
	public void deleteCustomerAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("delete from customer_info");
		jdbcTemplate.execute(sb.toString());
	}

}
