package xyz.talentboy.service;

import java.util.List;
import java.util.Map;

public interface ICombineInfoService {
	
	public void insertCombineInfo(List<Map<String,Object>> list);
	
	
	public void deleteCombineInfo();
	
	public List<Map<String,Object>> queryAllCombine();
	
	public List<Map<String,Object>> groupByAgeAndDepartment();
	
	public List<Map<String, Object>> groupbyGenderAndDepartment();
}
