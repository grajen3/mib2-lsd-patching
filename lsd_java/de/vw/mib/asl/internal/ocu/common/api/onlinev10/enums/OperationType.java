/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums;

import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationType;
import de.vw.mib.asl.internal.ocu.common.api.types.GenericEnumValue;

public class OperationType
extends GenericEnumValue
implements OnlineNetworkServiceResponseListener$OperationType {
    public static final OperationType ENUM_PAIR_MAIN_USER = new OperationType(0);
    public static final OperationType ENUM_RESTORE_FACTORY_SETTINGS = new OperationType(1);
    public static final OperationType ENUM_CONFIRM_SERVICE_EXPIRY_WARNING = new OperationType(2);
    public static final OperationType ENUM_CONFIRM_ALL_SERVICE_EXPIRY_WARNINGS = new OperationType(3);
    public static final OperationType ENUM_SYNCHRONIZE_SERVICE_LIST_WITH_BACKEND = new OperationType(4);
    public static final OperationType ENUM_SET_PRIVACY_MODE = new OperationType(5);

    private OperationType(int n) {
        super(n);
    }
}

