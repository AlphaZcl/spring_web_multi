package app.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试基类
 *
 * @author zclys
 * @date 2020/12/21 11:10
 */
@ContextConfiguration(locations = {"classpath:testconf/springwebtest/*"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseTest {

    @Test
    public void baseTest(){
    }
}
