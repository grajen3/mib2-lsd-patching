/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.enums;

import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceResponseListener$OperationStatus;
import de.vw.mib.asl.internal.ocu.common.api.types.GenericEnumValue;

public class OperationStatus
extends GenericEnumValue
implements OnlineUpdateServiceResponseListener$OperationStatus {
    public static final OperationStatus ENUM_NO_INFORMATION = new OperationStatus(0);
    public static final OperationStatus ENUM_NO_REQUEST_ACTIVE = new OperationStatus(1);
    public static final OperationStatus ENUM_IN_PROGRESS = new OperationStatus(2);
    public static final OperationStatus ENUM_CONNECTING_TO_SERVER = new OperationStatus(4);
    public static final OperationStatus ENUM_WAITING_FOR_AUTHENTICATION = new OperationStatus(5);
    public static final OperationStatus ENUM_DATA_TRANSMISSION = new OperationStatus(6);

    protected OperationStatus(int n) {
        super(n);
    }
}

