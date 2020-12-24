package app.test.common.json;

import app.test.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.app.dao.entity.UserInfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试类 Jackson api测试
 *
 * @author zclys
 * @date 2020/12/23 15:37
 */
public class JsonUtilsTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtilsTest.class);

    private Object object;

    @Before
    public void testBefore(){
        /*数据准备*/
        UserInfo userInfo = new UserInfo();
        userInfo.setSysId(1);
        userInfo.setUserAcco("user0001");
        userInfo.setUserName("我的亚索没有R");
        userInfo.setPhoneNo("11111111111");
        userInfo.setEmail("123@163.com");
        userInfo.setSalary(new BigDecimal(9999));
        Map<String, Object> resMap = new HashMap<>();
        Map<String, Object> head = new HashMap<>();
        head.put("jnl","123456789");
        head.put("SvrCod","000001");
        head.put("MsgID","123456789");
        Map<String, Object> body = new HashMap<>();
        List<UserInfo> resUserList = new ArrayList<>();
        resUserList.add(userInfo);
        resUserList.add(userInfo);
        body.put("resUserList",resUserList);
        resMap.put("head",head);
        resMap.put("body",body);
        object = resMap;
    }

    @Test
    public void testObjParse2Json(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonStr = objectMapper.writeValueAsString(object);
//            System.out.println("jsonStr:"+jsonStr);
            logger.info("jsonStr:{}",jsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
