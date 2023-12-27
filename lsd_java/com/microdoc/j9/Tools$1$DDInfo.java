/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9;

import com.microdoc.j9.ThreadInfo;

class Tools$1$DDInfo {
    ThreadInfo fThreadInfo;
    int fVisited = -1;
    boolean fDeadlocked = false;

    public Tools$1$DDInfo(ThreadInfo threadInfo) {
        this.fThreadInfo = threadInfo;
    }

    public boolean isBlocked() {
        int n = this.fThreadInfo.getStatus();
        return n == 1 || n == 2;
    }
}

