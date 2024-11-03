package lk.ijse.dao;

import lk.ijse.entity.Student;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    public boolean save(T entity);

    public boolean update(T entity);

    public boolean delete(String id);

    List<T> getAll();
}
