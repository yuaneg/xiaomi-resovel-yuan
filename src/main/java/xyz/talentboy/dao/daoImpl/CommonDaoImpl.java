/**
 * 
 */
package xyz.talentboy.dao.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import xyz.talentboy.dao.ICommonDao;

/**
 * @author yuaneg 2017年1月17日下午12:38:23
 *
 */
@Repository
public class CommonDaoImpl implements ICommonDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//B表有重复数据怎么处理?
	@Override
	public List<Map<String, Object>> combineSalesAndCustomer() {
		StringBuilder sb = new StringBuilder();
		sb.append(" select si.contract_no,si.ser_number,si.product_type,si.product,");
		sb.append(" si.customer_type,si.customer_name,ci.card_type,ci.card_number,si.sales_status,");
		sb.append(" si.sales_amount,si.income_type,si.buy_time,si.dead_time,si.bank_address,");
		sb.append(" si.bank_user_name,si.bank_number,si.term,si.product_discount,si.performance,");
		sb.append(" si.save_time,si.rate,si.income,si.income_amount,si.department,si.manager,");
		sb.append(" si.principal,si.customer_cell_phone,si.retrun_number,si.return_time,si.retrun_result,");
		sb.append(" si.info_rev,si.return_mark,");
		sb.append(" ci.gender,ci.email,ci.wechat,ci.qq,ci.phone,ci.mobile_f,ci.mobile_s,ci.birth,ci.address,");
		sb.append(" ci.marriage,ci.relationship_level,ci.risk_trend,ci.customer_property,ci.buy_amount,");
		sb.append(" ci.add_time,ci.mark,ci.return_visit");
		sb.append(" from sales_info si left join customer_info ci on si.customer_name = ci.customer_name");
		sb.append(" and ci.principal = si.principal group by si.id");
		List<Map<String,Object>> result = jdbcTemplate.queryForList(sb.toString());
		return result;
	}
	
	
}
