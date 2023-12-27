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
import org.dsi.ifc.telephone.ActivationStateStruct;
import org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener;
import org.dsi.ifc.telephone.DSINADListener;
import org.dsi.ifc.telephone.LockStateStruct;
import org.dsi.ifc.telephone.NADTemperatureStruct;
import org.dsi.ifc.telephone.NetworkProvider;
import org.dsi.ifc.telephone.NetworkProviderName;
import org.dsi.ifc.telephone.PhoneInformation;
import org.dsi.ifc.telephone.RegisterStateStruct;
import org.dsi.ifc.telephone.ServiceProvider;

public final class LR55c07becd
extends AbstractProxy
implements DSIMobileSpeechRecognitionListener,
DSINADListener {
    private static final Method[] JMS = new Method[29];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR55c07becd(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateSpeechRecognitionAvailable(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR55c07becd.gjm(0, "org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener", -220288590, 1676164096), 0, objectArray);
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
    public void updateSpeechRecognitionActive(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR55c07becd.gjm(1, "org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener", 1202502628, 1676164096), 1, objectArray);
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
    public void updateSpeechRecognitionType(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR55c07becd.gjm(2, "org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener", 2080319092, 1676164096), 2, objectArray);
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
    public void responseStartSpeechRecognition(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(3, "org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener", 1230337263, 1687814400), 3, objectArray);
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
    public void responseStopSpeechRecognition(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(4, "org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener", 1195001712, 1687814400), 4, objectArray);
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
            this.h.invoke(this, LR55c07becd.gjm(5, "org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener", -1459926625, 1276482132), -1, objectArray);
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
    public void responseRestoreFactorySettings(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(6, "org.dsi.ifc.telephone.DSINADListener", -183871736, 1687814400), 6, objectArray);
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
    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = networkProviderArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(7, "org.dsi.ifc.telephone.DSINADListener", 715197625, -1314144535), 7, objectArray);
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
    public void updateSignalQuality(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR55c07becd.gjm(8, "org.dsi.ifc.telephone.DSINADListener", 1675959988, 1676164096), 8, objectArray);
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
    public void responseAbortNetworkRegistration(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(9, "org.dsi.ifc.telephone.DSINADListener", -1920989398, 1687814400), 9, objectArray);
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
    public void responseAbortNetworkSearch(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(10, "org.dsi.ifc.telephone.DSINADListener", -1137658498, 1687814400), 10, objectArray);
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
    public void responseChangeSIMCode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR55c07becd.gjm(11, "org.dsi.ifc.telephone.DSINADListener", 1214601724, 1676164096), 11, objectArray);
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
    public void responseSIMPINRequired(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(12, "org.dsi.ifc.telephone.DSINADListener", 327736428, 1687814400), 12, objectArray);
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
    public void updateSIMPINRequired(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(13, "org.dsi.ifc.telephone.DSINADListener", -1692473422, -1665395196), 13, objectArray);
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
    public void responseNetworkRegistration(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(14, "org.dsi.ifc.telephone.DSINADListener", 2070345851, 1687814400), 14, objectArray);
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
    public void responseUnlockSIM(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(15, "org.dsi.ifc.telephone.DSINADListener", 657608455, 1687814400), 15, objectArray);
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
    public void responseCheckSIMPINCode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(16, "org.dsi.ifc.telephone.DSINADListener", 1730103123, 1687814400), 16, objectArray);
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
    public void responseTelPower(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(17, "org.dsi.ifc.telephone.DSINADListener", -2141494540, 1687814400), 17, objectArray);
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
    public void responseSetAutomaticPinEntryActive(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(18, "org.dsi.ifc.telephone.DSINADListener", 0x22050205, 1687814400), 18, objectArray);
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
    public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = activationStateStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(19, "org.dsi.ifc.telephone.DSINADListener", -2025344122, 1960351444), 19, objectArray);
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
    public void updateAutomaticPinEntryActive(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(20, "org.dsi.ifc.telephone.DSINADListener", -1164744782, -1665395196), 20, objectArray);
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
    public void updateLockState(LockStateStruct lockStateStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lockStateStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(21, "org.dsi.ifc.telephone.DSINADListener", -766655729, 1070156060), 21, objectArray);
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
    public void updateNADTemperature(NADTemperatureStruct nADTemperatureStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nADTemperatureStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(22, "org.dsi.ifc.telephone.DSINADListener", 1092035517, -1673465575), 22, objectArray);
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
    public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = phoneInformation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(23, "org.dsi.ifc.telephone.DSINADListener", 1016919447, 576851223), 23, objectArray);
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
    public void updateNetworkProvider(NetworkProviderName networkProviderName, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = networkProviderName;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(24, "org.dsi.ifc.telephone.DSINADListener", -1418931021, 248057213), 24, objectArray);
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
    public void updateNetworkType(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR55c07becd.gjm(25, "org.dsi.ifc.telephone.DSINADListener", 1960863048, 1676164096), 25, objectArray);
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
    public void updateRegisterState(RegisterStateStruct registerStateStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = registerStateStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(26, "org.dsi.ifc.telephone.DSINADListener", -627352663, -953354753), 26, objectArray);
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
    public void updateServiceProvider(ServiceProvider serviceProvider, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = serviceProvider;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR55c07becd.gjm(27, "org.dsi.ifc.telephone.DSINADListener", 845291849, 1780461108), 27, objectArray);
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

