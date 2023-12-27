/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.util.StringBuilder;

public final class FontAttribs
implements Cloneable {
    private static final String INVALID_FONT_NAME;
    private static final int INVALID_FONT_SIZE;
    private static HashCodeBuilder hcb;
    private String name;
    private int size;
    private int style;

    public FontAttribs() {
        this("", 0, 0);
    }

    public FontAttribs(FontAttribs fontAttribs) {
        this(fontAttribs.getName(), fontAttribs.getSize(), fontAttribs.getStyle());
    }

    public FontAttribs(String string, int n, int n2) {
        this.name = string;
        this.size = n;
        this.style = n2;
    }

    public FontAttribs(String string, int n) {
        this(string, n, 0);
    }

    public Object clone() {
        try {
            FontAttribs fontAttribs = (FontAttribs)super.clone();
            return fontAttribs;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.name);
        hcb.append(this.size);
        hcb.append(this.style);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            FontAttribs fontAttribs = (FontAttribs)object;
            return this.name.equals(fontAttribs.name) && this.size == fontAttribs.size && this.style == fontAttribs.style;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[name=").append(this.name);
        stringBuilder.append(",size=").append(this.size);
        stringBuilder.append(",style=").append(this.style);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean isEmpty() {
        return "".equals(this.name);
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int n) {
        this.size = n;
    }

    public int getStyle() {
        return this.style;
    }

    public void setStyle(int n) {
        this.style = n;
    }
}

