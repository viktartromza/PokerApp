package com.tms.service;

import com.tms.domain.Game;


import java.sql.*;

public class GameCrudService {
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Game getGameById (int id) {
        Game game = new Game();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PokerAppDB", "postgres", "root")) {
            PreparedStatement statementAcc = connection.prepareStatement("SELECT * FROM games WHERE id=?");
            statementAcc.setInt(1, id);
            ResultSet resultSet = statementAcc.executeQuery();

            resultSet.next();
            game.setId(resultSet.getInt("id"));
            game.setType(resultSet.getString("type"));
            game.setDate(resultSet.getDate("date"));


        } catch (SQLException e) {
            System.out.println("something wrong....");
        }
        return game;
    }
}
