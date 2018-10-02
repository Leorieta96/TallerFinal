package dao;

import modelo.Catalogo;

public interface CatalogoDAO extends DAO<Catalogo, Long>{

    public Long getIdGenerated();
    
}
