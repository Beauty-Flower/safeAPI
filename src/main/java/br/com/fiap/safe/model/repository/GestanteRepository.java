package br.com.fiap.safe.model.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.safe.model.entity.Gestante;

public class GestanteRepository extends Repository{

	public static Gestante save(Gestante gestante) {
		String sql = "insert into tb_gestante" + "(id_gestante, nm_gestante, nr_cpf, dt_nascimento, ds_email, ds_senha)"
				+ " values(SQ_TB_GESTANTE.NEXTVAL, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, gestante.getNome());
			ps.setLong(2, gestante.getCpf());
			ps.setDate(3, Date.valueOf(gestante.getDataNascimento()));
			ps.setString(4, gestante.getEmail());
			ps.setString(5, gestante.getSenha());
			if (ps.executeUpdate() > 0) {
				return gestante;
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
	
	public static ArrayList<Gestante> findAll() {
		ArrayList<Gestante> gestantes = new ArrayList<Gestante>();
		String sql = "select * from tb_gestante";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Gestante gestante = new Gestante();
					gestante.setId(rs.getInt("id_gestante"));
					gestante.setNome(rs.getString("nm_gestante"));
					gestante.setCpf(rs.getLong("nr_cpf"));
					gestante.setDataNascimento(rs.getDate("dt_nascimento").toLocalDate());
					gestante.setEmail(rs.getString("ds_email"));
					gestante.setSenha(rs.getString("ds_senha"));
					gestantes.add(gestante);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return gestantes;
	}
	
	public static Gestante update(Gestante gestante) {
		String sql = "UPDATE tb_gestante SET nm_gestante=?, nr_cpf=?, dt_nascimento=?, ds_email=?, ds_senha=? WHERE id_gestante=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, gestante.getNome());
			ps.setLong(2, gestante.getCpf());
			ps.setDate(3, Date.valueOf(gestante.getDataNascimento()));
			ps.setString(4, gestante.getEmail());
			ps.setString(5, gestante.getSenha());
			ps.setInt(6, gestante.getId());
			if (ps.executeUpdate() > 0) {
				return gestante;
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
		String sql = "delete from tb_gestante where id_gestante=?";
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
