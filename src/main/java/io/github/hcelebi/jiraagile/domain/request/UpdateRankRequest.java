package io.github.hcelebi.jiraagile.domain.request;

import lombok.Data;

import java.util.List;

@Data
public class UpdateRankRequest {
    private String rankBeforeIssue;
    private List<String> issues;
}
