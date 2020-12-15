package board.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("empDAO")
public class EmpDAOImpl { // 이름 설정따로 안해주면 empDAOImpl

    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<HashMap> selectEmp(){
        System.out.println("EmpDAOImpl 17line : selectEmp()");
        return sqlSession.selectList("EmpDAO.selectEmp");
    }

}
