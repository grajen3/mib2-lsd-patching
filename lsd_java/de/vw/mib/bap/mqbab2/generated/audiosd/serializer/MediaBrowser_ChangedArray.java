/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_Data;
import de.vw.mib.bap.stream.BitStream;

public final class MediaBrowser_ChangedArray
implements BAPChangedArray {
    public ArrayHeader arrayHeader = new ArrayHeader();
    private static final int MAX_DATA_ELEMENTS;
    public BAPArrayData data = new BAPArrayData(-65536, this.arrayHeader);

    @Override
    public BAPArrayElement createArrayElement() {
        return new MediaBrowser_Data(this.getArrayHeader());
    }

    public MediaBrowser_ChangedArray() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaBrowser_ChangedArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaBrowser_ChangedArray mediaBrowser_ChangedArray = (MediaBrowser_ChangedArray)bAPEntity;
        return this.arrayHeader.equalTo(mediaBrowser_ChangedArray.arrayHeader) && this.data.equalTo(mediaBrowser_ChangedArray.data);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MediaBrowser_ChangedArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.arrayHeader.deserialize(bitStream);
        this.arrayHeader.evaluateRecordAddressPosForChangedArray();
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
        return MediaBrowser_ChangedArray.functionId();
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
}

