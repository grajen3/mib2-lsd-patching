/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.framework4u;

import de.vw.mib.framework4u.Algorithms;
import de.vw.mib.framework4u.DataStructures;
import de.vw.mib.framework4u.Framework4U$1;
import de.vw.mib.framework4u.System;
import de.vw.mib.timer.spi.TimerSPI;

public class Framework4U {
    private static final long FACTOR;
    public final Algorithms algo;
    public final DataStructures data;
    public final System system;

    Framework4U() {
        Framework4U$1 framework4U$1 = new Framework4U$1(this);
        this.algo = new Algorithms();
        this.data = new DataStructures();
        this.system = new System(framework4U$1);
    }

    Framework4U(TimerSPI timerSPI) {
        this.algo = new Algorithms();
        this.data = new DataStructures();
        this.system = new System(timerSPI);
    }
}

