/*You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0

Note:
S and J will consist of letters and have length at most 50.
The characters in J are distinct.
*/

//METHOD 1:

class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewelSet = new HashSet<Character>();
        for(Character ch: J.toCharArray()) {
           jewelSet.add(ch);
        }
        int count = 0;
        for(Character ch: S.toCharArray()) {
           if(jewelSet.contains(ch)) {
              count++;
           }
        }
        return count;
    }
}


/*
Description: Here, we are going to traverse J string character by character and we will store all characters into a hashset. Then we will traverse S string character by character and check weather it is present in the set, if yes increment the count.
Complexity: O(m+n) and space complexity is O(m)
*/


//METHOD 2:

class Solution2 {
    public int numJewelsInStones(String J, String S) {
        int initialLength = S.length();
        for(int i=0; i<J.length(); i++) {
            S = S.replaceAll(J.charAt(i)+"", "");
        }
        return initialLength-S.length();
    }
}

/*
Description: Here, we are going to traverse J string character by character and for each character we will remove all occurrences of those character from string S. And in the end we will have those characters which are not in J string. So subtract initial length to current length of string S and return.
Complexity: Time complexity is O(n^2) and space complexity is O(1)
Complexity of replaceAll function is O(n). So overall complexity is O(n^2)
*/
