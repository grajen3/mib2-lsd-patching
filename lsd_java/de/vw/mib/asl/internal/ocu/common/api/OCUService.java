/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api;

import de.vw.mib.bap.marshalling.BAPService;
import org.dsi.ifc.bap.DSIBAPListener;

public interface OCUService
extends DSIBAPListener,
BAPService {
    default public void initialize() {
    }

    default public void stateEntry() {
    }

    default public void stateStart() {
    }

    default public void stateExit() {
    }
}

