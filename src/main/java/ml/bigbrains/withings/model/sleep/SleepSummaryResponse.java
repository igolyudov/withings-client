package ml.bigbrains.withings.model.sleep;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import ml.bigbrains.withings.model.GenericResponse;

@Data
@ToString(callSuper = true)
public class SleepSummaryResponse extends GenericResponse {
    @JsonProperty("body")
    private SleepSummaryBody body;
}
