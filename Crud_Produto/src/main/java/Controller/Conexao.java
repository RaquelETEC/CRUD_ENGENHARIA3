
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


 public class Conexao {
    public Connection getConnection(){
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/eng","root",null);
            
        } catch (SQLException ex) {
            System.out.println("erro no localhost"+ex);
        }
        
        return conexao;
      }
    
    /*
    SQL 
    
CREATE DATABASE eng; 


CREATE TABLE eng.produto ( 
PRO_ID INT NOT NULL AUTO_INCREMENT ,
PRO_CODIGO VARCHAR(20) NOT NULL ,
PRO_DESC VARCHAR(150) NOT NULL , 
PROD_PRECO_VENDA DOUBLE(12,2) NOT NULL ,
PROD_PRECO_COMPRA DOUBLE(12,2) NOT NULL ,
PROD_CORREDOR INT NOT NULL ,
PROD_ANDAR INT NOT NULL ,
PROD_COLUNA INT NOT NULL ,
PROD_PAIS VARCHAR NOT NULL ,
PROD_GRUPO VARCHAR NOT NULL ,
PROD_SUB_GRUPO VARCHAR NOT NULL ,
PROD_TIPO VARCHAR NOT NULL ,
PROD_MARCA VARCHAR NOT NULL ,
PRIMARY KEY (PRO_ID))

*/
    }
