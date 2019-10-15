
package com.grafana.api.client.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class Meta implements Serializable {

    private Boolean canAdmin;
    private Boolean canEdit;
    private Boolean canSave;
    private Boolean canStar;
    private String created;
    private String createdBy;
    private String expires;
    private long folderId;
    private String folderTitle;
    private String folderUrl;
    private Boolean hasAcl;
    private Boolean isFolder;
    private Boolean provisioned;
    private String provisionedExternalId;
    private String slug;
    private String type;
    private String updated;
    private String updatedBy;
    private String url;
    private long version;

}
