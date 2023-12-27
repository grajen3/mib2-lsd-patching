/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.controller;

import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public interface TemporyTargetDelegate {
    default public Hsm getHsm() {
    }

    default public HsmState getDefaultState() {
    }
}

