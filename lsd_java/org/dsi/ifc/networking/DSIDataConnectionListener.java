/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.ApplicationErrorStruct;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DataConnectionStateStruct;

public interface DSIDataConnectionListener
extends DSIListener {
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
}

