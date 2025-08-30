package com.pnc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pnc.PNCEntity.CustomerEntity;
import com.pnc.PNCService.CustomerService;


@Component
public class KafkaConsumer {

	/*
	 * 
	 * 
	 * async 
	 * distribute the data  on a event based 
	 * kakfa producer
	 * kafka consumer 
	 * 
	 * 
	 * users  
	 * 
	 * partitions  -- divide the topic into different units because I want to distribute the data for multiple brokers
	 * 
	 * 
	 * topics -- data folders is file systems  
	 * 
	 * 
	 * Brokers -- it is going to manage partitions on topics
	 * 
	 * Replication -- Ensures your data os durability anf fault tolerance on partitions across multyple brokers
	 * 
	 * producers are used to send a message / write a mesage to topics 
	 * 
	 * consumers are used to pull a message // read a message
	 * 
	 * Offsets -- Unique Identifier assigned to each message within partititon, allow consumers to track to progress
	 * 
	 *  Segments  -- store brokers data in segments 
	 *  
	 *  
	 * 
	 * high throughtput anf low latancey 
	 * fault tolerance -- faliures and disaster recoverty
	 * 
	 * 
	 * 
	 * 
	 * 
	 * rabbitMQ
	 * ActiveMQ
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	public KafkaConsumer() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Autowired
    private CustomerService service;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "customer-topic", groupId = "my-group")
//   public void consume(String message) {
//        try {
//            CustomerEntity customer = objectMapper.readValue(message, CustomerEntity.class);
//            service.saveCustomerWithThreadSafety(customer);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//}
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
    
	
	

}
