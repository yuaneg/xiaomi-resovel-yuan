package xyz.talentboy.service;

import org.springframework.web.multipart.MultipartFile;

public interface IComponentService {
	
	/**
	 * 导入excel 数据
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public boolean importExcelData(MultipartFile file) throws Exception ;
	
}
