
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IDandPasswords idandpasswords = new IDandPasswords();
		idandpasswords.getLoginInfo();
		loginpage LoginPage = new loginpage(idandpasswords.getLoginInfo());
	}

}
