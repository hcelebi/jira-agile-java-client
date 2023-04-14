package com.sdlc.jiraagile;

import com.sdlc.jiraagile.domain.request.UpdateRankRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class JiraAgileRestClientTest {

    JiraAgileRestClient jiraAgileRestClient;

    @BeforeEach
    void setUp() {
        jiraAgileRestClient = new JiraAgileRestClient("https://jira-agile-mock-bi3sh.hoverfly.io", "");
    }

    @Test
    void updateIssuesRank() {
        UpdateRankRequest updateRankRequest = new UpdateRankRequest();
        updateRankRequest.setRankBeforeIssue("EB-200");
        updateRankRequest.setIssues(List.of("EB-206"));
        jiraAgileRestClient.updateIssuesRank(updateRankRequest);
    }
}