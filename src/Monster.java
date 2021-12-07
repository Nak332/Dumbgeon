
public abstract class Monster {
	private String nama;
	protected int Str;
	protected int Int;
	private double HP;
	private double Attack;
	private double Defense;
	private double Magic;
	private double MDef;
	private int Evade;
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public int getStr() {
		return Str;
	}
	public void setStr(int str) {
		Str = str;
	}
	public int getInt() {
		return Int;
	}
	public void setInt(int i) {
		Int = i;
	}
	public double getHP() {
		return HP;
	}
	public void setHP(double hP) {
		HP = hP;
	}
	public double getAttack() {
		return Attack;
	}
	public void setAttack(double attack) {
		Attack = attack;
	}
	public double getDefense() {
		return Defense;
	}
	public void setDefense(double defense) {
		Defense = defense;
	}
	public double getMagic() {
		return Magic;
	}
	public void setMagic(double magic) {
		Magic = magic;
	}
	public double getMDef() {
		return MDef;
	}
	public void setMDef(double mDef) {
		MDef = mDef;
	}
	public int getEvade() {
		return Evade;
	}
	public void setEvade(int evade) {
		Evade = evade;
	}
	public Monster(int Str, int i) {
		this.Str = Str;
		this.Int = i;
	}
	public abstract void Stat();

}
