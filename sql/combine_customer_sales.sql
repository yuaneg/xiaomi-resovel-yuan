CREATE
OR REPLACE VIEW combine_customer_sales AS SELECT
	si.id,
	si.contract_no,
	si.ser_number,
	si.product_type,
	si.product,
	si.customer_type,
	si.customer_name,
	si.card_type,
	si.card_number,
	si.sales_status,
	si.sales_amount,
	si.income_type,
	si.buy_time,
	si.dead_time,
	si.bank_address,
	si.bank_user_name,
	si.bank_number,
	si.term,
	si.product_discount,
	si.performance,
	si.save_time,
	si.rate,
	si.income,
	si.income_amount,
	si.department,
	si.manager,
	si.principal,
	si.customer_cell_phone,
	si.retrun_number,
	si.return_time,
	si.retrun_result,
	si.info_rev,
	si.return_mark,
	ci.gender,
	ci.email,
	ci.wechat,
	ci.qq,
	ci.phone,
	ci.mobile_f,
	ci.mobile_s,
	ci.birth,
	ci.address,
	ci.marriage,
	ci.relationship_level,
	ci.risk_trend,
	ci.customer_property,
	ci.buy_amount,
	ci.add_time,
	ci.mark,
	ci.return_visit
FROM
	sales_info si
LEFT JOIN customer_info ci ON si.customer_name = ci.customer_name
AND ci.principal = si.principal
GROUP BY
	si.id