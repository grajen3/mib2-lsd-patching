/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

import org.dsi.ifc.base.DSIListener;

public interface DSIObjectPushListener
extends DSIListener {
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
}

