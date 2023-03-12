package com.tms.service;

import com.tms.domain.User;
import com.tms.domain.Wallet;

import java.sql.*;

public class UserCrudService {

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        User user = new User(new Wallet());
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PokerAppDB", "postgres", "root")) {
            PreparedStatement statementAcc = connection.prepareStatement("SELECT * FROM user_names WHERE id=?");
            statementAcc.setInt(1, id);
            ResultSet resultSet = statementAcc.executeQuery();

            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRegDate(resultSet.getDate("registration_date"));
            user.setEmail(resultSet.getString("e_mail"));
            user.setScore(resultSet.getInt("score"));

            PreparedStatement statementUserData = connection.prepareStatement("SELECT * FROM users_data WHERE user_id=?");
            statementUserData.setInt(1, id);
            ResultSet resultSetUD = statementUserData.executeQuery();

            resultSetUD.next();
            user.setFirstName(resultSetUD.getString("first_name"));
            user.setLastName(resultSetUD.getString("last_name"));
            user.setBirthDay(resultSetUD.getDate("date_of_birth"));
            user.setTelephone(resultSetUD.getString("telephone"));
            user.setBalance(resultSetUD.getDouble("balance"));


        } catch (SQLException e) {
            System.out.println("something wrong....");
        }
        return user;
    }

    public boolean createUser(String login, String password, String email) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movie_db", "postgres", "root")) {

            PreparedStatement statement = connection.prepareStatement("with rows as (INSERT INTO user_names (id, login, password, registration_date, score, e_mail) " +
                    "VALUES (DEFAULT, ?, ?, ?,  DEFAULT, ?) RETURNING id) INSERT INTO users_data (id) SELECT id FROM ROWS");
            statement.setString(1, login);
            statement.setString(2, password);
            statement.setDate(3, new Date((new java.util.Date()).getTime()));
            statement.setString(4, email);
            result = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("something wrong....");
        }
        return result == 1;
    }

   //public boolean updateUser(int id, String firstName, String lastName, String login, String password, String email, String telephoneNumber) {
   //    int result = 0;
   //    try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movie_db", "postgres", "root")) {
   //
   //        PreparedStatement statement = connection.prepareStatement("UPDATE user_table SET first_name=?, last_name=?, login=?, password=?, changed=?,email=?,birthday_date=?, telephone=? WHERE id=?");
   //        statement.setString(1, firstName);
   //        statement.setString(2, lastName);
   //        statement.setString(3, login);
   //        statement.setString(4, password);
   //        statement.setDate(5, new Date((new java.util.Date()).getTime()));
   //        statement.setString(6, email);
   //        statement.setDate(7, new Date((new java.util.Date()).getTime())); //TODO: CHANGE DATE
   //        statement.setString(8, telephoneNumber); //TODO + to _
   //        statement.setInt(9, id);
   //
   //        result = statement.executeUpdate();
   //    } catch (SQLException e) {
   //        System.out.println("something wrong....");
   //    }
   //    return result == 1;
   //}
   //
   //public boolean deleteUser(int id) {
   //    int result = 0;
   //    try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movie_db", "postgres", "root")) {
   //
   //        PreparedStatement statement = connection.prepareStatement("UPDATE user_table SET is_deleted=true WHERE id=?");
   //        statement.setInt(1, id);
   //        result = statement.executeUpdate();
   //    } catch (SQLException e) {
   //        System.out.println("something wrong....");
   //    }
   //    return result == 1;
   //}
}
