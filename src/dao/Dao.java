package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public interface Dao {
	void open (Properties properties )throws SQLException;
	int insert(Object object)throws SQLException;
	int update(Object object)throws SQLException;
	int delete(Object object)throws SQLException;
	List<Object> select()throws SQLException;
	void close()throws SQLException;
}
