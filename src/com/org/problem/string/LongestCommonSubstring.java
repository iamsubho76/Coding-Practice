package com.org.problem.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class  LongestCommonSubstring
{
    /** function lcs **/
    public String lcs(String str1, String str2)
    {
        int l1 = str1.length();
        int l2 = str2.length();
 
        int[][] arr = new int[l1 + 1][l2 + 1];
        int len = 0, pos = -1;
 
        for (int x = 1; x < l1 + 1; x++)
        {
            for (int y = 1; y < l2 + 1; y++)
            {
                if (str1.charAt(x - 1) == str2.charAt(y - 1))
                {
                        arr[x][y] = arr[x - 1][y - 1] + 1;
                        if (arr[x][y] > len)
                        {
                            len = arr[x][y];
                            pos = x;
                        }               
                }
                else
                    arr[x][y] = 0;
            }
        }        
 
        return str1.substring(pos - len, pos);
    }
 
    public int getLongestCommonSubstring(String a, String b){
    	int m = a.length();
    	int n = b.length();
     
    	int max = 0;
     
    	int[][] dp = new int[m][n];
     
    	for(int i=0; i<m; i++){
    		for(int j=0; j<n; j++){
    			if(a.charAt(i) == b.charAt(j)){
    				if(i==0 || j==0){
    					dp[i][j]=1;
    				}else{
    					dp[i][j] = dp[i-1][j-1]+1;
    				}
     
    				if(max < dp[i][j])
    					max = dp[i][j];
    			}
     
    		}
    	}
     
    	return max;
    }
    
    public Set<String> longestCommonSubstrings(String s, String t) {
        int[][] table = new int[s.length()][t.length()];
        int longest = 0;
        Set<String> result = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    continue;
                }

                table[i][j] = (i == 0 || j == 0) ? 1 : 1 + table[i - 1][j - 1];
                if (table[i][j] > longest) {
                    longest = table[i][j];
                    result.clear();
                }
                if (table[i][j] == longest) {
                    result.add(s.substring(i - longest + 1, i + 1));
                }
            }
        }
        return result;
    }
    
    /** Main Function **/
    public static void main(String[] args) throws IOException
    {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Longest Common Substring Algorithm Test\n");
 
        System.out.println("\nEnter string 1");
        String str1 = br.readLine();
 
        System.out.println("\nEnter string 2");
        String str2 = br.readLine();
 
        LongestCommonSubstring obj = new LongestCommonSubstring(); 
        Set<String> result = obj.longestCommonSubstrings(str1, str2);
 
        System.out.println("\nLongest Common Substring : "+ result);
    }
}
