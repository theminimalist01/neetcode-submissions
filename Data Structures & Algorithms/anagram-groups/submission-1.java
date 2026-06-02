class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs ){
            char[] charString = str.toCharArray();
            Arrays.sort(charString);
            String sortedString = new String(charString);
            map.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
