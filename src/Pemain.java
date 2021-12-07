
public abstract class Pemain {
	private String nama;
	private int location;
	private int stage_progress;
	protected int Str;
	protected int Int;
	private double HP;
	private double MP;
	private double Attack;
	private double Defense;
	private double Magic;
	private double MDef;
	private int Evade;
	private int potion_large;
	private int potion_medium;
	private int money;
	
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getPotion_large() {
		return potion_large;
	}
	public void setPotion_large(int potion_large) {
		this.potion_large = potion_large;
	}
	public int getPotion_medium() {
		return potion_medium;
	}
	public void setPotion_medium(int potion_medium) {
		this.potion_medium = potion_medium;
	}
	
	
	
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getStage_progress() {
		return stage_progress;
	}
	public void setStage_progress(int stage_progress) {
		this.stage_progress = stage_progress;
	}
	public int getStr() {
		return Str;
	}
	public void setStr(int str) {
		this.Str = str;
	}
	public int getInt() {
		return Int;
	}
	public void setInt(int i) {
		this.Int = i;
	}
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public double getHP() {
		return HP;
	}
	public void setHP(double d) {
		this.HP = d;
	}
	public double getMP() {
		return MP;
	}
	public void setMP(double d) {
		this.MP = d;
	}
	public double getAttack() {
		return Attack;
	}
	public void setAttack(double d) {
		this.Attack = d;
	}
	public double getDefense() {
		return Defense;
	}
	public void setDefense(double d) {
		this.Defense = d;
	}
	public double getMagic() {
		return Magic;
	}
	public void setMagic(double d) {
		this.Magic = d;
	}
	public double getMDef() {
		return MDef;
	}
	public void setMDef(double d) {
		this.MDef = d;
	}
	public int getEvade() {
		return Evade;
	}
	public void setEvade(int evade) {
		this.Evade = evade;
	}
	
	public Pemain(int Str, int i) {
		this.Str = Str;
		this.Int = i;
		this.money = 5;
	}
	
	
	
	public int use_potion(int i) {
		if(i==1) {
			
			this.setPotion_medium(this.getPotion_medium()-1);
			return 25;
		}else {
			
			this.setPotion_large(this.getPotion_large()-1);
			return 50;
		}
	}
	public abstract double skill1();
	public abstract double skill2();
	public abstract double skill_list();
	public double main_attack(double enemy_defense) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
