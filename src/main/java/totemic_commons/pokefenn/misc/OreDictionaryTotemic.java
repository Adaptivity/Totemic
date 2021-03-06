package totemic_commons.pokefenn.misc;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import totemic_commons.pokefenn.ModItems;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 23/12/13
 * Time: 13:54
 */
public class OreDictionaryTotemic
{

    public static void init()
    {

        OreDictionary.registerOre("plant", new ItemStack(Blocks.vine));
        OreDictionary.registerOre("plant", new ItemStack(Items.wheat_seeds));
        OreDictionary.registerOre("plant", new ItemStack(Items.carrot));
        OreDictionary.registerOre("plant", new ItemStack(Items.melon_seeds));
        OreDictionary.registerOre("plant", new ItemStack(Items.pumpkin_seeds));
        OreDictionary.registerOre("plant", new ItemStack(Items.potato));
        OreDictionary.registerOre("plant", new ItemStack(Items.poisonous_potato));

        for(int i = 0; i <= 3; i++)
        {
            OreDictionary.registerOre("plant", new ItemStack(Blocks.leaves, 1, i));
            OreDictionary.registerOre("plant", new ItemStack(Blocks.leaves2, 1, i));
        }

        OreDictionary.registerOre("crystalVerdant", new ItemStack(ModItems.verdantCrystal, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("blazingCrystalVerdant", new ItemStack(ModItems.blazingChlorophyllCrystal, 1, OreDictionary.WILDCARD_VALUE));
        for(int i = 0; i <= 3; i++)
        {
            OreDictionary.registerOre("plant", new ItemStack(Blocks.sapling, 1, i));
        }
    }
}
