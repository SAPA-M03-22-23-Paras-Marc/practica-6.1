package model;

import java.util.ArrayList;
import java.util.List;

public interface DAODB<T> {
    // CRUD
     boolean create(T t);
    ArrayList<T> read(T t);
    boolean update(T t);
    boolean delete(T t);
    // ALTRES
    boolean exists(T t);
    int count();
    List<T> all();
}
