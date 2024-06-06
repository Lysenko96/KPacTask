package org.example.kpactask.service;

import lombok.RequiredArgsConstructor;
import org.example.kpactask.dao.jdbc.JdbcKPacDao;
import org.example.kpactask.dao.jdbc.JdbcKPacKPacSetDao;
import org.example.kpactask.dao.jdbc.JdbcKPacSetDao;
import org.example.kpactask.entity.KPac;
import org.example.kpactask.entity.KPacKPacSet;
import org.example.kpactask.entity.KPacKPacSetDto;
import org.example.kpactask.entity.KPacSet;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KPacSetService {

    private final JdbcKPacDao jdbcKPacDao;
    private final JdbcKPacSetDao jdbcKPacSetDao;
    private final JdbcKPacKPacSetDao jdbcKPacKPacSetDao;

    public ModelAndView getModelAndViewBySets(ModelAndView modelAndView) {
        List<KPacSet> kPacSets = jdbcKPacSetDao.getAll();
        List<KPacKPacSet> kPacKPacSets = jdbcKPacKPacSetDao.getAll();
        Set<Long> kPacIds = kPacKPacSets.stream().map(KPacKPacSet::getKPacId).collect(Collectors.toSet());
        List<KPac> freeKPacs = jdbcKPacDao.getAllWithoutSetId(kPacIds);
        modelAndView.addObject("kPacSets", kPacSets);
        modelAndView.addObject("FreeKPacs", freeKPacs);
        return modelAndView;
    }

    public void addKPacSet(KPacSet kPacSet) {
        jdbcKPacSetDao.add(kPacSet);
        if(kPacSet.getKPacId() != null) {
            KPac kPac = jdbcKPacDao.getById(kPacSet.getKPacId());
            if (kPac != null) jdbcKPacKPacSetDao.addKPacKPacSet(new KPacKPacSet(kPac.getKPacId(), kPacSet.getKPacSetId()));
        }
    }

    public ModelAndView getSetById(Long id, ModelAndView modelAndView) {
        KPacSet kPacSet = jdbcKPacSetDao.getById(id);
        List<KPacKPacSet> kPacKPacSets = jdbcKPacKPacSetDao.getAllKPacByIdSet(id);
        Set<Long> kPacIds = kPacKPacSets.stream().map(KPacKPacSet::getKPacId).collect(Collectors.toSet());
        List<KPac> kPacs = jdbcKPacDao.getAllBySetId(kPacIds);
        List<KPacKPacSetDto> kPacKPacSetDtos = new ArrayList<>();
        for(KPacKPacSet kPacKPacSet : kPacKPacSets) {
            Long kPacId = kPacKPacSet.getKPacId();
            kPacKPacSetDtos.add(new KPacKPacSetDto(kPacId,
                    kPacs.stream().filter(kPac -> kPac.getKPacId().equals(kPacId)).findAny().orElse(null),
                    kPacSet,
                    id));
        }
        modelAndView.addObject("kPacKPacSetDto", kPacKPacSetDtos);
        return modelAndView;
    }

    public void deleteKPacSet(Long id) {
        jdbcKPacKPacSetDao.deleteKPacKPacSetByIdSet(id);
        jdbcKPacSetDao.deleteById(id);
    }
}