package config.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author: SunKe
 * @date: 2020/9/17 8:52 下午
 * @description: Db配置
 */
@Configuration
@MapperScan(basePackages = "com.fzf.study.**.db.mapper")
public class DbConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mktDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory mktSqlSessionFactory(@Qualifier("mktDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver()
						.getResources("classpath*:mapper/mysql/*.xml"));
		sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver()
				.getResource("classpath:mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager mktTransactionManager(@Qualifier("mktDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate mktSessionTemplate(@Qualifier("mktSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

//    @Bean
//    public PageInterceptor mktPageInterceptor(){
//        PageInterceptor pageInterceptor = new PageInterceptor();
//        Properties properties = new Properties();
//        properties.setProperty("helperDialect", "mysql");
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("params", "count=countSql");
//        properties.setProperty("autoRuntimeDialect", "true");
//        pageInterceptor.setProperties(properties);
//        return pageInterceptor;
//    }

}
