
package eng3.fatec.controle.web.vh.impl;

import java.io.IOException;

import eng3.fatec.controle.web.vh.IViewHelper;
import eng3.fatec.core.aplicacao.Resultado;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Model.EntidadeDominio;
import Model.IEntidade;
import Model.Produto;



public class ProdutoViewHelper implements IViewHelper {

	public IEntidade getEntidade(HttpServletRequest request) {
		
		
	
		String operacao = request.getParameter("operacao");
		Produto produto = null;
	
		if(!operacao.equals("VISUALIZAR")){
			String codigo = request.getParameter("txtCodigo");
			String descricao = request.getParameter("txtDescricao");
			String id = request.getParameter("txtId");
			Double preco_compra = Double.parseDouble(request.getParameter("txtPrecoCompra"));
			Double preco_venda = Double.parseDouble(request.getParameter("txtPrecoVenda"));
			String corredor = request.getParameter("txtCorredor");
			String andar = request.getParameter("txtAndar");
			String coluna = request.getParameter("txtColuna");
			String pais = request.getParameter("txtPais");
			String grupo = request.getParameter("txtGrupo");
			String subgrupo = request.getParameter("txtSubgrupo");
			String tipo = request.getParameter("txtTipo");
			String marca = request.getParameter("txtMarca");

			produto = new Produto();
			
			if(codigo != null && !codigo.trim().equals("")){
				produto.setCodigo(codigo);
			}
			
			if(descricao != null && !descricao.trim().equals("")){
				produto.setDescricao(descricao);
			}
			
			if(id != null && !id.trim().equals("")){
				produto.setId(Integer.parseInt(id));
			}
			
			if(preco_compra != null && !preco_compra.equals("")){
				produto.setPreco_compra((preco_compra));
			}
			if(preco_venda != null && !preco_venda.equals("")){
				produto.setPreco_compra((preco_venda));
			}
			if(corredor != null && !corredor.trim().equals("")){
				produto.setCorredor(Integer.parseInt(corredor));
			}
			if(andar != null && !andar.trim().equals("")){
				produto.setAndar(Integer.parseInt(andar));
			}
			if(coluna != null && !coluna.trim().equals("")){
				produto.setColuna(Integer.parseInt(coluna));
			}
			if(pais != null && !pais.trim().equals("")){
				produto.setPais(pais);
			}
			if(grupo != null && !grupo.trim().equals("")){
				produto.setGrupo(grupo);
			}
			if(subgrupo != null && !subgrupo.trim().equals("")){
				produto.setSubgrupo(subgrupo);
			}
			if(tipo != null && !tipo.trim().equals("")){
				produto.setTipo(tipo);
			}
			if(marca != null && !marca.trim().equals("")){
				produto.setMarca(marca);
			}
			
		}else{
			HttpSession session = request.getSession();
			Resultado resultado = (Resultado) session.getAttribute("resultado");
			String txtId = request.getParameter("txtId");
			int id=0;
			
			if(txtId != null && !txtId.trim().equals("")){
				id = Integer.parseInt(txtId);
			}
			
			for(EntidadeDominio e: resultado.getEntidades()){
				if(e.getId() == id){
					produto = (Produto)e;
				}
			}
		}
		
		return produto;
	}

	
	public void setView(Resultado resultado, HttpServletRequest request, 
			HttpServletResponse response)  throws ServletException {
		RequestDispatcher d=null;
		
		String operacao = request.getParameter("operacao");
		
		if(resultado.getMsg() == null){
			if(operacao.equals("SALVAR")){
				resultado.setMsg("Produto cadastrado com sucesso!");
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("INDEX.html"); 
			}			 			
		}
		
		if(resultado.getMsg() == null && operacao.equals("CONSULTAR")){		
			request.getSession().setAttribute("resultado", resultado);
			d= request.getRequestDispatcher("INDEX.html");  
		}
		
		if(resultado.getMsg() == null && operacao.equals("ALTERAR")){	
			
			request.getSession().setAttribute("resultado", resultado.getEntidades().get(0));
			
			d= request.getRequestDispatcher("INDEX.html");  
		}
		
		
		if(resultado.getMsg() == null && operacao.equals("VISUALIZAR")){
			
			request.getSession().setAttribute("produto", resultado.getEntidades().get(0));
			d= request.getRequestDispatcher("INDEX.html");  			
		}
		
		if(resultado.getMsg() == null && operacao.equals("EXCLUIR")){
			
			request.getSession().setAttribute("resultado", null);
			d= request.getRequestDispatcher("INDEX.html");  
		}
		
		if(resultado.getMsg() != null){
			if(operacao.equals("SALVAR") || operacao.equals("ALTERAR")){
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("INDEX.html");  	
			}
		}
		
		try {
			d.forward(request,response);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}


	public void setView(Resultado resultado, ServletConfig config) {
		// TODO Auto-generated method stub
		
	}

}
