/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver;

public class ImageInfo {
    public int type;
    public int width;
    public int height;
    public long hash;
    public long fileSize;

    public int getType() {
        return this.type;
    }

    public void setType(int n) {
        this.type = n;
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

    public long getHash() {
        return this.hash;
    }

    public void setHash(long l) {
        this.hash = l;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long l) {
        this.fileSize = l;
    }

    public ImageInfo() {
    }

    public ImageInfo(int n, int n2, int n3, long l, long l2) {
        this.type = n;
        this.width = n2;
        this.height = n3;
        this.hash = l;
        this.fileSize = l2;
    }

    public String toString() {
        return new StringBuffer("ImageInfo{").append("type=").append(this.type).append(", width=").append(this.width).append(", height=").append(this.height).append(", hash=").append(this.hash).append(", fileSize=").append(this.fileSize).append("}").toString();
    }
}

