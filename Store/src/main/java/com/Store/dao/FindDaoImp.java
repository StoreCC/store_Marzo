package com.Store.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.Store.pojo.Producto;

@Component("FindDao")
public class FindDaoImp implements FindDao {
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	

	@Override
	public List<Producto> Marca() {
		
		return jdbcTemplate.query("select * from RT_CATALOG_BRANDS", new RowMapper<Producto>(){

			@Override
			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Producto producto = new Producto();
				producto.setId(rs.getString("id"));
				producto.setBrand(rs.getString("brand"));
				return producto;
			}

		});
	}
	
	

}
