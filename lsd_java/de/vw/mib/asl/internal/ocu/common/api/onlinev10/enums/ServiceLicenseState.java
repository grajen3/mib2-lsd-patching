/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry$ServiceLicenseState;
import de.vw.mib.asl.internal.ocu.common.api.types.GenericEnumValue;

public class ServiceLicenseState
extends GenericEnumValue
implements OnlineNetworkServiceListEntry$ServiceLicenseState {
    public static final ServiceLicenseState ENUM_NOT_LICENSED = new ServiceLicenseState(0);
    public static final ServiceLicenseState ENUM_NOT_ACTIVATED = new ServiceLicenseState(1);
    public static final ServiceLicenseState ENUM_ACTIVATED = new ServiceLicenseState(2);
    public static final ServiceLicenseState ENUM_EXPIRED = new ServiceLicenseState(3);
    public static final ServiceLicenseState ENUM_TEPORARY_OFFER = new ServiceLicenseState(4);
    public static final ServiceLicenseState ENUM_LICENSE_ERROR = new ServiceLicenseState(5);

    public ServiceLicenseState(int n) {
        super(n);
    }
}

