package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		 * 4 - Inserçao com recuperaçao de Id (Statement.RETURN_GENERETED_KEYS)
		 * 5 - Executar os comandos com o excuteUpdate()
		 * 6 - Fazer tratamento para que, caso uma linha seja alterada exibir o id inserido:
		 * Se rowsAffect for maior do que 0 então mostrar a chave que foi gerada. 
		 * Senão mostrar mensagem informando que nenhuma linha foi aferada. 
		 * 7 - Fechar conexoes
		 */
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			/*
			st = conn.prepareStatement(
					"INSERT INTO seller " 
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, "Carl Purple");
			st.setString(2, "purple@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("10/04/1985").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);
			*/
			
			// insere um ou mais valores
			st = conn.prepareStatement(
					"insert into department (Name) values ('D1'), ('D2')",
					Statement.RETURN_GENERATED_KEYS);
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
			} else {
				System.out.println("No rown affected!");
			}
 		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}	
}
