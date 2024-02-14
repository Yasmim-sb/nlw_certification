package com.nlw.certification.students.seed;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateSeed {

    private final JdbcTemplate jdbcTemplate;

    private CreateSeed(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_certification");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        CreateSeed createSeed = new CreateSeed(dataSource);
        createSeed.run(args);

    }

    public void run(String... args){

        executeSqlFile("src/main/resources/create.sql");

    }

    private void executeSqlFile(String filePath){
        try{
            String sqlScript = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] sqlStatements = sqlScript.split(";");

            for (String statement : sqlStatements) {
                jdbcTemplate.execute(statement);
            }

            } catch(IOException e){
            System.out.println("Erro ao executar arquivo " + e.getMessage());
        }
    }
}
