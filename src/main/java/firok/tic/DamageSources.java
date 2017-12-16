package firok.tic;

import net.minecraft.util.DamageSource;

public class DamageSources
{
	static public class LightningDamege extends DamageSource
	{
		public LightningDamege()
		{
			super("lightningDamage");
			this.setDamageBypassesArmor();
			this.setDamageIsAbsolute();
		}
	}
	static public class AvariceDamege extends DamageSource
	{
		public AvariceDamege()
		{
			super("avariceDamage");
			this.setDamageBypassesArmor();
			this.setDamageIsAbsolute();
		}
	}
}
