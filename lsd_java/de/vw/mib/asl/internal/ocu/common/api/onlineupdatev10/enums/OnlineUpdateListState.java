/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.enums;

import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateList$OnlineUpdateListState;
import de.vw.mib.asl.internal.ocu.common.api.types.GenericEnumValue;

public class OnlineUpdateListState
extends GenericEnumValue
implements OnlineUpdateList$OnlineUpdateListState {
    public static final OnlineUpdateListState ENUM_NOT_INITIALIZED = new OnlineUpdateListState(0);
    public static final OnlineUpdateListState ENUM_NOT_AVAILABLE = new OnlineUpdateListState(1);
    public static final OnlineUpdateListState ENUM_LOADING = new OnlineUpdateListState(2);
    public static final OnlineUpdateListState ENUM_LOADED = new OnlineUpdateListState(3);
    public static final OnlineUpdateListState ENUM_ERROR = new OnlineUpdateListState(4);

    private OnlineUpdateListState(int n) {
        super(n);
    }
}

