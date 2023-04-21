package client.rapid.module.modules.player;

import client.rapid.event.events.Event;
import client.rapid.event.events.player.EventMotion;
import client.rapid.event.events.player.EventUpdate;
import client.rapid.module.*;
import client.rapid.module.modules.Category;
import client.rapid.module.settings.Setting;
import client.rapid.util.PacketUtil;
import client.rapid.util.TimerUtil;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.enchantment.*;
import net.minecraft.inventory.Slot;
import net.minecraft.item.*;
import net.minecraft.network.play.client.*;
import net.minecraft.util.*;

@ModuleInfo(getName = "Inventory Manager", getCategory = Category.PLAYER)
public class InventoryManager extends Module {
    private final Setting
    delay = new Setting("Delay", this, 100, 10, 500, true),
    swordSlot = new Setting("Sword Slot", this, 1, 1, 9, true),
    clean = new Setting("Clean", this, false),
    keepAxe = new Setting("Keep Axe", this, true),
    keepPickaxe = new Setting("Keep Pickaxe", this, true),
    keepShovel = new Setting("Keep Shovel", this, true),
    inventoryOnly = new Setting("Inventory Only", this, false);

    private final TimerUtil timer = new TimerUtil();

    public InventoryManager() {
        add(delay, swordSlot, clean, keepAxe, keepPickaxe, keepShovel, inventoryOnly);
    }

