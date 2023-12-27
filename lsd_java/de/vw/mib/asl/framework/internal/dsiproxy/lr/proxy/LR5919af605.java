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
import org.dsi.ifc.speechrec.DSISpeechRec;
import org.dsi.ifc.speechrec.DictionaryEntry;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.sse.DSISSE;

public final class LR5919af605
extends AbstractProxy
implements DSISSE,
DSISpeechRec {
    private static final Method[] JMS = new Method[54];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5919af605(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void requestSetMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(0, "org.dsi.ifc.sse.DSISSE", 199404039, 1687814400), 0, objectArray);
            return;
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
            this.h.invoke(this, LR5919af605.gjm(1, "org.dsi.ifc.sse.DSISSE", 643210807, 1687814400), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestSetMicMuteState(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(2, "org.dsi.ifc.sse.DSISSE", -645348859, 1687814400), 2, objectArray);
            return;
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
            this.h.invoke(this, LR5919af605.gjm(3, "org.dsi.ifc.sse.DSISSE", -501696838, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5919af605.gjm(4, "org.dsi.ifc.sse.DSISSE", -501696838, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5919af605.gjm(5, "org.dsi.ifc.sse.DSISSE", -501696838, -864245041), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5919af605.gjm(6, "org.dsi.ifc.sse.DSISSE", 1300919239, -904616957), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5919af605.gjm(7, "org.dsi.ifc.sse.DSISSE", 1300919239, 1805755651), -1, objectArray);
            return;
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
            this.h.invoke(this, LR5919af605.gjm(8, "org.dsi.ifc.sse.DSISSE", 1300919239, -864245041), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void shutdown() {
        try {
            this.h.invoke(this, LR5919af605.gjm(9, "org.dsi.ifc.speechrec.DSISpeechRec", -888608523, 17), 9, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void init() {
        try {
            this.h.invoke(this, LR5919af605.gjm(10, "org.dsi.ifc.speechrec.DSISpeechRec", -2056834816, 17), 10, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setDictionary(int n, String string, String string2, DictionaryEntry[] dictionaryEntryArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = string2;
            objectArray[3] = dictionaryEntryArray;
            this.h.invoke(this, LR5919af605.gjm(11, "org.dsi.ifc.speechrec.DSISpeechRec", 226036279, -2075244131), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getVersion() {
        try {
            this.h.invoke(this, LR5919af605.gjm(12, "org.dsi.ifc.speechrec.DSISpeechRec", 391889490, 17), 12, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setLanguage(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(13, "org.dsi.ifc.speechrec.DSISpeechRec", 1328833814, -645498553), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestRestoreFactorySettings() {
        try {
            this.h.invoke(this, LR5919af605.gjm(14, "org.dsi.ifc.speechrec.DSISpeechRec", -1021660768, 17), 14, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deleteProfile(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(15, "org.dsi.ifc.speechrec.DSISpeechRec", -201893407, 1687814400), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void abort() {
        try {
            this.h.invoke(this, LR5919af605.gjm(16, "org.dsi.ifc.speechrec.DSISpeechRec", -1524267771, 17), 16, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deleteVoiceTag(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(17, "org.dsi.ifc.speechrec.DSISpeechRec", 1217531664, 1687814400), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void enableContinuousUpdate(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5919af605.gjm(18, "org.dsi.ifc.speechrec.DSISpeechRec", -801722942, -1653679357), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void initVoiceTag(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(19, "org.dsi.ifc.speechrec.DSISpeechRec", -1388541167, 1687814400), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void loadGrammar(Grammar[] grammarArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = grammarArray;
            this.h.invoke(this, LR5919af605.gjm(20, "org.dsi.ifc.speechrec.DSISpeechRec", 1443767538, 552154271), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void loadProfile(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(21, "org.dsi.ifc.speechrec.DSISpeechRec", 1479605966, 1687814400), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void preloadGrammar(Grammar[] grammarArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = grammarArray;
            this.h.invoke(this, LR5919af605.gjm(22, "org.dsi.ifc.speechrec.DSISpeechRec", -748184830, 552154271), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void recordVoiceTag() {
        try {
            this.h.invoke(this, LR5919af605.gjm(23, "org.dsi.ifc.speechrec.DSISpeechRec", -294516359, 17), 23, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startRecognition(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5919af605.gjm(24, "org.dsi.ifc.speechrec.DSISpeechRec", 1781824977, 1043255048), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void unloadGrammar(GrammarInfo[] grammarInfoArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = grammarInfoArray;
            this.h.invoke(this, LR5919af605.gjm(25, "org.dsi.ifc.speechrec.DSISpeechRec", 488004418, 309507224), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void unloadProfile(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(26, "org.dsi.ifc.speechrec.DSISpeechRec", 523777311, 1687814400), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void unpreloadGrammar(GrammarInfo[] grammarInfoArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = grammarInfoArray;
            this.h.invoke(this, LR5919af605.gjm(27, "org.dsi.ifc.speechrec.DSISpeechRec", -1401516618, 309507224), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void waitForResults() {
        try {
            this.h.invoke(this, LR5919af605.gjm(28, "org.dsi.ifc.speechrec.DSISpeechRec", -1209735431, 17), 28, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMaxCommandNBestListSize(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(29, "org.dsi.ifc.speechrec.DSISpeechRec", -45315287, 1687814400), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMaxSlotNBestListSize(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(30, "org.dsi.ifc.speechrec.DSISpeechRec", -429246177, 1687814400), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setRecognitionTimeout(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(31, "org.dsi.ifc.speechrec.DSISpeechRec", 562072167, 1687814400), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUnambiguousResultThreshold(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(32, "org.dsi.ifc.speechrec.DSISpeechRec", 842921594, 1687814400), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUnambiguousResultRange(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(33, "org.dsi.ifc.speechrec.DSISpeechRec", 76268711, 1687814400), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setFirstLevelSize(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(34, "org.dsi.ifc.speechrec.DSISpeechRec", 1276674974, 1687814400), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startPostTraining(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(35, "org.dsi.ifc.speechrec.DSISpeechRec", -1845672871, 1687814400), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void stopPostTraining() {
        try {
            this.h.invoke(this, LR5919af605.gjm(36, "org.dsi.ifc.speechrec.DSISpeechRec", 835782535, 17), 36, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestSDSAvailability() {
        try {
            this.h.invoke(this, LR5919af605.gjm(37, "org.dsi.ifc.speechrec.DSISpeechRec", -1555657453, 17), 37, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setSpellingMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(38, "org.dsi.ifc.speechrec.DSISpeechRec", 1962336612, 1687814400), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deleteLastSpellingBlock() {
        try {
            this.h.invoke(this, LR5919af605.gjm(39, "org.dsi.ifc.speechrec.DSISpeechRec", 127677111, 17), 39, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void startDialogue() {
        try {
            this.h.invoke(this, LR5919af605.gjm(40, "org.dsi.ifc.speechrec.DSISpeechRec", -813521927, 17), 40, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void stopDialogue() {
        try {
            this.h.invoke(this, LR5919af605.gjm(41, "org.dsi.ifc.speechrec.DSISpeechRec", 1864769964, 17), 41, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestCheckDbPartition() {
        try {
            this.h.invoke(this, LR5919af605.gjm(42, "org.dsi.ifc.speechrec.DSISpeechRec", 140366527, 17), 42, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestGraphemicGroupAsNBestList(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5919af605.gjm(43, "org.dsi.ifc.speechrec.DSISpeechRec", -173843340, 1687814400), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestVDECapabilities(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5919af605.gjm(44, "org.dsi.ifc.speechrec.DSISpeechRec", -1289471418, -633848249), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setASRParameterConfiguration(int[] nArray, int[] nArray2, int[] nArray3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = nArray;
            objectArray[1] = nArray2;
            objectArray[2] = nArray3;
            this.h.invoke(this, LR5919af605.gjm(45, "org.dsi.ifc.speechrec.DSISpeechRec", -1608071693, 1598376704), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deleteLastFlexVDEPart() {
        try {
            this.h.invoke(this, LR5919af605.gjm(46, "org.dsi.ifc.speechrec.DSISpeechRec", -1511359934, 17), 46, ZOA);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void clearFlexVDEHistory() {
        try {
            this.h.invoke(this, LR5919af605.gjm(47, "org.dsi.ifc.speechrec.DSISpeechRec", 405317384, 17), 47, ZOA);
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

