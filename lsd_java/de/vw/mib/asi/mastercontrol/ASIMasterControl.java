/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.mastercontrol;

import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.mastercontrol.ASIMasterControlListener;

public interface ASIMasterControl
extends ASIService {
    default public ASIMasterControlListener getASIMasterControlListener() {
    }

    default public void setASIMasterControlListener(ASIMasterControlListener aSIMasterControlListener) {
    }
}

