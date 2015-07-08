package kl21.ClearGlobalChat;

import java.io.IOException;
import java.io.PrintStream;
import kl21.ClearGlobalChat.Commands.ChatMute;
import kl21.ClearGlobalChat.Commands.ChatReload;
import kl21.ClearGlobalChat.Commands.ClearChat;
import kl21.ClearGlobalChat.Commands.ClearPrivateChat;
import kl21.ClearGlobalChat.Listener.ChatMuteListener;
import kl21.ClearGlobalChat.MessagesConfig.ConfigLoader;
import kl21.ClearGlobalChat.MessagesConfig.MessageHandler;
import org.bukkit.Server;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
{
  public static Main instance;
  public static String version = "ClearChat - Version ";
  public static FileConfiguration messages;
  
  public void onDisable()
  {
    System.out.println("[ClearChat] =================================");
    System.out.println("[ClearChat] Author: kl21");
    System.out.println("[ClearChat] Version: v" + getDescription().getVersion());
    System.out.println("[ClearChat] Status: Disabled");
    System.out.println("[ClearChat] =================================");
  }
  
  public void onEnable()
  {
    System.out.println("[ClearChat] =================================");
    System.out.println("[ClearChat] Author: kl21");
    System.out.println("[ClearChat] Version: v" + getDescription().getVersion());
    System.out.println("[ClearChat] Status: Enabled");
    
    new ConfigLoader().load();
    MessageHandler.reload();
    
    instance = this;
    version += getDescription().getVersion();
    
    getCommand("cc").setExecutor(new ClearChat());
    getCommand("clearchat").setExecutor(new ClearChat());
    
    getCommand("cpc").setExecutor(new ClearPrivateChat());
    getCommand("clearprivatechat").setExecutor(new ClearPrivateChat());
    
    getCommand("cm").setExecutor(new ChatMute());
    getCommand("chatmute").setExecutor(new ChatMute());
    
    getCommand("chatreload").setExecutor(new ChatReload());
    getCommand("crl").setExecutor(new ChatReload());
    getCommand("chatrl").setExecutor(new ChatReload());
    getCommand("creload").setExecutor(new ChatReload());
    
    getServer().getPluginManager().registerEvents(new ChatMuteListener(), this);
    try
    {
      System.out.println("[ClearChat] Starting Metrics.");
      Metrics metrics = new Metrics(this);
      metrics.start();
      System.out.println("[ClearChat] Metrics started.");
      System.out.println("[ClearChat] =================================");
    }
    catch (IOException localIOException) {}
  }
  
  public static void saveMessages()
  {
    try
    {
      System.out.println("[ClearChat] Loading Messages.");
      messages.save("plugins/ClearChat/messages.yml");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
