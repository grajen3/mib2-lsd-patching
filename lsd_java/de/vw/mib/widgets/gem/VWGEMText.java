/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.gem.AbstractText
 */
package de.vw.mib.widgets.gem;

import de.audi.gem.AbstractText;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.text.TextDrawable;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.GlyphStyle;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.widgets.internal.ServiceManager;

public final class VWGEMText
extends AbstractText {
    private final Graphics3D g3d;
    private final Font font;
    private final int fontSize;
    private final int baselineOffset;
    private final Color4b defaultColor;
    private final Color4b selectedColor;
    private String text;
    private int x;
    private int y;
    private boolean selected;
    private boolean visible;
    private TextDrawable textDrawable;
    private TextLayout textLayout;
    private TextStyle[] textStyles;
    private boolean textDrawableValid;

    public VWGEMText(Graphics3D graphics3D, String string, Font font, int n) {
        this.g3d = graphics3D;
        this.text = string;
        this.font = font;
        this.fontSize = n;
        this.baselineOffset = Math.abs(this.font.getHeight(this.fontSize) - this.font.getAscender(this.fontSize) + this.font.getDescender(this.fontSize) >> 6);
        this.defaultColor = new Color4b(Color4b.WHITE);
        this.selectedColor = new Color4b(Color4b.WHITE);
        this.selected = false;
        this.visible = true;
        this.textDrawable = null;
        this.textDrawableValid = false;
    }

    public int getWidth() {
        if (this.textLayout == null) {
            this.updateTextLayout();
        }
        return this.textLayout.getWidth();
    }

    public int getHeight() {
        if (this.textLayout == null) {
            this.updateTextLayout();
        }
        return this.textLayout.getHeight();
    }

    public int getDefaultColorRGBA() {
        return this.defaultColor.getRGBA();
    }

    public int getSelectedColorRGBA() {
        return this.selectedColor.getRGBA();
    }

    public void setColors(int n, int n2) {
        this.defaultColor.setRGBA(n);
        this.selectedColor.setRGBA(n2);
    }

    public int getPositionX() {
        return this.x;
    }

    public int getPositionY() {
        return this.y;
    }

    public void setPosition(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean bl) {
        this.selected = bl;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean bl) {
        this.visible = bl;
    }

    public void draw() {
        if (this.isVisible() && this.text != null) {
            if (this.textDrawable == null) {
                this.textDrawable = this.g3d.getDrawableManager().createTextDrawable();
            }
            if (!this.textDrawableValid) {
                if (this.textLayout == null) {
                    this.updateTextLayout();
                }
                this.textDrawable.setTextLayout(this.textLayout);
                this.textDrawable.setTextStyles(this.textStyles);
                this.textDrawable.setFont(this.font);
                this.textDrawable.setIntervalStart(0);
                this.textDrawable.setIntervalEnd(-129);
                this.textDrawableValid = true;
            }
            if (this.textLayout != null) {
                this.textDrawable.setColor(this.isSelected() ? this.selectedColor : this.defaultColor);
                this.textDrawable.draw(this.getPositionX(), this.getPositionY() + this.baselineOffset);
            }
        }
    }

    private void updateTextLayout() {
        if (this.textStyles == null) {
            GlyphStyle glyphStyle = ServiceManager.textLayoutManager.createGlyphStyle(this.font.getFontId(), this.fontSize, 0x800000);
            this.textStyles = new TextStyle[1];
            this.textStyles[0] = ServiceManager.textLayoutManager.createTextStyle(0, 0, 1, 0, -129, glyphStyle);
        }
        if (this.textLayout != null) {
            this.textLayout.dispose();
        }
        this.textLayout = ServiceManager.textLayoutManager.performTextLayout(-129, -129, 1, false, ' ', false, ' ', this.textStyles, this.text, this.font);
    }

    public void setText(String string) {
        if (this.text == null || !this.text.equals(string)) {
            this.text = string;
            this.textLayout = null;
            this.textDrawableValid = false;
        }
    }

    public void cleanUp() {
        if (this.textStyles != null && this.textStyles[0] != null) {
            this.textStyles[0].dispose();
            this.textStyles = null;
        }
        if (this.textDrawable != null) {
            this.textDrawable.dispose();
            this.textDrawable = null;
        }
        if (this.textLayout != null) {
            this.textLayout.dispose();
            this.textLayout = null;
        }
    }
}

