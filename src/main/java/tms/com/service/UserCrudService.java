package tms.com.service;

import tms.com.domain.User;

import java.sql.*;

public class UserCrudService {

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

public User getUserById (int id) {
User user = new User();
    try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PokerAppDB", "postgres", "root")) {
        PreparedStatement statementAcc = connection.prepareStatement("SELECT * FROM user_names WHERE id=?");
        statementAcc.setInt(1, id);
        ResultSet resultSet = statementAcc.executeQuery();

        resultSet.next();
        user.setId(resultSet.getInt("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setRegDate(resultSet.getDate("registration_date"));
        user.setEmail(resultSet.getString("email"));
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

}
