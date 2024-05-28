package org.example.kpactask.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KPacKPacSetDto {
    private Long id;
    private Long KPacId;
    private KPac kPac;
    private KPacSet kPacSet;
    private Long KPacSetId;

    public KPacKPacSetDto(Long KPacId, Long KPacSetId) {
        this.KPacId = KPacId;
        this.KPacSetId = KPacSetId;
    }

    public KPacKPacSetDto(Long KPacId, KPac kPac, KPacSet kPacSet, Long KPacSetId) {
        this.KPacId = KPacId;
        this.kPac = kPac;
        this.kPacSet = kPacSet;
        this.KPacSetId = KPacSetId;
    }
}
