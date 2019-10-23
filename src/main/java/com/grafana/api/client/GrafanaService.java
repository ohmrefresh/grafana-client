/* Licensed under Apache-2.0 */
package com.grafana.api.client;

import com.grafana.api.client.models.GrafanaDashboard;
import com.grafana.api.client.models.GrafanaSearchResult;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


public interface GrafanaService {
  String GRAFANA_DASHBOARDS = "api/dashboards/db/";
  String GRAFANA_SEARCH = "api/search/";

  String AUTHORIZATION = "Authorization";

  @GET(GRAFANA_DASHBOARDS + "{dashboard}")
  Call<GrafanaDashboard> getDashboard(
          @Header(AUTHORIZATION) String authorization, @Path("dashboard") String dashboard);

  @GET(GRAFANA_SEARCH)
  Call<List<GrafanaSearchResult>> search(
          @Header(AUTHORIZATION) String authorization,
          @Query("query") String query,
          @Query("tag") String tag);

}
