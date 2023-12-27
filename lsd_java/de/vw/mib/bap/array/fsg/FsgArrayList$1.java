/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.array.fsg.FsgArrayObjectId;

final class FsgArrayList$1
implements FsgArrayObjectId {
    FsgArrayList$1() {
    }

    @Override
    public int getPosIndex() {
        return -1;
    }

    @Override
    public long getEntryId() {
        return -1L;
    }

    public boolean equals(Object object) {
        FsgArrayObjectId fsgArrayObjectId = (FsgArrayObjectId)object;
        return fsgArrayObjectId != null && fsgArrayObjectId.getEntryId() == this.getEntryId();
    }

    public int hashCode() {
        return (int)this.getEntryId();
    }

    @Override
    public int getInternalUserId() {
        return 0;
    }
}

