package exam;

import java.time.LocalDate;

public class User {
	private Long id;
	private String name;
	private String gender;
	private LocalDate birthday;

	public User() {
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", birthday=" + birthday +
				'}';
	}

	public User(Long id, String name, String gender, LocalDate birthday) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
}
