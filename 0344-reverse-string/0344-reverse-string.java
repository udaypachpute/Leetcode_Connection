class Solution {
    public void reverseString(char[] s) {
        int st = 0;
        int lst = s.length-1;
        while(st < lst){
            char temp = s[st];
            s[st] = s[lst];
            s[lst] = temp;
            st++;
            lst--; 
        }

    }
}