/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalshadowtech.spirerefresh;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Spirerefresh extends JavaPlugin {
  public final Logger logger = Logger.getLogger("Minecraft");
  public String enabledstartup = "Enabled On Startup";
  public boolean enabled = true;
 // public Configuration config;
 
  
  public void onDisable()
  {
    this.logger.info("Spire Disabled");
  }
  
  public void onEnable()
  {    
    getServer().getPluginManager().registerEvents(new SpireBlockListener(this.getConfig().getInt("setting.range"), this.getConfig().getInt("setting.safety"), this.getConfig().getInt("setting.strikes")), this);
    
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled.");
    
  }
      
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
      
       if(cmd.getName().equalsIgnoreCase("spirerf")){ // If the player typed /knspire then do the following...
            if (args.length > 1) {
               sender.sendMessage("Too many arguments!");
               return false;
            } 
            
            if (args.length < 1) {
               sender.sendMessage("Not enough arguments!");
               return false;
            }	
            
            if(args[0] == "reload"){
                sender.sendMessage("Spire Refresh Reloaded");
                this.reloadConfig();
		return true;  
            }else{
               sender.sendMessage("Unknown Argument."); 
               return false;  
            }
                
	} 
        
	return false; 
    }
  
  public void loadConfiguration(){
     // might use this later so keeping it for now.
     // However this code is never called in this program.
      
     int range = this.getConfig().getInt("setting.range");
     int safety = this.getConfig().getInt("setting.safety");
     int strikes = this.getConfig().getInt("setting.strikes");
     
     this.getConfig().options().copyDefaults(true); 
     this.saveConfig();
     }
}
