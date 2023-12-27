/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.lang;

import com.ibm.oti.lang.SystemProcess$1;
import com.ibm.oti.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SystemProcess
extends Process {
    InputStream err;
    InputStream out;
    OutputStream in;
    long handle = -1L;
    boolean exitCodeAvailable = false;
    int exitCode;
    Object lock;
    boolean waiterStarted = false;
    Throwable exception = null;

    static {
        SystemProcess.oneTimeInitialization();
    }

    private static native void oneTimeInitialization() {
    }

    private SystemProcess() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Process create(String[] stringArray, String[] stringArray2, File file) {
        byte[][] byArray = new byte[stringArray.length][];
        int n = 0;
        while (n < stringArray.length) {
            byArray[n] = Util.getBytes(stringArray[n]);
            ++n;
        }
        byte[][] byArray2 = new byte[stringArray2.length][];
        n = 0;
        while (n < stringArray2.length) {
            byArray2[n] = Util.getBytes(stringArray2[n]);
            ++n;
        }
        SystemProcess systemProcess = new SystemProcess();
        systemProcess.lock = new Object();
        SystemProcess$1 systemProcess$1 = new SystemProcess$1(systemProcess, byArray, byArray2, file);
        Thread thread = new Thread(systemProcess$1);
        thread.setDaemon(true);
        thread.start();
        Object object = systemProcess.lock;
        synchronized (object) {
            boolean bl = false;
            while (!systemProcess.waiterStarted) {
                try {
                    systemProcess.lock.wait();
                }
                catch (InterruptedException interruptedException) {
                    bl = true;
                }
            }
            if (bl) {
                Thread.currentThread().interrupt();
            }
            if (systemProcess.exception != null) {
                systemProcess.exception.fillInStackTrace();
                if (systemProcess.exception instanceof IOException) {
                    throw (IOException)systemProcess.exception;
                }
                if (systemProcess.exception instanceof Error) {
                    throw (Error)systemProcess.exception;
                }
                throw (RuntimeException)systemProcess.exception;
            }
        }
        return systemProcess;
    }

    protected static synchronized native long[] createImpl(Process process, byte[][] byArray, byte[][] byArray2, byte[] byArray3) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void destroy() {
        Object object = this.lock;
        synchronized (object) {
            if (this.handle != -1L) {
                this.destroyImpl();
            }
        }
    }

    private native void destroyImpl() {
    }

    native void closeImpl() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int exitValue() {
        Object object = this.lock;
        synchronized (object) {
            if (!this.exitCodeAvailable) {
                throw new IllegalThreadStateException();
            }
            return this.exitCode;
        }
    }

    @Override
    public InputStream getErrorStream() {
        return this.err;
    }

    @Override
    public InputStream getInputStream() {
        return this.out;
    }

    @Override
    public OutputStream getOutputStream() {
        return this.in;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int waitFor() {
        Object object = this.lock;
        synchronized (object) {
            while (!this.exitCodeAvailable) {
                this.lock.wait();
            }
            return this.exitCode;
        }
    }

    native int waitForCompletionImpl() {
    }
}

