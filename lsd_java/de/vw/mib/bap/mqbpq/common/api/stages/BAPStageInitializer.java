/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.stages;

import de.vw.mib.asl.api.bap.timer.Timer;
import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.mqbpq.common.api.adapter.LanguageUtil;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;

public interface BAPStageInitializer {
    default public void observeAslPropertiesAndLists(BAPStage bAPStage, int[] nArray, int[] nArray2, int n) {
    }

    default public void observeHMIEvents(BAPStage bAPStage, int[] nArray) {
    }

    default public void registerForPersistenceAvailability(BAPStage bAPStage) {
    }

    default public Timer createTimer(BAPStage bAPStage, TimerNotifier timerNotifier, long l, int n) {
    }

    default public LanguageUtil createLanguageUtil(BAPStage bAPStage) {
    }
}

