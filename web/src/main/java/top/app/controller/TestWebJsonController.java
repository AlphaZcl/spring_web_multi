package top.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import top.app.dao.entity.UserInfo;
import top.app.server.TestService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * demo控制器层,返回数据格式为json
 *
 * @author zclys
 * @date 2020/12/21 10:44
 */
@RequestMapping("testweb")
@Controller
public class TestWebJsonController {

    private static final Logger logger = LoggerFactory.getLogger(TestWebJsonController.class);

    @Autowired
    private TestService testService;

    @RequestMapping("test1")
    public String test1() {
        logger.info("TestWebController.test1()");
        //service调用
        String resStr = testService.testServer1();
        logger.info("resStr:{}", resStr);
        return "success";
    }

    @RequestMapping(value = "mvJson",produces ="application/json;charset=UTF-8" )
    @ResponseBody
    public ModelAndView test2(@RequestParam(value = "sysId", required = false, defaultValue = "0") Integer id) {
        UserInfo resUser = testService.testServer2(id);
        logger.info("test2：查询结果：{}", resUser);
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        Map<String, Object> resMap = new HashMap<>();
        Map<String, Object> head = new HashMap<>();
        head.put("jnl", "123456789");
        head.put("SvrCod", "000001");
        head.put("MsgID", "123456789");
        Map<String, Object> body = new HashMap<>();
        List<UserInfo> resUserList = new ArrayList<>();
        resUserList.add(resUser);
        resUserList.add(resUser);
        body.put("resUserList", resUserList);
        resMap.put("head", head);
        resMap.put("body", body);
        mv.addAllObjects(resMap);
        return mv;
    }

    @RequestMapping(value = "strJson",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String test3(@RequestParam(value = "sysId", required = false, defaultValue = "0") Integer id) {
        UserInfo resUser = testService.testServer2(id);
        logger.info("test3：查询结果：{}", resUser);
        Map<String, Object> resMap = new HashMap<>();
        Map<String, Object> head = new HashMap<>();
        head.put("jnl", "123456789");
        head.put("SvrCod", "000001");
        head.put("MsgID", "123456789");
        Map<String, Object> body = new HashMap<>();
        List<UserInfo> resUserList = new ArrayList<>();
        resUserList.add(resUser);
        resUserList.add(resUser);
        body.put("resUserList", resUserList);
        resMap.put("head", head);
        resMap.put("body", body);
        //转json串
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = objectMapper.writeValueAsString(resMap);
        } catch (JsonProcessingException e) {
            logger.info("json转换出错：{}，具体信息：{}", e.getMessage(), e);
        }
        return jsonStr;
    }

    @RequestMapping(value = "mapJson",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> test4(@RequestParam(value = "sysId", required = false, defaultValue = "0") Integer id){
        UserInfo resUser = testService.testServer2(id);
        logger.info("test4：查询结果：{}", resUser);
        Map<String, Object> resMap = new HashMap<>();
        Map<String, Object> head = new HashMap<>();
        head.put("jnl", "123456789");
        head.put("SvrCod", "000001");
        head.put("MsgID", "123456789");
        Map<String, Object> body = new HashMap<>();
        List<UserInfo> resUserList = new ArrayList<>();
        resUserList.add(resUser);
        resUserList.add(resUser);
        body.put("resUserList", resUserList);
        resMap.put("head", head);
        resMap.put("body", body);
        return resMap;
    }

    @RequestMapping("listJson")
    @ResponseBody
    public List<UserInfo> test5(@RequestParam(value = "sysId", required = false, defaultValue = "0") Integer id) {
        List<UserInfo> resList = new ArrayList<>();
        UserInfo resUser = testService.testServer2(id);
        resList.add(resUser);
        logger.info("test5：查询结果：{}", resUser);
        return resList;
    }

    @RequestMapping("pojoJson")
    @ResponseBody
    public UserInfo test6(@RequestParam(value = "sysId", required = false, defaultValue = "0") Integer id){
        UserInfo resUser = testService.testServer2(id);
        logger.info("test6：查询结果：{}", resUser);
        return resUser;
    }
}
