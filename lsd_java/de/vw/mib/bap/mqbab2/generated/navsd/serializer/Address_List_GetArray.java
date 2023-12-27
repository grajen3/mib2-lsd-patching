/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Address_List_GetArray
implements BAPGetArray {
    public int asg_Id;
    private static final int ASG_ID_BITSIZE;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTANEOUS_FSG_MESSAGE;
    public static final int ASG_ID_INSTRUMENT_CLUSTER;
    public static final int ASG_ID_HEAD_UP_DISPLAY;
    public static final int ASG_ID_OPERATING_UNIT_REAR_DF4_2;
    public static final int ASG_ID_INSTRUMENT_CLUSTER_TO_BE_EVALUATED_BY_ALL_ASGS;
    public static final int ASG_ID_HEAD_UP_DISPLAY_TO_BE_EVALUATED_BY_ALL_ASGS;
    public static final int ASG_ID_OPERATING_UNIT_REAR_TO_BE_EVALUATED_BY_ALL_ASGS;
    public int taid;
    private static final int TAID_BITSIZE;
    public int otherListType;
    public static final int OTHER_LIST_TYPE_LAST_DESTINATIONS_LIST_FUNCTION_0X1D;
    public static final int OTHER_LIST_TYPE_FAVORITE_DESTINATIONS_LIST_FUNCTION_0X1E;
    public static final int OTHER_LIST_TYPE_NAV_BOOK_FUNCTION_0X20;
    public static final int OTHER_LIST_TYPE_PHONE_BOOK_BAP_FUNCTION_CATALOGUE_PHONE;
    public static final int OTHER_LIST_TYPE_HOME_ADDRESS_DF4_1;
    public static final int OTHER_LIST_TYPE_COMPLETE_LIST_DF4_1;
    public int otherList_Reference;
    private ArrayHeader arrayHeader = new ArrayHeader();

    @Override
    public int getAsgId() {
        return this.asg_Id & 7;
    }

    @Override
    public void setAsgId(int n) {
        this.asg_Id = this.asg_Id & 8 | n & 7;
    }

    public boolean isBroadcast() {
        return this.asg_Id >>> 3 == 1;
    }

    public void setBroadcast(boolean bl) {
        this.asg_Id = bl ? this.asg_Id | 8 : this.asg_Id & 7;
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
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public Address_List_GetArray() {
        this.internalReset();
        this.customInitialization();
    }

    public Address_List_GetArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
        this.otherListType = 0;
        this.otherList_Reference = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Address_List_GetArray address_List_GetArray = (Address_List_GetArray)bAPEntity;
        return this.asg_Id == address_List_GetArray.asg_Id && this.taid == address_List_GetArray.taid && this.otherListType == address_List_GetArray.otherListType && this.otherList_Reference == address_List_GetArray.otherList_Reference && this.arrayHeader.equalTo(address_List_GetArray.arrayHeader);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Address_List_GetArray:";
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
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.otherListType = bitStream.popFrontByte();
        this.otherList_Reference = bitStream.popFrontShort();
        this.arrayHeader.deserialize(bitStream);
    }

    public static int functionId() {
        return 33;
    }

    @Override
    public int getFunctionId() {
        return Address_List_GetArray.functionId();
    }
}

