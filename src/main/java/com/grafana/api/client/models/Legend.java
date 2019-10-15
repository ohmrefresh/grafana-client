
package com.grafana.api.client.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class Legend implements Serializable {

    private Boolean avg;
    private Boolean current;
    private Boolean max;
    private Boolean min;
    private Boolean show;
    private Boolean total;

}
