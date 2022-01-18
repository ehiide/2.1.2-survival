package mc.server.survival.events;

import mc.server.survival.items.Chemistries;
import mc.server.survival.items.ChemistryItem;
import mc.server.survival.managers.NeuroManager;
import mc.server.survival.utils.QuestUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class ItemConsume implements Listener
{
    @EventHandler
    public void onEvent(PlayerItemConsumeEvent event)
    {
        final Player player = event.getPlayer();

        if (event.getPlayer().getInventory().getItemInOffHand().getType() == Material.AIR)
        {
            try
            {
                final boolean isKnownDrug = Chemistries.getInstance().isKnown(event.getPlayer().getInventory().getItemInMainHand());
                final boolean isNotOnCooldown = !event.getPlayer().hasCooldown(Material.POTION);
                final boolean haveDrug = event.getItem().getType() == Material.POTION;

                if (!isKnownDrug || !isNotOnCooldown || !haveDrug) return;

                final String itemName = event.getItem().hasItemMeta() ? event.getItem().getItemMeta().getDisplayName() : null;
                final ChemistryItem chemistryItem = Chemistries.getInstance().byName(itemName);

                if (chemistryItem.getAffinity().isOpioidic())
                    NeuroManager.normalize(event.getPlayer(),
                            chemistryItem.getAffinity().getOpioidic());
                else if (chemistryItem.getAffinity().isAmine())
                    NeuroManager.modify(event.getPlayer(),
                            chemistryItem.getAffinity().getSerotonine(),
                            chemistryItem.getAffinity().getDopamine(),
                            chemistryItem.getAffinity().getNoradrenaline(),
                            chemistryItem.getAffinity().getGABA());

                player.setFoodLevel(Math.min(player.getFoodLevel() + 4, 20));
                QuestUtil.manageQuest(player, 4);
                event.getPlayer().setCooldown(Material.POTION, 120);
            }
            catch (Exception ignored) {}
        }
    }
}