/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveSource_ListAvailable
implements BAPEntity {
    public boolean siriusAlertListAvailableDf4_6;
    public boolean mediaBrowserListAvailable;
    public boolean presetListAvailable;
    public boolean receptionListAvailable;

    public ActiveSource_ListAvailable() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveSource_ListAvailable(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.siriusAlertListAvailableDf4_6 = false;
        this.mediaBrowserListAvailable = false;
        this.presetListAvailable = false;
        this.receptionListAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveSource_ListAvailable activeSource_ListAvailable = (ActiveSource_ListAvailable)bAPEntity;
        return this.siriusAlertListAvailableDf4_6 == activeSource_ListAvailable.siriusAlertListAvailableDf4_6 && this.mediaBrowserListAvailable == activeSource_ListAvailable.mediaBrowserListAvailable && this.presetListAvailable == activeSource_ListAvailable.presetListAvailable && this.receptionListAvailable == activeSource_ListAvailable.receptionListAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ActiveSource_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.siriusAlertListAvailableDf4_6);
        bitStream.pushBoolean(this.mediaBrowserListAvailable);
        bitStream.pushBoolean(this.presetListAvailable);
        bitStream.pushBoolean(this.receptionListAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.siriusAlertListAvailableDf4_6 = bitStream.popFrontBoolean();
        this.mediaBrowserListAvailable = bitStream.popFrontBoolean();
        this.presetListAvailable = bitStream.popFrontBoolean();
        this.receptionListAvailable = bitStream.popFrontBoolean();
    }
}

