/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.SPI;
import de.vw.mib.timer.spi.TimerSPI;

public class TimerSPIImpl
implements TimerSPI {
    public static boolean CREATE_DEBUG_OUTPUT = false;

    @Override
    public long getSystemTime() {
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(">>TimerSPI::getSystemTime");
        }
        return SPI.timer_get_ticks();
    }

    @Override
    public long getSystemTimeFrequency() {
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(">>TimerSPI::getSystemTimeFrequency");
        }
        return SPI.timer_get_ticks_per_second();
    }

    static {
        System.loadLibrary("mibhighvwspi");
    }
}

