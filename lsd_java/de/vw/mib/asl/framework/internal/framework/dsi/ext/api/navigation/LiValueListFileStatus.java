/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.navigation;

public final class LiValueListFileStatus {
    private final int status;
    private final int type;
    private final String liValueListFilename;

    public LiValueListFileStatus(Object[] objectArray) {
        this.status = (Integer)objectArray[0];
        this.type = (Integer)objectArray[1];
        this.liValueListFilename = (String)objectArray[2];
    }

    public int getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public String getLiValueListFilename() {
        return this.liValueListFilename;
    }
}

