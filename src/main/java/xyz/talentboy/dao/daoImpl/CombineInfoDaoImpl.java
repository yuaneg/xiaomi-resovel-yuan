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

}
 