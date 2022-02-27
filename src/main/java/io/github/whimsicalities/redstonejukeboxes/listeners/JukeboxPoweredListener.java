package io.github.whimsicalities.redstonejukeboxes.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Jukebox;
import org.bukkit.block.data.type.RedstoneWire;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

import java.util.Set;

public class JukeboxPoweredListener implements Listener {
    @EventHandler
    public void onJukeboxPowered(BlockRedstoneEvent e){
        Block block = e.getBlock();
        if (block.getBlockData() instanceof RedstoneWire redstoneWireData){
            Set<BlockFace> possibleBlockFaces = redstoneWireData.getAllowedFaces();
            for (BlockFace blockFace : possibleBlockFaces){
                Block relativeBlock = block.getRelative(blockFace);
                if (relativeBlock.getState() instanceof Jukebox jukeboxState) {
                    Bukkit.broadcastMessage("Jukebox has been powered");
                    Material record = jukeboxState.getRecord().getType();
                    jukeboxState.setPlaying(record);
                    jukeboxState.update();
                    break;
                }
            }
        }
    }
}
