/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.ILifecycleListener;

public final class Lifecycle {
    public static final int STATE_UNBORN;
    public static final int STATE_ALIVE;
    public static final int STATE_DEAD;
    public static final int STATE_ERROR;
    public static final String[] lifecycleNames;
    private int state = 0;
    private ILifecycleListener listener;
    private final Object owner;
    private int errorCode;

    public Lifecycle(Object object) {
        this.owner = object;
    }

    public Object getOwner() {
        return this.owner;
    }

    public synchronized void setListener(ILifecycleListener iLifecycleListener) {
        this.listener = iLifecycleListener;
    }

    public void setAlive() {
        this.setAlive(true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setAlive(boolean bl) {
        boolean bl2 = false;
        Lifecycle lifecycle = this;
        synchronized (lifecycle) {
            if (this.state != 1) {
                this.state = 1;
                bl2 = true;
                super.notifyAll();
            }
        }
        if (bl && this.listener != null && bl2) {
            this.listener.lifecycleChanged(this, this.owner);
        }
    }

    public void setDead() {
        this.setDead(true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setDead(boolean bl) {
        boolean bl2 = false;
        Lifecycle lifecycle = this;
        synchronized (lifecycle) {
            if (this.state != 2) {
                this.state = 2;
                bl2 = true;
                super.notifyAll();
            }
        }
        if (bl && this.listener != null && bl2) {
            this.listener.lifecycleChanged(this, this.owner);
        }
    }

    public void setError(int n) {
        this.setError(n, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setError(int n, boolean bl) {
        boolean bl2 = false;
        Lifecycle lifecycle = this;
        synchronized (lifecycle) {
            if (this.state != 3) {
                this.state = 3;
                bl2 = true;
                this.errorCode = n;
                super.notifyAll();
            }
        }
        if (bl && this.listener != null && bl2) {
            this.listener.lifecycleChanged(this, this.owner);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reincarnate() {
        boolean bl = false;
        Lifecycle lifecycle = this;
        synchronized (lifecycle) {
            if (this.state != 0) {
                this.state = 0;
                bl = true;
                super.notifyAll();
            }
        }
        if (this.listener != null && bl) {
            this.listener.lifecycleChanged(this, this.owner);
        }
    }

    public synchronized boolean isUnborn() {
        return this.state == 0;
    }

    public synchronized boolean isAlive() {
        return this.state == 1;
    }

    public synchronized boolean isDead() {
        return this.state == 2;
    }

    public synchronized boolean isError() {
        return this.state == 3;
    }

    public synchronized int getErrorCode() {
        return this.errorCode;
    }

    public synchronized boolean waitUntilAlive() {
        if (this.state == 1) {
            return true;
        }
        if (this.state != 0) {
            return false;
        }
        while (this.state != 1) {
            if (this.state == 3) {
                return false;
            }
            super.wait();
        }
        return true;
    }

    public synchronized boolean waitUntilDead() {
        if (this.state == 2) {
            return true;
        }
        if (this.state != 1) {
            return false;
        }
        while (this.state != 2) {
            if (this.state == 3) {
                return false;
            }
            super.wait();
        }
        return true;
    }

    public synchronized boolean waitUntilAlive(long l) {
        if (this.state == 1) {
            return true;
        }
        if (this.state != 0) {
            return false;
        }
        super.wait(l);
        return this.state == 1;
    }

    public synchronized boolean waitUntilDead(long l) {
        if (this.state == 2) {
            return true;
        }
        if (this.state != 1) {
            return false;
        }
        super.wait(l);
        return this.state == 2;
    }

    public synchronized int getState() {
        return this.state;
    }

    public synchronized String getStateString() {
        return lifecycleNames[this.state];
    }

    static {
        lifecycleNames = new String[]{"unborn", "alive", "dead", "ERROR"};
    }
}

