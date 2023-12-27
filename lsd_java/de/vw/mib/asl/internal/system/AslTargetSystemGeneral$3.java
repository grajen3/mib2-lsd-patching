/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.media.services.sources.MediaEjectionService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral;

class AslTargetSystemGeneral$3
implements ASLComponentAPICallback {
    private final /* synthetic */ AslTargetSystemGeneral this$0;

    AslTargetSystemGeneral$3(AslTargetSystemGeneral aslTargetSystemGeneral) {
        this.this$0 = aslTargetSystemGeneral;
    }

    @Override
    public void registered(Class clazz, Object object) {
        this.this$0.mediaEjectionService = (MediaEjectionService)object;
    }
}

