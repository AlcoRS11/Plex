package dev.plex.listener.impl;

import dev.plex.event.AdminAddEvent;
import dev.plex.event.AdminRemoveEvent;
import dev.plex.event.AdminSetRankEvent;
import dev.plex.listener.PlexListener;
import dev.plex.player.PlexPlayer;
import dev.plex.rank.enums.Rank;
import static dev.plex.util.PlexUtils.tl;
import dev.plex.util.PlexUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;

public class AdminListener extends PlexListener
{
    @EventHandler
    public void onAdminAdd(AdminAddEvent event)
    {
        String userSender = event.getSender().getName();
        PlexPlayer target = event.getPlexPlayer();

        PlexUtils.broadcast(tl("newAdminAdded", userSender, target.getName()));
    }

    @EventHandler
    public void onAdminRemove(AdminRemoveEvent event)
    {
        String userSender = event.getSender().getName();
        PlexPlayer target = event.getPlexPlayer();

        PlexUtils.broadcast(tl("adminRemoved", userSender, target.getName()));
    }

    @EventHandler
    public void onAdminSetRank(AdminSetRankEvent event)
    {
        String userSender = event.getSender().getName();
        PlexPlayer target = event.getPlexPlayer();
        Rank newRank = event.getRank();

        PlexUtils.broadcast(tl("adminSetRank", userSender, target.getName(), newRank.name().toUpperCase()));
    }
}
