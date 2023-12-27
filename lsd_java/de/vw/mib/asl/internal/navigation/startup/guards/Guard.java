/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup.guards;

import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBase;

public interface Guard {
    default public boolean checkRedToYellowGuard(KnowledgeBase knowledgeBase) {
    }

    default public boolean checkYellowToGreenGuard(KnowledgeBase knowledgeBase) {
    }

    default public boolean checkGreenToYellowGuard(KnowledgeBase knowledgeBase) {
    }

    default public boolean checkYellowToRedGuard(KnowledgeBase knowledgeBase) {
    }
}

