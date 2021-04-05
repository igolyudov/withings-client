package ml.bigbrains.withings.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Weight {
    @JsonProperty("value")
    private Long value;
    @JsonProperty("unit")
    private Long unit;
}
