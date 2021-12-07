
public class Skeleton extends Monster{
	public Skeleton (int Str, int I) {
        super(Str,I);
    }
    
    public void Stat() {
        this.setHP(10 + 1.1 * this.Str);
        this.setAttack(1.5 * this.Str);
        this.setDefense(1 * this.Str);
        this.setEvade(0);
        this.setMagic(1.5 * this.Int);
        this.setMDef(1 * this.Str);
    }
}
