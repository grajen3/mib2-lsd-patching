/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.services;

import de.vw.mib.asl.api.exboxm.audioinformation.ExboxAudioInformationService;
import de.vw.mib.asl.api.exboxm.guidance.ExboxGuidanceManager;
import de.vw.mib.asl.internal.exboxm.api.impl.audioinformation.ExboxAudioInformationServiceImpl;
import de.vw.mib.asl.internal.exboxm.api.impl.guidance.ExboxGuidanceManagerImpl;
import de.vw.mib.asl.internal.exboxm.services.ExboxServices;
import de.vw.mib.asl.internal.exboxm.services.StartupService;
import de.vw.mib.asl.internal.exboxm.state.ExboxStateService;
import de.vw.mib.asl.internal.exboxm.state.ExboxStateServiceImpl;

public class ServiceFactory {
    public static ExboxAudioInformationService createExboxAudioInformationService(ExboxServices exboxServices) {
        return new ExboxAudioInformationServiceImpl(exboxServices.getLogger(), exboxServices.getInternalStartupService());
    }

    public static ExboxStateService createExboxStateService(ExboxServices exboxServices) {
        StartupService startupService = exboxServices.getInternalStartupService();
        ExboxStateServiceImpl exboxStateServiceImpl = new ExboxStateServiceImpl(exboxServices.getLogger(), exboxServices.getDSIProxy(), exboxServices.getAslPropertyManager());
        startupService.addStartupListener(exboxStateServiceImpl);
        return exboxStateServiceImpl;
    }

    public static ExboxGuidanceManager createExboxGuidanceManager(ExboxServices exboxServices) {
        return new ExboxGuidanceManagerImpl(exboxServices.getLogger(), exboxServices.getExboxStateService(), exboxServices.getAslThreadSwitchingTarget());
    }
}

