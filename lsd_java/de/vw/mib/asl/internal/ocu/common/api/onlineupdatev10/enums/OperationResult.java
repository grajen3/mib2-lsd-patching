/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.enums;

import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceResponseListener$OperationResult;
import de.vw.mib.asl.internal.ocu.common.api.types.GenericEnumValue;

public class OperationResult
extends GenericEnumValue
implements OnlineUpdateServiceResponseListener$OperationResult {
    public static final OperationResult ENUM_SUCCESSFUL = new OperationResult(0);
    public static final OperationResult ENUM_NOT_SUCCESSFUL = new OperationResult(1);
    public static final OperationResult ENUM_NOT_SUCCESSFUL_SERVICE_BUSY = new OperationResult(2);
    public static final OperationResult ENUM_NOT_SUCCESSFUL_ILLEGAL_OPERATION = new OperationResult(3);

    protected OperationResult(int n) {
        super(n);
    }
}

