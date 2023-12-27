/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.powerstate;

import de.vw.mib.asl.api.system.powerstate.ClampSignalListener;
import de.vw.mib.asl.api.system.powerstate.ClampSignalService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.impl.system.powerstate.ClampSignalServiceImpl$1;
import de.vw.mib.asl.internal.impl.system.powerstate.ClampSignalServiceImpl$2;
import de.vw.mib.asl.internal.impl.system.powerstate.ClampSignalServiceImpl$3;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.hmi.utils.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.powermanagement.DSIPowerManagement;

public class ClampSignalServiceImpl
implements ClampSignalService {
    private final List listeners = new ArrayList();
    private boolean isCurrentClamp15Activated;
    private boolean isCurrentClampSActivated;
    private final ThreadSwitchingTarget threadSwitchingTarget;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;

    public ClampSignalServiceImpl(DSIProxy dSIProxy, ThreadSwitchingTarget threadSwitchingTarget) {
        this.threadSwitchingTarget = threadSwitchingTarget;
        this.connectToDsi(dSIProxy);
    }

    @Override
    public void addListener(ClampSignalListener clampSignalListener) {
        Preconditions.checkArgument(clampSignalListener != null, "Argument >listener< must not be null!");
        this.listeners.add(clampSignalListener);
    }

    @Override
    public void removeListener(ClampSignalListener clampSignalListener) {
        this.listeners.remove(clampSignalListener);
    }

    @Override
    public boolean isCurrentClamp15Activated() {
        return this.isCurrentClamp15Activated;
    }

    @Override
    public boolean isCurrentClampSActivated() {
        return this.isCurrentClampSActivated;
    }

    void applyCurrentClamp15Value(boolean bl) {
        if (this.isCurrentClamp15Activated != bl) {
            this.isCurrentClamp15Activated = bl;
            this.notifyClamp15SignalListener(bl);
        }
    }

    void applyCurrentClampSValue(boolean bl) {
        if (this.isCurrentClampSActivated != bl) {
            this.isCurrentClampSActivated = bl;
            this.notifyClampSSignalListener(bl);
        }
    }

    private void connectToDsi(DSIProxy dSIProxy) {
        DSIPowerManagement dSIPowerManagement = (DSIPowerManagement)dSIProxy.getService(null, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = ClampSignalServiceImpl.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        DSIListener dSIListener = this.createDSIPowerManagementListenerAdapter();
        dSIProxy.addResponseListener(null, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = ClampSignalServiceImpl.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener, dSIListener);
        dSIPowerManagement.setNotification(4, dSIListener);
    }

    private DSIListener createDSIPowerManagementListenerAdapter() {
        return new ClampSignalServiceImpl$1(this);
    }

    private void notifyClamp15SignalListener(boolean bl) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ClampSignalListener clampSignalListener = (ClampSignalListener)iterator.next();
            this.threadSwitchingTarget.enqueue(new ClampSignalServiceImpl$2(this, clampSignalListener, bl));
        }
    }

    private void notifyClampSSignalListener(boolean bl) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ClampSignalListener clampSignalListener = (ClampSignalListener)iterator.next();
            this.threadSwitchingTarget.enqueue(new ClampSignalServiceImpl$3(this, clampSignalListener, bl));
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

