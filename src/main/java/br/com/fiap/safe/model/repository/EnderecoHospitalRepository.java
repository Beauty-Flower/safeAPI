package br.com.fiap.safe.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.safe.model.entity.EnderecoHospital;

public class EnderecoHospitalRepository extends Repository{

	public static EnderecoHospital save(EnderecoHospital enderecoHospital) {
		String sql = "insert into tb_endereco_hospital" + "(id_endereco, id_unid_hospitalar, nm_logradouro, nr_logradouro, nm_cidade, nm_bairr0, nm_estado)"
				+ " values(SQ_TB_ENDERECO_HOSPITAL.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, enderecoHospital.getIdUnidHospitalar());
			ps.setString(2, enderecoHospital.getNomeLogradouro());
			ps.setInt(3, enderecoHospital.getNumeroLogradouro());
			ps.setString(4, enderecoHospital.getCidade());
			ps.setString(5, enderecoHospital.getBairro());
			ps.setString(6, enderecoHospital.getEstado());
			if (ps.executeUpdate() > 0) {
				return enderecoHospital;
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
	
	public static ArrayList<EnderecoHospital> findAll() {
		ArrayList<EnderecoHospital> enderecosHospitalares = new ArrayList<EnderecoHospital>();
		String sql = "select * from tb_endereco_hospital";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					EnderecoHospital enderecoHospital = new EnderecoHospital();
					enderecoHospital.setId(rs.getInt("id_endereco"));
					enderecoHospital.setIdUnidHospitalar(rs.getInt("id_unid_hospitalar"));
					enderecoHospital.setNomeLogradouro(rs.getString("nm_logradouro"));
					enderecoHospital.setNumeroLogradouro(rs.getInt("nr_logradouro"));
					enderecoHospital.setCidade(rs.getString("nm_cidade"));
					enderecoHospital.setBairro(rs.getString("nm_bairr0"));
					enderecoHospital.setEstado(rs.getString("nm_estado"));
					enderecosHospitalares.add(enderecoHospital);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return enderecosHospitalares;
	}
	
	public static EnderecoHospital update(EnderecoHospital enderecoHospital) {
		String sql = "UPDATE tb_endereco_hospital SET id_unid_hospitalar=?, nm_logradouro=?, nr_logradouro=?, nm_cidade=?, nm_bairr0=?, nm_estado=? WHERE id_endereco=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, enderecoHospital.getIdUnidHospitalar());
			ps.setString(2, enderecoHospital.getNomeLogradouro());
			ps.setInt(3, enderecoHospital.getNumeroLogradouro());
			ps.setString(4, enderecoHospital.getCidade());
			ps.setString(5, enderecoHospital.getBairro());
			ps.setString(6, enderecoHospital.getEstado());
			ps.setInt(7, enderecoHospital.getId());
			if (ps.executeUpdate() > 0) {
				return enderecoHospital;
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
		String sql = "delete from tb_endereco_hospital where id_endereco=?";
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
