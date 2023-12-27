/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SourceList_Data$Attributes
implements BAPEntity {
    private static final int RESERVED_BIT_6__7_BITSIZE;
    public boolean noImportRunning;
    public boolean mediumIsNotBeingLoaded;
    public boolean mediumIsReadable;
    public boolean mediaIsPlayable;
    public boolean mediumAudioNoError;
    public boolean builtInAndReady;

    public SourceList_Data$Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public SourceList_Data$Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.noImportRunning = false;
        this.mediumIsNotBeingLoaded = false;
        this.mediumIsReadable = false;
        this.mediaIsPlayable = false;
        this.mediumAudioNoError = false;
        this.builtInAndReady = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SourceList_Data$Attributes sourceList_Data$Attributes = (SourceList_Data$Attributes)bAPEntity;
        return this.noImportRunning == sourceList_Data$Attributes.noImportRunning && this.mediumIsNotBeingLoaded == sourceList_Data$Attributes.mediumIsNotBeingLoaded && this.mediumIsReadable == sourceList_Data$Attributes.mediumIsReadable && this.mediaIsPlayable == sourceList_Data$Attributes.mediaIsPlayable && this.mediumAudioNoError == sourceList_Data$Attributes.mediumAudioNoError && this.builtInAndReady == sourceList_Data$Attributes.builtInAndReady;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Attributes:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(2);
        bitStream.pushBoolean(this.noImportRunning);
        bitStream.pushBoolean(this.mediumIsNotBeingLoaded);
        bitStream.pushBoolean(this.mediumIsReadable);
        bitStream.pushBoolean(this.mediaIsPlayable);
        bitStream.pushBoolean(this.mediumAudioNoError);
        bitStream.pushBoolean(this.builtInAndReady);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

