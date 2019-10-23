/* Licensed under Apache-2.0 */
package com.grafana.api.client.models;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class GrafanaSearchResult {
  private long id;
  private Boolean isStarred;
  private String slug;
  private List<String> tags;
  private String title;
  private String type;
  private String uid;
  private String uri;
  private String url;
}
