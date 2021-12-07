import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class Main {
	Scanner in = new Scanner(System.in);
	Random rand = new Random();
	
	
	String stage_1= null;
	String stage_2 = null;
	
	
	
	public String generate_stage() {
		String stage = "B";
		
		for(int i=1;i<=29;i++ ) {
			int randomizer = rand.nextInt(100);
			randomizer++;
			if(i==29) {
				stage = stage.concat("^");
				break;
			}
			else if(randomizer>=1&&randomizer<=40) {
				stage = stage.concat("M");
			}
			else if(randomizer>=41&&randomizer<=50) {
				stage = stage.concat("T");
			}
			else if(randomizer>=51&&randomizer<=80) {
				stage = stage.concat("|");
			}
			else if(randomizer>=81&&randomizer<=100) {
				stage = stage.concat("S");
			}
			
		}
		
		
		return stage;
	}
	
	
	
	
	public void print_stage_firsttime(String stage,int player_loc) {
		for(int i=0;i<stage.length();i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(i==0) {
				System.out.println("			      > X "+stage.charAt(i)+" X < ");
				continue;
			}
			if(player_loc==i) {
				System.out.println("			      { : "+stage.charAt(i)+" : } <---- You are here");
				continue;
			}
			
			System.out.println("				: "+stage.charAt(i)+" :");
		}
	}
	
	public void print_stage_normal(String stage,int player_loc) {
		for(int i=0;i<stage.length();i++) {
			
			if(i==0) {
				System.out.println("			      > X "+stage.charAt(i)+" X < ");
				continue;
			}
			if(player_loc==i) {
				System.out.println("			      { : "+stage.charAt(i)+" : } <---- You are here");
				continue;
			}
			
			System.out.println("				: "+stage.charAt(i)+" :");
		}
	}
	
	public void move_animation(String stage,int x,int move) {
		
		for(int y=x;y!=x-(move);y--) {
			if(y<0) {
				return;
			}
			clearscreen();
		for(int i=0;i<stage.length();i++) {
			
			
			if(i==0) {
				System.out.println("			      > X "+stage.charAt(i)+" X < ");
				continue;
			}
			if(y==i) {
				System.out.println("			      { : "+stage.charAt(i)+" : } <---- You are here");
				continue;
			}
			
			System.out.println("				: "+stage.charAt(i)+" :");
		}
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	
	int ran(int a){
		int i = rand.nextInt(a)+1;	
		return i;
	}
	
	int darah = 0;
	int strp = 1;
	int intp = 1;
	int Int = 1;
	int str = 1;
	
	void clearscreen() {
		for(int i = 0;i<50;i++) {
			System.out.println();
		}
		
	}
	
	public Pemain create_player(int strp,int intp) {
		Pemain player= null;
		int pilih = 0;
		clearscreen();
		System.out.println("Create your character!");
		System.out.println("1. Warrior");
		System.out.println("2. Mage");
		System.out.println("3. Thief");
		System.out.println("4. Archer");
		System.out.println("Pick your class [1-4]: ");
		do {
			try {
			pilih = in.nextInt();
			in.nextLine();
		} catch (Exception e){
			// TODO: handle exception
		}
		} while (pilih > 4 || pilih < 1);
		
		if(pilih == 1) {
			player = new Warrior(strp,intp);
		}
		else if(pilih == 2) {
			player = new Mage(strp,intp);
		}
		else if(pilih == 3) {
			player = new Thief(strp,intp);
		}
		else if(pilih == 4) {
			player = new Archer(strp,intp);
		}
		
		
		return player;
	}
	
	
	
	int check(Pemain kelas) {
		int a = 0;
		if(darah == 0) {
			 a = (int) kelas.getHP();
		}
		else {
			a = 0;
			a = darah;
		}
		return a;
	}
	
	void lvlup(Pemain kelas){
		if(kelas instanceof Mage) {
			
			kelas.setStr(kelas.getStr()+1);
			kelas.setInt(kelas.getInt()+4);
		}
		else if(kelas instanceof Warrior) {
			kelas.setStr(kelas.getStr()+4);
			kelas.setInt(kelas.getInt()+1);

		}
		else if(kelas instanceof Thief) {
			kelas.setStr(kelas.getStr()+3);
			kelas.setInt(kelas.getInt()+2);

		}
		else {
			kelas.setStr(kelas.getStr()+3);
			kelas.setInt(kelas.getInt()+2);
		}
	}
	
	int fight(Pemain kelas,int str, int  Int) {
		int i = ran(2);
		Monster mon = null;
		if(i == 1) {
		mon = new Skeleton(str, Int);
		mon.Stat();
		
		}
		else {
			mon = new Zombie(str, Int);
			mon.Stat();
		}
		
		
		double health =  mon.getHP();
		double hea = check(kelas);
		double MD = 0;
		double MM = 0;
		double PD = 0;
		double PM = 0;
		
		
		if(kelas.getAttack() > mon.getDefense()) {
			PD = kelas.getAttack() - mon.getDefense();
		}
		if(kelas.getMagic() > mon.getMDef()) {
			PM = kelas.getMagic() - mon.getMDef();
		}
		if(mon.getAttack() > kelas.getDefense()) {
			MD = mon.getAttack() - kelas.getDefense();
		}
		if(mon.getMagic() > kelas.getMDef()){
			MM = mon.getMagic() - kelas.getMDef();
		}
		
	do{
		System.out.printf("Hero : %.2f\n",hea);
		System.out.printf("Enemy: %.2f\n",health);
		int pilih = 0;
		System.out.println("1. Attack");
		System.out.println("2. Skill");
		System.out.println("3. Run");
		System.out.print("Choice :");
		do {
			try {
			pilih = in.nextInt();
			in.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
		} while (pilih > 3 || pilih <1);
		
		if(pilih == 1) {
			health -= kelas.main_attack(mon.getDefense());
			clearscreen();
			System.out.printf("kamu menyerang sebesar %.2f\n",PD);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clearscreen();
		}
		else if(pilih ==2) {
			clearscreen();
			PM = kelas.skill_list();
			health -= PM;
			System.out.printf("kamu menyerang sebesar %.2f\n",PM);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clearscreen();
		}
		else if (pilih == 3) {
			int a = ran(10);
			if(a >= 4) {
				System.out.println("kamu berhasil Kabur");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 2;
			}
		}
		
		
		int eva = ran(100);
		int j = ran(2);
		if(kelas.getEvade() < eva) {
		if(j == 1) {
			hea -= MD;
			System.out.printf("kamu terkena serangan sebesar %.2f\n",MD);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clearscreen();
		}
		else{
			hea -= MM;
			System.out.printf("kamu terkena serangan sebesar %.2f\n",MM);
			try {
				Thread.sleep(1500);
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clearscreen();
		}
		}
		else {
			System.out.println("Kamu evade");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
			clearscreen();
			
			
//			Attack_thread player = new Attack_thread(PM, "Player");
//			Attack_thread enemy = new Attack_thread(MM, "Monster");
		
	}
	while(hea > 0 && health > 0);
	if(health <=0) {
		lvlup(kelas);
		System.out.println("Win!");
		System.out.println("Press enter to continue...");
		str++;
		Int++;
		in.nextLine();
		return 0;
	}
	else {
		System.out.println("You lose");
		System.out.println("Press enter to exit...");
		in.nextLine();
	}
	 	darah = 0;
		darah += hea;
		return 1;
	}
	
	void shop(Pemain p) {
		clearscreen();
		System.out.println("Would you like to enter the shop?\n(Yes/No) >>");
		String yesorno=null;
		do{
			yesorno = in.nextLine();
		}while(yesorno.equals("Yes")==false&&yesorno.equals("No")==false);
		
		if(yesorno.equals("No")==true) {
			return;
		}
		
		while(true) {
			
		
		clearscreen();
		System.out.println("Welcome to the shop!");
		System.out.println("-======================[SHOP]========================-");
		System.out.println("-| 1. Red Potion 25% HP                         2g  |- ");
		System.out.println("-| 2. Mega Red Potion 50% HP                    5g  |- ");
//		System.out.println("-| 3. Blue Potion 10 MP                         2g  |- ");
//		System.out.println("-| 4. Mega Blue Potion 20 MP                    5g  |-");
//		System.out.println("-| 5. Smoke Bomb (EVA + 50%, 80% Run Success)  10g  |- ");
//		System.out.println("-| 6. Herb (Clear Status)                       2g  |- ");
		System.out.println("-====================================================-");
		System.out.println("Your gold : "+ p.getMoney());
		System.out.println("1. Buy Items");
		System.out.println("2. Return to game");
		int pilih=0;
		do {
			try {
			pilih = in.nextInt();
			in.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
		} while (pilih < 1 || pilih > 2);
		
		
		if(pilih==1) {
		System.out.print("Choose item >>");
		int item=0;
		try {
			item = in.nextInt();
			in.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
			if(item==1) {
				if(p.getMoney()<2) {
					System.out.println("Insufficient funds!");
				}else {
				p.setPotion_medium(p.getPotion_medium()+1);
				p.setMoney(p.getMoney()-2);
			}
				
				
			} else if(item ==2) {
				if(p.getMoney()<5) {
					System.out.println("Insufficient funds!");
				}else {
				p.setPotion_large(p.getPotion_large()+1);
				p.setMoney(p.getMoney()-5);
				}
			}
		
		} else if(pilih==2) {
			return;
		}
		}
	}
	
	void inventory(Pemain p) {
		while(true) {
			
		clearscreen();
		System.out.println("Inventory.");
		System.out.println("1. Large Potion "+ p.getPotion_large());
		System.out.println("2. Medium Potion "+ p.getPotion_medium());
		System.out.println("3. Exit");
		int pilih=0;
		do {
			try {
			pilih = in.nextInt();
			in.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
		} while (pilih > 3 || pilih < 1);
		
		
		if(pilih==1) {
			if(p.getPotion_large()==0) {
				System.out.println("Item is empty! Enter to continue...");
				in.nextLine();
				
			}else {
				//use
				p.setPotion_large(p.getPotion_large()-1);
				darah += p.getHP()*0.5;
			
				System.out.println("Item consumed! Enter to continue...");
				in.nextLine();
			}
			
		} else if(pilih==2) {
			if(p.getPotion_medium()==0) {
				System.out.println("Item is empty! Enter to continue...");
				in.nextLine();
				
			}else {
				//use
				p.setPotion_medium(p.getPotion_medium()-1);
				System.out.println("Item consumed! Enter to continue...");
				in.nextLine();
			}
			
			
		} else if(pilih==3) {
			return;
		}
		
		}
	
}
	
	public Main() {
		
		
		
		
		String nodes = "BSTMN";
		char boss = nodes.charAt(0);
		char shop = nodes.charAt(1);
		char treasure = nodes.charAt(2);
		char monster = nodes.charAt(3);
		char none=nodes.charAt(4);
		

		System.out.println("Welcome to Dumbgeon!");
		System.out.println("Press enter to continue...");
		in.nextLine();
		
		
		boolean main_menu = true;
		
		
		while(main_menu) {
		clearscreen();
		System.out.println("1.Play\n2.Tutorial\n3.Exit\n>>");
		int game_option = 0;
		do {
			try {
			game_option = in.nextInt();
			in.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
		} while (game_option > 3 || game_option < 1);
		
		
		Pemain kelas = null;
		
		if(game_option==1) {
			kelas = create_player( strp, intp);
			System.out.println("Character Created!");
			kelas.setLocation(29);
			kelas.setStage_progress(1);
			
			
		} else if(game_option==2) {
			clearscreen();
			System.out.println("You're a hero assigned to rescue the princess! Fight your way through monsters and save her!\r\n" + 
					"\r\n" + 
					"The path is filled with random encounters such as :\r\n" + 
					"-S- Shop\r\n" + 
					"-M- Monster\r\n" + 
					"-T- Treasure\r\n" + 
					"-B- Boss\r\n" + 
					"-^- Starting point\r\n" + 
					"\r\n" + 
					"You earn gold from the treasure loot or hunting monsters.\r\n" + 
					"For every 2 fights, you will Lv up, and so will the monsters. \r\n" + 
					"At the end of the stage, there will be a boss(B) blocking your way to the next stage!\r\n" + 
					"Be sure to save up potions so you can survive");
			System.out.println("Press enter to continue...");
			in.nextLine();
			continue;
			
		} else if(game_option==3) {
			System.out.println("Thank you for trying!");
			return;
			
		}
		
		
		
		stage_1 = generate_stage();

		
		print_stage_firsttime(stage_1, kelas.getLocation());
		
		System.out.println("Enter to continue...");
		in.nextLine();
		clearscreen();
		
		boolean ingame_status = true;
		while(ingame_status){
			print_stage_normal(stage_1, kelas.getLocation());
			System.out.println("Options");
			System.out.println("1. Roll the dice\n2. Open Inventory\n3. Exit");
			int ingame_option = 0;
			do {
				try {
				ingame_option = in.nextInt();
				in.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
			}
			} while (ingame_option > 3 || ingame_option < 1);
			
			
			if(ingame_option==1) {
				System.out.println("Press enter to roll the dice!");
				in.nextLine();
				int dice = rand.nextInt(6);
				dice++;
				System.out.println("You rolled "+dice+"!");
				try {
					Thread.sleep(600);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//dice++;
				char currloc = stage_1.charAt(29);;
				
				
				move_animation(stage_1, kelas.getLocation(), dice);
				kelas.setLocation(kelas.getLocation()-dice);			
				
				if(kelas.getLocation()<0) {
					kelas.setLocation(0);
				}
				currloc = stage_1.charAt(kelas.getLocation());
				dice=0;
				
				
				
				if(currloc==boss) {
					clearscreen();
					//System.out.println(currloc + ","+kelas.getLocation());
					for(int i = 0;i<=5;i++) {
						clearscreen();
						System.out.println("You have reached the boss node!");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						clearscreen();
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					}
					
					
						int progress=0;
						//generate boss
						progress=fight(kelas, str+3, Int+3);
						if(progress==0) {
							clearscreen();
							System.out.println("You win");
							System.out.println("Press enter to quit the game");
							in.nextLine();
							return;
						} else {
							System.out.println("Press enter to quit the game");
							in.nextLine();
							return;
						}
					
					
					
				}if(currloc == treasure) {
					//System.out.println(currloc + ","+kelas.getLocation());
					print_stage_firsttime(stage_1, kelas.getLocation());
					System.out.println("You got 5 gold!");
					kelas.setMoney(kelas.getMoney()+5);
					System.out.println("Press enter to continue..");
					in.nextLine();
					clearscreen();
					print_stage_normal(stage_1, kelas.getLocation());
					
					
					
				}if(currloc == shop) {
					print_stage_normal(stage_1, kelas.getLocation());
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					clearscreen();
					print_stage_normal(stage_1, kelas.getLocation());
					shop(kelas);
					//imp shop
					
				}if(currloc == monster) {
					print_stage_normal(stage_1, kelas.getLocation());
					
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					clearscreen();
					//System.out.println(currloc + ","+kelas.getLocation());
					System.out.println("You have encountered a Monster!\nPress enter to start the battle...");
					in.nextLine();
					
					int fight_status=0;
					//generate monster
					fight_status= fight(kelas,str,Int);
					if(fight_status==1) {
						System.out.println("You lose!\nPress enter to leave..");
						in.nextLine();
						return;
						
					}
					
					
					
				}else {
					//System.out.println(currloc + ","+kelas.getLocation());
					currloc = none;
					continue;
				}
				
				
			} else if(ingame_option==2) {
				inventory(kelas);
			} else if(ingame_option==3) {
				return;
			}
			
			
			
		}
		
		
		}
		
		
		//fight(kelas,str,Int);
	}

	public static void main(String[] args) {
		//System.out.println("first");
		
		
		
		
		new Main();
	}

}
