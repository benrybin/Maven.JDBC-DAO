package daos;

import models.Car;

import java.sql.SQLException;
import java.util.List;

public interface Tools <T> {

    T findbyId(int id );
    List findAll() throws SQLException;
    T update(T Car);
    T create(Object car);
    void delete(int id) throws SQLException;
}
