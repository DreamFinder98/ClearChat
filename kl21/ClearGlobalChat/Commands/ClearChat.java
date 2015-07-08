package kl21.ClearGlobalChat.Commands;

import java.util.logging.Logger;
import kl21.ClearGlobalChat.MessagesConfig.MessageHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat
  implements CommandExecutor
{
  public final Logger logger = Logger.getLogger("Minecraft");
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] arg3)
  {
    if ((sender instanceof Player))
    {
      Player player = (Player)sender;
      if ((commandLable.equalsIgnoreCase("clearchat")) || (commandLable.equalsIgnoreCase("cc"))) {
        if ((player.hasPermission("clearchat.clearchat")) || (player.isOp())) {
          for (int x = 0; x < 120; x++)
          {
            Bukkit.broadcastMessage("");
            if (x == 119) {
              Bukkit.broadcastMessage(MessageHandler.getMessage("clear-chat").replace("%player%", player.getDisplayName()));
            }
          }
        } else {
          player.sendMessage(MessageHandler.getMessage("no-permission"));
        }
      }
    }
    else
    {
      sender.sendMessage(MessageHandler.getMessage("console-use-command"));
    }
    return false;
  }
}
