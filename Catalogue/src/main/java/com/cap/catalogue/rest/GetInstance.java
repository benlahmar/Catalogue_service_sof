package com.cap.catalogue.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetInstance {

	@Autowired
	DiscoveryClient discovryclient;
	
	@GetMapping("/instances/{appname}")
	public List<ServiceInstance> get(@PathVariable String appname)
	{
		return discovryclient.getInstances(appname);
	}
	
}
