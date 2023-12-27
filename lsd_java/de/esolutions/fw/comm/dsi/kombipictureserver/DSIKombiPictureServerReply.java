/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombipictureserver;

public interface DSIKombiPictureServerReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void indicationCoverArt(long l, int n, int n2) {
    }

    default public void indicationStationArt(long l, int n, int n2) {
    }

    default public void indicationActiveCallPicture(int n) {
    }

    default public void indicationActiveCallPictureInstance(int n, int n2) {
    }

    default public void indicationDynamicIcon(int n, int n2) {
    }

    default public void indicationInternalAddressID(long l, int n) {
    }

    default public void indicationAdbContactPicture(long l, int n) {
    }

    default public void indicationPictureStreamAbilities() {
    }

    default public void indicationPictureStream(int n, short s, short s2, int n2, int n3, int n4, int n5, byte[] byArray) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

