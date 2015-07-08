package kl21.ClearGlobalChat.MessagesConfig;

import java.io.PrintStream;
import java.util.HashMap;
import kl21.ClearGlobalChat.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class MessageHandler
{
  private static HashMap<String, String> messages = new HashMap();
  
  public static void reload()
  {
    messages.clear();
    for (String key : Main.messages.getConfigurationSection("").getKeys(false)) {
      messages.put(key, replaceColors(Main.messages.getString(key)));
    }
    System.out.println("[ClearChat] " + messages.size() + " messages loaded!");
  }
  
  public static String getMessage(String name)
  {
    if (messages.containsKey(name))
    {
      if (name.equalsIgnoreCase("prefix")) {
        return (String)messages.get(name);
      }
      return (String)messages.get("prefix") + (String)messages.get(name);
    }
    return "§cMessages not loaded!";
  }
  
  public static String getMessageWithNoPrefix(String name)
  {
    if (messages.containsKey(name)) {
      return (String)messages.get(name);
    }
    return "§cMessages not loaded!";
  }
  
  public static String replaceColors(String s)
  {
    return ChatColor.translateAlternateColorCodes('&', s);
  }
}
