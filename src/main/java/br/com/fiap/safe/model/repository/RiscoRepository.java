package br.com.fiap.safe.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.safe.model.entity.Risco;

public class RiscoRepository extends Repository{

	public static Risco save(Risco risco) {
		String sql = "insert into tb_risco" + "(id_risco, id_exame, nm_nivel_risco)"
				+ " values(SQ_TB_RISCO.NEXTVAL, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, risco.getIdExame());
			ps.setString(2, risco.getNivelRisco());
			if (ps.executeUpdate() > 0) {
				return risco;
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
	
	public static ArrayList<Risco> findAll() {
		ArrayList<Risco> riscos = new ArrayList<Risco>();
		String sql = "select * from tb_risco";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Risco risco = new Risco();
					risco.setId(rs.getInt("id_risco"));
					risco.setIdExame(rs.getInt("id_exame"));
					risco.setNivelRisco(rs.getString("nm_nivel_risco"));
					riscos.add(risco);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return riscos;
	}
	
	public static Risco update(Risco risco) {
		String sql = "UPDATE tb_risco SET id_exame=?, nm_nivel_risco=? WHERE id_risco=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, risco.getIdExame());
			ps.setString(2, risco.getNivelRisco());
			ps.setInt(3, risco.getId());
			if (ps.executeUpdate() > 0) {
				return risco;
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
		String sql = "delete from tb_risco where id_risco=?";
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
