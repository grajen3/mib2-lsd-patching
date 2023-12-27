/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.lang;

import com.ibm.oti.lang.ProcessInputStream;
import com.ibm.oti.lang.ProcessOutputStream;
import com.ibm.oti.lang.SystemProcess;
import com.ibm.oti.util.Util;
import java.io.File;
import java.io.IOException;

final class SystemProcess$1
implements Runnable {
    private final /* synthetic */ SystemProcess val$p;
    private final /* synthetic */ byte[][] val$progBytes;
    private final /* synthetic */ byte[][] val$envBytes;
    private final /* synthetic */ File val$directory;

    SystemProcess$1(SystemProcess systemProcess, byte[][] byArray, byte[][] byArray2, File file) {
        this.val$p = systemProcess;
        this.val$progBytes = byArray;
        this.val$envBytes = byArray2;
        this.val$directory = file;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        long[] lArray = null;
        try {
            lArray = SystemProcess.createImpl(this.val$p, this.val$progBytes, this.val$envBytes, this.val$directory == null ? null : Util.getBytes(this.val$directory.getPath()));
        }
        catch (Throwable throwable) {
            Object object = this.val$p.lock;
            synchronized (object) {
                this.val$p.exception = throwable;
                this.val$p.waiterStarted = true;
                this.val$p.lock.notifyAll();
            }
            return;
        }
        this.val$p.handle = lArray[0];
        this.val$p.in = new ProcessOutputStream(lArray[1]);
        this.val$p.out = new ProcessInputStream(lArray[2]);
        this.val$p.err = new ProcessInputStream(lArray[3]);
        Object object = this.val$p.lock;
        synchronized (object) {
            this.val$p.waiterStarted = true;
            this.val$p.lock.notifyAll();
        }
        this.val$p.exitCode = this.val$p.waitForCompletionImpl();
        object = this.val$p.lock;
        synchronized (object) {
            this.val$p.closeImpl();
            this.val$p.handle = -1L;
            this.val$p.exitCodeAvailable = true;
            try {
                this.val$p.in.close();
            }
            catch (IOException iOException) {}
            this.val$p.lock.notifyAll();
        }
    }
}

