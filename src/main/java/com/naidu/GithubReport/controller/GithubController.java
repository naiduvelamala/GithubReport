package com.naidu.GithubReport.controller;

import com.naidu.GithubReport.dto.AccessReportDto;
import com.naidu.GithubReport.service.GithubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/access-report")
    public Map<String, AccessReportDto> accessReport() {
        return githubService.generateAccessReport();
    }
}