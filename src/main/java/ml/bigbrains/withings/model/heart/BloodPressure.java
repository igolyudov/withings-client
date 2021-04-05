package ml.bigbrains.withings.model.heart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BloodPressure {
    @JsonProperty("diastole")
    private Long diastole;
    @JsonProperty("systole")
    private Long systole;
}
