/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.Insets;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class ScaleImage
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    public static final int SCALEMODE_NOSCALE_CENTER;
    public static final int SCALEMODE_INTERPOLATE;
    public static final int SCALEMODE_SCALE9_STRETCH;
    public static final int SCALEMODE_SCALE9_REPEAT;
    public static final int SCALEMODE_NOSCALE_CROP;
    public static final int SCALEMODE_POSITIONAL_CROP_HORIZONTAL;
    public static final int SCALEMODE_NOSCALE_CROP_TOP_OR_LEFT;
    public static final int IMAGETYPE_SKIN;
    public static final int IMAGETYPE_COMMON_SKIN;
    public static final int IMAGETYPE_COMMON_SKIN_CAR_SPECIFIC;
    public static final String INVALID_FILE_IDENTIFIER;
    public static final int INVALID_IMAGE_ID;
    private int imageId;
    private int imageId2;
    private String fileIdentifier;
    private String fileIdentifier2;
    private Insets insets;
    private byte scaleMode;
    private byte imageType;

    public ScaleImage() {
        this("", -1, new Insets(), 0, 0);
    }

    public ScaleImage(String string, Insets insets, int n) {
        this(string, insets, n, 0);
    }

    public ScaleImage(String string, Insets insets, int n, int n2) {
        this(string, -1, insets, n, n2);
    }

    public ScaleImage(int n, Insets insets, int n2) {
        this(n, insets, n2, 0);
    }

    public ScaleImage(int n, Insets insets, int n2, int n3) {
        this("", n, insets, n2, n3);
    }

    public ScaleImage(String string, int n, Insets insets, int n2, int n3) {
        this(string, "", n, -1, insets, n2, n3);
    }

    public ScaleImage(String string, int n, Insets insets, int n2) {
        this(string, "", n, -1, insets, n2, 0);
    }

    public ScaleImage(String string, String string2, Insets insets, int n, int n2) {
        this(string, string2, -1, -1, insets, n, n2);
    }

    public ScaleImage(int n, int n2, Insets insets, int n3) {
        this("", "", n, n2, insets, n3, 0);
    }

    public ScaleImage(int n, int n2, Insets insets, int n3, int n4) {
        this("", "", n, n2, insets, n3, n4);
    }

    public ScaleImage(String string, String string2, int n, int n2, Insets insets, int n3) {
        this(string, string2, n, n2, insets, n3, 0);
    }

    public ScaleImage(String string, String string2, int n, int n2, Insets insets, int n3, int n4) {
        this.fileIdentifier = string;
        this.fileIdentifier2 = string2;
        this.imageId = n;
        this.imageId2 = n2;
        this.insets = insets;
        this.scaleMode = (byte)n3;
        this.imageType = (byte)n4;
    }

    public Object clone() {
        try {
            ScaleImage scaleImage = (ScaleImage)super.clone();
            scaleImage.insets = (Insets)this.insets.clone();
            return scaleImage;
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
        if (this.fileIdentifier != null) {
            hcb.append(this.fileIdentifier);
        } else {
            hcb.append(this.imageId);
        }
        if (this.fileIdentifier2 != null) {
            hcb.append(this.fileIdentifier2);
        } else {
            hcb.append(this.imageId2);
        }
        hcb.append(this.insets);
        hcb.append(this.scaleMode);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            ScaleImage scaleImage = (ScaleImage)object;
            return this.imageId == scaleImage.imageId && this.imageId2 == scaleImage.imageId2 && this.fileIdentifier.equals(scaleImage.fileIdentifier) && this.fileIdentifier2.equals(scaleImage.fileIdentifier2) && this.insets.equals(scaleImage.insets) && this.scaleMode == scaleImage.scaleMode && this.imageType == scaleImage.imageType;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[imageId=").append(this.imageId);
        stringBuilder.append(",imageId2=").append(this.imageId2);
        stringBuilder.append(",fileIdentifier=\"").append(this.fileIdentifier).append("\"");
        stringBuilder.append(",fileIdentifier2=\"").append(this.fileIdentifier2).append("\"");
        stringBuilder.append(",insets=").append(this.insets);
        stringBuilder.append(",scaleMode=").append(this.scaleMode);
        stringBuilder.append(",imageType=").append(this.imageType);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean hasFileIdentifier() {
        return !"".equals(this.fileIdentifier);
    }

    public boolean hasFileIdentifier2() {
        return !"".equals(this.fileIdentifier2);
    }

    public boolean isEmpty() {
        return this.getImageId() == -1 && !this.hasFileIdentifier();
    }

    public boolean hasSecondaryLayer() {
        return this.getImageId2() != -1 || this.hasFileIdentifier2();
    }

    public int getImageId() {
        return this.imageId;
    }

    public int getImageId2() {
        return this.imageId2;
    }

    public void setImageId(int n) {
        this.imageId = n;
    }

    public void setImageId2(int n) {
        this.imageId2 = n;
    }

    public String getFileIdentifier() {
        return this.fileIdentifier;
    }

    public void setFileIdentifier(String string) {
        this.fileIdentifier = string;
    }

    public String getFileIdentifier2() {
        return this.fileIdentifier2;
    }

    public void setFileIdentifier2(String string) {
        this.fileIdentifier2 = string;
    }

    public Insets getInsets() {
        return this.insets;
    }

    public void setInsets(Insets insets) {
        this.insets = insets;
    }

    public int getScaleMode() {
        return this.scaleMode;
    }

    public void setScaleMode(int n) {
        this.scaleMode = (byte)n;
    }

    public int getImageType() {
        return this.imageType;
    }

    public void setImageType(int n) {
        this.imageType = (byte)n;
    }
}

