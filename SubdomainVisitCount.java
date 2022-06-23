package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/subdomain-visit-count/ A website domain
 * "discuss.leetcode.com" consists of various subdomains. At the top level, we
 * have "com", at the next level, we have "leetcode.com" and at the lowest
 * level, "discuss.leetcode.com". When we visit a domain like
 * "discuss.leetcode.com", we will also visit the parent domains "leetcode.com"
 * and "com" implicitly.
 * 
 * A count-paired domain is a domain that has one of the two formats "rep
 * d1.d2.d3" or "rep d1.d2" where rep is the number of visits to the domain and
 * d1.d2.d3 is the domain itself.
 * 
 * For example, "9001 discuss.leetcode.com" is a count-paired domain that
 * indicates that discuss.leetcode.com was visited 9001 times. Given an array of
 * count-paired domains cpdomains, return an array of the count-paired domains
 * of each subdomain in the input. You may return the answer in any order.
 *
 * Input:
 * Input: cpdomains = ["9001 discuss.leetcode.com"]
 * Input: cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * 
 * Output:: 
 * ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"] 
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * 
 * "9001 com","9001 leetcode.com","9001 discuss.leetcode.com",
 * "951 com","900 google.mail.com","1 intel.mail.com","5 org","5 wiki.org","901 mail.com","50 yahoo.com"
 */
public class SubdomainVisitCount {

	public static void main(String[] args) {
		
		String[] input1 = {"9001 discuss.leetcode.com"};
		String[] input2 = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		
		List<String> outputList1 = subdomainVisits(input1);
		for (String value : outputList1) {
			System.out.print("\""+value+"\""+",");
		}
		
		System.out.println();
		
		List<String> outputList2 = subdomainVisits(input2);
		for (String value : outputList2) {
			System.out.print("\""+value+"\""+",");
		}
	}
	
	public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String str: cpdomains){
            String[] s = str.split("[ .]");
            
            for(int i= s.length-2; i>0; i--) {
                s[i] = s[i]+"."+s[i+1];
            }
            
            for(int i=1; i<s.length; i++){
                if(hm.containsKey(s[i]))
                    hm.put(s[i], hm.get(s[i])+Integer.parseInt(s[0]));
                else
                    hm.put(s[i], Integer.parseInt(s[0]));
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for(Map.Entry<String, Integer> map: hm.entrySet())
            res.add(map.getValue()+" "+map.getKey());
        
        return res;
    }

}
