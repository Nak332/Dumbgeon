import java.util.Scanner;

public class Thief extends Pemain implements Attack{
	Scanner in = new Scanner(System.in);
    public Thief(int Str, int I) {
        super(Str,I);
        this.setHP(23 + 1.25 * this.Str);
        this.setMP(18 + 1.25 * this.Int);
        this.setAttack(9.25 * this.Str);
        this.setDefense(0.8 * this.Str);
        this.setEvade(25);
        this.setMagic(1.25 * this.Int);
        this.setMDef(1.1* this.Str);
    }
    
   


	
	@Override
	public int shield() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double skill1() {
		// TODO Auto-generated method stub
		 double dmg = this.getAttack() * 1.8 * melee_multiplier;
		
		return dmg;
	}

	@Override
	public double skill2() {
		double dmg = this.getAttack() * 0.7 * melee_multiplier;
		// TODO Auto-generated method stub
		return dmg;
	}

	@Override
	public double skill_list() {
		// TODO Auto-generated method stub
		System.out.println("1. Double slash");
		System.out.println("2. Quick Attack");
		//System.out.println("3. Smokescreen");
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