/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.debugmanager.internal.DebugProbeManagerImpl;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import java.util.HashSet;
import java.util.List;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

class DebugProbeManagerImpl$2
implements ServiceListener {
    private HashSet alreadyRegisteredServices = new HashSet();
    private boolean alreadyInitiaized = false;
    private final /* synthetic */ List val$mandatoryServiceNames;
    private final /* synthetic */ DebugProbe val$debugProbe;
    private final /* synthetic */ DebugProbeFactory val$debugProbeFactory;
    private final /* synthetic */ DebugProbeManagerImpl this$0;

    DebugProbeManagerImpl$2(DebugProbeManagerImpl debugProbeManagerImpl, List list, DebugProbe debugProbe, DebugProbeFactory debugProbeFactory) {
        this.this$0 = debugProbeManagerImpl;
        this.val$mandatoryServiceNames = list;
        this.val$debugProbe = debugProbe;
        this.val$debugProbeFactory = debugProbeFactory;
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        block3: {
            String[] stringArray;
            block2: {
                stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
                if (serviceEvent.getType() != 1) break block2;
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    this.serviceRegistered(stringArray[i2]);
                }
                break block3;
            }
            if (serviceEvent.getType() != 4) break block3;
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                this.serviceUnregistered(stringArray[i3]);
            }
        }
    }

    private void serviceRegistered(String string) {
        if (this.val$mandatoryServiceNames.contains(string) && !this.alreadyInitiaized) {
            this.alreadyRegisteredServices.add(string);
            if (this.alreadyRegisteredServices.size() == this.val$mandatoryServiceNames.size()) {
                this.val$debugProbe.init();
                this.this$0.initialConfigureProbe(this.val$debugProbeFactory, this.val$debugProbe);
                this.alreadyInitiaized = true;
            }
        }
    }

    private void serviceUnregistered(String string) {
        if (this.val$mandatoryServiceNames.contains(string)) {
            this.alreadyRegisteredServices.remove(string);
            if (this.alreadyRegisteredServices.size() == this.val$mandatoryServiceNames.size() - 1) {
                this.val$debugProbe.cleanUp();
                this.alreadyInitiaized = false;
            }
        }
    }
}

