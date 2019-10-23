package com.grafana.api.client.models;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class Timepicker implements Serializable {

  private List<String> refreshIntervals;
  private List<String> timeOptions;
}
