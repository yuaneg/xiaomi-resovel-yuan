package xyz.talentboy.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.talentboy.common.util.ExcelUtils;
import xyz.talentboy.service.ICombineInfoService;

@Controller
public class AnalyzeController {

	private static final Logger logger = LoggerFactory.getLogger(AnalyzeController.class);

	@Autowired
	private ICombineInfoService combineInfoService;
	
	/**
	 * 查询并导出合并数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/combine")
	public ResponseEntity<byte[]> download() {
		List<Map<String, Object>> list = combineInfoService.queryAllCombine();
		ResponseEntity<byte[]> result = ExcelUtils.buildWorkBookDown("合并数据导出", "hebing", list);
		logger.info("combine数据导出结束");
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/age")
	public ResponseEntity<byte[]> downdloadAge() {
		//在service层进行组合
		List<Map<String, Object>> list = combineInfoService.groupByAgeAndDepartment();
		ResponseEntity<byte[]> result = ExcelUtils.buildWorkBookDown("根据年龄导出", "age", list);
		return result;
	}
	
	/**
	 * 根据年龄区分,每一个不同的年中男女的投资总额占比,不同分公司(外加所有的年的投资总和)
	 * @return
	 */
	@RequestMapping("/gender")
	public ResponseEntity<byte[]> downdloadGender() {
		logger.info("按照性别导出");
		List<Map<String, Object>> list =  combineInfoService.groupbyGenderAndDepartment();
		ResponseEntity<byte[]> result = ExcelUtils.buildWorkBookDown("根据性别导出", "gender", list);
		return result;
		
	}
	
}
