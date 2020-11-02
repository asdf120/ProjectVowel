package jdbc.gui;

public class  InfoVO implements java.io.Serializable
{
	private String name;
	private String id;
	private String tel;
	private String sex;
	private int age;
	private String home;

	public InfoVO(){

	}

	public InfoVO( String _name, String _id, String _tel, String _sex, int _age, String _home ){
		name	= _name;
		id		= _id;
		tel		= _tel;
		sex		= _sex;
		age		= _age;
		home	= _home;
	}

	public String toString(){
		return name + "\t" + id + "\t" + tel + "\t" +  sex + "\t" + age + "\t" + home + "\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}
	
	
}
