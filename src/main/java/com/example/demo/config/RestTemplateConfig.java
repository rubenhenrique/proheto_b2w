package com.example.demo.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	private int connectionTimeout;
	private int readTimeout;
	private int maxConnectionsPerHost;
	private int maxConnectionsTotal;

	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		return restTemplate;
	}
	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setHttpClient(getHttpClient());
		factory.setConnectTimeout(connectionTimeout);
		factory.setReadTimeout(readTimeout);
		return factory;
	}

	private HttpClient getHttpClient() {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		httpClientBuilder.setMaxConnPerRoute(maxConnectionsPerHost);
		httpClientBuilder.setMaxConnTotal(maxConnectionsTotal);
		return httpClientBuilder.build();
	}

	@Value("${service.connection.timeout}")
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	@Value("${service.read.timeout}")
	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	@Value("${service.max.conn.per.host}")
	public void setMaxConnectionsPerHost(int maxConnectionsPerHost) {
		this.maxConnectionsPerHost = maxConnectionsPerHost;
	}

	@Value("${service.max.conn.total}")
	public void setMaxConnectionsTotal(int maxConnectionsTotal) {
		this.maxConnectionsTotal = maxConnectionsTotal;
	}

}
