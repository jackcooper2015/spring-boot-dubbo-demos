package com.reapal.dubbo.provider.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



/**
 * Created by jack-cooper on 2017/1/18.
 */
@Aspect
@Component
public class DataSourceAop {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.reapal..mapper..*.select*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.read();
        log.info("dataSource切换到：Read");
    }

    @Before("execution(* com.reapal..mapper..*.insert*(..)) " +
            "or execution(* com.reapal..*.mapper..*.update*(..)) " +
            "or execution(* com.reapal..*.mapper..*.delete*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
        log.info("dataSource切换到：write");
    }
}
