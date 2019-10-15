
package com.grafana.api.client.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class GrafanaDashboard implements Serializable {
    private Dashboard dashboard;
    private Meta meta;

}
