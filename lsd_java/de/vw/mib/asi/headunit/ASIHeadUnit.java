/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.headunit;

import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.headunit.ASIHeadUnitListener;

public interface ASIHeadUnit
extends ASIService {
    default public ASIHeadUnitListener getASIHeadUnitListener() {
    }

    default public void setASIHeadUnitListener(ASIHeadUnitListener aSIHeadUnitListener) {
    }
}

