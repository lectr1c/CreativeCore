package se.lectr1c.creativecore;


import com.plotsquared.core.api.PlotAPI;
import com.plotsquared.core.listener.PlotListener;
import com.plotsquared.core.location.PlotLoc;
import com.plotsquared.core.player.PlotPlayer;
import com.plotsquared.core.plot.Plot;
import com.plotsquared.core.plot.PlotArea;
import com.plotsquared.core.plot.PlotAreaType;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
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
        if (PlotPlayer.wrap(p).getCurrentPlot().getPlayersInPlot() != null) {
            e.getRecipients().clear();
            e.setCancelled(true);

            List<PlotPlayer<?>> players = new ArrayList<>();
            players = PlotPlayer.wrap(p).getCurrentPlot().getPlayersInPlot();

            for (PlotPlayer pl : players) {

                Player player = Bukkit.getPlayer(pl.getUUID());
                assert player != null;
                player.sendMessage(String.valueOf(this.main.getConfig().getString("LocalChatFormat")) + e.getMessage());
            }
        }
    }
}