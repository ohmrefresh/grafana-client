package com.grafana.api.client.models;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class Dashboard implements Serializable {

  private Annotations annotations;
  private Boolean editable;
  private Object gnetId;
  private long graphTooltip;
  private long id;
  private long iteration;
  private List<Object> links;
  private List<Panel> panels;
  private String refresh;
  private long schemaVersion;
  private String style;
  private List<String> tags;
  private Templating templating;
  private Time time;
  private Timepicker timepicker;
  private String timezone;
  private String title;
  private String uid;
  private long version;
}
