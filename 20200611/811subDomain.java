class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i < cpdomains.length; i++) {
            String[] arr = cpdomains[i].split("\\s+");
            int count = Integer. parseInt(arr[0]);
            String domain = arr[1];
            
            String[] dos = domain.split("\\.");
            String cur = "";
            
            for (int j=dos.length-1; j >= 0; j--) {
                cur = dos[j] + (j < dos.length -1 ? "." : "") + cur;
                map.put(cur, map.getOrDefault(cur, 0) + count);
            }
        }
        List<String> out = new ArrayList();
        for (String s: map.keySet()){
            out.add(""+ map.get(s) + " " + s);
        }
        return out;
    }
}