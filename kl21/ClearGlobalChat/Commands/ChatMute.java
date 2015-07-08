package kl21.ClearGlobalChat.Commands;

import kl21.ClearGlobalChat.MessagesConfig.MessageHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatMute
  implements CommandExecutor
{
  public static boolean Muted;
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args)
  {
    if ((sender instanceof Player))
    {
      Player player = (Player)sender;
      if ((commandLable.equalsIgnoreCase("chatmute")) || (commandLable.equalsIgnoreCase("cm")))
      {
        if ((player.hasPermission("clearchat.chatmute")) || (player.isOp()))
        {
          if (Muted)
          {
            player.sendMessage(MessageHandler.getMessage("chat-for-players-on"));
            Bukkit.broadcastMessage(MessageHandler.getMessage("chatmute-chat-enabled").replace("%player%", player.getDisplayName()));
            Muted = false;
          }
          else
          {
            player.sendMessage(MessageHandler.getMessage("chat-for-players-off"));
            Bukkit.broadcastMessage(MessageHandler.getMessage("chatmute-chat-disabled").replace("%player%", player.getDisplayName()));
            Muted = true;
          }
          return true;
        }
        player.sendMessage(MessageHandler.getMessage("no-permission"));
      }
    }
    else
    {
      sender.sendMessage(MessageHandler.getMessage("console-use-command"));
    }
    return false;
  }
}
