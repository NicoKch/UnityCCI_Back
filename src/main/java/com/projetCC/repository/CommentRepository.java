package com.projetCC.repository;

import com.projetCC.domain.Comment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentRepository implements IRepository<Comment> {

    private final String TABLE = "comments";
    private final String ID = "id";
    private final String CONTENT = "content";
    private final String AUTHOR = "author";

    @Override
    public Comment findById(int id) {
        return null;
    }

    public List<Comment> findAll() {
        String query = "SELECT * FROM " + TABLE;
        List<Comment> comments = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                comments.add(
                        new Comment(
                                resultSet.getInt(ID),
                                resultSet.getString(CONTENT),
                                resultSet.getInt(AUTHOR)
                        )
                );
            }
        } catch (SQLException e) {
            System.err.println("SQL error for query : '" + query + "'");
            System.err.println(e.getMessage());
        }
        return comments;
    }

    public Comment save(Comment comment) {
        String query = "";
        PreparedStatement statement;
        try {
            if (comment.getId() == 0) {
                query = "INSERT INTO " + TABLE + " (" + CONTENT + ", " + AUTHOR + ") VALUES (?,?)";
                statement = connection.prepareStatement(query);

            } else {
                query = "UPDATE " + TABLE + " SET " + CONTENT + " = ?, " + AUTHOR + " = ? WHERE " + ID + " = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(3, comment.getId());
            }
            statement.setString(1, comment.getContent());
            statement.setInt(2, comment.getAuthor());

            int res = statement.executeUpdate();
            if (res == 1) {
                return comment;
            } else {
                System.out.println("Probleme car aucune ligne affectée");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("SQL error for query : '" + query + "'");
            System.err.println(e.getMessage());
        }
        return null;
    }
}
