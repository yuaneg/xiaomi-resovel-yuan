package xyz.talentboy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import xyz.talentboy.service.ICombineInfoService;
import xyz.talentboy.service.IComponentService;
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
	private IComponentService componentService;
	
	@Autowired
	private ISalesInfoService salesInfoService;
	
	@Autowired
	private ICustomerInfoService customerInfoService;
	
	@Autowired
	private ICombineInfoService combineInfoService;
	
	/**
	 * 上传读取excel文件
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadfile")
	@ResponseBody
	public boolean upload(@RequestParam(value = "file") MultipartFile file)  {
		boolean flag = false;
		try {
			flag = componentService.importExcelData(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("导入结束");
		return flag;
	}
	
	/**
	 * 删除所有数据
	 * @param view
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteAllData(){
		try {
			salesInfoService.deleteSalesInfoAll();
			customerInfoService.deleteCustomerAll();
			combineInfoService.deleteCombineInfo();
		} catch (Exception e) {
			e.printStackTrace();
			return "数据清空失败";
		}
		return "数据清空成功";
	}
	
}
