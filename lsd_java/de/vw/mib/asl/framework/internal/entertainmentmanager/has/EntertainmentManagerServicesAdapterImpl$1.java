/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.has;

import de.vw.mib.asl.framework.api.entertainmentmanager.contextlistener.EntertainmentContextListenerService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.framework.internal.entertainmentmanager.has.EntertainmentManagerServicesAdapterImpl;

class EntertainmentManagerServicesAdapterImpl$1
implements ASLComponentAPICallback {
    private final /* synthetic */ EntertainmentManagerServicesAdapterImpl this$0;

    EntertainmentManagerServicesAdapterImpl$1(EntertainmentManagerServicesAdapterImpl entertainmentManagerServicesAdapterImpl) {
        this.this$0 = entertainmentManagerServicesAdapterImpl;
    }

    @Override
    public void registered(Class clazz, Object object) {
        EntertainmentContextListenerService entertainmentContextListenerService = (EntertainmentContextListenerService)object;
        entertainmentContextListenerService.registerEntertainmentContextListener(this.this$0);
    }
}

