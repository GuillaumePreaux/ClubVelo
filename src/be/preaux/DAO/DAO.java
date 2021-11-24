package be.preaux.DAO;

import java.sql.*;
import java.util.List;

public abstract class DAO<T> {
	protected Connection connect = null;
	 public DAO(Connection co) {
		 this.connect = co;
	 }
	 public abstract boolean create(T obj) throws Exception;
	 public abstract boolean delete(int id);
	 public abstract boolean update(T obj);
	 public abstract T find(int id);
	 public abstract List<T> getAll() throws Exception;
	}
