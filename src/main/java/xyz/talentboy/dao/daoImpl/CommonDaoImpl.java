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
		sb.append("select * from sales_info si");
		sb.append(" left join customer_info ci on si.customer_name= ci.customer_name");
		sb.append(" and ci.principal = si.principal");
		sb.append(" group by si.id");
		List<Map<String,Object>> result = jdbcTemplate.queryForList(sb.toString());
		return result;
	}
	
	
}
