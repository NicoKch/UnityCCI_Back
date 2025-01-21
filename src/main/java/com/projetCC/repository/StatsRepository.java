package com.projetCC.repository;
import com.projetCC.domain.Stats;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatsRepository implements IRepository<Stats> {

    private final String TABLE = "stats";
    private final String ID = "id";
    private final String LEVEL = "level";
    private final String DEATHCOUNT = "deathcount";
    private final String PLAYTIME = "playtime";
    private final String RANK = "rank";
    private final String POWER = "power";
    private final String USER_ID = "user_id";





    public Stats getPlayerStat(int id) {
        String query = "SELECT * FROM " + TABLE + " WHERE " + USER_ID + " = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Stats(
                    resultSet.getInt(ID),
                    resultSet.getInt(LEVEL),
                    resultSet.getInt(DEATHCOUNT),
                    resultSet.getInt(PLAYTIME),
                    resultSet.getInt(RANK),
                    resultSet.getInt(POWER),
                    resultSet.getInt(USER_ID)
                );
            } else {
                System.out.println("Stats not found for user_id : " + id);
            }


        }  catch (SQLException e) {
            System.err.println("SQL error for query : " + query);
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Stats findById(int id) {
        return null;
    }
}
