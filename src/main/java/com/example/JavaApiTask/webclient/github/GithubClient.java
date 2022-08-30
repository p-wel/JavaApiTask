package com.example.JavaApiTask.webclient.github;

import com.example.JavaApiTask.model.GithubDto;
import com.example.JavaApiTask.webclient.github.dto.GithubReposDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GithubClient {

    private static final String GITHUB_URL = "https://api.github.com/users/";
    private RestTemplate restTemplate = new RestTemplate();

    //get user's data
    public GithubDto getGithubForUser(String user) {
        GithubReposDto githubReposDto = callGetMethod(user, GithubReposDto.class);
        return GithubDto.builder()
                .repoOwnerLogin(githubReposDto.getOwner().getLogin())
                .build();
    }

    //get user's repos data
    public GithubDto getGithubReposForUser(String user) {
        GithubReposDto githubReposDto = callGetMethod(user + "/repos", GithubReposDto.class);
        return GithubDto.builder()
                .repoOwnerLogin(githubReposDto.getOwner().getLogin())
                .build();
    }

    //call get method (with various class types can be given as a response)
    public <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(GITHUB_URL + url,
                responseType, objects);
    }
}
