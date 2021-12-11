package com.zhang.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class MyStringTypeHandler implements TypeHandler<String>{

	@Override
	public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("开始设置");
		ps.setString(i, parameter);
		System.out.println("结束转化");
	}

	@Override
	public String getResult(ResultSet rs, String columnName) throws SQLException {
		String res=rs.getString(columnName);
		return res;
	}

	@Override
	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		String res=rs.getString(columnIndex);
		return res;
	}

	@Override
	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String res=cs.getString(columnIndex);
		return res;
	}

}
