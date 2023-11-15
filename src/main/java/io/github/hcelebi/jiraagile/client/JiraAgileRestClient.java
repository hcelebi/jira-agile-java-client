package io.github.hcelebi.jiraagile.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hcelebi.jiraagile.domain.dto.AgileSprintResult;
import io.github.hcelebi.jiraagile.domain.request.UpdateRankRequest;
import io.github.hcelebi.jiraagile.exception.JiraAgileRunTimeException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class JiraAgileRestClient {
    private final String baseUri;
    private final String token;
    private final HttpClient client;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public JiraAgileRestClient(String baseUri, String token) {
        this.baseUri = baseUri;
        this.token = token;
        client = HttpClient.newHttpClient();
    }

    private HttpResponse put(String path, String requestBody) {
        try {
            return client.send(HttpRequest.newBuilder()
                    .uri(URI.create(baseUri + path))
                    .header("Authorization", "Basic " + token)
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build(), BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new JiraAgileRunTimeException(e.getMessage());
        }
    }

    public void updateIssuesRank(UpdateRankRequest updateRankRequest) {
        try {
            put("/issue/rank", objectMapper.writeValueAsString(updateRankRequest));
        } catch (JsonProcessingException e) {
            Thread.currentThread().interrupt();
            throw new JiraAgileRunTimeException(e.getMessage());
        }
    }

    public AgileSprintResult getSprints(Integer boardId) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            HttpResponse<String> response = client.send(HttpRequest.newBuilder()
                    .uri(URI.create(baseUri + "/board/" + boardId + "/sprint"))
                    .header("Authorization", "Basic " + token)
                    .header("Content-Type", "application/json")
                    .GET()
                    .build(), BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), AgileSprintResult.class);
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new JiraAgileRunTimeException(e.getMessage());
        }
    }
}
