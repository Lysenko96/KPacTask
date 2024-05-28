package org.example.kpactask.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KPacKPacSet {

    private Long id;
    private Long KPacId;
    private Long KPacSetId;

    public KPacKPacSet(Long KPacId, Long KPacSetId) {
        this.KPacId = KPacId;
        this.KPacSetId = KPacSetId;
    }
}
