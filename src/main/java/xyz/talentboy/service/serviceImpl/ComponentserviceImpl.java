/**
 * 
 */
package xyz.talentboy.service.serviceImpl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import xyz.talentboy.service.IComponentService;
import xyz.talentboy.service.ICustomerInfoService;
import xyz.talentboy.service.ISalesInfoService;

/**
 * @author yuaneg 2017年1月18日上午9:55:06
 *
 */
@Service
public class ComponentserviceImpl implements IComponentService {
	
	@Autowired
	private ISalesInfoService salesInfoService;
	
	@Autowired
	private ICustomerInfoService customerInfoService;
	

	@Override
	public boolean importExcelData(MultipartFile file) throws Exception {
		Workbook xwb = null;
		if(file.getOriginalFilename().endsWith("xlsx")){
			xwb = new XSSFWorkbook(file.getInputStream());
		} else if(file.getOriginalFilename().endsWith("xls")){
			xwb = new HSSFWorkbook(file.getInputStream());
		} else {
			return false;
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
		xwb.close();
		return true;
	}
	

}
