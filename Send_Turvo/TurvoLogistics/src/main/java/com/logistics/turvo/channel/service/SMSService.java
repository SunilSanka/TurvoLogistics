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
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

@Component
@Qualifier("smsService")
public class SMSService implements IChannelService {
	private static final Logger logger = LoggerFactory.getLogger(SMSService.class);
	
	//Send an SMS to the registered user
	@Override
	public void notify(String toNum, String smsMessage){
		try{
			TwilioRestClient client  = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("Body", smsMessage));
			params.add(new BasicNameValuePair("To", toNum));
			params.add(new BasicNameValuePair("From",TWILIO_NUMBER));
			
			MessageFactory messageFactory = client.getAccount().getMessageFactory();
			Message message = messageFactory.create(params);
			logger.info("Twilio SMS send on Sid :"+message.getSid());
			
		}catch(TwilioRestException te){
			logger.info("Twilio Rest Exception occured with error code '{}' while send the SMS :"+te.getErrorCode(),te.getErrorMessage());
			//te.printStackTrace();
		}
		catch(Exception e){
			logger.info("Twilio Rest Exception occured while send the SMS :"+e.getMessage());
			//te.printStackTrace();
		}
	}
	
	
	
}
