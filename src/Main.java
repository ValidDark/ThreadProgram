
public class Main
{
public static void main(String[] args) throws InterruptedException
{
	Thread T1= new Thread(new Custom("A"));
	Thread T2= new Thread(new Custom("B"));
	Thread T3= new Thread(new Custom("C"));
	
	T1.start();
	T2.start();
	T3.start();
	
	T1.join();
	T2.join();
	T3.join();
}
}
