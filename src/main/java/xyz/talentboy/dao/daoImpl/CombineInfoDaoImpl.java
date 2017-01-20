package xyz.talentboy.dao.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import xyz.talentboy.dao.ICombineInfoDao;
@Repository
public class CombineInfoDaoImpl implements ICombineInfoDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertCombineInfo(String info) {
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO `combine_info` (`contract_no`, `ser_number`, `product_type`, `product`, ");
		sb.append(" `customer_type`, `customer_name`, `card_type`, `card_number`, `sales_status`,");
		sb.append(" `sales_amount`,`income_type`,`buy_time`,`dead_time`,`bank_address`,`bank_user_name`,");
		sb.append(" `bank_number`,`term`,`product_discount`,`performance`,`save_time`,`rate`,`income`,");
		sb.append(" `income_amount`,`department`,`manager`,`principal`,`customer_cell_phone`,`retrun_number`,");
		sb.append(" `return_time`,`retrun_result`,`info_rev`,`return_mark`,`gender`,`email`,`wechat`,`qq`,`phone`,");
		sb.append(" `mobile_f`,`mobile_s`,`birth`,`address`,`marriage`,`relationship_level`,`risk_trend`,");
		sb.append(" `customer_property`,`buy_amount`,`add_time`,`mark`,`return_visit`,`age`,`province`,`area`,`buy_year`)");
		sb.append(" values (");
		sb.append(info);
		sb.append(")");
		jdbcTemplate.execute(sb.toString());
	}

	@Override
	public void deleteCombineInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("delete from combine_info");
		jdbcTemplate.execute(sb.toString());
	}

	@Override
	public List<Map<String, Object>> queryAllCombine() {
		String sql = "select * from combine_info";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> groupByAge(int start, int end) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select a.department, a.count, b.amount from");
		sb.append(" (select count(*) as count, a.department from");
		sb.append(" (select count(*), department from `combine_info` where age");
		sb.append(" between ? and ? group by card_number ) a group by a.department ) a");
		sb.append(" left join (select sum(sales_amount) as amount, department from combine_info");
		sb.append(" where age between ? and ? group by department ) b on a.department = b.department");
		return jdbcTemplate.queryForList(sb.toString(), start, end, start, end);
	}

	@Override
	public List<Map<String, Object>> getDepartment() {
		String sql = "select department from combine_info group by department order by department";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> groupByAgeNone() {
		StringBuffer sb = new StringBuffer();
		sb.append(" select a.department, a.count, b.amount from");
		sb.append(" (select count(*) as count, a.department from");
		sb.append(" (select count(*), department from `combine_info` where age");
		sb.append(" =-1 group by card_number ) a group by a.department ) a");
		sb.append(" left join (select sum(sales_amount) as amount, department from combine_info");
		sb.append(" where age = -1 group by department ) b on a.department = b.department");
		return jdbcTemplate.queryForList(sb.toString());
	}
	
	
	
}
 