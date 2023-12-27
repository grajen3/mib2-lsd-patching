/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;

public class sTileInfo {
    public long id;
    public long version;
    public int expiration;
    public sBoundingBox boundingBox;

    public long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public long getVersion() {
        return this.version;
    }

    public void setVersion(long l) {
        this.version = l;
    }

    public int getExpiration() {
        return this.expiration;
    }

    public void setExpiration(int n) {
        this.expiration = n;
    }

    public sBoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public void setBoundingBox(sBoundingBox sBoundingBox2) {
        this.boundingBox = sBoundingBox2;
    }

    public sTileInfo() {
        this.boundingBox = null;
    }

    public sTileInfo(long l, long l2, int n, sBoundingBox sBoundingBox2) {
        this.id = l;
        this.version = l2;
        this.expiration = n;
        this.boundingBox = sBoundingBox2;
    }

    public String toString() {
        return new StringBuffer("sTileInfo{").append("id=").append(this.id).append(", version=").append(this.version).append(", expiration=").append(this.expiration).append(", boundingBox=").append(this.boundingBox).append("}").toString();
    }
}

