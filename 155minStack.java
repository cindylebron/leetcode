class MinStack {
    private List<Integer> elements;
    private int top;
    /** initialize your data structure here. */
    public MinStack() {
        elements = new ArrayList<Integer>();
        top = -1;
    }
    
    public void push(int x) {
        top++;
        elements.add(x);
    }
    
    public void pop() {
        if (top == -1) {
            return;
        }
        elements.remove(top);
        top--;
        
    }
    
    public int top() {
        return elements.get(top);
    }
    
    public int getMin() {
        return Collections.min(elements);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */