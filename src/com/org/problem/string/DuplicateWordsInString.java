package com.org.problem.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class DuplicateWordsInString {

	public static void main(String[] args) {
		duplicateWords("Bread butter and bread");

		duplicateWords("Java is java again java");

		duplicateWords("Super Man Bat Man Spider Man");

        isAnagram("Mother In Law", "Hitler Woman");
 
        isAnagram("keEp", "peeK");
 
        isAnagram("SiLeNt CAT", "LisTen AcT");
 
        isAnagram("Debit Card", "Bad Credit");
 
        isAnagram("School MASTER", "The ClassROOM");
 
        isAnagram("DORMITORY", "Dirty Room");
 
        isAnagram("ASTRONOMERS", "NO MORE STARS");
 
        isAnagram("Toss", "Shot");
 
        isAnagram("joy", "enjoy");
        
        checkReverseString("I Am Not String"); //O/P -->  g ni rtS toNmAI
        
        checkReverseString("JAVA JSP ANDROID"); //O/P --> DIOR DNA PSJAVAJ
         
        checkReverseString("1 22 333 4444 55555"); //O/P --> 5 55 554 4443 33221
        
        reverseEachWordOfString("Java Concept Of The Day"); // avaJ tpecnoC fO ehT yaD
        
        reverseEachWordOfString("Java J2EE JSP Servlets Hibernate Struts"); // avaJ EE2J PSJ stelvreS etanrebiH sturtS
         
        reverseEachWordOfString("I am string not reversed"); // I ma gnirts ton desrever
         
        reverseEachWordOfString("Reverse Me"); //esreveR eM 
        
        characterPercentage("Tiger Runs @ The Speed Of 100 km/hour.");
        /*In ‘Tiger Runs @ The Speed Of 100 km/hour.’ :
        	Uppercase letters are 13.16%
        	Lowercase letters are 52.63%
        	Digits Are 7.89%
        	Other Characters Are 26.32%*/
        
        characterPercentage("My e-mail : eMail_Address321@anymail.com");
        /*In ‘My e-mail : eMail_Address321@anymail.com’ :
        	Uppercase letters are 7.5%
        	Lowercase letters are 65%
        	Digits Are 7.5%
        	Other Characters Are 20%*/
         
        characterPercentage("AUS : 123/3, 21.2 Overs");
        /*In ‘AUS : 123/3, 21.2 Overs’ :
        	Uppercase letters are 17.39%
        	Lowercase letters are 17.39%
        	Digits Are 30.43%
        	Other Characters Are 34.78%*/
        
        longestSubstring("javaconceptoftheday"); 
        //The longest substring : [o, f, t, h, e, d, a, y]
        //The longest Substring Length : 8
                 
        longestSubstring("thelongestsubstring");
        //The longest substring : [u, b, s, t, r, i, n, g]
        //The longest Substring Length : 8
        
        StringPermutation("JSP");
       /* JSP
        JPS
        SJP
        SPJ
        PJS
        PSJ*/
        
        firstRepeatedNonRepeatedChar("JavaConceptOfTheDay");
        /*JavaConceptOfTheDay
        First Non-Repeated Character In ‘JavaConceptOfTheDay’ is ‘J’
        First Repeated Character In ‘JavaConceptOfTheDay’ is ‘a’*/
	}

	static void duplicateWords(String inputString) {
		// Splitting inputString into words

		String[] words = inputString.split(" ");

		// Creating one HashMap with words as key and their count as value

		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

		// Checking each word

		for (String word : words) {
			// whether it is present in wordCount

			if (wordCount.containsKey(word.toLowerCase())) {
				// If it is present, incrementing it's count by 1

				wordCount.put(word.toLowerCase(), wordCount.get(word.toLowerCase()) + 1);
			} else {
				// If it is not present, put that word into wordCount with 1 as
				// it's value

				wordCount.put(word.toLowerCase(), 1);
			}
		}

		// Extracting all keys of wordCount

		Set<String> wordsInString = wordCount.keySet();

		// Iterating through all words in wordCount

		for (String word : wordsInString) {
			// if word count is greater than 1

			if (wordCount.get(word) > 1) {
				// Printing that word and it's count

				System.out.println(word + " : " + wordCount.get(word));
			}
		}
	}

	// Write a java program to count the number of words in a string?
	static void countNumberOfWordsV1() {
		System.out.println("Enter the string");

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		String[] words = s.trim().split(" ");

		System.out.println("Number of words in the string = " + words.length);

		sc.close();
	}

	static void countNumberOfWordsV2() {
		System.out.println("Enter the string");

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		int count = 1;

		for (int i = 0; i < s.length() - 1; i++) {
			if ((s.charAt(i) == ' ') && (s.charAt(i + 1) != ' ')) {
				count++;
			}
		}

		System.out.println("Number of words in a string = " + count);

		sc.close();
	}

	// Write a java program to count the total number of occurrences of a given
	// character in a string without using any loop?
	static void countCharacterOccurenceWithoutLoop() {
		String s = "Java is java again java again";

		char c = 'a';

		int count = s.length() - s.replace("a", "").length();

		System.out.println("Number of occurances of 'a' in " + s + " = " + count);
	}

	// Write a java program to reverse a string?
	// 1) Using StringBuffer class
	static void reverseStringUsingStringBuffer() {
		StringBuffer sbf = new StringBuffer("MyJava");

		System.out.println(sbf.reverse());
	}

	// 2) Using iterative method
	static void reverseStringUsingIterative() {
		String str = "MyJava";

		char[] strArray = str.toCharArray();

		for (int i = strArray.length - 1; i >= 0; i--) {
			System.out.print(strArray[i]);
		}
	}

	// 3) Using recursive method.
	static String recursiveMethod(String str) {
		if ((null == str) || (str.length() <= 1)) {
			return str;
		}

		return recursiveMethod(str.substring(1)) + str.charAt(0);
	}

	// Java Program To Count Occurrences Of Each Character In String
	static void characterCount(String inputString) {
		// Creating a HashMap containing char as a key and occurrences as a
		// value

		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

		// Converting given string to char array

		char[] strArray = inputString.toCharArray();

		// checking each char of strArray

		for (char c : strArray) {
			if (charCountMap.containsKey(c)) {
				// If char is present in charCountMap, incrementing it's count
				// by 1

				charCountMap.put(c, charCountMap.get(c) + 1);
			} else {
				// If char is not present in charCountMap, putting this char to
				// charCountMap with 1 as it's value

				charCountMap.put(c, 1);
			}
		}

		// Printing the charCountMap

		System.out.println(charCountMap);
	}

	// Write a java program to remove all white spaces from a string.?
	static void removeWhiteSpaces() {
		String str = "  Core Java jsp servlets             jdbc struts hibernate spring  ";

		// 1. Using replaceAll() Method

		String strWithoutSpace = str.replaceAll("\\s", "");

		System.out.println(strWithoutSpace); // Output :
												// CoreJavajspservletsjdbcstrutshibernatespring

		// 2. Without Using replaceAll() Method

		char[] strArray = str.toCharArray();

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < strArray.length; i++) {
			if ((strArray[i] != ' ') && (strArray[i] != '\t')) {
				sb.append(strArray[i]);
			}
		}

		System.out.println(sb); // Output :
								// CoreJavajspservletsjdbcstrutshibernatespring
	}

	// Write a java program to check whether one string is a rotation of
	// another?
	static void rotationCheck() {

		String s1 = "JavaJ2eeStrutsHibernate";

		String s2 = "StrutsHibernateJavaJ2ee";

		// Step 1

		if (s1.length() != s2.length()) {
			System.out.println("s2 is not rotated version of s1");
		} else {
			// Step 2

			String s3 = s1 + s1;

			// Step 3

			if (s3.contains(s2)) {
				System.out.println("s2 is a rotated version of s1");
			} else {
				System.out.println("s2 is not rotated version of s1");
			}
		}
	}

	// Write a java program to check whether two strings are anagram or not?
	//Two strings are called anagrams if they contain same set of characters but in different order. For example, 
	//“Dormitory – Dirty Room”, “keep – peek”,  
	//“School Master – The Classroom” are some anagrams.
	static void isAnagram(String s1, String s2) {
		// Removing all white spaces from s1 and s2

		String copyOfs1 = s1.replaceAll("\\s", "");

		String copyOfs2 = s2.replaceAll("\\s", "");

		// Initially setting status as true

		boolean status = true;

		if (copyOfs1.length() != copyOfs2.length()) {
			// Setting status as false if copyOfs1 and copyOfs2 doesn't have
			// same length

			status = false;
		} else {
			// Changing the case of characters of both copyOfs1 and copyOfs2 and
			// converting them to char array

			char[] s1Array = copyOfs1.toLowerCase().toCharArray();

			char[] s2Array = copyOfs2.toLowerCase().toCharArray();

			// Sorting both s1Array and s2Array

			Arrays.sort(s1Array);

			Arrays.sort(s2Array);

			// Checking whether s1Array and s2Array are equal

			status = Arrays.equals(s1Array, s2Array);
		}

		// Output

		if (status) {
			System.out.println(s1 + " and " + s2 + " are anagrams");
		} else {
			System.out.println(s1 + " and " + s2 + " are not anagrams");
		}
	}

	//How To Reverse The String With Preserving The Position Of Spaces?
	//Write a java program to reverse a string with preserving the position of spaces. For example, if “I Am Not String” 
	//is the given string then the reverse of this string 
	//with preserving the position of spaces is “g ni rtS toNmAI”. Notice that the position of 
	//spaces in the original string are maintained in the reversed string also. That means, if the given string has a space 
	//at index 3, then there should be also a space in the reversed string at index 3.
	static void checkReverseString(String inputString){

        //Converting inputString to char array 'inputStringArray'
         
        char[] inputStringArray = inputString.toCharArray();
         
        //Defining a new char array 'resultArray' with same size as inputStringArray
         
        char[] resultArray = new char[inputStringArray.length];
         
        //First for loop : 
        //For every space in the 'inputStringArray', 
        //we insert spaces in the 'resultArray' at the corresponding positions 
         
        for (int i = 0; i < inputStringArray.length; i++) 
        {
            if (inputStringArray[i] == ' ') 
            {
                resultArray[i] = ' ';
            }
        }
         
        //Initializing 'j' with length of resultArray
         
        int j = resultArray.length-1;
                 
        //Second for loop :
        //we copy every non-space character of inputStringArray 
        //from first to last at 'j' position of resultArray
         
        for (int i = 0; i < inputStringArray.length; i++)
        {
            if (inputStringArray[i] != ' ') 
            {
                //If resultArray already has space at index j then decrementing 'j'
                 
                if(resultArray[j] == ' ')
                {
                    j--;
                }
                 
                resultArray[j] = inputStringArray[i];
                 
                j--;
            }
        }
         
        System.out.println(inputString+" ---> "+String.valueOf(resultArray));
	}

	//Write a java program to reverse each word of a given string?
	static void reverseEachWordOfString(String inputString)
    {
        String[] words = inputString.split(" ");
         
        String reverseString = "";
         
        for (int i = 0; i < words.length; i++) 
        {
            String word = words[i];
             
            String reverseWord = "";
             
            for (int j = word.length()-1; j >= 0; j--) 
            {
                reverseWord = reverseWord + word.charAt(j);
            }
             
            reverseString = reverseString + reverseWord + " ";
        }
         
        System.out.println(inputString);
         
        System.out.println(reverseString);
         
        System.out.println("-------------------------");
    }
	
	//How do you convert string to integer and integer to string in java?
	static void stringToInteger(){
		String s = "2015";
        
        int i = Integer.parseInt(s);
         
        System.out.println(i);    
	}
    		
    //Write a java program to find the percentage of uppercase letters, lowercase letters, 
	//digits and special characters in a given string?	
	//Write a java program to find the percentage of uppercase letters, lowercase letters, digits and other special 
	//characters(including space) 
	//in the given string. For example, In “Tiger Runs @ The Speed Of 100 km/hour.”,
	//Number of uppercase letters is 5. So percentage is 13.16%
	//Number of lowercase letters is 20. So percentage is 52.63%
	//Number of digits is 3. So percentage is 7.89%
	//Number of other characters is 10. So percentage is 26.32%
	static void characterPercentage(String inputString)
    {
        //Getting total no of characters in the given string
         
        int totalChars = inputString.length();
         
        //Initializing upperCaseLetters, lowerCaseLetters, digits and others with 0
         
        int upperCaseLetters = 0;
         
        int lowerCaseLetters = 0;
         
        int digits = 0;
         
        int others = 0;
         
        //Iterating through each character of inputString
         
        for (int i = 0; i < inputString.length(); i++) 
        {
            char ch = inputString.charAt(i);
             
            //If ch is in uppercase, then incrementing upperCaseLetters
             
            if(Character.isUpperCase(ch))
            {
                upperCaseLetters++;
            }
             
            //If ch is in lowercase, then incrementing lowerCaseLetters
             
            else if(Character.isLowerCase(ch))
            {
                lowerCaseLetters++;
            }
             
            //If ch is a digit, then incrementing digits
             
            else if (Character.isDigit(ch))
            {
                digits++;
            }
             
            //If ch is a special character then incrementing others
             
            else
            {
                others++;
            }
        }
         
        //Calculating percentage of uppercase letters, lowercase letters, digits and other characters
         
        double upperCaseLetterPercentage = (upperCaseLetters * 100.0) / totalChars ;
         
        double lowerCaseLetterPercentage = (lowerCaseLetters * 100.0) / totalChars;
         
        double digitsPercentage = (digits * 100.0) / totalChars;
         
        double otherCharPercentage = (others * 100.0) / totalChars;
         
        DecimalFormat formatter = new DecimalFormat("##.##");
         
        //Printing percentage of uppercase letters, lowercase letters, digits and other characters
         
        System.out.println("In '"+inputString+"' : ");
         
        System.out.println("Uppercase letters are "+formatter.format(upperCaseLetterPercentage)+"% ");
         
        System.out.println("Lowercase letters are "+formatter.format(lowerCaseLetterPercentage)+"%");
         
        System.out.println("Digits Are "+formatter.format(digitsPercentage)+"%");
         
        System.out.println("Other Characters Are "+formatter.format(otherCharPercentage)+"%");
         
        System.out.println("-----------------------------");
    }

	// Write a java program to prove that strings are immutable in java?
	
	
	//How do you find longest substring without repeating characters in the given string?
	static void longestSubstring(String inputString)
    {
        //Convert inputString to charArray
         
        char[] charArray = inputString.toCharArray();
         
        //Initialization
         
        String longestSubstring = null;
         
        int longestSubstringLength = 0;
         
        //Creating LinkedHashMap with characters as keys and their position as values.
         
        LinkedHashMap<Character, Integer> charPosMap = new LinkedHashMap<Character, Integer>();
         
        //Iterating through charArray
         
        for (int i = 0; i < charArray.length; i++) 
        {
            char ch = charArray[i];
         
            //If ch is not present in charPosMap, adding ch into charPosMap along with its position
             
            if(!charPosMap.containsKey(ch))
            {
                charPosMap.put(ch, i);
            }
             
            //If ch is already present in charPosMap, reposioning the cursor i to the position of ch and clearing the charPosMap
             
            else
            {    
                i = charPosMap.get(ch);
                 
                charPosMap.clear();
            }
             
            //Updating longestSubstring and longestSubstringLength
             
            if(charPosMap.size() > longestSubstringLength)
            {
                longestSubstringLength = charPosMap.size();
                 
                longestSubstring = charPosMap.keySet().toString();
            }
        }
         
        System.out.println("Input String : "+inputString);
         
        System.out.println("The longest substring : "+longestSubstring);
         
        System.out.println("The longest Substring Length : "+longestSubstringLength);
    }
	
	//How do you swap two string variables without using third or temp variable in java?
	static void swappingTwoStringWithoutUsingThirdVariable(String s1, String s2){
		s1 = s1 + s2;
		s2 = s1.substring(0, s1.length()-s2.length());
		s1 = s1.substring(s2.length());
		
		System.out.println(s1.toString());
	}
	
	//Write a java program to find all permutations of a string?
	//start
	static public void StringPermutation(String input)
    {
        StringPermutation("", input);
    }
     
    private static void StringPermutation(String permutation, String input)
    {    
        if(input.length() == 0)
        {
            System.out.println(permutation);
        }
        else
        {
            for (int i = 0; i < input.length(); i++)
            {    
                StringPermutation(permutation+input.charAt(i), input.substring(0, i)+input.substring(i+1, input.length()));
            }
        }
    }
    //end
    
    //How do you find first repeated and non-repeated character in the given string in java?
    static void firstRepeatedNonRepeatedChar(String inputString)
    {
        //Creating a HashMap containing char as a key and occurrences as a value
         
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
         
        //Converting inputString to char array
         
        char[] strArray = inputString.toCharArray();
         
        //Checking each char of strArray
         
        for (char c : strArray)
        {
            if(charCountMap.containsKey(c))
            {
                //If char is present in charCountMap, incrementing it's count by 1
                 
                charCountMap.put(c, charCountMap.get(c)+1);
            }
            else
            {
                //If char is not present in charCountMap,
                //adding this char in charCountMap with 1 as it's value
                 
                charCountMap.put(c, 1);
            }
        }
         
        //checking for first non-repeated character
         
        for (char c : strArray)
        {
            if (charCountMap.get(c) == 1)
            {
                System.out.println("First Non-Repeated Character In '"+inputString+"' is '"+c+"'");
                 
                break;
            }
        }
         
        //checking for first repeated character
         
        for (char c : strArray)
        {
            if (charCountMap.get(c) > 1)
            {
                System.out.println("First Repeated Character In '"+inputString+"' is '"+c+"'");
                 
                break;
            }
        }
    }
    
    // Write a java program to append a given string to a text file?
    static void appendStringToFileEnd(){
        
        FileWriter fileWriter = null;
         
        BufferedWriter bufferedWriter = null;
         
        PrintWriter printWriter = null;
         
        try
        {
            //Opening a file in append mode using FileWriter
             
            fileWriter = new FileWriter("C:\\sample.txt", true);
             
            //Wrapping FileWriter object in BufferedWriter
             
            bufferedWriter = new BufferedWriter(fileWriter);
             
            //Wrapping BufferedWriter object in PrintWriter
             
            printWriter = new PrintWriter(bufferedWriter);
             
            //Bringing cursor to next line
             
            printWriter.println();
             
            //Writing text to file
             
            printWriter.println("Venkatesh : 789546");
             
            printWriter.println("Daniel : 874566");
             
            printWriter.println("Shankar : 789546");
             
            System.out.println("Done");
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //Closing the resources
             
            try
            {
                printWriter.close();
                bufferedWriter.close();
                fileWriter.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    //How do you find the number of characters, words and lines in the given text file in java?
    static void countNumberOfWordInFile(){
    	BufferedReader reader = null;
        
        //Initializing charCount, wordCount and lineCount to 0
         
        int charCount = 0;
         
        int wordCount = 0;
         
        int lineCount = 0;
         
        try
        {
            //Creating BufferedReader object
             
            reader = new BufferedReader(new FileReader("C:\\sample.txt"));
             
            //Reading the first line into currentLine
             
            String currentLine = reader.readLine();
             
            while (currentLine != null)
            {
                //Updating the lineCount
                 
                lineCount++;
                 
                //Getting number of words in currentLine
                 
                String[] words = currentLine.split(" ");
                 
                //Updating the wordCount
                 
                wordCount = wordCount + words.length;
                 
                //Iterating each word
                 
                for (String word : words)
                {
                    //Updating the charCount
                     
                    charCount = charCount + word.length();
                }
                 
                //Reading next line into currentLine
                 
                currentLine = reader.readLine();
            }
             
            //Printing charCount, wordCount and lineCount
             
            System.out.println("Number Of Chars In A File : "+charCount);
             
            System.out.println("Number Of Words In A File : "+wordCount);
             
            System.out.println("Number Of Lines In A File : "+lineCount);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();           //Closing the reader
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

    //How do you find the most repeated word in a text file in java?
    static void repeatedWordInFile(){
    	//Creating wordCountMap which holds words as keys and their occurrences as values
        
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
     
        BufferedReader reader = null;
         
        try
        {
            //Creating BufferedReader object
             
            reader = new BufferedReader(new FileReader("C:\\sample.txt"));
             
            //Reading the first line into currentLine
             
            String currentLine = reader.readLine();
             
            while (currentLine != null)
            {    
                //splitting the currentLine into words
                 
                String[] words = currentLine.toLowerCase().split(" ");
                 
                //Iterating each word
                 
                for (String word : words)
                {
                    //if word is already present in wordCountMap, updating its count
                     
                    if(wordCountMap.containsKey(word))
                    {    
                        wordCountMap.put(word, wordCountMap.get(word)+1);
                    }
                     
                    //otherwise inserting the word as key and 1 as its value
                    else
                    {
                        wordCountMap.put(word, 1);
                    }
                }
                 
                //Reading next line into currentLine
                 
                currentLine = reader.readLine();
            }
             
            //Getting the most repeated word and its occurrence
             
            String mostRepeatedWord = null;
             
            int count = 0;
             
            Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();
             
            for (Entry<String, Integer> entry : entrySet)
            {
                if(entry.getValue() > count)
                {
                    mostRepeatedWord = entry.getKey();
                     
                    count = entry.getValue();
                }
            }
             
            System.out.println("The most repeated word in input file is : "+mostRepeatedWord);
             
            System.out.println("Number Of Occurrences : "+count);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();           //Closing the reader
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
