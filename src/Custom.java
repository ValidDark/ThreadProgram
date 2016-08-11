import java.util.concurrent.atomic.AtomicInteger;

public class Custom implements Runnable
{
	static int numThread = 1;
	static int threadAllowedToRun = 1;
	int myThreadID;
	private static Object myLock = new Object();
	String myString;
	
	public Custom(String x)
	{
		this.myThreadID = numThread++;
		myString = x;
		System.out.println("Thread ID:" + myThreadID + "  " + x);
	}

	@Override
	public void run()
	{

		for(int x = 0; x<=30; x++)
		{
		if(threadAllowedToRun<=3)
		synchronized (myLock)
		{
			while (myThreadID != threadAllowedToRun)
			{
				try
				{
					myLock.wait();
				}
				catch (InterruptedException e)
				{

				}
				catch (Exception e)
				{
				}
			}
			try
			{
				Thread.sleep(200);
			}
			catch (InterruptedException e)
			{
			}

			System.out.println("Thread ID:" + myThreadID + "  " + myString);
			myLock.notifyAll();
			threadAllowedToRun++;
		}
		else
		{
			threadAllowedToRun = 1;
		}

		}
		
		
		}
		
		
		//}
		
	}


// public static int turn = 1;
// public int myTurn = 1;
// AtomicInteger atom = new AtomicInteger(-1);
//
// Main m = new Main();
//
// String myString;
//
// Custom(String s)
// {
// myString = s;
// myTurn = turn;
// turn++;
// atom.getAndIncrement();
// }
//
// @Override
// public void run()
// {
//
// for (int i = 0; i < 10; i++)
// {
// if (atom.intValue() % 3 == 0)
// {
// System.out.println(myString);
// }
//
//
//
//
//
// }
//
//
//
// }
// }

// private String myString;
// static int num = 0;
// int myNum;
// private AtomicInteger c = new AtomicInteger(0);
//
// public static final Object Lock = new Object();
// public static final Object Lock2 = new Object();
// public static final Object Lock3 = new Object();
//
//
//
// public String getMyString()
// {
// return myString;
// }
//
// public void setMyString(String myString)
// {
// this.myString = myString;
// }
//
// Custom(String s)
// {
// myString = s;
// myNum = ++num;
// }
//
// @Override
// public void run()
// {
// System.out.println(myNum);
//
// synchronized(Lock){
//
// if (myNum==1)
// System.out.println(myString);
// synchronized(Lock2){
// if (myNum==2)
// System.out.println(myString);
// if (myNum==3)
// System.out.println(myString);
// }
// }
// }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
// }
