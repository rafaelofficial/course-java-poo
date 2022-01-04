package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {

		/**
		 * TODO: 
		 * 1 - Conectar banco de dados
		 * 2 - Instanciar o preparedStatement (insersao SQL)	
		 * 3 - Instanciar os valores no preparedStatement (montar os comandos SQL (atribuir os valores para cada (?) ))
		 * 4 - Executar os comandos com o excuteUpdate()
		 * 5 - Fechar conexoes
		 */
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"INSERT INTO seller " 
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)");
			
			st.setString(1, "Carl Purple");
			st.setString(2, "purple@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("10/04/1985").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows Affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}	
}
