/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.media.services.sources.medialist.MediaIndicationService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral;
import de.vw.mib.asl.internal.system.MediaDeviceUpdater;

class AslTargetSystemGeneral$4
implements ASLComponentAPICallback {
    private final /* synthetic */ MediaDeviceUpdater val$deviceUpdater;
    private final /* synthetic */ AslTargetSystemGeneral this$0;

    AslTargetSystemGeneral$4(AslTargetSystemGeneral aslTargetSystemGeneral, MediaDeviceUpdater mediaDeviceUpdater) {
        this.this$0 = aslTargetSystemGeneral;
        this.val$deviceUpdater = mediaDeviceUpdater;
    }

    @Override
    public void registered(Class clazz, Object object) {
        MediaIndicationService mediaIndicationService = (MediaIndicationService)object;
        mediaIndicationService.registerSystemIndicationListener(this.val$deviceUpdater);
    }
}

