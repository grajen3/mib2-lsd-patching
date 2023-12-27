/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.helper.trace.debugprobe;

public class DebugProbe
implements Comparable {
    private final int mIndex;
    private final String mName;
    private boolean mActive = false;

    public DebugProbe(String string, int n) {
        this.mIndex = n;
        this.mName = string;
    }

    public void setActive(boolean bl) {
        this.mActive = bl;
    }

    public boolean isActive() {
        return this.mActive;
    }

    public String getName() {
        String string = "";
        if (this.mName != null) {
            string = new StringBuffer().append(this.mName).append(" (").append(this.mIndex).append(")").toString();
        }
        return string;
    }

    @Override
    public int compareTo(Object object) {
        DebugProbe debugProbe = (DebugProbe)object;
        if (this.mIndex < debugProbe.mIndex) {
            return -1;
        }
        if (this.mIndex > debugProbe.mIndex) {
            return 1;
        }
        return 0;
    }

    public int getIndex() {
        return this.mIndex;
    }
}

