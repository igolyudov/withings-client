package ml.bigbrains.withings;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ml.bigbrains.withings.model.heart.HeartListRequest;
import ml.bigbrains.withings.model.heart.HeartListResponse;
import ml.bigbrains.withings.model.heart.HeartRequest;
import ml.bigbrains.withings.model.heart.HeartResponse;
import ml.bigbrains.withings.model.nonce.GetNonceRequest;
import ml.bigbrains.withings.model.nonce.GetNonceResponse;
import ml.bigbrains.withings.model.sleep.SleepRequest;
import ml.bigbrains.withings.model.sleep.SleepResponse;
import ml.bigbrains.withings.model.sleep.SleepSummaryRequest;
import ml.bigbrains.withings.model.sleep.SleepSummaryResponse;
import ml.bigbrains.withings.model.token.AuthRequest;
import ml.bigbrains.withings.model.token.AuthResponse;
import ml.bigbrains.withings.model.user.GetDeviceRequest;
import ml.bigbrains.withings.model.user.GetDeviceResponse;
import ml.bigbrains.withings.model.user.GetGoalsRequest;
import ml.bigbrains.withings.model.user.GetGoalsResponse;
import okhttp3.*;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class WithingsClient {

    private String baseUrl = "https://wbsapi.withings.net/v2/";
    private String secretKey;
    private String clientId;

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final OkHttpClient client = new OkHttpClient();

    public WithingsClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public WithingsClient() {
    }

    public AuthResponse getToken(AuthRequest request) throws IOException {
        GetNonceRequest nonceRequest = new GetNonceRequest(request.getClientId(), request.getClientSecretKey());
        log.debug("nonce request map: {}",nonceRequest.getParamMap());
        GetNonceResponse nonceResponse = postRequest(nonceRequest.getRequestUrl(), nonceRequest.getParamMap(), GetNonceResponse.class);
        log.debug("nonce response: {}",nonceResponse);
        if(nonceResponse==null || nonceResponse.getBody()==null)
        {
            log.error("Error in get nonce for request");
            return null;
        }
        Map<String,String> mapForSign = new HashMap<>();
        mapForSign.put("action",request.getAction());
        mapForSign.put("client_id",request.getClientId());
        mapForSign.put("nonce",nonceResponse.getBody().getNonce());
        String signature = SignUtility.sign(mapForSign,  request.getClientSecretKey());
        request.setNonce(nonceResponse.getBody().getNonce());
        request.setSignature(signature);
        log.debug("auth request map: {}",request.getParamMap());
        AuthResponse response = postRequest(request.getRequestUrl(), request.getParamMap(), AuthResponse.class);
        return response;
    }

    public GetNonceResponse getNonce(GetNonceRequest request) throws IOException {
        log.debug("get nonce request map: {}",request.getParamMap());
        GetNonceResponse response = postRequest(request.getRequestUrl(), request.getParamMap(), GetNonceResponse.class);
        return response;
    }

    public SleepResponse getSleep(String token, SleepRequest request) throws IOException {
        log.debug("sleep request token {} map: {}",token,request.getParamMap());
        SleepResponse response = postRequest(request.getRequestUrl(), token, request.getParamMap(), SleepResponse.class);
        return response;
    }

    public SleepSummaryResponse getSleepSummary(String token, SleepSummaryRequest request) throws IOException {
        log.debug("sleep summary request map: {}",request.getParamMap());
        SleepSummaryResponse response = postRequest(request.getRequestUrl(), token, request.getParamMap(), SleepSummaryResponse.class);
        return response;
    }

    public HeartResponse getHeart(String token, HeartRequest request) throws IOException {
        log.debug("heart request token {} map: {}",token,request.getParamMap());
        HeartResponse response = postRequest(request.getRequestUrl(), token, request.getParamMap(), HeartResponse.class);
        return response;
    }

    public HeartListResponse getHeartList(String token, HeartListRequest request) throws IOException {
        log.debug("heart list request token {} map: {}",token,request.getParamMap());
        HeartListResponse response = postRequest(request.getRequestUrl(), token, request.getParamMap(), HeartListResponse.class);
        return response;
    }

    public GetDeviceResponse getDevice(String token, GetDeviceRequest request) throws IOException {
        log.debug("get device request token {} map: {}",token,request.getParamMap());
        GetDeviceResponse response = postRequest(request.getRequestUrl(), token, request.getParamMap(), GetDeviceResponse.class);
        return response;
    }

    public GetGoalsResponse getGoals(String token, GetGoalsRequest request) throws IOException {
        log.debug("get goals request token {} map: {}",token,request.getParamMap());
        GetGoalsResponse response = postRequest(request.getRequestUrl(), token, request.getParamMap(), GetGoalsResponse.class);
        return response;
    }


    private <T> T postRequest(String url, Map<String, String> params, Class<T> responseClass) {

        FormBody.Builder body = new FormBody.Builder();

        for(Map.Entry<String,String> entry: params.entrySet())
            body.add(entry.getKey(),entry.getValue());

        RequestBody formBody  = body.build();
        okhttp3.Request request = new Request.Builder()
                .url(baseUrl+url)
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
            {
                log.warn("Response is not success. Response code: {}",response.code());
            }
            if(response.body()!=null)
                return mapper.readValue(response.body().string(), responseClass);
            else
            {
                log.error("Empty response body after request to {}",url);
                return null;
            }
        }
        catch (IOException e)
        {
            log.error("Error in postRequest to {}",url,e);
            return null;
        }
    }

    private <T> T postRequest(String url, String token, Map<String, String> params, Class<T> responseClass) {

        FormBody.Builder body = new FormBody.Builder();

        for(Map.Entry<String,String> entry: params.entrySet())
            body.add(entry.getKey(),entry.getValue());

        RequestBody formBody  = body.build();
        okhttp3.Request request = new Request.Builder()
                .url(baseUrl+url)
                .header("Authorization","Bearer "+token)
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
            {
                log.warn("Response is not success. Response code: {}",response.code());
            }
            if(response.body()!=null)
                return mapper.readValue(response.body().string(), responseClass);
            else
            {
                log.error("Empty response body after request to {}",url);
                return null;
            }
        }
        catch (IOException e)
        {
            log.error("Error in postRequest to {}",url,e);
            return null;
        }
    }
    

}
