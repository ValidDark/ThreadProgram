import java.util.concurrent.atomic.AtomicInteger;

public class Custom implements Runnable
{
	static int numThread = 1;
	static int threadAllowedToRun = 1;
	int myThreadID;
	private static Object myLock = new Object();
	String myString;
	static int printNum = 1;

	public Custom(String x)
	{
		this.myThreadID = numThread++;
		myString = x;
	}

	@Override
	public void run()
	{
		for (int x = 0; x <= 18; x++)
		{
			// synchronized (myLock)
			// {
			if (threadAllowedToRun <= 3)
			{
				while (myThreadID != threadAllowedToRun)
				{
//					try
//					{
//						synchronized (myLock)
//						{
//							myLock.wait();
//						}
//					}
//					catch (InterruptedException e)
//					{
//
//					}
//					catch (Exception e)
//					{
//					}
				}
				System.out.println("Thread ID:" + myThreadID + "  " + myString + "    " + printNum);
				threadAllowedToRun++;
//				synchronized (myLock)
//				{
//					myLock.notifyAll();
//				}
			}
			else
			{
				threadAllowedToRun = 1;
				printNum++;
			}
			// }

		}
	}
}
