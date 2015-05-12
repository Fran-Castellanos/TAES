package juego.taes.domainmodel.Data.Example;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import juego.taes.domainmodel.Data.DatabaseManager;
import juego.taes.domainmodel.Model.Example.Comment;

/**
 * Created by alienware18 on 9-8-13.
 */
public class CommentsRepository {

    private DatabaseHelperExample db;
    Dao<Comment, Integer> commentsDao;

    public CommentsRepository(Context ctx) throws SQLException {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            //db = dbManager.getHelper(ctx);
            commentsDao = db.getCommentsDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            throw e;
        }

    }

    public int create(Comment comment) throws SQLException {
        try {
            return commentsDao.create(comment);
        } catch (SQLException e) {
            // TODO: Exception Handling
            throw e;
        }
    }
    public int update(Comment comment) throws SQLException {
        try {
            return commentsDao.update(comment);
        } catch (SQLException e) {
            // TODO: Exception Handling
            throw e;
        }
    }
    public int delete(Comment comment) throws SQLException {
        try {
            return commentsDao.delete(comment);
        } catch (SQLException e) {
            // TODO: Exception Handling
            throw e;
        }
    }

    public List<Comment> getAll() throws SQLException {
        try {
            return commentsDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            throw e;
        }
    }
}
