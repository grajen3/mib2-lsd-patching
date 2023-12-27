/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.homescreen.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface TileContent
extends Persistable {
    default public String getTileUsageId() {
    }

    default public void setTileUsageId(String string) {
    }

    default public int getTileUsageIndex() {
    }

    default public void setTileUsageIndex(int n) {
    }

    default public long getCioIntentId() {
    }

    default public void setCioIntentId(long l) {
    }
}

