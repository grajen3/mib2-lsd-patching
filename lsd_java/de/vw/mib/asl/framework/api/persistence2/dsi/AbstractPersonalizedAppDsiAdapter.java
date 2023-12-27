/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2.dsi;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.persistence2.dsi.PersonalizedApp;
import de.vw.mib.asl.framework.api.persistence2.dsi.PersonalizedAppListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public abstract class AbstractPersonalizedAppDsiAdapter
implements Target,
PersonalizedApp {
    private final GenericEvents genericEvents;
    private final DSIProxy dsiProxy;
    private int targetId;
    private PersonalizedAppListener listener;

    public AbstractPersonalizedAppDsiAdapter(GenericEvents genericEvents, DSIProxy dSIProxy) {
        this.genericEvents = genericEvents;
        this.dsiProxy = dSIProxy;
    }

    @Override
    public final GenericEvents getMainObject() {
        return this.genericEvents;
    }

    @Override
    public final void setTargetId(int n) {
        this.targetId = n;
    }

    @Override
    public final int getTargetId() {
        return this.targetId;
    }

    @Override
    public final void gotEvent(EventGeneric eventGeneric) {
    }

    public void init(PersonalizedAppListener personalizedAppListener) {
        this.listener = personalizedAppListener;
        DSIBase dSIBase = this.dsiProxy.getService(this, this.getDsiClass());
        this.registerDsiResponseListener(dSIBase);
        this.connectToDsi(dSIBase);
        this.genericEvents.getEventDispatcher().registerTarget(this);
    }

    public abstract Class getDsiClass() {
    }

    protected abstract void connectToDsi(DSIBase dSIBase) {
    }

    protected abstract Class getDsiListenerClass() {
    }

    protected PersonalizedAppListener getListener() {
        return this.listener;
    }

    protected abstract int getProfileStateAttributeValue() {
    }

    private void registerDsiResponseListener(DSIBase dSIBase) {
        DSIListener dSIListener = this.dsiProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, this.getDsiListenerClass());
        dSIBase.setNotification(this.getProfileStateAttributeValue(), dSIListener);
        this.dsiProxy.addResponseListener(this, this.getDsiListenerClass(), dSIListener);
    }
}

