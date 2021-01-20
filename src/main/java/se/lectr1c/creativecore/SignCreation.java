package se.lectr1c.creativecore;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

    public class SignCreation implements Listener {

        Main main = JavaPlugin.getPlugin(Main.class);

            
               private void saverpFile() {
                     try {
                           main.getCustomRpFile().save(main.getRpFile());
                         } catch (IOException e1) {

                         
                           e1.printStackTrace();
                         }
                   }
            
               private void savePlayerFile() {
                     try {
                           main.getCustomPlayerFile().save(main.getPlayerFile());
                         } catch (IOException e1) {
                    
                           e1.printStackTrace();
                         }
                   }
            
               @EventHandler
               public void onSignChange(SignChangeEvent e) {
                     String[] signlines = e.getLines();
                
                
                
                
                
                
                     if (signlines[0].equalsIgnoreCase("[role]")) {
                         int roleCapacity;
                         String roleLine;
                         String signOwner;
                         int currentJoined;
                         List<String> playersjoined = new ArrayList<>();
                    
                           try {
                                 roleCapacity = Integer.parseInt(signlines[2]);
                               }
                           catch (NumberFormatException ex) {
                                 e.getPlayer().sendMessage(ChatColor.RED +
                                             "Line three on the sign should contain the amount of players that can join that role.");
                                 return;
                               }
                           signOwner = ChatColor.stripColor(e.getPlayer().getDisplayName());
                           currentJoined = 0;
                           roleLine = e.getLine(1).toString();
                           roleCapacity = Integer.parseInt(e.getLine(2).toString());
                           Location signlocation = e.getBlock().getLocation();
                    
                           main.getCustomRpFile().createSection("roleprofiles." + signOwner + ".roles." + roleLine);
                    
                           e.setLine(0, ChatColor.GRAY + "[" + ChatColor.RED + "RP Role" + ChatColor.GRAY + "]");
                           e.setLine(1, roleLine);
                           e.setLine(2, "§7" + currentJoined + "§c/§7" + roleCapacity);
                           e.setLine(3, "§7" + signOwner);
                    
                           saverpFile();

                         YamlConfiguration playerconfig = main.getCustomRpFile();

                           playerconfig.set("roleprofiles." + signOwner + ".roles." + roleLine + ".options.currently joined", currentJoined);
                           playerconfig.set("roleprofiles." + signOwner + ".roles." + roleLine + ".options.max capacity", roleCapacity);
                           playerconfig.set("roleprofiles." + signOwner + ".roles." + roleLine + ".options.sign location", signlocation);
                           playerconfig.set("roleprofiles." + signOwner + ".roles." + roleLine + ".options.players in role", playersjoined);
                           playerconfig.set("roleprofiles." + signOwner + ".roles." + roleLine + ".options.world", e.getBlock().getWorld().getName());
                           saverpFile();
                         }
                   }
            
            
            
            
            
            
               @EventHandler
               public void onPlayerInteract(PlayerInteractEvent event) {
                     if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                         Objects.requireNonNull(event.getClickedBlock()).getState();
                         if (event.getClickedBlock().getState() instanceof Sign) {

                             Sign sign = (Sign) event.getClickedBlock().getState();
                             if (sign.getLine(0).equals(ChatColor.GRAY + "[" + ChatColor.RED + "RP Role" + ChatColor.GRAY + "]")) {

                                 //Initiate Before Sign
                                 YamlConfiguration rpconfig = main.getCustomRpFile();
                                 YamlConfiguration playerconfig = main.getCustomPlayerFile();
                                 String player = event.getPlayer().getName();
                                 //get old info
                                 String oldrole = playerconfig.getString("playerprofiles." + player + ".current role");
                                 String oldrpowner = playerconfig.getString("playerprofiles." + player + ".current rpowner");

                                 //Get Info from sign.
                                 String rolename = sign.getLine(1).toString();
                                 String roleowner = sign.getLine(3).toString();

                                 //Initiate & Get Info from yml files.

                                 int joined = rpconfig.getInt("roleprofiles." + roleowner + ".roles." + rolename + ".options.currently joined");
                                 int maxplayers = rpconfig.getInt("roleprofiles." + roleowner + ".roles." + rolename + ".options.max capacity");
                                 List<String> playerlist = rpconfig.getStringList("roleprofiles." + roleowner + ".roles." + rolename + ".options.players in role");
                                 Player p = event.getPlayer();

                                 //If checks if player can join.
                                 for (String pl : playerlist) {
                                     if (pl.equals(player) && Objects.equals(playerconfig.getString("playerprofiles." + player + ".current role"), rolename)) {
                                         p.sendMessage(org.bukkit.ChatColor.DARK_RED + "You are already in this role.");

                                         //
                                         return;
                                     }
                                 }
                                 if (joined == maxplayers) {
                                     p.sendMessage(org.bukkit.ChatColor.DARK_RED + "Role is full.");
                                     return;
                                 }

                                 if (!rolename.equals(oldrole) && !roleowner.equals(oldrpowner) && !rolename.equals("none")) {
                                     List<String> oldplayerlist = rpconfig.getStringList("roleprofiles." + oldrpowner + ".roles." + oldrole + ".options.players in role");
                                     oldplayerlist.remove(playerlist.indexOf(player));
                                     int oldjoined = rpconfig.getInt("roleprofiles." + roleowner + ".roles." + rolename + ".options.currently joined");
                                     oldjoined = oldjoined - 1;
                                     rpconfig.set("roleprofiles." + oldrpowner + ".roles." + oldrole + ".options.currently joined",
                                             oldjoined);
                                     rpconfig.set("roleprofiles." + oldrpowner + ".roles." + oldrole + ".options.players in role",
                                             oldplayerlist);
                                     savePlayerFile();
                                     saverpFile();
                                 }

                                 //edit variables

                                 joined = joined + 1;
                                 playerlist.add(player);

                                 //Set info in config
                                 rpconfig.set("roleprofiles." + roleowner + ".roles." + rolename + ".options.currently joined",
                                         joined);
                                 rpconfig.set("roleprofiles." + roleowner + ".roles." + rolename + ".options.players in role",
                                         playerlist);
                                 playerconfig.set("playerprofiles." + player + ".current role", rolename);
                                 playerconfig.set("playerprofiles." + player + ".current rpowner", roleowner);
                                 savePlayerFile();
                                 saverpFile();


                                 //Set info on sign
                                 sign.setLine(2, "§7" + joined + "§c/§7" + maxplayers);
                                 sign.update();


                             }
                         }
                     }
                   }
            
            
            
            
            
            
            
               @EventHandler
               public void onPlayerBreakBlock(BlockBreakEvent e) {
                     Sign sign = (Sign)e.getBlock().getState();
                
                     if (e.getBlock().getState() instanceof Sign && sign.getLine(0).equals(ChatColor.GRAY + "[" + ChatColor.RED + "RP Role" + ChatColor.GRAY + "]")) {
                    
                           String signOwnerBreak = ChatColor.stripColor(sign.getLine(3));
                           String signRole = sign.getLine(1);
                           List<String> playersjoined1 = main.getCustomRpFile().getStringList("roleprofiles." + signOwnerBreak + ".roles." + signRole + ".options.players in role");
                    
                           for (String player : playersjoined1) {
                                 main.getCustomPlayerFile().set("playerprofiles." + player + ".current role", "none");
                               }
                    
                           main.getCustomRpFile().set("roleprofiles." + signOwnerBreak + ".roles." + signRole, "Deleted");
                    
                           saverpFile();
                           savePlayerFile();
                         }
                   }
             }
