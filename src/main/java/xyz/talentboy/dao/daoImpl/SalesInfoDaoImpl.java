package xyz.talentboy.dao.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import xyz.talentboy.dao.ISalesInfoDao;

@Repository
public class SalesInfoDaoImpl implements ISalesInfoDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertSalesInfo(String info) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO `sales_info` ( `contract_no`, `ser_number`, `product_type`, `product`, `customer_type`, `customer_name`, ");
		sb.append("`card_type`, `card_number`, `sales_status`, `sales_amount`, `income_type`, `buy_time`, `dead_time`, `bank_address`, ");
		sb.append("`bank_user_name`, `bank_number`, `term`, `product_discount`, `performance`, `save_time`, `rate`, `income`, `income_amount`,");
		sb.append("`department`, `manager`, `responsible`, `customer_cell_phone`, `retrun_number`, `return_time`, `retrun_result`, `info_rev`, `return_mark`) VALUES ");
		sb.append("(");
		sb.append(info);
		sb.append(")");
		System.out.println(sb.toString());
		jdbcTemplate.execute(sb.toString());
	}

}
