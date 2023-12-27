/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.api.impl.audioinformation;

import de.vw.mib.asl.internal.exboxm.api.impl.audioinformation.ExboxAudioInformationServiceImpl;
import de.vw.mib.asl.internal.exboxm.services.ExboxServices;
import de.vw.mib.asl.internal.exboxm.services.ExboxServicesProvider;
import de.vw.mib.asl.internal.exboxm.services.StartupListener;

class ExboxAudioInformationServiceImpl$1
implements StartupListener {
    private final /* synthetic */ ExboxAudioInformationServiceImpl this$0;

    ExboxAudioInformationServiceImpl$1(ExboxAudioInformationServiceImpl exboxAudioInformationServiceImpl) {
        this.this$0 = exboxAudioInformationServiceImpl;
    }

    @Override
    public void notifyPowerOnEvent() {
        ExboxServices exboxServices = ExboxServicesProvider.getExBoxServices();
        this.this$0.setInvoker(exboxServices.getAslThreadSwitchingTarget());
        this.this$0.registerToDsi(exboxServices.getDSIProxy());
    }
}

