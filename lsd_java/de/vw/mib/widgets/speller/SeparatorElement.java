/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.Point;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.Alphabet;

public final class SeparatorElement {
    private final int index;
    private int x;
    private int y;
    private int width;
    private int height;
    private int imageId;
    private Alphabet alphabet;

    public SeparatorElement(int n, int n2, int n3, int n4, int n5) {
        this(-1, n, n2, n3, n4, n5);
    }

    public SeparatorElement(int n, int n2, int n3, int n4, int n5, int n6) {
        this.index = n;
        this.x = n2;
        this.y = n3;
        this.width = n4;
        this.height = n5;
        this.imageId = n6;
    }

    public int getIndex() {
        return this.index;
    }

    public int getAbsX() {
        Point point;
        if (this.alphabet != null && (point = this.alphabet.getLocation()) != null) {
            return this.x + point.x;
        }
        return this.x;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int n) {
        this.x = n;
    }

    public int getAbsY() {
        Point point;
        if (this.alphabet != null && (point = this.alphabet.getLocation()) != null) {
            return this.y + point.y;
        }
        return this.y;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int n) {
        this.y = n;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int n) {
        this.width = n;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int n) {
        this.height = n;
    }

    public int getImageId() {
        return this.imageId;
    }

    public void setImageId(int n) {
        this.imageId = n;
    }

    public Alphabet getAlphabet() {
        return this.alphabet;
    }

    public void setAlphabet(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            SeparatorElement separatorElement = (SeparatorElement)object;
            boolean bl = this.index == separatorElement.index && this.x == separatorElement.x && this.y == separatorElement.y && this.width == separatorElement.width && this.height == separatorElement.height;
            return bl;
        }
        return false;
    }

    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.index);
        hashCodeBuilder.append(this.x);
        hashCodeBuilder.append(this.y);
        hashCodeBuilder.append(this.width);
        hashCodeBuilder.append(this.height);
        hashCodeBuilder.append(this.imageId);
        return hashCodeBuilder.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SeperatorElement");
        stringBuilder.append("[index=").append(this.index).append(", x=").append(this.x).append(", y=").append(this.y).append(", width=").append(this.width).append(", height=").append(this.height).append(", imageId=").append(this.imageId).append("]");
        return stringBuilder.toString();
    }
}

