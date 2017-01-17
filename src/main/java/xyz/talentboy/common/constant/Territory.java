package xyz.talentboy.common.constant;

/**
 * @author yuaneg 2017年1月17日上午10:38:51
 *
 */
public enum Territory {
	
	华北地区("北京", "天津", "河北", "山西", "内蒙古"), 
	东北地区("辽宁", "吉林", "黑龙江", "大连"), 
	华东地区("上海", "江苏", "浙江", "安徽", "福建", "江西", "山东","宁波", "厦门", "青岛"), 
	中南地区("河南", "湖北", "湖南", "广东", "广西", "海南","深圳"), 
	西南地区("重庆", "四川", "贵州", "云南", "西藏"), 
	西北地区("陕西", "甘肃", "青海", "宁厦", "新疆");
	
	private String[] provinces;

	private Territory(String... provinces) {
		this.provinces = provinces;
	}
	
	public static String getTerritoryByProvince(String name){
		for(Territory territory : values()){
			String[] ps = territory.getProvinces();
			for(String pro : ps){
				if(pro.contains(name) || name.contains(pro)){
					return territory.toString();
				}
			}
		}
		return "无地域信息";
	}
	
	
	public String[] getProvinces() {
		return provinces;
	}

	public void setProvinces(String[] provinces) {
		this.provinces = provinces;
	}

}
