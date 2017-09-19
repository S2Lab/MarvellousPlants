package firok.mps;

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
}
