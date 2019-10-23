package com.grafana.api.client.models;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class Time implements Serializable {

  private String from;
  private String to;
}
