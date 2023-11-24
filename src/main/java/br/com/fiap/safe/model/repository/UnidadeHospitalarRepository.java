package br.com.fiap.safe.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.safe.model.entity.UnidadeHospitalar;

public class UnidadeHospitalarRepository extends Repository{

	public static UnidadeHospitalar save(UnidadeHospitalar unidadeHospitalar) {
		String sql = "insert into tb_unid_hospitalar" + "(id_unid_hospitalar, nm_unid_hospitalar, ds_email, ds_senha)"
				+ " values(SQ_TB_UNID_HOSPITALAR.NEXTVAL, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, unidadeHospitalar.getNome());
			ps.setString(2, unidadeHospitalar.getEmail());
			ps.setString(3, unidadeHospitalar.getSenha());
			if (ps.executeUpdate() > 0) {
				return unidadeHospitalar;
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
	
	public static ArrayList<UnidadeHospitalar> findAll() {
		ArrayList<UnidadeHospitalar> unidadesHospitalares = new ArrayList<UnidadeHospitalar>();
		String sql = "select * from tb_unid_hospitalar";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					UnidadeHospitalar unidadeHospitalar = new UnidadeHospitalar();
					unidadeHospitalar.setId(rs.getInt("id_unid_hospitalar"));
					unidadeHospitalar.setNome(rs.getString("nm_unid_hospitalar"));
					unidadeHospitalar.setEmail(rs.getString("ds_email"));
					unidadeHospitalar.setSenha(rs.getString("ds_senha"));
					unidadesHospitalares.add(unidadeHospitalar);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return unidadesHospitalares;
	}
	
	public static UnidadeHospitalar update(UnidadeHospitalar unidadeHospitalar) {
		String sql = "UPDATE tb_unid_hospitalar SET nm_unid_hospitalar=?, ds_email=?, ds_senha=? WHERE id_unid_hospitalar=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, unidadeHospitalar.getNome());
			ps.setString(2, unidadeHospitalar.getEmail());
			ps.setString(3, unidadeHospitalar.getSenha());
			ps.setInt(4, unidadeHospitalar.getId());
			if (ps.executeUpdate() > 0) {
				return unidadeHospitalar;
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
		String sql = "delete from tb_unid_hospitalar where id_unid_hospitalar=?";
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
