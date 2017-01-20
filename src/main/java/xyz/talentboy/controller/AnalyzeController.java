package xyz.talentboy.controller;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.talentboy.async.CommonForAsync;
import xyz.talentboy.common.util.ExcelUtils;
import xyz.talentboy.service.ICombineInfoService;
import xyz.talentboy.service.ICommonService;

@Controller
public class AnalyzeController {

	private static final Logger logger = LoggerFactory.getLogger(AnalyzeController.class);

	@Autowired
	private ICommonService commonService;
	
	@Autowired
	private CommonForAsync commonForAsync;
	
	@Autowired
	private ICombineInfoService combineInfoService;
	
	/**
	 * 查询并导出合并数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/combine")
	public ResponseEntity<byte[]> download() throws Exception {
		List<Map<String, Object>> list = combineInfoService.queryAllCombine();
		if(list.size() > 0){
			logger.info("数据已经存在");
			return ExcelUtils.buildWorkBookDown("合并数据导出", "hebing", list);
		}
		logger.info("combine数据导出开始");
		list = commonService.combineSalesAndCustomer();
		logger.info("插入数据开始");
		//异步操作中间表 避免前台等待时间过长
		commonForAsync.insertCombineInfo(list);
		ResponseEntity<byte[]> result = ExcelUtils.buildWorkBookDown("合并数据导出", "hebing", list);
		logger.info("combine数据导出结束");
		return result;
	}
	
	@RequestMapping("/age")
	public ResponseEntity<byte[]> downdloadAge() throws Exception{
		//在service层进行组合
		List<Map<String, Object>> list = combineInfoService.groupByAgeAndDepartment();
		ResponseEntity<byte[]> result = ExcelUtils.buildWorkBookDown("根据年龄导出", "age", list);
		return result;
	}
	
}
