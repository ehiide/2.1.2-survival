package mc.server.survival.files;

import mc.server.Logger;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

public class Minecraft
{
    private Minecraft() {}

    static Minecraft instance = new Minecraft();

    public static Minecraft getInstance()
    {
        return instance;
    }

    private final String[] VERSIONS = {"1.17", "1.18"};

    public void checkVersion(final Server server, Plugin plugin)
    {
        final String serverVersion = server.getBukkitVersion();
        final String catchUpVersion = serverVersion.substring(0, 4);

        for (String version : VERSIONS)
        {
            if (catchUpVersion.equalsIgnoreCase(version))
            {
                Logger.log("&7Wykryto wersje serwera minecrafta: " + serverVersion);
                Logger.log("&7Protokoly zostana przystosowane dla natywnej wersji: " + version);
                return;
            }
        }

        Logger.log("&cWykryto wersje serwera minecraft, ktora nie jest obslugiwana!");
        plugin.getPluginLoader().disablePlugin(plugin);
    }
}