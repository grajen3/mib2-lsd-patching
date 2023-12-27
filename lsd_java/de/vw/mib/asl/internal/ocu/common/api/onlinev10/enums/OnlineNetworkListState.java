/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList$OnlineNetworkListState;
import de.vw.mib.asl.internal.ocu.common.api.types.GenericEnumValue;

public class OnlineNetworkListState
extends GenericEnumValue
implements OnlineNetworkList$OnlineNetworkListState {
    public static final OnlineNetworkListState ENUM_NOT_INITIALIZED = new OnlineNetworkListState(0);
    public static final OnlineNetworkListState ENUM_NOT_AVAILABLE = new OnlineNetworkListState(1);
    public static final OnlineNetworkListState ENUM_LOADING = new OnlineNetworkListState(2);
    public static final OnlineNetworkListState ENUM_LOADED = new OnlineNetworkListState(3);
    public static final OnlineNetworkListState ENUM_ERROR = new OnlineNetworkListState(4);

    private OnlineNetworkListState(int n) {
        super(n);
    }
}

