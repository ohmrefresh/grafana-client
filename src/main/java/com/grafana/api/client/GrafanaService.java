/* Licensed under Apache-2.0 */
package com.grafana.api.client;

import com.grafana.api.client.models.GrafanaDashboard;
import retrofit2.Call;
import retrofit2.http.*;


public interface GrafanaService {
  String GRAFANA_DASHBOARDS = "api/dashboards/db/";

  String AUTHORIZATION = "Authorization";

  //Dashboards
  @GET(GRAFANA_DASHBOARDS + "{dashboard}")
  Call<GrafanaDashboard> getDashboard(
          @Header(AUTHORIZATION) String authorization, @Path("dashboard") String dashboard);

}
