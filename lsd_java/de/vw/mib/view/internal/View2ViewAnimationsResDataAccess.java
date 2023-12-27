/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

public class View2ViewAnimationsResDataAccess {
    public static final int SIGNATURE;
    private static final int HEADER_ARRAY;
    private static final int ANIMATIONLEAVEINDEX_ARRAY;
    private static final int ANIMATIONENTERINDEX_ARRAY;
    private static final int ANIMATIONLEAVEDELAY_ARRAY;
    private static final int ANIMATIONENTERDELAY_ARRAY;
    private static final int ANIMATIONAUDIORAMPDELAY_ARRAY;
    private static final int ANIMATIONLEAVEOVERENTER_ARRAY;
    private final Object[] resData;

    public View2ViewAnimationsResDataAccess(Object[] objectArray) {
        this.resData = objectArray;
    }

    public int getHeader_size() {
        return ((int[])this.resData[0]).length;
    }

    public int[] getHeader() {
        return (int[])this.resData[0];
    }

    public int getAnimationLeaveIndex_size() {
        return ((int[])this.resData[1]).length;
    }

    public int[] getAnimationLeaveIndex() {
        return (int[])this.resData[1];
    }

    public int getAnimationEnterIndex_size() {
        return ((int[])this.resData[2]).length;
    }

    public int[] getAnimationEnterIndex() {
        return (int[])this.resData[2];
    }

    public int getAnimationLeaveDelay_size() {
        return ((int[])this.resData[3]).length;
    }

    public int[] getAnimationLeaveDelay() {
        return (int[])this.resData[3];
    }

    public int getAnimationEnterDelay_size() {
        return ((int[])this.resData[4]).length;
    }

    public int[] getAnimationEnterDelay() {
        return (int[])this.resData[4];
    }

    public int getAnimationAudioRampDelay_size() {
        return ((int[])this.resData[5]).length;
    }

    public int[] getAnimationAudioRampDelay() {
        return (int[])this.resData[5];
    }

    public int getAnimationLeaveOverEnter_size() {
        return ((byte[])this.resData[6]).length;
    }

    public byte[] getAnimationLeaveOverEnter() {
        return (byte[])this.resData[6];
    }
}

