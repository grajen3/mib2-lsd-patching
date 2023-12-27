/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import org.dsi.ifc.organizer.DataSet;

public interface DSIAdbDataResolutionReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void resolveMailAddressResult(int n, DataSet[] dataSetArray) {
    }

    default public void resolvePhoneNumbersResult(int n, DataSet[] dataSetArray) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

