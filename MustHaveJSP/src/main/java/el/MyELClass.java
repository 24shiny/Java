package el;

public class MyELClass {
	public String getGender(String jumin) {
		String returnstr = "";
		int beginIdx = jumin.indexOf("-")+1;
		String genderStr = jumin.substring(beginIdx,beginIdx+1);
		int genderInt = Integer.parseInt(genderStr);
		if(genderInt == 1 || genderInt ==3) {
			returnstr = "male";
		}
		else if (genderInt == 2 || genderInt ==4) {
			returnstr = "female";
		} else {
			returnstr = "error";
		}
		return returnstr;
	}
	public static boolean isNumber(String value) {
		char[] chArr = value.toCharArray();
		for(int i=0; i<chArr.length; i++) {
			if(!(chArr[i]>='0' && chArr[i]<='9')) {
				return false;
			}
		}
		return true;
	}
	public static String showGugu(int dan) {
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<table border='1'>");
			for(int i=2; i<=dan; i++) {
				sb.append("<tr>");
				for(int j=1; j<=9; j++) {
					sb.append("<td>"+i+"*"+j+"="+(i*j)+"</td>");
				}
				sb.append("</tr>");
			}
			sb.append("</table>");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
