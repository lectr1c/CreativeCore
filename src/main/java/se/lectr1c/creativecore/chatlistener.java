package se.lectr1c.creativecore;


import com.plotsquared.core.api.PlotAPI;
import com.plotsquared.core.listener.PlotListener;
import com.plotsquared.core.location.PlotLoc;
import com.plotsquared.core.player.PlotPlayer;
import com.plotsquared.core.plot.Plot;
import com.plotsquared.core.plot.PlotArea;
import com.plotsquared.core.plot.PlotAreaType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;








public class chatlistener
        implements Listener
{
    private Main main;
    private PlotAreaType plotArea;
    private PlotLoc plot1;
    private PlotAPI api;
    private PlotListener pplayer;

    public chatlistener(Main main, PlotAreaType plotArea2, PlotLoc plot, PlotListener pplayer2) {
        this.main = main;
        this.plotArea = plotArea2;
        this.plot1 = plot;
        this.pplayer = pplayer2;
    }

    @EventHandler
    public void oPlayerChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (true) {   // add local to rpplayer config

            e.getRecipients().clear();
            e.setCancelled(true);

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.main, () -> p.getNearbyEntities(500,500,500).forEach((en) -> {
                if(en instanceof Player){
                    en.sendMessage(p.getName() + ">> " + e.getMessage());

                }

            }), 1L);

            p.sendMessage(p.getName() + ">> " + e.getMessage());

        }
    }
}