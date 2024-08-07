package net.origins.inventive_inventory.config.screens;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.OptionListWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.origins.inventive_inventory.InventiveInventory;
import net.origins.inventive_inventory.config.ConfigManager;


public class ConfigScreen extends GameOptionsScreen {
    private OptionListWidget body;

    public ConfigScreen(Screen parent) {
        super(parent, InventiveInventory.getClient().options, Text.of("Inventive Inventory Options"));
    }

    @Override
    protected void init() {
        this.body = new OptionListWidget(this.client, this.width, this.height, 32, this.height - 32, 25);
        this.addOptions();
        this.addSelectableChild(this.body);
        this.addDrawableChild(
                ButtonWidget.builder(ScreenTexts.DONE, (button) -> this.close())
                        .position(this.width / 2 - 100, this.height - 27)
                        .size(200, 20)
                        .build());
    }

    @Override
    public void render(DrawContext DrawContext, int mouseX, int mouseY, float delta) {
        this.renderBackgroundTexture(DrawContext);
        this.body.render(DrawContext, mouseX, mouseY, delta);
        DrawContext.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 5, 0xffffff);
        super.render(DrawContext, mouseX, mouseY, delta);
    }

    public void addOptions() {
        if (this.client == null || this.body == null) return;
        this.body.addSingleOptionEntry(ConfigManager.SORTING.asButton());
        this.body.addOptionEntry(ConfigManager.SORTING_MODE.asButton(), ConfigManager.CURSOR_STACK_BEHAVIOUR.asButton());

    }
}
