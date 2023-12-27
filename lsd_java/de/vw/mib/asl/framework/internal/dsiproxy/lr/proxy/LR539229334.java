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
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephone.CFRequestData;
import org.dsi.ifc.telephone.DSITelephone;
import org.dsi.ifc.telephone.Favorite;
import org.dsi.ifc.telephoneng.DSIMobileEquipment;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;

public final class LR539229334
extends AbstractProxy
implements DSIMobileEquipment,
DSITelephone {
    private static final Method[] JMS = new Method[116];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR539229334(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void restoreFactorySettings() {
        try {
            this.h.invoke(this, LR539229334.gjm(0, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1415644906, 17), -1, ZOA);
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
    public void requestNetworkSearch() {
        try {
            this.h.invoke(this, LR539229334.gjm(1, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1661910889, 17), -1, ZOA);
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
    public void requestSetMicGainLevel(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539229334.gjm(2, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 643210807, 1687814400), -1, objectArray);
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
    public void resetMissedCallIndicator() {
        try {
            this.h.invoke(this, LR539229334.gjm(3, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 478360856, 17), 3, ZOA);
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
    public void revertCallstacks(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR539229334.gjm(4, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1107706637, -1653679357), 4, objectArray);
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
    public void requestStartSpeechRecognition() {
        try {
            this.h.invoke(this, LR539229334.gjm(5, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 392547975, 17), 5, ZOA);
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
    public void requestStopSpeechRecognition() {
        try {
            this.h.invoke(this, LR539229334.gjm(6, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1174887357, 17), 6, ZOA);
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
    public void requestNetworkRegistration(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539229334.gjm(7, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1830369124, -645498553), -1, objectArray);
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
    public void requestAbortNetworkRegistration() {
        try {
            this.h.invoke(this, LR539229334.gjm(8, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -606856172, 17), -1, ZOA);
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
    public void requestAbortNetworkSearch() {
        try {
            this.h.invoke(this, LR539229334.gjm(9, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1973994585, 17), -1, ZOA);
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
    public void requestSetAutomaticPinEntryActive(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR539229334.gjm(10, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -260238401, -1653679357), -1, objectArray);
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
    public void requestTelPower(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539229334.gjm(11, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -838134200, 1687814400), -1, objectArray);
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
    public void requestUnlockSIM(int n, String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = string2;
            this.h.invoke(this, LR539229334.gjm(12, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1718939350, 1383775559), -1, objectArray);
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
    public void requestCheckSIMPINCode(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR539229334.gjm(13, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1494985077, -633848249), -1, objectArray);
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
    public void requestChangeSIMCode(int n, String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = string2;
            this.h.invoke(this, LR539229334.gjm(14, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1162506790, 1383775559), -1, objectArray);
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
    public void requestSIMPINRequired(String string, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR539229334.gjm(15, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -515558827, 372504021), -1, objectArray);
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
    public void acceptCall(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539229334.gjm(16, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -69085770, 1687814400), -1, objectArray);
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
    public void hangupCall(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539229334.gjm(17, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 6101029, 1687814400), -1, objectArray);
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
    public void swapCalls() {
        try {
            this.h.invoke(this, LR539229334.gjm(18, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 2010555058, 17), -1, ZOA);
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
    public void splitCall(short s) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(s);
            this.h.invoke(this, LR539229334.gjm(19, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 233771288, -242842362), -1, objectArray);
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
    public void joinCalls() {
        try {
            this.h.invoke(this, LR539229334.gjm(20, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1085405664, 17), -1, ZOA);
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
    public void dialNumber(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR539229334.gjm(21, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1317139061, -633848249), -1, objectArray);
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
    public void dialOperator(int n, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            this.h.invoke(this, LR539229334.gjm(22, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1456805611, 1909456715), -1, objectArray);
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
    public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(8);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = string2;
            objectArray[3] = RuntimeUtil.valueOf(s);
            objectArray[4] = RuntimeUtil.valueOf(s2);
            objectArray[5] = resourceLocator;
            objectArray[6] = RuntimeUtil.valueOf(n);
            objectArray[7] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR539229334.gjm(23, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -2044896967, -1335048711), -1, objectArray);
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
    public void sendDTMF(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR539229334.gjm(24, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 654070346, -633848249), -1, objectArray);
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
    public void requestCallForward(org.dsi.ifc.telephoneng.CFRequestData[] cFRequestDataArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = cFRequestDataArray;
            this.h.invoke(this, LR539229334.gjm(25, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -305993250, -500686037), 25, objectArray);
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
    public void requestCallWaiting(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539229334.gjm(26, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1975963465, 1687814400), -1, objectArray);
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
    public void requestCLIR(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539229334.gjm(27, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -693074876, 1687814400), -1, objectArray);
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
    public void requestServiceCodeAbort() {
        try {
            this.h.invoke(this, LR539229334.gjm(28, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 847376626, 17), -1, ZOA);
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
    public void requestSetAutomaticRedialActive(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR539229334.gjm(29, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1232366434, -1653679357), -1, objectArray);
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
    public void requestSetCDMAThreeWayCallingSetting(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR539229334.gjm(30, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -637310355, -1653679357), -1, objectArray);
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
    public void requestSetAutomaticEmergencyCallActive(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR539229334.gjm(31, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1294025895, -1653679357), -1, objectArray);
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
    public void requestSetEnhancedPrivacyMode(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR539229334.gjm(32, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 395604738, -1653679357), -1, objectArray);
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
    public void requestSetMailboxContent(MailboxDialingNumber[] mailboxDialingNumberArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = mailboxDialingNumberArray;
            this.h.invoke(this, LR539229334.gjm(33, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -840583751, -2117017335), 33, objectArray);
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
    public void requestSetPrivacyMode(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR539229334.gjm(34, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1831004938, -1653679357), -1, objectArray);
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
    public void requestSetHandsFreeMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539229334.gjm(35, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 362441503, 1687814400), -1, objectArray);
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
    public void requestSetMICMuteState(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539229334.gjm(36, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -653459745, 1687814400), -1, objectArray);
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
    public void requestSetLanguage(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR539229334.gjm(37, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1074417718, -633848249), -1, objectArray);
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
    public void requestDecreaseMicGainLevel(short s) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(s);
            this.h.invoke(this, LR539229334.gjm(38, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 545033262, -242842362), -1, objectArray);
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
    public void requestIncreaseMicGainLevel(short s) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(s);
            this.h.invoke(this, LR539229334.gjm(39, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1004817425, -242842362), -1, objectArray);
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
    public void requestSetOptimizationMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539229334.gjm(40, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1743490006, 1687814400), -1, objectArray);
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
    public void requestUnlockOtherSIM(int n, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            this.h.invoke(this, LR539229334.gjm(41, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -285087244, 1909456715), -1, objectArray);
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
    public void requestSetSIMAliases(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR539229334.gjm(42, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1325720668, -412271469), -1, objectArray);
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
    public void requestSetNADMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539229334.gjm(43, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -166374358, 1687814400), -1, objectArray);
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
    public void requestRemoveOtherSIM() {
        try {
            this.h.invoke(this, LR539229334.gjm(44, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 802897564, 17), -1, ZOA);
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
    public void requestSetPhoneReminderSetting(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR539229334.gjm(45, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1737171543, -1653679357), -1, objectArray);
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
    public void requestSetPrefixActivated(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR539229334.gjm(46, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 20084332, -1653679357), -1, objectArray);
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
    public void requestSetPrefixContent(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR539229334.gjm(47, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1775207069, -633848249), -1, objectArray);
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
    public void requestSetPhoneRingtone(int n, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            this.h.invoke(this, LR539229334.gjm(48, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 317547487, 1909456715), -1, objectArray);
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
    public void requestSetFavorites(org.dsi.ifc.telephoneng.Favorite[] favoriteArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = favoriteArray;
            this.h.invoke(this, LR539229334.gjm(49, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1182349106, -1944510538), 49, objectArray);
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
    public void requestSetSIMName(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR539229334.gjm(50, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1541932736, -633848249), -1, objectArray);
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
    public void requestSetESIMActive(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR539229334.gjm(51, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 13509981, -1653679357), -1, objectArray);
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
    public void deleteCallstacksAll(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539229334.gjm(52, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -1571791781, 1687814400), 52, objectArray);
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
    public void deleteCallstacksEntry(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR539229334.gjm(53, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1944894197, 1676164096), 53, objectArray);
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
            this.h.invoke(this, LR539229334.gjm(54, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -501696838, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR539229334.gjm(55, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -501696838, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR539229334.gjm(56, "org.dsi.ifc.telephoneng.DSIMobileEquipment", -501696838, -864245041), -1, objectArray);
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
            this.h.invoke(this, LR539229334.gjm(57, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1300919239, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR539229334.gjm(58, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1300919239, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR539229334.gjm(59, "org.dsi.ifc.telephoneng.DSIMobileEquipment", 1300919239, -864245041), -1, objectArray);
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
    public void requestCallForward(CFRequestData[] cFRequestDataArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = cFRequestDataArray;
            this.h.invoke(this, LR539229334.gjm(81, "org.dsi.ifc.telephone.DSITelephone", -305993250, 2074616059), 81, objectArray);
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
    public void requestSetMailboxContent(org.dsi.ifc.telephone.MailboxDialingNumber[] mailboxDialingNumberArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = mailboxDialingNumberArray;
            this.h.invoke(this, LR539229334.gjm(89, "org.dsi.ifc.telephone.DSITelephone", -840583751, -935191682), 89, objectArray);
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
    public void requestSetFavorites(Favorite[] favoriteArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = favoriteArray;
            this.h.invoke(this, LR539229334.gjm(105, "org.dsi.ifc.telephone.DSITelephone", -1182349106, 1400796395), 105, objectArray);
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
    public void requestAbortAlternatePhoneActivity() {
        try {
            this.h.invoke(this, LR539229334.gjm(108, "org.dsi.ifc.telephone.DSITelephone", -110249146, 17), 108, ZOA);
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
    public void requestTogglePrioritizedPhoneDevice() {
        try {
            this.h.invoke(this, LR539229334.gjm(109, "org.dsi.ifc.telephone.DSITelephone", -1222061399, 17), 109, ZOA);
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

