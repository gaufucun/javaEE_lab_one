package load;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class infoSQLDAO {

	public static void main(String[] args) {

		System.out.println(new infoSQLDAO().ListStudentInfo().size());

	}

	public List<infoSQL> ListStudentInfo() {
		List<infoSQL> products = new ArrayList<infoSQL>();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8",
					"root", "root");

			String sql = "select * from studetail";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				infoSQL infomation = new infoSQL();
				int id = rs.getInt(1);// 可以使用字段名
				String detail = rs.getString(2);// 也可以使用字段的顺序

				infomation.setId(id);
				infomation.setDetail(detail);

				products.add(infomation);

			}

			ps.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	// 新增一条信息
	public void AddStudentInfo(infoSQL teacher) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8",
					"root", "root");

			String sql = "insert into studetail  values(" + teacher.getId() + ",'" + teacher.getDetail() + "' )";

			Statement statement = c.createStatement();
			statement.execute(sql);

			statement.close();

			c.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
