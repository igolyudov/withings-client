package ml.bigbrains.withings.model.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import ml.bigbrains.withings.model.GenericResponse;

@Data
@ToString(callSuper = true)
public class AuthResponse extends GenericResponse {
    @JsonProperty("body")
    private AuthBody body;
}
