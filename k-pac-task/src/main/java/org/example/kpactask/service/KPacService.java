package org.example.kpactask.service;

import lombok.RequiredArgsConstructor;
import org.example.kpactask.dao.jdbc.JdbcKPacDao;
import org.example.kpactask.dao.jdbc.JdbcKPacKPacSetDao;
import org.example.kpactask.dao.jdbc.JdbcKPacSetDao;
import org.example.kpactask.entity.KPac;
import org.example.kpactask.entity.KPacKPacSet;
import org.example.kpactask.entity.KPacSet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KPacService {

    private final JdbcKPacDao jdbcKPacDao;
    private final JdbcKPacSetDao jdbcKPacSetDao;
    private final JdbcKPacKPacSetDao jdbcKPacKPacSetDao;

    public void addKPac(KPac kPac) {
        if(kPac.getKPacSetId() != null) {
            KPacSet kPacSet = jdbcKPacSetDao.getById(kPac.getKPacSetId());
            jdbcKPacDao.add(kPac);
            if (kPacSet != null) jdbcKPacKPacSetDao.addKPacKPacSet(new KPacKPacSet(kPac.getKPacId(), kPacSet.getKPacSetId()));
        } else  {
            jdbcKPacDao.add(kPac);
        }
    }

    public void deleteKPac(Long id) {
        List<KPacKPacSet> kPacKPacSets = jdbcKPacKPacSetDao.getAll();
        List<Long> kPacSetIds = kPacKPacSets.stream().filter(kPacKPacSet -> kPacKPacSet.getKPacId().equals(id)).map(KPacKPacSet::getKPacSetId).toList();
        kPacSetIds.forEach(kPacSetId -> jdbcKPacKPacSetDao.deleteKPacKPacSet(id, kPacSetId));
        jdbcKPacDao.deleteById(id);
    }

    public List<KPac> getAllKPacs(){
        return jdbcKPacDao.getAll();
    }
}
