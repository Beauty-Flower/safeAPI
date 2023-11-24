package br.com.fiap.safe.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.safe.model.entity.Medico;

public class MedicoRepository extends Repository{

	public static Medico save(Medico medico) {
		String sql = "insert into tb_medico" + "(id_medico, nm_medico, nr_crm, ds_email, ds_senha)"
				+ " values(SQ_TB_MEDICO.NEXTVAL, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, medico.getNome());
			ps.setLong(2, medico.getCrm());
			ps.setString(3, medico.getEmail());
			ps.setString(4, medico.getSenha());
			if (ps.executeUpdate() > 0) {
				return medico;
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
	
	public static ArrayList<Medico> findAll() {
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		String sql = "select * from tb_medico";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Medico medico = new Medico();
					medico.setId(rs.getInt("id_medico"));
					medico.setNome(rs.getString("nm_medico"));
					medico.setCrm(rs.getLong("nr_crm"));
					medico.setEmail(rs.getString("ds_email"));
					medico.setSenha(rs.getString("ds_senha"));
					medicos.add(medico);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return medicos;
	}
	
	public static Medico update(Medico medico) {
		String sql = "UPDATE tb_medico SET nm_medico=?, nr_crm=?, ds_email=?, ds_senha=? WHERE id_medico=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, medico.getNome());
			ps.setLong(2, medico.getCrm());
			ps.setString(3, medico.getEmail());
			ps.setString(4, medico.getSenha());
			ps.setInt(5, medico.getId());
			if (ps.executeUpdate() > 0) {
				return medico;
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
		String sql = "delete from tb_medico where id_medico=?";
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
