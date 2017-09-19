package com.logistics.turvo.channel.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Call;

@Component
@Qualifier("callService")
public class CallService implements IChannelService {
	
	private static final Logger logger = LoggerFactory.getLogger(CallService.class);
	
	//Make a call to the registered user
	@Override
	public void notify(String toNum, String smsMessage) {
		
			try{
				TwilioRestClient client  = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("Url","https://brodan.biz/call.xml"));
				params.add(new BasicNameValuePair("To",toNum));
				params.add(new BasicNameValuePair("From",TWILIO_NUMBER));
				
				CallFactory callFactory = client.getAccount().getCallFactory();
				Call call = callFactory.create(params);
				
				logger.info("Answered By :",call.getAnsweredBy());
				logger.info("Duration :",call.getDuration());
				logger.info("Call Price :",call.getPrice());
				
								
			}catch(TwilioRestException te){
				logger.debug("Twilio Rest Exception occured while making a call :"+te);
				te.printStackTrace();
			}
		
	}

}
