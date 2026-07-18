package com.naidu.GithubReport.service;

import com.naidu.GithubReport.client.GithubClient;
import com.naidu.GithubReport.dto.AccessReportDto;
import com.naidu.GithubReport.dto.CollaboratorDto;
import com.naidu.GithubReport.dto.RepositoryDto;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class GithubService {

    private final GithubClient githubClient;

    public GithubService(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    public Map<String, AccessReportDto> generateAccessReport() {
        Map<String, AccessReportDto> report = new LinkedHashMap<>();

        List<RepositoryDto> repositories = githubClient.getRepositories();

        for (RepositoryDto repository : repositories) {

            List<CollaboratorDto> collaborators =
                    githubClient.getCollaborators(repository.getName());

            for (CollaboratorDto collaborator : collaborators) {

                report.computeIfAbsent(
                        collaborator.getLogin(),
                        AccessReportDto::new
                ).addRepository(repository.getName());
            }
        }

        return report;
    }
}