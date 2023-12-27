/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.exboxm.guidance;

import de.vw.mib.asl.api.exboxm.guidance.GuidanceState;

public interface ExboxGuidanceListener {
    default public void onExboxGuidanceStateChanged(GuidanceState guidanceState) {
    }
}

