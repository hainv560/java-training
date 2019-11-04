package com.hainv.training.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Created by Hainv on 2019-11-05
 * @project docker-compose
 */
@Component
@ConfigurationProperties("app")
public class AppProperties {
}
