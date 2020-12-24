package top.app.dao.mapper;

import top.app.dao.entity.UserInfo;

import java.util.List;

/**
 *
 *
 * @author zclys
 * @date 2020/12/21 16:45
 */
public interface UserInfoMapper {

    List<UserInfo> findAll();

    UserInfo findOne(Integer id);
}
