/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth;

public interface DSIObjectPushReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateOPPIncomingObject(String string, String string2, int n, int n2) {
    }

    default public void responseOPPAbortSending(int n) {
    }

    default public void responseOPPAcceptObject(int n) {
    }

    default public void responseOPPSendContacts(int n) {
    }

    default public void responseOPPSendMessages(int n) {
    }

    default public void responseOPPSendBinary(int n) {
    }

    default public void updateVCardsReceived(String string, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

