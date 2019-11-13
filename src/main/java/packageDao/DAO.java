/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
/**
 *
 * @author pedago
 */
public class DAO {
    protected final DataSource myDataSource;

	/**
	 *
	 * @param dataSource la source de données à utiliser
	 */
	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}
        
       public ArrayList<DISCOUNTIDENTITY> parcour() throws DAOException{
           ArrayList<DISCOUNTIDENTITY> code= new  ArrayList<DISCOUNTIDENTITY>() ;
       
           String sql = "SELECT * FROM DISCOUNT_CODE ";
           try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {

		
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) { // On a trouvé
					String name = rs.getString("DISCOUNT_CODE");
					float address = rs.getFloat("RATE");
					// On crée l'objet "entity"
					 
                                        code.add(new DISCOUNTIDENTITY(name, address));
				} // else on n'a pas trouvé, on renverra null
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
           return code ;
       }

        public int  add (String a,float b ) throws DAOException {
            String sql = "INSERT INTO DISCOUNT_CODE (DISCOUNT_CODE,RATE) VALUE (?,?)";
            try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
		) {
                    stmt.setString(1, a);
                    stmt.setFloat(2, b);
                    return stmt.executeUpdate();
                    
                }
           catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
        }
        
         public void supprimerCode(String codeId) throws DAOException{
    // Une requête SQL paramétrée
		String sql = "DELETE FROM Discount_Code WHERE discount_code = ?";
		try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
                        // Définir la valeur du paramètre
			stmt.setString(1, codeId);
			
			stmt.executeUpdate();

		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
        }
}
