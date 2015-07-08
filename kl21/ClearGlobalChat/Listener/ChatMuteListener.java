package kl21.ClearGlobalChat.Listener;

import java.util.logging.Logger;
import kl21.ClearGlobalChat.Commands.ChatMute;
import kl21.ClearGlobalChat.MessagesConfig.MessageHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatMuteListener
  implements Listener
{
  public final Logger logger = Logger.getLogger("Minecraft");
  
  @EventHandler
  public void DetectTouch(PlayerChatEvent event)
  {
    if ((!event.getPlayer().hasPermission("clearchat.mute.ignore")) && (ChatMute.Muted))
    {
      event.setCancelled(true);
      event.getPlayer().sendMessage(MessageHandler.getMessage("chat-disabled"));
    }
  }
}
