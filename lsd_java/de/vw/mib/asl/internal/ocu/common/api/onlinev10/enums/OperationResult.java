/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums;

import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationResult;
import de.vw.mib.asl.internal.ocu.common.api.types.GenericEnumValue;

public class OperationResult
extends GenericEnumValue
implements OnlineNetworkServiceResponseListener$OperationResult {
    public static final OperationResult ENUM_SUCCESSFUL = new OperationResult(0);
    public static final OperationResult ENUM_NOT_SUCCESSFUL = new OperationResult(1);
    public static final OperationResult ENUM_NOT_SUCCESSFUL_SERVICE_BUSY = new OperationResult(2);
    public static final OperationResult ENUM_TERMINATED_BY_USER = new OperationResult(3);
    public static final OperationResult ENUM_NO_NETWORK_CONNECTION = new OperationResult(4);
    public static final OperationResult ENUM_BACKEND_SERVICE_UNAVAILABLE = new OperationResult(6);
    public static final OperationResult ENUM_MISC_BACKEND_ERROR = new OperationResult(7);
    public static final OperationResult ENUM_TIMEOUT = new OperationResult(8);
    public static final OperationResult ENUM_WRONG_REGISTRATION_CODE = new OperationResult(11);
    public static final OperationResult ENUM_WRONG_REGISTRATION_CODE_PIN_EXPIRED = new OperationResult(12);
    public static final OperationResult ENUM_WRONG_REGISTRATION_CODE_NO_PIN_CREATED_UNPAIRED = new OperationResult(13);

    private OperationResult(int n) {
        super(n);
    }
}

