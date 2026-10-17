package oop.day04_collections_and_arrays;

import java.util.Scanner;

public class Endfield {
    static Scanner sc = new Scanner(System.in);
    private int baseAttack, attackUp, bounsAttack;
    private int criticalDamage, criticalRate;
    private final double totalAttack;
    private int fragility;
    private int amplification;
    private int damageBouns, susceptibility;
    private int combo;
    private int defense;
    private double resistance;
    private int mainAttribute, secondaryAttribute;
    private int artsStrength;
    private int multiplier, mainDamagetype, secondDamagetype;
    private int corrosionLevel;
    private double finaldamage;
    public Endfield(int baseAttack, int mainAttribute, int secondaryAttribute, int bounsAttack, int attackUp)
    {
        totalAttack = (baseAttack)*((1+mainAttribute*0.5)+(1+secondaryAttribute*0.2))*(1+attackUp/100.0)+bounsAttack;
    }
    public void getDamageBouns()
    {
        System.out.println("请输入造成伤害增加的值：（这个及后面的游戏内显示为百分比的值均填写百分比，但是都不要带百分号）");
        this.damageBouns = sc.nextInt();
    }
    public void getSusceptibility()
    {
        System.out.println("请输入敌人受到伤害增加的值：");
        this.susceptibility = sc.nextInt();
    }
    public void getMultiplier()
    {
        System.out.println("请输入倍率：");
        this.multiplier = sc.nextInt();
    }
    public void getCriticalDamage()
    {
        System.out.println("请输入暴击伤害：");
        this.criticalDamage = sc.nextInt();
    }
    public void getCriticalRate()
    {
        System.out.println("请输入暴击率：");
        this.criticalRate = sc.nextInt();
    }
    public void getFragility()
    {
        System.out.println("请输入脆弱的值：");
        this.fragility = sc.nextInt();
    }
    public void getAmplification()
    {
        System.out.println("请输入增幅的值：");
        this.amplification = sc.nextInt();
    }
    public void getCombo()
    {
        System.out.println("请输入连击的值：");
        this.combo = sc.nextInt();
    }
    public void getResistance()
    {
        System.out.println("请输入敌人抗性的值：（常见的为D级即0抗性）");
        this.resistance = sc.nextInt();
    }
    public void getArtsStrength()
    {
        System.out.println("请输入源石技艺强度的值：");
        this.artsStrength = sc.nextInt();
    }
    public void getCorrosion()
    {
        System.out.println("是否有腐蚀效果？：有（填写是几级），无（0）（默认按持续时间达标的最大值计算减抗效果）");
        this.corrosionLevel = sc.nextInt();
    }
    public void getFinalDamage()
    {
        if( corrosionLevel > 0 ){
            this.resistance -= (8 + corrosionLevel * 4) * (1 + (2.0 * artsStrength) / (300 + artsStrength));
        }
        this.finaldamage = totalAttack*(1+(criticalRate/100.0)*(1+criticalDamage/100.0))*(1+damageBouns/100.0)*(1+fragility/100.0)*(1+amplification/100.0)*(1+combo/100.0)*(1+susceptibility/100.0)*(1+resistance/100.0)*(1+multiplier/100.0)/2/*防御力目前没有减少的办法，所以默认最终伤害是50%*/;
        System.out.printf("最终伤害：%.2f", finaldamage);
    }
    /*public void getType(){
        System.out.println("请输入伤害类型：终结技（0），连携技（1），战技（2），物理&法术异常伤害（3），都不是（4）");
        this.mainDamagetype = sc.nextInt();
        System.out.println("请输入伤害元素类型：灼热，寒冷，自然，电磁，物理");
        this.secondDamagetype = sc.nextInt();
        暂时用不到，所以现在暂时无法计算法术&物理异常伤害
    }*/
    public static void main(String[] args)
    {
        System.out.println("请先输入：基础攻击力、主能力、副能力、额外攻击力、攻击力加成（百分比，不要带百分号）\n这将用于计算总攻击力，没有请填写0");
        Endfield ed = new Endfield(Endfield.sc.nextInt(), Endfield.sc.nextInt(), Endfield.sc.nextInt(), Endfield.sc.nextInt(), Endfield.sc.nextInt());
        //ed.getType();
        ed.getDamageBouns();
        ed.getSusceptibility();
        ed.getMultiplier();
        ed.getCriticalDamage();
        ed.getCriticalRate();
        ed.getFragility();
        ed.getAmplification();
        ed.getCombo();
        ed.getArtsStrength();
        ed.getCorrosion();
        ed.getResistance();
        ed.getFinalDamage();
    }
}
