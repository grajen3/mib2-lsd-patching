/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap.lcu;

import de.vw.mib.asl.api.bap.lcu.BAPLogicalControlUnit;
import de.vw.mib.asl.api.bap.lcu.ControlUnitState;

public interface BAPFunctionControlUnit
extends BAPLogicalControlUnit {
    default public void activateTransition() {
    }

    default public ControlUnitState getcurrentState() {
    }
}

