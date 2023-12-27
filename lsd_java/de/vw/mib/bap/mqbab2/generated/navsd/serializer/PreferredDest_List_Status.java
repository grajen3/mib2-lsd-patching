/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PreferredDest_List_Status
implements StatusProperty {
    public int listType;
    public static final int LIST_TYPE_NO_LIST_PREFERRED_UNDEFINED;
    public static final int LIST_TYPE_LAST_DESTINATIONS_LIST_FCT_0X1D;
    public static final int LIST_TYPE_FAVORITE_DESTINATIONS_LIST_FCT_0X1E;
    public static final int LIST_TYPE_NAV_BOOK_FCT_0X20;

    public PreferredDest_List_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PreferredDest_List_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.listType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PreferredDest_List_Status preferredDest_List_Status = (PreferredDest_List_Status)bAPEntity;
        return this.listType == preferredDest_List_Status.listType;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "PreferredDest_List_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.listType);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 31;
    }

    @Override
    public int getFunctionId() {
        return PreferredDest_List_Status.functionId();
    }
}

