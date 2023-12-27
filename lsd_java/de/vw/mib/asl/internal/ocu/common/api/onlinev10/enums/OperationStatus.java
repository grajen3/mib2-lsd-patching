/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums;

import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationStatus;
import de.vw.mib.asl.internal.ocu.common.api.types.GenericEnumValue;

public class OperationStatus
extends GenericEnumValue
implements OnlineNetworkServiceResponseListener$OperationStatus {
    public static final OperationStatus ENUM_NO_INFORMATION = new OperationStatus(0);
    public static final OperationStatus ENUM_NO_REQUEST_ACTIVE = new OperationStatus(1);
    public static final OperationStatus ENUM_IN_PROGRESS = new OperationStatus(2);
    public static final OperationStatus ENUM_SEARCHING_FOR_NETWORK = new OperationStatus(3);
    public static final OperationStatus ENUM_CONNECTING_TO_SERVER = new OperationStatus(4);
    public static final OperationStatus ENUM_WAITING_FOR_AUTHENTICATION = new OperationStatus(5);
    public static final OperationStatus ENUM_DATA_TRANSMISSION = new OperationStatus(6);

    private OperationStatus(int n) {
        super(n);
    }
}

