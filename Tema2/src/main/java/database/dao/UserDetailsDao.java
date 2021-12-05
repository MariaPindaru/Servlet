package database.dao;

import database.DatabaseConnection;
import database.model.UserEntity;
import database.model.UserdetailsEntity;

import javax.persistence.TypedQuery;
import java.util.List;

public class UserDetailsDao implements IDao<UserdetailsEntity> {
    DatabaseConnection connection = new DatabaseConnection();

    public UserdetailsEntity get(int id) {
        return connection.getEntityManager().find(UserdetailsEntity.class, Integer.valueOf(id));
    }

    @Override
    public List<UserdetailsEntity> getAll() {
        TypedQuery<UserdetailsEntity> query = connection.getEntityManager().createQuery("SELECT a FROM UserdetailsEntity a",
                UserdetailsEntity.class);

        return query.getResultList();
    }

    @Override
    public void update(UserdetailsEntity user){
        connection.executeTransaction(entityManager -> entityManager.merge(user));
    }

    @Override
    public void create(UserdetailsEntity user) {
        connection.executeTransaction(entityManager -> entityManager.persist(user));
    }
}
