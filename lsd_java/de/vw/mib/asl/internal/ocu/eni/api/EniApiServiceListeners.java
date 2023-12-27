/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.api;

import de.vw.mib.asl.internal.ocu.eni.api.online.ActiveMonitoringsServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.ChallengeDataServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.ConnectionStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.CurrentOnlineUpdateStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.FunctionSupportServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.OnlineUpdateListServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.OperationStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.PrivacySetupServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.ServiceListServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.UserListServiceListener;

public interface EniApiServiceListeners
extends RemoteProcessServiceListener,
UserListServiceListener,
ServiceListServiceListener,
OperationStateServiceListener,
FunctionSupportServiceListener,
ActiveMonitoringsServiceListener,
OnlineUpdateListServiceListener,
CurrentOnlineUpdateStateServiceListener,
ChallengeDataServiceListener,
PrivacySetupServiceListener,
ConnectionStateServiceListener {
}

