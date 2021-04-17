package server;


import java.sql.*;

public class SQLite {
    private static Connection connection;
    private static PreparedStatement preparedStatementNickname;
    private static PreparedStatement preparedStatementRegistration;
    private static PreparedStatement preparedStatementChangeNick;

    public static boolean connect()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            return true;



        } catch (Exception e) {
           e.printStackTrace();
           return false;
        }


    }
    public static void disconnect()
    {
        try {
            preparedStatementRegistration.close();
            preparedStatementChangeNick.close();
            preparedStatementNickname.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    private  static  void statements() throws SQLException {
        preparedStatementRegistration= connection.prepareStatement("SELECT nickname FROM users WHERE LOGIN =? AND password = ?;");
        preparedStatementChangeNick= connection.prepareStatement("INSERT INTO users(login, password, nickname) VALUES(? ,? ,? );");
        preparedStatementChangeNick= connection.prepareStatement("UPDATE users SET nickname =? WHERE nickname = ?;");
    }
    public static String nickNameByLoginAndPassword(String login, String password)
    {
        String nick = null;
        try {
            preparedStatementNickname.setString(1,login);
            preparedStatementNickname.setString(2, password);
            ResultSet rs= preparedStatementNickname.executeQuery();
            if (rs.next())
            {
                nick = rs.getString(1);
            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nick;
    }
    public static boolean register(String login, String password, String nickname)
    {
        try {
            preparedStatementRegistration.setString(1,login);
            preparedStatementRegistration.setString(2,password);
            preparedStatementRegistration.setString(3,nickname);
            preparedStatementRegistration.executeUpdate();
            return true;
        } catch (SQLException throwables) {

            throwables.printStackTrace();
            return false;
        }
    }

    public static boolean changeNick(String oldNickName, String newNickname)
    {
        try {
            preparedStatementChangeNick.setString(1,newNickname);
            preparedStatementChangeNick.setString(2,oldNickName);
            preparedStatementChangeNick.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            return false;
        }


    }
}
