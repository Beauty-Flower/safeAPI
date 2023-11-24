package br.com.fiap.safe.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.safe.model.entity.EnderecoGestante;

public class EnderecoGestanteRepository extends Repository{

	public static EnderecoGestante save(EnderecoGestante enderecoGestante) {
		String sql = "insert into tb_endereco_gestante" + "(id_endereco, id_gestante, nm_logradouro, nr_logradouro, nm_cidade, nm_bairr0, nm_estado)"
				+ " values(SQ_TB_ENDERECO_GESTANTE.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, enderecoGestante.getIdGestante());
			ps.setString(2, enderecoGestante.getNomeLogradouro());
			ps.setInt(3, enderecoGestante.getNumeroLogradouro());
			ps.setString(4, enderecoGestante.getCidade());
			ps.setString(5, enderecoGestante.getBairro());
			ps.setString(6, enderecoGestante.getEstado());
			if (ps.executeUpdate() > 0) {
				return enderecoGestante;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public static ArrayList<EnderecoGestante> findAll() {
		ArrayList<EnderecoGestante> enderecosGestantes = new ArrayList<EnderecoGestante>();
		String sql = "select * from tb_endereco_gestante";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					EnderecoGestante enderecoGestante = new EnderecoGestante();
					enderecoGestante.setId(rs.getInt("id_endereco"));
					enderecoGestante.setIdGestante(rs.getInt("id_gestante"));
					enderecoGestante.setNomeLogradouro(rs.getString("nm_logradouro"));
					enderecoGestante.setNumeroLogradouro(rs.getInt("nr_logradouro"));
					enderecoGestante.setCidade(rs.getString("nm_cidade"));
					enderecoGestante.setBairro(rs.getString("nm_bairr0"));
					enderecoGestante.setEstado(rs.getString("nm_estado"));
					enderecosGestantes.add(enderecoGestante);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return enderecosGestantes;
	}
	
	public static EnderecoGestante update(EnderecoGestante enderecoGestante) {
		String sql = "UPDATE tb_endereco_gestante SET id_gestante=?, nm_logradouro=?, nr_logradouro=?, nm_cidade=?, nm_bairr0=?, nm_estado=? WHERE id_endereco=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, enderecoGestante.getIdGestante());
			ps.setString(2, enderecoGestante.getNomeLogradouro());
			ps.setInt(3, enderecoGestante.getNumeroLogradouro());
			ps.setString(4, enderecoGestante.getCidade());
			ps.setString(5, enderecoGestante.getBairro());
			ps.setString(6, enderecoGestante.getEstado());
			ps.setInt(7, enderecoGestante.getId());
			if (ps.executeUpdate() > 0) {
				return enderecoGestante;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public static boolean delete(int id) {
		String sql = "delete from tb_endereco_gestante where id_endereco=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao deletar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return false;
	}
}
