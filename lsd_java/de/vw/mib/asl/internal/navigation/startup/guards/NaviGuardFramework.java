/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup.guards;

import de.vw.mib.asl.internal.navigation.startup.guards.Guard;
import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBase;

public class NaviGuardFramework
implements Guard {
    @Override
    public boolean checkGreenToYellowGuard(KnowledgeBase knowledgeBase) {
        return false;
    }

    @Override
    public boolean checkYellowToRedGuard(KnowledgeBase knowledgeBase) {
        return false;
    }

    @Override
    public boolean checkRedToYellowGuard(KnowledgeBase knowledgeBase) {
        return knowledgeBase.getNavStateOfOperation() == 5 && knowledgeBase.getNavDomainState() == 4 && knowledgeBase.isYellow(1);
    }

    @Override
    public boolean checkYellowToGreenGuard(KnowledgeBase knowledgeBase) {
        return knowledgeBase.getNavStateOfOperation() == 5 && knowledgeBase.getNavDomainState() == 4 && knowledgeBase.isYellow(1) && knowledgeBase.isGreen(2);
    }
}

