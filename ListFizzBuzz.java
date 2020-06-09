class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> out = new ArrayList<String>(n);
        for (int i = 1; i <= n; i++){
            if (i%3 == 0 && i%5 == 0) {
                out.add("FizzBuzz");
            } else if (i%3 == 0) {
                out.add("Fizz");
            } else if (i%5 == 0){
                out.add("Buzz");
            } else {
                out.add(Integer.toString(i));
            }
        }
        return out;
    }
}