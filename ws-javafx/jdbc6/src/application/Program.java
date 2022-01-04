package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		/**
		 * TODO: 
		 * 1 - Conectar banco de dados
		 * 2 - Instanciar o preparedStatement (transa��o SQL)
		 * 3 - Instanciar os valores no Statement (montar os comandos SQL (atribuir os valores para cada ?))
		 * 4 - Executar os comandos com o excuteUpdate()
		 * 5 - Mostrar quantas linhas foram afetadas
		 * 6 - Fechar conexoes
		 */
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET Basesalary = 2090 WHERE DepartmentId = 1");
			
			//int x = 1;
			//if (x < 2) {
			//	throw new SQLException("Fake error");
			//}
			
			int rows2 = st.executeUpdate("UPDATE seller SET Basesalary = 3090 WHERE DepartmentId = 2");
			
			conn.commit();
			
			System.out.println("Rows 1: " + rows1);
			System.out.println("Rows 2: " + rows2);
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
			
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}	
}
