/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio.dab;

import de.vw.mib.asl.api.radio.Station;

public interface DabEnsemble
extends Station {
    default public int getEnsId() {
    }

    default public int getEnsEcc() {
    }

    default public String getEnsembleShortName() {
    }

    default public String getEnsembleFullName() {
    }

    default public String getFrequencyLabel() {
    }
}

