/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common;

import de.vw.mib.asl.internal.ocu.common.HsmContextDelegate;
import de.vw.mib.genericevents.hsm.Hsm;

public interface HsmContext {
    default public HsmContextDelegate getContextDelegate() {
    }

    default public Hsm getHsm() {
    }
}

