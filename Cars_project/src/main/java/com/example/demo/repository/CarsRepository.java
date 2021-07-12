package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Cars;

@Repository
public class CarsRepository {

	@Autowired
	private JdbcTemplate template;

	public int addCars(Cars car) {

		SimpleJdbcInsert inserter = new SimpleJdbcInsert(template);

		inserter.withTableName("cars").usingColumns("model", "year", "kilometers", "brand", "status");
		BeanPropertySqlParameterSource sql = new BeanPropertySqlParameterSource(car);
		return inserter.execute(sql);

	}

	public List<Cars> getAllCars() {

		String sql = "select * from cars";

		List<Cars> carsList = template.query(sql, BeanPropertyRowMapper.newInstance(Cars.class));

		return carsList;

	}

	public List<Cars> getCarStatus() {

		String sql = "select * from cars where status='UNSOLD' ";

		List<Cars> carsStatus = template.query(sql, BeanPropertyRowMapper.newInstance(Cars.class));

		return carsStatus;

	}

	public List<Cars> getsCarsByBrand(String brand) {

		String sql = "select * from cars where brand=?";
		@SuppressWarnings("deprecation")
		List<Cars> cars = template.query(sql, new Object[] { brand }, new BeanPropertyRowMapper<>(Cars.class));

		return cars;

	}

	public String[] getBrand() {
		String sql = "select distinct(brand) from cars";
		List<String> list = template.queryForList(sql, String.class);
		String[] brands = list.toArray(new String[list.size()]);

		return brands;

	}

}