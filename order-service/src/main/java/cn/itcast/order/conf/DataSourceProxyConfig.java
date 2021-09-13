package cn.itcast.order.conf;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;


/**
 * 注册mybatis代理
 */
@Configurable
public class DataSourceProxyConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        // 订单服务中引入了mybatis-plus，所以要使用特殊的SqlSessionFactoryBean
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        // 代理数据源
        sqlSessionFactoryBean.setDataSource(new DataSourceProxy(dataSource));
        // 生成SqlSessionFactory
        return sqlSessionFactoryBean.getObject();
    }
}
