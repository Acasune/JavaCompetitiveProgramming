class Solution {
    public String intToRoman(int num) {
        String ret = "";
        int r1 = num % 10;
        int r2 = (num / 10) % 10;
        int r3 = (num / 100) % 10;
        int r4 = num / 1000;

        // r1
        String tmp = "";
        if (r1 == 4) {
            tmp = "IV";
        } else if (r1 == 9) {
            tmp = "IX";
        } else {
            if (r1 >= 5) {
                tmp = "V";
            }
            tmp = tmp + padding(r1 % 5, "I");
        }
        ret = tmp + ret;

        // r2
        tmp = "";
        if (r2 == 4) {
            tmp = "XL";
        } else if (r2 == 9) {
            tmp = "XC";
        } else {
            if (r2 >= 5) {
                tmp = "L";
            }
            tmp = tmp + padding(r2 % 5, "X");
        }
        ret = tmp + ret;

        // r3
        tmp = "";
        if (r3 == 4) {
            tmp = "CD";
        } else if (r3 == 9) {
            tmp = "CM";
        } else {
            if (r3 >= 5) {
                tmp = "D";
            }
            tmp = tmp + padding(r3 % 5, "C");
        }
        ret = tmp + ret;

        // r4
        tmp = padding(r4, "M");
        return tmp + ret;
    }

    private String padding(int num, String digit) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(digit);
        }
        return sb.toString();

    }

}
