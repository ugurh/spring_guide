package io.ugurh.spring_guide.dao;

import io.ugurh.spring_guide.domain.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    final JdbcTemplate jdbcTemplate;

    public PlayerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM PLAYER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Player.class));
    }

    public Player getPlayerById(int id) {
        String sql = "SELECT * FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Player.class), new Object[]{id});
    }

    public int insertPlayer(Player player) {
        String sql = "INSERT INTO PLAYER (ID, NAME, NATIONALITY ,BIRTH_DATE, TITLE) VALUES (?, ?, ?, ?, ?)";
        try {
            return jdbcTemplate.update(sql,
                    player.getId(), player.getName(), player.getNationality(),
                    new Timestamp(player.getBirthDate().getTime()),
                    player.getTitle());
        } catch (Exception ex) {
            logger.info("Insert Player: {}", ex.getMessage());
        }
        return -1;
    }

    public int updatePlayer(Player player){
        String sql =
                "UPDATE PLAYER " +
                "SET NAME = ?, NATIONALITY = ?, BIRTH_DATE = ? , TITLE = ? " +
                "WHERE ID = ?";

        return jdbcTemplate.update( sql,
                player.getName(),
                player.getNationality(),
                new Timestamp(player.getBirthDate().getTime()),
                player.getTitle(),
                player.getId());
    }

    public int deletePlayerById(int id) {
        String sql="DELETE FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.update(sql, id);
    }

}
