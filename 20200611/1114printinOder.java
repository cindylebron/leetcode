class Foo {
    //Use volatile variable which will update variable 'a' in different caches of multi core system. Note - It is only required if this code runs on multi core environment.
    //Run printFirst.run only when a=1;
    //Run printSecond.run only when a=2;
    //Similarly printThird.run only when a=3l
    volatile int a; 
    public Foo() {
        a = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (a!=1);
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        a = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (a!=2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        a = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (a!=3);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}