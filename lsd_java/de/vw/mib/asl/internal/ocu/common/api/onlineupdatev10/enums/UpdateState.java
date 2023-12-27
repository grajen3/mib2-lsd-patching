/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.enums;

import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState$UpdateState;
import de.vw.mib.asl.internal.ocu.common.api.types.GenericEnumValue;

public class UpdateState
extends GenericEnumValue
implements OnlineUpdateState$UpdateState {
    public static final UpdateState ENUM_NO_UPDATE_AVAILABLE = new UpdateState(0);
    public static final UpdateState ENUM_SPIN_INVALID = new UpdateState(1);
    public static final UpdateState ENUM_SPIN_FAILED = new UpdateState(2);
    public static final UpdateState ENUM_SPIN_ERROR = new UpdateState(3);
    public static final UpdateState ENUM_DOWNLOAD_CONFIRM_PENDING = new UpdateState(4);
    public static final UpdateState ENUM_DOWNLOAD_RUNNING = new UpdateState(5);
    public static final UpdateState ENUM_DOWNLOAD_WITHDRAWN_CONFIRM_PENDING = new UpdateState(7);
    public static final UpdateState ENUM_DOWNLOAD_ERROR_CONFIRM_PENDING = new UpdateState(9);
    public static final UpdateState ENUM_INSTALLATION_CONFIRM_PENDING = new UpdateState(10);
    public static final UpdateState ENUM_INSTALLATION_RUNNING = new UpdateState(11);
    public static final UpdateState ENUM_INSTALLATION_ERROR_CONFIRM_PENDING = new UpdateState(13);
    public static final UpdateState ENUM_INSTALLATION_FATAL_ERROR_CONFIRM_PENDING = new UpdateState(14);
    public static final UpdateState ENUM_INSTALLATION_FINISHED_CONFIRM_PENDING = new UpdateState(15);
    public static final UpdateState ENUM_INSTALLATION_PRECONDITION_NOT_MET = new UpdateState(16);

    protected UpdateState(int n) {
        super(n);
    }
}

