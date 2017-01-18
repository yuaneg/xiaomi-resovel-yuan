package xyz.talentboy.service.serviceImpl;

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
	
}
