package com.naidu.GithubReport.client;
import com.naidu.GithubReport.config.GithubConfig;
import com.naidu.GithubReport.dto.RepositoryDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import java.util.Arrays;
import java.util.List;
import com.naidu.GithubReport.dto.CollaboratorDto;

@Component
public class GithubClient {
    private final RestClient restClient;
    private final GithubConfig githubConfig;
    public GithubClient(RestClient restClient,GithubConfig githubConfig){
        this.restClient=restClient;
        this.githubConfig=githubConfig;
    }
    public List<RepositoryDto> getRepositories() {
        RepositoryDto[] repositories = restClient.get()
                .uri("https://api.github.com/orgs/{org}/repos",githubConfig.getOrganisation())
                .header("Authorization", "Bearer " + githubConfig.getToken())
                .header("Accept", "application/vnd.github+json")
                .retrieve()
                .body(RepositoryDto[].class);

        return Arrays.asList(repositories);
    }

    public List<CollaboratorDto> getCollaborators(String repositoryName) {

        CollaboratorDto[] collaborators = restClient.get()
                .uri(
                        "https://api.github.com/repos/{org}/{repo}/collaborators",
                        githubConfig.getOrganisation(),
                        repositoryName
                )
                .header("Authorization", "Bearer " + githubConfig.getToken())
                .header("Accept", "application/vnd.github+json")
                .retrieve()
                .body(CollaboratorDto[].class);

        return Arrays.asList(collaborators);
    }

}
