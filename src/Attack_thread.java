
public class Attack_thread extends Main implements Runnable {
	
	private Thread t;
	private double damage;
	private String user;
	
	void clearscreen() {
		for(int i = 0;i<50;i++) {
			System.out.println();
		}
		
	}
	
	Attack_thread(double damage_dealt,String player){
		damage = damage_dealt;
		System.out.println("Engaging target!");
	}
	

	@Override
	public void run() {
		if(user.equals("Player")==true) {
			System.out.println("Attacking Monster!");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Attacking Player!");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		clearscreen();
 		
		if(user.equals("Player")==true) {
			System.out.println(damage + "damage dealt to monster!");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println(damage + "damage dealt to player!");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		
		
		
		}
	}
	
	
	public void start() {
		System.out.println("Battle Start!");
		if(t==null) {
			t = new Thread();
			t.start();
		}
	}
	

}
