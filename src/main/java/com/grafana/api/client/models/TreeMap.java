
package com.grafana.api.client.models;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class TreeMap implements Serializable {

    private String colorByFunction;
    private Boolean debug;
    private long depth;
    private Boolean enableGrouping;
    private Boolean enableTimeBlocks;
    private List<Group> groups;
    private List<String> ids;
    private String mode;
    private String nodeSizeProperty;
    private String sizeByFunction;

}
