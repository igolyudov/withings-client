package ml.bigbrains.withings.model.heart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import ml.bigbrains.withings.model.GenericResponse;

@Data
@ToString(callSuper = true)
public class HeartResponse extends GenericResponse {
    @JsonProperty("body")
    private HeartBody body;
}
