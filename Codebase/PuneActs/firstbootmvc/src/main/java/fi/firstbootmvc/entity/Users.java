package fi.firstbootmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name="users")
	public class Users {

		@Id
		@Column(name="username")
		String userName;
		
		@Column(name="password")
		String password;
		
		@Column(name="name")
		String name;
		
		@Column(name="email")
		String email;

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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Users(String userName, String password, String name, String email) {
			super();
			this.userName = userName;
			this.password = password;
			this.name = name;
			this.email = email;
		}
		
		public Users() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Users [userName=" + userName + ", password=" + password + ", name=" + name + ", email=" + email + "]";
		}
		
		
		
	}

