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
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.phonetic.DSIPhoneticConverterListener;
import org.dsi.ifc.picturehandling.DSIPictureHandlingListener;

public final class LR5f07d5031
extends AbstractProxy
implements DSIPhoneticConverterListener,
DSIPictureHandlingListener {
    private static final Method[] JMS = new Method[6];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5f07d5031(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void hanziToPinYinResult(String string, String string2, String string3, String string4) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = string3;
            objectArray[3] = string4;
            this.h.invoke(this, LR5f07d5031.gjm(0, "org.dsi.ifc.phonetic.DSIPhoneticConverterListener", 987314552, 1305175025), 0, objectArray);
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
    public void hanziToZhuYinResult(String string, String string2, String string3, String string4) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = string3;
            objectArray[3] = string4;
            this.h.invoke(this, LR5f07d5031.gjm(1, "org.dsi.ifc.phonetic.DSIPhoneticConverterListener", 146032606, 1305175025), 1, objectArray);
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
            this.h.invoke(this, LR5f07d5031.gjm(2, "org.dsi.ifc.phonetic.DSIPhoneticConverterListener", -1459926625, 1276482132), -1, objectArray);
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
    public void indicatePicture(int n, int n2, ResourceLocator resourceLocator, ResourceLocator resourceLocator2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = resourceLocator;
            objectArray[3] = resourceLocator2;
            this.h.invoke(this, LR5f07d5031.gjm(3, "org.dsi.ifc.picturehandling.DSIPictureHandlingListener", 2055880139, -1644528364), 3, objectArray);
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
    public void finishPictureRequest(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f07d5031.gjm(4, "org.dsi.ifc.picturehandling.DSIPictureHandlingListener", -1718539474, 1687814400), 4, objectArray);
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

