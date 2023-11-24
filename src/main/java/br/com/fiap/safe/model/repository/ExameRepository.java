package br.com.fiap.safe.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.safe.model.entity.Exame;

public class ExameRepository extends Repository{

	public static Exame save(Exame exame) {
		String sql = "insert into tb_exame" + "(id_exame, id_consulta, nr_pressao_sistolica, nr_pressao_diastolica, nr_nivel_glicose, nr_temp_corporal, nr_freq_cardiaca)"
				+ " values(SQ_TB_EXAME.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, exame.getIdConsulta());
			ps.setInt(2, exame.getPressaoSistolica());
			ps.setInt(3, exame.getPressaoDiastolica());
			ps.setInt(4, exame.getNivelGlicose());
			ps.setInt(5, exame.getTemperaturaCorporal());
			ps.setInt(6, exame.getFrequenciaCardiaca());
			if (ps.executeUpdate() > 0) {
				return exame;
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
	
	public static ArrayList<Exame> findAll() {
		ArrayList<Exame> exames = new ArrayList<Exame>();
		String sql = "select * from tb_exame";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Exame exame = new Exame();
					exame.setId(rs.getInt("id_exame"));
					exame.setIdConsulta(rs.getInt("id_consulta"));
					exame.setPressaoSistolica(rs.getInt("nr_pressao_sistolica"));
					exame.setPressaoDiastolica(rs.getInt("nr_pressao_diastolica"));
					exame.setNivelGlicose(rs.getInt("nr_nivel_glicose"));
					exame.setTemperaturaCorporal(rs.getInt("nr_temp_corporal"));
					exame.setFrequenciaCardiaca(rs.getInt("nr_freq_cardiaca"));
					exames.add(exame);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return exames;
	}
	
	public static Exame update(Exame exame) {
		String sql = "UPDATE tb_exame SET id_consulta=?, nr_pressao_sistolica=?, nr_pressao_diastolica=?, nr_nivel_glicose=?, nr_temp_corporal=?, nr_freq_cardiaca=? WHERE id_exame=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, exame.getIdConsulta());
			ps.setInt(2, exame.getPressaoSistolica());
			ps.setInt(3, exame.getPressaoDiastolica());
			ps.setInt(4, exame.getNivelGlicose());
			ps.setInt(5, exame.getTemperaturaCorporal());
			ps.setInt(6, exame.getFrequenciaCardiaca());
			ps.setInt(7, exame.getId());
			if (ps.executeUpdate() > 0) {
				return exame;
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
		String sql = "delete from tb_exame where id_exame=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return false;
	}
}
