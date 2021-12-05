package database.dao;

import database.DatabaseConnection;
import database.model.UserEntity;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserDao implements IDao<UserEntity> {
    DatabaseConnection connection = new DatabaseConnection();

    public UserEntity get(int id) {
        return connection.getEntityManager().find(UserEntity.class, Integer.valueOf(id));
    }

    @Override
    public List<UserEntity> getAll() {
        TypedQuery<UserEntity> query = connection.getEntityManager().createQuery("SELECT a FROM UserEntity a",
                UserEntity.class);

        return query.getResultList();
    }

    @Override
    public void update(UserEntity user) {
        connection.executeTransaction(entityManager -> entityManager.merge(user));
    }

    @Override
    public void create(UserEntity user) {
        connection.executeTransaction(entityManager -> entityManager.persist(user));
    }

    public UserEntity getUser(String username, String password) {
        Optional<UserEntity> user = null;
        try {
            user = getAll().stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findAny();

        } catch (Exception e) {
            System.out.println(e);
        }

        if (user.isPresent())
            return user.get();

        return null;
    }

    public UserEntity getUser(String username) {
        Optional<UserEntity> user = null;
        try {
            user = getAll().stream().filter(u -> u.getUsername().equals(username)).findAny();

        } catch (Exception e) {
            System.out.println(e);
        }

        if (user.isPresent())
            return user.get();

        return null;
    }

}
