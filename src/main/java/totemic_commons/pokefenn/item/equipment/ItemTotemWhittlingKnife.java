package totemic_commons.pokefenn.item.equipment;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import totemic_commons.pokefenn.ModBlocks;
import totemic_commons.pokefenn.ModItems;
import totemic_commons.pokefenn.item.ItemTotemic;
import totemic_commons.pokefenn.item.ItemTotems;
import totemic_commons.pokefenn.lib.Strings;
import totemic_commons.pokefenn.tileentity.totem.TileTotemSocket;
import totemic_commons.pokefenn.util.EntityUtil;

import java.util.List;

public class ItemTotemWhittlingKnife extends ItemTotemic
{

    public ItemTotemWhittlingKnife()
    {
        setMaxStackSize(1);
        setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.TOTEM_WHITTLING_KNIFE_NAME);
        setContainerItem(this);
        //setMaxDamage(2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        list.add("A knife for all your whittlin' needs");
        if(stack.getItemDamage() < ItemTotems.TOTEM_NAMES.length)
            list.add("Currently Carving: " + ItemTotems.TOTEM_NAMES[stack.getItemDamage()]);
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item id, CreativeTabs creativeTab, List list)
    {
        for(int meta = 0; meta < ItemTotems.TOTEM_NAMES.length; meta++)
            list.add(new ItemStack(id, 1, meta));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if(player.isSneaking() && itemStack.getItemDamage() + 2 > ItemTotems.TOTEM_NAMES.length)
            return new ItemStack(this, 1, 0);

        return player.isSneaking() ? new ItemStack(this, 1, 1 + itemStack.getItemDamage()) : itemStack;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if(!world.isRemote)
        {
            //if(!player.isSneaking())
            {
                MovingObjectPosition block = EntityUtil.raytraceFromEntity(world, player, true, 5);

                if(block != null)
                {
                    Block blockQuery = world.getBlock(block.blockX, block.blockY, block.blockZ);

                    if(blockQuery instanceof BlockLog)
                    {
                        if(itemStack.getItemDamage() != 0)
                        {
                            world.setBlock(block.blockX, block.blockY, block.blockZ, ModBlocks.totemSocket);
                            TileTotemSocket tileTotemSocket = (TileTotemSocket) world.getTileEntity(block.blockX, block.blockY, block.blockZ);

                            if(tileTotemSocket.getStackInSlot(0) == null)
                            {
                                if(itemStack.getItemDamage() != 0)
                                    tileTotemSocket.setInventorySlotContents(0, new ItemStack(ModItems.totems, itemStack.getItemDamage()));
                                world.markBlockForUpdate(block.blockX, block.blockY, block.blockZ);
                                tileTotemSocket.markDirty();
                            }
                        }
                    }
                }
            }


        }

        return true;
    }


}


