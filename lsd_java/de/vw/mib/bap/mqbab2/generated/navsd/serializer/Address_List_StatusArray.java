/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Address_List_Data;
import de.vw.mib.bap.stream.BitStream;

public final class Address_List_StatusArray
implements BAPStatusArray {
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
    public int totalNumListElements;
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData data = new BAPArrayData(-16842752);
    private static final int MAX_DATA_ELEMENTS;

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
    public int getTransactionId() {
        return this.taid;
    }

    @Override
    public void setTransactionId(int n) {
        this.taid = n;
    }

    @Override
    public int getNumberOfElements() {
        return this.totalNumListElements;
    }

    @Override
    public void setNumberOfElements(int n) {
        this.totalNumListElements = n;
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
    public void setArrayData(BAPArrayData bAPArrayData) {
        this.data = bAPArrayData;
    }

    @Override
    public BAPArrayData getArrayData() {
        return this.data;
    }

    @Override
    public BAPArrayElement createArrayElement() {
        return new Address_List_Data(this.getArrayHeader());
    }

    public Address_List_StatusArray() {
        this.internalReset();
        this.customInitialization();
    }

    public Address_List_StatusArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
        this.otherListType = 0;
        this.otherList_Reference = 0;
        this.totalNumListElements = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Address_List_StatusArray address_List_StatusArray = (Address_List_StatusArray)bAPEntity;
        return this.asg_Id == address_List_StatusArray.asg_Id && this.taid == address_List_StatusArray.taid && this.otherListType == address_List_StatusArray.otherListType && this.otherList_Reference == address_List_StatusArray.otherList_Reference && this.totalNumListElements == address_List_StatusArray.totalNumListElements && this.arrayHeader.equalTo(address_List_StatusArray.arrayHeader) && this.data.equalTo(address_List_StatusArray.data);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Address_List_StatusArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        bitStream.pushByte((byte)this.otherListType);
        bitStream.pushShort((short)this.otherList_Reference);
        bitStream.pushShort((short)this.totalNumListElements);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 33;
    }

    @Override
    public int getFunctionId() {
        return Address_List_StatusArray.functionId();
    }
}

