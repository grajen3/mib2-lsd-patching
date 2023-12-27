/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.InfoList_Data$Attributes;
import de.vw.mib.bap.stream.BitStream;

public final class InfoList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_TYPE_ATTRIBUTES_NAME;
    public static final int RECORD_ADDRESS_NAME;
    public static final int RECORD_ADDRESS_TYPE_ATTRIBUTES;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public int type;
    private static final int TYPE_BITSIZE;
    public static final int TYPE_ANY_STRING_UNKNOWN;
    public static final int TYPE_DIRECTORY;
    public static final int TYPE_FILE_NAME;
    public static final int TYPE_STATION_NAME;
    public final InfoList_Data$Attributes attributes;
    public final BAPString name;
    private static final int MAX_NAME_LENGTH;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }

    public InfoList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new InfoList_Data$Attributes();
        this.name = new BAPString(49);
        this.internalReset();
        this.customInitialization();
    }

    public InfoList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.type = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.attributes.reset();
        this.name.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        InfoList_Data infoList_Data = (InfoList_Data)bAPEntity;
        return this.arrayHeader.equalTo(infoList_Data.arrayHeader) && this.pos == infoList_Data.pos && this.type == infoList_Data.type && this.attributes.equalTo(infoList_Data.attributes) && this.name.equalTo(infoList_Data.name);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "InfoList_Data:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushBits(4, this.type);
                this.attributes.serialize(bitStream);
                this.name.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushBits(4, this.type);
                this.attributes.serialize(bitStream);
                break;
            }
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

