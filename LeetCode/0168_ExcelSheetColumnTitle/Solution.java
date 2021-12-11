class Solution {
    public String convertToTitle(int columnNumber) {
        String s = "";
        while (columnNumber > 0) {
            if (columnNumber % 26 == 0) {
                s = "Z" + s;
                columnNumber /= 26;
                columnNumber--;
            } else {
                s = (char) ((columnNumber % 26) + '@') + s;
                columnNumber /= 26;
            }
        }
        return s;
    }
}
