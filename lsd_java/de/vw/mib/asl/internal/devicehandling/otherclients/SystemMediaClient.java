/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.devicehandling.otherclients;

import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.devicehandling.clients.MediumChangeListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;

public class SystemMediaClient
extends MediumChangeListener {
    @Override
    protected void onChange(Medium medium) {
        if (medium.getPreviousInfo().getMediaType() == 17 ^ medium.getCurrentInfo().getMediaType() == 17) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setObject(0, medium.getParent().getCurrentInfo());
            ServiceManager.eventMain.getServiceRegister().triggerObserver(-976868096, eventGeneric);
        }
    }
}

