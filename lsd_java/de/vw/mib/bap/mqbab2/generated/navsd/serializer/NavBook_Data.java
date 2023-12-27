/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class NavBook_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_LAST_NAME_FIRST_NAME;
    public static final int RECORD_ADDRESS_LAST_NAME;
    public static final int RECORD_ADDRESS_FIRST_NAME;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public final BAPString lastName;
    private static final int MAX_LAST_NAME_LENGTH;
    public final BAPString firstName;
    private static final int MAX_FIRST_NAME_LENGTH;

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

    public NavBook_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.lastName = new BAPString(61);
        this.firstName = new BAPString(61);
        this.internalReset();
        this.customInitialization();
    }

    public NavBook_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.lastName.reset();
        this.firstName.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        NavBook_Data navBook_Data = (NavBook_Data)bAPEntity;
        return this.arrayHeader.equalTo(navBook_Data.arrayHeader) && this.pos == navBook_Data.pos && this.lastName.equalTo(navBook_Data.lastName) && this.firstName.equalTo(navBook_Data.firstName);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "NavBook_Data:";
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
                this.lastName.serialize(bitStream);
                this.firstName.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.lastName.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.firstName.serialize(bitStream);
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

