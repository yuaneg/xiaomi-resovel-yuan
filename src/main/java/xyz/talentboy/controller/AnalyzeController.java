package xyz.talentboy.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.talentboy.service.ICommonService;

@Controller
public class AnalyzeController {

	private static final Logger logger = LoggerFactory.getLogger(AnalyzeController.class);

	@Autowired
	private ICommonService commonService;

	@RequestMapping("/combine")
	public String combineSalesAndCustomer(ModelAndView view) {
		logger.info("combine组合");
		List<Map<String, Object>> list = commonService.combineSalesAndCustomer();
		System.out.println(list.size());
		return "redirect:/";
	}
	
	
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download() throws IOException {
		String fileName=new String("合并数据.xlsx".getBytes("UTF-8"),"iso-8859-1");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		InputStream in = new DefaultResourceLoader().getResource("static/exceltemplate/hebing.xlsx").getInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(in);
		Sheet sheet = wb.getSheetAt(0);
		List<Map<String, Object>> list = commonService.combineSalesAndCustomer();
		for(int i = 1 ;i<list.size();i++ ){
			Row row = sheet.createRow(i);
			Map<String,Object> map = list.get(i-1);
			for(int j = 0;j<map.size();j++){
				Cell cell = row.createCell(j);
				//cell.setCellValue(map.get(""));
			}
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
		wb.write(out);
		return new ResponseEntity<byte[]>(out.toByteArray(), headers, HttpStatus.CREATED);
	}
	
}
