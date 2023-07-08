package ca.sheridancollege.sin13014.repositories;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.sin13014.beans.Drink;
@Repository
public class DrinkRepository {
	private NamedParameterJdbcTemplate jdbc;
	public DrinkRepository(NamedParameterJdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	public  ArrayList<Drink> getDrinks(){
		String query = "Select * from easy_drinks";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		ArrayList<Drink> drinks= (ArrayList<Drink>)jdbc.query(query,parameters, new BeanPropertyRowMapper<Drink>(Drink.class));
		return drinks;
	}
	public void addDrink(Drink drink){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO easy_drinks (name, main1, amount1, main2, amount2, directions)   VALUES " +
				"(:na, :m1, :a1, :m2, :a2, :dir)" ;
		parameters.addValue("na", drink.getName());
		parameters.addValue("m1", drink.getMain1());
		parameters.addValue("a1", drink.getAmount1());
		parameters.addValue("m2", drink.getMain2());
		parameters.addValue("a2", drink.getAmount2());
		parameters.addValue("dir", drink.getDirections());
		jdbc.update(query, parameters);

	}
}
