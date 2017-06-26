package routines;

public class ValidatePhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String phone = "03 20 16 79 00";
		 phone=phone.replaceAll("[\\D]","");
		 if(phone.length()>=9 || phone.length()<=11)
		   System.out.println(phone);
	}

}
