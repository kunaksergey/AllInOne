package ua.shield.hw01032017.service;

import ua.shield.hw01032017.entity.Stock;

import java.util.List;

/**
 * Created by sa on 01.03.17.
 */
public interface IService<T> {
    void save(T obj);
    List<T> findAll();
    T findById(int id);
    void delete(T obj);

}
