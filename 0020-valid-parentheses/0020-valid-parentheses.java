class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++) {
            char curr = str.charAt(i);
            if ( curr == '[' || curr == '{' || curr == '(' ) {
                s.push(curr);
            }
            else if(curr == ']' || curr == '}' || curr == ')'){
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek() == '(' && curr == ')')
                    || (s.peek() == '[' && curr == ']')
                    || (s.peek() == '{' && curr == '}')){
                    s.pop();
                }
                else {
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
}