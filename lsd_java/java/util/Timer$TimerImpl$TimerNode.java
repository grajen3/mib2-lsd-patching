/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.TimerTask;

final class Timer$TimerImpl$TimerNode {
    Timer$TimerImpl$TimerNode parent;
    Timer$TimerImpl$TimerNode left;
    Timer$TimerImpl$TimerNode right;
    TimerTask task;

    public Timer$TimerImpl$TimerNode(TimerTask timerTask) {
        this.task = timerTask;
    }
}

