package com.gs.generator;

/**
 * @author gongsong
 * @description:
 * @date 2020/11/9 18:27
 */
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MyGenerator {
    public static void main(String[] args) {
        //全局配置
        GlobalConfig globalConfig=new GlobalConfig();
        globalConfig.setAuthor("gongsong")//设置作者
                .setActiveRecord(true)//是否支持AR模式
                .setOutputDir("E:\\code\\my\\saas-boot\\src\\main\\java")   //生成文件的路径
                .setFileOverride(true)   //文件覆盖
                .setIdType(IdType.AUTO); //主键策略

        //数据源配置
        DataSourceConfig dataSourceConfig=new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://127.0.0.1:3306/manage?serverTimezone=Asia/Shanghai&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull")
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                .setPassword("123456");

        //策略配置
        StrategyConfig strategyConfig=new StrategyConfig();
        strategyConfig.setCapitalMode(true)  //全局大写
                .setNaming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略
                .setInclude("t_user","t_tenant","t_static_resource","t_role","t_page_element","t_menu","t_auth")//表名,不指定表名生成全部
                .setTablePrefix("t_");//表前缀

        //包名策略
        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setParent("com.gs")
                .setEntity("entity")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setXml("mapper");

        AutoGenerator autoGenerator=new AutoGenerator();
        autoGenerator.setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
                .setGlobalConfig(globalConfig)
                .setStrategy(strategyConfig);
        autoGenerator.execute();

    }
}
