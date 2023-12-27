/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class Image
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private static int currentMode;
    private ScaleImage dayImage;
    private ScaleImage nightImage;

    public Image() {
        this(new ScaleImage());
    }

    public Image(ScaleImage scaleImage) {
        this(scaleImage, scaleImage);
    }

    public Image(ScaleImage scaleImage, ScaleImage scaleImage2) {
        this.dayImage = scaleImage;
        this.nightImage = scaleImage2;
    }

    public Image(Image image) {
        this.dayImage = image.dayImage;
        this.nightImage = image.nightImage;
    }

    public Object clone() {
        try {
            Image image = (Image)super.clone();
            image.dayImage = (ScaleImage)this.dayImage.clone();
            image.nightImage = (ScaleImage)this.nightImage.clone();
            return image;
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
        hcb.append(this.dayImage);
        hcb.append(this.nightImage);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Image image = (Image)object;
            return this.dayImage.equals(image.dayImage) && this.nightImage.equals(image.nightImage);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[dayImage=").append(this.dayImage);
        stringBuilder.append(",nightImage=").append(this.nightImage);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public ScaleImage getDayImage() {
        return this.dayImage;
    }

    public ScaleImage getNightImage() {
        return this.nightImage;
    }

    public ScaleImage getCurrentImage() {
        switch (currentMode) {
            case 0: {
                return this.getDayImage();
            }
            case 1: {
                return this.getNightImage();
            }
        }
        throw new IllegalArgumentException("Invalid day/night mode");
    }

    public static void setDayNightMode(int n) {
        currentMode = n;
    }

    static {
        currentMode = 0;
    }
}

