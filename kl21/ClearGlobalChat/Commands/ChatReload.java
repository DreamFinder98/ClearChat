package kl21.ClearGlobalChat.Commands;

import kl21.ClearGlobalChat.MessagesConfig.ConfigReloader;
import kl21.ClearGlobalChat.MessagesConfig.MessageHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatReload
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] arg3)
  {
    if ((sender instanceof Player))
    {
      Player player = (Player)sender;
      if ((commandLable.equalsIgnoreCase("chatreload")) || (commandLable.equalsIgnoreCase("crl")) || (commandLable.equalsIgnoreCase("chatrl")) || (commandLable.equalsIgnoreCase("creload"))) {
        if ((player.hasPermission("clearchat.reload")) || (player.isOp()))
        {
          ConfigReloader.reloadMessage();
          player.sendMessage(MessageHandler.getMessage("re-loaded"));
        }
        else
        {
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
