/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.pool.PooledObject;

final class SkinImagePreloader$PreloadRequest
implements PooledObject {
    private long key;
    private int skinId;
    private String filename;
    private int imageId;

    @Override
    public void backToPool() {
        this.filename = null;
    }

    public long getKey() {
        return this.key;
    }

    public void setKey(long l) {
        this.key = l;
    }

    public int getSkinId() {
        return this.skinId;
    }

    public void setSkinId(int n) {
        this.skinId = n;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String string) {
        this.filename = string;
    }

    public int getImageId() {
        return this.imageId;
    }

    public void setImageId(int n) {
        this.imageId = n;
    }
}

