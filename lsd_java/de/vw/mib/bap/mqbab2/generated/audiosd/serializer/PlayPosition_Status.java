/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.PlayPosition_Attributes;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PlayPosition_Status
implements StatusProperty {
    public int timePosition;
    public static final int TIME_POSITION_MIN;
    public int totalPlayTime;
    public static final int TOTAL_PLAY_TIME_MIN;
    public PlayPosition_Attributes attributes = new PlayPosition_Attributes();
    public int bufferLevel;
    public static final int BUFFER_LEVEL_MIN;

    public PlayPosition_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PlayPosition_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.timePosition = 0;
        this.totalPlayTime = 0;
        this.bufferLevel = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.attributes.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PlayPosition_Status playPosition_Status = (PlayPosition_Status)bAPEntity;
        return this.timePosition == playPosition_Status.timePosition && this.totalPlayTime == playPosition_Status.totalPlayTime && this.attributes.equalTo(playPosition_Status.attributes) && this.bufferLevel == playPosition_Status.bufferLevel;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "PlayPosition_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.timePosition);
        bitStream.pushShort((short)this.totalPlayTime);
        this.attributes.serialize(bitStream);
        bitStream.pushByte((byte)this.bufferLevel);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.timePosition = bitStream.popFrontShort();
        this.totalPlayTime = bitStream.popFrontShort();
        this.attributes.deserialize(bitStream);
        this.bufferLevel = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 52;
    }

    @Override
    public int getFunctionId() {
        return PlayPosition_Status.functionId();
    }
}

