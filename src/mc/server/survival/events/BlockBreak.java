package mc.server.survival.events;

import mc.server.survival.files.Configuration;
import mc.server.survival.files.Main;
import mc.server.survival.managers.DataManager;
import mc.server.survival.managers.FileManager;
import mc.server.survival.managers.NeuroManager;
import mc.server.survival.utils.MathUtil;
import mc.server.survival.utils.QuestUtil;
import mc.server.survival.utils.WorldUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class BlockBreak 
implements Listener
{
    private final Material[] ores = {Material.COAL_ORE, Material.COPPER_ORE, Material.IRON_ORE, Material.GOLD_ORE, Material.NETHER_GOLD_ORE,
                                     Material.EMERALD_ORE, Material.DIAMOND_ORE, Material.LAPIS_ORE, Material.REDSTONE_ORE,
                                     Material.NETHER_QUARTZ_ORE, Material.DEEPSLATE_COAL_ORE, Material.DEEPSLATE_COPPER_ORE,
									 Material.DEEPSLATE_GOLD_ORE, Material.DEEPSLATE_EMERALD_ORE, Material.DEEPSLATE_DIAMOND_ORE,
									 Material.DEEPSLATE_LAPIS_ORE, Material.DEEPSLATE_REDSTONE_ORE};

	@EventHandler
	public void onEvent(BlockBreakEvent event)
	{
		final Player player = event.getPlayer();
		Block block = event.getBlock();
		
		if (player.getWorld().getName().equalsIgnoreCase("survival") && Configuration.SERVER_TERRAIN_PROTECTION)
		{
			final Location blockLoc = block.getLocation();

			if (blockLoc.distanceSquared(new Location(player.getWorld(), 437, 50, -29)) <= 1)
				for (String author : Main.AUTHORS)
					if (player.getName().equalsIgnoreCase(author))
					{
						final Material material = block.getType();

						new BukkitRunnable() { @Override public void run() {
							block.setType(material);
						} }.runTaskLater(Main.getInstance(), 60L);
						return;
					}

			if (allowedDist(blockLoc, WorldUtil.SURVIVAL_SPAWN))
			{
				event.setCancelled(true);
				return;
			}
		}

		if (block.hasMetadata("unbreakable"))
		{
			event.setCancelled(true);
			return;
		}

		if (!player.getInventory().getItemInMainHand().getEnchantments().isEmpty())
			if (player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH))
				block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SPAWNER, 1));

		if ((boolean) FileManager.getInstance().getConfigValue("function.ore-miner.status"))
			for (Material ore : ores)
				if (block.getType() == ore)
					if (!player.isSneaking())
						runMiner(player, block, block.getType());
					else
					{
						ItemStack item = player.getInventory().getItemInMainHand();

						if (item.getType() != Material.WOODEN_PICKAXE && item.getType() != Material.STONE_PICKAXE && item.getType() != Material.IRON_PICKAXE &&
								item.getType() != Material.GOLDEN_PICKAXE && item.getType() != Material.DIAMOND_PICKAXE && item.getType() != Material.NETHERITE_PICKAXE)
							return;

						if (block.getType() == Material.NETHER_QUARTZ_ORE || block.getType() == Material.NETHER_GOLD_ORE)
							player.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHERRACK));
						else
							player.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COBBLESTONE));

						block.breakNaturally(item);
						block.setType(Material.AIR);
					}

		if (block.getType() == Material.STONE || block.getType() == Material.NETHERRACK)
			if (!player.isSneaking())
				if (DataManager.getInstance().getLocal(player).getNoradrenaline() > 5)
					if (MathUtil.chanceOf(DataManager.getInstance().getLocal(player).getNoradrenaline()))
					{
						ItemStack item = player.getInventory().getItemInMainHand();

						for (int x = -1; x < 1; x++)
							for (int z = -1; z < 1; z++)
								for (int y = -1; y < 1; y++)
									if (block.getLocation().add(x, y, z).getBlock().getType() == Material.STONE || block.getType() == Material.NETHERRACK)
										if (MathUtil.chanceOf(50))
											block.getLocation().add(x, y, z).getBlock().breakNaturally(item);
					}
		
		if (block.getType() == Material.ACACIA_LEAVES || block.getType() == Material.BIRCH_LEAVES || block.getType() == Material.OAK_LEAVES ||
			block.getType() == Material.SPRUCE_LEAVES || block.getType() == Material.JUNGLE_LEAVES || block.getType() == Material.DARK_OAK_LEAVES)
		{
			if (MathUtil.chanceOf(10 + (4 * (DataManager.getInstance().getLocal(player).getUpgradeLevel(player.getName(), "loot")))))
				player.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.APPLE));

			if (MathUtil.chanceOf(20 + (2 * (DataManager.getInstance().getLocal(player).getUpgradeLevel(player.getName(), "loot")))))
				player.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.STICK));

			if (NeuroManager.ABILITY_PLAYER_LUCK.get(player) > 25)
				if (MathUtil.chanceOf(NeuroManager.ABILITY_PLAYER_LUCK.get(player) / 300))
					player.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GOLDEN_APPLE));
		}

		if (block.getType() == Material.ANCIENT_DEBRIS)
			if (MathUtil.chanceOf(1 + (2 * (DataManager.getInstance().getLocal(player).getUpgradeLevel(player.getName(), "loot")))))
				player.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHERITE_SCRAP));

		if (block.getType() == Material.ACACIA_LOG || block.getType() == Material.BIRCH_LOG || block.getType() == Material.OAK_LOG ||
			block.getType() == Material.SPRUCE_LOG || block.getType() == Material.JUNGLE_LOG || block.getType() == Material.DARK_OAK_LOG)
			QuestUtil.manageQuest(player, 1);

		if (block.getType() == Material.STONE || block.getType() == Material.COBBLESTONE)
			QuestUtil.manageQuest(player, 2);

		if (block.getType() == Material.SAND || block.getType() == Material.RED_SAND ||
			block.getType() == Material.GRAVEL || block.getType() == Material.DIRT || block.getType() == Material.GRASS_BLOCK)
			QuestUtil.manageQuest(player, 3);

		if (block.getType() == Material.WHEAT || block.getType() == Material.CARROTS ||
			block.getType() == Material.BEETROOTS || block.getType() == Material.POTATOES ||
			block.getType() == Material.NETHER_WART)
		{
			Ageable ageable = (Ageable) block.getBlockData();
			if (ageable.getAge() == ageable.getMaximumAge())
				QuestUtil.manageQuest(player, 11);

			if (DataManager.getInstance().getLocal(player).getNoradrenaline() > 3)
				if (MathUtil.chanceOf(50))
				{
					if (block.getType() == Material.WHEAT)
					{
						if (player.getInventory().contains(Material.WHEAT_SEEDS))
						{
							new BukkitRunnable() { @Override public void run() {
								block.setType(Material.WHEAT);
							} }.runTaskLater(Main.getInstance(), 2L);
							Inventory.removeItem(player, new ItemStack(Material.WHEAT_SEEDS), 1);
						}
					}
					else if (block.getType() == Material.CARROTS)
					{
						if (player.getInventory().contains(Material.CARROTS))
						{
							new BukkitRunnable() { @Override public void run() {
								block.setType(Material.CARROTS);
							} }.runTaskLater(Main.getInstance(), 2L);
							Inventory.removeItem(player, new ItemStack(Material.CARROTS), 1);
						}
					}
					else if (block.getType() == Material.BEETROOTS)
					{
						if (player.getInventory().contains(Material.BEETROOTS))
						{
							new BukkitRunnable() { @Override public void run() {
								block.setType(Material.BEETROOTS);
							} }.runTaskLater(Main.getInstance(), 2L);
							Inventory.removeItem(player, new ItemStack(Material.BEETROOTS), 1);
						}
					}
					else if (block.getType() == Material.POTATOES)
					{
						if (player.getInventory().contains(Material.POTATOES))
						{
							new BukkitRunnable() { @Override public void run() {
								block.setType(Material.POTATOES);
							} }.runTaskLater(Main.getInstance(), 2L);
							Inventory.removeItem(player, new ItemStack(Material.POTATOES), 1);
						}
					}
					else if (block.getType() == Material.NETHER_WART)
					{
						if (player.getInventory().contains(Material.NETHER_WART))
						{
							new BukkitRunnable() { @Override public void run() {
								block.setType(Material.NETHER_WART);
							} }.runTaskLater(Main.getInstance(), 2L);
							Inventory.removeItem(player, new ItemStack(Material.NETHER_WART), 1);
						}
					}
				}
		}
	}

	private boolean allowedDist(final Location from, final Location to)
	{
		return from.distance(to) <= Configuration.SERVER_SPAWN_PROTECTION;
	}

	private void runMiner(Player player, Block block, Material road)
    {
        if (player.isSneaking())
            return;

		final ItemStack item = player.getInventory().getItemInMainHand();
		final ItemStack concurrentItem = player.getInventory().getItemInOffHand();
		ItemStack finalItem;

		if (item.getType() != Material.WOODEN_PICKAXE && item.getType() != Material.STONE_PICKAXE && item.getType() != Material.IRON_PICKAXE &&
				item.getType() != Material.GOLDEN_PICKAXE && item.getType() != Material.DIAMOND_PICKAXE && item.getType() != Material.NETHERITE_PICKAXE)
			finalItem = concurrentItem;
		else
			finalItem = item;

        ArrayList<Block> blockRoad = new ArrayList<>();

        for (int x = -1; x <= 1; x++)
        {
            for (int y = -1; y <= 1; y++)
            {
                for (int z = -1; z <= 1; z++)
                {
                    if (player.getWorld().getBlockAt(block.getLocation().add(x, y, z)).getType().toString().equalsIgnoreCase(road.toString()))
                    {
                        blockRoad.add(player.getWorld().getBlockAt(block.getLocation().add(x, y, z)));
                        Block targetBlock = player.getWorld().getBlockAt(block.getLocation().add(x, y, z));

						if (MathUtil.chanceOf(NeuroManager.ABILITY_PLAYER_LUCK.get(player) / 2))
						{
							Collection<ItemStack> itemStacks = targetBlock.getDrops(finalItem);

							for (ItemStack itemStack : itemStacks)
								player.getWorld().dropItemNaturally(targetBlock.getLocation(), itemStack);
						}

						targetBlock.breakNaturally(finalItem);
						targetBlock.setType(Material.AIR);

						if (!MathUtil.chanceOf(NeuroManager.ABILITY_PLAYER_LUCK.get(player) / 2))
							finalItem.setDurability((short) (finalItem.getDurability() - (short) -1));

						if (MathUtil.chanceOf(50))
						{
						    player.getWorld().getBlockAt(block.getLocation().add(x, y, z)).breakNaturally(new ItemStack(Material.STICK));

							if (road == Material.NETHER_QUARTZ_ORE || road == Material.NETHER_GOLD_ORE)
								player.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.NETHERRACK));
							else
								player.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COBBLESTONE));
                    	}
                    }
                }
            }
        }

        for (Block blocks : blockRoad)
            runMiner(player, blocks, road);
    }
}