package kl21.ClearGlobalChat.Commands;

import java.util.logging.Logger;
import kl21.ClearGlobalChat.MessagesConfig.MessageHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearPrivateChat
  implements CommandExecutor
{
  public final Logger logger = Logger.getLogger("Minecraft");
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] arg3)
  {
    if ((sender instanceof Player))
    {
      Player player = (Player)sender;
      if ((commandLable.equalsIgnoreCase("clearprivatechat")) || (commandLable.equalsIgnoreCase("cpc"))) {
        if ((player.hasPermission("clearchat.clearprivatechat")) || (player.isOp())) {
          for (int x = 0; x < 120; x++)
          {
            player.sendMessage("");
            if (x == 119) {
              player.sendMessage(MessageHandler.getMessage("clear-private-chat"));
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
