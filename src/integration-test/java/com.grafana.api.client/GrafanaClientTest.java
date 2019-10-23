package com.grafana.api.client;

import com.grafana.api.client.models.GrafanaDashboard;
import com.grafana.api.client.models.GrafanaSearchResult;
import com.grafana.api.configuration.GrafanaConfiguration;
import com.grafana.api.exceptions.GrafanaException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class GrafanaClientTest {

    private  final String GRAFANA_API_KEY = "Bearer xxxx=="; //Replace with valid API key
    private  final String GRAFANA_HOST = "https://xxxx:3000"; // Replace with valid host

    private GrafanaConfiguration grafanaConfiguration =
            new GrafanaConfiguration().host(GRAFANA_HOST).apiKey(GRAFANA_API_KEY);

    private final String tags = "app";
    private final String dashboardName = "app-dash";
    private  GrafanaClient grafanaClient;

    @Before
    public void setup() {
        grafanaClient = new GrafanaClient(grafanaConfiguration);
    }


    @After
    public void clean() {

    }

    @Test
    public void testGeDashboardShouldReturnResponse()  throws GrafanaException, IOException {
        grafanaClient = new GrafanaClient(grafanaConfiguration);
        GrafanaDashboard dash = grafanaClient.getDashboard(dashboardName);
        assert dash !=null;
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//        String json = om.writerWithDefaultPrettyPrinter().writeValueAsString(dash);
//        System.out.println(json);
    }


    @Test
    public void testSearchDashboardWithTagsShouldReturnResponse()  throws GrafanaException, IOException {
        grafanaClient = new GrafanaClient(grafanaConfiguration);
        List<GrafanaSearchResult> dash = grafanaClient.search("",tags);
        assert dash.size()>0;
//
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//        String json = om.writerWithDefaultPrettyPrinter().writeValueAsString(dash);
//        System.out.println(json);
    }

}
