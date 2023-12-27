/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SourceList_Attributes
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean mediumSupportBrowserListDf4_2;
    public boolean noImportRunning;
    public boolean mediumIsNotBeingLoaded;
    public boolean mediumIsReadable;
    public boolean mediaIsPlayable;
    public boolean mediumAudioNoError;
    public boolean builtInAndReadyMediumInserted;

    public SourceList_Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public SourceList_Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.mediumSupportBrowserListDf4_2 = false;
        this.noImportRunning = false;
        this.mediumIsNotBeingLoaded = false;
        this.mediumIsReadable = false;
        this.mediaIsPlayable = false;
        this.mediumAudioNoError = false;
        this.builtInAndReadyMediumInserted = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SourceList_Attributes sourceList_Attributes = (SourceList_Attributes)bAPEntity;
        return this.reserved_bit_7 == sourceList_Attributes.reserved_bit_7 && this.mediumSupportBrowserListDf4_2 == sourceList_Attributes.mediumSupportBrowserListDf4_2 && this.noImportRunning == sourceList_Attributes.noImportRunning && this.mediumIsNotBeingLoaded == sourceList_Attributes.mediumIsNotBeingLoaded && this.mediumIsReadable == sourceList_Attributes.mediumIsReadable && this.mediaIsPlayable == sourceList_Attributes.mediaIsPlayable && this.mediumAudioNoError == sourceList_Attributes.mediumAudioNoError && this.builtInAndReadyMediumInserted == sourceList_Attributes.builtInAndReadyMediumInserted;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SourceList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.mediumSupportBrowserListDf4_2);
        bitStream.pushBoolean(this.noImportRunning);
        bitStream.pushBoolean(this.mediumIsNotBeingLoaded);
        bitStream.pushBoolean(this.mediumIsReadable);
        bitStream.pushBoolean(this.mediaIsPlayable);
        bitStream.pushBoolean(this.mediumAudioNoError);
        bitStream.pushBoolean(this.builtInAndReadyMediumInserted);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_7 = bitStream.popFrontBoolean();
        this.mediumSupportBrowserListDf4_2 = bitStream.popFrontBoolean();
        this.noImportRunning = bitStream.popFrontBoolean();
        this.mediumIsNotBeingLoaded = bitStream.popFrontBoolean();
        this.mediumIsReadable = bitStream.popFrontBoolean();
        this.mediaIsPlayable = bitStream.popFrontBoolean();
        this.mediumAudioNoError = bitStream.popFrontBoolean();
        this.builtInAndReadyMediumInserted = bitStream.popFrontBoolean();
    }
}

