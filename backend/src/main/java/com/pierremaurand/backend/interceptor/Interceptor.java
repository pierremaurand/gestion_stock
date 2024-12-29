package com.pierremaurand.backend.interceptor;

import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Interceptor implements StatementInspector {

    @Override
    public String inspect(String sql) {
        if(StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
            if(sql.contains("where")) {
                sql += " and entreprise_id = 1";
            } else {
                sql += " where entreprise_id = 1";
            }
        }
        System.out.println(sql);
        return sql;
    }


}
