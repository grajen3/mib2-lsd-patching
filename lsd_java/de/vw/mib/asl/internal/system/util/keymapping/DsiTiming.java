/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.util.keymapping;

import de.vw.mib.util.StringBuilder;

public class DsiTiming {
    private int longPressTime;
    private int ultraLongPressTime;

    public DsiTiming() {
        this.longPressTime = 5000;
        this.ultraLongPressTime = 5000;
    }

    public DsiTiming(int n, int n2) {
        this.longPressTime = n;
        this.ultraLongPressTime = n2;
    }

    public int getLongPressTime() {
        return this.longPressTime;
    }

    public int getUltraLongPressTime() {
        return this.ultraLongPressTime;
    }

    public String toString() {
        return new StringBuilder().append("DsiTiming [ longPressTime=").append(this.longPressTime).append(", ultraLongPressTime=").append(this.ultraLongPressTime).append("]").toString();
    }
}

