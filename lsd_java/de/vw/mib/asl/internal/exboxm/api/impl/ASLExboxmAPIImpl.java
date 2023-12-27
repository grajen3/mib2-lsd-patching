/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.api.impl;

import de.vw.mib.asl.api.exboxm.ASLExboxmAPI;
import de.vw.mib.asl.api.exboxm.audioinformation.ExboxAudioInformationService;
import de.vw.mib.asl.api.exboxm.guidance.ExboxGuidanceManager;
import de.vw.mib.asl.internal.exboxm.services.ExboxServices;
import de.vw.mib.asl.internal.exboxm.services.ExboxServicesProvider;
import de.vw.mib.asl.internal.exboxm.services.ServiceFactory;

public class ASLExboxmAPIImpl
implements ASLExboxmAPI {
    private final ExboxAudioInformationService audioInformationService;
    private final ExboxGuidanceManager exboxGuidanceManager;

    public ASLExboxmAPIImpl() {
        ExboxServices exboxServices = ExboxServicesProvider.getExBoxServices();
        this.audioInformationService = ServiceFactory.createExboxAudioInformationService(exboxServices);
        this.exboxGuidanceManager = ServiceFactory.createExboxGuidanceManager(exboxServices);
    }

    @Override
    public ExboxAudioInformationService getAudioInformationService() {
        return this.audioInformationService;
    }

    @Override
    public ExboxGuidanceManager getExboxGuidanceManager() {
        return this.exboxGuidanceManager;
    }
}

