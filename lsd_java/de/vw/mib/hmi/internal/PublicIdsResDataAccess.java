/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.internal;

import de.vw.mib.hmi.utils.PerfectSlotHash;

public class PublicIdsResDataAccess {
    public static final int SIGNATURE;
    private static final int HEADER_ARRAY;
    private static final int ASLDATAPOOLIDS_PUBLICID_ARRAY;
    private static final int ASLDATAPOOLIDS_TARGETID_ARRAY;
    private static final int ASLDATAPOOLIDS_HASH_ARRAY;
    private static final int EVENTIDS_PUBLICID_ARRAY;
    private static final int EVENTIDS_DATA_ARRAY;
    private final Object[] resData;

    public PublicIdsResDataAccess(Object[] objectArray) {
        this.resData = objectArray;
    }

    public int getHeader_size() {
        return ((int[])this.resData[0]).length;
    }

    public int[] getHeader() {
        return (int[])this.resData[0];
    }

    public int getAslDatapoolIds_size() {
        return ((int[])this.resData[1]).length;
    }

    public int[] getAslDatapoolIds_PublicId() {
        return (int[])this.resData[1];
    }

    public int[] getAslDatapoolIds_TargetId() {
        return (int[])this.resData[2];
    }

    public PerfectSlotHash newAslDatapoolIds_slothash() {
        Object object = this.resData[1];
        Object object2 = this.resData[3];
        return PerfectSlotHash.newSlotHash(object, object2);
    }

    public int getEventIds_size() {
        return ((int[])this.resData[4]).length;
    }

    public int[] getEventIds_PublicId() {
        return (int[])this.resData[4];
    }

    public int getEventIds_Data_size() {
        return ((int[])this.resData[5]).length;
    }

    public int[] getEventIds_Data() {
        return (int[])this.resData[5];
    }
}

