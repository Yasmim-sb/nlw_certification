package com.nlw.certification.seed;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class CreateSeed {

    private final JdbcTemplate jdbcTemplate;

    private CreateSeed(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

}
