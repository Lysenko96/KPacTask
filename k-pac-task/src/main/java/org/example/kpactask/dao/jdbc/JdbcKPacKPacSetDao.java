package org.example.kpactask.dao.jdbc;

import lombok.RequiredArgsConstructor;
import org.example.kpactask.entity.KPacKPacSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JdbcKPacKPacSetDao {

    private static final String ADD_K_PAC_K_PAC_SETS = "INSERT INTO k_pac_k_pac_sets(k_pac_id, k_pac_set_id) VALUES (?,?)";
    private static final String GET_K_PAC_K_PAC_SETS = "SELECT * FROM k_pac_k_pac_sets";
    private static final String GET_K_PAC_K_PAC_SETS_BY_ID_SET = "SELECT * FROM k_pac_k_pac_sets WHERE k_pac_set_id=?";
    private static final String DELETE_K_PAC_K_PAC_SETS_BY_ID_SET = "DELETE FROM k_pac_k_pac_sets WHERE k_pac_id=? AND k_pac_set_id=?";

    private final JdbcTemplate jdbcTemplate;

    public void addKPacKPacSet(KPacKPacSet kPacKPacSet) {
        jdbcTemplate.update(conn -> {
            PreparedStatement st = conn.prepareStatement(ADD_K_PAC_K_PAC_SETS);
            st.setLong(1, kPacKPacSet.getKPacId());
            st.setLong(2, kPacKPacSet.getKPacSetId());
            return st;
        });
    }


    public List<KPacKPacSet> getAll() {
        return jdbcTemplate.query(GET_K_PAC_K_PAC_SETS, (rs, rowNum) -> {
            Long id = rs.getLong("k_pac_id");
            Long id_set = rs.getLong("k_pac_set_id");
            return new KPacKPacSet(id, id_set);
        });
    }

    public KPacKPacSet getAllKPacByIdSet(Long idSet) {
        return jdbcTemplate.queryForObject(GET_K_PAC_K_PAC_SETS_BY_ID_SET, (rs, rowNum) -> {
            Long id = rs.getLong("k_pac_id");
            Long id_set = rs.getLong("k_pac_set_id");
            return new KPacKPacSet(id, id_set);
        }, idSet);
    }

    public void deleteKPacKPacSet(Long kPacId, Long kPacSetId) {
        jdbcTemplate.update(DELETE_K_PAC_K_PAC_SETS_BY_ID_SET, kPacId, kPacSetId);
    }
}