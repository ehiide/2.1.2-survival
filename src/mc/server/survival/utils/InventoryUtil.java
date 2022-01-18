package mc.server.survival.utils;

import mc.server.survival.files.Configuration;
import mc.server.survival.files.Main;
import mc.server.survival.items.Chemistries;
import mc.server.survival.items.ChemistryDrug;
import mc.server.survival.managers.ChatManager;
import mc.server.survival.managers.DataManager;
import mc.server.survival.managers.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class InventoryUtil
{
	public static void createNewInventory(Player player, int size, String name, String type)
	{
		Inventory inventory = Bukkit.createInventory(player, size, name);
		fillInventory(inventory);

		if (type.equalsIgnoreCase("domki"))
		{
			inventory.setItem(11, getItem(player, "home1"));
			inventory.setItem(13, getItem(player, "homeinfo"));
			inventory.setItem(15, getItem(player, "home2"));
		}
		else if (type.equalsIgnoreCase("schowek"))
		{
			inventory.setItem(11, getItem(player, "schowekinfo"));
			inventory.setItem(15, getItem(player, "schowek1"));
		}
		else if (type.equalsIgnoreCase("pomoc"))
		{
			inventory.setItem(13, getItem(player, "pomocinfo"));
			inventory.setItem(24, getItem(player, "pomoc1"));
			inventory.setItem(25, getItem(player, "pomoc2"));
			inventory.setItem(34, getItem(player, "pomoc3"));
			inventory.setItem(19, getItem(player, "pomoc4"));
			inventory.setItem(20, getItem(player, "pomoc5"));
			inventory.setItem(28, getItem(player, "pomoc6"));
			inventory.setItem(31, getItem(player, "pomoc7"));
		}
		else if (type.equalsIgnoreCase("wyspy"))
		{
			inventory.setItem(40, getItem(player, "wyspyspawn"));
			inventory.setItem(11, getItem(player, "wyspy1"));
			inventory.setItem(12, getItem(player, "wyspy2"));
			inventory.setItem(13, getItem(player, "wyspy3"));
			inventory.setItem(14, getItem(player, "wyspy4"));
			inventory.setItem(15, getItem(player, "wyspy5"));
			inventory.setItem(20, getItem(player, "wyspy6"));
			inventory.setItem(21, getItem(player, "wyspy7"));
			inventory.setItem(22, getItem(player, "wyspy8"));
		}
		else if (type.equalsIgnoreCase("craftingi1"))
		{
			inventory.setItem(44, getItem(player, "arrownext"));
			inventory.setItem(24, new ItemStack(Material.SADDLE));
			inventory.setItem(22, new ItemStack(Material.STRING));
			inventory.setItem(21, null);
			inventory.setItem(20, new ItemStack(Material.STRING));
			inventory.setItem(31, new ItemStack(Material.IRON_INGOT));
			inventory.setItem(30, null);
			inventory.setItem(29, new ItemStack(Material.IRON_INGOT));
			inventory.setItem(13, new ItemStack(Material.LEATHER));
			inventory.setItem(12, new ItemStack(Material.LEATHER));
			inventory.setItem(11, new ItemStack(Material.LEATHER));
		}
		else if (type.equalsIgnoreCase("craftingi2"))
		{
			inventory.setItem(36, getItem(player, "arrowback"));
			inventory.setItem(44, getItem(player, "arrownext"));
			inventory.setItem(24, new ItemStack(Material.NAME_TAG));
			inventory.setItem(22, new ItemStack(Material.PAPER));
			inventory.setItem(21, new ItemStack(Material.PAPER));
			inventory.setItem(20, new ItemStack(Material.PAPER));
			inventory.setItem(31, new ItemStack(Material.STRING));
			inventory.setItem(30, new ItemStack(Material.IRON_INGOT));
			inventory.setItem(29, new ItemStack(Material.STRING));
			inventory.setItem(13, new ItemStack(Material.STRING));
			inventory.setItem(12, new ItemStack(Material.IRON_INGOT));
			inventory.setItem(11, new ItemStack(Material.STRING));
		}
		else if (type.equalsIgnoreCase("craftingi3"))
		{
			inventory.setItem(36, getItem(player, "arrowback"));
			inventory.setItem(44, getItem(player, "arrownext"));
			inventory.setItem(24, new ItemStack(Material.ELYTRA));
			inventory.setItem(22, new ItemStack(Material.NETHERITE_INGOT));
			inventory.setItem(21, new ItemStack(Material.ARMOR_STAND));
			inventory.setItem(20, new ItemStack(Material.NETHERITE_INGOT));
			inventory.setItem(31, new ItemStack(Material.NETHERITE_INGOT));
			inventory.setItem(30, null);
			inventory.setItem(29, new ItemStack(Material.NETHERITE_INGOT));
			inventory.setItem(13, new ItemStack(Material.TRIPWIRE_HOOK));
			inventory.setItem(12, new ItemStack(Material.GHAST_TEAR));
			inventory.setItem(11, new ItemStack(Material.TRIPWIRE_HOOK));
		}
		else if (type.equalsIgnoreCase("craftingi4"))
		{
			inventory.setItem(36, getItem(player, "arrowback"));
			inventory.setItem(44, getItem(player, "arrownext"));
			inventory.setItem(24, new ItemStack(Material.DIAMOND_HORSE_ARMOR));
			inventory.setItem(22, new ItemStack(Material.DIAMOND));
			inventory.setItem(21, new ItemStack(Material.DIAMOND));
			inventory.setItem(20, new ItemStack(Material.DIAMOND));
			inventory.setItem(31, new ItemStack(Material.DIAMOND));
			inventory.setItem(30, null);
			inventory.setItem(29, new ItemStack(Material.DIAMOND));
			inventory.setItem(13, new ItemStack(Material.DIAMOND));
			inventory.setItem(12, new ItemStack(Material.DIAMOND));
			inventory.setItem(11, new ItemStack(Material.DIAMOND));
		}
		else if (type.equalsIgnoreCase("craftingi5"))
		{
			inventory.setItem(36, getItem(player, "arrowback"));
			inventory.setItem(44, getItem(player, "arrownext"));
			inventory.setItem(24, new ItemStack(Material.EXPERIENCE_BOTTLE));
			inventory.setItem(22, new ItemStack(Material.IRON_NUGGET));
			inventory.setItem(21, new ItemStack(Material.GLASS_BOTTLE));
			inventory.setItem(20, new ItemStack(Material.IRON_NUGGET));
			inventory.setItem(31, null);
			inventory.setItem(30, new ItemStack(Material.GLOWSTONE_DUST));
			inventory.setItem(29, null);
			inventory.setItem(13, null);
			inventory.setItem(12, new ItemStack(Material.GLOWSTONE_DUST));
			inventory.setItem(11, null);
		}
		else if (type.equalsIgnoreCase("craftingi6"))
		{
			inventory.setItem(36, getItem(player, "arrowback"));
			inventory.setItem(44, getItem(player, "arrownext"));
			inventory.setItem(24, ChemistryDrug.getDrug(Chemistries.piwo));
			inventory.setItem(22, new ItemStack(Material.WHEAT));
			inventory.setItem(21, new ItemStack(Material.GLASS_BOTTLE));
			inventory.setItem(20, new ItemStack(Material.WHEAT));
			inventory.setItem(31, new ItemStack(Material.WHEAT));
			inventory.setItem(30, new ItemStack(Material.WHEAT));
			inventory.setItem(29, new ItemStack(Material.WHEAT));
			inventory.setItem(13, new ItemStack(Material.WHEAT));
			inventory.setItem(12, new ItemStack(Material.WHEAT));
			inventory.setItem(11, new ItemStack(Material.WHEAT));
		}
		else if (type.equalsIgnoreCase("craftingi7"))
		{
			inventory.setItem(36, getItem(player, "arrowback"));
			inventory.setItem(24, ChemistryDrug.getDrug(Chemistries.wino));
			inventory.setItem(22, new ItemStack(Material.SUGAR));
			inventory.setItem(21, new ItemStack(Material.GLASS_BOTTLE));
			inventory.setItem(20, new ItemStack(Material.SUGAR));
			inventory.setItem(31, null);
			inventory.setItem(30, new ItemStack(Material.SWEET_BERRIES));
			inventory.setItem(29, null);
			inventory.setItem(13, null);
			inventory.setItem(12, new ItemStack(Material.SWEET_BERRIES));
			inventory.setItem(11, null);
		}
		else if (type.equalsIgnoreCase("paleta"))
		{
			inventory.setItem(4, new ItemStack(Material.PINK_STAINED_GLASS_PANE));
			inventory.setItem(9, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
			inventory.setItem(11, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			inventory.setItem(13, getItem(player, "paletainfo"));
			inventory.setItem(15, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
			inventory.setItem(17, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
			inventory.setItem(22, new ItemStack(Material.BLUE_STAINED_GLASS_PANE));
		}
		else if (type.equalsIgnoreCase("sklep"))
		{
			inventory.setItem(13, getItem(player, "sklepprzedmioty"));
			inventory.setItem(20, getItem(player, "sklepefekty"));
			inventory.setItem(24, getItem(player, "sklepgangi"));
			inventory.setItem(31, getItem(player, "sklepdodatki"));
		}
		else if (type.equalsIgnoreCase("sklep_efekty"))
		{
			inventory.setItem(10, getItem(player, "sklepspeed"));
			inventory.setItem(11, getItem(player, "sklepjumpboost"));
			inventory.setItem(12, getItem(player, "sklepresistance"));
			inventory.setItem(13, getItem(player, "sklepstrength"));
			inventory.setItem(14, getItem(player, "sklephaste"));
			inventory.setItem(15, getItem(player, "sklepfireresistance"));
			inventory.setItem(16, getItem(player, "sklepregeneration"));
			inventory.setItem(21, getItem(player, "sklepinvis"));
			inventory.setItem(22, getItem(player, "sklepwaterbreathing"));
			inventory.setItem(23, getItem(player, "sklepnightvision"));

			inventory.setItem(40, getItem(player, "powrot"));
		}
		else if (type.equalsIgnoreCase("sklep_dodatki"))
		{
			inventory.setItem(10, getItem(player, "sklepkolor1"));
			inventory.setItem(11, getItem(player, "sklepkolor2"));
			inventory.setItem(12, getItem(player, "sklepkolor3"));
			inventory.setItem(19, getItem(player, "sklepkolor4"));
			inventory.setItem(20, getItem(player, "sklepkolor5"));
			inventory.setItem(21, getItem(player, "sklepkolor6"));
			inventory.setItem(28, getItem(player, "sklepkolor7"));
			inventory.setItem(29, getItem(player, "sklepkolor8"));
			inventory.setItem(14, getItem(player, "sklepschowek"));
			inventory.setItem(23, getItem(player, "sklepvoucher"));
			inventory.setItem(16, getItem(player, "sklepslub"));
			inventory.setItem(40, getItem(player, "powrot"));
		}
		else if (type.equalsIgnoreCase("sklep_gang"))
		{
			if (DataManager.getInstance().getLocal(player).getGang() == null)
				inventory.setItem(22, getItem(player, "sklepnogang"));
			else
			{
				inventory.setItem(10, getItem(player, "sklepgang1"));
				inventory.setItem(11, getItem(player, "sklepgang2"));
				inventory.setItem(12, getItem(player, "sklepgang3"));
				inventory.setItem(19, getItem(player, "sklepgang4"));
				inventory.setItem(20, getItem(player, "sklepgang5"));
				inventory.setItem(21, getItem(player, "sklepgang6"));
				inventory.setItem(28, getItem(player, "sklepgang7"));
				inventory.setItem(29, getItem(player, "sklepgang8"));
				inventory.setItem(14, getItem(player, "sklepgangp1"));
				inventory.setItem(23, getItem(player, "sklepgangp2"));
				inventory.setItem(32, getItem(player, "sklepgangp3"));
				inventory.setItem(16, getItem(player, "sklepgangstar"));
				inventory.setItem(25, getItem(player, "sklepgangchat"));
			}

			inventory.setItem(40, getItem(player, "powrot"));
		}
		else if (type.equalsIgnoreCase("sklep_przedmioty"))
		{
			inventory.setItem(9, getItem(player, "sklepitemy"));
			inventory.setItem(18, getItem(player, "sklepksiazki"));
			inventory.setItem(27, getItem(player, "sklepspecjalne"));

			inventory.setItem(22, getItem(player, "sklepinfo"));

			inventory.setItem(49, getItem(player, "powrot"));
			inventory.setItem(26, getItem(player, "sklepkupno"));
		}
		else if (type.equalsIgnoreCase("sklep_przedmioty_itemy"))
		{
			inventory.setItem(9, getItem(player, "sklepitemyselected"));
			inventory.setItem(18, getItem(player, "sklepksiazki"));
			inventory.setItem(27, getItem(player, "sklepspecjalne"));

			inventory.setItem(11, getItem(player, "sklepitemy1"));
			inventory.setItem(12, getItem(player, "sklepitemy2"));
			inventory.setItem(13, getItem(player, "sklepitemy3"));
			inventory.setItem(14, getItem(player, "sklepitemy4"));
			inventory.setItem(15, getItem(player, "sklepitemy5"));
			inventory.setItem(20, getItem(player, "sklepitemy6"));
			inventory.setItem(21, getItem(player, "sklepitemy7"));
			inventory.setItem(22, getItem(player, "sklepitemy8"));
			inventory.setItem(23, getItem(player, "sklepitemy9"));
			inventory.setItem(24, getItem(player, "sklepitemy10"));
			inventory.setItem(29, getItem(player, "sklepitemy11"));
			inventory.setItem(30, getItem(player, "sklepitemy12"));
			inventory.setItem(31, getItem(player, "sklepitemy13"));
			inventory.setItem(32, getItem(player, "sklepitemy14"));
			inventory.setItem(33, getItem(player, "sklepitemy15"));

			inventory.setItem(45, getItem(player, "arrowback"));
			inventory.setItem(53, getItem(player, "arrownext"));
			inventory.setItem(49, getItem(player, "powrot"));
			inventory.setItem(26, getItem(player, "sklepkupno"));
		}
		else if (type.equalsIgnoreCase("sklep_przedmioty_itemy2"))
		{
			inventory.setItem(9, getItem(player, "sklepitemyselected"));
			inventory.setItem(18, getItem(player, "sklepksiazki"));
			inventory.setItem(27, getItem(player, "sklepspecjalne"));

			inventory.setItem(11, getItem(player, "sklepitemy16"));
			inventory.setItem(12, getItem(player, "sklepitemy17"));
			inventory.setItem(13, getItem(player, "sklepitemy18"));
			inventory.setItem(14, getItem(player, "sklepitemy19"));
			inventory.setItem(15, getItem(player, "sklepitemy20"));
			inventory.setItem(20, getItem(player, "sklepitemy21"));
			inventory.setItem(21, getItem(player, "sklepitemy22"));
			inventory.setItem(22, getItem(player, "sklepitemy23"));
			inventory.setItem(23, getItem(player, "sklepitemy24"));
			inventory.setItem(24, getItem(player, "sklepitemy25"));
			inventory.setItem(29, getItem(player, "sklepitemy26"));
			inventory.setItem(30, getItem(player, "sklepitemy27"));
			inventory.setItem(31, getItem(player, "sklepitemy28"));
			inventory.setItem(32, getItem(player, "sklepitemy29"));
			inventory.setItem(33, getItem(player, "sklepitemy30"));

			inventory.setItem(45, getItem(player, "arrowback"));
			inventory.setItem(53, getItem(player, "arrownext"));
			inventory.setItem(49, getItem(player, "powrot"));
			inventory.setItem(26, getItem(player, "sklepkupno"));
		}
		else if (type.equalsIgnoreCase("sklep_przedmioty_itemy3"))
		{
			inventory.setItem(9, getItem(player, "sklepitemyselected"));
			inventory.setItem(18, getItem(player, "sklepksiazki"));
			inventory.setItem(27, getItem(player, "sklepspecjalne"));

			inventory.setItem(11, getItem(player, "sklepitemy31"));
			inventory.setItem(12, getItem(player, "sklepitemy32"));
			inventory.setItem(13, getItem(player, "sklepitemy33"));
			inventory.setItem(14, getItem(player, "sklepitemy34"));
			inventory.setItem(15, getItem(player, "sklepitemy35"));
			inventory.setItem(20, getItem(player, "sklepitemy36"));
			inventory.setItem(21, getItem(player, "sklepitemy37"));
			inventory.setItem(22, getItem(player, "sklepitemy38"));
			inventory.setItem(23, getItem(player, "sklepitemy39"));
			inventory.setItem(24, getItem(player, "sklepitemy40"));
			inventory.setItem(29, getItem(player, "sklepitemy41"));
			inventory.setItem(30, getItem(player, "sklepitemy42"));
			inventory.setItem(31, getItem(player, "sklepitemy43"));
			inventory.setItem(32, getItem(player, "sklepitemy44"));
			inventory.setItem(33, getItem(player, "sklepitemy45"));

			inventory.setItem(45, getItem(player, "arrowback"));
			inventory.setItem(53, getItem(player, "arrownext"));
			inventory.setItem(49, getItem(player, "powrot"));
			inventory.setItem(26, getItem(player, "sklepkupno"));
		}
		else if (type.equalsIgnoreCase("sklep_przedmioty_itemy4"))
		{
			inventory.setItem(9, getItem(player, "sklepitemyselected"));
			inventory.setItem(18, getItem(player, "sklepksiazki"));
			inventory.setItem(27, getItem(player, "sklepspecjalne"));

			inventory.setItem(11, getItem(player, "sklepitemy46"));
			inventory.setItem(12, getItem(player, "sklepitemy47"));
			inventory.setItem(13, getItem(player, "sklepitemy48"));
			inventory.setItem(14, getItem(player, "sklepitemy49"));
			inventory.setItem(15, getItem(player, "sklepitemy50"));
			inventory.setItem(20, getItem(player, "sklepitemy51"));
			inventory.setItem(21, getItem(player, "sklepitemy52"));
			inventory.setItem(22, getItem(player, "sklepitemy53"));
			inventory.setItem(23, getItem(player, "sklepitemy54"));
			inventory.setItem(24, getItem(player, "sklepitemy55"));
			inventory.setItem(29, getItem(player, "sklepitemy56"));
			inventory.setItem(30, getItem(player, "sklepitemy57"));
			inventory.setItem(31, getItem(player, "sklepitemy58"));
			inventory.setItem(32, getItem(player, "sklepitemy59"));
			inventory.setItem(33, getItem(player, "sklepitemy60"));

			inventory.setItem(45, getItem(player, "arrowback"));
			inventory.setItem(53, getItem(player, "arrownext"));
			inventory.setItem(49, getItem(player, "powrot"));
			inventory.setItem(26, getItem(player, "sklepkupno"));
		}
		else if (type.equalsIgnoreCase("sklep_przedmioty_itemy5"))
		{
			inventory.setItem(9, getItem(player, "sklepitemyselected"));
			inventory.setItem(18, getItem(player, "sklepksiazki"));
			inventory.setItem(27, getItem(player, "sklepspecjalne"));

			inventory.setItem(11, getItem(player, "sklepitemy61"));
			inventory.setItem(12, getItem(player, "sklepitemy62"));
			inventory.setItem(13, getItem(player, "sklepitemy63"));
			inventory.setItem(14, getItem(player, "sklepitemy64"));
			inventory.setItem(15, getItem(player, "sklepitemy65"));
			inventory.setItem(20, getItem(player, "sklepitemy66"));
			inventory.setItem(21, getItem(player, "sklepitemy67"));
			inventory.setItem(22, getItem(player, "sklepitemy68"));
			inventory.setItem(23, getItem(player, "sklepitemy69"));
			inventory.setItem(24, getItem(player, "sklepitemy70"));
			inventory.setItem(29, getItem(player, "sklepitemy71"));
			inventory.setItem(30, getItem(player, "sklepitemy72"));
			inventory.setItem(31, getItem(player, "sklepitemy73"));
			inventory.setItem(32, getItem(player, "sklepitemy74"));
			inventory.setItem(33, getItem(player, "sklepitemy75"));

			inventory.setItem(45, getItem(player, "arrowback"));
			inventory.setItem(53, getItem(player, "arrownext"));
			inventory.setItem(49, getItem(player, "powrot"));
			inventory.setItem(26, getItem(player, "sklepkupno"));
		}
		else if (type.equalsIgnoreCase("sklep_przedmioty_itemy6"))
		{
			inventory.setItem(9, getItem(player, "sklepitemyselected"));
			inventory.setItem(18, getItem(player, "sklepksiazki"));
			inventory.setItem(27, getItem(player, "sklepspecjalne"));

			inventory.setItem(11, getItem(player, "sklepitemy76"));
			inventory.setItem(12, getItem(player, "sklepitemy77"));
			inventory.setItem(13, getItem(player, "sklepitemy78"));
			inventory.setItem(14, getItem(player, "sklepitemy79"));
			inventory.setItem(15, getItem(player, "sklepitemy80"));
			inventory.setItem(20, getItem(player, "sklepitemy81"));
			inventory.setItem(21, getItem(player, "sklepitemy82"));
			inventory.setItem(22, getItem(player, "sklepitemy83"));
			inventory.setItem(23, getItem(player, "sklepitemy84"));

			inventory.setItem(45, getItem(player, "arrowback"));
			inventory.setItem(53, getItem(player, "arrownext"));
			inventory.setItem(49, getItem(player, "powrot"));
			inventory.setItem(26, getItem(player, "sklepkupno"));
		}
		else if (type.equalsIgnoreCase("sklep_przedmioty_ksiazki"))
		{
			inventory.setItem(9, getItem(player, "sklepitemy"));
			inventory.setItem(18, getItem(player, "sklepksiazkiselected"));
			inventory.setItem(27, getItem(player, "sklepspecjalne"));

			inventory.setItem(11, getItem(player, "sklepksiazki1"));
			inventory.setItem(12, getItem(player, "sklepksiazki2"));
			inventory.setItem(13, getItem(player, "sklepksiazki3"));
			inventory.setItem(14, getItem(player, "sklepksiazki4"));
			inventory.setItem(15, getItem(player, "sklepksiazki5"));
			inventory.setItem(20, getItem(player, "sklepksiazki6"));
			inventory.setItem(21, getItem(player, "sklepksiazki7"));
			inventory.setItem(22, getItem(player, "sklepksiazki8"));
			inventory.setItem(23, getItem(player, "sklepksiazki9"));
			inventory.setItem(24, getItem(player, "sklepksiazki10"));
			inventory.setItem(29, getItem(player, "sklepksiazki11"));
			inventory.setItem(30, getItem(player, "sklepksiazki12"));
			inventory.setItem(31, getItem(player, "sklepksiazki13"));
			inventory.setItem(32, getItem(player, "sklepksiazki14"));
			inventory.setItem(33, getItem(player, "sklepksiazki15"));

			inventory.setItem(45, getItem(player, "arrowback"));
			inventory.setItem(53, getItem(player, "arrownext"));
			inventory.setItem(49, getItem(player, "powrot"));
			inventory.setItem(26, getItem(player, "sklepkupno"));
		}
		else if (type.equalsIgnoreCase("sklep_przedmioty_ksiazki2"))
		{
			inventory.setItem(9, getItem(player, "sklepitemy"));
			inventory.setItem(18, getItem(player, "sklepksiazkiselected"));
			inventory.setItem(27, getItem(player, "sklepspecjalne"));

			inventory.setItem(11, getItem(player, "sklepksiazki16"));
			inventory.setItem(12, getItem(player, "sklepksiazki17"));
			inventory.setItem(13, getItem(player, "sklepksiazki18"));
			inventory.setItem(14, getItem(player, "sklepksiazki19"));
			inventory.setItem(15, getItem(player, "sklepksiazki20"));
			inventory.setItem(20, getItem(player, "sklepksiazki21"));
			inventory.setItem(21, getItem(player, "sklepksiazki22"));
			inventory.setItem(22, getItem(player, "sklepksiazki23"));
			inventory.setItem(23, getItem(player, "sklepksiazki24"));

			inventory.setItem(45, getItem(player, "arrowback"));
			inventory.setItem(53, getItem(player, "arrownext"));
			inventory.setItem(49, getItem(player, "powrot"));
			inventory.setItem(26, getItem(player, "sklepkupno"));
		}
		else if (type.equalsIgnoreCase("sklep_przedmioty_specjalne"))
		{
			inventory.setItem(9, getItem(player, "sklepitemy"));
			inventory.setItem(18, getItem(player, "sklepksiazki"));
			inventory.setItem(27, getItem(player, "sklepspecjalneselected"));

			inventory.setItem(11, getItem(player, "sklepspecjalne1"));
			inventory.setItem(12, getItem(player, "sklepspecjalne2"));
			inventory.setItem(13, getItem(player, "sklepspecjalne3"));
			inventory.setItem(14, getItem(player, "sklepspecjalne4"));
			inventory.setItem(15, getItem(player, "sklepspecjalne5"));
			inventory.setItem(20, getItem(player, "sklepspecjalne6"));

			inventory.setItem(45, getItem(player, "arrowback"));
			inventory.setItem(53, getItem(player, "arrownext"));
			inventory.setItem(49, getItem(player, "powrot"));
			inventory.setItem(26, getItem(player, "sklepkupno"));
		}
        else if (type.equalsIgnoreCase("questy"))
        {
            inventory.setItem(10, getItem(player, "questy1"));
            inventory.setItem(11, getItem(player, "questy2"));
            inventory.setItem(12, getItem(player, "questy3"));
            inventory.setItem(14, getItem(player, "questy4"));
            inventory.setItem(15, getItem(player, "questy5"));
            inventory.setItem(16, getItem(player, "questy6"));

            inventory.setItem(20, getItem(player, "questy7"));
            inventory.setItem(21, getItem(player, "questy8"));
            inventory.setItem(22, getItem(player, "questy9"));
            inventory.setItem(23, getItem(player, "questy10"));
            inventory.setItem(24, getItem(player, "questy11"));

            inventory.setItem(30, getItem(player, "questy12"));
            inventory.setItem(31, getItem(player, "questy13"));
            inventory.setItem(32, getItem(player, "questy14"));
        }
        else if (type.equalsIgnoreCase("postac"))
        {
			inventory.setItem(13, getItem(player, "postacloading"));
			inventory.setItem(20, getItem(player, "postacslub"));
			inventory.setItem(24, getItem(player, "postacgang"));
			inventory.setItem(31, getItem(player, "postacupgrades"));
			inventory.setItem(38, getItem(player, "postacupgrade1"));
			inventory.setItem(39, getItem(player, "postacupgrade2"));
			inventory.setItem(40, getItem(player, "postacupgrade3"));
			inventory.setItem(41, getItem(player, "postacupgrade4"));
			inventory.setItem(42, getItem(player, "postacupgrade5"));

			new BukkitRunnable()
			{
				@Override
				public void run()
				{
					inventory.setItem(13, getItem(player, "postacstatystyki"));
				}
			}.runTaskAsynchronously(Main.getInstance());
        }
		else if (type.equalsIgnoreCase("monopolowy"))
		{
			inventory.setItem(11, ChemistryDrug.getDrug(Chemistries.piwo));
			inventory.setItem(12, ChemistryDrug.getDrug(Chemistries.wino));
			inventory.setItem(13, ChemistryDrug.getDrug(Chemistries.szampan));
			inventory.setItem(14, ChemistryDrug.getDrug(Chemistries.whisky));
			inventory.setItem(15, ChemistryDrug.getDrug(Chemistries.wodka));
			inventory.setItem(20, getItem(player, "monopolowypiwo"));
			inventory.setItem(21, getItem(player, "monopolowywino"));
			inventory.setItem(22, getItem(player, "monopolowyszampan"));
			inventory.setItem(23, getItem(player, "monopolowywhisky"));
			inventory.setItem(24, getItem(player, "monopolowywodka"));
		}
		else if (type.equalsIgnoreCase("drug_table_amina"))
		{
			new BukkitRunnable()
			{
				@Override
				public void run()
				{
					inventory.setItem(11, ChemistryDrug.getDrug(Chemistries.metyloamina));
					inventory.setItem(12, ChemistryDrug.getDrug(Chemistries.metylenoamina));
					inventory.setItem(13, ChemistryDrug.getDrug(Chemistries.fenyloamina));
					inventory.setItem(14, ChemistryDrug.getDrug(Chemistries.fluoroamina));
					inventory.setItem(15, ChemistryDrug.getDrug(Chemistries.dimetoamina));

                    inventory.setItem(30, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
					inventory.setItem(31, ChemistryDrug.getDrug(Chemistries.amina));
                    inventory.setItem(32, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

					inventory.setItem(45, getItem(player, "drug_table_info"));
					inventory.setItem(49, getItem(player, "powrot"));
					inventory.setItem(53, getItem(player, "drug_table_info2"));
				}
			}.runTaskAsynchronously(Main.getInstance());
		}
		else if (type.equalsIgnoreCase("drug_table_opium"))
		{
			new BukkitRunnable()
			{
				@Override
				public void run()
				{
					inventory.setItem(11, ChemistryDrug.getDrug(Chemistries.alprazolam));
					inventory.setItem(12, ChemistryDrug.getDrug(Chemistries.metylomorfina));
					inventory.setItem(13, ChemistryDrug.getDrug(Chemistries.morfina));
					inventory.setItem(14, ChemistryDrug.getDrug(Chemistries.heroina));
					inventory.setItem(15, ChemistryDrug.getDrug(Chemistries.fentanyl));

                    inventory.setItem(30, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    inventory.setItem(31, ChemistryDrug.getDrug(Chemistries.opium));
                    inventory.setItem(32, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

					inventory.setItem(45, getItem(player, "drug_table_info"));
					inventory.setItem(49, getItem(player, "powrot"));
					inventory.setItem(53, getItem(player, "drug_table_info2"));
				}
			}.runTaskAsynchronously(Main.getInstance());
		}
        else if (type.equalsIgnoreCase("drug_table_metyloamina"))
        {
            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    inventory.setItem(11, ChemistryDrug.getDrug(Chemistries.metamfetamina));
                    inventory.setItem(12, ChemistryDrug.getDrug(Chemistries.metafedron));
                    inventory.setItem(13, ChemistryDrug.getDrug(Chemistries.metylon));
                    inventory.setItem(14, ChemistryDrug.getDrug(Chemistries.metylometkatynon));
                    inventory.setItem(15, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

                    inventory.setItem(30, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    inventory.setItem(31, ChemistryDrug.getDrug(Chemistries.metyloamina));
                    inventory.setItem(32, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

                    inventory.setItem(45, getItem(player, "drug_table_info"));
                    inventory.setItem(49, getItem(player, "powrot"));
                    inventory.setItem(53, getItem(player, "drug_table_info2"));
                }
            }.runTaskAsynchronously(Main.getInstance());
        }
		else if (type.equalsIgnoreCase("drug_table_metylenoamina"))
		{
			new BukkitRunnable()
			{
				@Override
				public void run()
				{
					inventory.setItem(11, ChemistryDrug.getDrug(Chemistries.MDA));
					inventory.setItem(12, ChemistryDrug.getDrug(Chemistries.MDMA));
					inventory.setItem(13, ChemistryDrug.getDrug(Chemistries.MDPV));
					inventory.setItem(14, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
					inventory.setItem(15, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

					inventory.setItem(30, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
					inventory.setItem(31, ChemistryDrug.getDrug(Chemistries.metylenoamina));
					inventory.setItem(32, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

					inventory.setItem(45, getItem(player, "drug_table_info"));
					inventory.setItem(49, getItem(player, "powrot"));
					inventory.setItem(53, getItem(player, "drug_table_info2"));
				}
			}.runTaskAsynchronously(Main.getInstance());
		}
		else if (type.equalsIgnoreCase("drug_table_fenyloamina"))
		{
			new BukkitRunnable()
			{
				@Override
				public void run()
				{
					inventory.setItem(11, ChemistryDrug.getDrug(Chemistries.amfetamina));
					inventory.setItem(12, ChemistryDrug.getDrug(Chemistries.mefedron));
					inventory.setItem(13, ChemistryDrug.getDrug(Chemistries.klefedron));
					inventory.setItem(14, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
					inventory.setItem(15, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

					inventory.setItem(30, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
					inventory.setItem(31, ChemistryDrug.getDrug(Chemistries.fenyloamina));
					inventory.setItem(32, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

					inventory.setItem(45, getItem(player, "drug_table_info"));
					inventory.setItem(49, getItem(player, "powrot"));
					inventory.setItem(53, getItem(player, "drug_table_info2"));
				}
			}.runTaskAsynchronously(Main.getInstance());
		}
		else if (type.equalsIgnoreCase("drug_table_fluoroamina"))
		{
			new BukkitRunnable()
			{
				@Override
				public void run()
				{
					inventory.setItem(11, ChemistryDrug.getDrug(Chemistries.fluoroamfetamina));
					inventory.setItem(12, ChemistryDrug.getDrug(Chemistries.flefedron));
					inventory.setItem(13, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
					inventory.setItem(14, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
					inventory.setItem(15, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

					inventory.setItem(30, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
					inventory.setItem(31, ChemistryDrug.getDrug(Chemistries.fluoroamina));
					inventory.setItem(32, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

					inventory.setItem(45, getItem(player, "drug_table_info"));
					inventory.setItem(49, getItem(player, "powrot"));
					inventory.setItem(53, getItem(player, "drug_table_info2"));
				}
			}.runTaskAsynchronously(Main.getInstance());
		}
		else if (type.equalsIgnoreCase("drug_table_dimetoamina"))
		{
			new BukkitRunnable()
			{
				@Override
				public void run()
				{
					inventory.setItem(11, ChemistryDrug.getDrug(Chemistries.kokaina));
					inventory.setItem(12, ChemistryDrug.getDrug(Chemistries.kleksedron));
					inventory.setItem(13, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
					inventory.setItem(14, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
					inventory.setItem(15, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

					inventory.setItem(30, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
					inventory.setItem(31, ChemistryDrug.getDrug(Chemistries.dimetoamina));
					inventory.setItem(32, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

					inventory.setItem(45, getItem(player, "drug_table_info"));
					inventory.setItem(49, getItem(player, "powrot"));
					inventory.setItem(53, getItem(player, "drug_table_info2"));
				}
			}.runTaskAsynchronously(Main.getInstance());
		}

		player.openInventory(inventory);
		player.updateInventory();
	}

	public static String getName(Player player)
	{
		return player.getOpenInventory().getTitle();
	}

	private static void fillInventory(Inventory inventory)
	{
		int size = inventory.getSize();

		for (int slot = 0; slot < size; slot++)
		{
			inventory.setItem(slot, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
		}
	}

	public static ItemStack getItem(Player player, String name)
	{
		if (name.equalsIgnoreCase("home1"))
		{
			ArrayList<String> lore = new ArrayList<String>();
			String isExist = (String) FileManager.getInstance().data().get(DataManager.getInstance().getLocal(player).getPlayer() + ".data.home1.world");

			if (isExist.equalsIgnoreCase("none"))
			{
				String[] no = {"&c&l» &a&lDOM 1", "", "&c&l» &aWspolrzedne:", " &8> &7Swiat : <brak danych>", " &8> &7X : <brak danych>"
						, " &8> &7Y : <brak danych>", " &8> &7Z : <brak danych>", " &8> &7Yaw : <brak danych>", " &8> &7Pitch : <brak danych>"
						, "", ColorUtil.formatHEX("   #666666(LPM - Teleportacja do domku"), ColorUtil.formatHEX("   #666666PPM - Zmiana miejsca polozenia domku)"), ""};

				for (String vers : no)
					lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}
			else
			{
				String[] yes  = {"&c&l» &a&lDOM 1", "", "&c&l» &aWspolrzedne:", " &8> &7Swiat : " + Objects.requireNonNull(DataManager.getInstance().getLocal(player).getHome("1").getWorld()).getName(), " &8> &7X : " + DataManager.getInstance().getLocal(player).getHome("1").getX()
						, " &8> &7Y : " + DataManager.getInstance().getLocal(player).getHome("1").getY(), " &8> &7Z : " + + DataManager.getInstance().getLocal(player).getHome("1").getZ(), " &8> &7Yaw : " + DataManager.getInstance().getLocal(player).getHome("1").getYaw(), " &8> &7Pitch : " + DataManager.getInstance().getLocal(player).getHome("1").getPitch()
						, "", ColorUtil.formatHEX("   #666666(LPM - Teleportacja do domku"), ColorUtil.formatHEX("   #666666PPM - Zmiana miejsca polozenia domku)"), ""};

				for (String vers : yes)
					lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}

			ItemStack item = new ItemStack(Material.OAK_DOOR);
			ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(" ");
			meta.setLore(lore);
			item.setItemMeta(meta);

			return item;
		}

		if (name.equalsIgnoreCase("home2"))
		{
			ArrayList<String> lore = new ArrayList<String>();
			String isExist = (String) FileManager.getInstance().data().get(DataManager.getInstance().getLocal(player).getPlayer() + ".data.home2.world");

			if (isExist.equalsIgnoreCase("none"))
			{
				String[] no = {"&c&l» &a&lDOM 2", "", "&c&l» &aWspolrzedne:", " &8> &7Swiat : <brak danych>", " &8> &7X : <brak danych>"
						, " &8> &7Y : <brak danych>", " &8> &7Z : <brak danych>", " &8> &7Yaw : <brak danych>", " &8> &7Pitch : <brak danych>"
						, "", ColorUtil.formatHEX("   #666666(LPM - Teleportacja do domku"), ColorUtil.formatHEX("   #666666PPM - Zmiana miejsca polozenia domku)"), ""};

				for (String vers : no)
					lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}
			else
			{
				String[] yes  = {"&c&l» &a&lDOM 2", "", "&c&l» &aWspolrzedne:", " &8> &7Swiat : " + DataManager.getInstance().getLocal(player).getHome("2").getWorld().getName(), " &8> &7X : " + DataManager.getInstance().getLocal(player).getHome("2").getX()
						, " &8> &7Y : " + DataManager.getInstance().getLocal(player).getHome("2").getY(), " &8> &7Z : " + + DataManager.getInstance().getLocal(player).getHome("2").getZ(), " &8> &7Yaw : " + DataManager.getInstance().getLocal(player).getHome("2").getYaw(), " &8> &7Pitch : " + DataManager.getInstance().getLocal(player).getHome("2").getPitch()
						, "", ColorUtil.formatHEX("   #666666(LPM - Teleportacja do domku"), ColorUtil.formatHEX("   #666666PPM - Zmiana miejsca polozenia domku)"), ""};

				for (String vers : yes)
					lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}

			ItemStack item = new ItemStack(Material.OAK_DOOR);
			ItemMeta meta = item.getItemMeta();

			meta.setDisplayName(" ");
			meta.setLore(lore);
			item.setItemMeta(meta);

			return item;
		}

		if (name.equalsIgnoreCase("homeinfo"))
		{
			String[] lore = {"&c&l» &a&lINFORMACJE", "", "&c&l» &7Domki sluza do szybkiej teleportacji", "   &7miedzy wybranymi lokacjami na swiecie!", "",
							"&c&l» &7Kazdy gracz ma przypisane dwa", "   &7mozliwe do ustawienia i uzycia domki!", ""};

			return createInvItem(lore, Material.BOOK, false);
		}

		if (name.equalsIgnoreCase("schowekinfo"))
		{
			String[] lore = {"&c&l» &a&lINFORMACJE", "", "&c&l» &7Za pomoca ulepszenia schowku", "   &7otrzymujesz mozliwosc powiekszenia go!", "",
							"&c&l» &7Kazdy gracz ma poczatkowo 27 slotow,", "   &7ktore moze powiekszyc do az 54!", ""};

			return createInvItem(lore, Material.BOOK, false);
		}

		if (name.equalsIgnoreCase("schowek1"))
		{
			String[] lore = {"&c&l» &a&lULEPSZENIE", "", "&c&l» &7Kazdorazowe ulepszenie schowku powieksza", "   &7go o 9 slotow, co jest rowne jednemu paskowi.", "   &7Zakup jest finalny i nie ma mozliwosci cofniecia go!", "", ColorUtil.formatHEX("&c&l» &7Cena: #ffc936200 ⛃"),
					ColorUtil.formatHEX(" &8> &7Aktualny poziom #80ff1f" + (DataManager.getInstance().getLocal(player).getSchowekLevel() + 1) + "&7/#80ff1f4"), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno ulepszenia)"), ""};

			return createInvItem(lore, Material.DIAMOND_PICKAXE, false);
		}

		if (name.equalsIgnoreCase("pomocinfo"))
		{
			String[] lore = {"&c&l» &a&lCENTRUM POMOCY SERWERA", "", "&c&l» &7Ponizej znajdziesz liste wszystkich", "   &7komend na serwerze, wskazowki i informacje!", "",
							"&c&l» &7Mamy nadzieje, ze uda Ci sie rozwiazac", "   &7problem!", ""};

			return createInvItem(lore, Material.BOOK, true);
		}

		if (name.equalsIgnoreCase("pomoc1"))
		{
			String[] lore = {"&c&l» &a&lKOMENDY", "", "&c&l» &7Wiecej informacji o danej komendzie", "   &7znajduje sie w GUI tej komendy, np.",
							"   &7wpisujac &c/dom &7otrzymasz pelen opis!", "",
							"  &c/&c&lCRAFTINGI&r&7 - wyswietla panel z dodanymi recepturami",
							"  &c/&c&lDOM&r&7 - pozwala ustawic Twoj dom",
							"  &c/&c&lGANG&r&7 - wyswietla sub-komendy systemu gangow",
							"  &c/&c&lPALETA&r&7 - ukazuje dodatkowe informacje o szacie kolorow",
							"  &c/&c&lPING &r&c(gracz)&r&7 - wyswietla Twoj aktualny ping",
							"  &c/&c&lPOMOC&r&7 - wyswietla centrum pomocy serwera",
							"  &c/&c&lPOSTAC&r&7 - wyswietla ulepszenia i statystyki twojej postaci",
							"  &c/&c&lPOWROT&r&7 - teleportuje gracza w ostatnie miejsce",
							"  &c/&c&lSCHOWEK &r&c(ulepsz) &r&7 - otwiera prywatny schowek gracza",
							"  &c/&c&lSKLEP&r&7 - otwiera menu sklepu serwera",
							"  &c/&c&lSLUB&r&7 - wyswietla sub-komendy systemu slubow",
							"  &c/&c&lSPAWN&r&7 - teleportuje gracza na spawn swiata",
							"  &c/&c&lTPA &r&c(gracz/akceptuj/odrzuc) [gracz]&r&7 - teleportacja",
							"  &c/&c&lQUESTY&r&7 - pokazuje dostepne zadania serwerowe",
							"  &c/&c&lWIADOMOSC &r&c(gracz) (tresc)&r&7 - wysysla prywatne wiadomosci",
							"  &c/&c&lZAPLAC &r&c(gracz) (ilosc)&r&7 - pozwala przelac pieniadze komus innemu", ""};

			return createInvItem(lore, Material.MAP, false);
		}

		if (name.equalsIgnoreCase("pomoc2"))
		{
			String[] lore = {"&c&l» &a&lSWIATY", "", "&c&l» &7Na serwerze istnieja 2 swiaty:", "   &7survivalowy oraz lobby, na obydwu",
							"   &7istnieje mozliwosc budowania i pozyskiwania", "   &7przedmiotow, ekspolorowania, itp.",
							"",
							"&c&l» &7Aby przeniesc sie z jednego na drugi",
							"   &7udaj sie do teleportera na lobby!",
							"",
							"&c&l» &7Mozesz ustawic &c/dom &7w roznych swiatach,",
							"   &7system teleportacji przeniesie Cie nawet",
							"   &7do piwnicy Natali PL!", ""};

			return createInvItem(lore, Material.GRASS_BLOCK, false);
		}

		if (name.equalsIgnoreCase("pomoc3"))
		{
			String[] lore = {"&c&l» &a&lPLACEHOLDERS", "", "&c&l» &7Jesli nie wiesz czegos o sobie, badz", "   &7chcesz komus cos szybko przekazac, mozesz",
					"   &7uzyc zamiennikow czatowych. Ponizej znajdziesz", "   &7ich liste:",
					"",
					"   &c%swiat%&7 - wyswietla aktualny swiat, w jakim sie znajdujesz",
					"   &c%xyz%&7 - pokazuje Twoje aktualne koordynaty",
					"   &c%ping%&7 - wyswietla Twoj aktualny ping",
					"   &c%monety%&7 - wyswietla ilosc monet jaka posiadasz",
					"   &c%zabojstwa%&7 - ukazuje liczbe zabitych przez Ciebie osob",
					"   &c%questy%&7 - wyswietla ilosc ukonczonych questow",
					"   &c%smierci%&7 - pokazuje ile razy odszedles z tego swiata",
					"   &c%item%&7 - pokazuje aktualnie trzymany przedmiot",
					"   &c%itemmeta%&7 - wyswietla szczegolowe informacje o",
					"   &7aktualnie trzymanym przedmiocie", ""};

			return createInvItem(lore, Material.OAK_TRAPDOOR, false);
		}

		if (name.equalsIgnoreCase("pomoc4"))
		{
			String[] lore = {"&c&l» &a&lREGULAMIN", "", "&c&l» &7Zaczniejmy od podstawowej hierarchii.", "   &7Administracja ma zawsze racje, chyba ze jest", "   &7pijana!",
							"",
							"&c&l» &7Milosc, przyjazn i muzyka - mowiac prosciej", "   &7postaraj sie przestrzegac podstawowych zasad", "   &7etyki, &minaczej ci zapierdole!",
							"",
							"&c&l» &7Serwer posiada wiezienie, znajdujace sie", "   &7w lochach, pod spawnem. Trafi tam kazdy, kto", "   &7na to zasluzy!",
							"",
							"&c&l» &7Do tych na odlocie - cheaty oraz inne rodzaje", "   &7wspomagaczy sa surowo zakazane! Griefing podlega", "   &7rowniez temu podpunktowi!", ""};

			return createInvItem(lore, Material.NETHER_STAR, false);
		}

		if (name.equalsIgnoreCase("pomoc5"))
		{
			String[] lore = {"&c&l» &a&lTARYFIKATOR", "", "&c&l» &7Nie ma dokladnie ustalonych kar za", "   &7zlamanie regulaminu, kazdorazowe jego nieprzestrzeganie", "   &7skutkuje nadanie jednej z 3 mozliwych pokut!",
			"",
			"&c&l» &e/mute &7jest lagodnym wymiarem kary, ktory", "   &7blokuje ci mozliwosc udzielania sie na czacie", "   &7na okreslony czas!",
			"",
			"&c&l» &e/kick &7jest lagodnym wymiarem kary, ktory", "   &7powoduje wyrzucenie cie z serwera!",
			"",
			"&c&l» &e/zakuj &7jest surowym wymiarem kary, ktory", "   &7uniemozliwia ci granie na serwerze!", ""};

			return createInvItem(lore, Material.DIAMOND_AXE, false);
		}

		if (name.equalsIgnoreCase("pomoc6"))
		{
			String[] lore = {"&c&l» &a&lWHITELISTA", "", "&c&l» &7Aby dolaczyc na serwer musisz znajdowac", "   &7sie na liscie osob do tego opowaznionych -", "   &7tzw. whitelist'y. Jezeli chcesz dodac na nia", "   &7jakas osobe napisz do nas na discordzie!", ""};

			return createInvItem(lore, Material.PAPER, false);
		}

		if (name.equalsIgnoreCase("pomoc7"))
		{
			String[] lore = {"&c&l» &a&lZGLASZANIE PROBLEMOW", "", "&c&l» &7Aby zglosic problem techniczny lub", "   &7zapisac jakas osobe na serwerowej", "   &7whiteliscie skontaktuj sie z &eEhide&a#7158&7!", "",
					"&c&l» &7Aby zglosic problem z graczem, np.", "   &7griefing, nieprzestrzeganie regulaminu,", "   &7itp. skontaktuj sie z &eProsek&a#1307&7!", "",
					ColorUtil.formatHEX("   #666666&o(W przypadku braku odpowiedzi, zglos"), ColorUtil.formatHEX("   #666666&oproblem bezposrednio na serwerze)"), ""};

			return createInvItem(lore, Material.EMERALD, false);
		}

		if (name.equalsIgnoreCase("arrownext"))
		{
			String[] lore = {"&c&l» &a&lNASTEPNA STRONA","", "&c&l» &7Kliknij, aby przejsc do nastepnej", "   &7strony w tej zakladce!", "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Przejscie do nastepnej strony)"),""};

			return createInvItem(lore, Material.ARROW, false);
		}

		if (name.equalsIgnoreCase("arrowback"))
		{
			String[] lore = {"&c&l» &a&lPOPRZEDNIA STRONA", "", "&c&l» &7Kliknij, aby cofnac sie do poprzedniej", "   &7strony w tej zakladce!", "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Przejscie do poprzedniej strony)"),""};

			return createInvItem(lore, Material.ARROW, false);
		}

		if (name.equalsIgnoreCase("powrot"))
		{
			String[] lore = {"&c&l» &a&lPOWROT", "", "&c&l» &7Kliknij, aby cofnac sie do poprzedniej", "   &7zakladki lub zamknac obecne menu!", "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Opuszczenie menu)"),""};

			return createInvItem(lore, Material.OAK_DOOR, false);
		}

		if (name.equalsIgnoreCase("paletainfo"))
		{
			String[] lore = {"&c&l» &a&lJAK UZYWAC 16.7M KOLOROW?", "", "&c&l» &7Tworzenie koloru polega na wpisaniu", "   &7go w postaci koloru HEX. Jak to zrobic?",
					"   &7Wpisz w Google fraze &o'hex color'&r&7, a nastepnie", "   &7wybierz swoj kolor i skopiuj jego postac HEX.", "", "&c&l» &7Przyklady takich kolorow to na przyklad:",
					"   &e#F83044&7, &e#8C8C8C &7czy &e#03FC41", "", "&c&l» &7Przykladowa wiadomosc: &e#03fc41Czesc!", ColorUtil.formatHEX(" &8> &7Finalny widok: #03fc41Czesc!"), ""};

			return createInvItem(lore, Material.BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepprzedmioty"))
		{
			String[] lore = {"&c&l» &a&lPRZEDMIOTY", "", "&c&l» &7W sklepie z przedmiotami mozesz nabyc", "   &7prestizowe przedmioty specjalne, ksiazki z enchantami,",
					"   &7mineraly oraz wiele innych blokow i surowcow!", "", ColorUtil.formatHEX("   #666666&o(LPM/PPM - Wybranie zakladki)"), ""};

			return createInvItem(lore, Material.GRASS_BLOCK, false);
		}

		if (name.equalsIgnoreCase("sklepefekty"))
		{
			String[] lore = {"&c&l» &a&lEFEKTY", "", "&c&l» &7W sklepie z efektami czekaja na Ciebie", "   &7mozliwe do zakupu efekty wielu mikstur,",
					"   &7ktore mozesz zakupic na pewien okres czasu!", "", ColorUtil.formatHEX("   #666666&o(LPM/PPM - Wybranie zakladki)"), ""};

			return createInvItem(lore, Material.HONEY_BOTTLE, false);
		}

		if (name.equalsIgnoreCase("sklepgangi"))
		{
			String[] lore = {"&c&l» &a&lGANGI", "", "&c&l» &7Specjalna zakladka, w ktorej znajduja sie", "   &7ulepszenia do Twojego gangu!", "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Wybranie zakladki)"), ""};

			return createInvItem(lore, Material.DIAMOND_SWORD, false);
		}

		if (name.equalsIgnoreCase("sklepdodatki"))
		{
			String[] lore = {"&c&l» &a&lDODATKI", "", "&c&l» &7W sklepie z dodatkami mozesz zakupic", "   &7kosmetyki oraz ulepszenia tylko dla Ciebie!",
					"   &7Jesli interesuje Cie zmiana koloru nicku,", "   &7mozliwosc powiekszenia pojemnosci swojego", "   &7schowku, itp. to nie czekaj i klikaj!", "", ColorUtil.formatHEX("   #666666&o(LPM/PPM - Wybranie zakladki)"), ""};

			return createInvItem(lore, Material.NETHER_STAR, false);
		}

		if (name.equalsIgnoreCase("sklepspeed"))
		{
			ArrayList<String> lore = new ArrayList<String>();
			String[] text = {"&c&l» &a&lSZYBKOSC", "", "&c&l» &7Mozesz zakupic i nalozyc na siebie", "   &7jeden z 10 dostepnych efektow mikstur. Pamietaj",
					"   &7ze wchodza one w interakcje z pewnymi substancjami,",
					"   &7wiec nie zaleca sie ich sumowania!", "", "&c&l» &7Efekt: &bSzybkosc", " &8> &7Nasilenie: 1",
					" &8> &7Czas dzialania: 3m/8m/30m", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203900 ⛃&7/#fff2031500 ⛃&7/#fff2034000 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno efektu na okres 3 minut"), ColorUtil.formatHEX("   #666666&o(SHIFT + LPM - Kupno efektu na okres 8 minut"),
					ColorUtil.formatHEX("   #666666&o(SCROLL - Kupno efektu na okres 30 minut"), ""};;

			for (String vers : text)
			{
				lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}
			ItemStack item = new ItemStack(Material.SPLASH_POTION);
			ItemMeta meta = item.getItemMeta();
			PotionMeta potion = (PotionMeta) meta;
			potion.setColor(Color.AQUA);
			potion.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			potion.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			potion.setBasePotionData(new PotionData(PotionType.WATER));

			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			meta.setLore(lore);
			item.setItemMeta(potion);

			return item;
		}

		if (name.equalsIgnoreCase("sklepjumpboost"))
		{
			ArrayList<String> lore = new ArrayList<String>();
			String[] text = {"&c&l» &a&lWYSOKI SKOK", "", "&c&l» &7Mozesz zakupic i nalozyc na siebie", "   &7jeden z 10 dostepnych efektow mikstur. Pamietaj",
					"   &7ze wchodza one w interakcje z pewnymi substancjami,",
					"   &7wiec nie zaleca sie ich sumowania!", "", "&c&l» &7Efekt: &aWysoki skok", " &8> &7Nasilenie: 4",
					" &8> &7Czas dzialania: 3m/8m/30m", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203900 ⛃&7/#fff2031500 ⛃&7/#fff2034000 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno efektu na okres 3 minut"), ColorUtil.formatHEX("   #666666&o(SHIFT + LPM - Kupno efektu na okres 8 minut"),
					ColorUtil.formatHEX("   #666666&o(SCROLL - Kupno efektu na okres 30 minut"), ""};;

			for (String vers : text)
			{
				lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}
			ItemStack item = new ItemStack(Material.SPLASH_POTION);
			ItemMeta meta = item.getItemMeta();
			PotionMeta potion = (PotionMeta) meta;
			potion.setColor(Color.GREEN);
			potion.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			potion.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			potion.setBasePotionData(new PotionData(PotionType.WATER));

			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			meta.setLore(lore);
			item.setItemMeta(potion);

			return item;
		}

		if (name.equalsIgnoreCase("sklephaste"))
		{
			ArrayList<String> lore = new ArrayList<String>();
			String[] text = {"&c&l» &a&lSZYBKOSC KOPANIA", "", "&c&l» &7Mozesz zakupic i nalozyc na siebie", "   &7jeden z 10 dostepnych efektow mikstur. Pamietaj",
					"   &7ze wchodza one w interakcje z pewnymi substancjami,",
					"   &7wiec nie zaleca sie ich sumowania!", "", "&c&l» &7Efekt: &eSzybkosc kopania", " &8> &7Nasilenie: 1",
					" &8> &7Czas dzialania: 3m/8m/30m", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203900 ⛃&7/#fff2031500 ⛃&7/#fff2034000 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno efektu na okres 3 minut"), ColorUtil.formatHEX("   #666666&o(SHIFT + LPM - Kupno efektu na okres 8 minut"),
					ColorUtil.formatHEX("   #666666&o(SCROLL - Kupno efektu na okres 30 minut"), ""};;

			for (String vers : text)
			{
				lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}
			ItemStack item = new ItemStack(Material.SPLASH_POTION);
			ItemMeta meta = item.getItemMeta();
			PotionMeta potion = (PotionMeta) meta;
			potion.setColor(Color.YELLOW);
			potion.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			potion.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			potion.setBasePotionData(new PotionData(PotionType.WATER));

			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			meta.setLore(lore);
			item.setItemMeta(potion);

			return item;
		}

		if (name.equalsIgnoreCase("sklepstrength"))
		{
			ArrayList<String> lore = new ArrayList<String>();
			String[] text = {"&c&l» &a&lSILA", "", "&c&l» &7Mozesz zakupic i nalozyc na siebie", "   &7jeden z 10 dostepnych efektow mikstur. Pamietaj",
					"   &7ze wchodza one w interakcje z pewnymi substancjami,",
					"   &7wiec nie zaleca sie ich sumowania!", "", "&c&l» &7Efekt: &dSila", " &8> &7Nasilenie: 1",
					" &8> &7Czas dzialania: 3m/8m/30m", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203900 ⛃&7/#fff2031500 ⛃&7/#fff2034000 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno efektu na okres 3 minut"), ColorUtil.formatHEX("   #666666&o(SHIFT + LPM - Kupno efektu na okres 8 minut"),
					ColorUtil.formatHEX("   #666666&o(SCROLL - Kupno efektu na okres 30 minut"), ""};;

			for (String vers : text)
			{
				lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}
			ItemStack item = new ItemStack(Material.SPLASH_POTION);
			ItemMeta meta = item.getItemMeta();
			PotionMeta potion = (PotionMeta) meta;
			potion.setColor(Color.FUCHSIA);
			potion.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			potion.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			potion.setBasePotionData(new PotionData(PotionType.WATER));

			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			meta.setLore(lore);
			item.setItemMeta(potion);

			return item;
		}

		if (name.equalsIgnoreCase("sklepresistance"))
		{
			ArrayList<String> lore = new ArrayList<String>();
			String[] text = {"&c&l» &a&lODPORNOSC", "", "&c&l» &7Mozesz zakupic i nalozyc na siebie", "   &7jeden z 10 dostepnych efektow mikstur. Pamietaj",
					"   &7ze wchodza one w interakcje z pewnymi substancjami,",
					"   &7wiec nie zaleca sie ich sumowania!", "", "&c&l» &7Efekt: &7Odpornosc", " &8> &7Nasilenie: 1",
					" &8> &7Czas dzialania: 3m/8m/30m", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203900 ⛃&7/#fff2031500 ⛃&7/#fff2034000 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno efektu na okres 3 minut"), ColorUtil.formatHEX("   #666666&o(SHIFT + LPM - Kupno efektu na okres 8 minut"),
					ColorUtil.formatHEX("   #666666&o(SCROLL - Kupno efektu na okres 30 minut"), ""};;

			for (String vers : text)
			{
				lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}
			ItemStack item = new ItemStack(Material.SPLASH_POTION);
			ItemMeta meta = item.getItemMeta();
			PotionMeta potion = (PotionMeta) meta;
			potion.setColor(Color.WHITE);
			potion.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			potion.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			potion.setBasePotionData(new PotionData(PotionType.WATER));

			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			meta.setLore(lore);
			item.setItemMeta(potion);

			return item;
		}

		if (name.equalsIgnoreCase("sklepfireresistance"))
		{
			ArrayList<String> lore = new ArrayList<String>();
			String[] text = {"&c&l» &a&lODPORNOSC NA OGIEN", "", "&c&l» &7Mozesz zakupic i nalozyc na siebie", "   &7jeden z 10 dostepnych efektow mikstur. Pamietaj",
					"   &7ze wchodza one w interakcje z pewnymi substancjami,",
					"   &7wiec nie zaleca sie ich sumowania!", "", "&c&l» &7Efekt: &6Odpornosc na ogien", " &8> &7Nasilenie: 2",
					" &8> &7Czas dzialania: 3m/8m/30m", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203900 ⛃&7/#fff2031500 ⛃&7/#fff2034000 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno efektu na okres 3 minut"), ColorUtil.formatHEX("   #666666&o(SHIFT + LPM - Kupno efektu na okres 8 minut"),
					ColorUtil.formatHEX("   #666666&o(SCROLL - Kupno efektu na okres 30 minut"), ""};;

			for (String vers : text)
			{
				lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}
			ItemStack item = new ItemStack(Material.SPLASH_POTION);
			ItemMeta meta = item.getItemMeta();
			PotionMeta potion = (PotionMeta) meta;
			potion.setColor(Color.ORANGE);
			potion.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			potion.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			potion.setBasePotionData(new PotionData(PotionType.WATER));

			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			meta.setLore(lore);
			item.setItemMeta(potion);

			return item;
		}

		if (name.equalsIgnoreCase("sklepregeneration"))
		{
			ArrayList<String> lore = new ArrayList<String>();
			String[] text = {"&c&l» &a&lREGENERACJA", "", "&c&l» &7Mozesz zakupic i nalozyc na siebie", "   &7jeden z 10 dostepnych efektow mikstur. Pamietaj",
					"   &7ze wchodza one w interakcje z pewnymi substancjami,",
					"   &7wiec nie zaleca sie ich sumowania!", "", "&c&l» &7Efekt: &cRegeneracja", " &8> &7Nasilenie: 1",
					" &8> &7Czas dzialania: 3m/8m/30m", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203900 ⛃&7/#fff2031500 ⛃&7/#fff2034000 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno efektu na okres 3 minut"), ColorUtil.formatHEX("   #666666&o(SHIFT + LPM - Kupno efektu na okres 8 minut"),
					ColorUtil.formatHEX("   #666666&o(SCROLL - Kupno efektu na okres 30 minut"), ""};;

			for (String vers : text)
			{
				lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}
			ItemStack item = new ItemStack(Material.SPLASH_POTION);
			ItemMeta meta = item.getItemMeta();
			PotionMeta potion = (PotionMeta) meta;
			potion.setColor(Color.RED);
			potion.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			potion.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			potion.setBasePotionData(new PotionData(PotionType.WATER));

			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			meta.setLore(lore);
			item.setItemMeta(potion);

			return item;
		}

		if (name.equalsIgnoreCase("sklepinvis"))
		{
			ArrayList<String> lore = new ArrayList<String>();
			String[] text = {"&c&l» &a&lNIEWIDZIALNOSC", "", "&c&l» &7Mozesz zakupic i nalozyc na siebie", "   &7jeden z 10 dostepnych efektow mikstur. Pamietaj",
					"   &7ze wchodza one w interakcje z pewnymi substancjami,",
					"   &7wiec nie zaleca sie ich sumowania!", "", "&c&l» &7Efekt: &fNiewidzialnosc", " &8> &7Nasilenie: 2",
					" &8> &7Czas dzialania: 3m/8m/30m", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203900 ⛃&7/#fff2031500 ⛃&7/#fff2034000 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno efektu na okres 3 minut"), ColorUtil.formatHEX("   #666666&o(SHIFT + LPM - Kupno efektu na okres 8 minut"),
					ColorUtil.formatHEX("   #666666&o(SCROLL - Kupno efektu na okres 30 minut"), ""};;

			for (String vers : text)
			{
				lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}
			ItemStack item = new ItemStack(Material.SPLASH_POTION);
			ItemMeta meta = item.getItemMeta();
			PotionMeta potion = (PotionMeta) meta;
			potion.setColor(Color.SILVER);
			potion.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			potion.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			potion.setBasePotionData(new PotionData(PotionType.WATER));

			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			meta.setLore(lore);
			item.setItemMeta(potion);

			return item;
		}

		if (name.equalsIgnoreCase("sklepwaterbreathing"))
		{
			ArrayList<String> lore = new ArrayList<String>();
			String[] text = {"&c&l» &a&lODDYCHANIE POD WODA", "", "&c&l» &7Mozesz zakupic i nalozyc na siebie", "   &7jeden z 10 dostepnych efektow mikstur. Pamietaj",
					"   &7ze wchodza one w interakcje z pewnymi substancjami,",
					"   &7wiec nie zaleca sie ich sumowania!", "", "&c&l» &7Efekt: &1Oddychanie pod woda", " &8> &7Nasilenie: 1",
					" &8> &7Czas dzialania: 3m/8m/30m", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203900 ⛃&7/#fff2031500 ⛃&7/#fff2034000 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno efektu na okres 3 minut"), ColorUtil.formatHEX("   #666666&o(SHIFT + LPM - Kupno efektu na okres 8 minut"),
					ColorUtil.formatHEX("   #666666&o(SCROLL - Kupno efektu na okres 30 minut"), ""};;

			for (String vers : text)
			{
				lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}
			ItemStack item = new ItemStack(Material.SPLASH_POTION);
			ItemMeta meta = item.getItemMeta();
			PotionMeta potion = (PotionMeta) meta;
			potion.setColor(Color.NAVY);
			potion.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			potion.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			potion.setBasePotionData(new PotionData(PotionType.WATER));

			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			meta.setLore(lore);
			item.setItemMeta(potion);

			return item;
		}

		if (name.equalsIgnoreCase("sklepnightvision"))
		{
			ArrayList<String> lore = new ArrayList<String>();
			String[] text = {"&c&l» &a&lWIDZENIE W CIEMNOSCI", "", "&c&l» &7Mozesz zakupic i nalozyc na siebie", "   &7jeden z 10 dostepnych efektow mikstur. Pamietaj",
					"   &7ze wchodza one w interakcje z pewnymi substancjami,",
					"   &7wiec nie zaleca sie ich sumowania!", "", "&c&l» &7Efekt: &9Widzenie w ciemnosci", " &8> &7Nasilenie: 2",
					" &8> &7Czas dzialania: 3m/8m/30m", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203900 ⛃&7/#fff2031500 ⛃&7/#fff2034000 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno efektu na okres 3 minut"), ColorUtil.formatHEX("   #666666&o(SHIFT + LPM - Kupno efektu na okres 8 minut"),
					ColorUtil.formatHEX("   #666666&o(SCROLL - Kupno efektu na okres 30 minut"), ""};;

			for (String vers : text)
			{
				lore.add(ChatColor.translateAlternateColorCodes('&', vers));
			}
			ItemStack item = new ItemStack(Material.SPLASH_POTION);
			ItemMeta meta = item.getItemMeta();
			PotionMeta potion = (PotionMeta) meta;
			potion.setColor(Color.BLUE);
			potion.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			potion.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			potion.setBasePotionData(new PotionData(PotionType.WATER));

			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			meta.setLore(lore);
			item.setItemMeta(potion);

			return item;
		}

		if (name.equalsIgnoreCase("sklepschowek"))
		{
			String[] lore = {"&c&l» &a&lPOWIEKSZENIE SCHOWKU", "", "&c&l» &7Kliknij aby przeniesc sie do menu ulepszenia", "   &7schowku!", "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Wybranie zakladki)"), ""};

			return createInvItem(lore, Material.CHEST, false);
		}

		if (name.equalsIgnoreCase("sklepvoucher"))
		{
			String[] lore = {"&c&l» &a&lVOUCHER NA UNMUTE", "", "&c&l» &7Dodatek ten pozwoli Ci zdjac nalozone", "   &7wyciszenie na czacie, usuwajac je. Jezeli nie", "   &7jestes wyciszony - nie bedziesz w stanie zakupic",
					"   &7tego przedmiotu. Zakup jest finalny i jednorazowy!", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203300 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Zakup vouchera)"), ""};

			return createInvItem(lore, Material.MAP, false);
		}

		if (name.equalsIgnoreCase("sklepslub"))
		{
			String[] lore = {"&c&l» &a&lSLUB", "", "&c&l» &7Mozesz wziac slub z dowolnym graczem", "   &7kompletnie za darmo za pomoca komendy &c/slub!", "",
							"&c&l» &7Pre-view Twojego nicku przed slubem:", " &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.getGangInChat(DataManager.getInstance().getLocal(player).getGang()) + "&c" + "&r" + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
							"&c&l» &7Pre-view Twojego nicku po slubie:", " &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.getGangInChat(DataManager.getInstance().getLocal(player).getGang()) + "&c❤ #fc7474" + "&r" + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",};

			return createInvItem(lore, Material.POPPY, false);
		}

		if (name.equalsIgnoreCase("sklepkolor1"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU NICKU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow nicku na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.getGangInChat(DataManager.getInstance().getLocal(player).getGang()) + "&c" + ChatUtil.returnMarryPrefix(player) +  "&r#fc7474" + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					ColorUtil.formatHEX("&c&l» &7Kolor: #fc7474CZERWONY"), " &8> &7Oznaczenie HEX: #fc7474", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203400 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isPlayerColor(player, "#fc7474")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.RED_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepkolor2"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU NICKU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow nicku na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.getGangInChat(DataManager.getInstance().getLocal(player).getGang()) + "&c" + ChatUtil.returnMarryPrefix(player) +  "&r#3075ff" + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					ColorUtil.formatHEX("&c&l» &7Kolor: #3075ffNIEBIESKI"), " &8> &7Oznaczenie HEX: #3075ff", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203400 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isPlayerColor(player, "#3075ff")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.LIGHT_BLUE_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepkolor3"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU NICKU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow nicku na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.getGangInChat(DataManager.getInstance().getLocal(player).getGang()) + "&c" + ChatUtil.returnMarryPrefix(player) +  "&r#02d645" + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					ColorUtil.formatHEX("&c&l» &7Kolor: #02d645ZIELONY"), " &8> &7Oznaczenie HEX: #02d645", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203400 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isPlayerColor(player, "#02d645")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.LIME_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepkolor4"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU NICKU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow nicku na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.getGangInChat(DataManager.getInstance().getLocal(player).getGang()) + "&c" + ChatUtil.returnMarryPrefix(player) +  "&r#fcff33" + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					ColorUtil.formatHEX("&c&l» &7Kolor: #fcff33ZOLTY"), " &8> &7Oznaczenie HEX: #fcff33", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203400 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isPlayerColor(player, "#fcff33")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.YELLOW_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepkolor5"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU NICKU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow nicku na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.getGangInChat(DataManager.getInstance().getLocal(player).getGang()) + "&c" + ChatUtil.returnMarryPrefix(player) +  "&r#ffffff" + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					ColorUtil.formatHEX("&c&l» &7Kolor: #ffffffBIALY"), " &8> &7Oznaczenie HEX: #ffffff", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203400 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isPlayerColor(player, "#ffffff")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.WHITE_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepkolor6"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU NICKU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow nicku na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.getGangInChat(DataManager.getInstance().getLocal(player).getGang()) + "&c" + ChatUtil.returnMarryPrefix(player) +  "&r#242424" + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					ColorUtil.formatHEX("&c&l» &7Kolor: #242424SZARY"), " &8> &7Oznaczenie HEX: #242424", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203400 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isPlayerColor(player, "#242424")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.LIGHT_GRAY_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepkolor7"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU NICKU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow nicku na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.getGangInChat(DataManager.getInstance().getLocal(player).getGang()) + "&c" + ChatUtil.returnMarryPrefix(player) +  "&r#ffb338" + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					ColorUtil.formatHEX("&c&l» &7Kolor: #ffb338POMARANCZOWY"), " &8> &7Oznaczenie HEX: #ffb338", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203400 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isPlayerColor(player, "#ffb338")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.ORANGE_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepkolor8"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU NICKU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow nicku na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.getGangInChat(DataManager.getInstance().getLocal(player).getGang()) + "&c" + ChatUtil.returnMarryPrefix(player) +  "&r#ff9ee7" + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					ColorUtil.formatHEX("&c&l» &7Kolor: #ff9ee7ROZOWY"), " &8> &7Oznaczenie HEX: #ff9ee7", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203400 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isPlayerColor(player, "#ff9ee7")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.PINK_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepnogang"))
		{
			String[] lore = {"&c&l» &a&lSKLEP GANGU", "", "&c&l» &7Ta zakladka sklepu jest niedostepna, poniewaz", "   &7nie nalezysz do zadnego z gangow!", "",
					ColorUtil.formatHEX("   #666666&o(Gang mozesz stworzyc za 1000⛃ za pomoca komendy"), ColorUtil.formatHEX("   #666666&o/gang stworz. Mozesz takze dolaczyc do istniejacego"),
					ColorUtil.formatHEX("   #666666&ojuz gangu, lecz musisz najpierw otrzymac zaproszenie)"), ""};

			return createInvItem(lore, Material.BARRIER, false);
		}

		if (name.equalsIgnoreCase("sklepgang1"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU GANGU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow gangu na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru gangu:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.returnCustomGangPrefix(player, "&c", DataManager.getInstance().getLocal(player).getPrefixes(DataManager.getInstance().getLocal(player).getGang()), ChatUtil.returnGangStar(DataManager.getInstance().getLocal(player).getGang())) + "&c" + ChatUtil.returnMarryPrefix(player) + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					"&c&l» &7Kolor: &cCZERWONY", " &8> &7Oznaczenie Bukkit: & c", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203250 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isGangColor(DataManager.getInstance().getLocal(player).getGang(), "&c")), "",
					 ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.RED_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepgang2"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU GANGU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow gangu na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru gangu:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.returnCustomGangPrefix(player, "&b", DataManager.getInstance().getLocal(player).getPrefixes(DataManager.getInstance().getLocal(player).getGang()), ChatUtil.returnGangStar(DataManager.getInstance().getLocal(player).getGang())) + "&c" + ChatUtil.returnMarryPrefix(player) + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					"&c&l» &7Kolor: &bNIEBIESKI", " &8> &7Oznaczenie Bukkit: & b", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203250 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isGangColor(DataManager.getInstance().getLocal(player).getGang(), "&b")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.LIGHT_BLUE_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepgang3"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU GANGU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow gangu na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru gangu:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.returnCustomGangPrefix(player, "&a", DataManager.getInstance().getLocal(player).getPrefixes(DataManager.getInstance().getLocal(player).getGang()), ChatUtil.returnGangStar(DataManager.getInstance().getLocal(player).getGang())) + "&c" + ChatUtil.returnMarryPrefix(player) + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					"&c&l» &7Kolor: &aZIELONY", " &8> &7Oznaczenie Bukkit: & a", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203250 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isGangColor(DataManager.getInstance().getLocal(player).getGang(), "&a")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.LIME_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepgang4"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU GANGU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow gangu na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru gangu:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.returnCustomGangPrefix(player, "&e", DataManager.getInstance().getLocal(player).getPrefixes(DataManager.getInstance().getLocal(player).getGang()), ChatUtil.returnGangStar(DataManager.getInstance().getLocal(player).getGang())) + "&c" + ChatUtil.returnMarryPrefix(player) + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					"&c&l» &7Kolor: &eZOLTY", " &8> &7Oznaczenie Bukkit: & e", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203250 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isGangColor(DataManager.getInstance().getLocal(player).getGang(), "&e")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.YELLOW_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepgang5"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU GANGU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow gangu na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru gangu:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.returnCustomGangPrefix(player, "&f", DataManager.getInstance().getLocal(player).getPrefixes(DataManager.getInstance().getLocal(player).getGang()), ChatUtil.returnGangStar(DataManager.getInstance().getLocal(player).getGang())) + "&c" + ChatUtil.returnMarryPrefix(player) + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					"&c&l» &7Kolor: &fBIALY", " &8> &7Oznaczenie Bukkit: & f", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203250 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isGangColor(DataManager.getInstance().getLocal(player).getGang(), "&f")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.WHITE_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepgang6"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU GANGU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow gangu na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru gangu:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.returnCustomGangPrefix(player, "&7", DataManager.getInstance().getLocal(player).getPrefixes(DataManager.getInstance().getLocal(player).getGang()), ChatUtil.returnGangStar(DataManager.getInstance().getLocal(player).getGang())) + "&c" + ChatUtil.returnMarryPrefix(player) + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					"&c&l» &7Kolor: &7SZARY", " &8> &7Oznaczenie Bukkit: & 7", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203250 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isGangColor(DataManager.getInstance().getLocal(player).getGang(), "&7")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.LIGHT_GRAY_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepgang7"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU GANGU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow gangu na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru gangu:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.returnCustomGangPrefix(player, "&6", DataManager.getInstance().getLocal(player).getPrefixes(DataManager.getInstance().getLocal(player).getGang()), ChatUtil.returnGangStar(DataManager.getInstance().getLocal(player).getGang())) + "&c" + ChatUtil.returnMarryPrefix(player) + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					"&c&l» &7Kolor: &6POMARANCZOWY", " &8> &7Oznaczenie Bukkit: & 6", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203250 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isGangColor(DataManager.getInstance().getLocal(player).getGang(), "&6")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.ORANGE_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepgang8"))
		{
			String[] lore = {"&c&l» &a&lZMIANA KOLORU GANGU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 8 dostepnych", "   &7kolorow gangu na czacie. Pamietaj jednak", "   &7ze zakup koloru jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego koloru gangu:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.returnCustomGangPrefix(player, "&d", DataManager.getInstance().getLocal(player).getPrefixes(DataManager.getInstance().getLocal(player).getGang()), ChatUtil.returnGangStar(DataManager.getInstance().getLocal(player).getGang())) + "&c" + ChatUtil.returnMarryPrefix(player) + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					"&c&l» &7Kolor: &dROZOWY", " &8> &7Oznaczenie Bukkit: & d", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203250 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isGangColor(DataManager.getInstance().getLocal(player).getGang(), "&d")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.PINK_DYE, false);
		}

		if (name.equalsIgnoreCase("sklepgangp1"))
		{
			String[] lore = {"&c&l» &a&lZMIANA PREFIXOW GANGU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 3 dostepnych", "   &7prefixow gangu na czacie. Pamietaj jednak", "   &7ze zakup prefixow jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego prefixu gangu:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.returnCustomGangPrefix(player, ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()), "normal", ChatUtil.returnGangStar(DataManager.getInstance().getLocal(player).getGang())) + "&c" + ChatUtil.returnMarryPrefix(player) + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					"&c&l» &7Prefixy: Kwadratowe", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203350 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isGangPrefix(DataManager.getInstance().getLocal(player).getGang(), "normal")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.WOODEN_AXE, false);
		}

		if (name.equalsIgnoreCase("sklepgangp2"))
		{
			String[] lore = {"&c&l» &a&lZMIANA PREFIXOW GANGU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 3 dostepnych", "   &7prefixow gangu na czacie. Pamietaj jednak", "   &7ze zakup prefixow jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego prefixu gangu:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.returnCustomGangPrefix(player, ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()), "rounded", ChatUtil.returnGangStar(DataManager.getInstance().getLocal(player).getGang())) + "&c" + ChatUtil.returnMarryPrefix(player) + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					"&c&l» &7Prefixy: Zaokraglone", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203350 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isGangPrefix(DataManager.getInstance().getLocal(player).getGang(), "rounded")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.STONE_AXE, false);
		}

		if (name.equalsIgnoreCase("sklepgangp3"))
		{
			String[] lore = {"&c&l» &a&lZMIANA PREFIXOW GANGU", "", "&c&l» &7Mozesz dowolnie kupic jeden z 3 dostepnych", "   &7prefixow gangu na czacie. Pamietaj jednak", "   &7ze zakup prefixow jest finalny i jednorazowy!", "", "&c&l» &7Pre-view nowego prefixu gangu:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.returnCustomGangPrefix(player, ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()), "arrows", ChatUtil.returnGangStar(DataManager.getInstance().getLocal(player).getGang())) + "&c" + ChatUtil.returnMarryPrefix(player) + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					"&c&l» &7Prefixy: Strzalkowe", "", ColorUtil.formatHEX("&c&l» &7Cena: #fff203350 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isGangPrefix(DataManager.getInstance().getLocal(player).getGang(), "arrows")), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.GOLDEN_AXE, false);
		}

		if (name.equalsIgnoreCase("sklepgangchat"))
		{
			String[] lore = {"&c&l» &a&lPRYWATNY CZAT GANGU", "", "&c&l» &7Mozesz zakupic specjalny, ekskluzywny prywatny", "   &7czat dla czlonkow swojego gangu. Aby go wykorzystac", "   &7pzed swoja wiadomoscia wpisz znak &e!&7.", "", "&c&l» &7Pre-view prywatnego czatu gangu:",
					" &8> " + ColorUtil.formatHEX(ChatUtil.returnGangPlayerChatMessage(player, "!Czesc!")), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff203500 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isGangChat(DataManager.getInstance().getLocal(player).getGang())), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.FEATHER, false);
		}

		if (name.equalsIgnoreCase("sklepgangstar"))
		{
			String[] lore = {"&c&l» &a&lKOSMETYK GWIAZDY", "", "&c&l» &7Mozesz zakupic specjalny, ekskluzywny dodatek", "   &7do Twojego gangu na czacie, ktory uswiadomi", "   &7reszcie ktory gang jest najbogatszy!", "", "&c&l» &7Pre-view nowego wygladu gangu:",
					" &8> " + ColorUtil.formatHEX("#80ff1f[" + TimeUtil.hour() + ":" + TimeUtil.minute() + "#80ff1f] " + ChatUtil.returnCustomGangPrefix(player, ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()), DataManager.getInstance().getLocal(player).getPrefixes(DataManager.getInstance().getLocal(player).getGang()), "#ffc936★ ") + "&c" + ChatUtil.returnMarryPrefix(player) + ChatUtil.returnPlayerColor(player) + Objects.requireNonNull(player.getPlayer()).getName() + "#8c8c8c Czesc!"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff203900 ⛃"), " &8> &7Status posiadania: " + ColorUtil.formatHEX(ChatUtil.isGangStar(DataManager.getInstance().getLocal(player).getGang())), "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Kupno i zmiana)"), ""};

			return createInvItem(lore, Material.NETHER_STAR, false);
		}

		if (name.equalsIgnoreCase("sklepinfo"))
		{
			String[] lore = {"&c&l» &a&lWYBIERZ KATEGORIE", "", "&c&l» &7Wybierz interesujaca Cie zakladke, sposrod", "   &73 dostepnych po lewej stronie menu!", ""};

			return createInvItem(lore, Material.BARRIER, false);
		}

		if (name.equalsIgnoreCase("sklepkupno"))
		{
			String[] lore = {"&c&l» &a&lKUPNO I SPRZEDAZ", "", "&c&l» &7Aby kupic przedmiot, najedz na niego", "   &7i kliknij LPM, jesli chcesz sprzedac jakis",
					"   &7przedmiot - kliknij PPM. Dodatkowo kiedy uzyjesz", "   &7kombinacji SHIFT + LPM lub SHIFT + PPM, wowczas", "   &7manipulujesz calym stakiem danego przedmiotu!",
					"", "&c&l» &7Wszystkie dokonane kupna i sprzedaze w sklepie", "   &7sa finalne i nie ma mozliwosci ich cofniecia.", "   &7Oznacza to, ze jesli sie pomylisz i kupisz",
					"   &7cos innego - to chuj ci w dupie, sklep", "   &7umywa od ciebie rece!", ""};

			return createInvItem(lore, Material.GOLD_INGOT, false);
		}

		if (name.equalsIgnoreCase("sklepitemy"))

		{
			String[] lore = {"&c&l» &a&lPRZEDMIOTY, BLOKI I SUROWCE", "", "&c&l» &7Kategoria sklepu z przedmiotami zawierajaca", "   &7wiekszosc znanych Ci blokow, ktore mozesz",
					"&7   swobodnie zakupic lub sprzedac!", "", ColorUtil.formatHEX("   #666666&o(LPM/PPM - Wybranie zakladki)"), ""};

			return createInvItem(lore, Material.GRASS_BLOCK, false);
		}

		if (name.equalsIgnoreCase("sklepitemyselected"))
		{
			String[] lore = {"&c&l» &a&lPRZEDMIOTY, BLOKI I SUROWCE", "", "&c&l» &7Kategoria sklepu z przedmiotami zawierajaca", "   &7wiekszosc znanych Ci blokow, ktore mozesz",
					"&7   swobodnie zakupic lub sprzedac!", "", ColorUtil.formatHEX("   #666666&o(LPM/PPM - Wybranie zakladki)"), ""};

			return createInvItem(lore, Material.GRASS_BLOCK, true);
		}

		if (name.equalsIgnoreCase("sklepksiazki"))
		{
			String[] lore = {"&c&l» &a&lKSIAZKI Z ENCHANTAMI", "", "&c&l» &7Kategoria sklepu z enchantowanymi", "   &7ksiazkami, ktore mozesz zakupic juz teraz!", "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Wybranie zakladki)"), ""};

			return createInvItem(lore, Material.ENCHANTING_TABLE, false);
		}

		if (name.equalsIgnoreCase("sklepksiazkiselected"))
		{
			String[] lore = {"&c&l» &a&lKSIAZKI Z ENCHANTAMI", "", "&c&l» &7Kategoria sklepu z enchantowanymi", "   &7ksiazkami, ktore mozesz zakupic juz teraz!", "",
					ColorUtil.formatHEX("   #666666&o(LPM/PPM - Wybranie zakladki)"), ""};

			return createInvItem(lore, Material.ENCHANTING_TABLE, true);
		}

		if (name.equalsIgnoreCase("sklepspecjalne"))
		{
			String[] lore = {"&c&l» &a&lPRZEDMIOTY SPECJALNE", "", "&c&l» &7Kategoria sklepu z ekskluzywnymi itemami,", "   &7ktorych nie da sie wytworzyc w craftingu. Ich dzialanie",
					"   &7jest dokladnie opisane, a satysfakcja z jego posiadania", "   &7i mozliwosci - gwarantowana!", "", ColorUtil.formatHEX("   #666666&o(LPM/PPM - Wybranie zakladki)"), ""};

			return createInvItem(lore, Material.EMERALD, false);
		}

		if (name.equalsIgnoreCase("sklepspecjalneselected"))
		{
			String[] lore = {"&c&l» &a&lPRZEDMIOTY SPECJALNE", "", "&c&l» &7Kategoria sklepu z ekskluzywnymi itemami,", "   &7ktorych nie da sie wytworzyc w craftingu. Ich dzialanie",
							"   &7jest dokladnie opisane, a satysfakcja z jego posiadania", "   &7i jego mozliwosci - gwarantowana!", "", ColorUtil.formatHEX("   #666666&o(LPM/PPM - Wybranie zakladki)"), ""};

			return createInvItem(lore, Material.EMERALD, true);
		}

		if (name.equalsIgnoreCase("sklepksiazki1"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia: #80ff1fMending"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: #fc7474✖"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2034200 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki2"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia: #80ff1fInfinity"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: #fc7474✖"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2032700 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki3"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Silk Touch"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: #fc7474✖"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2033000 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki4"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Protection"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b4"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2033900 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki5"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Sharpness"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b5"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2033700 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki6"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Fire Aspect"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b2"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2032200 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki7"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Power"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b5"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2033900 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki8"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Flame"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: #fc7474✖"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2031400 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki9"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Punch"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b2"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2032900 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki10"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Efficiency"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b5"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2034000 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki11"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Unbreaking"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b3"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2032500 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki12"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Looting"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b3"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2033400 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki13"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Fortune"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b3"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2033600 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki14"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Feather Falling"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b4"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2033300 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki15"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Thorns"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b3"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2033000 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki16"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Depth Strider"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b3"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2033600 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki17"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Luck Of The Sea"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b3"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2032700 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki18"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Lure"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b3"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2032600 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki19"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Quick Charge"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b3"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2032400 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki20"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Channelling"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: #fc7474✖"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2032900 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki21"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Multishot"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: #fc7474✖"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2033500 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki22"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Impaling"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b5"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2033700 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki23"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Piercing"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b4"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2033400 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepksiazki24"))
		{
			String[] lore = {"&c&l» &a&lENCHANTOWANA KSIAZKA", "", "&c&l» &7Ksiazka zakleta na podany enchant, ktorej", "   &7mozesz uzyc by ulepszyc swoje przedmioty!", "",
					ColorUtil.formatHEX("&c&l» &7Rodzaj zaklecia:#80ff1f Riptide"), ColorUtil.formatHEX(" &8> &7Poziom zaklecia: &b3"), "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2031900 ⛃"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.ENCHANTED_BOOK, false);
		}

		if (name.equalsIgnoreCase("sklepspecjalne1"))
		{
			String[] lore = {"&c&l» &a&lNIEZNISZCZALNA KUSZA", "", "&c&l» &7Kusza z permanentnym zakleciem unbreakable,", "   &7ktore sprawi, ze Twoja kusza nigdy sie nie zepsuje!", "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2033100 ⛃"), "", ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.CROSSBOW, false);
		}

		if (name.equalsIgnoreCase("sklepspecjalne2"))
		{
			String[] lore = {"&c&l» &a&lNIEZNISZCZALNY KILOF", "", "&c&l» &7Kilof z permanentnym zakleciem unbreakable,", "   &7ktore sprawi, ze Twoj kilof nigdy sie nie zepsuje!", "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2034600 ⛃"), "", ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.GOLDEN_PICKAXE, false);
		}

		if (name.equalsIgnoreCase("sklepspecjalne3"))
		{
			String[] lore = {"&c&l» &a&lNIEZNISZCZALNA SIEKIERA", "", "&c&l» &7Siekiera z permanentnym zakleciem unbreakable,", "   &7ktore sprawi, ze Twoja siekiera nigdy sie nie zepsuje!", "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2032900 ⛃"), "", ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.GOLDEN_AXE, false);
		}

		if (name.equalsIgnoreCase("sklepspecjalne4"))
		{
			String[] lore = {"&c&l» &a&lNIEZNISZCZALNA LOPATA", "", "&c&l» &7Lopata z permanentnym zakleciem unbreakable,", "   &7ktore sprawi, ze Twoja lopata nigdy sie nie zepsuje!", "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2032600 ⛃"), "", ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.GOLDEN_SHOVEL, false);
		}

		if (name.equalsIgnoreCase("sklepspecjalne5"))
		{
			String[] lore = {"&c&l» &a&lNIEZNISZCZALNA MOTYKA", "", "&c&l» &7Motyka z permanentnym zakleciem unbreakable,", "   &7ktore sprawi, ze Twoja motyka nigdy sie nie zepsuje!", "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff2031400 ⛃"), "", ColorUtil.formatHEX("   #666666&o(LPM - Kupno przedmiotu)"), ""};

			return createInvItem(lore, Material.GOLDEN_HOE, false);
		}

		if (name.equalsIgnoreCase("sklepspecjalne6"))
		{
			String[] lore = {"&c&l» &a&lKOSA STACHA JONESA", "", "&c&l» &7Legendarna, magiczna kosa Stacha Jonesa,", "   &7z olbrzymia moca i bitewnymi mozliwosciami!", "",
					ColorUtil.formatHEX("&c&l» &7Cena: #fc747414 ukonczonych questow"), "", ColorUtil.formatHEX("   #666666&o(LPM - Odbior przedmiotu)"), ""};

			return createInvItem(lore, Material.STONE_HOE, true);
		}

		if (name.equalsIgnoreCase("sklepitemy1"))
			return createShopItem("cobblestone", Material.COBBLESTONE, 16, 4, 2);

		if (name.equalsIgnoreCase("sklepitemy2"))
			return createShopItem("netherrack", Material.NETHERRACK, 16, 4, 2);

		if (name.equalsIgnoreCase("sklepitemy3"))
			return createShopItem("kamien", Material.STONE, 16, 4, 3);

		if (name.equalsIgnoreCase("sklepitemy4"))
			return createShopItem("ziemia", Material.DIRT, 16, 8, 3);

		if (name.equalsIgnoreCase("sklepitemy5"))
			return createShopItem("blok trawy", Material.GRASS_BLOCK, 16, 16, 6);

		if (name.equalsIgnoreCase("sklepitemy6"))
			return createShopItem("blok netherowej trawy", Material.CRIMSON_NYLIUM, 16, 16, 8);

		if (name.equalsIgnoreCase("sklepitemy7"))
			return createShopItem("blok netherowej trawy", Material.WARPED_NYLIUM, 16, 16, 8);

		if (name.equalsIgnoreCase("sklepitemy8"))
			return createShopItem("granit", Material.GRANITE, 8, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy9"))
			return createShopItem("dioryt", Material.DIORITE, 8, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy10"))
			return createShopItem("andezyt", Material.ANDESITE, 8, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy11"))
			return createShopItem("zwir", Material.GRAVEL, 8, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy12"))
			return createShopItem("piasek", Material.SAND, 8, 4, 2);

		if (name.equalsIgnoreCase("sklepitemy13"))
			return createShopItem("sandstone", Material.SANDSTONE, 8, 4, 3);

		if (name.equalsIgnoreCase("sklepitemy14"))
			return createShopItem("czerwony piasek", Material.RED_SAND, 8, 8, 3);

		if (name.equalsIgnoreCase("sklepitemy15"))
			return createShopItem("czerwony sandstone", Material.RED_SANDSTONE, 8, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy16"))
			return createShopItem("drewno debowe", Material.OAK_LOG, 8, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy17"))
			return createShopItem("drewno swierkowe", Material.SPRUCE_LOG, 8, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy18"))
			return createShopItem("drewno brzozowe", Material.BIRCH_LOG, 8, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy19"))
			return createShopItem("drewno dzunglowe", Material.JUNGLE_LOG, 8, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy20"))
			return createShopItem("drewno akacjowe", Material.ACACIA_LOG, 8, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy21"))
			return createShopItem("drewno ciemnego debu", Material.DARK_OAK_LOG, 8, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy22"))
			return createShopItem("drewno netherowe", Material.CRIMSON_STEM, 8, 12, 6);

		if (name.equalsIgnoreCase("sklepitemy23"))
			return createShopItem("drewno netherowe", Material.WARPED_STEM, 8, 12, 6);

		if (name.equalsIgnoreCase("sklepitemy24"))
			return createShopItem("liscie debowe", Material.OAK_LEAVES, 16, 8, 3);

		if (name.equalsIgnoreCase("sklepitemy25"))
			return createShopItem("liscie swierkowe", Material.SPRUCE_LEAVES, 16, 8, 3);

		if (name.equalsIgnoreCase("sklepitemy26"))
			return createShopItem("liscie brzozowe", Material.BIRCH_LEAVES, 16, 8, 3);

		if (name.equalsIgnoreCase("sklepitemy27"))
			return createShopItem("liscie dzunglowe", Material.JUNGLE_LEAVES, 16, 8, 3);

		if (name.equalsIgnoreCase("sklepitemy28"))
			return createShopItem("liscie akacjowe", Material.ACACIA_LEAVES, 16, 8, 3);

		if (name.equalsIgnoreCase("sklepitemy29"))
			return createShopItem("liscie ciemnego debu", Material.DARK_OAK_LEAVES, 16, 8, 3);

		if (name.equalsIgnoreCase("sklepitemy30"))
			return createShopItem("blok sniegu", Material.SNOW_BLOCK, 8, 32, 16);

		if (name.equalsIgnoreCase("sklepitemy31"))
			return createShopItem("lod", Material.ICE, 8, 12, 8);

		if (name.equalsIgnoreCase("sklepitemy32"))
			return createShopItem("zbity lod", Material.PACKED_ICE, 8, 24, 12);

		if (name.equalsIgnoreCase("sklepitemy33"))
			return createShopItem("morska latarnia", Material.SEA_LANTERN, 1, 8, -1);

		if (name.equalsIgnoreCase("sklepitemy34"))
			return createShopItem("pryzmaryn", Material.PRISMARINE, 8, 16, -1);

		if (name.equalsIgnoreCase("sklepitemy35"))
			return createShopItem("ciemny pryzmaryn", Material.DARK_PRISMARINE, 8, 24, 12);

		if (name.equalsIgnoreCase("sklepitemy36"))
			return createShopItem("cegly netherowe", Material.NETHER_BRICKS, 8, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy37"))
			return createShopItem("jasnoglaz", Material.GLOWSTONE, 8, 24, 12);

		if (name.equalsIgnoreCase("sklepitemy38"))
			return createShopItem("piasek dusz", Material.SOUL_SAND, 8, 24, 6);

		if (name.equalsIgnoreCase("sklepitemy39"))
			return createShopItem("blackstone", Material.BLACKSTONE, 8, 8, 3);

		if (name.equalsIgnoreCase("sklepitemy40"))
			return createShopItem("obsydian", Material.OBSIDIAN, 8, 32, 16);

		if (name.equalsIgnoreCase("sklepitemy41"))
			return createShopItem("kamien kresu", Material.END_STONE, 16, 12, 8);

		if (name.equalsIgnoreCase("sklepitemy42"))
			return createShopItem("cegly kresu", Material.END_STONE_BRICKS, 8, 36, 23);

		if (name.equalsIgnoreCase("sklepitemy43"))
			return createShopItem("blok purpuru", Material.PURPUR_BLOCK, 8, 24, -1);

		if (name.equalsIgnoreCase("sklepitemy44"))
			return createShopItem("owoc chorusu", Material.CHORUS_FRUIT, 8, 32, 8);

		if (name.equalsIgnoreCase("sklepitemy45"))
			return createShopItem("kwiat chorusu", Material.CHORUS_FLOWER, 8, -1, 12);

		if (name.equalsIgnoreCase("sklepitemy46"))
			return createShopItem("szmaragd", Material.NETHERITE_INGOT, 1, 1000, 400);

		if (name.equalsIgnoreCase("sklepitemy47"))
			return createShopItem("szmaragd", Material.EMERALD, 1, 40, 20);

		if (name.equalsIgnoreCase("sklepitemy48"))
			return createShopItem("diament", Material.DIAMOND, 1, 160, 60);

		if (name.equalsIgnoreCase("sklepitemy49"))
			return createShopItem("zloto", Material.GOLD_INGOT, 1, 32, 6);

		if (name.equalsIgnoreCase("sklepitemy50"))
			return createShopItem("zelazo", Material.IRON_INGOT, 1, 16, 4);

		if (name.equalsIgnoreCase("sklepitemy51"))
			return createShopItem("kwarc", Material.QUARTZ, 8, 24, 16);

		if (name.equalsIgnoreCase("sklepitemy52"))
			return createShopItem("miedz", Material.COPPER_INGOT, 8, 24, 8);

		if (name.equalsIgnoreCase("sklepitemy53"))
			return createShopItem("redstone", Material.REDSTONE, 8, 12, 8);

		if (name.equalsIgnoreCase("sklepitemy54"))
			return createShopItem("lapis dla zuli", Material.LAPIS_LAZULI, 8, 24, 6);

		if (name.equalsIgnoreCase("sklepitemy55"))
			return createShopItem("wegiel", Material.COAL, 8, 12, 4);

		if (name.equalsIgnoreCase("sklepitemy56"))
			return createShopItem("pszenica", Material.WHEAT, 8, 12, 4);

		if (name.equalsIgnoreCase("sklepitemy57"))
			return createShopItem("marchewki", Material.CARROT, 8, 16, 6);

		if (name.equalsIgnoreCase("sklepitemy58"))
			return createShopItem("ziemniaki", Material.POTATO, 8, 12, 4);

		if (name.equalsIgnoreCase("sklepitemy59"))
			return createShopItem("melony", Material.MELON_SLICE, 8, 32, 6);

		if (name.equalsIgnoreCase("sklepitemy60"))
			return createShopItem("buraki", Material.BEETROOT, 8, 24, 8);

		if (name.equalsIgnoreCase("sklepitemy61"))
			return createShopItem("bambus", Material.BAMBOO, 16, 48, 4);

		if (name.equalsIgnoreCase("sklepitemy62"))
			return createShopItem("trzcina", Material.SUGAR_CANE, 8, 16, 8);

		if (name.equalsIgnoreCase("sklepitemy63"))
			return createShopItem("kaktus", Material.CACTUS, 8, 8, 6);

		if (name.equalsIgnoreCase("sklepitemy64"))
			return createShopItem("dynia", Material.PUMPKIN, 8, 12, 8);

		if (name.equalsIgnoreCase("sklepitemy65"))
			return createShopItem("jajka", Material.EGG, 8, 12, 4);

		if (name.equalsIgnoreCase("sklepitemy66"))
		    return createShopItem("jablko", Material.APPLE, 1, 8, 2);

		if (name.equalsIgnoreCase("sklepitemy67"))
		    return createShopItem("zlote jablko", Material.GOLDEN_APPLE, 1, 200, 64);

		if (name.equalsIgnoreCase("sklepitemy68"))
            return createShopItem("surowe mieso", Material.PORKCHOP, 16, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy69"))
            return createShopItem("surowe mieso", Material.MUTTON, 16, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy70"))
            return createShopItem("surowe mieso", Material.BEEF, 16, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy71"))
            return createShopItem("surowe mieso", Material.CHICKEN, 16, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy72"))
            return createShopItem("surowe mieso", Material.MUTTON, 16, 8, 4);

		if (name.equalsIgnoreCase("sklepitemy73"))
            return createShopItem("skora", Material.LEATHER, 8, 24, 12);

		if (name.equalsIgnoreCase("sklepitemy74"))
            return createShopItem("plastry miodu", Material.HONEYCOMB, 4, 16, 12);

		if (name.equalsIgnoreCase("sklepitemy75"))
            return createShopItem("brodawki", Material.NETHER_WART, 8, 48, 16);

		if (name.equalsIgnoreCase("sklepitemy76"))
		    return createShopItem("enderperla", Material.SLIME_BALL, 8, 64, -1);

		if (name.equalsIgnoreCase("sklepitemy77"))
            return createShopItem("enderperla", Material.ENDER_PEARL, 1, 32, 4);

		if (name.equalsIgnoreCase("sklepitemy78"))
            return createShopItem("blaze rod", Material.BLAZE_ROD, 1, 48, 8);

		if (name.equalsIgnoreCase("sklepitemy79"))
            return createShopItem("lza ghasta", Material.GHAST_TEAR, 1, 128, 32);

		if (name.equalsIgnoreCase("sklepitemy80"))
			return createShopItem("oko pajaka", Material.SPIDER_EYE, 1, 24, 8);

		if (name.equalsIgnoreCase("sklepitemy81"))
			return createShopItem("gunpowder", Material.GUNPOWDER, 8, 32, 16);

		if (name.equalsIgnoreCase("sklepitemy82"))
			return createShopItem("kosci", Material.BONE, 8, 24, 12);

		if (name.equalsIgnoreCase("sklepitemy83"))
			return createShopItem("nici", Material.STRING, 8, 24, 18);

		if (name.equalsIgnoreCase("sklepitemy84"))
			return createShopItem("gwiazda netheru", Material.NETHER_STAR, 1, -1, 25000);

        if (name.equalsIgnoreCase("postacslub"))
        {
            String[] lore = {""};

            if (DataManager.getInstance().getLocal(player).getMarry() == null)
                lore = new String[]{"&c&l» &a&lSLUB",
                        "",
                        "&c&l» &7Zakochanym wiedza o ich partnerze jest bardzo",
                        "   &7wazna, wszelkie informacje o Twoim zwiazku znajdziesz",
                        "   &7pod komenda /wyspy. Nie no zartuje, sa ponizej!",
                        "",
                        " &8> &7Jednak najpierw musze Cie czegos nauczyc..",
                        "   &7Nie posiadasz zadnego partnera, wiec",
                        "   &7sugeruje umyc swoj brzydki ryj, kupic",
                        "   &7cos ladnego i znalezc sobie kogos!",
                        ""};
            else
            {
                final int timexp = TimeUtil.getDifferenceInMinutes(DataManager.getInstance().getLocal(player).getMarryDate()) / 6;
                final int xp = DataManager.getInstance().getLocal(player).getMarryLevel() + DataManager.getInstance().getLocal(null).getMarryLevel(DataManager.getInstance().getLocal(player).getMarry()) + timexp;
                final int level = xp / 100;
                final String s = Integer.toString(xp);
                String percentage;
                if (xp < 10)
                    percentage = "0";
                else
                {
                    percentage = Integer.toString(xp).charAt(s.length() - 2) + "0";
                    if (percentage.equalsIgnoreCase("00"))
                        percentage = "0";
                }

                lore = new String[]{"&c&l» &a&lSLUB",
                        "",
                        "&c&l» &7Zakochanym wiedza o ich partnerze jest bardzo",
                        "   &7wazna, wszelkie informacje o Twoim zwiazku znajdziesz",
                        "   &7pod komenda /wyspy. Nie no zartuje, sa ponizej!",
                        "",
                        ColorUtil.formatHEX(" &8> #ffc936Jestes w zwiazku z: &7" + ChatUtil.returnPlayerColor(DataManager.getInstance().getLocal(player).getMarry()) + DataManager.getInstance().getLocal(player).getMarry()),
                        ColorUtil.formatHEX(" &8> #ffc936Data waszego slubu: &7" + ChatUtil.returnPlayerColor(DataManager.getInstance().getLocal(player).getMarry()) + DataManager.getInstance().getLocal(player).getMarryDate()),
                        ColorUtil.formatHEX(" &8> #ffc936Poziom waszego zwiazku: &7" + ChatUtil.returnPlayerColor(DataManager.getInstance().getLocal(player).getMarry()) + level + " &7(" + percentage + "%)"),
                        ""};
            }

            return createInvItem(lore, Material.POPPY, false);
        }

        if (name.equalsIgnoreCase("postacstatystyki"))
        {
            String[] lore = {"&c&l» &a&lSTATYSTYKI", "", "&c&l» &7Dzien dobry nasz &mwartosciowy&r &7graczu &6☻", "   &7Ponizej znajdziesz wszystkie swoje statystyki",
                    "   &7oraz informacje jakie o Tobie posiadamy!", "", ColorUtil.formatHEX(" &8> #ffc936Nazwa: &7" + player.getName()),
                    ColorUtil.formatHEX(" &8> #ffc936UUID: &7" + DataManager.getInstance().getLocal(player).getUUID()),
                    ColorUtil.formatHEX(" &8> #ffc936Adres IP: &7" + DataManager.getInstance().getLocal(player).getAddress()),
                    ColorUtil.formatHEX(" &8> #ffc936Opoznienie z serwerem: &7" + ServerUtil.getPing(player) + "ms"),
                    ColorUtil.formatHEX(" &8> #ffc936Konto premium #ffc936: &7" + ChatUtil.isPlayerPremium(player)),
                    "",
                    ColorUtil.formatHEX(" &8> #ffc936Ranga: &7" + ChatUtil.getColoredRank(player)),
                    ColorUtil.formatHEX(" &8> #ffc936Kolor: &7" + ChatUtil.returnColoredPlayerColor(player.getName())),
                    ColorUtil.formatHEX(" &8> #ffc936Ostatnie wyciszenie: &7" + ChatUtil.getLastMuteColored(player.getName())),
                    ColorUtil.formatHEX(" &8> #ffc936Wykonane questy: #fcff33" + QuestUtil.getCompletedQuests(player) + "/#fcff3314"),
                    ColorUtil.formatHEX(" &8> #ffc936Poziom ulepszenia schowku: #80ff1f" + (DataManager.getInstance().getLocal(player).getSchowekLevel() + 1) + "&7/#80ff1f4"),
                    "",
                    ColorUtil.formatHEX(" &8> #ffc936Monety: #fcff33" + DataManager.getInstance().getLocal(player).getMoney() + " ⛃"),
                    ColorUtil.formatHEX(" &8> #ffc936Punkty umiejetnosci: &e" + DataManager.getInstance().getLocal(player).getSP() + " ☀"),
                    ColorUtil.formatHEX(" &8> #ffc936Zabojstwa: #80ff1f" + DataManager.getInstance().getLocal(player).getKills() + " ⚔"),
                    ColorUtil.formatHEX(" &8> #ffc936Smierci: #fc7474" + DataManager.getInstance().getLocal(player).getDeaths() + " ☠"),
                    ""};

            return createPlayerHeadInvItem(lore, player.getName(), true);
        }

		if (name.equalsIgnoreCase("postacloading"))
		{
			String[] lore = {"&c&l» &a&lSTATYSTYKI", "", "&c&l» &7Wczytywanie statystyk...", ""};

			return createPlayerHeadInvItem(lore, player.getName(), true);
		}

        if (name.equalsIgnoreCase("postacgang"))
        {
            String[] lore = {""};

            if (DataManager.getInstance().getLocal(player).getGang() == null)
                lore = new String[]{"&c&l» &a&lGANG",
                        "",
                        "&c&l» &7Nie wiesz czegos o swoim gangu lub chcesz",
                        "   &7cos sprawdzic? Wszystkie szczegolowe informacje",
                        "   &7na temat gangu znajduja sie... no zgadnij gdzie!",
                        "",
                        " &8> &7Jednak najpierw musze Cie czegos nauczyc..",
                        "   &7Dzisiejszym tematem zajec bedzie idiotyzm!",
                        "   &7Nic nie sugeruje ale moglbys chociaz byc",
                        "   &7w ktoryms z gangow na serwerze!",
                        ""};
            else
            {
                boolean base = DataManager.getInstance().getLocal(player).getBase(DataManager.getInstance().getLocal(player).getGang()) != null;

                if (base)
                {
                    String world = Objects.requireNonNull(DataManager.getInstance().getLocal(player).getBase(DataManager.getInstance().getLocal(player).getGang()).getWorld()).getName();
                    int x = DataManager.getInstance().getLocal(player).getBase(DataManager.getInstance().getLocal(player).getGang()).getBlockX();
                    int y = DataManager.getInstance().getLocal(player).getBase(DataManager.getInstance().getLocal(player).getGang()).getBlockY();
                    int z = DataManager.getInstance().getLocal(player).getBase(DataManager.getInstance().getLocal(player).getGang()).getBlockZ();

                    lore = new String[]{"&c&l» &a&lGANG",
                            "",
                            "&c&l» &7Nie wiesz czegos o swoim gangu lub chcesz",
                            "   &7cos sprawdzic? Wszystkie szczegolowe informacje",
                            "   &7na temat gangu znajduja sie... no zgadnij gdzie!",
                            "",
                            ColorUtil.formatHEX(" &8> #ffc936Nazwa gangu: &7" + ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()) + DataManager.getInstance().getLocal(player).getGang()),
                            ColorUtil.formatHEX(" &8> #ffc936Design gangu: &7" + ChatUtil.getGangInChat(DataManager.getInstance().getLocal(player).getGang())),
                            "",
                            ColorUtil.formatHEX(" &8> #ffc936Liczba czlonkow: &7" + ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()) + DataManager.getInstance().getLocal(player).getMembers(DataManager.getInstance().getLocal(player).getGang())),
                            ColorUtil.formatHEX(" &8> #ffc936Lider gangu: &7" + ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()) + DataManager.getInstance().getLocal(player).getLider(DataManager.getInstance().getLocal(player).getGang())),
                            ColorUtil.formatHEX(" &8> #ffc936Friendly Fire: &7" + ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()) + ChatUtil.isGangFriendlyFire(DataManager.getInstance().getLocal(player).getGang())),
                            "",
                            ColorUtil.formatHEX(" &8> #ffc936Kolor gangu: &7" + ChatUtil.getColoredValidGangColor(DataManager.getInstance().getLocal(player).getGang())),
                            ColorUtil.formatHEX(" &8> #ffc936Prefixy gangu: &7" + ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()) + ChatUtil.getColoredGangPrefixes(DataManager.getInstance().getLocal(player).getGang())),
                            ColorUtil.formatHEX(" &8> #ffc936Ekskluzywna gwiazda: &7" + ChatUtil.isGangStar(DataManager.getInstance().getLocal(player).getGang())),
                            ColorUtil.formatHEX(" &8> #ffc936Czat prywatny gangu: &7" + ChatUtil.isGangChat(DataManager.getInstance().getLocal(player).getGang())),
                            "",
                            ColorUtil.formatHEX(" &8> #ffc936Lokalizacja bazy gangu:"),
                            ColorUtil.formatHEX("   &8- &7swiat: " + world),
                            ColorUtil.formatHEX("   &8- &7x: " + x),
                            ColorUtil.formatHEX("   &8- &7y: " + y),
                            ColorUtil.formatHEX("   &8- &7z: " + z),
                            ""};
                }
                else
                {
                    lore = new String[]{"&c&l» &a&lGANG",
                            "",
                            "&c&l» &7Nie wiesz czegos o swoim gangu lub chcesz",
                            "   &7cos sprawdzic? Wszystkie szczegolowe informacje",
                            "   &7na temat gangu znajduja sie... no zgadnij gdzie!",
                            "",
                            ColorUtil.formatHEX(" &8> #ffc936Nazwa gangu: &7" + ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()) + DataManager.getInstance().getLocal(player).getGang()),
                            ColorUtil.formatHEX(" &8> #ffc936Design gangu: &7" + ChatUtil.getGangInChat(DataManager.getInstance().getLocal(player).getGang())),
                            "",
                            ColorUtil.formatHEX(" &8> #ffc936Liczba czlonkow: &7" + ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()) + DataManager.getInstance().getLocal(player).getMembers(DataManager.getInstance().getLocal(player).getGang())),
                            ColorUtil.formatHEX(" &8> #ffc936Lider gangu: &7" + ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()) + DataManager.getInstance().getLocal(player).getLider(DataManager.getInstance().getLocal(player).getGang())),
                            ColorUtil.formatHEX(" &8> #ffc936Friendly Fire: &7" + ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()) + ChatUtil.isGangFriendlyFire(DataManager.getInstance().getLocal(player).getGang())),
                            "",
                            ColorUtil.formatHEX(" &8> #ffc936Kolor gangu: &7" + ChatUtil.getColoredValidGangColor(DataManager.getInstance().getLocal(player).getGang())),
                            ColorUtil.formatHEX(" &8> #ffc936Prefixy gangu: &7" + ChatUtil.getValidGangColor(DataManager.getInstance().getLocal(player).getGang()) + ChatUtil.getColoredGangPrefixes(DataManager.getInstance().getLocal(player).getGang())),
                            ColorUtil.formatHEX(" &8> #ffc936Ekskluzywna gwiazda: &7" + ChatUtil.isGangStar(DataManager.getInstance().getLocal(player).getGang())),
                            ColorUtil.formatHEX(" &8> #ffc936Czat prywatny gangu: &7" + ChatUtil.isGangChat(DataManager.getInstance().getLocal(player).getGang())),
                            "",
                            ColorUtil.formatHEX(" &8> #ffc936Lokalizacja bazy gangu:"),
                            ColorUtil.formatHEX("   &8- &7/gang baza ustaw"),
                            ""};
                }
            }

            return createInvItem(lore, Material.DIAMOND_SWORD, false);
        }

        if (name.equalsIgnoreCase("postacupgrades"))
        {
            String[] lore = {"&c&l» &a&lINFORMACJE O UMIEJETNOSCIACH",
					"",
					"&c&l» &7Na serwerze istnieje mozliwosc ulepszania",
					"   &7siebie jako swojej postaci i nie, nie chodzi nam",
					"   &7o poprawe Twojej tlustej talii czy ujemnego IQ!",
					"",
					"&c&l» &7Twoja postac moze zyskac 5 dodatkowych umiejetnosci,",
					"   &7ktore posiadaja 5 poziomow ulepszen. Opis kazdej",
					"   &7z umiejetnosci zawarty jest ponizej!",
					"",
					"&c&l» &7Aby zakupic ulepszenie, musisz posiadac",
					"   &7specjalna walute, ktora mozesz otrzymac m. in.",
					"   &7wykonujac &c/questy &7na serwerze. Mowa tu",
					"   &7oczywiscie o &ePunktach umiejetnosci (☀)&7.",
					"   &7Kazde pojedyncze ulepszenie kosztuje 1 ☀",
					"   &7i nie ma mozliwosci jego cofniecia!",
					""};

            return createInvItem(lore, Material.LEGACY_BOOK_AND_QUILL, true);
        }

        if (name.equalsIgnoreCase("postacupgrade1"))
        {
            String[] lore = {"&c&l» &c&lWITALNOSC",
					"",
					"&c&l» &7Witalnosc pozwala Twojej postaci zwiekszyc",
					"   &7swoje maksymalne zdrowie!",
					"",
					ColorUtil.formatHEX("&c&l» &7Wskaznik ulepszenia ilosc zdrowia:"),
					ColorUtil.formatHEX(" &8> &f(+2❤) " + DataManager.getInstance().getLocal(player).getUpgradeBar(player.getName(), "vitality", "&c") + " #fc7474+10❤"),
					"",
					ColorUtil.formatHEX("&c&l» &7Cena: &e1 ☀"),
					ColorUtil.formatHEX(" &8> &7Aktualny poziom: &c" + DataManager.getInstance().getLocal(player).getUpgradeLevel(player.getName(), "vitality") + "&7/&c5"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno ulepszenia)"), ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("postacupgrade2"))
        {
            String[] lore = {"&c&l» &e&lSZCZESCIE",
					"",
					"&c&l» &7Szczescie Twojej postaci odpowiada za",
					"   &7zwiekszenie szansy na wylowienie legendarnych morskich",
					"   &7skarbow oraz zmniejsza pobor monet po smierci!",
					"",
					ColorUtil.formatHEX("&c&l» &7Wskaznik zmniejszenia poboru monet po smierci:"),
					ColorUtil.formatHEX(" &8> &f(-2%⛃) " + DataManager.getInstance().getLocal(player).getUpgradeBar(player.getName(), "luck", "&e") + " #ffc9360%⛃"),
					"",
					ColorUtil.formatHEX("&c&l» &7Wskaznik zwiekszenia szczescia w lowieniu:"),
					ColorUtil.formatHEX(" &8> &f(+1%✪) " + DataManager.getInstance().getLocal(player).getUpgradeBar(player.getName(), "luck", "&e") + " #ffc9366%✪"),
					"",
					ColorUtil.formatHEX("&c&l» &7Cena: &e1 ☀"),
					ColorUtil.formatHEX(" &8> &7Aktualny poziom: &e" + DataManager.getInstance().getLocal(player).getUpgradeLevel(player.getName(), "luck") + "&7/&e5"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno ulepszenia)"), ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("postacupgrade3"))
        {
            String[] lore = {"&c&l» &a&lGRABIEZ",
					"",
					"&c&l» &7Grabiez pozwoli Ci na zwiekszenie dropu",
					"   &7z rud netheritu w netherze i jablek z drzew!",
					"",
					ColorUtil.formatHEX("&c&l» &7Wskaznik zwiekszenia szansy na obfitszy drop:"),
					ColorUtil.formatHEX(" &8> &f(+2%☠) " + DataManager.getInstance().getLocal(player).getUpgradeBar(player.getName(), "loot", "&a") + " #80ff1f10%☠"),
					"",
					ColorUtil.formatHEX("&c&l» &7Cena: &e1 ☀"),
					ColorUtil.formatHEX(" &8> &7Aktualny poziom: &a" + DataManager.getInstance().getLocal(player).getUpgradeLevel(player.getName(), "loot") + "&7/&a5"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno ulepszenia)"), ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("postacupgrade4"))
        {
            String[] lore = {"&c&l» &b&lWALECZNOSC",
					"",
					"&c&l» &7Walecznosc to typowa umiejetnosc bitewna.",
					"   &7Pozwala absorpcje obrazen od teleportacji perla!",
					"",
					ColorUtil.formatHEX("&c&l» &7Wskaznik absorpcji obrazen od perel:"),
					ColorUtil.formatHEX(" &8> &f(+20%☄) " + DataManager.getInstance().getLocal(player).getUpgradeBar(player.getName(), "honorable", "&b") + " #3075ff100%☄"),
					"",
					ColorUtil.formatHEX("&c&l» &7Cena: &e1 ☀"),
					ColorUtil.formatHEX(" &8> &7Aktualny poziom: &b" + DataManager.getInstance().getLocal(player).getUpgradeLevel(player.getName(), "honorable") + "&7/&b5"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno ulepszenia)"), ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("postacupgrade5"))
        {
            String[] lore = {"&c&l» &6&lPRZEBIEGLOSC",
					"",
					"&c&l» &7Przebieglosc pozwoli zwiekszyc Twoj",
					"   &7wspolczynnik otrzymywanego XP!",
					"",
					ColorUtil.formatHEX("&c&l» &7Wskaznik zwiekszenia otrzymywanego XP:"),
					ColorUtil.formatHEX(" &8> &60% &f(+10%❀) " + DataManager.getInstance().getLocal(player).getUpgradeBar(player.getName(), "thiefy", "&6") + " #ffb33850%❀"),
					"",
					ColorUtil.formatHEX("&c&l» &7Cena: &e1 ☀"),
					ColorUtil.formatHEX(" &8> &7Aktualny poziom: &6" + DataManager.getInstance().getLocal(player).getUpgradeLevel(player.getName(), "thiefy") + "&7/&65"), "",
					ColorUtil.formatHEX("   #666666&o(LPM - Kupno ulepszenia)"), ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy1"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Drwal"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #80ff1fLatwy"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7Silny badz jak drwale,"),
                    ColorUtil.formatHEX("   &7sztywno stawiaj pale. Chwyc za swoj topor i"),
                    ColorUtil.formatHEX("   &7zetnij co nieco drewna!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
                    ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar(1)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e1 ☀"),
                    ColorUtil.formatHEX(" &8> #fff20350 ⛃"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy2"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Zbieracz kamykow"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #80ff1fLatwy"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7Jezeli jestes gornikiem,"),
                    ColorUtil.formatHEX("   &7i nie posiadasz RTX 3090 to lepiej chwyc za"),
                    ColorUtil.formatHEX("   &7swoj kilof i wykop mi troche kamienia!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
                    ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar(2)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e1 ☀"),
                    ColorUtil.formatHEX(" &8> #fff203100 ⛃"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy3"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Szpadel"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #80ff1fLatwy"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7Widzisz ten piasek,"),
                    ColorUtil.formatHEX("   &7ziemie, zwir? Najebalo go tutaj ze japie**"),
                    ColorUtil.formatHEX("   &7Skop troche i wroc po nagrode!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
                    ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar(3)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e1 ☀"),
                    ColorUtil.formatHEX(" &8> #fff20375 ⛃"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy4"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Najeb sie!"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #80ff1fLatwy"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7Z pewnoscia zaliczysz"),
                    ColorUtil.formatHEX("   &7to cudowne zadanie, chwyc kilka piwek i"),
                    ColorUtil.formatHEX("   &7rozluznij sie troszke!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
					ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar(4)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e1 ☀"),
                    ColorUtil.formatHEX(" &8> #fff20350 ⛃"),
                    ColorUtil.formatHEX(" &8> &fPiwo 5% &f(x1)"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy5"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Lowca"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #80ff1fLatwy"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7Potwory sa straszne"),
                    ColorUtil.formatHEX("   &7tylko w nocy, ich tez dotyczy to zadanie."),
                    ColorUtil.formatHEX("   &7Wystarczy ze przyniesiesz mi ich glowy!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
					ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar(5)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e1 ☀"),
                    ColorUtil.formatHEX(" &8> #fff203100 ⛃"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy6"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Psychopata"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #80ff1fLatwy"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7Swiat jest pelen zlych"),
                    ColorUtil.formatHEX("   &7i falszywych ludzi, mnie obchodza wszyscy,"),
                    ColorUtil.formatHEX("   &7wiec bede wdzieczny jesli zabijesz ich"),
                    ColorUtil.formatHEX("   &7minimum 10!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
					ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar(6)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e1 ☀"),
                    ColorUtil.formatHEX(" &8> #fff203150 ⛃"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy7"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Poszukiwacz"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #fff203Sredni"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7Kazdemu zlodziejowi"),
                    ColorUtil.formatHEX("   &7jak i wedrowcowi potrzebne sa pojemne i"),
                    ColorUtil.formatHEX("   &7glebokie kieszenie, ulepsz wiec swoj"),
                    ColorUtil.formatHEX("   &7schowek na maksymalny poziom!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
					ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar(7)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e2 ☀"),
                    ColorUtil.formatHEX(" &8> #fff203250 ⛃"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy8"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Psychonauta"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #fff203Sredni"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7Gdzies tam daleko"),
                    ColorUtil.formatHEX("   &7swiat jest inny, a moze nawet i przed nami"),
                    ColorUtil.formatHEX("   &7lecz nie umiemy otworzyc oczu.."),
                    ColorUtil.formatHEX("   &7Wyprobuj jeden z serwerowych specjalow!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
					ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar(8)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e2 ☀"),
                    ColorUtil.formatHEX(" &8> #fff203200 ⛃"),
                    ColorUtil.formatHEX(" &8> &fHeroina &f(x1)"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy9"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Forget"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #fff203Sredni"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7Twoim wyzwaniem jest"),
                    ColorUtil.formatHEX("   &7zostac wyciszonym na czacie minimum 10 razy!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
					ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar(9)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e2 ☀"),
                    ColorUtil.formatHEX(" &8> #fff203200 ⛃"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy10"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Spoceniec"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #fff203Sredni"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7Kto pierwszy ten.."),
                    ColorUtil.formatHEX("   &7najbardziej spocony! Przegraj na serwerze"),
                    ColorUtil.formatHEX("   &7czas wynoszacy minimum 7 dni!"),
                    ColorUtil.formatHEX("   &7Jesli ukonczyles questa, wejdz i wejdz"),
                    ColorUtil.formatHEX("   &7ponownie na serwer!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
					ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar(10)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e2 ☀"),
                    ColorUtil.formatHEX(" &8> #fff203300 ⛃"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy11"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Ogrodnik"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #fff203Sredni"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7Na swoim duzym"),
                    ColorUtil.formatHEX("   &7i pieknym polu, bez chaszczy i robali"),
                    ColorUtil.formatHEX("   &7poswiec czas zbierajac plony ze swojej"),
                    ColorUtil.formatHEX("   &7plantacji!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
					ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar(11)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e2 ☀"),
                    ColorUtil.formatHEX(" &8> #fff203250 ⛃"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy12"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Zakochani po uszy"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #fc7474Trudny"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7Im wiecej milosci"),
                    ColorUtil.formatHEX("   &7i szczescia w twym zwiazku, tym jeszcze"),
                    ColorUtil.formatHEX("   &7wiecej w kieszeni majatku. Osiagnij 100"),
                    ColorUtil.formatHEX("   &7poziom slubu! Jesli ukonczyles questa"),
                    ColorUtil.formatHEX("   &7na chwile przed otrzymaniem nagrody"),
                    ColorUtil.formatHEX("   &7pocaluj swoja druga polowke!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
					ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar(12)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e3 ☀"),
                    ColorUtil.formatHEX(" &8> #fff203450 ⛃"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy13"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Partia serwera"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #fc7474Trudny"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7Twoim zadaniem jest"),
                    ColorUtil.formatHEX("   &7zakupic ekskluzywny kosmetyk gwiazdy"),
                    ColorUtil.formatHEX("   &7dla swojego gangu. Jezeli jestes w gangu"),
                    ColorUtil.formatHEX("   &7i gwiazde kupi jego lider, wowczas"),
                    ColorUtil.formatHEX("   &7quest nie zostaje zaliczony poniewaz"),
                    ColorUtil.formatHEX("   &7nie tolerujemy darmozjadow!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
					ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar( 13)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e3 ☀"),
                    ColorUtil.formatHEX(" &8> #fff203500 ⛃"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

        if (name.equalsIgnoreCase("questy14"))
        {
            String[] lore = {"&c&l» &a&lQUEST",
                    "",
                    "&c&l» &7Wykonuj serwerowe zadania, aby zdobyc punkty",
                    "   &7umiejetnosci i ulepszac swoja postac!",
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nazwa: #ffc936Piraci z karaibow"),
                    ColorUtil.formatHEX(" &8> &7Trudnosc: #fc7474Trudny"),
                    ColorUtil.formatHEX(" &8> &7Szczegoly questa: &7W morzu i jeziorach"),
                    ColorUtil.formatHEX("   &7znajduja sie fascynujace przedmioty,"),
                    ColorUtil.formatHEX("   &7ktore mozesz wylowic za pomoca swojego"),
                    ColorUtil.formatHEX("   &7kija ze sznurkiem i haczykiem. Twoim"),
                    ColorUtil.formatHEX("   &7zadaniem jest wylowienie 15 legendarnych"),
                    ColorUtil.formatHEX("   &7morskich skarbow!"),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Status ukonczenia questa:"),
					ColorUtil.formatHEX(" &8> " + DataManager.getInstance().getLocal(player).getQuestBar(14)),
                    "",
                    ColorUtil.formatHEX("&c&l» &7Nagrody za ukonczenie:"),
                    ColorUtil.formatHEX(" &8> &e3 ☀"),
                    ColorUtil.formatHEX(" &8> #fff203600 ⛃"),
                    ""};

            return createInvItem(lore, Material.BOOK, false);
        }

		if (name.equalsIgnoreCase("monopolowypiwo"))
		{
			String[] lore = {"&c&l» &a&lPIWO",
					"",
					"&c&l» &7Jezeli chcesz sie napic dla towarzystwa",
					"   &7nie wahaj sie i natychmiast kup piwo!",
					"",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff20360 ⛃"),
					""};

			return createInvItem(lore, Material.LIME_DYE, false);
		}

		if (name.equalsIgnoreCase("monopolowywino"))
		{
			String[] lore = {"&c&l» &a&lWINO",
					"",
					"&c&l» &7Potrzebujesz czegos na romantyczny wieczor",
					"   &7lub cos slodkiego i owocowego? Kup wino!",
					"",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff203100 ⛃"),
					""};

			return createInvItem(lore, Material.LIME_DYE, false);
		}

		if (name.equalsIgnoreCase("monopolowyszampan"))
		{
			String[] lore = {"&c&l» &a&lSZAMPAN",
					"",
					"&c&l» &7Gdy w kosciele nowa para,",
					"   &7biegnij do mnie po szampana!",
					"",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff203150 ⛃"),
					""};

			return createInvItem(lore, Material.LIME_DYE, false);
		}

		if (name.equalsIgnoreCase("monopolowywhisky"))
		{
			String[] lore = {"&c&l» &a&lWHISKY",
					"",
					"&c&l» &7Wytrawny luksusowy alkohol, ktory",
					"   &7oswiadczy sie Twoim kubkom smakowym!",
					"",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff203340 ⛃"),
					""};

			return createInvItem(lore, Material.LIME_DYE, false);
		}

		if (name.equalsIgnoreCase("monopolowywodka"))
		{
			String[] lore = {"&c&l» &a&lWODKA",
					"",
					"&c&l» &7Polska czy ruska, zawsze dobrze smakuje",
					"   &7kto wodki nie pije, ten nie baluje!",
					"",
					ColorUtil.formatHEX("&c&l» &7Cena: #fff203400 ⛃"),
					""};

			return createInvItem(lore, Material.LIME_DYE, false);
		}

		if (name.equalsIgnoreCase("drug_table_info"))
		{
			String[] lore = {"&c&l» &a&lSYNTEZA",
					"",
					" &8> &7Aby rozpoczac swoja synteze, wybierz",
					"   &7jeden z pieciu szlakow, powyzej!",
					"",
					" &8> &7Domyslnie, synteezy rozpoczynaja sie",
					"   &7od podstawnika, ktorym jest &aAmina&7.",
					"   &7Aby ja zmienic, kliknij na nia.",
					"",
					" &8> &7Syntezy rozpoczac mozesz od aminy,",
					"   &7badz opium. Alkohole nabyc mozesz",
					"   &7&mwylacznie&r&7 w sklepie monopolowym.",
					""};

			return createInvItem(lore, Material.BREWING_STAND, false);
		}

		if (name.equalsIgnoreCase("drug_table_info2"))
		{
			String[] lore = {"&c&l» &a&lINFORMACJE",
					"",
					" &8> &7Za kazda przeprowadzona synteze placisz",
					"   &750 punktami doswiadczenia. Takze wypierdalaj",
					"   &7mi z tymi monetami i diamentami!",
					"",
					" &8> &7Nie ma mozliwosci desyntezacji -",
					"   &7wiec kazda reakcja chemiczna jest finalna,",
					"   &7podejmuj madre decyzje!",
					""};

			return createInvItem(lore, Material.BOOK, false);
		}

		return null;
	}

	public static boolean isFullInventory(Player player)
	{
		for (int slot = 0; slot < 36; slot++)
			if (player.getInventory().getItem(slot) == null)
				return false;

		return true;
	}

	public static boolean canBeStacked(ItemStack item, int amount)
	{
		if (item != null)
			return item.getAmount() + amount <= item.getMaxStackSize();

		return false;
	}

	public static boolean canStackItem(Player player, Material material, int amount)
	{
		for (int slot = 0; slot < 36; slot++)
			if (Objects.requireNonNull(player.getInventory().getItem(slot)).getType() == material)
				if (canBeStacked(player.getInventory().getItem(slot), amount))
					return true;

		return false;
	}

	public static ItemStack getEnchantmentBook(Enchantment enchantment, int tier)
	{
		ItemStack enchBook = new ItemStack(Material.ENCHANTED_BOOK, 1);
		EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchBook.getItemMeta();
		assert meta != null;
		meta.addStoredEnchant(enchantment, tier, true);
		enchBook.setItemMeta(meta);

		return enchBook;
	}

	public static ItemStack createInvItem(String[] lore, Material material, boolean enchGlowing)
	{
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();

		ArrayList<String> itemLore = new ArrayList<>();

		for (String vers : lore)
			itemLore.add(ChatColor.translateAlternateColorCodes('&', vers));

		assert meta != null;

		if (enchGlowing)
			meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);

		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(" ");
		meta.setLore(itemLore);
		item.setItemMeta(meta);

		return item;
	}

    public static ItemStack createPlayerHeadInvItem(String[] lore, String name, boolean enchGlowing)
    {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skull_meta = (SkullMeta) skull.getItemMeta();

        ArrayList<String> itemLore = new ArrayList<>();

        for (String vers : lore)
            itemLore.add(ChatColor.translateAlternateColorCodes('&', vers));

        assert skull_meta != null;

        if (enchGlowing)
            skull_meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);

        skull_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        skull_meta.setOwningPlayer(Bukkit.getOfflinePlayer(name));
        skull.setItemMeta(skull_meta);
        skull_meta.setDisplayName(" ");
        skull_meta.setLore(itemLore);
        skull.setItemMeta(skull_meta);

        return skull;
    }

	public static ItemStack createAmountedInvItem(String[] lore, Material material, int amount, boolean enchGlowing)
	{
		ItemStack item = new ItemStack(material, amount);
		ItemMeta meta = item.getItemMeta();

		ArrayList<String> itemLore = new ArrayList<>();

		for (String vers : lore)
			itemLore.add(ChatColor.translateAlternateColorCodes('&', vers));

		assert meta != null;

		if (enchGlowing)
			meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);

		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(" ");
		meta.setLore(itemLore);
		item.setItemMeta(meta);

		return item;
	}

	public static ItemStack createShopItem(String name, Material material, int amount, int buy, int sell)
	{
		String buyStr;
		String sellStr;

		if (buy == -1)
			buyStr = ColorUtil.formatHEX("&c&l» &7Cena kupna: #80ff1f✖ &7(Nie ma kurwa!)");
		else
			buyStr = ColorUtil.formatHEX("&c&l» &7Cena kupna: #80ff1f" + buy + " ⛃ &7(" + buy * (material.getMaxStackSize() / amount) + " ⛃/stak)");

		if (sell == -1)
			sellStr = ColorUtil.formatHEX("&c&l» &7Cena sprzedazy: #fc7474✖ &7(Nie ma kurwa!)");
		else
			sellStr = ColorUtil.formatHEX("&c&l» &7Cena sprzedazy: #fc7474" + sell + " ⛃ &7(" + sell * (material.getMaxStackSize() / amount) + " ⛃/stak)");


		String[] lore = {"&c&l» &a&l" + name.toUpperCase(), "", "&c&l» &7Przedmiot: " + name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase(), " &8> &7Ilosc: 8", "",
				buyStr,
				sellStr, "",
				ColorUtil.formatHEX("   #666666&o(LPM - Kupno jednej sztuki przedmiotu"),
				ColorUtil.formatHEX("   #666666&oPPM - Sprzedaz jednej sztuki przedmiotu"),
				ColorUtil.formatHEX("   #666666&oSHIFT + LPM - Kupno staka przedmiotu"),
				ColorUtil.formatHEX("   #666666&oSHIFT + PPM - Sprzedaz staka przedmiotu)"),""};

		return createAmountedInvItem(lore, material, amount, false);
	}

	public static void createSchowek(Player player)
	{
		Inventory inventory = Bukkit.createInventory(
				player,
				9*3 + (DataManager.getInstance().getLocal(player).getSchowekLevel() * 9),
				ChatColor.translateAlternateColorCodes('&', "&c&lSCHOWEK"));

		if (DataManager.getInstance().getLocal(player).getSchowek() != null)
		{
			@SuppressWarnings("unchecked")
			ArrayList<ItemStack> items = (ArrayList<ItemStack>) DataManager.getInstance().getLocal(player).getSchowek();
			ItemStack[] contents;
            contents = Objects.requireNonNull(items).toArray(new ItemStack[items.size()]);

            inventory.setContents(contents);
			player.openInventory(inventory);

			return;
		}

		ChatManager.sendMessage(player, Configuration.SERVER_FULL_PREFIX + "&7Trwa tworzenie Twojego schowku... &e⌛");

		ItemStack[] items = inventory.getContents();
		List<ItemStack> contents = new ArrayList<>(Arrays.asList(items));

        DataManager.getInstance().getLocal(player).setSchowek(contents);
		ChatManager.sendMessage(player, Configuration.SERVER_FULL_PREFIX + "&7Twoj schowek zostal utworzony, mozesz go otworzyc pod komenda #fc7474/schowek");
	}
}