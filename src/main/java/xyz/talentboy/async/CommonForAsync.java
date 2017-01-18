package xyz.talentboy.async;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import xyz.talentboy.service.ICombineInfoService;

@Component
@Async
public class CommonForAsync {
	
	private static Logger logger = LoggerFactory.getLogger(CommonForAsync.class);
	
	@Autowired
	private ICombineInfoService combineInfoService;
	
	public void insertCombineInfo(List<Map<String,Object>> list){
		logger.info("执行异步插入数据combineInfo");
		combineInfoService.insertCombineInfo(list);
		logger.info("combineInfo数据插入结束");
	}

}
