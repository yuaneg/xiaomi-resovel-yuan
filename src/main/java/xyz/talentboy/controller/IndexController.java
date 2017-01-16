package xyz.talentboy.controller;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import xyz.talentboy.service.ISalesInfoService;

@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private ISalesInfoService salesInfoService;
	
	@RequestMapping("/")
	public String indexCon() {
		logger.info("访问时间" + new Date());
		return "home";
	}

	@RequestMapping("/uploadfile")
	public String upload(@RequestParam(value = "file") MultipartFile file) throws Exception {
		Workbook xwb = new HSSFWorkbook(file.getInputStream());
		Sheet sheet;
		Row row;
		String cell;
		// 获得sheet的个数
		int sheetNo = xwb.getNumberOfSheets();
		for (int i = 0; i < sheetNo; i++) {
			sheet = xwb.getSheetAt(i);
			// 循环读取内容
			//+1 不读取表头
			for (int j = sheet.getFirstRowNum()+1; j < sheet.getPhysicalNumberOfRows(); j++) {
				StringBuilder sb = new StringBuilder();
				row = sheet.getRow(j);
				for (int k = row.getFirstCellNum(); k < row.getPhysicalNumberOfCells(); k++) {
					cell = row.getCell(k).toString().trim();
					if(!cell.startsWith("'")){
						cell = "'"+cell;
					}
					if(!cell.endsWith("'") || cell.length() == 1){
						cell = cell + "'";
					}
					if(StringUtils.isEmpty(cell) || !StringUtils.hasText(cell)){
						cell = "''";
					}
					sb.append(cell+",");	
				}
				sb.deleteCharAt(sb.length() - 1);
				salesInfoService.insertSalesInfo(sb.toString());
			}
		}
		return "home";
	}
}
