package com.grafana.api.client.models;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class Panel implements Serializable {

  private String chartId;
  private List<String> colors;
  private String datasource;
  private String format;
  private GridPos gridPos;
  private long id;
  private Legend legend;
  private List<Object> links;
  private long mappingType;
  private long maxDataPoints;
  private String nullPointMode;
  private List<Object> seriesOverrides;
  private List<Target> targets;
  //    private String thresholds;
  private String title;
  private TreeMap treeMap;
  private String type;
  private List<ValueMap> valueMaps;
}
