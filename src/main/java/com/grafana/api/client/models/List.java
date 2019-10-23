package com.grafana.api.client.models;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class List implements Serializable {

  private String allFormat;
  private long builtIn;
  private Current current;
  private String datasource;
  private Boolean enable;
  private Boolean hide;
  private String iconColor;
  private Boolean includeAll;
  private String label;
  private Boolean multi;
  private String name;
  private java.util.List<Object> options;
  private String query;
  private long refresh;
  private String regex;
  private Boolean skipUrlSync;
  private String type;
}
