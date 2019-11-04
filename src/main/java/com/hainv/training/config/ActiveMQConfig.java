package com.hainv.training.config;

import lombok.Data;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

/**
 * @author Created by Hainv on 2019-11-05
 * @project docker-compose
 */
@Configuration
@Data
public class ActiveMQConfig {

    @Value("${activemq.broker-url}")
    private String brokerUrl;

    @Value("${activemq.username}")
    private String userName;

    @Value("${activemq.password}")
    private String password;


    @Bean(value = "senderActiveMQConnectionFactory")
    public ConnectionFactory senderActiveMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        activeMQConnectionFactory.setUserName(userName);
        activeMQConnectionFactory.setPassword(password);

        return activeMQConnectionFactory;
    }

    @Bean(value = "cachingConnectionFactory")
    public CachingConnectionFactory cachingConnectionFactory(@Qualifier(value = "senderActiveMQConnectionFactory") ConnectionFactory connectionFactory) {
        return new CachingConnectionFactory(
                connectionFactory);
    }

    @Bean
    public JmsTemplate jmsTemplate(@Qualifier(value = "cachingConnectionFactory") ConnectionFactory connectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());

        return jmsTemplate;
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
