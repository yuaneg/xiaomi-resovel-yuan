package xyz.talentboy.service.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xyz.talentboy.dao.ICombineInfoDao;
import xyz.talentboy.service.ICombineInfoService;

@Service
public class CombineInfoServiceImpl implements ICombineInfoService {
	
	@Autowired
	private ICombineInfoDao combineInfoDao;
	
	
	@Override
	public void insertCombineInfo(List<Map<String, Object>> list) {
		for(Map<String,Object> map : list){
			StringBuilder sb = new StringBuilder();
			for(String key : map.keySet()){
				if(null == map.get(key)){
					map.put(key, "");
				}
				String value = map.get(key).toString();
				if(!value.startsWith("'")){
					value = "'"+value;
				}
				if(!value.endsWith("'") || value.length() == 1){
					value = value + "'";
				}
				if(StringUtils.isEmpty(value) || !StringUtils.hasText(value)){
					value = "''";
				}
				sb.append(value+",");
			}
			sb.deleteCharAt(sb.length() - 1);
			//执行插入操作
			combineInfoDao.insertCombineInfo(sb.toString());
		}
	}


	@Override
	public void deleteCombineInfo() {
		combineInfoDao.deleteCombineInfo();	
	}


	@Override
	public List<Map<String, Object>> queryAllCombine() {
		return combineInfoDao.queryAllCombine();
	}


	@Override
	public List<Map<String, Object>> groupByAgeAndDepartment() {
		List<Map<String, Object>> map10 = combineInfoDao.groupByAge(1, 19);
		List<Map<String, Object>> map20 = combineInfoDao.groupByAge(20, 29);
		List<Map<String, Object>> map30 = combineInfoDao.groupByAge(30, 39);
		List<Map<String, Object>> map40 = combineInfoDao.groupByAge(40, 49);
		List<Map<String, Object>> map50 = combineInfoDao.groupByAge(50, 59);
		List<Map<String, Object>> map60 = combineInfoDao.groupByAge(60, 69);
		List<Map<String, Object>> map70 = combineInfoDao.groupByAge(70, 79);
		List<Map<String, Object>> map80 = combineInfoDao.groupByAge(80, 110);
		//没有岁数的人(无身份证信息无法识别)
		List<Map<String, Object>> map00 = combineInfoDao.groupByAgeNone();
		List<Map<String, Object>> departments = combineInfoDao.getDepartment();
		//进入大循环
		List<Map<String, Object>> resMap = new ArrayList<>();
		Map<String, Object> map = null;
		for(Map<String, Object> m : departments){
			map = new LinkedHashMap<>();
			//放置部门
			Object department = m.get("department");
			map.put("department",department);
			//年龄 20 以下
			for(Map<String,Object> ageDe10 : map10){
				int i = 0;
				if(department.equals(ageDe10.get("department"))){
					i++;
					map.put("20岁以下人数", ageDe10.get("count"));
					map.put("20岁以总投资金额", ageDe10.get("amount"));
					break;
				}
				if(i == 0){
					map.put("20岁以下人数", "0");
					map.put("20岁以总投资金额", "0");
				}	
			}
			//年龄在20到29
			for(Map<String,Object> ageDe20 : map20){
				int i = 0;
				if(department.equals(ageDe20.get("department"))){
					i++;
					map.put("20-29岁人数", ageDe20.get("count"));
					map.put("20-29岁总投资金额", ageDe20.get("amount"));
					break;
				}
				if(i == 0){
					map.put("20-29岁人数", "0");
					map.put("20-29岁总投资金额", "0");
				}
			}
			//年龄在30到39
			for(Map<String,Object> ageDe30 : map30){
				int i = 0;
				if(department.equals(ageDe30.get("department"))){
					i++;
					map.put("30-39岁人数", ageDe30.get("count"));
					map.put("30-39岁总投资金额", ageDe30.get("amount"));
					break;
				}
				if(i == 0){
					map.put("30-39岁人数", "0");
					map.put("30-39岁总投资金额", "0");
				}
			}
			//年龄在40到49
			for(Map<String,Object> ageDe40 : map40){
				int i = 0;
				if(department.equals(ageDe40.get("department"))){
					i++;
					map.put("40-49岁人数", ageDe40.get("count"));
					map.put("40-49岁总投资金额", ageDe40.get("amount"));
					break;
				}
				if(i == 0){
					map.put("40-49岁人数", "0");
					map.put("40-49岁总投资金额", "0");
				}
				
			}
			//年龄在50到59
			for(Map<String,Object> ageDe50 : map50){
				int i = 0;
				if(department.equals(ageDe50.get("department"))){
					i++;
					map.put("50-59岁人数", ageDe50.get("count"));
					map.put("50-59岁总投资金额", ageDe50.get("amount"));
					break;
				}
				if(i == 0){
					map.put("50-59岁人数", "0");
					map.put("50-59岁总投资金额", "0");
				}
			}
			//年龄在60到69
			for(Map<String,Object> ageDe60 : map60){
				int i = 0;
				if(department.equals(ageDe60.get("department"))){
					i++;
					map.put("60-69岁人数", ageDe60.get("count"));
					map.put("60-69岁总投资金额", ageDe60.get("amount"));
					break;
				}
				if(i==0){
					map.put("60-69岁人数", "0");
					map.put("60-69岁总投资金额", "0");
				}
			}
			//年龄在70到79
			for(Map<String,Object> ageDe70 : map70){
				int i = 0;
				if(department.equals(ageDe70.get("department"))){
					i++;
					map.put("70-79岁人数", ageDe70.get("count"));
					map.put("70-79岁总投资金额", ageDe70.get("amount"));
					break;
				}
				if(i == 0){
					map.put("70-79岁人数", "0");
					map.put("70-79岁总投资金额", "0");
				}
			}
			//年龄在80以上
			for(Map<String,Object> ageDe80 : map80){
				int i = 0;
				if(department.equals(ageDe80.get("department"))){
					i++;
					map.put("80岁以上人数", ageDe80.get("count"));
					map.put("80岁以上总投资金额", ageDe80.get("amount"));
				}
				if(i == 0){
					map.put("80岁以上人数", "0");
					map.put("80岁以上总投资金额", "0");
				}
			}
			//年龄在80以上
			for(Map<String,Object> ageDe00 : map00){
				int i = 0;
				if(department.equals(ageDe00.get("department"))){
					i++;
					map.put("无岁数信息", ageDe00.get("count"));
					map.put("无岁数信息投资总额", ageDe00.get("amount"));
					break;
				}
				if(i == 0){
					map.put("无岁数信息", "0");
					map.put("无岁数信息投资总额", "0");
				}
			}
			resMap.add(map);
		}
		return resMap;
	}
	
}
