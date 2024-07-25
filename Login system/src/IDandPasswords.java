import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		logininfo.put("Bro","chicken wings");
		logininfo.put("frog","flies");
		logininfo.put("cow","children");
	}
	
	protected HashMap getLoginInfo(){
		return logininfo;
	}
}
