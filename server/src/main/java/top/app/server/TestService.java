package top.app.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import top.app.dao.entity.UserInfo;
import top.app.dao.mapper.UserInfoMapper;

import java.util.List;

/**
 * demo测试
 *
 * @author zclys
 * @date 2020/12/21 13:58
 */
@Service
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    public String testServer1(){
        logger.info("TestService.testServer1()");
        List<UserInfo> reslist =  userInfoMapper.findAll();
        reslist.forEach(System.out::print);
        return "test1";
    }

    public UserInfo testServer2(Integer id){
        logger.info("TestService.testServer2()");
        return userInfoMapper.findOne(id);
    }
}
