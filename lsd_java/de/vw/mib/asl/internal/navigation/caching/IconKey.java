/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.caching;

import de.vw.mib.asl.internal.navigation.caching.CacheClient;

public class IconKey {
    public final int type;
    public final int k0;
    public final int k1;
    public final int k2;
    public final int k3;
    protected CacheClient client;
    protected Object arg;

    public boolean equals(Object object) {
        if (object instanceof IconKey) {
            return ((IconKey)object).type == this.type && ((IconKey)object).k0 == this.k0 && ((IconKey)object).k1 == this.k1 && ((IconKey)object).k2 == this.k2 && ((IconKey)object).k3 == this.k3;
        }
        return false;
    }

    public int hashCode() {
        return this.type ^ this.k0 << 4 ^ this.k1 << 8 ^ this.k2 << 12 ^ this.k3 << 16;
    }

    public int getType() {
        return this.type;
    }

    public int getK0() {
        return this.k0;
    }

    public int getK1() {
        return this.k1;
    }

    public int getK2() {
        return this.k2;
    }

    public int getK3() {
        return this.k3;
    }

    public CacheClient getC() {
        return this.client;
    }

    public Object getArg() {
        return this.arg;
    }

    public IconKey(int n, int n2, int n3, int n4, int n5, CacheClient cacheClient, Object object) {
        this.type = n;
        this.k0 = n2;
        this.k1 = n3;
        this.k2 = n4;
        this.k3 = n5;
        this.client = cacheClient;
        this.arg = object;
    }

    public IconKey(int n, int n2, int n3, int n4, CacheClient cacheClient, Object object) {
        this.type = n;
        this.k0 = n2;
        this.k1 = n3;
        this.k2 = n4;
        this.k3 = -1;
        this.client = cacheClient;
        this.arg = object;
    }

    public IconKey(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        this.type = n;
        this.k0 = n2;
        this.k1 = n3;
        this.k2 = -1;
        this.k3 = -1;
        this.client = cacheClient;
        this.arg = object;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.type == 2001) {
            stringBuffer.append("IconKey(POI)[Type=").append(this.type).append(" ");
            stringBuffer.append("catNumber/iconIndex=").append(this.k0).append(" ");
            stringBuffer.append("subIndex=").append(this.k1).append(" ");
            stringBuffer.append("iconSize=").append(this.k2).append("]");
            return stringBuffer.toString();
        }
        stringBuffer.append("IconKey[Type=").append(this.type).append(" ");
        stringBuffer.append("k0=").append(this.k0).append(" ");
        stringBuffer.append("k1=").append(this.k1).append(" ");
        stringBuffer.append("k2=").append(this.k2).append(" ");
        stringBuffer.append("k3=").append(this.k3).append("]");
        return stringBuffer.toString();
    }
}

