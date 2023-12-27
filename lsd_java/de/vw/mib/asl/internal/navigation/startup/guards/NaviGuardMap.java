/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup.guards;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.startup.guards.Guard;
import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBase;

public class NaviGuardMap
implements Guard {
    @Override
    public boolean checkGreenToYellowGuard(KnowledgeBase knowledgeBase) {
        return false;
    }

    @Override
    public boolean checkYellowToRedGuard(KnowledgeBase knowledgeBase) {
        return false;
    }

    private boolean mapGroupGuard(KnowledgeBase knowledgeBase) {
        return knowledgeBase.isMainMapReady() && (knowledgeBase.isMapInMapReady() || !ServiceManager.configManagerDiag.getNaviCommonOptionDefaultBoolean(8)) && knowledgeBase.getNavStateOfOperation() == 5 && knowledgeBase.getNavDomainState() == 4 && knowledgeBase.isGreen(1) && knowledgeBase.isGreen(0) && knowledgeBase.isGreen(2);
    }

    @Override
    public boolean checkRedToYellowGuard(KnowledgeBase knowledgeBase) {
        return this.mapGroupGuard(knowledgeBase);
    }

    @Override
    public boolean checkYellowToGreenGuard(KnowledgeBase knowledgeBase) {
        return this.mapGroupGuard(knowledgeBase);
    }
}

