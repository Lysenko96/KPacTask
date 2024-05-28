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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KPacSetService {

    private final JdbcKPacDao jdbcKPacDao;
    private final JdbcKPacSetDao jdbcKPacSetDao;
    private final JdbcKPacKPacSetDao jdbcKPacKPacSetDao;

    public ModelAndView getModelAndViewBySets(ModelAndView modelAndView) {
        List<KPacKPacSet> kPacKPacSets = jdbcKPacKPacSetDao.getAll();
        List<KPacSet> kPacSets = jdbcKPacSetDao.getAll();
        List<KPac> kPacs = jdbcKPacDao.getAll();
        List<Long> kPacIdByKPacSet = new ArrayList<>();
        for(KPacKPacSet kPacKPacSet : kPacKPacSets) {
            Long kPacId = kPacKPacSet.getKPacId();
            kPacIdByKPacSet.add(kPacId);
        }
        modelAndView.addObject("kPacSets", kPacSets);
        modelAndView.addObject("FreeKPacs", kPacs.stream().filter(kPac -> !kPacIdByKPacSet.contains(kPac.getKPacId())).collect(Collectors.toList()));
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
        List<KPacKPacSet> kPacKPacSets = jdbcKPacKPacSetDao.getAll();
        List<KPac> kPacs = jdbcKPacDao.getAll();
        List<KPacSet> kPacSets = jdbcKPacSetDao.getAll();
        List<KPacKPacSetDto> kPacKPacSetDtos = new ArrayList<>();
        for(KPacKPacSet kPacKPacSet :kPacKPacSets) {
            Long kPacId = kPacKPacSet.getKPacId();
            Long kPacSetId = kPacKPacSet.getKPacSetId();
            kPacKPacSetDtos.add(new KPacKPacSetDto(kPacId, kPacs.get(Math.toIntExact(kPacId)-1), kPacSets.get(Math.toIntExact(kPacSetId)-1), kPacSetId));
        }
        modelAndView.addObject("kPacKPacSetDto", kPacKPacSetDtos.stream().filter(kPacKPacSetDto -> kPacKPacSetDto.getKPacSetId().equals(id)).collect(Collectors.toList()));
        return modelAndView;
    }

    public void deleteKPacSet(Long id) {
        List<KPacKPacSet> kPacKPacSets = jdbcKPacKPacSetDao.getAll();
        List<Long> kPacIds = kPacKPacSets.stream().filter(kPacKPacSet -> kPacKPacSet.getKPacSetId().equals(id)).map(KPacKPacSet::getKPacId).toList();
        kPacIds.forEach(kPacId -> jdbcKPacKPacSetDao.deleteKPacKPacSet(kPacId, id));
        jdbcKPacSetDao.deleteById(id);
    }
}
