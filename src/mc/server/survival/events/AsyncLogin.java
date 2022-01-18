package mc.server.survival.events;

import mc.server.Logger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class AsyncLogin implements Listener
{
    @EventHandler
    public void onEvent(AsyncPlayerPreLoginEvent event)
    {
        Logger.log("UUID: " + event.getUniqueId());
    }
}