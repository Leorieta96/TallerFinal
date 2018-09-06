package dao;

import java.util.List;


public interface DAO<T, K>{ 
    
    void insertar(T a);
    void eliminar (T a);
    void modificar (T a);
    List<T> obtenerTodos();
    T obtener(K id); //hjkhkh
    //kllk
    
}
