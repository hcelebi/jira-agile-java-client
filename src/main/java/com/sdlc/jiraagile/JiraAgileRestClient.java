package com.sdlc.jiraagile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdlc.jiraagile.domain.request.UpdateRankRequest;

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
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateIssuesRank(UpdateRankRequest updateRankRequest) {
        try {
            put("/issue/rank", objectMapper.writeValueAsString(updateRankRequest));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
