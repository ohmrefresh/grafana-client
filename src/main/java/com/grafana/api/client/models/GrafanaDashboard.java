package com.grafana.api.client.models;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class GrafanaDashboard implements Serializable {
  private Dashboard dashboard;
  private Meta meta;
}
