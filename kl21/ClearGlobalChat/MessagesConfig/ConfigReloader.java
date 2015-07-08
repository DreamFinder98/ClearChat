package kl21.ClearGlobalChat.MessagesConfig;

public class ConfigReloader
{
  public static void reloadMessage()
  {
    ConfigLoader.reloadMessages();
    MessageHandler.reload();
  }
}
