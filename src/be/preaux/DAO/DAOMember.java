package be.preaux.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import be.preaux.POJO.Manager;
import be.preaux.POJO.Member;

public class DAOMember extends DAO<Member> {

	public DAOMember(Connection co) {
		super(co);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Member m) throws Exception {
		String sql = "INSERT INTO Member(Name,Surname,Telephone,Nickname,Password,Balance)"
				+ "VALUES ('" + m.getName() + "','" 
				+ m.getSurname() + "','" + m.getTelephone()+ "','" 
				+ m.getNickname() + "','" + m.getPassword() + "'," + m.getBalance() +")";
		PreparedStatement pst=connect.prepareStatement(sql);
		pst.execute();
		System.out.println("Member créé");
		pst.close();
		return true;

}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Member m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getAll() {
		try {
			List<Member> members = new ArrayList<>();
			
				String sql = "SELECT * FROM Member";
				ResultSet result = this.connect
						.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
				while(result.next()) {
					Member member = new Member();
					member.setIDPerson(result.getInt("IDMember"));
					member.setSurname(result.getString("Surname"));
					member.setName(result.getString("Name"));
					member.setNickname(result.getString("Nickname"));
					member.setPassword(result.getString("Password"));
					member.setTelephone(result.getString("Telephone"));
					member.setBalance(result.getDouble("balance"));
					members.add(member);
				}
				return members;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return null;

		}

}
