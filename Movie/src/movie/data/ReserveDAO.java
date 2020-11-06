package movie.data;

import java.sql.Connection;

public class ReserveDAO {
    Connection con;

    public ReserveDAO() throws Exception{
        this.con = DbSingleton.getInstance();
    }


}
