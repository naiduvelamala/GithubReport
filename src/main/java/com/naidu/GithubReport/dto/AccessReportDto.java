package com.naidu.GithubReport.dto;

import java.util.ArrayList;
import java.util.List;

public class AccessReportDto {

    private String user;

    private List<String> repositories = new ArrayList<>();

    public AccessReportDto() {
    }

    public AccessReportDto(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public List<String> getRepositories() {
        return repositories;
    }

    public void addRepository(String repository) {
        repositories.add(repository);
    }
}