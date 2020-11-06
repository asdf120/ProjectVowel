package movie.data;

import java.sql.Connection;

public class MovieDAO {
    Connection con;

    public MovieDAO(Connection con) throws Exception{
        this.con = DbSingleton.getInstance();
    }
}
