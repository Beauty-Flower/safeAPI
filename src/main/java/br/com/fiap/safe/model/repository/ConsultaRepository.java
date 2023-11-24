package br.com.fiap.safe.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import br.com.fiap.safe.model.entity.Consulta;

public class ConsultaRepository extends Repository{

	public static Consulta save(Consulta consulta) {
		String sql = "insert into tb_consulta" + "(id_consulta, id_gestante, id_unid_hospitalar, id_medico, dt_hr_consulta)"
				+ " values(SQ_TB_CONSULTA.NEXTVAL, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, consulta.getIdGestante());
			ps.setInt(2, consulta.getIdUnidHospitalar());
			ps.setInt(3, consulta.getIdMedico());
			ps.setTimestamp(4, Timestamp.valueOf(consulta.getDataHora()));
			if (ps.executeUpdate() > 0) {
				return consulta;
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
	
	public static ArrayList<Consulta> findAll() {
		ArrayList<Consulta> consultas = new ArrayList<Consulta>();
		String sql = "select * from tb_consulta";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Consulta consulta = new Consulta();
					consulta.setId(rs.getInt("id_consulta"));
					consulta.setIdGestante(rs.getInt("id_gestante"));
					consulta.setIdUnidHospitalar(rs.getInt("id_unid_hospitalar"));
					consulta.setIdMedico(rs.getInt("id_medico"));
					consulta.setDataHora(rs.getTimestamp("dt_hr_consulta").toLocalDateTime());
					consultas.add(consulta);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return consultas;
	}
	
	public static Consulta update(Consulta consulta) {
		String sql = "UPDATE tb_consulta SET id_gestante=?, id_unid_hospitalar=?, id_medico=?, dt_hr_consulta=? WHERE id_consulta=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, consulta.getIdGestante());
			ps.setInt(2, consulta.getIdUnidHospitalar());
			ps.setInt(3, consulta.getIdMedico());
			ps.setTimestamp(4, Timestamp.valueOf(consulta.getDataHora()));
			ps.setInt(5, consulta.getId());
			if (ps.executeUpdate() > 0) {
				return consulta;
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
		String sql = "delete from tb_consulta where id_consulta=?";
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
