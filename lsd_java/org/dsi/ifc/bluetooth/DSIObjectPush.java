/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

import org.dsi.ifc.base.DSIBase;

public interface DSIObjectPush
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_OPPINCOMINGOBJECT;
    public static final int ATTR_VCARDSRECEIVED;
    public static final int RT_REQUESTOPPABORTSENDING;
    public static final int RT_REQUESTOPPACCEPTOBJECT;
    public static final int RT_REQUESTOPPSENDBINARY;
    public static final int RT_REQUESTOPPSENDCONTACTS;
    public static final int RT_REQUESTOPPSENDMESSAGES;
    public static final int RP_RESPONSEOPPABORTSENDING;
    public static final int RP_RESPONSEOPPACCEPTOBJECT;
    public static final int RP_RESPONSEOPPSENDBINARY;
    public static final int RP_RESPONSEOPPSENDCONTACTS;
    public static final int RP_RESPONSEOPPSENDMESSAGES;
    public static final int OBJECTTYPE_ADDRESS;
    public static final int OBJECTTYPE_APPOINTMENT;
    public static final int OBJECTTYPE_MESSAGE;
    public static final int OBJECTTYPE_BINARY;
    public static final int OBJECTTYPE_UNKNOWN;
    public static final int OBJECTTYPE_TODO;
    public static final int OBJECTTYPE_NOTE;

    default public void requestOPPAbortSending() {
    }

    default public void requestOPPAcceptObject(String string, boolean bl) {
    }

    default public void requestOPPSendContacts(String string, String string2) {
    }

    default public void requestOPPSendMessages(String string, int[] nArray) {
    }

    default public void requestOPPSendBinary(String string, String[] stringArray) {
    }
}

