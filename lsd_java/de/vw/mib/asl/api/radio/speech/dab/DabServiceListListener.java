/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio.speech.dab;

import de.vw.mib.asl.api.radio.dab.DabService;

public interface DabServiceListListener {
    default public void updateServiceList(DabService[] dabServiceArray) {
    }
}

