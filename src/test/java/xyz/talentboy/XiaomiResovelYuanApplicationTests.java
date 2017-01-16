package xyz.talentboy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xyz.talentboy.common.constant.Territory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XiaomiResovelYuanApplicationTests {

	@Test
	public void contextLoads() {
		Territory tt = Territory.valueOf("山东");
		System.out.println(tt.toString());
	}

}
