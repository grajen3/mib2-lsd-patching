/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceStatus$CellularNetworkState;
import de.vw.mib.asl.internal.ocu.common.api.types.GenericEnumValue;

public class CellularNetworkState
extends GenericEnumValue
implements OnlineNetworkServiceStatus$CellularNetworkState {
    public static final CellularNetworkState ENUM_UNKNOWN = new CellularNetworkState(0);
    public static final CellularNetworkState ENUM_NOT_CONNECTED = new CellularNetworkState(1);
    public static final CellularNetworkState ENUM_CONNECTED = new CellularNetworkState(2);

    private CellularNetworkState(int n) {
        super(n);
    }
}

