package com.example.JavaApiTask.controller;

import com.example.JavaApiTask.model.GithubDto;
import com.example.JavaApiTask.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GithubController {

    private final GithubService githubService;

    @GetMapping("/github/{user}")
    public GithubDto getGithub(@PathVariable String user){
        return githubService.getGithub(user);
    }
}

