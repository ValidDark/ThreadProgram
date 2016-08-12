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
		System.out.println("Thread ID:" + myThreadID + "  " + x);
	}

	@Override
	public void run()
	{
		for (int x = 0; x <= 18; x++)
		{
			if (threadAllowedToRun <= 3)
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
					System.out.println("Thread ID:" + myThreadID + "  " + myString + "    " + printNum);
					myLock.notifyAll();
					threadAllowedToRun++;
				}
			else
			{
				threadAllowedToRun = 1;
				printNum++;
			}
		}
	}
}
