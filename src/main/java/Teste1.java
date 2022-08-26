import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;



public class Teste1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/","SA","");
			Statement stmt = connection.createStatement();
				int re = 8;
				String nome = "nnnn','2000-05-05',1000);DROP TABLE TESTE;INSERT INTO FUNCIONARIOS VALUES(10,'sss";
				String dataAdmissao = "2000-01-01";
				double salario = 3333;
				System.out.println(re+" "+nome+" "+dataAdmissao+" "+salario);
				String sql = "INSERT INTO FUNCIONARIOS VALUES("+re+",'"+nome+"','"
						+ dataAdmissao +"', "+salario+")";
				System.out.println(sql);
			stmt.executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
