package ml.bigbrains.withings.model.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class AuthBody {
    @JsonProperty("userid")
    private Long userId;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("scope")
    private String scope;
    @JsonProperty("expires_in")
    private Long expiresInSeconds;
    @JsonProperty("csrf_token")
    private String csrfToken;
    @JsonProperty("token_type")
    private String tokenType;
}
