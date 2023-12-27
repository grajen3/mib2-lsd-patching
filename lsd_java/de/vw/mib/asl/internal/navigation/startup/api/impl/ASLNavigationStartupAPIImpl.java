/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup.api.impl;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupAPI;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.startup.NavStartupStatusListener;
import de.vw.mib.asl.api.navigation.startup.NaviTargetDelegator;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.startup.HsmTargetAslEventPrinter;
import de.vw.mib.asl.internal.navigation.startup.HsmTargetNavigation;
import de.vw.mib.asl.internal.navigation.startup.api.impl.ASLNavigationStartupGroups;
import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBase;
import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBaseObserver;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import java.util.Iterator;
import java.util.List;

public class ASLNavigationStartupAPIImpl
implements ASLNavigationStartupAPI,
ASLNavigationContainer,
KnowledgeBaseObserver {
    private IExtLogger LOGGER = null;
    private WeakIdentityHashSet startupStatusListener = new WeakIdentityHashSet();

    public ASLNavigationStartupAPIImpl() {
        ASLNavigationStartupGroups.getInstance().registerContainer(this);
        KnowledgeBase.getInstance().registerObserver(this);
    }

    @Override
    public void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(0, new HsmTargetNavigation(genericEvents, 1548424192, string));
        if (System.getProperty("AslEventPrinter") != null) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviTargetDelegator(new HsmTargetAslEventPrinter(genericEvents, 1800082432, string), string));
        }
    }

    @Override
    public void registerContainer(ASLNavigationContainer aSLNavigationContainer) {
        ASLNavigationStartupGroups.getInstance().registerContainer(aSLNavigationContainer);
    }

    @Override
    public void addTarget(int n, Target target) {
        ASLNavigationStartupGroups.getInstance().addTarget(n, target);
    }

    @Override
    public void addTargets(int n, List list) {
        ASLNavigationStartupGroups.getInstance().addTargets(n, list);
    }

    @Override
    public void sendEvNaviStatusChange(boolean bl) {
        this.getLOGGER().trace("sendEvNaviStatusChange()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(392443136);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    private IExtLogger getLOGGER() {
        if (this.LOGGER == null) {
            this.LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[ASLNavigationStartupAPIImpl]");
        }
        return this.LOGGER;
    }

    @Override
    public boolean isNaviRunning() {
        return KnowledgeBase.getInstance().isNaviRunning() && KnowledgeBase.getInstance().isMainMapReady() && KnowledgeBase.getInstance().getNavStateOfOperation() == 5;
    }

    @Override
    public void registerNavStartupStatusListener(NavStartupStatusListener navStartupStatusListener) {
        this.startupStatusListener.add(navStartupStatusListener);
    }

    @Override
    public void unregisterNavStartupStatusListener(NavStartupStatusListener navStartupStatusListener) {
        this.startupStatusListener.remove(navStartupStatusListener);
    }

    @Override
    public void changed(KnowledgeBase knowledgeBase) {
        Iterator iterator = this.startupStatusListener.iterator();
        while (iterator.hasNext()) {
            NavStartupStatusListener navStartupStatusListener = (NavStartupStatusListener)iterator.next();
            if (navStartupStatusListener == null) continue;
            try {
                navStartupStatusListener.navStartupStatusChanged();
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }
}

