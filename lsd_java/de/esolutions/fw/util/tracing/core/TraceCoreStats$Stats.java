/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.tracing.core.TraceCoreStats;

class TraceCoreStats$Stats {
    int count;
    int value;
    final int flags;
    private final /* synthetic */ TraceCoreStats this$0;

    public TraceCoreStats$Stats(TraceCoreStats traceCoreStats, int n) {
        this.this$0 = traceCoreStats;
        this.flags = n;
    }

    public void update(int n) {
        ++this.count;
        if ((this.flags & 3) != 0) {
            this.value += n;
        } else if ((this.flags & 8) != 0) {
            if (n > this.value) {
                this.value = n;
            }
        } else {
            this.value = n;
        }
    }

    public int read() {
        int n = 0;
        if ((this.flags & 1) != 0) {
            if (this.count > 0) {
                n = this.value / this.count;
            }
        } else {
            n = this.value;
        }
        if ((this.flags & 4) != 0) {
            this.count = 0;
            this.value = 0;
        }
        return n;
    }
}

