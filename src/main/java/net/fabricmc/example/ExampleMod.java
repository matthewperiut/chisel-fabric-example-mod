package net.fabricmc.example;

import com.matthewperiut.chisel.block.ChiselGroupLookup;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Feel free to remove these imports
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Material;

import static com.matthewperiut.chisel.Chisel.CHISEL_GROUP;
import com.matthewperiut.chisel.block.blocks.EzReg;
//

public class ExampleMod implements ModInitializer
{
	public static final String MODID = "example";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static final Block TEST_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));

	@Override
	public void onInitialize()
	{
		LOGGER.info("Hello Fabric world!");

		Identifier test_block = new Identifier(MODID, "test_block");
		Registry.register(Registry.BLOCK, test_block, TEST_BLOCK);
		Registry.register(Registry.ITEM, test_block, new BlockItem(TEST_BLOCK, new FabricItemSettings().group(CHISEL_GROUP)));

		ChiselGroupLookup.addItemToGroup("stone", test_block);
	}
}
