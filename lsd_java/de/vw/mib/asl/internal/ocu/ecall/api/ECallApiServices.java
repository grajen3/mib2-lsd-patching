/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.api;

import de.vw.mib.asl.api.ocu.ecall.ECallService;
import de.vw.mib.asl.internal.ocu.ecall.api.asl.AndroidAutoService;
import de.vw.mib.asl.internal.ocu.ecall.api.asl.AudioManagementService;
import de.vw.mib.asl.internal.ocu.ecall.api.asl.CarPlayService;
import de.vw.mib.asl.internal.ocu.ecall.api.asl.PhoneService;
import de.vw.mib.asl.internal.ocu.ecall.api.asl.SmartphoneIntegrationService;
import de.vw.mib.asl.internal.ocu.ecall.api.model.ModelOcuTestModeListener;
import de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCallListener;
import de.vw.mib.asl.internal.ocu.ecall.api.online.OperationStateServiceListener;
import de.vw.mib.asl.internal.ocu.ecall.api.online.RegisterStateServiceListener;
import de.vw.mib.asl.internal.ocu.ecall.api.voice.SupportedServicesListener;

public interface ECallApiServices
extends ECallService,
AudioManagementService,
PhoneService,
ModelPhoneOcuCallListener,
CarPlayService,
AndroidAutoService,
SmartphoneIntegrationService,
OperationStateServiceListener,
RegisterStateServiceListener,
SupportedServicesListener,
ModelOcuTestModeListener {
    public static final int PRIVATE;
}

