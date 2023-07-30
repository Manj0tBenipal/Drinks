package ca.sheridancollege.sin13014.Assignment3_Manjot_Singh.repositories;

import ca.sheridancollege.sin13014.Assignment3_Manjot_Singh.beans.Ticket;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TicketsRepo {
    private NamedParameterJdbcTemplate jdbc;

    public TicketsRepo(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public ArrayList<Ticket> getTicketsByUserName(String userName){
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "select * from Ticket where username=:un";
        parameters.addValue("un", userName);
        ArrayList<Ticket> tickets = (ArrayList<Ticket>) jdbc.query(query, parameters, new BeanPropertyRowMapper<Ticket>(Ticket.class));
        return tickets;
    }
    public Ticket getTicketById(int id){
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "select * from Ticket where id=:id";
        parameters.addValue("id", id);
        ArrayList<Ticket> tickets = (ArrayList<Ticket>) jdbc.query(query, parameters, new BeanPropertyRowMapper<Ticket>(Ticket.class));
        return tickets.get(0);
    }
    public ArrayList<Ticket> getAllTickets(){
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "select * from Ticket";

        ArrayList<Ticket> tickets = (ArrayList<Ticket>) jdbc.query(query, parameters, new BeanPropertyRowMapper<Ticket>(Ticket.class));
        return tickets;
    }
    public void addTicket(Ticket ticket){
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "Insert into Ticket(address, time, date, price, anime_group, username )" +
                " values(:ad, :time, :date, :price, :ag, :un)";
        parameters.addValue("un", ticket.getUserName());
        parameters.addValue("time", ticket.getTime());
        parameters.addValue("price", ticket.getPrice());
        parameters.addValue("ad", ticket.getAddress());
        parameters.addValue("ag", ticket.getAnimeGroup());
        parameters.addValue("date", ticket.getDate());
        jdbc.update(query, parameters);
    }

    public void deleteById(int id){
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "Delete from ticket where id=:id";
        parameters.addValue("id", id);
        jdbc.update(query, parameters);
    }
    public void updateTicket(Ticket ticket){
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "Update ticket set address=:ad, time=:time, date=:date, price=:price, anime_group=:ag, username=:un where id=:id";
        parameters.addValue("un", ticket.getUserName());
        parameters.addValue("time", ticket.getTime());
        parameters.addValue("price", ticket.getPrice());
        parameters.addValue("ad", ticket.getAddress());
        parameters.addValue("ag", ticket.getAnimeGroup());
        parameters.addValue("date", ticket.getDate());
        parameters.addValue("id", ticket.getId());
        jdbc.update(query, parameters);
    }
}
