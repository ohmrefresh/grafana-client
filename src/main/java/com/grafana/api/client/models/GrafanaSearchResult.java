/* Licensed under Apache-2.0 */
package com.grafana.api.client.models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(fluent = true)
public class GrafanaSearchResult {
  Long id;
  String title;
  String uri;
  String type;
  List<String> tags;
  Boolean isStarred;
}