package top.app.dao.dynamicManager;

import java.lang.annotation.*;

/**
 * 目标数据库
 * @author zclys
 * @date 2020/12/30 9:23
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
