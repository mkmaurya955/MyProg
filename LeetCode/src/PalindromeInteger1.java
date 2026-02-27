
public class PalindromeInteger1 {
	public boolean isPalindrome(int x) {
        int i = 0;
        String str = x+"";
        String str2 = "";
        for(i=str.length()-1;i>=0;i--){
            str2 = str2+str.charAt(i);
        }
        if(str.equals(str2)){
            return true;
        }
        else{
            return false;
        }
       
    }
	
	public static void main(String[] args) {
		PalindromeInteger1 pi =  new PalindromeInteger1();
		pi.isPalindrome(121);
	}
}
