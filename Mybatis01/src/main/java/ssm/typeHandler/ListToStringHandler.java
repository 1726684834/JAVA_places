package ssm.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ListToStringHandler extends BaseTypeHandler<List<String>> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType)
			throws SQLException {
		String p = "";
		if (parameter.size() > 0) {
			for (String s : parameter) {
				p += s + ",";
			}
			p = p.substring(0, p.length() - 1);
		}
		ps.setString(i, p);

	}

	@Override
	public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String res = rs.getString(columnName);
		return Arrays.asList(res.split(","));
	}

	@Override
	public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String res = rs.getString(columnIndex);
		return Arrays.asList(res.split(","));
	}

	@Override
	public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String res = cs.getString(columnIndex);
		return Arrays.asList(res.split(","));
	}

}
