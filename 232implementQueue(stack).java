class MyQueue {
    
    /** Initialize your data structure here. */
    Stack<Integer> s1;
    Stack<Integer> s2;
    //front element is kept in constant memory and is modified when we push or pop an element.
    private int front;
    
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty()) 
            front = x;
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s1.push(x);
        while(!s2.isEmpty())
            s1.push(s2.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int a = s1.pop();
        if (!s1.empty())
            front = s1.peek();
        return a;
    }
    
    /** Get the front element. */
    public int peek() {
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */