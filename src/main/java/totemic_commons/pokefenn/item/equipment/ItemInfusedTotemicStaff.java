package totemic_commons.pokefenn.item.equipment;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockSapling;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import totemic_commons.pokefenn.ModBlocks;
import totemic_commons.pokefenn.api.ITotemicStaffUsage;
import totemic_commons.pokefenn.block.plant.BlockSylvanSapling;
import totemic_commons.pokefenn.lib.Strings;
import totemic_commons.pokefenn.util.EntityUtil;

import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 18/02/14
 * Time: 16:30
 */
public class ItemInfusedTotemicStaff extends ItemTotemicStaff
{
    public ItemInfusedTotemicStaff()
    {
        super();
        setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.INFUSED_TOTEMIC_STAFF_NAME);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        list.add("A staff for all Totemic needs!");
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.epic;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if(!world.isRemote)
        {
            MovingObjectPosition block = EntityUtil.raytraceFromEntity(world, player, true, 5);

            if(block != null)
            {
                Block blockQuery = world.getBlock(block.blockX, block.blockY, block.blockZ);

                if(blockQuery != null)
                {
                    if(blockQuery instanceof ITotemicStaffUsage)
                    {
                        ((ITotemicStaffUsage) blockQuery).onInfusedRightClick(block.blockX, block.blockY, block.blockZ, player, world);
                        return true;
                    }

                    if(blockQuery instanceof BlockSapling && !(blockQuery instanceof BlockSylvanSapling))
                    {
                        if(world.getBlock(block.blockX + 1, block.blockY - 1, block.blockZ + 1) == ModBlocks.chlorophyll && world.getBlock(block.blockX - 1, block.blockY - 1, block.blockZ - 1) == ModBlocks.chlorophyll && world.getBlock(block.blockX + 1, block.blockY - 1, block.blockZ - 1) == ModBlocks.chlorophyll && world.getBlock(block.blockX - 1, block.blockY - 1, block.blockZ + 1) == ModBlocks.chlorophyll)
                        {

                        }
                    }


                }
            }

        }

        return true;
    }

}
