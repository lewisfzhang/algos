class Solution {
    public String removeKdigits(String num, int k) {
        // for (; k < num.length() && num.charAt(k) == '0'; k++) ;
        // return (k == num.length()) ? "0" : num.substring(k);

        if (k == num.length()) return "0";

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }
}
