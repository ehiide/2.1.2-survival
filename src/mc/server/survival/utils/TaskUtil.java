package mc.server.survival.utils;

import mc.server.survival.files.Main;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class TaskUtil
{
    public static void runSync(@NotNull Runnable runnable)
    {
        Bukkit.getScheduler().runTask(Main.getInstance(), runnable);
    }

    public static void runAsync(@NotNull Runnable runnable)
    {
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), runnable);
    }

    public static void runAsyncTimer(@NotNull Runnable runnable, final int interval)
    {
        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getInstance(), runnable, interval, interval);
    }
}