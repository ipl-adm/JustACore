package ru.justagod.justacore.gui.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

/**
 * Created by JustAGod on 04.11.17.
 */
public abstract class AbstractButtonOverlay extends ScaledOverlay {

    protected String text;
    private Runnable onClick;
    private ResourceLocation sound = new ResourceLocation("gui.button.press");

    public AbstractButtonOverlay(double x, double y, String text, Runnable onClick, ResourceLocation sound) {
        super(x, y);
        this.text = text;
        this.onClick = onClick;
        this.sound = sound;
    }

    public AbstractButtonOverlay(double x, double y, double width, double height, String text, Runnable onClick, ResourceLocation sound) {
        super(x, y, width, height);
        this.text = text;
        this.onClick = onClick;
        this.sound = sound;
    }

    public AbstractButtonOverlay(double x, double y, double width, double height, boolean scalePosition, boolean scaleSize, String text, Runnable onClick, ResourceLocation sound) {
        super(x, y, width, height, scalePosition, scaleSize);
        this.text = text;
        this.onClick = onClick;
        this.sound = sound;
    }

    public AbstractButtonOverlay(double x, double y, String text, final Runnable onClick) {
        this(x, y, 20, 2, text, onClick);
        setDoScissor(true);
    }

    public AbstractButtonOverlay(double x, double y, double width, double height, String text, final Runnable onClick) {
        super(x, y, width, height);
        this.text = text;
        this.onClick = onClick;
        setDoScissor(true);

    }

    public AbstractButtonOverlay localize() {
        text = I18n.format(text);
        return this;
    }

    @Override
    protected boolean doClick(int x, int y) {
        Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.func_147674_a(sound, 1.0F));
        onClick.run();
        return true;
    }
}
