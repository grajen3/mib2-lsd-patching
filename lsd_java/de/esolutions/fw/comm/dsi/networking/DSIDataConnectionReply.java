/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking;

import org.dsi.ifc.networking.ApplicationErrorStruct;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DataConnectionStateStruct;

public interface DSIDataConnectionReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateStateDataConnection(DataConnectionStateStruct dataConnectionStateStruct, int n) {
    }

    default public void updateConnectionStateInformation(ConnectionStateInformationStruct connectionStateInformationStruct, int n) {
    }

    default public void updateRoamingState(int n, int n2) {
    }

    default public void updateErrorState(ApplicationErrorStruct applicationErrorStruct, int n) {
    }

    default public void forceDisconnectResponse(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

