/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.threading;

import de.esolutions.fw.util.commons.threading.ThreadPoolWorker;

class ThreadPoolWorker$1
implements Runnable {
    private final /* synthetic */ ThreadPoolWorker this$0;

    ThreadPoolWorker$1(ThreadPoolWorker threadPoolWorker) {
        this.this$0 = threadPoolWorker;
    }

    @Override
    public void run() {
        try {
            ThreadPoolWorker.access$000(this.this$0);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

