/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager;

import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentActivation;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerUpdates;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.entertainmentmanager.EntertainmentManagerPersistence;
import de.vw.mib.asl.framework.internal.entertainmentmanager.activations.AbsoluteActivation;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;
import de.vw.mib.threads.AsyncServiceFactory;
import java.util.ArrayList;

public final class EntertainmentManagerLastmodes
implements Loggable {
    private EntertainmentManagerPersistence persistence;
    private final ArrayList updateListeners = new ArrayList();

    public void initPersistence() {
        this.persistence = new EntertainmentManagerPersistence();
        ServiceManager.persistence.registerSharedPersistable(this.persistence);
        ServiceManager.persistence.loadPersistable(5011, 0, this.persistence);
        int n = this.persistence.loadContext();
        this.setContext(n);
        this.triggerCurrentContext();
    }

    public AbsoluteActivation getActive() {
        return this.persistence.getActive();
    }

    public static int fallbackContext() {
        return 1;
    }

    private AbsoluteActivation fallback() {
        return this.persistence.getContextLastmode(EntertainmentManagerLastmodes.fallbackContext());
    }

    public AbsoluteActivation getContextLastmode(int n) {
        return this.persistence.getContextLastmode(n);
    }

    @Override
    public void toString(LogMessage logMessage) {
        this.persistence.toString(logMessage);
    }

    public void setContextLastmode(AbsoluteActivation absoluteActivation) {
        this.persistence.setContextLastmode(absoluteActivation);
        if (absoluteActivation.getContext() == 1) {
            this.onChangeBand(absoluteActivation.getSubcontext());
        }
    }

    public void resetContext(AbsoluteActivation absoluteActivation) {
        this.setContextLastmode(absoluteActivation);
        if (this.persistence.getActive().getContext() == absoluteActivation.getContext()) {
            this.setActive(absoluteActivation);
        }
    }

    private void setActive(AbsoluteActivation absoluteActivation) {
        this.persistence.setActive(absoluteActivation);
        this.triggerCurrentContext();
        this.onChangeActive(absoluteActivation);
    }

    private void triggerCurrentContext() {
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(-631499520);
        eventGeneric.setInt(0, this.getActive().getContext());
        ServiceManager.eventMain.getServiceRegister().triggerObserver(-631499520, eventGeneric);
    }

    public void resetLastContext(AbsoluteActivation absoluteActivation) {
        if (absoluteActivation.equals(this.persistence.getActive())) {
            this.setActive(this.fallback());
        }
        if (absoluteActivation.equals(this.persistence.getContextLastmode(absoluteActivation.getContext()))) {
            this.setContextLastmode(new AbsoluteActivation(absoluteActivation.getContext(), 0));
        }
    }

    public void setLastmodes(AbsoluteActivation absoluteActivation) {
        this.setActive(absoluteActivation);
    }

    public void addUpdates(EntertainmentManagerUpdates entertainmentManagerUpdates) {
        AsyncServiceFactory asyncServiceFactory = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory();
        entertainmentManagerUpdates = (EntertainmentManagerUpdates)asyncServiceFactory.create(entertainmentManagerUpdates);
        entertainmentManagerUpdates.onUpdateBand(this.getContextLastmode(1).getSubcontext());
        AbsoluteActivation absoluteActivation = this.getActive();
        if (ServiceManager.logger2.isTraceEnabled(16)) {
            ServiceManager.logger2.trace(16).append("Sending update to source ").append(absoluteActivation.getContext()).append(" to ").append(entertainmentManagerUpdates.toString()).append(" via EntertainmentManagerServiceImpl.addListener()").log();
        }
        entertainmentManagerUpdates.onUpdateEntertainmentSource(absoluteActivation.getContext(), absoluteActivation.getSubcontext());
        this.updateListeners.add(entertainmentManagerUpdates);
    }

    private void onChangeBand(int n) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            EntertainmentManagerUpdates entertainmentManagerUpdates = (EntertainmentManagerUpdates)this.updateListeners.get(i2);
            entertainmentManagerUpdates.onUpdateBand(n);
        }
    }

    private void onChangeActive(EntertainmentActivation entertainmentActivation) {
        for (int i2 = 0; i2 < this.updateListeners.size(); ++i2) {
            EntertainmentManagerUpdates entertainmentManagerUpdates = (EntertainmentManagerUpdates)this.updateListeners.get(i2);
            entertainmentManagerUpdates.onUpdateEntertainmentSource(entertainmentActivation.getContext(), entertainmentActivation.getSubcontext());
            if (!ServiceManager.logger2.isTraceEnabled(16)) continue;
            ServiceManager.logger2.trace(16).append("Sending update to source ").append(entertainmentActivation.getContext()).append(" to ").append(entertainmentManagerUpdates).append(" via EntertainmentManagerUpdates").log();
        }
    }

    public void setContext(int n) {
        this.setActive(this.getContextLastmode(n));
    }
}

