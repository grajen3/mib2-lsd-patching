/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.util.Msg;

public class ThreadGroup {
    private String name;
    private int maxPriority = 10;
    ThreadGroup parent = null;
    int numThreads = 0;
    private Thread[] childrenThreads = new Thread[5];
    int numGroups = 0;
    private ThreadGroup[] childrenGroups = new ThreadGroup[3];
    private Object childrenGroupsLock = new ThreadGroup$ChildrenGroupsLock();
    private Object childrenThreadsLock = new ThreadGroup$ChildrenThreadsLock();
    private boolean isDaemon = false;
    private boolean isDestroyed = false;
    private int addedNotStartedThreads = 0;
    private long memorySpace;

    private ThreadGroup() {
        this.name = "system";
    }

    public ThreadGroup(String string) {
        this(Thread.currentThread().getThreadGroup(), string);
    }

    public ThreadGroup(ThreadGroup threadGroup, String string) {
        if (Thread.currentThread() != null) {
            threadGroup.checkAccess();
        }
        this.name = string;
        this.setParent(threadGroup);
        if (threadGroup != null) {
            this.setMaxPriority(threadGroup.getMaxPriority());
            if (threadGroup.isDaemon()) {
                this.setDaemon(true);
            }
        }
    }

    ThreadGroup(ThreadGroup threadGroup) {
        this.name = "main";
        this.setParent(threadGroup);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int activeCount() {
        int n;
        int n2 = 0;
        Object object = this.childrenThreadsLock;
        synchronized (object) {
            n = this.numThreads;
            while (--n >= 0) {
                if (!this.childrenThreads[n].isAlive()) continue;
                ++n2;
            }
        }
        object = this.childrenGroupsLock;
        synchronized (object) {
            n = 0;
            while (n < this.numGroups) {
                n2 += this.childrenGroups[n].activeCount();
                ++n;
            }
        }
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int activeGroupCount() {
        int n = 0;
        Object object = this.childrenGroupsLock;
        synchronized (object) {
            int n2 = 0;
            while (n2 < this.numGroups) {
                n += 1 + this.childrenGroups[n2].activeGroupCount();
                ++n2;
            }
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final void checkNewThread(Thread thread) {
        Object object = this.childrenThreadsLock;
        synchronized (object) {
            if (this.isDestroyed) {
                throw new IllegalThreadStateException();
            }
            ++this.addedNotStartedThreads;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final void add(Thread thread) {
        Object object = this.childrenThreadsLock;
        synchronized (object) {
            if (!this.isDestroyed) {
                if (this.childrenThreads.length == this.numThreads) {
                    Thread[] threadArray = new Thread[this.childrenThreads.length * 2];
                    System.arraycopy((Object)this.childrenThreads, 0, (Object)threadArray, 0, this.numThreads);
                    threadArray[this.numThreads++] = thread;
                    this.childrenThreads = threadArray;
                } else {
                    this.childrenThreads[this.numThreads++] = thread;
                }
                --this.addedNotStartedThreads;
            } else {
                throw new IllegalThreadStateException();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void add(ThreadGroup threadGroup) {
        Object object = this.childrenGroupsLock;
        synchronized (object) {
            if (!this.isDestroyed) {
                if (this.childrenGroups.length == this.numGroups) {
                    ThreadGroup[] threadGroupArray = new ThreadGroup[this.childrenGroups.length * 2];
                    System.arraycopy((Object)this.childrenGroups, 0, (Object)threadGroupArray, 0, this.numGroups);
                    threadGroupArray[this.numGroups++] = threadGroup;
                    this.childrenGroups = threadGroupArray;
                } else {
                    this.childrenGroups[this.numGroups++] = threadGroup;
                }
            } else {
                throw new IllegalThreadStateException();
            }
        }
    }

    public final void checkAccess() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkAccess(this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void destroy() {
        this.checkAccess();
        Object object = this.childrenThreadsLock;
        synchronized (object) {
            Object object2 = this.childrenGroupsLock;
            synchronized (object2) {
                if (this.isDestroyed) {
                    throw new IllegalThreadStateException(Msg.getString("K0056"));
                }
                if (this.numThreads > 0) {
                    throw new IllegalThreadStateException(Msg.getString("K0057"));
                }
                int n = this.numGroups;
                int n2 = 0;
                while (n2 < n) {
                    this.childrenGroups[0].destroy();
                    ++n2;
                }
                if (this.parent != null) {
                    this.parent.remove(this);
                }
                this.isDestroyed = true;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void destroyIfEmptyDaemon() {
        Object object = this.childrenThreadsLock;
        synchronized (object) {
            if (this.isDaemon && !this.isDestroyed && this.addedNotStartedThreads == 0 && this.numThreads == 0) {
                Object object2 = this.childrenGroupsLock;
                synchronized (object2) {
                    if (this.numGroups == 0) {
                        this.destroy();
                    }
                }
            }
        }
    }

    public int enumerate(Thread[] threadArray) {
        return this.enumerate(threadArray, true);
    }

    public int enumerate(Thread[] threadArray, boolean bl) {
        return this.enumerateGeneric(threadArray, bl, 0, true);
    }

    public int enumerate(ThreadGroup[] threadGroupArray) {
        return this.enumerate(threadGroupArray, true);
    }

    public int enumerate(ThreadGroup[] threadGroupArray, boolean bl) {
        return this.enumerateGeneric(threadGroupArray, bl, 0, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int enumerateGeneric(Object[] objectArray, boolean bl, int n, boolean bl2) {
        Object object;
        this.checkAccess();
        Object object2 = object = bl2 ? this.childrenThreadsLock : this.childrenGroupsLock;
        synchronized (object2) {
            Object[] objectArray2 = bl2 ? this.childrenThreads : this.childrenGroups;
            int n2 = bl2 ? this.numThreads : this.numGroups;
            while (--n2 >= 0) {
                if (bl2 && !((Thread)objectArray2[n2]).isAlive()) continue;
                if (n >= objectArray.length) {
                    return n;
                }
                objectArray[n++] = objectArray2[n2];
            }
        }
        if (bl) {
            object2 = this.childrenGroupsLock;
            synchronized (object2) {
                int n3 = 0;
                while (n3 < this.numGroups) {
                    if (n >= objectArray.length) {
                        return n;
                    }
                    n = this.childrenGroups[n3].enumerateGeneric(objectArray, bl, n, bl2);
                    ++n3;
                }
            }
        }
        return n;
    }

    public final int getMaxPriority() {
        return this.maxPriority;
    }

    public final String getName() {
        return this.name;
    }

    public final ThreadGroup getParent() {
        if (this.parent != null) {
            this.parent.checkAccess();
        }
        return this.parent;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void interrupt() {
        int n;
        this.checkAccess();
        Object object = this.childrenThreadsLock;
        synchronized (object) {
            n = 0;
            while (n < this.numThreads) {
                this.childrenThreads[n].interrupt();
                ++n;
            }
        }
        object = this.childrenGroupsLock;
        synchronized (object) {
            n = 0;
            while (n < this.numGroups) {
                this.childrenGroups[n].interrupt();
                ++n;
            }
        }
    }

    public final boolean isDaemon() {
        return this.isDaemon;
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    public void list() {
        System.out.println();
        this.list(0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void list(int n) {
        int n2;
        int n3 = 0;
        while (n3 < n) {
            System.out.print("    ");
            ++n3;
        }
        System.out.println(this.toString());
        Object object = this.childrenThreadsLock;
        synchronized (object) {
            n2 = 0;
            while (n2 < this.numThreads) {
                int n4 = 0;
                while (n4 <= n) {
                    System.out.print("    ");
                    ++n4;
                }
                System.out.println(this.childrenThreads[n2]);
                ++n2;
            }
        }
        object = this.childrenGroupsLock;
        synchronized (object) {
            n2 = 0;
            while (n2 < this.numGroups) {
                this.childrenGroups[n2].list(n + 1);
                ++n2;
            }
        }
    }

    public final boolean parentOf(ThreadGroup threadGroup) {
        while (threadGroup != null) {
            if (this == threadGroup) {
                return true;
            }
            threadGroup = threadGroup.parent;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final void remove(Thread thread) {
        Object object = this.childrenThreadsLock;
        synchronized (object) {
            int n = 0;
            while (n < this.numThreads) {
                if (this.childrenThreads[n] == thread) {
                    --this.numThreads;
                    System.arraycopy((Object)this.childrenThreads, n + 1, (Object)this.childrenThreads, n, this.numThreads - n);
                    this.childrenThreads[this.numThreads] = null;
                    break;
                }
                ++n;
            }
            if (this.numThreads == 0) {
                ThreadGroup threadGroup = this;
                synchronized (threadGroup) {
                    super.notifyAll();
                }
            }
        }
        this.destroyIfEmptyDaemon();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void remove(ThreadGroup threadGroup) {
        Object object = this.childrenGroupsLock;
        synchronized (object) {
            int n = 0;
            while (n < this.numGroups) {
                if (this.childrenGroups[n] == threadGroup) {
                    --this.numGroups;
                    System.arraycopy((Object)this.childrenGroups, n + 1, (Object)this.childrenGroups, n, this.numGroups - n);
                    this.childrenGroups[this.numGroups] = null;
                    break;
                }
                ++n;
            }
        }
        this.destroyIfEmptyDaemon();
    }

    public final void setDaemon(boolean bl) {
        this.checkAccess();
        this.isDaemon = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void setMaxPriority(int n) {
        this.checkAccess();
        if (n <= this.maxPriority) {
            if (n < 1) {
                n = 1;
            }
            int n2 = this.parent == null ? n : this.parent.getMaxPriority();
            this.maxPriority = n2 <= n ? n2 : n;
            Object object = this.childrenGroupsLock;
            synchronized (object) {
                int n3 = 0;
                while (n3 < this.numGroups) {
                    this.childrenGroups[n3].setMaxPriority(n);
                    ++n3;
                }
            }
        }
    }

    private void setParent(ThreadGroup threadGroup) {
        if (threadGroup != null) {
            threadGroup.add(this);
        }
        this.parent = threadGroup;
    }

    public String toString() {
        return new StringBuffer(String.valueOf(super.getClass().getName())).append("[name=").append(this.getName()).append(",maxpri=").append(this.getMaxPriority()).append("]").toString();
    }

    public void uncaughtException(Thread thread, Throwable throwable) {
        if (this.parent != null) {
            this.parent.uncaughtException(thread, throwable);
        } else if (!(throwable instanceof ThreadDeath)) {
            System.err.print(Msg.getString("K0319", thread.getName()));
            throwable.printStackTrace(System.err);
        }
    }
}

