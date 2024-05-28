package org.example.kpactask.dao;

import org.example.kpactask.entity.KPacSet;

import java.util.List;

public interface KPacSetDao {

    void add(KPacSet kPacSet);

    List<KPacSet> getAll();

    KPacSet getById(Long id);

    Long update(KPacSet kPacSet);

    void deleteById(Long id);
}
