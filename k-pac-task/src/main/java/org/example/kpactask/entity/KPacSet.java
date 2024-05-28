package org.example.kpactask.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KPacSet {

    private Long kPacSetId;
    private Long kPacId;
    private String title;
    private List<KPac> kPacs;
}
