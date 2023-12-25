package io.ren778.github.rensato_whistle.item;

import io.ren778.github.rensato_whistle.registers.WhistleModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ItemWhistle extends Item {
    public ItemWhistle() {
        super(new Properties()
                .rarity(Rarity.COMMON)
                .stacksTo(1)
        );
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        List<Entity> entities = world.getEntities(null, player.getLocalBoundsForPose(player.getPose()));

        for (Entity entity:entities) {
            entity.teleportTo(player.position().x, player.position().y, player.position().z);
        }

        world.playSound(null, player.position().x, player.position().y, player.position().z, WhistleModSounds.WHISTLE_CLICK.get(), SoundSource.MASTER, 1, 1);

        return InteractionResultHolder.consume(stack);
    }
}
