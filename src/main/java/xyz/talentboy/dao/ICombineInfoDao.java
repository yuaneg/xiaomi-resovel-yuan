package xyz.talentboy.dao;

import java.util.List;
import java.util.Map;

public interface ICombineInfoDao {
	
	public void insertCombineInfo(String info);
	
	public void deleteCombineInfo();
	
	public List<Map<String,Object>> queryAllCombine();
	
	public List<Map<String,Object>> groupByAge(int start,int end);
	
	public List<Map<String,Object>> getDepartment();
	
	public List<Map<String,Object>> groupByAgeNone();
}
