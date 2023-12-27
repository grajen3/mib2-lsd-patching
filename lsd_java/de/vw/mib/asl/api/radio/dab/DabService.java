/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio.dab;

import de.vw.mib.asl.api.radio.Station;
import de.vw.mib.asl.api.radio.dab.DabEnsemble;

public interface DabService
extends DabEnsemble,
Station {
    default public long getSid() {
    }

    default public String getComponentName() {
    }

    default public int getScidi() {
    }
}

