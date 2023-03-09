**Not the best way to solve multi threading!**
```
Runnable runnable = ()->{
for(int i=1;i<=100;i++)
{
try{
Thread.sleep(1000);
} catch (InterruptedException e) {
throw new RuntimeException(e);
}
System.out.println(Thread.currentThread().getName()+" "+i);
}
};

for(int i=0;i<3;i++)
{
    Thread thread = new Thread(runnable);
    thread.start();
}
```