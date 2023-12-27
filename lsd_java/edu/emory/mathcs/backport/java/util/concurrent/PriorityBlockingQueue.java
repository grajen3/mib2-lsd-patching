/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.PriorityQueue;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.PriorityBlockingQueue$Itr;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class PriorityBlockingQueue
extends AbstractQueue
implements BlockingQueue,
Serializable {
    private static final long serialVersionUID;
    private final PriorityQueue q;
    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition notEmpty = this.lock.newCondition();
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$edu$emory$mathcs$backport$java$util$concurrent$PriorityBlockingQueue;

    public PriorityBlockingQueue() {
        this.q = new PriorityQueue();
    }

    public PriorityBlockingQueue(int n) {
        this.q = new PriorityQueue(n, null);
    }

    public PriorityBlockingQueue(int n, Comparator comparator) {
        this.q = new PriorityQueue(n, comparator);
    }

    public PriorityBlockingQueue(Collection collection) {
        this.q = new PriorityQueue(collection);
    }

    @Override
    public boolean add(Object object) {
        return this.offer(object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean offer(Object object) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean bl = this.q.offer(object);
            if (!$assertionsDisabled && !bl) {
                throw new AssertionError();
            }
            this.notEmpty.signal();
            boolean bl2 = true;
            return bl2;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public void put(Object object) {
        this.offer(object);
    }

    @Override
    public boolean offer(Object object, long l, TimeUnit timeUnit) {
        return this.offer(object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object poll() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object object = this.q.poll();
            return object;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object take() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        try {
            try {
                while (this.q.size() == 0) {
                    this.notEmpty.await();
                }
            }
            catch (InterruptedException interruptedException) {
                this.notEmpty.signal();
                throw interruptedException;
            }
            Object object = this.q.poll();
            if (!$assertionsDisabled && object == null) {
                throw new AssertionError();
            }
            Object object2 = object;
            return object2;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public Object poll(long var1_1, TimeUnit var3_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 7[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object peek() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object object = this.q.peek();
            return object;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public Comparator comparator() {
        return this.q.comparator();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int n = this.q.size();
            return n;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public int remainingCapacity() {
        return -129;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(Object object) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean bl = this.q.remove(object);
            return bl;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean contains(Object object) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean bl = this.q.contains(object);
            return bl;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objectArray = this.q.toArray();
            return objectArray;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            String string = this.q.toString();
            return string;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int drainTo(Collection collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object object;
            int n = 0;
            while ((object = this.q.poll()) != null) {
                collection.add(object);
                ++n;
            }
            int n2 = n;
            return n2;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int drainTo(Collection collection, int n) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        if (n <= 0) {
            return 0;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object object;
            int n2;
            for (n2 = 0; n2 < n && (object = this.q.poll()) != null; ++n2) {
                collection.add(object);
            }
            int n3 = n2;
            return n3;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.q.clear();
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray(Object[] objectArray) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objectArray2 = this.q.toArray(objectArray);
            return objectArray2;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public Iterator iterator() {
        return new PriorityBlockingQueue$Itr(this, this.toArray());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void writeObject(ObjectOutputStream objectOutputStream) {
        this.lock.lock();
        try {
            objectOutputStream.defaultWriteObject();
        }
        finally {
            this.lock.unlock();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ReentrantLock access$000(PriorityBlockingQueue priorityBlockingQueue) {
        return priorityBlockingQueue.lock;
    }

    static /* synthetic */ PriorityQueue access$100(PriorityBlockingQueue priorityBlockingQueue) {
        return priorityBlockingQueue.q;
    }

    static {
        $assertionsDisabled = !(class$edu$emory$mathcs$backport$java$util$concurrent$PriorityBlockingQueue == null ? (class$edu$emory$mathcs$backport$java$util$concurrent$PriorityBlockingQueue = PriorityBlockingQueue.class$("edu.emory.mathcs.backport.java.util.concurrent.PriorityBlockingQueue")) : class$edu$emory$mathcs$backport$java$util$concurrent$PriorityBlockingQueue).desiredAssertionStatus();
    }
}

