package com.hainv.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Created by Hainv on 2019-11-05
 * @project docker-compose
 */
@Service
public class Sender {

    private final static Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${activemq.topic}")
    private String topic;


    public void send(String message) {
        try {
            logger.info("Sending message='{}'", message);
            jmsTemplate.convertAndSend(topic, message);
        } catch (Exception e) {
            logger.error("Can't send the message");
        }

    }
}
