package totemic_commons.pokefenn.item.equipment.armour;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import totemic_commons.pokefenn.Totemic;
import totemic_commons.pokefenn.api.armour.ITotemArmour;
import totemic_commons.pokefenn.client.rendering.armour.TotemArmourHead;
import totemic_commons.pokefenn.item.equipment.EquipmentMaterials;
import totemic_commons.pokefenn.lib.Strings;

/**
 * Created by Pokefenn.
 * Licensed under MIT (If this is one of my Mods)
 */
public class ItemTotemArmour extends ItemArmor implements ISpecialArmor, ITotemArmour
{
    public int armourType;

    public ItemTotemArmour(int armourType, String name)
    {
        super(EquipmentMaterials.totemArmour, 0, armourType);
        setUnlocalizedName(Strings.RESOURCE_PREFIX + name);
        setCreativeTab(Totemic.tabsTotem);
        this.armourType = armourType;
    }


    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
    {
        return new ArmorProperties(1, 1, 0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase par1EntityLiving, ItemStack itemStack, int armorSlot)
    {
        if(!par1EntityLiving.isPotionActive(Potion.invisibility))
        {

            if(armorSlot == 0)
            {
                return new TotemArmourHead();
            }
            if(armorSlot == 1)
            {

            }
            if(armorSlot == 2)
            {

            }
            if(armorSlot == 3)
            {

            }
        }

        return null;
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
    {
        return EquipmentMaterials.totemArmour.getDamageReductionAmount(slot);
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
    {
        //stack.damageItem(damage % 2, entity);
    }

    @Override
    public int getEfficiency(ItemStack itemStack)
    {
        return 1;
    }
}
