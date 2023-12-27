/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.enums;

import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceResponseListener$OperationType;
import de.vw.mib.asl.internal.ocu.common.api.types.GenericEnumValue;

public class OperationType
extends GenericEnumValue
implements OnlineUpdateServiceResponseListener$OperationType {
    public static final OperationType ENUM_POSTPONE_ONLINE_DOWNLOAD = new OperationType(1);
    public static final OperationType ENUM_AUTHENTICATE_ONLINE_DOWNLOAD = new OperationType(2);
    public static final OperationType ENUM_POSTPONE_UPDATE_INSTALLATION = new OperationType(4);
    public static final OperationType ENUM_CONFIRM_UPDATE_INSTALLATION = new OperationType(5);
    public static final OperationType ENUM_CONFIRM_UPDATE_ERROR = new OperationType(7);
    public static final OperationType ENUM_CONFIRM_INSTALLATION_FINISHED = new OperationType(8);
    public static final OperationType ENUM_CONFIRM_UPDATE_WITHDRAWN = new OperationType(9);
    public static final OperationType ENUM_NO_OPERATION = new OperationType(0);
    public static final OperationType ENUM_REQUEST_CHALLENGE = new OperationType(10);

    protected OperationType(int n) {
        super(n);
    }
}

