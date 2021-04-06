package ml.bigbrains.withings.model.token;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ml.bigbrains.withings.model.GenericRequest;

import java.util.HashMap;
import java.util.Map;

@ToString
public class AuthRequest implements GenericRequest {

    @Getter
    private String requestUrl = "oauth2";

    @Getter
    private String action = "requesttoken";
    private String grantType;
    @Getter
    private String clientId;
    @Getter
    private String clientSecretKey;
    private String code;
    private String refreshToken;
    private String redirectUri;
    @Getter @Setter
    private String nonce;
    @Setter
    private String signature;

    public AuthRequest(String clientId, String secretKey, String codeOrRefreshToken, String redirectUri, boolean needRefreshToken) {
        this.clientId = clientId;
        this.clientSecretKey = secretKey;
        if(needRefreshToken)
            this.refreshToken = codeOrRefreshToken;
        else
            this.code = codeOrRefreshToken;
        this.redirectUri = redirectUri;
    }


    @Override
    public Map<String, String> getParamMap() {
        Map<String,String> map = new HashMap<>();
        if(code!=null && !code.equals("")) {
            map.put("code", code);
            map.put("grant_type","authorization_code");
        }
        else
        {
            map.put("refresh_token", refreshToken);
            map.put("grant_type","refresh_token");
        }

        if(clientId!=null && !clientId.equals(""))
            map.put("client_id",clientId);
        if(signature!=null && !signature.equals(""))
        {
            map.put("nonce",nonce);
            map.put("signature",signature);
        }
        else
            map.put("client_secret",clientSecretKey);

        if(redirectUri!=null && !redirectUri.equals(""))
            map.put("redirect_uri",redirectUri);

        map.put("action",action);
        return map;
    }
}
