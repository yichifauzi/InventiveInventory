package net.origins.inventive_inventory.config.options;

import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;
import net.origins.inventive_inventory.InventiveInventory;
import net.origins.inventive_inventory.commands.config.type.ConfigType;
import org.jetbrains.annotations.Nullable;

public class SimpleConfigOption extends ConfigOption<Boolean> {
    private final Text tooltip;

    public SimpleConfigOption(String key, boolean defaultValue, ConfigType configType) {
        this(key, key, defaultValue, configType);
    }

    public SimpleConfigOption(String key, String tooltipKey, boolean defaultValue, ConfigType configType) {
        super(key, defaultValue, configType);
        this.tooltip = Text.translatable("optionTooltip." + InventiveInventory.MOD_ID + "." + tooltipKey);
    }

    private void cycle() {
        this.setValue(!this.getValue());
    }

    @Override
    public Boolean[] getValues() {
        return new Boolean[]{true, false};
    }

    @Override
    public void setValue(@Nullable String value) {
        if (value != null) {
            if (value.equals("Yes")) this.setValue(true);
            else if (value.equals("No")) this.setValue(false);
        }
    }

    @Override
    public SimpleOption<?> asButton() {
        return SimpleOption.ofBoolean(
                this.getTranslationKey(),
                SimpleOption.constantTooltip(this.tooltip),
                (optionText, value) -> ConfigOption.getValueAsText(value),
                this.getValue(),
                aBoolean -> this.cycle());
    }
}
