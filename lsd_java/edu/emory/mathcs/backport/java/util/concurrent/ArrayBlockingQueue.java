/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.concurrent.ArrayBlockingQueue$Itr;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public class ArrayBlockingQueue
extends AbstractQueue
implements BlockingQueue,
Serializable {
    private static final long serialVersionUID;
    private final Object[] items;
    private int takeIndex;
    private int putIndex;
    private int count;
    private final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    final int inc(int n) {
        return ++n == this.items.length ? 0 : n;
    }

    private void insert(Object object) {
        this.items[this.putIndex] = object;
        this.putIndex = this.inc(this.putIndex);
        ++this.count;
        this.notEmpty.signal();
    }

    private Object extract() {
        Object[] objectArray = this.items;
        Object object = objectArray[this.takeIndex];
        objectArray[this.takeIndex] = null;
        this.takeIndex = this.inc(this.takeIndex);
        --this.count;
        this.notFull.signal();
        return object;
    }

    void removeAt(int n) {
        Object[] objectArray = this.items;
        if (n == this.takeIndex) {
            objectArray[this.takeIndex] = null;
            this.takeIndex = this.inc(this.takeIndex);
        } else {
            int n2;
            while ((n2 = this.inc(n)) != this.putIndex) {
                objectArray[n] = objectArray[n2];
                n = n2;
            }
            objectArray[n] = null;
            this.putIndex = n;
        }
        --this.count;
        this.notFull.signal();
    }

    public ArrayBlockingQueue(int n) {
        this(n, false);
    }

    public ArrayBlockingQueue(int n, boolean bl) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.items = new Object[n];
        this.lock = new ReentrantLock(bl);
        this.notEmpty = this.lock.newCondition();
        this.notFull = this.lock.newCondition();
    }

    public ArrayBlockingQueue(int n, boolean bl, Collection collection) {
        this(n, bl);
        if (n < collection.size()) {
            throw new IllegalArgumentException();
        }
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
    }

    @Override
    public boolean add(Object object) {
        return super.add(object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean offer(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.count == this.items.length) {
                boolean bl = false;
                return bl;
            }
            this.insert(object);
            boolean bl = true;
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
    public void put(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        Object[] objectArray = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        try {
            try {
                while (this.count == objectArray.length) {
                    this.notFull.await();
                }
            }
            catch (InterruptedException interruptedException) {
                this.notFull.signal();
                throw interruptedException;
            }
            this.insert(object);
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public boolean offer(Object var1_1, long var2_2, TimeUnit var4_3) {
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
    public Object poll() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object object;
            if (this.count == 0) {
                Object var2_2 = null;
                return var2_2;
            }
            Object object2 = object = this.extract();
            return object2;
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
            Object object;
            try {
                while (this.count == 0) {
                    this.notEmpty.await();
                }
            }
            catch (InterruptedException interruptedException) {
                this.notEmpty.signal();
                throw interruptedException;
            }
            Object object2 = object = this.extract();
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
            Object object = this.count == 0 ? null : this.items[this.takeIndex];
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
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int n = this.count;
            return n;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int n = this.items.length - this.count;
            return n;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public boolean remove(Object object) {
        if (object == null) {
            return false;
        }
        Object[] objectArray = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int n = this.takeIndex;
            int n2 = 0;
            while (true) {
                if (n2++ >= this.count) {
                    boolean bl = false;
                    return bl;
                }
                if (object.equals(objectArray[n])) {
                    this.removeAt(n);
                    boolean bl = true;
                    return bl;
                }
                n = this.inc(n);
            }
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
        if (object == null) {
            return false;
        }
        Object[] objectArray = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int n = this.takeIndex;
            int n2 = 0;
            while (n2++ < this.count) {
                if (object.equals(objectArray[n])) {
                    boolean bl = true;
                    return bl;
                }
                n = this.inc(n);
            }
            boolean bl = false;
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
        Object[] objectArray = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objectArray2 = new Object[this.count];
            int n = 0;
            int n2 = this.takeIndex;
            while (n < this.count) {
                objectArray2[n++] = objectArray[n2];
                n2 = this.inc(n2);
            }
            Object[] objectArray3 = objectArray2;
            return objectArray3;
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
        Object[] objectArray2 = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (objectArray.length < this.count) {
                objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), this.count);
            }
            int n = 0;
            int n2 = this.takeIndex;
            while (n < this.count) {
                objectArray[n++] = objectArray2[n2];
                n2 = this.inc(n2);
            }
            if (objectArray.length > this.count) {
                objectArray[this.count] = null;
            }
            Object[] objectArray3 = objectArray;
            return objectArray3;
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
            String string = super.toString();
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
    public void clear() {
        Object[] objectArray = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int n = this.takeIndex;
            int n2 = this.count;
            while (n2-- > 0) {
                objectArray[n] = null;
                n = this.inc(n);
            }
            this.count = 0;
            this.putIndex = 0;
            this.takeIndex = 0;
            this.notFull.signalAll();
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
        Object[] objectArray = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int n;
            int n2 = this.takeIndex;
            int n3 = this.count;
            for (n = 0; n < n3; ++n) {
                collection.add(objectArray[n2]);
                objectArray[n2] = null;
                n2 = this.inc(n2);
            }
            if (n > 0) {
                this.count = 0;
                this.putIndex = 0;
                this.takeIndex = 0;
                this.notFull.signalAll();
            }
            int n4 = n;
            return n4;
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
        Object[] objectArray = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int n2;
            int n3;
            int n4 = this.takeIndex;
            int n5 = this.count;
            int n6 = n3 = n < this.count ? n : this.count;
            for (n2 = 0; n2 < n3; ++n2) {
                collection.add(objectArray[n4]);
                objectArray[n4] = null;
                n4 = this.inc(n4);
            }
            if (n2 > 0) {
                this.count -= n2;
                this.takeIndex = n4;
                this.notFull.signalAll();
            }
            int n7 = n2;
            return n7;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator iterator() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            ArrayBlockingQueue$Itr arrayBlockingQueue$Itr = new ArrayBlockingQueue$Itr(this);
            return arrayBlockingQueue$Itr;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    static /* synthetic */ int access$000(ArrayBlockingQueue arrayBlockingQueue) {
        return arrayBlockingQueue.count;
    }

    static /* synthetic */ int access$100(ArrayBlockingQueue arrayBlockingQueue) {
        return arrayBlockingQueue.takeIndex;
    }

    static /* synthetic */ Object[] access$200(ArrayBlockingQueue arrayBlockingQueue) {
        return arrayBlockingQueue.items;
    }

    static /* synthetic */ int access$300(ArrayBlockingQueue arrayBlockingQueue) {
        return arrayBlockingQueue.putIndex;
    }

    static /* synthetic */ ReentrantLock access$400(ArrayBlockingQueue arrayBlockingQueue) {
        return arrayBlockingQueue.lock;
    }
}

