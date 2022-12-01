
package Model;


public class Produto extends EntidadeDominio{

   private String codigo ;
   private String descricao ;
   private Double preco_compra;
   private Double preco_venda ;
   private int corredor ;
   private int andar ;
   private int coluna ;
   private String pais ;
   private String grupo ;
   private String subgrupo ;
   private String tipo ;
   private String marca ;

    public Produto() {
    }

    public Produto(int id, String codigo, String descricao, Double preco_compra, Double preco_venda, int corredor, int andar, int coluna, String pais, String grupo, String subgrupo, String tipo, String marca) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.corredor = corredor;
        this.andar = andar;
        this.coluna = coluna;
        this.pais = pais;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.tipo = tipo;
        this.marca = marca;
    }

   
   
   
   
    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco_compra(Double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public void setCorredor(int corredor) {
        this.corredor = corredor;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco_compra() {
        return preco_compra;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public int getCorredor() {
        return corredor;
    }

    public int getAndar() {
        return andar;
    }

    public int getColuna() {
        return coluna;
    }

    public String getPais() {
        return pais;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }
    
    
}
