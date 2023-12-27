/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.proxy;

import de.vw.mib.reflection.AbstractProxy;
import de.vw.mib.reflection.InvocationHandler;
import de.vw.mib.reflection.RuntimeUtil;
import de.vw.mib.reflection.pool.ObjArrayPool;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.persistence.DSIPersistence;
import org.dsi.ifc.personalization.DSIPersonalization;

public final class LR52bcdba25
extends AbstractProxy
implements DSIPersistence,
DSIPersonalization {
    private static final Method[] JMS = new Method[37];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR52bcdba25(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void readInt(int n, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR52bcdba25.gjm(0, "org.dsi.ifc.persistence.DSIPersistence", -296196800, -995993593), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void writeInt(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52bcdba25.gjm(1, "org.dsi.ifc.persistence.DSIPersistence", 97185937, -1612125681), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void writeBuffer(int n, long l, byte[] byArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = byArray;
            this.h.invoke(this, LR52bcdba25.gjm(2, "org.dsi.ifc.persistence.DSIPersistence", 0x74373337, 934977799), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void subscribe(int n, int[] nArray, long[] lArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = nArray;
            objectArray[2] = lArray;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52bcdba25.gjm(3, "org.dsi.ifc.persistence.DSIPersistence", -1075859682, 15757373), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void unsubscribe(int n, int[] nArray, long[] lArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = nArray;
            objectArray[2] = lArray;
            this.h.invoke(this, LR52bcdba25.gjm(4, "org.dsi.ifc.persistence.DSIPersistence", 1177404450, 1507281920), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void readArray(int n, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR52bcdba25.gjm(5, "org.dsi.ifc.persistence.DSIPersistence", -658965829, -995993593), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void readString(int n, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR52bcdba25.gjm(6, "org.dsi.ifc.persistence.DSIPersistence", -1130418206, -995993593), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void readIntTimeout(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52bcdba25.gjm(7, "org.dsi.ifc.persistence.DSIPersistence", 487023687, -1612125681), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void readBuffer(int n, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR52bcdba25.gjm(8, "org.dsi.ifc.persistence.DSIPersistence", -338479675, -995993593), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void readBufferTimeout(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52bcdba25.gjm(9, "org.dsi.ifc.persistence.DSIPersistence", -2136637519, -1612125681), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void writeString(int n, long l, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = string;
            this.h.invoke(this, LR52bcdba25.gjm(10, "org.dsi.ifc.persistence.DSIPersistence", 1157836116, -1521674749), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void readStringTimeout(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52bcdba25.gjm(11, "org.dsi.ifc.persistence.DSIPersistence", -1893936873, -1612125681), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void writeArray(int n, long l, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = nArray;
            this.h.invoke(this, LR52bcdba25.gjm(12, "org.dsi.ifc.persistence.DSIPersistence", 792751832, -1495293689), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void readArrayTimeout(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52bcdba25.gjm(13, "org.dsi.ifc.persistence.DSIPersistence", -204756979, -1612125681), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void writeStringArray(int n, long l, String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = stringArray;
            this.h.invoke(this, LR52bcdba25.gjm(14, "org.dsi.ifc.persistence.DSIPersistence", -561664858, -2059728075), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void readStringArray(int n, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR52bcdba25.gjm(15, "org.dsi.ifc.persistence.DSIPersistence", -954467192, -995993593), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void readStringArrayTimeout(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR52bcdba25.gjm(16, "org.dsi.ifc.persistence.DSIPersistence", 604958459, -1612125681), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void enterEngineeringSession(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52bcdba25.gjm(17, "org.dsi.ifc.persistence.DSIPersistence", 1887413004, 1687814400), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void exitEngineeringSession(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52bcdba25.gjm(18, "org.dsi.ifc.persistence.DSIPersistence", 913088120, 1687814400), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getVisibleSystemLanguages() {
        try {
            this.h.invoke(this, LR52bcdba25.gjm(19, "org.dsi.ifc.persistence.DSIPersistence", 1167693661, 17), 19, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void flushSQLDatabase() {
        try {
            this.h.invoke(this, LR52bcdba25.gjm(20, "org.dsi.ifc.persistence.DSIPersistence", 983976524, 17), 20, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSQLDatabaseMedium(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52bcdba25.gjm(21, "org.dsi.ifc.persistence.DSIPersistence", 1897940353, 1687814400), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void beginTransaction(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52bcdba25.gjm(22, "org.dsi.ifc.persistence.DSIPersistence", -365903438, 1687814400), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void endTransaction(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR52bcdba25.gjm(23, "org.dsi.ifc.persistence.DSIPersistence", 2020424829, -1600866162), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void unsubscribeAll(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR52bcdba25.gjm(24, "org.dsi.ifc.persistence.DSIPersistence", -2053426230, 1687814400), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR52bcdba25.gjm(25, "org.dsi.ifc.persistence.DSIPersistence", -501696838, -904616957), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR52bcdba25.gjm(26, "org.dsi.ifc.persistence.DSIPersistence", -501696838, 1805755651), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dSIListener;
            this.h.invoke(this, LR52bcdba25.gjm(27, "org.dsi.ifc.persistence.DSIPersistence", -501696838, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR52bcdba25.gjm(28, "org.dsi.ifc.persistence.DSIPersistence", 1300919239, -904616957), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR52bcdba25.gjm(29, "org.dsi.ifc.persistence.DSIPersistence", 1300919239, 1805755651), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dSIListener;
            this.h.invoke(this, LR52bcdba25.gjm(30, "org.dsi.ifc.persistence.DSIPersistence", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}

