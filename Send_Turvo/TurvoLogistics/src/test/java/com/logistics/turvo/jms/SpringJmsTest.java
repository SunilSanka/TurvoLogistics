package com.logistics.turvo.jms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.logistics.turvo.ws.Producer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringJmsTest {

	@Autowired
	private Producer producer;
	
	
	@Test
	public void testReceive() throws Exception{
		 producer.send("boot.q", "This is a test message");
		 //assertThat(consumer.getLatch().getCount()).isEqualTo(0);
	}
}
