package xyz.talentboy.common.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ExcelUtils {
	
	
	/**
	 * 根据模板肯和文件名创建文件
	 * @param name
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static XSSFWorkbook buildWorkBook(String resourceName,List<Map<String,Object>> list) throws Exception{
		InputStream in = new DefaultResourceLoader().getResource("static/exceltemplate/"+resourceName+".xlsx").getInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(in);
		Sheet sheet = wb.getSheetAt(0);
		for (int i = 1; i < list.size(); i++) {
			Row row = sheet.createRow(i);
			Map<String, Object> map = list.get(i - 1);
			int j = 0;
			for (String key : map.keySet()) {
				if (null == map.get(key)) {
					map.put(key, "");
				}
				String value = map.get(key).toString();
				Cell cell = row.createCell(j);
				cell.setCellValue(value);
				j++;
			}
		}
		return wb;
	}
	
	/**
	 * 构建下载用的 responseEntity
	 * @param name
	 * @param resourceName
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static ResponseEntity<byte[]> buildWorkBookDown(String name,String resourceName,List<Map<String,Object>> list) {		
		try {
			String fileName = new String((name+".xlsx").getBytes("UTF-8"), "iso-8859-1");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("attachment", fileName);
			XSSFWorkbook wb = buildWorkBook(resourceName, list);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			wb.write(out);
			ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(out.toByteArray(), headers, HttpStatus.CREATED);
			wb.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
