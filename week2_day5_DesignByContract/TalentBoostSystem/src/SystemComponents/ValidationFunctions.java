package SystemComponents;

public class ValidationFunctions {

	public static boolean stringValidation(String value) {
		if (value == null || value.equals("")) {
			return false;
		}
		return true;
	}
	
	public static boolean markValidation(int mark){
	    if (mark < 0 || mark > 100) {
            return false;
        }
	    return true;
	}
}
