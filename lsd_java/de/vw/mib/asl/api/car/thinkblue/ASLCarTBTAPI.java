/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.thinkblue;

import de.vw.mib.asl.api.car.thinkblue.TBTService;
import de.vw.mib.asl.api.car.thinkblue.TBTServiceListener;

public interface ASLCarTBTAPI {
    default public TBTService getTBTService() {
    }

    default public void addTBTServiceListener(TBTServiceListener tBTServiceListener) {
    }

    default public void removeTBTServiceListener(TBTServiceListener tBTServiceListener) {
    }
}

