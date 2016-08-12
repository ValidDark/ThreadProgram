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

		for (int x = 0; x <= 30; x++)
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
}