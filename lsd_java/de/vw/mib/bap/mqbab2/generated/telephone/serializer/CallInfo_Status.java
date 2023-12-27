/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CallInfo_Status
implements StatusProperty {
    public final BAPString pbName0 = new BAPString(100);
    private static final int MAX_PB_NAME0_LENGTH;
    public final BAPString telNumber0 = new BAPString(41);
    private static final int MAX_TEL_NUMBER0_LENGTH;
    public int category0;
    public static final int CATEGORY0_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY0_GENERAL;
    public static final int CATEGORY0_MOBILE;
    public static final int CATEGORY0_OFFICE;
    public static final int CATEGORY0_HOME;
    public static final int CATEGORY0_FAX;
    public static final int CATEGORY0_PAGER;
    public static final int CATEGORY0_CAR;
    public static final int CATEGORY0_SIM;
    public static final int CATEGORY0_MAIN_OFFICE;
    public static final int CATEGORY0_MAIN_HOME;
    public static final int CATEGORY0_CELL_OFFICE;
    public static final int CATEGORY0_CELL_HOME;
    public static final int CATEGORY0_FAX_OFFICE;
    public static final int CATEGORY0_FAX_HOME;
    public final BAPString pbName1 = new BAPString(100);
    private static final int MAX_PB_NAME1_LENGTH;
    public final BAPString telNumber1 = new BAPString(41);
    private static final int MAX_TEL_NUMBER1_LENGTH;
    public int category1;
    public static final int CATEGORY1_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY1_GENERAL;
    public static final int CATEGORY1_MOBILE;
    public static final int CATEGORY1_OFFICE;
    public static final int CATEGORY1_HOME;
    public static final int CATEGORY1_FAX;
    public static final int CATEGORY1_PAGER;
    public static final int CATEGORY1_CAR;
    public static final int CATEGORY1_SIM;
    public static final int CATEGORY1_MAIN_OFFICE;
    public static final int CATEGORY1_MAIN_HOME;
    public static final int CATEGORY1_CELL_OFFICE;
    public static final int CATEGORY1_CELL_HOME;
    public static final int CATEGORY1_FAX_OFFICE;
    public static final int CATEGORY1_FAX_HOME;
    public final BAPString pbName2 = new BAPString(100);
    private static final int MAX_PB_NAME2_LENGTH;
    public final BAPString telNumber2 = new BAPString(41);
    private static final int MAX_TEL_NUMBER2_LENGTH;
    public int category2;
    public static final int CATEGORY2_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY2_GENERAL;
    public static final int CATEGORY2_MOBILE;
    public static final int CATEGORY2_OFFICE;
    public static final int CATEGORY2_HOME;
    public static final int CATEGORY2_FAX;
    public static final int CATEGORY2_PAGER;
    public static final int CATEGORY2_CAR;
    public static final int CATEGORY2_SIM;
    public static final int CATEGORY2_MAIN_OFFICE;
    public static final int CATEGORY2_MAIN_HOME;
    public static final int CATEGORY2_CELL_OFFICE;
    public static final int CATEGORY2_CELL_HOME;
    public static final int CATEGORY2_FAX_OFFICE;
    public static final int CATEGORY2_FAX_HOME;
    public final BAPString pbName3 = new BAPString(100);
    private static final int MAX_PB_NAME3_LENGTH;
    public final BAPString telNumber3 = new BAPString(41);
    private static final int MAX_TEL_NUMBER3_LENGTH;
    public int category3;
    public static final int CATEGORY3_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY3_GENERAL;
    public static final int CATEGORY3_MOBILE;
    public static final int CATEGORY3_OFFICE;
    public static final int CATEGORY3_HOME;
    public static final int CATEGORY3_FAX;
    public static final int CATEGORY3_PAGER;
    public static final int CATEGORY3_CAR;
    public static final int CATEGORY3_SIM;
    public static final int CATEGORY3_MAIN_OFFICE;
    public static final int CATEGORY3_MAIN_HOME;
    public static final int CATEGORY3_CELL_OFFICE;
    public static final int CATEGORY3_CELL_HOME;
    public static final int CATEGORY3_FAX_OFFICE;
    public static final int CATEGORY3_FAX_HOME;
    public final BAPString pbName4 = new BAPString(100);
    private static final int MAX_PB_NAME4_LENGTH;
    public final BAPString telNumber4 = new BAPString(41);
    private static final int MAX_TEL_NUMBER4_LENGTH;
    public int category4;
    public static final int CATEGORY4_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY4_GENERAL;
    public static final int CATEGORY4_MOBILE;
    public static final int CATEGORY4_OFFICE;
    public static final int CATEGORY4_HOME;
    public static final int CATEGORY4_FAX;
    public static final int CATEGORY4_PAGER;
    public static final int CATEGORY4_CAR;
    public static final int CATEGORY4_SIM;
    public static final int CATEGORY4_MAIN_OFFICE;
    public static final int CATEGORY4_MAIN_HOME;
    public static final int CATEGORY4_CELL_OFFICE;
    public static final int CATEGORY4_CELL_HOME;
    public static final int CATEGORY4_FAX_OFFICE;
    public static final int CATEGORY4_FAX_HOME;
    public final BAPString pbName5 = new BAPString(100);
    private static final int MAX_PB_NAME5_LENGTH;
    public final BAPString telNumber5 = new BAPString(41);
    private static final int MAX_TEL_NUMBER5_LENGTH;
    public int category5;
    public static final int CATEGORY5_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY5_GENERAL;
    public static final int CATEGORY5_MOBILE;
    public static final int CATEGORY5_OFFICE;
    public static final int CATEGORY5_HOME;
    public static final int CATEGORY5_FAX;
    public static final int CATEGORY5_PAGER;
    public static final int CATEGORY5_CAR;
    public static final int CATEGORY5_SIM;
    public static final int CATEGORY5_MAIN_OFFICE;
    public static final int CATEGORY5_MAIN_HOME;
    public static final int CATEGORY5_CELL_OFFICE;
    public static final int CATEGORY5_CELL_HOME;
    public static final int CATEGORY5_FAX_OFFICE;
    public static final int CATEGORY5_FAX_HOME;
    public final BAPString pbName6 = new BAPString(100);
    private static final int MAX_PB_NAME6_LENGTH;
    public final BAPString telNumber6 = new BAPString(41);
    private static final int MAX_TEL_NUMBER6_LENGTH;
    public int category6;
    public static final int CATEGORY6_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY6_GENERAL;
    public static final int CATEGORY6_MOBILE;
    public static final int CATEGORY6_OFFICE;
    public static final int CATEGORY6_HOME;
    public static final int CATEGORY6_FAX;
    public static final int CATEGORY6_PAGER;
    public static final int CATEGORY6_CAR;
    public static final int CATEGORY6_SIM;
    public static final int CATEGORY6_MAIN_OFFICE;
    public static final int CATEGORY6_MAIN_HOME;
    public static final int CATEGORY6_CELL_OFFICE;
    public static final int CATEGORY6_CELL_HOME;
    public static final int CATEGORY6_FAX_OFFICE;
    public static final int CATEGORY6_FAX_HOME;

    public CallInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CallInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.category0 = 0;
        this.category1 = 0;
        this.category2 = 0;
        this.category3 = 0;
        this.category4 = 0;
        this.category5 = 0;
        this.category6 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.pbName0.reset();
        this.telNumber0.reset();
        this.pbName1.reset();
        this.telNumber1.reset();
        this.pbName2.reset();
        this.telNumber2.reset();
        this.pbName3.reset();
        this.telNumber3.reset();
        this.pbName4.reset();
        this.telNumber4.reset();
        this.pbName5.reset();
        this.telNumber5.reset();
        this.pbName6.reset();
        this.telNumber6.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallInfo_Status callInfo_Status = (CallInfo_Status)bAPEntity;
        return this.pbName0.equalTo(callInfo_Status.pbName0) && this.telNumber0.equalTo(callInfo_Status.telNumber0) && this.category0 == callInfo_Status.category0 && this.pbName1.equalTo(callInfo_Status.pbName1) && this.telNumber1.equalTo(callInfo_Status.telNumber1) && this.category1 == callInfo_Status.category1 && this.pbName2.equalTo(callInfo_Status.pbName2) && this.telNumber2.equalTo(callInfo_Status.telNumber2) && this.category2 == callInfo_Status.category2 && this.pbName3.equalTo(callInfo_Status.pbName3) && this.telNumber3.equalTo(callInfo_Status.telNumber3) && this.category3 == callInfo_Status.category3 && this.pbName4.equalTo(callInfo_Status.pbName4) && this.telNumber4.equalTo(callInfo_Status.telNumber4) && this.category4 == callInfo_Status.category4 && this.pbName5.equalTo(callInfo_Status.pbName5) && this.telNumber5.equalTo(callInfo_Status.telNumber5) && this.category5 == callInfo_Status.category5 && this.pbName6.equalTo(callInfo_Status.pbName6) && this.telNumber6.equalTo(callInfo_Status.telNumber6) && this.category6 == callInfo_Status.category6;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CallInfo_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.pbName0.serialize(bitStream);
        this.telNumber0.serialize(bitStream);
        bitStream.pushByte((byte)this.category0);
        this.pbName1.serialize(bitStream);
        this.telNumber1.serialize(bitStream);
        bitStream.pushByte((byte)this.category1);
        this.pbName2.serialize(bitStream);
        this.telNumber2.serialize(bitStream);
        bitStream.pushByte((byte)this.category2);
        this.pbName3.serialize(bitStream);
        this.telNumber3.serialize(bitStream);
        bitStream.pushByte((byte)this.category3);
        this.pbName4.serialize(bitStream);
        this.telNumber4.serialize(bitStream);
        bitStream.pushByte((byte)this.category4);
        this.pbName5.serialize(bitStream);
        this.telNumber5.serialize(bitStream);
        bitStream.pushByte((byte)this.category5);
        this.pbName6.serialize(bitStream);
        this.telNumber6.serialize(bitStream);
        bitStream.pushByte((byte)this.category6);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 23;
    }

    @Override
    public int getFunctionId() {
        return CallInfo_Status.functionId();
    }
}

