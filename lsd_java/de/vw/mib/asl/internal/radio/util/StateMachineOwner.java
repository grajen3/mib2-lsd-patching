/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.util;

import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.DSIAMFMTuner;
import org.dsi.ifc.sdars.DSISDARSTuner;

public interface StateMachineOwner {
    default public Hsm getHsm() {
    }

    default public AbstractTarget getTarget() {
    }

    default public HsmState getIdleState() {
    }

    default public DSISDARSTuner getSdarsTuner() {
    }

    default public void debugOut(String string) {
    }

    default public int getTimeoutEventId() {
    }

    default public int getTargetId() {
    }

    default public EventGeneric getCurrentEvent() {
    }

    default public DSIAMFMTuner getAmfmTuner() {
    }
}

