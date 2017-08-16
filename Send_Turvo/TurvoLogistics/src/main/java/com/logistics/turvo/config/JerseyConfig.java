package com.logistics.turvo.config;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.logistics.turvo.endpoint.LogisticsEndpoint;
import com.logistics.turvo.endpoint.UserEndpoint;
@Component
@ApplicationPath("/turvo")
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig() {
		register(LogisticsEndpoint.class);
		register(UserEndpoint.class);
	}
}
