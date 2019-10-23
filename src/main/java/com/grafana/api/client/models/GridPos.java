package com.grafana.api.client.models;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class GridPos implements Serializable {

  private long h;
  private long w;
  private long x;
  private long y;
}
