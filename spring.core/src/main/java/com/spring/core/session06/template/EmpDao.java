package com.spring.core.session06.template;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.TRANSACTION_REQUIRED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.spring.core.session06.entity.Emp;

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private ComboPooledDataSource dataSource;
	
	// 多筆
	public List<Map<String, Object>> queryAll(){
		String sql = "select eid , ename , age , createtime from emp";
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Emp> queryAll2(){
		String sql = "select eid , ename , age , createtime from emp";
		RowMapper<Emp> rowMapper = (ResultSet rs, int rowNum) ->{
			Emp emp = new Emp();
			emp.setEid(rs.getInt("eid"));
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setAge(rs.getInt("age"));
			emp.setCreatetime(rs.getTimestamp("createtime"));
			return emp;
		}; 
		return jdbcTemplate.query(sql,rowMapper);
	}
	
	public List<Emp> queryAll3(){
		String sql = "select eid , ename , age , createtime from emp";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Emp.class));
	}
	
	// 單筆新增
	public int add(String ename , Integer age) {
		String sql = "insert into emp(ename , age) value(?,?)";
		int rowcount = jdbcTemplate.update(sql,ename,age);
		return rowcount;
	}
	
	public int add2(String ename , Integer age) {
		String sql = "insert into emp(ename , age) value(:ename,:age)";
		MapSqlParameterSource parms = new MapSqlParameterSource();
		parms.addValue("ename", ename);
		parms.addValue("age"  , age);
		int rowcount = namedParameterJdbcTemplate.update(sql, parms);
		return rowcount;
	}
	
	// 多筆新增
	public int[] batchAdd1(List<Object[]> rows) {
		String sql = "insert into emp(ename , age) value(?,?)";
		return jdbcTemplate.batchUpdate(sql,rows);
	}
	
	public int[] batchAdd2(List<Emp> emps) {
		String sql = "insert into emp(ename , age) value(?,?)";
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, emps.get(i).getEname());
				ps.setInt(2, emps.get(i).getAge());
			}
			
			@Override
			public int getBatchSize() {
				
				return emps.size();
			}
		};
		return jdbcTemplate.batchUpdate(sql,setter);
	}
	
	// 修改
	public int update(String ename , Integer age , Integer eid) {
		
		String sql = "update emp set ename=? , age=? where eid=?";
		return jdbcTemplate.update(sql,ename , age , eid);
	}
	
	// 刪除
    public int delete(Integer eid) {
		String sql = "Delete from emp where eid=?";
		return jdbcTemplate.update(sql,eid);
	}
    
    // 單筆查詢
    public Emp getById(Integer eid) {
    	String sql = "select eid , ename , age , createtime from emp where eid=?";
    	return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class) ,eid);
    }
    
    // 交易模式(手動)
    public int[] addTwo(String ename1 , Integer age1 , String ename2 , Integer age2 ) {
    	int[] rowcount = new int[2];
    	
    	// 宣告 DataSourceTransactionManager 
    	DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
    	
    	// 定義 TransactionManger
    	DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        
        // 狀態
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
			String sql = "insert into emp(ename , age) values(?,?)";
			rowcount[0] = jdbcTemplate.update(sql,ename1 , age1);
			rowcount[1] = jdbcTemplate.update(sql,ename2 , age2);
		} catch (Exception e) {
			transactionManager.rollback(status);
			System.out.println("新增失敗");
		}
        transactionManager.commit(status);
        System.out.println("新增成功");
    	return rowcount;
    }
    
    
}
