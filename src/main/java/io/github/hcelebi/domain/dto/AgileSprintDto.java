package io.github.hcelebi.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.hcelebi.serializer.CustomDateTimeDeserializer;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgileSprintDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3211838999969552511L;
    private Integer id;
    private String self;
    private String name;
    private String state;
    private String goal;
    private Integer originBoardId;
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private DateTime startDate;
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private DateTime endDate;
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private DateTime completeDate;
}
