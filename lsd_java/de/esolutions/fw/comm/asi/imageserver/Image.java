/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver;

import de.esolutions.fw.comm.asi.imageserver.ImageInfo;

public class Image {
    public ImageInfo info;
    public boolean converted;
    public byte[] data;
    public int dataSize;

    public ImageInfo getInfo() {
        return this.info;
    }

    public void setInfo(ImageInfo imageInfo) {
        this.info = imageInfo;
    }

    public boolean isConverted() {
        return this.converted;
    }

    public void setConverted(boolean bl) {
        this.converted = bl;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] byArray) {
        this.data = byArray;
    }

    public int getDataSize() {
        return this.dataSize;
    }

    public void setDataSize(int n) {
        this.dataSize = n;
    }

    public Image() {
        this.info = null;
    }

    public Image(ImageInfo imageInfo, boolean bl, byte[] byArray, int n) {
        this.info = imageInfo;
        this.converted = bl;
        this.data = byArray;
        this.dataSize = n;
    }

    public String toString() {
        return new StringBuffer("Image{").append("info=").append(this.info).append(", converted=").append(this.converted).append(", data=").append("[").append(this.data == null ? "null" : new StringBuffer().append("size=").append(this.data.length).toString()).append("]").append(", dataSize=").append(this.dataSize).append("}").toString();
    }
}

