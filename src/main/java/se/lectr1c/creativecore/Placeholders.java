package se.lectr1c.creativecore;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Placeholders extends PlaceholderExpansion {
    Main main = JavaPlugin.getPlugin(Main.class);
    /**
     * This method should always return true unless we
     * have a dependency we need to make sure is on the server
     * for our placeholders to work!
     *
     * @return always true since we do not have any dependencies.
     */
    @Override
    public boolean canRegister(){
        return true;
    }

    /**
     * The name of the person who created this expansion should go here.
     *
     * @return The name of the author as a String.
     */
    @Override
    public String getAuthor(){
        return "lectr1c";
    }

    /**
     * The placeholder identifier should go here.
     * <br>This is what tells PlaceholderAPI to call our onRequest
     * method to obtain a value if a placeholder starts with our
     * identifier.
     * <br>This must be unique and can not contain % or _
     *
     * @return The identifier in {@code %<identifier>_<value>%} as String.
     */
    @Override
    public String getIdentifier(){
        return "carboncore";
    }

    /**
     * This is the version of this expansion.
     * <br>You don't have to use numbers, since it is set as a String.
     *
     * @return The version as a String.
     */
    @Override
    public String getVersion(){
        return "1.0.0";
    }

    /**
     * This is the method called when a placeholder with our identifier
     * is found and needs a value.
     * <br>We specify the value identifier in this method.
     * <br>Since version 2.9.1 can you use OfflinePlayers in your requests.
     *
     * @param
     *          {@link org.bukkit.OfflinePlayer OfflinePlayer}.
     * @param  identifier
     *         A String containing the identifier/value.
     *
     * @return Possibly-null String of the requested identifier.
     */
    @Override
    public String onRequest(OfflinePlayer Player, String identifier){

        // %example_placeholder1%
        if(identifier.equals("roleplayerone")){
            OfflinePlayer playerob = Player;

            try {
            String p = playerob.getPlayer().getName();
            String rpowner = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current rpowner");
            String rprole = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current role");
            List<String> playerlist = (List<String>) main.getCustomRpFile().getList("roleprofiles." + rpowner + ".roles." + rprole + ".options.players in role");


            String player = playerlist.get(0);
            Player pl = Bukkit.getPlayer(player);

            String plname = pl.getName();
            String plrole = main.getCustomPlayerFile().getString("playerprofiles." + plname + ".current role");

            return ChatColor.LIGHT_PURPLE + plrole + " " + ChatColor.WHITE + plname;
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                return " ";
            }
        }
        if(identifier.equals("roleplayertwo")){
            try{
            String p = Player.getPlayer().getName();
            String rpowner = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current rpowner");
            String rprole = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current role");
            List<String> playerlist = (List<String>) main.getCustomRpFile().getList("roleprofiles." + rpowner + ".roles." + rprole + ".options.players in role");



            String player = playerlist.get(1);
            Player pl = Bukkit.getPlayer(player);

            String plname = pl.getName();
            String plrole = main.getCustomPlayerFile().getString("playerprofiles." + plname + ".current role");

            return ChatColor.RED + plrole + " " + ChatColor.WHITE + plname;
            } catch (IndexOutOfBoundsException | NullPointerException e ) {
                return " ";
            }
        }
        if(identifier.equals("roleplayerthree")){
            OfflinePlayer playerob = Player;
            try {
            String p = playerob.getPlayer().getName();
            String rpowner = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current rpowner");
            String rprole = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current role");
            List<String> playerlist = (List<String>) main.getCustomRpFile().getList("roleprofiles." + rpowner + ".roles." + rprole + ".options.players in role");


                String player = playerlist.get(2);
                Player pl = Bukkit.getPlayer(player);

                String plname = pl.getName();
                String plrole = main.getCustomPlayerFile().getString("playerprofiles." + plname + ".current role");

                return ChatColor.YELLOW + plrole + " " + ChatColor.WHITE + plname;
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                return " ";
            }

        }
        if(identifier.equals("roleplayerfour")){
            OfflinePlayer playerob = Player;
            try {
            String p = playerob.getPlayer().getName();
            String rpowner = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current rpowner");
            String rprole = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current role");
            List<String> playerlist = (List<String>) main.getCustomRpFile().getList("roleprofiles." + rpowner + ".roles." + rprole + ".options.players in role");

            String player = playerlist.get(3);
            Player pl = Bukkit.getPlayer(player);

            String plname = pl.getName();
            String plrole = main.getCustomPlayerFile().getString("playerprofiles." + plname + ".current role");

            return ChatColor.GREEN + plrole + " " + ChatColor.WHITE + plname;
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                return " ";
            }
        }
        if(identifier.equals("roleplayerfive")){
            OfflinePlayer playerob = Player;
            try {
            String p = playerob.getPlayer().getName();
            String rpowner = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current rpowner");
            String rprole = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current role");
            List<String> playerlist = (List<String>) main.getCustomRpFile().getList("roleprofiles." + rpowner + ".roles." + rprole + ".options.players in role");


            String player = playerlist.get(4);
            Player pl = Bukkit.getPlayer(player);

            String plname = pl.getName();
            String plrole = main.getCustomPlayerFile().getString("playerprofiles." + plname + ".current role");

            return ChatColor.BLUE + plrole + " " + ChatColor.WHITE + plname;
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                return " ";
            }
        }
        if(identifier.equals("roleplayersix")){
            OfflinePlayer playerob = Player;
            try{
            String p = playerob.getPlayer().getName();
            String rpowner = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current rpowner");
            String rprole = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current role");
            List<String> playerlist = (List<String>) main.getCustomRpFile().getList("roleprofiles." + rpowner + ".roles." + rprole + ".options.players in role");


            String player = playerlist.get(5);
            Player pl = Bukkit.getPlayer(player);

            String plname = pl.getName();
            String plrole = main.getCustomPlayerFile().getString("playerprofiles." + plname + ".current role");

            return ChatColor.LIGHT_PURPLE + plrole + " " + ChatColor.WHITE + plname;
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                return " ";
            }
        }
        if(identifier.equals("roleplayerseven")){
            OfflinePlayer playerob = Player;
            try{
            String p = playerob.getPlayer().getName();
            String rpowner = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current rpowner");
            String rprole = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current role");
            List<String> playerlist = (List<String>) main.getCustomRpFile().getList("roleprofiles." + rpowner + ".roles." + rprole + ".options.players in role");


            String player = playerlist.get(6);
            Player pl = Bukkit.getPlayer(player);

            String plname = pl.getName();
            String plrole = main.getCustomPlayerFile().getString("playerprofiles." + plname + ".current role");

            return ChatColor.GREEN + plrole + " " + ChatColor.WHITE + plname;
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                return " ";
            }
        }
        if(identifier.equals("roleplayereight")){
            OfflinePlayer playerob = Player;
            try {
            String p = playerob.getPlayer().getName();
            String rpowner = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current rpowner");
            String rprole = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current role");
            List<String> playerlist = (List<String>) main.getCustomRpFile().getList("roleprofiles." + rpowner + ".roles." + rprole + ".options.players in role");


            String player = playerlist.get(7);
            Player pl = Bukkit.getPlayer(player);

            String plname = pl.getName();
            String plrole = main.getCustomPlayerFile().getString("playerprofiles." + plname + ".current role");

            return ChatColor.RED + plrole + " " + ChatColor.WHITE + plname;
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                return " ";
            }
        }
        if(identifier.equals("roleplayernine")){
            OfflinePlayer playerob = Player;
            try {
            String p = playerob.getPlayer().getName();
            String rpowner = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current rpowner");
            String rprole = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current role");
            List<String> playerlist = (List<String>) main.getCustomRpFile().getList("roleprofiles." + rpowner + ".roles." + rprole + ".options.players in role");


            String player = playerlist.get(8);
            Player pl = Bukkit.getPlayer(player);

            String plname = pl.getName();
            String plrole = main.getCustomPlayerFile().getString("playerprofiles." + plname + ".current role");

            return ChatColor.BLUE + plrole + " " + ChatColor.WHITE + plname;
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                return " ";
            }
        }
        if(identifier.equals("roleplayerten")){
            OfflinePlayer playerob = Player;
            try {
            String p = playerob.getPlayer().getName();
            String rpowner = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current rpowner");
            String rprole = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current role");
            List<String> playerlist = (List<String>) main.getCustomRpFile().getList("roleprofiles." + rpowner + ".roles." + rprole + ".options.players in role");


            String player = playerlist.get(9);
            Player pl = Bukkit.getPlayer(player);

            String plname = pl.getName();
            String plrole = main.getCustomPlayerFile().getString("playerprofiles." + plname + ".current role");

            return ChatColor.BLUE + plrole + " " + ChatColor.WHITE + plname;
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                return " ";
            }
        }
        if(identifier.equals("roleplayereleven")){
            OfflinePlayer playerob = Player;
            try {
            String p = playerob.getPlayer().getName();
            String rpowner = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current rpowner");
            String rprole = main.getCustomPlayerFile().getString("playerprofiles." + p + ".current role");
            List<String> playerlist = (List<String>) main.getCustomRpFile().getList("roleprofiles." + rpowner + ".roles." + rprole + ".options.players in role");


            String player = playerlist.get(10);
            Player pl = Bukkit.getPlayer(player);

            String plname = pl.getName();
            String plrole = main.getCustomPlayerFile().getString("playerprofiles." + plname + ".current role");

            return ChatColor.BLUE + plrole + " " + ChatColor.WHITE + plname;
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                return " ";
            }
        }

        // We return null if an invalid placeholder (f.e. %example_placeholder3%)
        // was provided
        return null;
    }
}
