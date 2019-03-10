package br.com.nielter.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.nielter.entidades.Usuario;

public class UsuarioDAO {
	
	private Connection con = conexao.getConnerction();
	
	public void cadastrar(Usuario usuario){
		//Monta SQL
		String sql = "INSERT INTO USUARIO (nome, login, senha) values (?,?,?)";
		
		//Constroe o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getUsuario());
			preparador.setString(3,usuario.getSenha());			
			preparador.execute();
			preparador.close();
			System.out.println("Cadastrado Com Sucesso");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Alterar(Usuario usuario){
		//Monta SQL
		String sql = "UPDATE USUARIO SET nome = ?, login = ?, senha = ? where id =?";
		
		//Constroe o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getUsuario());
			preparador.setString(3,usuario.getSenha());			
			preparador.setInt(4,usuario.getId());
			preparador.execute();
			preparador.close();
			System.out.println("Alterado Com Sucesso");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Excluir(Usuario usuario){
		//Monta SQL
		String sql = "DELETE FROM USUARIO where id = ?";
		
		//Constroe o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1,usuario.getId());
			preparador.execute();
			preparador.close();
			System.out.println("Excluido Com Sucesso");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Usuario> BuscarTodos(){
		//Monta SQL
		String sql = "SELECT * FROM USUARIO";
		
		List<Usuario> listaDeUsuario = new ArrayList<Usuario>();
		
		//Constroe o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			
			while (resultado.next()){
				
				Usuario usu = new Usuario();
				
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setUsuario(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));		
				
				listaDeUsuario.add(usu);
			}
			
			preparador.close();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaDeUsuario;

	}
	

	
	public Usuario BuscarPorId(Integer id){

		String sql = "SELECT * FROM USUARIO WHERE ID=?";
		Usuario usuario = null;	
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);;
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				usuario = new Usuario();
				
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setUsuario(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
			
			}
			
			preparador.close();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;

	}
	
	public Usuario Autenticar(Usuario usuario){

		String sql = "SELECT * FROM USUARIO WHERE LOGIN=? AND SENHA =?";
		Usuario usuarioRetorno = null;	
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getUsuario());
			preparador.setString(2, usuario.getSenha());
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				usuarioRetorno = new Usuario();
				
				usuarioRetorno.setId(resultado.getInt("id"));
				usuarioRetorno.setNome(resultado.getString("nome"));
				usuarioRetorno.setUsuario(resultado.getString("login"));
				usuarioRetorno.setSenha(resultado.getString("senha"));
			
			}
			
			preparador.close();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarioRetorno;

	}


}
