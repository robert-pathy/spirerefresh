/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalshadowtech.spirerefresh;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class SpireBlockListener implements Listener {
  private int RANGE;
  private int SAFETY;
  private int STRIKES;
  
  public SpireBlockListener(int range, int safety, int strikes)
  {
    this.RANGE = range;
    this.SAFETY = safety;
    this.STRIKES = strikes;
  }
  
  @EventHandler // EventPriority.NORMAL by default
  public void onBlockRedstoneChange(BlockRedstoneEvent event)
  {
    Block block = event.getBlock();
    
    Block east = block.getRelative(BlockFace.EAST);
    Block west = block.getRelative(BlockFace.WEST);
    Block north = block.getRelative(BlockFace.NORTH);
    Block south = block.getRelative(BlockFace.SOUTH);
    if (event.getNewCurrent() > 1) {
      if (north.getType() == Material.DIAMOND_BLOCK) {
        tryShoot(north);
      } else if (east.getType() == Material.DIAMOND_BLOCK) {
        tryShoot(east);
      } else if (south.getType() == Material.DIAMOND_BLOCK) {
        tryShoot(south);
      } else if (west.getType() == Material.DIAMOND_BLOCK) {
        tryShoot(west);
      }
    }
  }
  
  private void tryShoot(Block base)
  {
    World world = base.getWorld();
    
    int i = 0;
    Block above = base.getRelative(BlockFace.UP);
    while (above.getType() == Material.IRON_BLOCK)
    {
      i++;
      above = above.getRelative(BlockFace.UP);
    }
    if ((i > 2) && (above.getType() == Material.AIR))
    {
      world.strikeLightning(above.getRelative(BlockFace.DOWN).getLocation());
      for (int x = 0; x < this.STRIKES; x++) {
        world.strikeLightning(getOffset(base));
      }
    }
  }
  
  private Location getOffset(Block base)
  {
    Random randy = new Random();
    
    double distance = (randy.nextGaussian() + 1.0D) * this.RANGE + this.SAFETY;
    double angle = randy.nextDouble() * 2.0D * 3.141592653589793D;
    


    Double x = Double.valueOf(Math.cos(angle) * distance);
    Double z = Double.valueOf(Math.sin(angle) * distance);
    

    Location loc = base.getLocation().add(x.doubleValue(), 0.0D, z.doubleValue());
    while (loc.getBlock().getType() == Material.AIR) {
      loc.subtract(0.0D, 1.0D, 0.0D);
    }
    return loc;
  }
}
