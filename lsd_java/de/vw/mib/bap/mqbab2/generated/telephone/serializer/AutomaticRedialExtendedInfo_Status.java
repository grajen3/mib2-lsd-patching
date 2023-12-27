/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class AutomaticRedialExtendedInfo_Status
implements StatusProperty {
    public int redial_TimeStamp;
    public final BAPString pbName = new BAPString(100);
    private static final int MAX_PB_NAME_LENGTH;
    public final BAPString telNumber = new BAPString(41);
    private static final int MAX_TEL_NUMBER_LENGTH;
    public int category;
    public static final int CATEGORY_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY_GENERAL;
    public static final int CATEGORY_MOBILE;
    public static final int CATEGORY_OFFICE;
    public static final int CATEGORY_HOME;
    public static final int CATEGORY_FAX;
    public static final int CATEGORY_PAGER;
    public static final int CATEGORY_CAR;
    public static final int CATEGORY_SIM;
    public static final int CATEGORY_MAIN_OFFICE;
    public static final int CATEGORY_MAIN_HOME;
    public static final int CATEGORY_CELL_OFFICE;
    public static final int CATEGORY_CELL_HOME;
    public static final int CATEGORY_FAX_OFFICE;
    public static final int CATEGORY_FAX_HOME;

    public AutomaticRedialExtendedInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public AutomaticRedialExtendedInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.redial_TimeStamp = 0;
        this.category = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.pbName.reset();
        this.telNumber.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AutomaticRedialExtendedInfo_Status automaticRedialExtendedInfo_Status = (AutomaticRedialExtendedInfo_Status)bAPEntity;
        return this.redial_TimeStamp == automaticRedialExtendedInfo_Status.redial_TimeStamp && this.pbName.equalTo(automaticRedialExtendedInfo_Status.pbName) && this.telNumber.equalTo(automaticRedialExtendedInfo_Status.telNumber) && this.category == automaticRedialExtendedInfo_Status.category;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "AutomaticRedialExtendedInfo_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.redial_TimeStamp);
        this.pbName.serialize(bitStream);
        this.telNumber.serialize(bitStream);
        bitStream.pushByte((byte)this.category);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 58;
    }

    @Override
    public int getFunctionId() {
        return AutomaticRedialExtendedInfo_Status.functionId();
    }
}

