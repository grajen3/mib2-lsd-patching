/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util.semaphore;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.semaphore.CreateSemaphorePermission;
import java.util.Hashtable;

abstract class Semaphore {
    private static Hashtable existingSemaphores = new Hashtable();
    private String name = null;
    private static long semaphoreHandle = 0L;

    private static native long init(String string, int n) {
    }

    private static native void closeSemaphore(long l) {
    }

    private static native boolean waitOnSemaphore(long l) {
    }

    private static native boolean postOnSemaphore(long l) {
    }

    Semaphore(String string, int n) {
        this.initializeSemaphore(string, n);
    }

    Semaphore() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void initializeSemaphore(String string, int n) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(CreateSemaphorePermission.CreateSemaphorePermission);
        }
        Hashtable hashtable = existingSemaphores;
        synchronized (hashtable) {
            if (existingSemaphores.containsKey(string)) {
                throw new IllegalArgumentException(Msg.getString("K037c"));
            }
            existingSemaphores.put(string, string);
            semaphoreHandle = Semaphore.init(string, n);
            if (semaphoreHandle == 0L) {
                throw new RuntimeException(Msg.getString("K0353"));
            }
            this.name = string;
        }
    }

    public boolean waitSemaphore() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(CreateSemaphorePermission.CreateSemaphorePermission);
        }
        if (semaphoreHandle != 0L) {
            return Semaphore.waitOnSemaphore(semaphoreHandle);
        }
        throw new IllegalStateException(Msg.getString("K0352"));
    }

    public boolean postSemaphore() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(CreateSemaphorePermission.CreateSemaphorePermission);
        }
        if (semaphoreHandle != 0L) {
            return Semaphore.postOnSemaphore(semaphoreHandle);
        }
        throw new IllegalStateException(Msg.getString("K0352"));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(CreateSemaphorePermission.CreateSemaphorePermission);
        }
        Hashtable hashtable = existingSemaphores;
        synchronized (hashtable) {
            if (semaphoreHandle != 0L) {
                if (existingSemaphores.containsKey(this.name)) {
                    existingSemaphores.remove(this.name);
                }
            } else {
                throw new IllegalStateException(Msg.getString("K0352"));
            }
            Semaphore.closeSemaphore(semaphoreHandle);
            semaphoreHandle = 0L;
        }
    }

    protected void finalize() {
        this.close();
    }
}

