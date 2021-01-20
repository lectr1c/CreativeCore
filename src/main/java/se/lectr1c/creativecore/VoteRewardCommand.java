package se.lectr1c.creativecore;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class VoteRewardCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        if (sender instanceof ConsoleCommandSender) {


            if (args[0].length() > 0) {

                String player = args[0].toString();

                Player p = Bukkit.getPlayer(player);

                assert p != null;
                if (p.hasPermission("carbon.tier1")) {

                    Bukkit.dispatchCommand(console, "lp user " + player + " parent addtemp voter 2h30m accumulate");


                } else if (p.hasPermission("carbon.tier2")) {

                    Bukkit.dispatchCommand(console, "lp user " + player + " parent addtemp voter 1h30m accumulate");

                } else if (p.hasPermission("carbon.tier3")) {

                    Bukkit.dispatchCommand(console, "lp user " + player + " parent addtemp voter 45m accumulate");



                } else if (p.hasPermission("carbon.user")) {

                    Bukkit.dispatchCommand(console, "lp user " + player + " parent addtemp voter 30m accumulate");

                }

            } else {
                return false;
            }

        }
        return false;
    }

}
