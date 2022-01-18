package mc.server.api;

import mc.server.survival.events.AsyncChat;
import mc.server.survival.managers.DataManager;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class SurvivalAPI
{
    private SurvivalAPI() {}

    static SurvivalAPI api;

    public static SurvivalAPI getAPI() { return api; }

    public DataManager.LocalData getPlayerData(final Player player)
    {
        return DataManager.getInstance().getLocal(player);
    }

    public void getFD() {}

    public DataManager.FastData getServerData()
    {
        return DataManager.getInstance().getData();
    }

    public void sudoMessage(String message, final Player player)
    {
        new AsyncChat().compileMessage(message, player);
    }
}