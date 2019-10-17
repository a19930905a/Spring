package spring_jdbc.test;

public class user {

	private String username;
	private int sex;
	private int age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "user [username=" + username + ", sex=" + sex + ", age=" + age + "]\r\n";
	}
	
}
