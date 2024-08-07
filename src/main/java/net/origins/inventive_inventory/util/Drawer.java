package net.origins.inventive_inventory.util;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

public class Drawer {

    public static void drawSlotBackground(DrawContext context, int x, int y, int color, int z) {
        context.fillGradient(x, y, x + 16, y + 16, z, color, color);
    }

    public static void drawTexture(DrawContext context, Identifier texture, int x, int y, int z, int size) {
        context.drawTexture(texture, x, y, z, 0, 0, size, size, size, size);
    }

}
