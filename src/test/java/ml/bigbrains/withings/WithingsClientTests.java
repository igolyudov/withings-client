package ml.bigbrains.withings;

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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(JUnit4.class)
@Slf4j
public class WithingsClientTests {

	private static final String BASE_URL = "https://wbsapi.withings.net/v2/";


	@Test
	public void testGetAuthToken() throws IOException
	{
		String clientId="4900fadde42c96c4c95591863f0dc58cccd68a9440375462e04acb4690ac5027";
		String secretKey="d3dfc8ae1bc6d51fc42f1c3facf4c4ebb6aad4f55cf64d0289af696e09718de2";
		String code = "6ac481e48bce25db63b91d35b75eb945868c50d7";
		String redirectUrl = "http://healthreport.ml:9090/auth";

		AuthRequest req = new AuthRequest(clientId, secretKey, code, redirectUrl, false);
		log.info("req: {}",req);
		assertNotNull(req);
		WithingsClient client = new WithingsClient();
		AuthResponse resp = client.getToken(req);
		log.info("resp: {}",resp);
		assertNotNull(resp);
	}


	@Test
	public void testGetSleepSummary()  throws IOException
	{
		String clientId=System.getProperty("clientId");
		String secretKey=System.getProperty("secretKey");
		String token =System.getProperty("token");

		SleepSummaryRequest req = new SleepSummaryRequest(LocalDate.now().minusDays(1), LocalDate.now(), Arrays.asList("breathing_disturbances_intensity","deepsleepduration,durationtosleep"));
		log.info("req: {}",req.getParamMap());
		assertNotNull(req);
		WithingsClient client = new WithingsClient(BASE_URL);
		SleepSummaryResponse resp = client.getSleepSummary(token,req);
		log.info("resp: {}",resp);
		assertNotNull(resp);
	}

	@Test
	public void testGetSleep()  throws IOException
	{
		String clientId=System.getProperty("clientId");;
		String secretKey=System.getProperty("secretKey");
		String token =System.getProperty("token");

		SleepRequest req = new SleepRequest(LocalDate.now().minusDays(1), Arrays.asList("hr","rr","snoring"));
		log.info("req: {}",req.getParamMap());
		assertNotNull(req);
		WithingsClient client = new WithingsClient(BASE_URL);
		SleepResponse resp = client.getSleep(token,req);
		log.info("resp: {}",resp);
		assertNotNull(resp);
	}

	@Test
	public void testRefreshAuthToken() throws IOException
	{
		String clientId=System.getProperty("clientId");
		String secretKey=System.getProperty("secretKey");
		String refreshToken =System.getProperty("refreshToken");
		String redirectUrl = "http://localhost/auth";

		AuthRequest req = new AuthRequest(clientId, secretKey, refreshToken, redirectUrl, true);
		log.info("req: {}",req);
		assertNotNull(req);
		WithingsClient client = new WithingsClient(BASE_URL);
		AuthResponse resp = client.getToken(req);
		log.info("resp: {}",resp);
		assertNotNull(resp);
	}

	@Test
	public void testGetNonse() throws IOException
	{
		String clientId=System.getProperty("clientId");
		String secretKey=System.getProperty("secretKey");

		GetNonceRequest req = new GetNonceRequest(clientId, secretKey);
		log.info("req: {}",req);
		assertNotNull(req);
		WithingsClient client = new WithingsClient();
		GetNonceResponse resp = client.getNonce(req);
		log.info("resp: {}",resp);
		assertNotNull(resp);
	}

	@Test
	public void testGetHeartList()  throws IOException
	{
		String clientId=System.getProperty("clientId");;
		String secretKey=System.getProperty("secretKey");
		String token =System.getProperty("token");

		HeartListRequest req = new HeartListRequest(LocalDateTime.now().minusDays(10), LocalDateTime.now(),0L);
		log.info("req: {}",req.getParamMap());
		assertNotNull(req);
		WithingsClient client = new WithingsClient();
		HeartListResponse resp = client.getHeartList(token,req);
		log.info("resp: {}",resp);
		assertNotNull(resp);
	}

	@Test
	public void testGetHeart()  throws IOException
	{
		String clientId=System.getProperty("clientId");;
		String secretKey=System.getProperty("secretKey");
		String token =System.getProperty("token");

		HeartRequest req = new HeartRequest("0");
		log.info("req: {}",req.getParamMap());
		assertNotNull(req);
		WithingsClient client = new WithingsClient();
		HeartResponse resp = client.getHeart(token,req);
		log.info("resp: {}",resp);
		assertNotNull(resp);
	}


	@Test
	public void testGetDevice()  throws IOException
	{
		String clientId=System.getProperty("clientId");;
		String secretKey=System.getProperty("secretKey");
		String token =System.getProperty("token");

		GetDeviceRequest req = new GetDeviceRequest();
		log.info("req: {}",req.getParamMap());
		assertNotNull(req);
		WithingsClient client = new WithingsClient();
		GetDeviceResponse resp = client.getDevice(token,req);
		log.info("resp: {}",resp);
		assertNotNull(resp);
	}

	@Test
	public void testGetGoals()  throws IOException
	{
		String clientId=System.getProperty("clientId");;
		String secretKey=System.getProperty("secretKey");
		String token =System.getProperty("token");

		GetGoalsRequest req = new GetGoalsRequest();
		log.info("req: {}",req.getParamMap());
		assertNotNull(req);
		WithingsClient client = new WithingsClient();
		GetGoalsResponse resp = client.getGoals(token,req);
		log.info("resp: {}",resp);
		assertNotNull(resp);
	}

	@Test
	public void testSign()
	{
		String clientId = "123";
		String secretKey="321";
		String signature="e31578567e9bf03aca4821b7697016195c7d337963f1c85a3035148d7394efdc";
		String action="getnonce";
		Long timestamp=1617741683L;
		Map<String,String> map = new HashMap<>();
		map.put("client_id",clientId);
		map.put("action", action);
		map.put("timestamp", Long.toString(timestamp));
		assertEquals(signature,SignUtility.sign(map,secretKey));
	}

}
