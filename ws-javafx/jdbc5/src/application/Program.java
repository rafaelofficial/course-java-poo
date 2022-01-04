package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {

		/**
		 * TODO: 
		 * 1 - Conectar banco de dados
		 * 2 - Instanciar o preparedStatement (deleção SQL)
		 * 3 - Instanciar os valores no preparedStatement (montar os comandos SQL (atribuir os valores para cada ?))
		 * 4 - Executar os comandos com o excuteUpdate()
		 * 5 - Mostrar quantas linhas foram afetadas
		 * 6 - Fechar conexoes
		 */
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ?");
			st.setInt(1, 6);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}	
}
