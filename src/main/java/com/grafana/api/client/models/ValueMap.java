package com.grafana.api.client.models;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class ValueMap implements Serializable {

  private String op;
  private String text;
  private String value;
}
