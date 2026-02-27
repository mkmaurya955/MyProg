public class CheckSentencePangram1832 {

	public static void main(String[] args) {
		String sentence = "jwtucoucmdfwxxqnxzkaxoglszmfrcvjoiunqqausaxxaaijyqdqgvdnqcaihwilqkpivenpnekioyqujrdrovqrlxovcucjqzjsxmllfgndfprctxvxwlzjtciqxgsxfwhmuzqvlksyuztoetyjugmswfjtawwaqmwyxmvo";
//		String sentence = "thequickbrownfoxjumpsoverthelazydog";
		System.out.println(checkIfPangram(sentence));
	}

//	A pangram is a sentence where every letter of the English alphabet appears at least once.
//	Given a string sentence containing only lowercase English letters, return true if sentence is a pangram,
//	or false otherwise.

	static String str1 = "";

	public static boolean checkIfPangram(String sentence) {

//		for (char c = 97; c <= 122; c++) {
//			str1 = str1 + c;
//		}
//
//		Set<Character> in = new HashSet<Character>();
//		for (int i = 0; i < sentence.length(); i++) {
//			in.add(sentence.charAt(i));
//		}
//
//		if (in.size() == str1.length()) {
//			return true;
//		} else {
//			return false;
//		}
		
		boolean[] marks = new boolean[26];
		int index =0;
		for(int i=0;i<26;i++) {
			marks[i]=false;
		}
		
		for(int i= 0; i< sentence.length();i++) {
			if(sentence.charAt(i)>='a' && sentence.charAt(i)<='z') {
				index = sentence.charAt(i)-'a';
				marks[index] = true;
				
			}
		}
//		System.out.println(marks[1]);
		for(int j = 0; j<=25;j++) {
//			System.out.println(marks[j]+" "+j);
			if(marks[j]==false) {
//				System.out.println(marks[j]+" "+j);
				return false;
			}
			
		}
		return true;
	}
}
