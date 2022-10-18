package com.magerwa.util.audit;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditingDTO {
    private String createdBy;
    private String updatedBy;
    private boolean isDeleted;
}
