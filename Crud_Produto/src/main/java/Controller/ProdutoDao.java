
package Controller;

import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProdutoDao {
    
     public void CadastrarProduto( Produto produto ) throws SQLException {
        String sql = "INSERT INTO `produto`("
                + "`PRO_CODIGO`, "
                + "`PRO_DESC`, "
                + "`PROD_PRECO_VENDA`, "
                + "`PROD_PRECO_COMPRA`, "
                + "`PROD_CORREDOR`, "
                + "`PROD_ANDAR`, "
                + "`PROD_COLUNA`, "
                + "`PROD_PAIS`, "
                + "`PROD_GRUPO`, "
                + "`PROD_SUB_GRUPO`, "
                + "`PROD_TIPO`, `"
                + "PROD_MARCA`) "
                + "VALUES ("
                + "?,?,?,?,?,?,?,?,?,?,?,?";

        PreparedStatement st = null;

        Connection con = null;
        con = new Conexao().getConnection();

        try {
            st = con.prepareStatement(sql);
            st.setString(1, produto.getCodigo());
            st.setString(2, produto.getDescricao());
            st.setDouble(3, produto.getPreco_venda());
            st.setDouble(4, produto.getPreco_compra());
            st.setInt(5, produto.getCorredor());
            st.setInt(5, produto.getAndar());
            st.setInt(7, produto.getColuna());
            st.setString(8, produto.getPais());
            st.setString(9, produto.getGrupo());
            st.setString(10, produto.getSubgrupo());
            st.setString(11, produto.getTipo());
            st.setString(12, produto.getMarca());
               
            st.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao Cadastrar Produto"+ex);
      
        }
    }

     
    public void DeletarProduto(Produto produto ) throws SQLException {
        String sql = "DELETE FROM produto WHERE PRO_ID = ?";

        PreparedStatement st = null;

        Connection con = null;
        con = new Conexao().getConnection();

        try {
            st = con.prepareStatement(sql);
            st.setLong(1, produto.getId());
            st.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao Deletar Produto"+ex);
       
        }
    }
    
    
    public void AtualizarProduto(Produto produto) throws SQLException {
        String sql = ""
                + "UPDATE produto SET ("
                + "PRO_CODIGO, "
                + "PRO_DESC, "
                + "PROD_PRECO_VENDA, "
                + "PROD_PRECO_COMPRA, "
                + "PROD_CORREDOR, "
                + "PROD_ANDAR, "
                + "PROD_COLUNA, "
                + "PROD_PAIS, "
                + "PROD_GRUPO, "
                + "PROD_SUB_GRUPO, "
                + "PROD_TIPO, "
                + "PROD_MARCA "
                + "FROM produto) "
                + "VALUES  "
                + "?,?,?,?,?,?,?,?,?,?,?,?"
                + "WHERE PRO_ID = ? ";

        PreparedStatement st = null;

        Connection con = null;
        con = new Conexao().getConnection();

        try {
             st = con.prepareStatement(sql);
            st.setInt(1, produto.getId());
     
            st.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Produto"+ex);
       
        }
    }
     public void ExibirProduto (Produto produto) throws SQLException {
        String sql = ""
                + "SELECT PRO_ID,"
                + "PRO_CODIGO, "
                + "PRO_DESC, "
                + "PROD_PRECO_VENDA, "
                + "PROD_PRECO_COMPRA, "
                + "PROD_CORREDOR, "
                + "PROD_ANDAR, "
                + "PROD_COLUNA, "
                + "PROD_PAIS, "
                + "PROD_GRUPO, "
                + "PROD_SUB_GRUPO, "
                + "PROD_TIPO, "
                + "PROD_MARCA "
                + "FROM produto) "; 
          

        PreparedStatement st = null;

        Connection con = null;
        con = new Conexao().getConnection();

        try {
             st = con.prepareStatement(sql);
            st.setInt(1, produto.getId());
     
            st.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Produto"+ex);
       
        }
    }
    
   
}
