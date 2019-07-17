class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String o1 = s2 + s1;
                String o2 = s1 + s2;
                return o1.compareTo(o2);
            }
        });

        if ("0".equals(str[0]))
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String item : str)
            sb.append(item);
        return sb.toString();
    }
}
