package org.example.kpactask.dao.jdbc;

import lombok.RequiredArgsConstructor;
import org.example.kpactask.dao.KPacDao;
import org.example.kpactask.entity.KPac;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JdbcKPacDao implements KPacDao {

    private static final String GET_K_PAC = "SELECT * FROM k_pac WHERE k_pac_id=?";
    private static final String GET_K_PACS = "SELECT * FROM k_pac";
    private static final String UPDATE_K_PAC = "UPDATE k_pac SET title=?, description=?, createdAt=? WHERE k_pac_id=?";
    private static final String DELETE_K_PAC = "DELETE FROM k_pac WHERE k_pac_id=?";

    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<KPac> rowMapper = new BeanPropertyRowMapper<>(KPac.class);

    @Override
    public void add(KPac kPac) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("k_pac");
        simpleJdbcInsert.usingGeneratedKeyColumns("k_pac_id");
        simpleJdbcInsert.usingColumns("title", "description", "createdAt");
        Map<String, Object> params = new HashMap<>();
        params.put("kPacId", kPac.getKPacId());
        params.put("title", kPac.getTitle());
        params.put("description", kPac.getDescription());
        params.put("createdAt", kPac.getCreatedAt());
        kPac.setKPacId(simpleJdbcInsert.executeAndReturnKey(params).longValue());
    }

    @Override
    public List<KPac> getAll() {
        return jdbcTemplate.query(GET_K_PACS, rowMapper);
//                (rs, rowNum) -> {
//            Long id = rs.getLong("k_pac_id");
//            String title = rs.getString("title");
//            String description = rs.getString("description");
//            Date createdAt = rs.getDate("createdAt");
//            return new KPac(id, title, description, createdAt);
//        });
    }

    @Override
    public KPac getById(Long id) {
        return jdbcTemplate.queryForObject(GET_K_PAC, rowMapper, id);
    }

    @Override
    public Long update(KPac kPac) {
        jdbcTemplate.update(UPDATE_K_PAC, kPac.getTitle(), kPac.getDescription(), kPac.getCreatedAt(), kPac.getKPacId());
        return kPac.getKPacId();
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_K_PAC, id);
    }
}
