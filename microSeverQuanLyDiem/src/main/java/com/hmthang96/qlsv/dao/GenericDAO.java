package com.hmthang96.qlsv.dao;

import javax.swing.tree.RowMapper;
import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, RowMapper rowMapper, Object... parameters);
    void update (String sql, Object... parameters);
    Long insert (String sql, Object... parameters);
    int count(String sql, Object... parameters);
}
