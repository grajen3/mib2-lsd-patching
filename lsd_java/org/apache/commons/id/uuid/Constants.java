/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid;

public interface Constants {
    public static final int UUID_BIT_LENGTH;
    public static final int UUID_BYTE_LENGTH;
    public static final int UUID_UNFORMATTED_LENGTH;
    public static final int UUID_FORMATTED_LENGTH;
    public static final int TOKENS_IN_UUID;
    public static final int[] TOKEN_LENGTHS;
    public static final int FORMAT_POSITION1;
    public static final int FORMAT_POSITION2;
    public static final int FORMAT_POSITION3;
    public static final int FORMAT_POSITION4;
    public static final String URN_PREFIX;
    public static final int VARIANT_NCS_COMPAT;
    public static final int VARIANT_IETF_DRAFT;
    public static final int VARIANT_MS;
    public static final int VARIANT_FUTURE;
    public static final int VERSION_ONE;
    public static final int VERSION_TWO;
    public static final int VERSION_THREE;
    public static final int VERSION_FOUR;
    public static final int VERSION_FIVE;
    public static final String MD5_ENCODING;
    public static final String SHA1_ENCODING;
    public static final String WRONG_VAR_VER_MSG;
    public static final int TIME_LOW_BYTE_LEN;
    public static final int TIME_MID_BYTE_LEN;
    public static final int TIME_HI_BYTE_LEN;
    public static final int TIME_LOW_TS_POS;
    public static final int TIME_MID_TS_POS;
    public static final int TIME_HI_TS_POS;
    public static final int TIME_LOW_START_POS;
    public static final int TIME_MID_START_POS;
    public static final int TIME_HI_START_POS;
    public static final short TIME_HI_AND_VERSION_BYTE_6;
    public static final short CLOCK_SEQ_HI_AND_RESERVED_BYTE_8;

    static {
        TOKEN_LENGTHS = new int[]{8, 4, 4, 4, 12};
    }
}

