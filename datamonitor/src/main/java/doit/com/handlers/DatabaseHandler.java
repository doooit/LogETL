package doit.com.handlers;

import java.io.IOException;
import java.util.ArrayList;

import doit.com.models.domain.DataCheckRule;
import doit.com.models.mapper.DataCheckRuleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import doit.com.models.domain.DataEtlDetailInfo;
import doit.com.models.mapper.DataEtlDetailInfoMapper;

public class DatabaseHandler {
	
	private static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = "configuration.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return sessionFactory;
    }
	
	public int insertDataEtlDetailInfo(DataEtlDetailInfo info) {
		SqlSession sqlSession = getSessionFactory().openSession(true);
		
        DataEtlDetailInfoMapper infoMapper = sqlSession.getMapper(DataEtlDetailInfoMapper.class);

        return infoMapper.insert(info);
	}

    public ArrayList<DataCheckRule> selectCheckRules(String flag) {
        SqlSession sqlSession = getSessionFactory().openSession(true);

        DataCheckRuleMapper ruleMapper = sqlSession.getMapper(DataCheckRuleMapper.class);

        return ruleMapper.select(flag);
    }
}
