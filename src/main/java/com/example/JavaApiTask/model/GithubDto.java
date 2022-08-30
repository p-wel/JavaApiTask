package com.example.JavaApiTask.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GithubDto {
    private String repoOwnerLogin;
}
