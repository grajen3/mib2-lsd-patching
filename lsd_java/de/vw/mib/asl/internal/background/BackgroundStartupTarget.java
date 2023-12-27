/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.background;

import de.vw.mib.asl.api.background.ASLBackgroundFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.background.api.impl.ASLBackgroundAPIImpl;
import de.vw.mib.asl.internal.background.api.impl.ServiceInstaller;
import de.vw.mib.asl.internal.impl.background.AbstractBackgroundTarget;
import de.vw.mib.asl.internal.impl.background.BackgroundServicesImpl;
import de.vw.mib.asl.internal.impl.background.ParticleParameterSetSelector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class BackgroundStartupTarget
extends AbstractBackgroundTarget {
    public BackgroundStartupTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), -494134784);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
        }
    }

    private void processPowerOn() {
        BackgroundServicesImpl backgroundServicesImpl = new BackgroundServicesImpl();
        ServiceInstaller serviceInstaller = new ServiceInstaller((ASLBackgroundAPIImpl)ASLBackgroundFactory.getBackgroundApi());
        serviceInstaller.installParticleBackgroundService(new ParticleParameterSetSelector(backgroundServicesImpl));
    }
}

