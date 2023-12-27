/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.api;

import de.vw.mib.asl.internal.ocu.common.api.OCUService;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceListenerNotifier;

public interface ECallInternalServices
extends OCUService,
ServiceListenerNotifier {
    public static final int PARAM_UPDATE_OPERATION_STATE_STARTED_RUNNING;
    public static final int PARAM_UPDATE_REGISTER_STATE_REGISTERED_STATE;
    public static final int PARAM_UPDATE_SUPPORTED_SERVICES_INFO_CALL_AVAILABLE;
    public static final int PARAM_UPDATE_SUPPORTED_SERVICES_SERVICE_CALL_AVAILABLE;
    public static final int PARAM_UPDATE_SUPPORTED_SERVICES_EMERGENCY_CALL_AVAILABLE;
}

