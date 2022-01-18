package mc.server.survival.files;

import mc.server.Broadcaster;
import mc.server.Logger;
import mc.server.survival.commands.*;
import mc.server.survival.events.*;
import mc.server.survival.managers.DataManager;
import mc.server.survival.managers.FileManager;
import mc.server.survival.managers.NeuroManager;
import mc.server.survival.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Main
extends JavaPlugin
{
	private static Main instance;
	
	public static Main getInstance()
	{
		return instance;
	}

	public static String[] AUTHORS = {"Eh1de", "schiziss", "misspill", "ProseczeqPL"};

	private final PluginManager plugin = getServer().getPluginManager();
	private static int registeredEvents, registeredCommands;
	
	private void registerEvent(@NotNull Listener event) { plugin.registerEvents(event, this); registeredEvents++; }

	private void registerEvents() 
	{
		Listener[] listeners = {new ServerPing(), new EntityDamageByEntity(), new AsyncChat(), new PlayerJoin(),
				new Inventory(), new PlayerDeath(), new BlockBreak(), new CommandPreProcess(), new Portal(),
				new PlayerInteract(), new Respawn(), new BlockPlace(), new ItemDrop(), new EntityInteract(),
				new PrepareAnvil(), new ItemConsume(), new PlayerItemDamage(), new EntityDeath(), new PlayerFish(),
				new PlayerTeleport(), new ItemMerge(), new ItemThrow(), new Explode(), new Dismount(), new RegainHealth(),
				new PlayerDamage()};

		Arrays.stream(listeners).forEach(this::registerEvent);
		TaskUtil.runSync(() -> Logger.log("Zaladowano eventy: " + registeredEvents + "/" + Arrays.stream(listeners).toList().size()));
	}
	
	private void registerCommand(@NotNull String name, @NotNull CommandExecutor command)
	{
		getCommand(name).setExecutor(command);
		registeredCommands++;
	}
	
	private void registerCommands() 
	{
		registerCommand("powrot", new Powrot());
		registerCommand("lobby", new Lobby());
		registerCommand("dom", new Dom());
		registerCommand("wiadomosc", new Wiadomosc());
		registerCommand("odpowiedz", new Odpowiedz());
		registerCommand("schowek", new Schowek());
		registerCommand("pomoc", new Pomoc());
		registerCommand("ping", new Ping());
		registerCommand("craftingi", new Craftingi());
		registerCommand("zaplac", new Zaplac());
		registerCommand("paleta", new Paleta());
		registerCommand("tpa", new TPA());
		registerCommand("sklep", new Sklep());
		registerCommand("slub", new Slub());
		registerCommand("gang", new Gang());
		registerCommand("ip", new IP());
		registerCommand("mute", new Mute());
		registerCommand("unmute", new Unmute());
		registerCommand("kick", new Kick());
		registerCommand("powiedz", new Powiedz());
		registerCommand("postac", new Postac());
		registerCommand("questy", new Questy());
		registerCommand("serverside", new ServerSide());
		registerCommand("zakuj", new Zakuj());
		registerCommand("odkuj", new Odkuj());
		registerCommand("whitelist", new Whitelist());

		TaskUtil.runSync(() -> Logger.log("Zaladowano komendy: " + registeredCommands + "/26"));
	}
	
	@Override
	public void onEnable() 
	{
		instance = this;

		Minecraft.getInstance().checkVersion(getServer(), this);

		FileManager.getInstance().start(instance);

		WorldUtil.loadWorlds();
		WorldUtil.DropChecker.runTask();

		RecipeUtil.getInstance().addRecipes();
		NPCUtil.getInstance().reloadEntities();

		for (final Player player : Bukkit.getOnlinePlayers())
		{
			TaskUtil.runAsync(() -> DataManager.getInstance().getLocal(player).handlePlayer());

			NeuroManager.apply(player);
			ServerUtil.reloadContents(player);
		}

		TaskUtil.runAsync(() -> DataManager.getInstance().getLocal(null).handleGangs());

		if ((boolean) FileManager.getInstance().getConfigValue("function.chemistry.status"))
			NeuroManager.schedule(this);

		registerEvents();
		registerCommands();

		TaskUtil.runAsyncTimer(Broadcaster::scheduleGlobalMessages, 3600);
		TaskUtil.runSync(() -> Logger.log("Pomyslnie zaladowano wszystkie komponenty serwera!"));
	}
	
	@Override
	public void onDisable() 
	{ }
}