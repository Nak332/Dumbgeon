
public class Zombie extends Monster {
	public Zombie (int Str, int I) {
        super(Str,I);
    }
    
    public void Stat() {
        this.setHP(10 + 5 * this.Str *2);
        this.setAttack(0.7 * this.Str);
        this.setDefense(0.8 * this.Str);
        this.setEvade(0);
        this.setMagic(0.9 * this.Int);
        this.setMDef(0.6 * this.Str);
    }
}
