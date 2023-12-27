/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.WeakHashMap;

public final class InvocationContext {
    private static final int MAX_POOL_SIZE;
    private static InvocationContext poolHead;
    private static int poolSize;
    private InvocationContext nextInPool;
    public static final int ROOT_CONTEXT_ID;
    public static final int INITIAL_BRANCH_ID;
    public static final String PROPERTY_ENABLE_INVOCATION_CONTEXT;
    public static final InvocationContext DISABLED_INVOCATION_CONTEXT;
    private static boolean active;
    private static final WeakHashMap THREAD_CONTEXTS;
    private static int nextInvocationId;
    private static int nextBranchId;
    private int invocationId;
    private int branchId;
    private int forkBranchId;
    private boolean setup;
    private WeakReference threadRef;
    static /* synthetic */ Class class$de$vw$mib$log4mib$InvocationContext;

    private static synchronized InvocationContext borrow() {
        InvocationContext invocationContext;
        if (null != poolHead) {
            invocationContext = poolHead;
            poolHead = invocationContext.nextInPool;
            invocationContext.nextInPool = null;
            --poolSize;
        } else {
            invocationContext = new InvocationContext();
        }
        return invocationContext;
    }

    private static synchronized void release(InvocationContext invocationContext) {
        if (poolSize < 10) {
            invocationContext.nextInPool = poolHead;
            poolHead = invocationContext;
            ++poolSize;
        }
    }

    private InvocationContext() {
    }

    private static int getNextInvocationId() {
        return nextInvocationId++ & 0xFFFFFF7F;
    }

    private static int getNextBranchId() {
        return nextBranchId++ & 0xFFFFFF7F;
    }

    private InvocationContext setup(int n, int n2, int n3) {
        this.invocationId = n;
        this.branchId = n2;
        this.forkBranchId = n3;
        this.setup = true;
        return this;
    }

    private void setThread(Thread thread) {
        if (null == this.threadRef || this.threadRef.get() != thread) {
            this.threadRef = new WeakReference(thread);
        }
    }

    private void release() {
        this.setup = false;
        InvocationContext.release(this);
    }

    private boolean isSetup() {
        return this.setup;
    }

    public static boolean isActive() {
        return active;
    }

    public static void setActive(boolean bl) {
        if (active && !bl) {
            Iterator iterator = THREAD_CONTEXTS.values().iterator();
            while (iterator.hasNext()) {
                InvocationContext invocationContext = (InvocationContext)iterator.next();
                if (null == invocationContext) continue;
                iterator.remove();
            }
        }
        active = bl;
    }

    private static synchronized InvocationContext getThreadInvocationContext(Thread thread, boolean bl) {
        InvocationContext invocationContext = (InvocationContext)THREAD_CONTEXTS.get(thread);
        if (null == invocationContext && bl) {
            invocationContext = InvocationContext.borrow();
            THREAD_CONTEXTS.put(thread, invocationContext);
        }
        return invocationContext;
    }

