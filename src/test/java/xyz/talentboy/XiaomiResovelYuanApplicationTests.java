package xyz.talentboy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xyz.talentboy.common.constant.Province;
import xyz.talentboy.common.constant.Territory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XiaomiResovelYuanApplicationTests {

	@Test
	public void contextLoads() {
		String name = Province.valueOf(37);
		System.out.println(name);
		String name2 = Territory.getTerritoryByProvince("甘肃");
		System.out.println(name2);
	}
	
}
