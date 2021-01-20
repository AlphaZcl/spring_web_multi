package top.app.dao.dynamicManager;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.List;
import java.util.Random;

/**
 * 数据库路由组件
 * 通过获取注解@TragetDataSource的值来改变数据源
 *
 * @see  TargetDataSource
 * @author zclys
 * @date 2020/12/29 17:20
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 利用ThreadLocal解决线程安全问题，里面存放的是自定义注解的值
     * @see TargetDataSource
     */
    private static final ThreadLocal<String> dataSourcekey = new InheritableThreadLocal<>();

    /**
     * 数据库名称列表
     */
    private List<String> dataSourceNmList;

    /**
     * 默认数据库名称
     */
    private String defaultDataSourceNm;

    private Random random = new Random();

    public DynamicDataSource(){}

    /**
     * 根据dataSourceKey决定当前数据库，dataSourceKey.get()的值将作为key值
     * 从父类的targetDataSources中获取配置的数据源，因而在对本组
     * 件进行创建时，需要进行targetDataSources的初始化配置
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourcekey.get();
    }

    public static void setDS(String dataSource){
        dataSourcekey.set(dataSource);
    }

    public static void clearDS(){
        dataSourcekey.remove();
    }

    public String getDataSourceNmList() {
        //后续可根据需要使用策略进行库表的分派
        return dataSourceNmList.get(random.nextInt(dataSourceNmList.size()));
    }

    public void setDataSourceNmList(List<String> dataSourceNmList) {
        this.dataSourceNmList = dataSourceNmList;
    }

    public String getDefaultDataSourceNm() {
        return defaultDataSourceNm;
    }

    public void setDefaultDataSourceNm(String defaultDataSourceNm) {
        this.defaultDataSourceNm = defaultDataSourceNm;
    }
}
