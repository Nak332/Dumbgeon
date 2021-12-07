import java.util.Scanner;

public class Warrior extends Pemain implements Attack{

	Scanner in = new Scanner(System.in);
	
	
    public Warrior(int Str, int I) {
        super(Str,I);
        this.setHP(30 + 1.5 * this.Str);
        this.setMP(8 + 1.2 * this.Int);
        this.setAttack(11.75 * this.Str);
        this.setDefense(1.1 * this.Str);
        this.setEvade(0);
        this.setMagic(0.6 * this.Int);
        this.setMDef(1.25 * this.Str);
    }
    
    

	
	

	@Override
	public int shield() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double skill1() {
		// TODO Auto-generated method stub
		 double dmg = this.getAttack() * 1.5 * melee_multiplier;
		
		return dmg;
	}

	@Override
	public double skill2() {
		double dmg = this.getAttack() * 0.8 * melee_multiplier;
		// TODO Auto-generated method stub
		return dmg;
	}

	@Override
	public double skill_list() {
		// TODO Auto-generated method stub
		System.out.println("1. Heavy Strike");
		System.out.println("2. Shield Bash");
		double damage=0;
		int pilih=0;
		try {
			pilih = in.nextInt();
			in.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(pilih == 1) {
			damage = this.skill1();
		}
		else if(pilih == 2) {
			damage = this.skill2();
		}
	
	
		
		return damage;
		
		
	}

	@Override
	public double attack_melee() {
		double at = this.getAttack() * melee_multiplier;
		return at;
	}

	@Override
	public double main_attack(double enemy_defense) {
		double total = attack_melee() - enemy_defense;
		return total;
	}





	
}