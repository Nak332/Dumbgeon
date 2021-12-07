import java.util.Scanner;

public class Mage extends Pemain implements Magic{
	Scanner in = new Scanner(System.in);
    public Mage(int Str, int I) {
        super(Str,I);
        this.setHP(20 + 1.1 * this.Str);
        this.setMP(8 + 1.5 * this.Int);
        this.setAttack(9.75 * this.Str);
        this.setDefense(1.1 * this.Str);
        this.setEvade(0);
        this.setMagic(1.5 * this.Int);
        this.setMDef(1.3 * this.Str);
    }
    
    

    @Override
	public int magic() {
		// TODO Auto-generated method stub
		return 0;
	}
    
    @Override
	public double skill1() {
		// TODO Auto-generated method stub
		 double dmg = this.getAttack() * 1.3 * magic_multiplier;
		
		return dmg;
	}

	@Override
	public double skill2() {
		double dmg = this.getAttack() * 1.8 * magic_multiplier;
		// TODO Auto-generated method stub
		return dmg;
	}

	@Override
	public double skill_list() {
		// TODO Auto-generated method stub
		System.out.println("1. Fira");
		System.out.println("2. Power Magic");
		//System.out.println("3. Defensive Shield");
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
	public double attack_ranged() {
		double at = this.getAttack() * magic_multiplier;
		return at;
	}

	@Override
	public double main_attack(double enemy_defense) {
		double total = attack_ranged() - enemy_defense;
		return total;
	};

	
	
}