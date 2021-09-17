/*
Sept 2 Question (The Challenge Strikes Back)

QUESTION 1: Alien Message
You are a part of a team of researchers designed to interpret cryptic messages. 
An asteroid with a post it note attached to it contains an alien message. Ignoring the logic
 that paper would burn up in the initial atmospheric entry, you begin to interpret the message. 
 The closest interpretation to syntax comes as follows:
------------------
3  5
String: ron|wewdl
------------------
Create an anagram generator, and assuming that the numbers above will be the length of each word (xxx xxxxx),
 print out a list of words that might explain the alien message

Input: s = "ron|wewdl"
Output: nol wwred
lod wwrel
oln wrewd

*/

package test;

public class ChallengeQuestionSept02 {

		public static void main(String[] args) {
			 String str = "ron|wewdl";  
				int len = str.length();  
				System.out.println("All the messages are: ");  
				permute(str, 0, len, str.indexOf('|')); 

		}
 
	    //Function for swapping the characters at position i with character at position j  
	    public static String swapChars(String a, int i, int j) {  
	        char[] b =a.toCharArray();  
	        char ch;  
	        ch = b[i];  
	        b[i] = b[j];  
	        b[j] = ch;  
	        return String.valueOf(b);  
	    }  
	    
	    //Function for generating different permutations of the string and print in a given sequence 
	    public static void permute(String str, int start, int end, int x)  
	    {     	
	        //Prints the permutations  
	        if (start == end-1) {
	        	//int x = str.indexOf('|');
	        	if(str.charAt(x) == '|') {
	        		String s = str.replace('|', ' ');
	        		System.out.println(s); 
	        	}            
	        }else  
	        {  
	            for (int i = start; i < end; i++)  
	            {  
	                //Swapping the string by fixing a character  
	                str = swapChars(str,start,i);  
	                //Recursively calling function generatePermutation() for rest of the characters   
	                permute(str,start+1,end, x);  
	                //Backtracking and swapping the characters again.  
	                str = swapChars(str,start,i);  
	            }  
	        }  
	    }  
}

