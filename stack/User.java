package stack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TAB")
public class User {
	@Id
	@Column(name ="USER_NAME")
	private String userName;
	@Column(name = "PASSWORD", nullable = true)
	private String password;
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", getUserName()=" + getUserName()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
