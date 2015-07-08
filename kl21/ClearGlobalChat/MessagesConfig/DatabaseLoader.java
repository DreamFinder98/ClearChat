package kl21.ClearGlobalChat.MessagesConfig;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class DatabaseLoader
{
  private File rawFile;
  private String path;
  private String fileName;
  
  @Deprecated
  public DatabaseLoader(String path, String target, String res)
  {
    this.path = path;
    this.fileName = target;
  }
  
  public DatabaseLoader(String path, String target)
  {
    this.path = path;
    this.fileName = target;
  }
  
  public FileConfiguration getFileConfiguration()
  {
    this.rawFile = new File(this.path, this.fileName);
    if (!this.rawFile.exists())
    {
      new File(this.path).mkdirs();
      try
      {
        this.rawFile.createNewFile();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    FileConfiguration fc = new YamlConfiguration();
    try
    {
      fc.load(this.rawFile);
    }
    catch (IOException|InvalidConfigurationException e)
    {
      e.printStackTrace();
    }
    return fc;
  }
}
