/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums;

import de.vw.mib.asl.internal.ocu.common.api.types.GenericEnumValue;

public class ServiceListSynchronisationState
extends GenericEnumValue
implements de.vw.mib.asl.api.ocu.onlinev10.data.ServiceListSynchronisationState {
    public static final ServiceListSynchronisationState ENUM_NOT_AVAILABLE = new ServiceListSynchronisationState(0);
    public static final ServiceListSynchronisationState ENUM_UNKNOWN = new ServiceListSynchronisationState(1);
    public static final ServiceListSynchronisationState ENUM_NOT_SYNCHRONISED = new ServiceListSynchronisationState(2);
    public static final ServiceListSynchronisationState ENUM_SYNCHRONISED = new ServiceListSynchronisationState(3);

    private ServiceListSynchronisationState(int n) {
        super(n);
    }
}

