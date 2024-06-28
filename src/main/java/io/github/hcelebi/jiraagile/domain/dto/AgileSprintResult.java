package io.github.hcelebi.jiraagile.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgileSprintResult {
    private Integer maxResults;
    private Integer startAt;
    private Integer total;
    private Boolean isLast;
    private List<AgileSprintDto> values;
}
