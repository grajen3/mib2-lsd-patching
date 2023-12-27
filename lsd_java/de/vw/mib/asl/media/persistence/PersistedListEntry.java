/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface PersistedListEntry
extends Persistable {
    default public long getEntryID() {
    }

    default public void setEntryID(long l) {
    }

    default public String getFilename() {
    }

    default public void setFilename(String string) {
    }

    default public int getContentType() {
    }

    default public void setContentType(int n) {
    }
}

