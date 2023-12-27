/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup.knowledge;

import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBase;

public interface KnowledgeBaseObserver {
    default public void changed(KnowledgeBase knowledgeBase) {
    }
}

