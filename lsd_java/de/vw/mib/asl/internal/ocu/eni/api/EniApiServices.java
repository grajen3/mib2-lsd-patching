/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.api;

import de.vw.mib.asl.internal.ocu.eni.api.online.ChallengeDataService;
import de.vw.mib.asl.internal.ocu.eni.api.online.ConnectionStateService;
import de.vw.mib.asl.internal.ocu.eni.api.online.OnlineUpdateListService;
import de.vw.mib.asl.internal.ocu.eni.api.online.PrivacyService;
import de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessService;
import de.vw.mib.asl.internal.ocu.eni.api.online.ServiceListService;
import de.vw.mib.asl.internal.ocu.eni.api.online.UserListService;

public interface EniApiServices
extends RemoteProcessService,
UserListService,
ServiceListService,
PrivacyService,
OnlineUpdateListService,
ChallengeDataService,
ConnectionStateService {
}

