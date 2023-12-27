/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup.guards;

import de.vw.mib.asl.internal.navigation.startup.guards.Guard;
import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBase;

public class NaviGuardRemaining
implements Guard {
    @Override
    public boolean checkGreenToYellowGuard(KnowledgeBase knowledgeBase) {
        return false;
    }

    @Override
    public boolean checkYellowToRedGuard(KnowledgeBase knowledgeBase) {
        return false;
    }

    private boolean remainingGroupGuard(KnowledgeBase knowledgeBase) {
        return knowledgeBase.isGreen(0) && knowledgeBase.isGreen(1) && knowledgeBase.isGreen(2) && knowledgeBase.isGreen(3);
    }

    @Override
    public boolean checkRedToYellowGuard(KnowledgeBase knowledgeBase) {
        return this.remainingGroupGuard(knowledgeBase);
    }

    @Override
    public boolean checkYellowToGreenGuard(KnowledgeBase knowledgeBase) {
        return this.remainingGroupGuard(knowledgeBase);
    }
}