    public static InvocationContext getCurrentInvocationContext(Thread thread) {
        InvocationContext invocationContext;
        if (active) {
            if (null == thread) {
                thread = Thread.currentThread();
            }
            if (!(invocationContext = InvocationContext.getThreadInvocationContext(thread, true)).isSetup()) {
                invocationContext.setup(InvocationContext.getNextInvocationId(), InvocationContext.getNextBranchId(), -1);
                invocationContext.setThread(thread);
            }
        } else {
            invocationContext = DISABLED_INVOCATION_CONTEXT;
        }
        return invocationContext;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void endInvocation(Thread thread) {
        if (active) {
            if (null == thread) {
                thread = Thread.currentThread();
            }
            Class clazz = class$de$vw$mib$log4mib$InvocationContext == null ? (class$de$vw$mib$log4mib$InvocationContext = InvocationContext.class$("de.vw.mib.log4mib.InvocationContext")) : class$de$vw$mib$log4mib$InvocationContext;
            synchronized (clazz) {
                InvocationContext invocationContext = (InvocationContext)THREAD_CONTEXTS.get(thread);
                if (null != invocationContext) {
                    THREAD_CONTEXTS.put(thread, null);
                    invocationContext.release();
                }
            }
        }
    }

    public static void startInvocation(Thread thread) {
        InvocationContext.startSpecificInvocation(InvocationContext.getNextBranchId(), thread);
    }

    public static void startSpecificInvocation(int n, Thread thread) {
        if (active) {
            InvocationContext invocationContext;
            if (null == thread) {
                thread = Thread.currentThread();
            }
            if (!(invocationContext = InvocationContext.getThreadInvocationContext(thread, true)).isSetup()) {
                invocationContext.setThread(thread);
            }
            invocationContext.setup(InvocationContext.getNextInvocationId(), n, n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void startInvocationBranch(InvocationContext invocationContext, Thread thread) {
        if (active && invocationContext != null && invocationContext != DISABLED_INVOCATION_CONTEXT) {
            if (null == thread) {
                thread = Thread.currentThread();
            }
            Class clazz = class$de$vw$mib$log4mib$InvocationContext == null ? (class$de$vw$mib$log4mib$InvocationContext = InvocationContext.class$("de.vw.mib.log4mib.InvocationContext")) : class$de$vw$mib$log4mib$InvocationContext;
            synchronized (clazz) {
                InvocationContext invocationContext2 = (InvocationContext)THREAD_CONTEXTS.get(thread);
                if (null != invocationContext2) {
                    invocationContext2.branchId = invocationContext.branchId;
                    invocationContext2.invocationId = invocationContext.invocationId;
                    invocationContext2.forkBranchId = invocationContext.forkBranchId;
                    invocationContext.release();
                } else {
                    THREAD_CONTEXTS.put(thread, invocationContext);
                    invocationContext.setThread(thread);
                }
            }
        }
    }

    public static void startTriggeredInvocation(Thread thread) {
        InvocationContext.startSpecificInvocation(InvocationContext.getNextBranchId(), thread);
    }

    public InvocationContext copy() {
        InvocationContext invocationContext;
        if (active && this != DISABLED_INVOCATION_CONTEXT) {
            invocationContext = InvocationContext.borrow();
            invocationContext.setup(this.invocationId, this.forkBranchId, this.forkBranchId);
            invocationContext.threadRef = this.threadRef;
        } else {
            invocationContext = DISABLED_INVOCATION_CONTEXT;
        }
        return invocationContext;
    }

    public InvocationContext createBranch() {
        InvocationContext invocationContext;
        this.forkBranchId = InvocationContext.getNextBranchId();
        if (active && this != DISABLED_INVOCATION_CONTEXT) {
            invocationContext = InvocationContext.borrow();
            invocationContext.setup(this.invocationId, this.forkBranchId, this.forkBranchId);
            invocationContext.threadRef = this.threadRef;
        } else {
            invocationContext = DISABLED_INVOCATION_CONTEXT;
        }
        return invocationContext;
    }

    public InvocationContext createSpecificBranch(int n) {
        InvocationContext invocationContext;
        this.forkBranchId = n;
        if (active && this != DISABLED_INVOCATION_CONTEXT) {
            invocationContext = InvocationContext.borrow();
            invocationContext.setup(this.invocationId, n, n);
            invocationContext.threadRef = this.threadRef;
        } else {
            invocationContext = DISABLED_INVOCATION_CONTEXT;
        }
        return invocationContext;
    }

    public int getBranchId() {
        return this.branchId;
    }

    public int getForkBranchId() {
        return this.forkBranchId;
    }

    public int getInvocationId() {
        return this.invocationId;
    }

    public Thread getThread() {
        return null != this.threadRef ? (Thread)this.threadRef.get() : null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        DISABLED_INVOCATION_CONTEXT = new InvocationContext();
        InvocationContext.DISABLED_INVOCATION_CONTEXT.branchId = -1;
        InvocationContext.DISABLED_INVOCATION_CONTEXT.invocationId = -1;
        InvocationContext.DISABLED_INVOCATION_CONTEXT.forkBranchId = -1;
        active = Boolean.getBoolean("de.vw.mib.InvocationContext");
        THREAD_CONTEXTS = new WeakHashMap();
    }
}

