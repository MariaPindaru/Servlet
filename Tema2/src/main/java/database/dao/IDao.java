package database.dao;

import java.util.List;

public interface IDao<T> {
    T get(int id);
    List<T> getAll ();
    void create (T t);
    void update (T t);
}