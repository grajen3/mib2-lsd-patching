/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.carplay.datatypes.iterator.elements;

public interface CarPlayCall {
    public static final int CAR_PLAY_SERVICE__CALL_STATE__DISCONNECTING;
    public static final int CAR_PLAY_SERVICE__CALL_STATE__ACTIVE;
    public static final int CAR_PLAY_SERVICE__CALL_STATE__HOLD;
    public static final int CAR_PLAY_SERVICE__CALL_STATE__CONNECTING;
    public static final int CAR_PLAY_SERVICE__CALL_DIRECTION__INCOMING;
    public static final int CAR_PLAY_SERVICE__CALL_DIRECTION__OUTGOING;
    public static final int CAR_PLAY_SERVICE__CALL_DIRECTION__UNKNOWN;
    public static final int CAR_PLAY_SERVICE__CALL_ID_ONE;
    public static final int CAR_PLAY_SERVICE__CALL_ID_TWO;
    public static final int CAR_PLAY_SERVICE__CALL_ID_THREE;
    public static final int CAR_PLAY_SERVICE__CALL_ID_FOUR;
    public static final int CAR_PLAY_SERVICE__CALL_ID_FIVE;
    public static final int CAR_PLAY_SERVICE__CALL_ID_SIX;
    public static final int CAR_PLAY_SERVICE__CALL_ID_SEVEN;
    public static final int CAR_PLAY_SERVICE__CALL_ID_CONFERENCE;
    public static final int CAR_PLAY_SERVICE__CALL_ID_INVALID;

    default public String getUniqueCarPlayCallID() {
    }

    default public int getMappedCallID() {
    }

    default public String getPhoneNumber() {
    }

    default public String getCallerName() {
    }

    default public int getStatus() {
    }

    default public int getDirection() {
    }
}

