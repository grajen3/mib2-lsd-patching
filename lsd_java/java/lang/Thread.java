/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.util.IdentityHashtable;
import com.ibm.oti.util.Msg;
import java.security.AccessControlContext;
import java.security.AccessController;

public class Thread
implements Runnable {
    public static final int MAX_PRIORITY;
    public static final int MIN_PRIORITY;
    public static final int NORM_PRIORITY;
    private static int createCount;
    private static final int NANOS_MAX;
    private static final int INITIAL_LOCAL_STORAGE_CAPACITY;
    static final long NO_REF;
    long threadRef;
    long stackSize = 0L;
    private volatile boolean started;
    private String name = null;
    private int priority = 5;
    private boolean isDaemon = false;
    ThreadGroup threadGroup = null;
    private Runnable runnable = null;
    private Throwable stopThrowable = null;
    private ClassLoader contextClassLoader = null;
    private IdentityHashtable localStorage;
    private AccessControlContext accessControlContext;
    Object lock = new Thread$ThreadLock(null);
    private Object slot1;
    private Object slot2;
    private Object slot3;
    private long longSlot1;
    private Object slot4;
    private static ThreadGroup systemThreadGroup;
    private static ThreadGroup mainGroup;

    static {
        createCount = -1;
    }

    public Thread() {
        this(null, null, Thread.newName());
    }

    private Thread(String string, Object object, int n, boolean bl) {
        this.name = string == null ? Thread.newName() : string;
        this.isDaemon = bl;
        this.priority = n;
        ThreadGroup threadGroup = null;
        boolean bl2 = false;
        if (mainGroup == null) {
            bl2 = true;
            mainGroup = new ThreadGroup(systemThreadGroup);
        }
        threadGroup = object == null ? mainGroup : (ThreadGroup)object;
        this.initialize(bl2, threadGroup, null);
        this.threadGroup.add(this);
        if (bl2) {
            System.completeInitialization();
        }
    }

    void completeInitialization() {
        this.contextClassLoader = ClassLoader.getSystemClassLoader();
    }

    public Thread(Runnable runnable) {
        this(null, runnable, Thread.newName());
    }

    public Thread(Runnable runnable, String string) {
        this(null, runnable, string);
    }

    public Thread(String string) {
        this(null, null, string);
    }

    public Thread(ThreadGroup threadGroup, Runnable runnable) {
        this(threadGroup, runnable, Thread.newName());
    }

    public Thread(ThreadGroup threadGroup, Runnable runnable, String string, long l) {
        this(threadGroup, runnable, string);
        this.stackSize = l;
    }

    public Thread(ThreadGroup threadGroup, Runnable runnable, String string) {
        SecurityManager securityManager;
        if (string == null) {
            throw new NullPointerException();
        }
        this.name = string;
        this.runnable = runnable;
        Thread thread = Thread.currentThread();
        this.isDaemon = thread.isDaemon();
        if (threadGroup == null && (securityManager = System.getSecurityManager()) != null) {
            threadGroup = securityManager.getThreadGroup();
        }
        if (threadGroup == null) {
            threadGroup = thread.getThreadGroup();
        }
        this.initialize(false, threadGroup, thread);
        this.setPriority(thread.getPriority());
    }

    private void initialize(boolean bl, ThreadGroup threadGroup, Thread thread) {
        this.threadGroup = threadGroup;
        if (thread != null) {
            this.initializeLocalStorage(thread);
            this.contextClassLoader = thread.contextClassLoader;
        } else {
            if (bl) {
                ClassLoader.initializeClassLoaders();
            }
            this.contextClassLoader = ClassLoader.getSystemClassLoader();
        }
        threadGroup.checkAccess();
        threadGroup.checkNewThread(this);
        this.accessControlContext = AccessController.getContext();
    }

    public Thread(ThreadGroup threadGroup, String string) {
        this(threadGroup, null, string);
    }

    public static int activeCount() {
        return Thread.currentThread().getThreadGroup().activeCount();
    }

    public final void checkAccess() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkAccess(this);
        }
    }

    public static native Thread currentThread() {
    }

    public void destroy() {
        throw new NoSuchMethodError();
    }

    public static void dumpStack() {
        new Throwable().printStackTrace();
    }

    public static int enumerate(Thread[] threadArray) {
        return Thread.currentThread().getThreadGroup().enumerate(threadArray, true);
    }

    public ClassLoader getContextClassLoader() {
        ClassLoader classLoader;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null && (classLoader = ClassLoader.callerClassLoader()) != null && this.contextClassLoader != classLoader && !classLoader.isAncestorOf(this.contextClassLoader)) {
            securityManager.checkPermission(RuntimePermission.permissionToGetClassLoader);
        }
        return this.contextClassLoader;
    }

    public final String getName() {
        return String.valueOf(this.name);
    }

    public final int getPriority() {
        return this.priority;
    }

    public final ThreadGroup getThreadGroup() {
        return this.threadGroup;
    }

    Object getThreadLocal(ThreadLocal threadLocal) {
        Object object;
        if (this.localStorage == null) {
            this.initializeLocalStorage(5);
            object = IdentityHashtable.ABSENT_FLAG;
        } else {
            object = this.localStorage.get(threadLocal, IdentityHashtable.ABSENT_FLAG);
        }
        if (object == IdentityHashtable.ABSENT_FLAG) {
            object = threadLocal.initialValue();
            this.setThreadLocal(threadLocal, object);
        }
        return object;
    }

    private void initializeLocalStorage(int n) {
        this.localStorage = new IdentityHashtable(n);
    }

    private void initializeLocalStorage(Thread thread) {
        if (thread.localStorage == null) {
            return;
        }
        int n = thread.localStorage.size() / 2;
        if (n < 5) {
            n = 5;
        }
        this.initializeLocalStorage(n);
        Thread$1 thread$1 = new Thread$1(this);
        thread.localStorage.iterate(thread$1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void interrupt() {
        this.checkAccess();
        Object object = this.lock;
        synchronized (object) {
            this.interruptImpl();
        }
    }

    public static native boolean interrupted() {
    }

    private native void interruptImpl() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final boolean isAlive() {
        Object object = this.lock;
        synchronized (object) {
            return this.threadRef != 0L;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean isDead() {
        Object object = this.lock;
        synchronized (object) {
            return this.started && this.threadRef == 0L;
        }
    }

    public final boolean isDaemon() {
        return this.isDaemon;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isInterrupted() {
        Object object = this.lock;
        synchronized (object) {
            return this.isInterruptedImpl();
        }
    }

    private native boolean isInterruptedImpl() {
    }

    public final synchronized void join() {
        if (this.started) {
            while (!this.isDead()) {
                super.wait(0L);
            }
        }
    }

    public final void join(long l) {
        this.join(l, 0);
    }

    public final synchronized void join(long l, int n) {
        if (l < 0L || n < 0 || n > 1061293824) {
            throw new IllegalArgumentException();
        }
        if (!this.started || this.isDead()) {
            return;
        }
        long l2 = 0L;
        long l3 = l;
        boolean bl = false;
        if (l == 0L & n > 0) {
            if (n < 547424000) {
                bl = true;
            } else {
                l3 = 1L;
            }
        }
        while (!bl && !this.isDead()) {
            long l4 = System.currentTimeMillis();
            super.wait(l3);
            long l5 = System.currentTimeMillis() - l4;
            l3 -= l5;
            boolean bl2 = bl = (l2 += l5) >= l;
        }
    }

    private static synchronized String newName() {
        if (createCount == -1) {
            ++createCount;
            return "main";
        }
        return new StringBuffer("Thread-").append(createCount++).toString();
    }

    @Override
    public void run() {
        if (this.runnable != null) {
            this.runnable.run();
        }
    }

    public void setContextClassLoader(ClassLoader classLoader) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(RuntimePermission.permissionToSetContextClassLoader);
        }
        this.contextClassLoader = classLoader;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void setDaemon(boolean bl) {
        this.checkAccess();
        Object object = this.lock;
        synchronized (object) {
            if (!this.started) {
                this.isDaemon = bl;
            } else if (this.isAlive()) {
                throw new IllegalThreadStateException();
            }
        }
    }

    private native void setNameImpl(long l) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void setName(String string) {
        this.checkAccess();
        if (string == null) {
            throw new NullPointerException();
        }
        this.name = string;
        Object object = this.lock;
        synchronized (object) {
            if (this.started && this.threadRef != 0L) {
                this.setNameImpl(this.threadRef);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void setPriority(int n) {
        this.checkAccess();
        if (1 <= n && n <= 10) {
            int n2 = n;
            int n3 = this.getThreadGroup().getMaxPriority();
            if (n3 < n) {
                n2 = n3;
            }
            this.priority = n2;
            Object object = this.lock;
            synchronized (object) {
                if (this.started && this.threadRef != 0L) {
                    this.setPriorityNoVMAccessImpl(this.threadRef, n2);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private native void setPriorityNoVMAccessImpl(long l, int n) {
    }

    void setThreadLocal(ThreadLocal threadLocal, Object object) {
        if (this.localStorage == null) {
            this.initializeLocalStorage(5);
        }
        this.localStorage.put(threadLocal, object);
    }

    public static void sleep(long l) {
        Thread.sleep(l, 0);
    }

    public static native void sleep(long l, int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void start() {
        Object object = this.lock;
        synchronized (object) {
            if (this.started) {
                throw new IllegalThreadStateException(Msg.getString("K0341"));
            }
            boolean bl = false;
            this.threadGroup.add(this);
            try {
                this.startImpl();
                bl = true;
            }
            finally {
                if (!bl) {
                    this.threadGroup.remove(this);
                }
            }
        }
    }

    private native void startImpl() {
    }

    public String toString() {
        return new StringBuffer("Thread[").append(this.getName()).append(",").append(this.getPriority()).append(",").append(this.getThreadGroup() == null ? "" : this.getThreadGroup().getName()).append("]").toString();
    }

    public static native void yield() {
    }

    public static native boolean holdsLock(Object object) {
    }

    private void uncaughtException(Throwable throwable) {
        ThreadGroup threadGroup = this.getThreadGroup();
        if (threadGroup != null) {
            threadGroup.uncaughtException(this, throwable);
        }
    }

    static /* synthetic */ IdentityHashtable access$0(Thread thread) {
        return thread.localStorage;
    }
}

