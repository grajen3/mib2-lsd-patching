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
import org.dsi.ifc.persistence.DSIPersistenceListener;
import org.dsi.ifc.personalization.DSIPersonalizationListener;

public final class LR51b91841d
extends AbstractProxy
implements DSIPersonalizationListener,
DSIPersistenceListener {
    private static final Method[] JMS = new Method[26];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR51b91841d(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void copyProfile(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(0, "org.dsi.ifc.personalization.DSIPersonalizationListener", -384405560, 1676164096), 0, objectArray);
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
    public void resetProfile(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR51b91841d.gjm(1, "org.dsi.ifc.personalization.DSIPersonalizationListener", -817945654, 1687814400), 1, objectArray);
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
    public void resetAllProfiles() {
        try {
            this.h.invoke(this, LR51b91841d.gjm(2, "org.dsi.ifc.personalization.DSIPersonalizationListener", 1372479525, 17), 2, ZOA);
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
    public void asyncException(int n, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(3, "org.dsi.ifc.personalization.DSIPersonalizationListener", -1459926625, 1276482132), -1, objectArray);
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
    public void readInt(int n, long l, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR51b91841d.gjm(4, "org.dsi.ifc.persistence.DSIPersistenceListener", -296196800, 1174474573), 4, objectArray);
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
            this.h.invoke(this, LR51b91841d.gjm(5, "org.dsi.ifc.persistence.DSIPersistenceListener", 97185937, -1612125681), 5, objectArray);
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
    public void writeBuffer(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(6, "org.dsi.ifc.persistence.DSIPersistenceListener", 0x74373337, -1612125681), 6, objectArray);
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
    public void unsubscribe(int n, int[] nArray, long[] lArray, int[] nArray2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = nArray;
            objectArray[2] = lArray;
            objectArray[3] = nArray2;
            this.h.invoke(this, LR51b91841d.gjm(7, "org.dsi.ifc.persistence.DSIPersistenceListener", 1177404450, 61137418), 7, objectArray);
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
    public void readArray(int n, long l, int[] nArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = nArray;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(8, "org.dsi.ifc.persistence.DSIPersistenceListener", -658965829, 1308149060), 8, objectArray);
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
    public void readString(int n, long l, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = string;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(9, "org.dsi.ifc.persistence.DSIPersistenceListener", -1130418206, 1281768000), 9, objectArray);
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
    public void readBuffer(int n, long l, byte[] byArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = byArray;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(10, "org.dsi.ifc.persistence.DSIPersistenceListener", -338479675, -556612284), 10, objectArray);
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
    public void writeString(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(11, "org.dsi.ifc.persistence.DSIPersistenceListener", 1157836116, -1612125681), 11, objectArray);
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
    public void writeArray(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(12, "org.dsi.ifc.persistence.DSIPersistenceListener", 792751832, -1612125681), 12, objectArray);
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
    public void writeStringArray(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(13, "org.dsi.ifc.persistence.DSIPersistenceListener", -561664858, -1612125681), 13, objectArray);
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
    public void readStringArray(int n, long l, String[] stringArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = stringArray;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(14, "org.dsi.ifc.persistence.DSIPersistenceListener", -954467192, 743714674), 14, objectArray);
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
    public void getVisibleSystemLanguages(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR51b91841d.gjm(15, "org.dsi.ifc.persistence.DSIPersistenceListener", 1167693661, -633848249), 15, objectArray);
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
    public void flushSQLDatabase(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR51b91841d.gjm(16, "org.dsi.ifc.persistence.DSIPersistenceListener", 983976524, 1687814400), 16, objectArray);
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
    public void beginTransaction(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(17, "org.dsi.ifc.persistence.DSIPersistenceListener", -365903438, 1676164096), 17, objectArray);
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
    public void endTransaction(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(18, "org.dsi.ifc.persistence.DSIPersistenceListener", 2020424829, 1676164096), 18, objectArray);
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
    public void updateActiveSQLDatabaseMedium(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(19, "org.dsi.ifc.persistence.DSIPersistenceListener", 1145556944, 1676164096), 19, objectArray);
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
    public void valueChangedInt(int n, long l, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR51b91841d.gjm(20, "org.dsi.ifc.persistence.DSIPersistenceListener", 1634182361, 1174474573), 20, objectArray);
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
    public void valueChangedString(int n, long l, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = string;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(21, "org.dsi.ifc.persistence.DSIPersistenceListener", 1763189331, 1281768000), 21, objectArray);
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
    public void valueChangedArray(int n, long l, int[] nArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = nArray;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(22, "org.dsi.ifc.persistence.DSIPersistenceListener", -1946767615, 1308149060), 22, objectArray);
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
    public void valueChangedStringArray(int n, long l, String[] stringArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = stringArray;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(23, "org.dsi.ifc.persistence.DSIPersistenceListener", 973540300, 743714674), 23, objectArray);
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
    public void valueChangedBuffer(int n, long l, byte[] byArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = byArray;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51b91841d.gjm(24, "org.dsi.ifc.persistence.DSIPersistenceListener", -1739839434, -556612284), 24, objectArray);
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

