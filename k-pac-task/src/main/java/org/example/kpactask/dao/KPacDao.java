package org.example.kpactask.dao;

import org.example.kpactask.entity.KPac;

import java.util.List;

public interface KPacDao {

    void add(KPac kPac);

    List<KPac> getAll();

    KPac getById(Long id);

    Long update(KPac kPac);

    void deleteById(Long id);
}
