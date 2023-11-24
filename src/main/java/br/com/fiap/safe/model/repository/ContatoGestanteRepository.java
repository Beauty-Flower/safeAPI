package br.com.fiap.safe.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.safe.model.entity.ContatoGestante;

public class ContatoGestanteRepository extends Repository{

	public static ContatoGestante save(ContatoGestante contatoGestante) {
		String sql = "insert into tb_contato_gestante" + "(id_contato, id_gestante, nr_ddi, nr_ddd, nr_telefone)"
				+ " values(SQ_TB_CONTATO_GESTANTE.NEXTVAL, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, contatoGestante.getIdGestante());
			ps.setInt(2, contatoGestante.getDdi());
			ps.setInt(3, contatoGestante.getDdd());
			ps.setLong(4, contatoGestante.getTelefone());
			if (ps.executeUpdate() > 0) {
				return contatoGestante;
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
	
	public static ArrayList<ContatoGestante> findAll() {
		ArrayList<ContatoGestante> contatosGestantes = new ArrayList<ContatoGestante>();
		String sql = "select * from tb_contato_gestante";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ContatoGestante contatoGestante = new ContatoGestante();
					contatoGestante.setId(rs.getInt("id_contato"));
					contatoGestante.setIdGestante(rs.getInt("id_gestante"));
					contatoGestante.setDdi(rs.getInt("nr_ddi"));
					contatoGestante.setDdd(rs.getInt("nr_ddd"));
					contatoGestante.setTelefone(rs.getLong("nr_telefone"));
					contatosGestantes.add(contatoGestante);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return contatosGestantes;
	}
	
	public static ContatoGestante update(ContatoGestante contatoGestante) {
		String sql = "UPDATE tb_contato_gestante SET id_gestante=?, nr_ddi=?, nr_ddd=?, nr_telefone=? WHERE id_contato=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, contatoGestante.getIdGestante());
			ps.setInt(2, contatoGestante.getDdi());
			ps.setInt(3, contatoGestante.getDdd());
			ps.setLong(4, contatoGestante.getTelefone());
			ps.setInt(5, contatoGestante.getId());
			if (ps.executeUpdate() > 0) {
				return contatoGestante;
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
		String sql = "delete from tb_contato_gestante where id_gestante=?";
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
