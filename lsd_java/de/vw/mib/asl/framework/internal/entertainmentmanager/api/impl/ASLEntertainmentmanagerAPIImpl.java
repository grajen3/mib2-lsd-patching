/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.api.impl;

import de.vw.mib.asl.framework.api.entertainmentmanager.ASLEntertainmentmanagerAPI;
import de.vw.mib.asl.framework.api.entertainmentmanager.ASLEntertainmentmanagerFactory;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerListener;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerResponder;
import de.vw.mib.asl.framework.internal.entertainmentmanager.EntertainmentManagerListeners;
import de.vw.mib.asl.framework.internal.entertainmentmanager.activations.AbsoluteActivation;
import de.vw.mib.asl.framework.internal.entertainmentmanager.api.impl.EntertainmentManagerResponderImpl;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;

public class ASLEntertainmentmanagerAPIImpl
implements ASLEntertainmentmanagerAPI {
    private int currentContext;
    private int currentSubcontext;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerListener;

    @Override
    public void register(Object object, Class clazz) {
        if (clazz == (class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerListener == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerListener = ASLEntertainmentmanagerAPIImpl.class$("de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerListener")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerListener)) {
            EntertainmentManagerListeners.getInstance().register((EntertainmentManagerListener)object);
        }
    }

    @Override
    public void deregister(Object object, Class clazz) {
        if (clazz == (class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerListener == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerListener = ASLEntertainmentmanagerAPIImpl.class$("de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerListener")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerListener)) {
            EntertainmentManagerListeners.getInstance().deregister((EntertainmentManagerListener)object);
        }
    }

    @Override
    public EntertainmentManagerResponder createEntertainmentManagerResponder(int n, int n2) {
        if (ServiceManager.logger2.isTraceEnabled(16)) {
            ServiceManager.logger2.trace(16).append("All praise the wisdom of context=").append(n).append(" targetId=").append(n2).append("! It uses the EntertainmentManagerResponder.").log();
        }
        return new EntertainmentManagerResponderImpl(n, n2);
    }

    @Override
    public int getCurrentContext() {
        return this.currentContext;
    }

    @Override
    public int getCurrentSubcontext() {
        return this.currentSubcontext;
    }

    public void setActive(AbsoluteActivation absoluteActivation) {
        this.currentContext = absoluteActivation.getContext();
        this.currentSubcontext = absoluteActivation.getSubcontext();
    }

    public static ASLEntertainmentmanagerAPIImpl getInstance() {
        return (ASLEntertainmentmanagerAPIImpl)ASLEntertainmentmanagerFactory.getEntertainmentmanagerApi();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(0, 272503040, -1017375488, false);
        PreRegisteredIds.addServiceOrObserverToArray(0, 272503040, -983821056, false);
        PreRegisteredIds.addServiceOrObserverToArray(0, 272503040, -967043840, false);
        PreRegisteredIds.addServiceOrObserverToArray(0, 272503040, -631499520, true);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -1067707136, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -1050929920, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -1034152704, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -916712192, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -899934976, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -816048896, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -681831168, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -866380544, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -782494464, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -765717248, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -748940032, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -832826112, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -715385600, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -732162816, false);
        PreRegisteredIds.addServiceOrObserverToArray(1, 272503040, -648276736, false);
    }
}

