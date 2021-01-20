package se.lectr1c.creativecore;


import com.plotsquared.core.api.PlotAPI;
import com.plotsquared.core.listener.PlotListener;
import com.plotsquared.core.location.PlotLoc;
import com.plotsquared.core.plot.PlotAreaType;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class Main extends JavaPlugin implements Listener
{
    public static JavaPlugin plugin;
    private File rpfile;
    private YamlConfiguration customrpfile;
    private File playerFile;
    private YamlConfiguration customPlayerfile;
    private PlotAreaType plotArea;
    private PlotLoc plot;
    private PlotAPI api;
    private PlotListener pplayer;


    @Override
    public void onEnable() {
        System.out.println("Plugin Enabled");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        try {
            initiateFiles();
            System.out.println("RP Files initiated");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            initiatePlayerFiles();
            System.out.println("Player Files initiated");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PluginManager manager = Bukkit.getServer().getPluginManager();
        Plugin plotsquared = manager.getPlugin("PlotSquared");
        Bukkit.getServer().getPluginManager().registerEvents(new SignCreation(), (Plugin)this);
        Bukkit.getServer().getPluginManager().registerEvents(new chatlistener(this, plotArea, plot, pplayer), (Plugin)this);
        if (plotsquared != null && !plotsquared.isEnabled()) {
            System.out.println("Could not find PlotSquared");
            manager.disablePlugin((Plugin)this);
            return;
        }

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new Placeholders().register();
        }
        setApi(new PlotAPI());

        Objects.requireNonNull(getCommand("votewereward")).setExecutor(new VoteRewardCommand());
        System.out.println("playerFile: " + playerFile);
    }



    public void onDisable() {}



    public YamlConfiguration getCustomRpFile() { return customrpfile; }

    public File getRpFile() { return rpfile; }
    public YamlConfiguration getCustomPlayerFile() { return customPlayerfile; }
    public File getPlayerFile() { return playerFile; }
    public PlotAreaType plotArea() {
        return plotArea;
    }

    public void initiateFiles() throws IOException {
        rpfile = new File(getDataFolder(), "rpfile.yml");
        if (!rpfile.exists()) {
            rpfile.createNewFile();
        }
        customrpfile = YamlConfiguration.loadConfiguration(rpfile);
    }





    public void initiatePlayerFiles() throws IOException {
        this.playerFile = new File(getDataFolder(), "playerFile.yml");
        if (!playerFile.exists()) {
            playerFile.createNewFile();
        }
        customPlayerfile = YamlConfiguration.loadConfiguration(playerFile);
    }



    public PlotAPI getApi() {
        return api;
    }




    public void setApi(PlotAPI api) {
        this.api = api;
    }




}
