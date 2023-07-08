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
		String query = "INSERT INTO easy_drinks (name, main1, amount1, main2, amount2, directions, iURL)   VALUES " +
				"(:na, :m1, :a1, :m2, :a2, :dir, :iURL)" ;
		parameters.addValue("na", drink.getName());
		parameters.addValue("m1", drink.getMain1());
		parameters.addValue("a1", drink.getAmount1());
		parameters.addValue("m2", drink.getMain2());
		parameters.addValue("a2", drink.getAmount2());
		parameters.addValue("dir", drink.getDirections());
		parameters.addValue("iURL", drink.getiURL());
		jdbc.update(query, parameters);

	}

	public Drink findById(int id){
		String query = "select * from easy_drinks where id=:id";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		ArrayList<Drink> drinks = (ArrayList<Drink>)jdbc.query(query,parameters,new BeanPropertyRowMapper<>(Drink.class));
		Drink drink = drinks.get(0);
		return drink;
	}
	public void updateDrink(Drink drink){
		MapSqlParameterSource parameters =  new MapSqlParameterSource();
		String query = "Update easy_drinks set name=:na, amount1=:a1, main1=:m1, main2=:m2, amount2=:a2, directions=:dir, iURL=:iURL where id=:id;";
		parameters.addValue("id", drink.getId());
		parameters.addValue("na", drink.getName());
		parameters.addValue("m1", drink.getMain1());
		parameters.addValue("a1", drink.getAmount1());
		parameters.addValue("m2", drink.getMain2());
		parameters.addValue("a2", drink.getAmount2());
		parameters.addValue("dir", drink.getDirections());
		parameters.addValue("iURL", drink.getiURL());
		jdbc.update(query, parameters);
	}

	public void deleteById(int id){
		MapSqlParameterSource parameters =  new MapSqlParameterSource();
		String query = "DELETE FROM easy_drinks where id=:id;";
		parameters.addValue("id", id);
		jdbc.update(query, parameters);
	}
}
