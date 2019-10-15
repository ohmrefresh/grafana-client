package com.grafana.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grafana.api.client.GrafanaClient;
import com.grafana.api.client.models.GrafanaDashboard;
import com.grafana.api.configuration.GrafanaConfiguration;
import com.grafana.api.exceptions.GrafanaException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
public class GrafanaTest {

    private  final String GRAFANA_API_KEY = "Bearer xxxxxx=="; //Replace with valid API key
    private  final String GRAFANA_HOST = "https://xxxxxxxxxxx:3000"; // Replace with valid host

    private  GrafanaConfiguration grafanaConfiguration =
            new GrafanaConfiguration().host(GRAFANA_HOST).apiKey(GRAFANA_API_KEY);
    private  GrafanaClient grafanaClient;

    @Before
    public void setup() {
        grafanaClient = new GrafanaClient(grafanaConfiguration);
    }


    @After
    public void clean() {

    }

    @Test
    public void testGeDashboard()  throws GrafanaException, IOException{
        grafanaClient = new GrafanaClient(grafanaConfiguration);
        GrafanaDashboard dash = grafanaClient.getDashboard("test");
//
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = om.writerWithDefaultPrettyPrinter().writeValueAsString(dash);
        System.out.println(json);
    }

}
