package top.app.dsmanager;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import top.app.dao.dynamicManager.DynamicDataSource;
import top.app.dao.dynamicManager.TargetDataSource;

import java.lang.reflect.Method;

/**
 * 数据源切换切面类
 * 指定在server层通过注解的方式进行数据库动态切换
 *
 * @author zclys
 * @date 2020/12/30 10:37
 */
@Aspect
@Component
@Order(1)//数据源切换在事务管理器切面之前执行
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("execution(* top.app.server.*.* (..))")
    public void dataPointCut(){}

    @Around("dataPointCut()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable{
        //获取被增强对象类型
        Class<?> target = point.getTarget().getClass();
        //切入点签名
        MethodSignature signature = (MethodSignature)point.getSignature();

        //解析目标对象的注解进行数据源路由配置
        resolveDataSource(target,signature.getMethod());
        //执行目标方法
        Object result = point.proceed();
        //清理当前数据库线程路由的key值
        DynamicDataSource.clearDS();
        logger.info("---------");
        return result;
    }

    /**
     * 解析数据源
     * @param clazz  被增强类实现的接口及所有注解
     * @param method 倍增强方法
     */
    private void resolveDataSource(Class<?> clazz , Method method){
        try {
//            Class<?>[] parameterTypes = method.getParameterTypes();
            String dataSourceKey = null;
            //判断目标类型上是否有TargetDataSource注解
            if(clazz.isAnnotationPresent(TargetDataSource.class)){
                dataSourceKey = clazz.getAnnotation(TargetDataSource.class).value();
            }

//            Method m = clazz.getMethod(method.getName(),parameterTypes);
            //方法上的注解覆盖掉类上注解的值
            if(method != null &&method.isAnnotationPresent(TargetDataSource.class)){
                dataSourceKey = method.getAnnotation(TargetDataSource.class).value();
            }
            logger.info("数据库源路由key值:{}",dataSourceKey);
            DynamicDataSource.setDS(dataSourceKey);
        } catch (Exception e) {
            logger.info("获取数据源路由key异常:{}",e);
        }
    }

}
