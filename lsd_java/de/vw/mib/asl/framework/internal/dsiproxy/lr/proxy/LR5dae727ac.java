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
import org.dsi.ifc.telephone.CallDuration;
import org.dsi.ifc.telephone.DSITelephoneListener;
import org.dsi.ifc.telephone.DisconnectReason;
import org.dsi.ifc.telephone.Favorite;
import org.dsi.ifc.telephone.MailboxDialingNumber;
import org.dsi.ifc.telephone.NetworkProvider;
import org.dsi.ifc.telephone.NetworkProviderName;
import org.dsi.ifc.telephone.PhoneInformation;
import org.dsi.ifc.telephone.SuppServiceResponseStruct;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;
import org.dsi.ifc.telephoneng.EmergencyCallSetting;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.MissedCallIndicator;
import org.dsi.ifc.telephoneng.NADTemperatureStruct;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.SIMAliasInformation;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.ServiceNumbers;
import org.dsi.ifc.telephoneng.ServiceProvider;

public final class LR5dae727ac
extends AbstractProxy
implements DSIMobileEquipmentListener,
DSITelephoneListener {
    private static final Method[] JMS = new Method[191];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5dae727ac(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateMicGainLevel(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dae727ac.gjm(0, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1661289084, 1676164096), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(1, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -183871736, 1687814400), -1, objectArray);
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
    public void responseNetworkSearch(org.dsi.ifc.telephoneng.NetworkProvider[] networkProviderArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = networkProviderArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(2, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 715197625, 1487807011), 2, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(3, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1675959988, 1676164096), -1, objectArray);
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
    public void updateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = callStackEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(4, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 601393871, -541580181), 4, objectArray);
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
    public void updateLastDialedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = callStackEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(5, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -236977586, -541580181), 5, objectArray);
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
    public void updateMissedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = callStackEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(6, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1534537297, -541580181), 6, objectArray);
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
    public void updateMEDataValidity(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dae727ac.gjm(7, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 849525527, 1676164096), 7, objectArray);
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
    public void updateMissedCallIndicator(MissedCallIndicator missedCallIndicator, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = missedCallIndicator;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(8, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1655777269, -745942425), 8, objectArray);
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
    public void updateSpeechRecognitionAvailable(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dae727ac.gjm(9, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -220288590, 1676164096), 9, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(10, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1202502628, 1676164096), 10, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(11, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 2080319092, 1676164096), 11, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(12, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1230337263, 1687814400), 12, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(13, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1195001712, 1687814400), 13, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(14, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1920989398, 1687814400), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(15, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1137658498, 1687814400), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(16, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1214601724, 1676164096), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(17, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 327736428, 1687814400), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(18, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1692473422, -1665395196), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(19, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 2070345851, 1687814400), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(20, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 657608455, 1687814400), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(21, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1730103123, 1687814400), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(22, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -2141494540, 1687814400), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(23, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 0x22050205, 1687814400), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(24, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -2025344122, -315766685), 24, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(25, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1164744782, -1665395196), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(26, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -766655729, 2028839530), 26, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(27, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1092035517, 64549546), 27, objectArray);
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
    public void updatePhoneInformation(org.dsi.ifc.telephoneng.PhoneInformation phoneInformation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = phoneInformation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(28, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1016919447, 163960979), 28, objectArray);
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
    public void updateNetworkProvider(org.dsi.ifc.telephoneng.NetworkProviderName networkProviderName, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = networkProviderName;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(29, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1418931021, -953657099), 29, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(30, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1960863048, 1676164096), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(31, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -627352663, -2138292360), 31, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(32, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 845291849, -1555888253), 32, objectArray);
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
    public void responseAcceptCall(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(33, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 473278412, 1687814400), -1, objectArray);
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
    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = cFResponseDataArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(34, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -67283101, -112335262), 34, objectArray);
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
    public void responseCallWaiting(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dae727ac.gjm(35, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -2097070386, 1676164096), -1, objectArray);
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
    public void responseCLIR(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5dae727ac.gjm(36, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -2002141099, 1043255048), -1, objectArray);
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
    public void responseDialNumber(int n, org.dsi.ifc.telephoneng.SuppServiceResponseStruct suppServiceResponseStruct) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = suppServiceResponseStruct;
            this.h.invoke(this, LR5dae727ac.gjm(37, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1876214667, -764191791), 37, objectArray);
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
    public void responseDialOperator(int n, org.dsi.ifc.telephoneng.SuppServiceResponseStruct suppServiceResponseStruct) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = suppServiceResponseStruct;
            this.h.invoke(this, LR5dae727ac.gjm(38, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1975930116, -764191791), 38, objectArray);
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
    public void responseSendDTMF(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(39, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -2019299184, 1687814400), -1, objectArray);
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
    public void updateDTMFTonePlaying(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(40, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -15857401, -645498553), -1, objectArray);
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
    public void updateEmergencyNumbers(EmergencyNumbers emergencyNumbers, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = emergencyNumbers;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(41, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -671569705, -1541305133), 41, objectArray);
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
    public void responseRemoveOtherSIM(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(42, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1629350323, 1687814400), -1, objectArray);
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
    public void updateOtherSIMAvailable(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(43, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1908204326, -1665395196), -1, objectArray);
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
    public void responseHangupCall(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(44, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 565242170, 1687814400), -1, objectArray);
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
    public void responseJoinCalls(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(45, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -716690, 1687814400), -1, objectArray);
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
    public void responseUnlockOtherSIM(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(46, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 558142220, 1687814400), -1, objectArray);
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
    public void responseSetHandsFreeMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(47, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -954757387, 1687814400), -1, objectArray);
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
    public void responseSetAutomaticRedialActive(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(48, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1748467636, 1687814400), -1, objectArray);
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
    public void responseServiceCodeAbort(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(49, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -453111095, 1687814400), -1, objectArray);
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
    public void responseSplitCall(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(50, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -869062235, 1687814400), -1, objectArray);
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
    public void responseSwapCalls(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(51, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 907786815, 1687814400), -1, objectArray);
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
    public void updateAutomaticRedialActive(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(52, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 9217866, -1665395196), -1, objectArray);
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
    public void updateBatteryChargeLevel(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dae727ac.gjm(53, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 24164046, 1676164096), -1, objectArray);
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
    public void updateCallDurationList(org.dsi.ifc.telephoneng.CallDuration[] callDurationArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = callDurationArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(54, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 780632800, -711598809), 54, objectArray);
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
    public void updateCallList(CallInformation[] callInformationArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = callInformationArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(55, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 2047250473, -1979792155), 55, objectArray);
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
    public void updateCDMAThreeWayCallingSetting(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(56, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -794722861, -1665395196), -1, objectArray);
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
    public void updateCradlePlugInState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dae727ac.gjm(57, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -546699860, 1676164096), -1, objectArray);
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
    public void updateDisconnectReason(org.dsi.ifc.telephoneng.DisconnectReason disconnectReason, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = disconnectReason;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(58, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1589634369, 736675901), 58, objectArray);
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
    public void updateEmergencyCallActive(EmergencyCallSetting emergencyCallSetting, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = emergencyCallSetting;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(59, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1638577389, 1813396576), 59, objectArray);
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
    public void updateEnhancedPrivacyMode(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(60, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -518062426, -1665395196), -1, objectArray);
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
    public void updateHandsFreeMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dae727ac.gjm(61, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1602502774, 1676164096), -1, objectArray);
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
    public void updateMailboxContent(org.dsi.ifc.telephoneng.MailboxDialingNumber[] mailboxDialingNumberArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = mailboxDialingNumberArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(62, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1018921411, -2145510134), 62, objectArray);
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
    public void updateMICMuteState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dae727ac.gjm(63, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1337007405, 1676164096), -1, objectArray);
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
    public void updatePrivacyMode(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(64, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 924297749, -1665395196), -1, objectArray);
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
    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = serviceCodeTypeStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(65, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 139411792, -1362069442), 65, objectArray);
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
    public void updateServiceNumbers(ServiceNumbers serviceNumbers, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = serviceNumbers;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(66, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1942817966, -1068424016), 66, objectArray);
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
    public void updateSuppServiceResponse(org.dsi.ifc.telephoneng.SuppServiceResponseStruct suppServiceResponseStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = suppServiceResponseStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(67, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1060592081, 1725401550), 67, objectArray);
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
    public void updateNADMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dae727ac.gjm(68, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1056993068, 1676164096), -1, objectArray);
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
    public void responseSetCDMAThreeWayCallingSetting(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(69, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1758933110, 1687814400), -1, objectArray);
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
    public void responseSetAutomaticEmergencyCallActive(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(70, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1073341364, 1687814400), -1, objectArray);
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
    public void responseSetMailboxContent(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(71, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1528751015, 1687814400), -1, objectArray);
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
    public void responseSetPrivacyMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(72, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1620798174, 1687814400), -1, objectArray);
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
    public void responseSetSIMAliases(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(73, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -575426690, 1687814400), -1, objectArray);
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
    public void responseSetMICMuteState(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(74, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -418341699, 1687814400), -1, objectArray);
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
    public void responseSetOptimizationMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dae727ac.gjm(75, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1503578814, 1676164096), -1, objectArray);
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
    public void responseSetNADMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dae727ac.gjm(76, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 675400692, 1676164096), -1, objectArray);
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
    public void updateSIMAliasInformation(SIMAliasInformation sIMAliasInformation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = sIMAliasInformation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(77, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1614370507, 278877352), 77, objectArray);
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
    public void updateOptimizationMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dae727ac.gjm(78, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 244228317, 1676164096), -1, objectArray);
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
    public void responseSetPhoneReminderSetting(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(79, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1500842698, 1687814400), -1, objectArray);
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
    public void responseSetPrefixActivated(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(80, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 856420419, 1687814400), -1, objectArray);
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
    public void responseSetPrefixContent(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(81, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 458073459, 1687814400), -1, objectArray);
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
    public void updatePhoneReminderSetting(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(82, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 239314070, -1665395196), -1, objectArray);
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
    public void updatePrefixActivated(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(83, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -877545119, -1665395196), -1, objectArray);
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
    public void updatePrefixContent(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(84, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1279698956, -645498553), -1, objectArray);
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
    public void updateWidebandSpeech(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(85, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 683079874, -1665395196), -1, objectArray);
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
    public void responseSetPhoneRingtone(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(86, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -999651659, 1687814400), -1, objectArray);
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
    public void updatePhoneRingtone(int n, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5dae727ac.gjm(87, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1557608502, 1276482132), -1, objectArray);
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
    public void responseSetFavorites(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(88, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1806508504, 1687814400), -1, objectArray);
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
    public void updateFavorites(org.dsi.ifc.telephoneng.Favorite[] favoriteArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = favoriteArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(89, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 52851421, -1956160842), 89, objectArray);
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
    public void updateSAPUpgradeActive(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(90, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -559645143, -1665395196), -1, objectArray);
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
    public void responseSetSIMName(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(91, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -700289013, 1687814400), -1, objectArray);
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
    public void responseSetESIMActive(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(92, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1904348802, 1687814400), -1, objectArray);
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
    public void updateEUICCID(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(93, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 538499866, -645498553), -1, objectArray);
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
    public void updateESIMMSISDN(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(94, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1428016073, -645498553), -1, objectArray);
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
    public void updateESimActive(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(95, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -165962308, -1665395196), -1, objectArray);
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
    public void updateESimB2BMode(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(96, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1332904373, -1665395196), -1, objectArray);
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
    public void updateCallstacksIsReverted(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(97, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", 1424315865, -1665395196), 97, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(98, "org.dsi.ifc.telephoneng.DSIMobileEquipmentListener", -1459926625, 1276482132), -1, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(101, "org.dsi.ifc.telephone.DSITelephoneListener", 715197625, -1314144535), 101, objectArray);
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
    public void updateActivationState(org.dsi.ifc.telephone.ActivationStateStruct activationStateStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = activationStateStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(113, "org.dsi.ifc.telephone.DSITelephoneListener", -2025344122, 1960351444), 113, objectArray);
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
    public void updateLockState(org.dsi.ifc.telephone.LockStateStruct lockStateStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lockStateStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(115, "org.dsi.ifc.telephone.DSITelephoneListener", -766655729, 1070156060), 115, objectArray);
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
    public void updateNADTemperature(org.dsi.ifc.telephone.NADTemperatureStruct nADTemperatureStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nADTemperatureStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(116, "org.dsi.ifc.telephone.DSITelephoneListener", 1092035517, -1673465575), 116, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(117, "org.dsi.ifc.telephone.DSITelephoneListener", 1016919447, 576851223), 117, objectArray);
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
            this.h.invoke(this, LR5dae727ac.gjm(118, "org.dsi.ifc.telephone.DSITelephoneListener", -1418931021, 248057213), 118, objectArray);
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
    public void updateRegisterState(org.dsi.ifc.telephone.RegisterStateStruct registerStateStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = registerStateStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(120, "org.dsi.ifc.telephone.DSITelephoneListener", -627352663, -953354753), 120, objectArray);
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
    public void updateServiceProvider(org.dsi.ifc.telephone.ServiceProvider serviceProvider, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = serviceProvider;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(121, "org.dsi.ifc.telephone.DSITelephoneListener", 845291849, 1780461108), 121, objectArray);
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
    public void responseCallForward(org.dsi.ifc.telephone.CFResponseData[] cFResponseDataArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = cFResponseDataArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(123, "org.dsi.ifc.telephone.DSITelephoneListener", -67283101, -2134796142), 123, objectArray);
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
    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = suppServiceResponseStruct;
            this.h.invoke(this, LR5dae727ac.gjm(126, "org.dsi.ifc.telephone.DSITelephoneListener", 1876214667, -710961892), 126, objectArray);
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
    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = suppServiceResponseStruct;
            this.h.invoke(this, LR5dae727ac.gjm(127, "org.dsi.ifc.telephone.DSITelephoneListener", -1975930116, -710961892), 127, objectArray);
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
    public void updateEmergencyNumbers(org.dsi.ifc.telephone.EmergencyNumbers emergencyNumbers, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = emergencyNumbers;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(130, "org.dsi.ifc.telephone.DSITelephoneListener", -671569705, -1111572394), 130, objectArray);
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
    public void updateCallDurationList(CallDuration[] callDurationArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = callDurationArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(143, "org.dsi.ifc.telephone.DSITelephoneListener", 780632800, 473945398), 143, objectArray);
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
    public void updateCallList(org.dsi.ifc.telephone.CallInformation[] callInformationArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = callInformationArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(144, "org.dsi.ifc.telephone.DSITelephoneListener", 2047250473, -486842196), 144, objectArray);
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
    public void updateDisconnectReason(DisconnectReason disconnectReason, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = disconnectReason;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(147, "org.dsi.ifc.telephone.DSITelephoneListener", 1589634369, 1149631936), 147, objectArray);
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
    public void updateEmergencyCallActive(org.dsi.ifc.telephone.EmergencyCallSetting emergencyCallSetting, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = emergencyCallSetting;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(148, "org.dsi.ifc.telephone.DSITelephoneListener", 1638577389, 92224207), 148, objectArray);
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
    public void updateMailboxContent(MailboxDialingNumber[] mailboxDialingNumberArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = mailboxDialingNumberArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(151, "org.dsi.ifc.telephone.DSITelephoneListener", -1018921411, -946841986), 151, objectArray);
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
    public void updateServiceCodeType(org.dsi.ifc.telephone.ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = serviceCodeTypeStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(154, "org.dsi.ifc.telephone.DSITelephoneListener", 139411792, 897271727), 154, objectArray);
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
    public void updateServiceNumbers(org.dsi.ifc.telephone.ServiceNumbers serviceNumbers, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = serviceNumbers;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(155, "org.dsi.ifc.telephone.DSITelephoneListener", 1942817966, 425844661), 155, objectArray);
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
    public void updateSuppServiceResponse(SuppServiceResponseStruct suppServiceResponseStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = suppServiceResponseStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(156, "org.dsi.ifc.telephone.DSITelephoneListener", -1060592081, 1843814795), 156, objectArray);
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
    public void updateSIMAliasInformation(org.dsi.ifc.telephone.SIMAliasInformation sIMAliasInformation, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = sIMAliasInformation;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(166, "org.dsi.ifc.telephone.DSITelephoneListener", -1614370507, 1463749168), 166, objectArray);
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
    public void updateFavorites(Favorite[] favoriteArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = favoriteArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(178, "org.dsi.ifc.telephone.DSITelephoneListener", 52851421, 1389146091), 178, objectArray);
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
    public void responseAbortAlternatePhoneActivity(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(186, "org.dsi.ifc.telephone.DSITelephoneListener", 130915774, 1687814400), 186, objectArray);
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
    public void responseTogglePrioritizedPhoneDevice(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(187, "org.dsi.ifc.telephone.DSITelephoneListener", 1772829486, 1687814400), 187, objectArray);
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
    public void updateActivationStateAssociated(org.dsi.ifc.telephone.ActivationStateStruct activationStateStruct, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = activationStateStruct;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(188, "org.dsi.ifc.telephone.DSITelephoneListener", 759855369, 1960351444), 188, objectArray);
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
    public void updateAlternatePhoneActivity(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5dae727ac.gjm(189, "org.dsi.ifc.telephone.DSITelephoneListener", -511270200, -1665395196), 189, objectArray);
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

