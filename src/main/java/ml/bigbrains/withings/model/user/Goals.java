package ml.bigbrains.withings.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Goals {
    @JsonProperty("steps")
    private Long steps;
    @JsonProperty("sleep")
    private Long sleep;
    @JsonProperty("weight")
    private Weight weight;
}
