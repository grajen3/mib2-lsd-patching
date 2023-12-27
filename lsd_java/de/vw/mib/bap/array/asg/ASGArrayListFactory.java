/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg;

import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public interface ASGArrayListFactory {
    default public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
    }

    default public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
    }

    default public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
    }

    default public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
    }

    default public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
    }
}

