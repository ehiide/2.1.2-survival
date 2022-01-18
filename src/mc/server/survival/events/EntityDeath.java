package mc.server.survival.events;

import mc.server.survival.managers.DataManager;
import mc.server.survival.utils.MathUtil;
import mc.server.survival.utils.QuestUtil;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class EntityDeath implements Listener
{
    @EventHandler
    public void onEvent(EntityDeathEvent event)
    {
        if (!(event.getEntity() instanceof Player) && event.getEntity().getKiller() != null)
        {
            final int serotonine = DataManager.getInstance().getLocal(event.getEntity().getKiller()).getSerotonine();
            final int dopamine = DataManager.getInstance().getLocal(event.getEntity().getKiller()).getDopamine();
            int xp = event.getDroppedExp();
            List<ItemStack> drops = event.getDrops();

            if (serotonine >= 60)
                xp = xp * 2;

            if (serotonine <= -20)
                xp = 0;

            if (serotonine <= -40)
                event.getDrops().clear();

            if (dopamine > 5)
            {
                if (event.getEntity() instanceof WitherSkeleton)
                {
                    if (MathUtil.chanceOf(dopamine / 15))
                        event.getEntity().getKiller().getInventory().addItem(new ItemStack(Material.WITHER_SKELETON_SKULL, 1));
                }
                else if (event.getEntity() instanceof Skeleton)
                {
                    if (MathUtil.chanceOf(dopamine / 14))
                        event.getEntity().getKiller().getInventory().addItem(new ItemStack(Material.SKELETON_SKULL, 1));
                }
                else if (event.getEntity() instanceof Zombie)
                {
                    if (MathUtil.chanceOf(dopamine / 10))
                        event.getEntity().getKiller().getInventory().addItem(new ItemStack(Material.ZOMBIE_HEAD, 1));
                }
                else if (event.getEntity() instanceof Creeper)
                {
                    if (MathUtil.chanceOf(dopamine / 17))
                        event.getEntity().getKiller().getInventory().addItem(new ItemStack(Material.CREEPER_HEAD, 1));
                }
            }

            event.setDroppedExp(xp + (DataManager.getInstance().getLocal(event.getEntity().getKiller()).getUpgradeLevel(event.getEntity().getKiller().getName(), "thiefy")));
            QuestUtil.manageQuest(event.getEntity().getKiller(), 5);
        }
    }
}