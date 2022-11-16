package com.example.springprojetkaddem.kaddem.Generique;

import java.util.List;

public interface IGeneriqueService <T,ID> {

  public List<T> retrieveAll();





  public T add (T entity);

  public T retrieve (ID i);

  public void remove(ID id);

}
