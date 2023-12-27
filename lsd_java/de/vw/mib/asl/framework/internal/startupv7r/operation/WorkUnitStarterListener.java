/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;

public interface WorkUnitStarterListener {
    default public void onWorkUnitAboutToStart(AbstractWorkUnit abstractWorkUnit) {
    }

    default public void onWorkUnitCompleted(AbstractWorkUnit abstractWorkUnit) {
    }
}

