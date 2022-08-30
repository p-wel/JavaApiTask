package com.example.JavaApiTask.service;

import com.example.JavaApiTask.model.GithubDto;
import com.example.JavaApiTask.webclient.github.GithubClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GithubService {

    private final GithubClient githubClient;

    public GithubDto getGithub(String user) {
        return githubClient.getGithubReposForUser(user);
    }


}
