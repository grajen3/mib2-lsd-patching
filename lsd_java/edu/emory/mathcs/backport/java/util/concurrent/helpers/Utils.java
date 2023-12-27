/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.helpers;

import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.NanoTimer;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils$1;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils$MillisProvider;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils$SunPerfProvider;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import java.lang.reflect.Array;
import java.security.AccessController;
import java.util.Collection;
import java.util.Iterator;

public final class Utils {
    private static final NanoTimer nanoTimer;
    private static final String providerProp;
    static /* synthetic */ Class array$Ljava$lang$Object;

    private Utils() {
    }

    public static long nanoTime() {
        return nanoTimer.nanoTime();
    }

    public static long awaitNanos(Condition condition, long l) {
        if (l <= 0L) {
            return l;
        }
        long l2 = Utils.nanoTime();
        condition.await(l, TimeUnit.NANOSECONDS);
        return l - (Utils.nanoTime() - l2);
    }

    private static long gcd(long l, long l2) {
        while (l2 > 0L) {
            long l3 = l % l2;
            l = l2;
            l2 = l3;
        }
        return l;
    }

    public static Object[] collectionToArray(Collection collection) {
        int n = collection.size();
        Object[] objectArray = new Object[n];
        Iterator iterator = collection.iterator();
        int n2 = 0;
        while (true) {
            if (n2 < n && iterator.hasNext()) {
                objectArray[n2++] = iterator.next();
                continue;
            }
            if (!iterator.hasNext()) {
                if (n2 == n) {
                    return objectArray;
                }
                return Arrays.copyOf(objectArray, n2, array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = Utils.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object);
            }
            int n3 = (objectArray.length / 2 + 1) * 3;
            if (n3 < objectArray.length) {
                if (objectArray.length < -129) {
                    n3 = -129;
                } else {
                    throw new OutOfMemoryError("required array size too large");
                }
            }
            objectArray = Arrays.copyOf(objectArray, n3, array$Ljava$lang$Object == null ? Utils.class$("[Ljava.lang.Object;") : array$Ljava$lang$Object);
            n = n3;
        }
    }

    public static Object[] collectionToArray(Collection collection, Object[] objectArray) {
        Class clazz = super.getClass();
        int n = collection.size();
        Object[] objectArray2 = objectArray.length >= n ? objectArray : (Object[])Array.newInstance(clazz.getComponentType(), n);
        Iterator iterator = collection.iterator();
        int n2 = 0;
        while (true) {
            if (n2 < n && iterator.hasNext()) {
                objectArray2[n2++] = iterator.next();
                continue;
            }
            if (!iterator.hasNext()) {
                if (n2 == n) {
                    return objectArray2;
                }
                if (objectArray2 == objectArray) {
                    objectArray[n2] = null;
                    return objectArray;
                }
                return Arrays.copyOf(objectArray2, n2, clazz);
            }
            int n3 = (objectArray2.length / 2 + 1) * 3;
            if (n3 < objectArray2.length) {
                if (objectArray2.length < -129) {
                    n3 = -129;
                } else {
                    throw new OutOfMemoryError("required array size too large");
                }
            }
            objectArray2 = Arrays.copyOf(objectArray2, n3, clazz);
            n = n3;
        }
    }

    static /* synthetic */ long access$000(long l, long l2) {
        return Utils.gcd(l, l2);
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
        NanoTimer nanoTimer = null;
        try {
            String string = (String)AccessController.doPrivileged(new Utils$1());
            if (string != null) {
                Class clazz = Class.forName(string);
                nanoTimer = (NanoTimer)clazz.newInstance();
            }
        }
        catch (Exception exception) {
            System.err.println("WARNING: unable to load the system-property-defined nanotime provider; switching to the default");
            exception.printStackTrace();
        }
        if (nanoTimer == null) {
            try {
                nanoTimer = new Utils$SunPerfProvider();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (nanoTimer == null) {
            nanoTimer = new Utils$MillisProvider();
        }
        Utils.nanoTimer = nanoTimer;
    }
}

