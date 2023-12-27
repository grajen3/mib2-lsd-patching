/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.speechproxy;

import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerProxy;
import de.vw.mib.asl.internal.speechengine.speechproxy.Activator;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class Activator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ Activator this$0;

    Activator$1(Activator activator) {
        this.this$0 = activator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        DialogManagerProxy dialogManagerProxy = (DialogManagerProxy)this.this$0.bundleContext.getService(serviceReference);
        this.this$0.speechProxy.setDialogManager(dialogManagerProxy);
        return dialogManagerProxy;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.speechProxy.setDialogManager(null);
    }
}

