/* Licensed under Apache-2.0 */
package com.grafana.api.client;

import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grafana.api.client.models.GrafanaDashboard;
import com.grafana.api.client.models.GrafanaSearchResult;
import com.grafana.api.configuration.GrafanaConfiguration;
import com.grafana.api.exceptions.GrafanaDashboardDoesNotExistException;
import com.grafana.api.exceptions.GrafanaException;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class GrafanaClient {

  private final String host;
  private final String apiKey;
  private final GrafanaService service;

  private static final ObjectMapper mapper =
      new ObjectMapper()
          .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
          .setSerializationInclusion(JsonInclude.Include.NON_NULL)
          .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

  /** @param configuration the information needed to communicate with Grafana. */
  public GrafanaClient(GrafanaConfiguration configuration) {
    this(configuration, createOkHttpClient());
  }

  private static OkHttpClient createOkHttpClient() {
    try {
      // Create a trust manager that does not validate certificate chains
      final TrustManager[] trustAllCerts =
          new TrustManager[] {
            new X509TrustManager() {
              @Override
              public void checkClientTrusted(
                  java.security.cert.X509Certificate[] chain, String authType) {}

              @Override
              public void checkServerTrusted(
                  java.security.cert.X509Certificate[] chain, String authType) {}

              @Override
              public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
              }
            }
          };

      // Install the all-trusting trust manager
      final SSLContext sslContext = SSLContext.getInstance("SSL");
      sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

      // Create an ssl socket factory with our all-trusting manager
      final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

      return new OkHttpClient.Builder()
          .sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0])
          .hostnameVerifier((hostname, session) -> true)
          .build();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public GrafanaClient(GrafanaConfiguration configuration, OkHttpClient client) {

    this.apiKey = configuration.apiKey();
    this.host = configuration.host();

    Retrofit retrofit =
        new Retrofit.Builder()
            .baseUrl(host)
            .client(client)
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .build();

    service = retrofit.create(GrafanaService.class);
  }

  public String getHost() {
    return host;
  }

  /**
   * Searches for an existing dashboard by name.
   *
   * @param dashboardName the name of the dashboard to search for.
   * @return {@link GrafanaDashboard} with matching name.
   * @throws GrafanaDashboardDoesNotExistException if a dashboard with matching name does not exist.
   * @throws GrafanaException if Grafana returns an error when trying to retrieve the dashboard.
   * @throws IOException if a problem occurred talking to the server.
   */
  public GrafanaDashboard getDashboard(String dashboardName)
      throws GrafanaDashboardDoesNotExistException, GrafanaException, IOException {

    Response<GrafanaDashboard> response = service.getDashboard(apiKey, dashboardName).execute();

    if (response.isSuccessful()) {
      return response.body();
    } else if (response.code() == HTTP_NOT_FOUND) {
      throw new GrafanaDashboardDoesNotExistException(
          "Dashboard " + dashboardName + " does not exist");
    } else {
      throw GrafanaException.withErrorBody(response.errorBody());
    }
  }

  public List<GrafanaSearchResult> search(String query, String tag)
      throws GrafanaException, IOException {

    Response<List<GrafanaSearchResult>> response = service.search(apiKey, query, tag).execute();

    if (response.isSuccessful()) {
      return response.body();
    } else {
      throw GrafanaException.withErrorBody(response.errorBody());
    }
  }
}
