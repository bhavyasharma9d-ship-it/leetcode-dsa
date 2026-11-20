
        class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for (String s : operations) {
            if (s.equals("+")) {
                int top = st.pop();
                int nextScore = top + st.peek();
                st.push(top);      // restore the previous top
                st.push(nextScore);
            } else if (s.equals("D")) {
                st.push(2 * st.peek());
            } else if (s.equals("C")) {
                st.pop();
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        int total = 0;
        for (int score : st) {
            total += score;
        }
        return total;
    }
}
    