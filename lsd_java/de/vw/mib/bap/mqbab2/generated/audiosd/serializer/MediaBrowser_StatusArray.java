/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_Data;
import de.vw.mib.bap.stream.BitStream;

public final class MediaBrowser_StatusArray
implements BAPStatusArray {
    public int asg_Id;
    public static final int ASG_ID_OPERATING_UNIT_REAR_DF4_2;
    public static final int ASG_ID_HEAD_UP_DISPLAY;
    public static final int ASG_ID_INSTRUMENT_CLUSTER;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTAENOUS_FSG_MESSAGE;
    private static final int ASG_ID_BITSIZE;
    public int taid;
    public static final int TAID_MIN;
    private static final int TAID_BITSIZE;
    public int totalNumListElements;
    public static final int TOTAL_NUM_LIST_ELEMENTS_MIN;
    public int activeListPos;
    public static final int ACTIVE_LIST_POS_MIN;
    public ArrayHeader arrayHeader = new ArrayHeader();
    private static final int MAX_DATA_ELEMENTS;
    public BAPArrayData data = new BAPArrayData(-65536, this.arrayHeader);

    @Override
    public BAPArrayElement createArrayElement() {
        return new MediaBrowser_Data(this.getArrayHeader());
    }

    public MediaBrowser_StatusArray() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaBrowser_StatusArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
        this.totalNumListElements = 0;
        this.activeListPos = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaBrowser_StatusArray mediaBrowser_StatusArray = (MediaBrowser_StatusArray)bAPEntity;
        return this.asg_Id == mediaBrowser_StatusArray.asg_Id && this.taid == mediaBrowser_StatusArray.taid && this.totalNumListElements == mediaBrowser_StatusArray.totalNumListElements && this.activeListPos == mediaBrowser_StatusArray.activeListPos && this.arrayHeader.equalTo(mediaBrowser_StatusArray.arrayHeader) && this.data.equalTo(mediaBrowser_StatusArray.data);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MediaBrowser_StatusArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        bitStream.pushShort((short)this.totalNumListElements);
        bitStream.pushShort((short)this.activeListPos);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.totalNumListElements = bitStream.popFrontShort();
        this.activeListPos = bitStream.popFrontShort();
        this.arrayHeader.deserialize(bitStream);
        this.data.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new MediaBrowser_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 36;
    }

    @Override
    public int getFunctionId() {
        return MediaBrowser_StatusArray.functionId();
    }

    @Override
    public void setArrayData(BAPArrayData bAPArrayData) {
        this.data = bAPArrayData;
    }

    @Override
    public BAPArrayData getArrayData() {
        return this.data;
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public int getTransactionId() {
        return this.taid;
    }

    @Override
    public void setTransactionId(int n) {
        this.taid = n;
    }

    @Override
    public int getAsgId() {
        return this.asg_Id & 7;
    }

    @Override
    public void setAsgId(int n) {
        this.asg_Id = this.asg_Id & 8 | n & 7;
    }

    @Override
    public boolean isBroadcast() {
        return this.asg_Id >>> 3 == 1;
    }

    @Override
    public void setBroadcast(boolean bl) {
        this.asg_Id = bl ? this.asg_Id | 8 : this.asg_Id & 7;
    }

    @Override
    public int getNumberOfElements() {
        return this.totalNumListElements;
    }

    @Override
    public void setNumberOfElements(int n) {
        this.totalNumListElements = n;
    }
}

