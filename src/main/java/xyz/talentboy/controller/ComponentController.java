package xyz.talentboy.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import xyz.talentboy.service.ICustomerInfoService;
import xyz.talentboy.service.ISalesInfoService;

/**
 * @author yuaneg 2017年1月17日上午10:38:51
 *
 */
@Controller
public class ComponentController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(ComponentController.class);
	
	@Autowired
	private ISalesInfoService salesInfoService;
	
	@Autowired
	private ICustomerInfoService customerInfoService;
	
	/**
	 * 上传读取excel文件
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadfile")
	public ModelAndView upload(@RequestParam(value = "file") MultipartFile file ,ModelAndView view) throws Exception {
		view.setViewName("redirect:/");
		view.addObject("uploadValidate", "success");
		Workbook xwb = null;
		if(file.getOriginalFilename().endsWith("xlsx")){
			xwb = new XSSFWorkbook(file.getInputStream());
		} else if(file.getOriginalFilename().endsWith("xls")){
			xwb = new HSSFWorkbook(file.getInputStream());
		} else {
			view.addObject("uploadValidate", "error");
			return view;
		}
		Sheet sheet;
		Row row;
		String cell;
		// 获得sheet的个数
		//sheet-1(下标问题)  约束 奇数为订单打款  偶数为 自然人 (i为偶数 订单打款  奇数 自然人)
		int sheetNo = xwb.getNumberOfSheets();
		for (int i = 0; i < sheetNo; i++) {
			sheet = xwb.getSheetAt(i);
			// 循环读取内容
			//+1 不读取表头
			for (int j = sheet.getFirstRowNum()+1; j < sheet.getPhysicalNumberOfRows(); j++) {
				StringBuilder sb = new StringBuilder();
				row = sheet.getRow(j);
				//读取cell 的值并把它拼接成 sql 语句插入形式
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
				if(i % 2 == 0){
					// 订单导入
					salesInfoService.insertSalesInfo(sb.toString());
				} else {
					//自然人导入
					customerInfoService.insertCustomerInfo(sb.toString());
				}
			}
		}
		logger.info("导入结束");
		xwb.close();
		return view;
	}
	
	/**
	 * 删除所有数据
	 * @param view
	 * @return
	 */
	@RequestMapping("/delete")
	public ModelAndView deleteAllData(ModelAndView view){
		view.setViewName("redirect:/");
		view.addObject("uploadValidate", "success");
		salesInfoService.deleteSalesInfoAll();
		customerInfoService.deleteCustomerAll();
		return view;
	}
	
}
