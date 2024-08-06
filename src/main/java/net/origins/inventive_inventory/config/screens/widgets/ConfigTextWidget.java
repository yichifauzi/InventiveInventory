package net.origins.inventive_inventory.config.screens.widgets;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.text.Text;

public class ConfigTextWidget extends TextWidget {
    public ConfigTextWidget(Text message, TextRenderer textRenderer) {
        super(message, textRenderer);
    }

    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y + 6);
    }
}
