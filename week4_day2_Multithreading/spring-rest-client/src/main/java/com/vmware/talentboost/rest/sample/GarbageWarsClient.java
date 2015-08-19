package com.vmware.talentboost.rest.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class GarbageWarsClient {

    private RestTemplate restTemplate;
    private String server;
    private int port;

    public GarbageWarsClient(String server, int port) {
        super();
        this.server = server;
        this.port = port;
        restTemplate = new RestTemplate();
    }

    public String getObjects(int sector) {
        String requestUrl = "http://{server}:{port}/api/sector/{sector}/objects";
        return restTemplate.getForObject(requestUrl, String.class, server, port, sector);
    }

    public String getRoots(int sector) {
        String requestUrl = "http://{server}:{port}/api/sector/{sector}/roots";
        return restTemplate.getForObject(requestUrl, String.class, server, port, sector);
    }

    public ResponseEntity<String> collectTrajectory(int sector, String company, String trajectory) {
        String requestUrl = "http://{server}:{port}/api/sector/{sector}/company/{company}/trajectory";
//        StringBuilder trajectoryBuilder = new StringBuilder();
//        for (int value : trajectory) {
//            trajectoryBuilder.append(value + " ");
//        }
        MultiValueMap<String, Object> trajectoryMap = new LinkedMultiValueMap<String, Object>();
        trajectoryMap.add("trajectory", trajectory.trim());
        return restTemplate.postForEntity(requestUrl, trajectoryMap, String.class, server, port, sector, company);
    }

}
