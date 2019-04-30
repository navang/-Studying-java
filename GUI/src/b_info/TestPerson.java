package b_info;

public class TestPerson {

		private String name;
		private String id;
		private String tel;
		private String gender;
		private int age;
		private String home;
		
		
		public TestPerson( ) { //오른 클릭 generate construct .. 만들고 기본생성자 생성 
			
		}
		
		public String toString() {
			return name + "\t"+id + "\t"+tel + "\t"+gender+ "\t"+age+ "\t"+home+ "\n" ; 
					
		}
		
		public TestPerson(String name, String id, String tel, String gender, int age, String home) {
			super();
			this.name = name;
			this.id = id;
			this.tel = tel;
			this.gender = gender;
			this.age = age;
			this.home = home;
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

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
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

		public String getSex() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
}
