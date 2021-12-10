package P6;

import java.nio.charset.StandardCharsets;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ans = new StringBuilder();
        int interval = 2 * (numRows - 1);

        for(int i = 0; i < numRows; ++i) {
            for(int j = 0; i + j < s.length(); j += interval) {
                ans.append(s.charAt(i + j));
                if (i == 0 || i == numRows - 1 || (-i + j + interval) >= s.length()) continue;
                ans.append(s.charAt(-i + j + interval));
            }
        }

        return ans.toString();
    }

    public static void test(String inputString, int numRows, String expected) {
        String result = new Solution().convert(inputString, numRows);
        System.out.println("Input: s = \""+inputString+"\", numRows = "+numRows);
        System.out.println("Output: \"" + result + "\"");
        System.out.println("Expected: \""+expected+"\"");
        System.out.println("Result: "+ (expected.equals(result) ? "Pass" : "Fail"));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        /* Example 1*/
        test("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR");
        /* Example 2*/
        test("PAYPALISHIRING", 4, "PINALSIGYAHRPI");
        /* Example 3*/
        test("A", 1, "A");
        /* Example 4*/
        test("PAYPALISHIRING", 16, "PAYPALISHIRING");
    }
}
/*
Suppose N := numRows
1                           2*N-1
2                   N+N-2   2*N
3            N+N-3          2*N+1
...      ...
N-1  N+1
N

"|/" is the set,
k row, i-th set :
k, k+(N-k)*2,
k + (N-k)*2 + (k-1)*2, ...

k + (i-1)*(N-k)*2 + (i-1)*(k-1)*2, k + (i)*(N-k)*2 + (i-1)*(k-1)*2
== k + (2i - 2)N - (2i-2)k + (2i-2)k - (2i-2), ...
== k + 2(i-1)(N-1), 2*(i)(N-1) - k + 2

*/