    public void onEvent(Event e) {
        if(e instanceof EventUpdate && e.isPre()) {
            if(inventoryOnly.isEnabled() && !(mc.currentScreen instanceof GuiInventory))
                return;

            if(timer.sleep((int) delay.getValue())) {
                for(int i = 0; i < mc.thePlayer.inventory.mainInventory.length; i++) {
                    ItemStack stack = mc.thePlayer.inventory.mainInventory[i];

                    if(stack != null && !(stack.getItem() instanceof ItemArmor)) {
                        if(clean.isEnabled()) {
                            if(stack.getItem() instanceof ItemSword) {
                                if(getBestSword() != -1 && getBestSword() != i)
                                    drop(i, stack);
                            }
                            if(stack.getItem() instanceof ItemAxe && !keepAxe.isEnabled()) {
                                if(getBestAxe() != -1 && getBestAxe() != i)
                                    drop(i, stack);
                            }
                            if(stack.getItem() instanceof ItemPickaxe && !keepPickaxe.isEnabled()) {
                                if(getBestPickaxe() != -1 && getBestPickaxe() != i)
                                    drop(i, stack);
                            }

                            if(isShovel(stack.getItem()) && stack.getItem() instanceof ItemTool && !keepShovel.isEnabled()) {
                                if(getBestPickaxe() != -1 && getBestPickaxe() != i)
                                    drop(i, stack);
                            }
                        }
                        if(getBestSword() != -1 && getBestSword() != swordSlot.getValue() - 1) {
                            for(int j = 0; j < mc.thePlayer.inventoryContainer.inventorySlots.size(); j++) {
                                Slot slot = mc.thePlayer.inventoryContainer.inventorySlots.get(i);

                                if(slot.getHasStack() && slot.getStack() == mc.thePlayer.inventory.mainInventory[getBestSword()]) {
                                    mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId, slot.slotNumber, (int)swordSlot.getValue(), 2, mc.thePlayer);
                                }
                            }
                        }
                        if(isBadItem(stack.getItem()))
                            drop(i, stack);
                    }
                }
            }
        }
    }

    private int getBestSword() {
        int bestSword = -1;
        float bestDamage = 1;

        for(int i = 0; i < mc.thePlayer.inventory.mainInventory.length; i++) {
            ItemStack stack = mc.thePlayer.inventory.mainInventory[i];

            if(stack != null && stack.getItem() instanceof ItemSword) {
                ItemSword itemSword = (ItemSword)stack.getItem();

                float damage = itemSword.getDamageVsEntity();
                damage += EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, stack);

                if(damage > bestDamage) {
                    bestDamage = damage;
                    bestSword = i;
                }
            }
        }
        return bestSword;
    }

    private int getBestPickaxe() {
        int best = -1;
        float bestDamage = 1;

        for(int i = 0; i < mc.thePlayer.inventory.mainInventory.length; i++) {
            ItemStack stack = mc.thePlayer.inventory.mainInventory[i];

            if(stack != null && stack.getItem() instanceof ItemPickaxe) {
                ItemPickaxe itemSword = (ItemPickaxe)stack.getItem();

                float damage = itemSword.getStrVsBlock(stack, Block.getBlockById(4));
                damage += EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, stack);

                if(damage > bestDamage) {
                    bestDamage = damage;
                    best = i;
                }
            }
        }
        return best;
    }

    private int getBestAxe() {
        int best = -1;
        float bestDamage = 1;

        for(int i = 0; i < mc.thePlayer.inventory.mainInventory.length; i++) {
            ItemStack stack = mc.thePlayer.inventory.mainInventory[i];

            if(stack != null && stack.getItem() instanceof ItemAxe) {
                ItemAxe itemSword = (ItemAxe)stack.getItem();

                float damage = itemSword.getStrVsBlock(stack, Block.getBlockById(4));
                damage += EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, stack);

                if(damage > bestDamage) {
                    bestDamage = damage;
                    best = i;
                }
            }
        }
        return best;
    }

    private boolean isShovel(Item item) {
        return Item.getItemById(256) == item || Item.getItemById(269) == item ||Item.getItemById(273) == item ||Item.getItemById(277) == item ||Item.getItemById(284) == item;
    }

    private int getBestShovel() {
        int best = -1;
        float bestDamage = 1;

        for(int i = 0; i < mc.thePlayer.inventory.mainInventory.length; i++) {
            ItemStack stack = mc.thePlayer.inventory.mainInventory[i];

            if(stack != null && isShovel(stack.getItem()) && stack.getItem() instanceof ItemTool) {
                ItemTool itemSword = (ItemTool)stack.getItem();

                float damage = itemSword.getStrVsBlock(stack, Block.getBlockById(4));
                damage += EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, stack);

                if(damage > bestDamage) {
                    bestDamage = damage;
                    best = i;
                }
            }
        }
        return best;
    }

    private void drop(int slot, ItemStack item) {
        boolean hotbar = false;

        for(int i =0; i < 9; i++) {
            ItemStack stack = mc.thePlayer.inventory.getStackInSlot(i);

            if(stack != null && stack == item) {
                hotbar = true;
                continue;
            }
        }
        if(hotbar) {
            PacketUtil.sendPacket(new C09PacketHeldItemChange(slot));
            PacketUtil.sendPacket(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.DROP_ALL_ITEMS, BlockPos.ORIGIN, EnumFacing.DOWN));
        } else {
            mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId, slot, 0, 0, mc.thePlayer);
            mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId, -999, 0, 0, mc.thePlayer);
        }
    }

    private boolean isBadItem(Item item) {
        return item.getUnlocalizedName().contains("tnt") ||
                item.getUnlocalizedName().contains("stick") ||
                item.getUnlocalizedName().contains("egg") ||
                item.getUnlocalizedName().contains("string") ||
                item.getUnlocalizedName().contains("flint") ||
                item.getUnlocalizedName().contains("bow") ||
                item.getUnlocalizedName().contains("arrow") ||
                item.getUnlocalizedName().contains("bucket") ||
                item.getUnlocalizedName().contains("feather") ||
                item.getUnlocalizedName().contains("snow") ||
                item.getUnlocalizedName().contains("piston") ||
                item instanceof ItemGlassBottle ||
                item.getUnlocalizedName().contains("web") ||
                item.getUnlocalizedName().contains("slime") ||
                item.getUnlocalizedName().contains("trip") ||
                item.getUnlocalizedName().contains("wire") ||
                item.getUnlocalizedName().contains("sugar") ||
                item.getUnlocalizedName().contains("note") ||
                item.getUnlocalizedName().contains("record") ||
                item.getUnlocalizedName().contains("flower") ||
                item.getUnlocalizedName().contains("wheat") ||
                item.getUnlocalizedName().contains("fishing") ||
                item.getUnlocalizedName().contains("boat") ||
                item.getUnlocalizedName().contains("leather") ||
                item.getUnlocalizedName().contains("seeds") ||
                item.getUnlocalizedName().contains("skull") ||
                item.getUnlocalizedName().contains("torch") ||
                item.getUnlocalizedName().contains("anvil") ||
                item.getUnlocalizedName().contains("enchant") ||
                item.getUnlocalizedName().contains("exp") ||
                item.getUnlocalizedName().contains("shears");

    }
}
