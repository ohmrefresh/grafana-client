package com.grafana.api.client.models;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class Target implements Serializable {

  private String expr;
  private String format;
  private long intervalFactor;
  private String legendFormat;
  private String metric;
  private String refId;
  private long step;
}
