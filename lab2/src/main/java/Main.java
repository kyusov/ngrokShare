import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        ProcessBuilder process = new ProcessBuilder();
        if (process.environment().get("PORT") != null) {
            port(Integer.parseInt(process.environment().get("PORT")));
        } else {
            port(8080);
        }



        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:db.sqlite");

        Gson gson = new GsonBuilder().create();

        // Fb518SnauE518Ao1 git
        // Fi42xApfn9105 heroku


        get("/profiles", (request,response) -> {
            response.type("application/json");
            PreparedStatement stmnt = conn.prepareStatement(
                    "SELECT * FROM `profile`"
            );
            ResultSet rs = stmnt.executeQuery();
            List<Profile> profiles = new ArrayList<>();
            while (rs.next()){
                profiles.add(new Profile(
                        rs.getInt("ID"),
                        rs.getString("Profile")));
            }
            return profiles;
        }, gson::toJson);


        get("/profiles/:id",(request,response)-> {

            int profileID = Integer.parseInt(request.params("id"));
            response.type("application/json");

            PreparedStatement stmnt = conn.prepareStatement(
                    "SELECT * FROM `profile` WHERE id= ?"
            );
            stmnt.setInt(1, profileID);
            ResultSet rs = stmnt.executeQuery();

            Profile profiles = new Profile();
            profiles.errorCode = 1;
            profiles.error = "Ошибка. Такого ID нет";
            if (!rs.next())
                return profiles;

            return new Profile(rs.getInt("ID"),
                    rs.getString("Profile"));
        }, gson::toJson);


        delete("/profiles/:id",(request,response)->{

            int profileID = Integer.parseInt(request.params("id"));
            response.type("application/json");

            PreparedStatement stmnt1 = conn.prepareStatement(
                    "SELECT * FROM `profile` WHERE id= ?"
            );
            stmnt1.setInt(1, profileID);

            Profile profiles = new Profile();
            profiles.errorCode = 2;
            profiles.error = "Ошибка удаления. Такого ID нет";

            ResultSet rs = stmnt1.executeQuery();
            if (!rs.next())
                return profiles;

            PreparedStatement stmnt = conn.prepareStatement(
                    "DELETE FROM `profile` WHERE `id` = ?"
            );

            stmnt.setInt(1, profileID);
            stmnt.executeUpdate();
            profiles.errorCode = 0;
            profiles.error = "";

            return profiles;

        }, gson::toJson);


        post("/profiles",(request,response)->{

            response.type("application/json");
            PreparedStatement stmnt = conn.prepareStatement(
                    "INSERT INTO `profile` (`Profile`) VALUES (?)"
            );

            Profile profile = gson.fromJson(request.body(), Profile.class);
            stmnt.setString(1, profile.profile);
            stmnt.executeUpdate();
            ResultSet rs = stmnt.getGeneratedKeys();
            rs.next();
            profile.id = rs.getInt(1);
            return profile;
        }, gson::toJson);


        put("/profiles/:id",(request,response)->{

            int profileID = Integer.parseInt(request.params("id"));

            Profile profile = gson.fromJson(request.body(), Profile.class);
            response.type("application/json");

            PreparedStatement stmnt = conn.prepareStatement(
                    "UPDATE `profile` SET `ID`=?, `Profile`=? WHERE `ID`=?"
            );
            stmnt.setInt(1, profileID);
            stmnt.setString(2, profile.profile);
            stmnt.setInt(3, profileID);
            stmnt.executeUpdate();

            return profile;
        }, gson::toJson);






/*
        get("/users", (request,response) -> {
            response.type("application/json");
            PreparedStatement stmnt = conn.prepareStatement(
                    "SELECT * FROM `users`"
            );
            ResultSet rs = stmnt.executeQuery();
            List<User> users = new ArrayList<>();
            while (rs.next()){
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name")));
            }
            return users;
        }, gson::toJson);

        get("/users/:id",(request,response)-> {
            int userID = Integer.parseInt(request.params("id"));
            response.type("application/json");
            PreparedStatement stmnt = conn.prepareStatement(
                    "SELECT * FROM `users` WHERE id= ?"
            );
            stmnt.setInt(1, userID);
            ResultSet rs = stmnt.executeQuery();
            if (!rs.next())
                return null;
            return new User(rs.getInt("id"),
                        rs.getString("name"));
        }, gson::toJson);


        delete("/users/:id",(request,response)->{
            int userID = Integer.parseInt(request.params("id"));
            response.type("application/json");
            PreparedStatement stmnt1 = conn.prepareStatement(
                    "SELECT * FROM `users` WHERE id= ?"
            );
            stmnt1.setInt(1, userID);
            User user = new User();
            user.errorCode = 1;
            ResultSet rs = stmnt1.executeQuery();
            if (!rs.next())
                return user;
            PreparedStatement stmnt = conn.prepareStatement(
                    "DELETE FROM `users` WHERE `id` = ?"
            );
            stmnt.setInt(1, userID);
            stmnt.executeUpdate();
            user.errorCode = 0;
            return user;
        }, gson::toJson);



        post("/users",(request,response)->{
            response.type("application/json");
            PreparedStatement stmnt = conn.prepareStatement(
                    "INSERT INTO `users` (`name`) VALUES (?)"
            );
            User user = gson.fromJson(request.body(), User.class);
            stmnt.setString(1, user.name);
            stmnt.executeUpdate();
            return user;
        }, gson::toJson);



        put("/users/:id",(request,response)->{
            int userID = Integer.parseInt(request.params("id"));
            User user = gson.fromJson(request.body(), User.class);
            response.type("application/json");
            PreparedStatement stmnt = conn.prepareStatement(
                    "UPDATE `users` SET `id`=?, `name`=? WHERE `id`=?"
            );
            stmnt.setInt(1, userID);
            stmnt.setString(2, user.name);
            stmnt.setInt(3, userID);
            stmnt.executeUpdate();
            return user;
        }, gson::toJson);

*/












/*
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE if not exists `users` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` text);");

        PreparedStatement ps1 = conn.prepareStatement(
                "INSERT INTO `users` (name) VALUES (?)"
        );

        ps1.setString(1, "Ivan"); // вместо первого "?" подставляется строка "Ivan"
        ps1.executeUpdate();
        ps1.setString(1, "Petr"); // вместо первого "?" подставляется строка "Petr"
        ps1.executeUpdate();

        int userId = 2;
        PreparedStatement ps2 = conn.prepareStatement(
                "SELECT * FROM `users` WHERE `id` = ?"
        );
        ps2.setInt(1, userId);
        ResultSet rs = ps2.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getInt("id") + ": " + rs.getString("name"));
        }
*/

    }

}
