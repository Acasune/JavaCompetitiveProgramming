class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new LinkedList<String>();
        }
        HashMap<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        List<String> ans = new LinkedList<>();
        char[] input = digits.toCharArray();
        dfs(new StringBuilder(), 0, input, mp, ans);
        return ans;

    }

    private void dfs(StringBuilder sb, int idx, char[] input, HashMap<Character, String> mp, List ans) {
        if (input.length == idx) {
            ans.add(sb.toString());
            return;
        }
        for (char a : mp.get(input[idx]).toCharArray()) {
            sb.append(a);
            dfs(sb, idx + 1, input, mp, ans);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
