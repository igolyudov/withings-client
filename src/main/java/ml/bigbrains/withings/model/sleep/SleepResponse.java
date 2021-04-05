package ml.bigbrains.withings.model.sleep;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import ml.bigbrains.withings.model.GenericResponse;

import java.util.List;

@Data
@ToString(callSuper = true)
public class SleepResponse extends GenericResponse {
    @JsonProperty("body")
    private SleepBody body;

}
