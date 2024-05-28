package org.example.kpactask.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KPac {

    private Long kPacId;
    private Long kPacSetId;
    private String title;
    private String description;
    private Date createdAt;

    public KPac(Long kPacSetId, String title, String description, Date createdAt) {
        this.kPacSetId = kPacSetId;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

    public KPac(String title, String description, Date createdAt) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }
}
