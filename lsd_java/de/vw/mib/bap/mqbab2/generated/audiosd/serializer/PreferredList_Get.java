/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class PreferredList_Get
implements BAPEntity {
    public int list;
    public static final int LIST_NO_LIST_PREFERRED;
    public static final int LIST_RECEPTION_LIST_MEDIA_BROWSER_PREFERRED;
    public static final int LIST_PRESET_LIST_PREFERRED;
    public static final int LIST_COMMON_LIST_PREFERRED_DF4_1;

    public PreferredList_Get() {
        this.internalReset();
        this.customInitialization();
    }

    public PreferredList_Get(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.list = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PreferredList_Get preferredList_Get = (PreferredList_Get)bAPEntity;
        return this.list == preferredList_Get.list;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "PreferredList_Get:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.list = bitStream.popFrontByte();
    }
}

