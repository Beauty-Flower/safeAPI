package br.com.fiap.safe.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.safe.model.entity.ContatoMedico;

public class ContatoMedicoRepository extends Repository{

	public static ContatoMedico save(ContatoMedico contatoMedico) {
		String sql = "insert into tb_contato_medico" + "(id_contato, id_medico, nr_ddi, nr_ddd, nr_telefone)"
				+ " values(SQ_TB_CONTATO_MEDICO.NEXTVAL, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, contatoMedico.getIdMedico());
			ps.setInt(2, contatoMedico.getDdi());
			ps.setInt(3, contatoMedico.getDdd());
			ps.setLong(4, contatoMedico.getTelefone());
			if (ps.executeUpdate() > 0) {
				return contatoMedico;
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
	
	public static ArrayList<ContatoMedico> findAll() {
		ArrayList<ContatoMedico> contatosMedicos = new ArrayList<ContatoMedico>();
		String sql = "select * from tb_contato_medico";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ContatoMedico contatoMedico = new ContatoMedico();
					contatoMedico.setId(rs.getInt("id_contato"));
					contatoMedico.setIdMedico(rs.getInt("id_medico"));
					contatoMedico.setDdi(rs.getInt("nr_ddi"));
					contatoMedico.setDdd(rs.getInt("nr_ddd"));
					contatoMedico.setTelefone(rs.getLong("nr_telefone"));
					contatosMedicos.add(contatoMedico);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return contatosMedicos;
	}
	
	public static ContatoMedico update(ContatoMedico contatoMedico) {
		String sql = "UPDATE tb_contato_medico SET id_medico=?, nr_ddi=?, nr_ddd=?, nr_telefone=? WHERE id_contato=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, contatoMedico.getIdMedico());
			ps.setInt(2, contatoMedico.getDdi());
			ps.setInt(3, contatoMedico.getDdd());
			ps.setLong(4, contatoMedico.getTelefone());
			ps.setInt(5, contatoMedico.getId());
			if (ps.executeUpdate() > 0) {
				return contatoMedico;
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
		String sql = "delete from tb_contato_medico where id_contato=?";
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
