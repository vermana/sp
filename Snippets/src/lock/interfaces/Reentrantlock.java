package lock.interfaces;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class Reentrantlock {

	public static void main(String[] args) {

		Lock k= new ReentrantLock(true);
		
for (int i=1;i<=1000;i++)
{	k.lock();
//		k.lock();
	}
		
		ReentrantLock c;
		c=(ReentrantLock)k;
		
		System.out.println( "Hold count is "  + c.getHoldCount());
		
		
		System.out.println( "Hold count is "  + c.getHoldCount());
		System.out.println( "Hold count is "  + c.getHoldCount());
		System.out.println( "Hold count is "  + c.getHoldCount());
		System.out.println( "Hold count is "  + c.getHoldCount());
		
		c.unlock();
		
		System.out.println( "Hold count is "  + c.getHoldCount());
		
		c.unlock();
		
		System.out.println( "Hold count is "  + c.getHoldCount());
		
		k.unlock();
		
		
		for(int i=1;i<=997;i++){
			
			k.unlock();
			
		}
		System.out.println( "Hold count is "  + c.getHoldCount());
		
		System.out.println( "Wait Queue length is "  + c.getQueueLength());
		
		System.out.println( "Is held by current thread "  + c.isHeldByCurrentThread());
		
		System.out.println( "Is fair "  + c.isFair());
		

	}

}
