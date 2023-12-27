/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.text;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.font.style.GlyphStyle;

final class TextDrawableRenderer$DummyGlyphStyle
implements GlyphStyle {
    private int fontId;
    private int fontSize;
    private static HashCodeBuilder hcb;

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.fontId);
        hcb.append(this.fontSize);
        hcb.append(this.isBold());
        hcb.append(this.isItalic());
        hcb.append(this.isHintingDisabled());
        hcb.append(this.isByteCodeHintingDisabled());
        hcb.append(this.isOverline());
        hcb.append(this.isUnderline());
        hcb.append(this.isStrikeOut());
        return hcb.hashCode();
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean isReferenced() {
        return false;
    }

    @Override
    public void reference() {
    }

    @Override
    public int getFontId() {
        return this.fontId;
    }

    public void setFontId(int n) {
        this.fontId = n;
    }

    @Override
    public int getFontSize() {
        return this.fontSize;
    }

    public void setFontSize(int n) {
        this.fontSize = n;
    }

    @Override
    public boolean isUnderline() {
        return false;
    }

    @Override
    public boolean isStrikeOut() {
        return false;
    }

    @Override
    public boolean isOverline() {
        return false;
    }

    @Override
    public boolean isItalic() {
        return false;
    }

    @Override
    public boolean isBold() {
        return false;
    }

    @Override
    public boolean isByteCodeHintingDisabled() {
        return true;
    }

    @Override
    public boolean isHintingDisabled() {
        return true;
    }
}

