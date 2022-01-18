package mc.server.survival.events;

import mc.server.Logger;
import mc.server.survival.managers.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.io.File;

public class ServerPing 
implements Listener
{
	@EventHandler
	public void onEvent(ServerListPingEvent event)
	{
		final int maxPlayers = (int) FileManager.getInstance().getConfigValue("general.max-players");
		final String serverIcon = (String) FileManager.getInstance().getConfigValue("general.server-icon");
		final String serverMotd = (String) FileManager.getInstance().getConfigValue("general.server-motd");

		event.setMaxPlayers(maxPlayers);
		event.setMotd(ChatColor.translateAlternateColorCodes('&', serverMotd));
		
		try 
		{
			event.setServerIcon(Bukkit.loadServerIcon(new File(serverIcon)));
		} 
		catch (Exception ignored)
		{
			Logger.asyncLog("&cWystapil problem ze znalezieniem pliku ikony serwera!");
		}

		event.setServerIcon(Bukkit.getServerIcon());
	}
}