class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                // Save current string
                stack.push(curr.toString());

                // Start a new string
                curr.setLength(0);

            } 
            else if (ch == ')') {

                // Reverse current substring
                curr.reverse();

                // Add it to previous string
                curr.insert(0, stack.pop());

            } 
            else {

                curr.append(ch);
            }
        }

        return curr.toString();
    }
}