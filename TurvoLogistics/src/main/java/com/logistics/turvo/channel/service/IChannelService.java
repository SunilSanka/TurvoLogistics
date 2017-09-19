package com.logistics.turvo.channel.service;

public interface IChannelService {

	public static final String ACCOUNT_SID = "ACcc5bb6db2ce1ec6e56c47dfec7357580";
	public static final String AUTH_TOKEN = "ad154038081581eac19f7cf1ea31ce48";
	public static final String TWILIO_NUMBER = "+14158553757";
	
	void notify(String toNum, String smsMessage);

}