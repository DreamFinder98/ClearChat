package kl21.ClearGlobalChat.MessagesConfig;

import kl21.ClearGlobalChat.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;

public class ConfigLoader
{
  public void load() {}
  
  public static void reloadMessages()
  {
    FileConfiguration c = new DatabaseLoader("plugins/ClearChat", "messages.yml").getFileConfiguration();
    Main.messages = c;
    
    c.addDefault("prefix", "&4[&bClearChat&4] &r");
    c.addDefault("no-permission", "&cYou do not have permission to use this command.");
    c.addDefault("re-loaded", "&aSuccessfully reloaded file &e&l'messages.yml'&a.");
    c.addDefault("console-use-command", "&cOnly player can use commands.");
    c.addDefault("clear-chat", "&6Chat has been cleared by &r%player%&6.");
    c.addDefault("clear-private-chat", "&6You cleaned your private chat.");
    c.addDefault("chat-for-players-off", "&7Chat for players: &cDisabled&7.");
    c.addDefault("chat-for-players-on", "&7Chat for players: &aEnabled&7.");
    c.addDefault("chatmute-chat-disabled", "&6Chat has been &cDisabled&6 by &r%player%&6.");
    c.addDefault("chatmute-chat-enabled", "&6Chat has been &aEnabled&6 by &r%player%&6.");
    c.addDefault("chat-disabled", "&6Chat is currently &cDisabled&6.");
    
    c.options().header(
      "##### ClearGlobalChat v1.1.0 - Messages.yml ##### #\n#####         Plugin created by kl21        ##### #\n#####           File: Messages.yml          ##### #\n#####   All configurable messages are here  ##### #\n");
    
    c.options().copyDefaults(true);
    Main.saveMessages();
  }
}
