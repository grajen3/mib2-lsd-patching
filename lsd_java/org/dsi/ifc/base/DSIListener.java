/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.base;

public interface DSIListener {
    public static final int RT_NONE;
    public static final int ATTRVALIDFLAG_UNKNOWN;
    public static final int ATTRVALIDFLAG_VALID;
    public static final int ATTRVALIDFLAG_INVALID;

    default public void asyncException(int n, String string, int n2) {
    }
}

