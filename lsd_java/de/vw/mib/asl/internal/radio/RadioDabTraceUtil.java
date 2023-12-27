/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.LogUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class RadioDabTraceUtil {
    private static final int LEN_ENS_ECC;
    private static final int LEN_ENS_FULLNAME;
    private static final int LEN_ENS_ID;
    private static final int LEN_ENS_SHORTNAME;
    private static final int LEN_BLOCKNO;
    private static final int LEN_SER_FULLNAME;
    private static final int LEN_SER_ID;
    private static final int LEN_SER_SHORTNAME;
    private static final String DAB_CONTEXT;
    static final short TRACE_DAB_MAIN_HSM;
    static final short TRACE_DAB_DSI_HSM;
    static final short TRACE_DAB_RT_HSM;
    static final short TRACE_DAB_SLS_HSM;
    static final short TRACE_DAB_DP;
    static final short TRACE_RADIO_MGR;
    static final short TRACE_ALL;
    static short mCurrentTrace;

    private static boolean traceAllowed(int n) {
        if ((mCurrentTrace & 2) > 0 && n == ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_DSI) {
            return true;
        }
        if ((mCurrentTrace & 1) > 0 && n == ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB) {
            return true;
        }
        if ((mCurrentTrace & 8) > 0 && n == ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_SLS) {
            return true;
        }
        if ((mCurrentTrace & 4) > 0 && n == ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB_RADIOTEXT) {
            return true;
        }
        return (mCurrentTrace & 0x20) > 0 && n == ASLRadioTargetIds.ASL_RADIO_MANAGER;
    }

    public static void errorLogDab(String string) {
        ServiceManager.logger.error(256).append("[DAB] ").append(string).log();
    }

    public static void eventTraceDab(int n, String string, String string2, String string3, String[] stringArray, String[] stringArray2) {
        if (RadioDabTraceUtil.traceAllowed(n) && ServiceManager.logger.isTraceEnabled(256)) {
            LogMessage logMessage = ServiceManager.logger.trace(256);
            logMessage.append("[DAB] ").append("EventTrace - ").append(string).append(" ---> ").append(string2).append(": ").append(string3).append("(");
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                logMessage.append(stringArray[i2]).append(new StringBuffer().append("[").append(stringArray2[i2]).toString()).append("]");
                if (i2 >= stringArray.length - 1) continue;
                logMessage.append(", ");
            }
            logMessage.append(")").log();
        }
    }

    public static void hsmTraceDAB(TargetHsmImpl targetHsmImpl, HsmState hsmState, String string, String string2) {
        if (RadioDabTraceUtil.traceAllowed(targetHsmImpl.getTargetId()) && ServiceManager.logger.isTraceEnabled(256)) {
            LogMessage logMessage = ServiceManager.logger.trace(256);
            logMessage.append("[DAB] ");
            logMessage.append("HSMTrace - Target[").append(targetHsmImpl.getShortName()).append("] Current State[").append(targetHsmImpl.getHsm().getState().getName()).append("] Handle State[").append(hsmState.getName()).append("] Event[").append(string).append("] -> ").append(string2).log();
        }
    }

    public static void hsmTraceDABStart(TargetHsmImpl targetHsmImpl, HsmState hsmState, String string) {
        if (RadioDabTraceUtil.traceAllowed(targetHsmImpl.getTargetId()) && ServiceManager.logger.isTraceEnabled(256)) {
            LogMessage logMessage = ServiceManager.logger.trace(256);
            logMessage.append("[DAB] ");
            logMessage.append("HSMTrace - Target[").append(targetHsmImpl.getShortName()).append("] Current State[").append(targetHsmImpl.getHsm().getState().getName()).append("] Handle State[").append(hsmState.getName()).append("] Event[").append(string).append("] START").log();
        }
    }

    public static void hsmTraceDABStop(TargetHsmImpl targetHsmImpl, HsmState hsmState, String string) {
        if (RadioDabTraceUtil.traceAllowed(targetHsmImpl.getTargetId()) && ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("[DAB] ").append("HSMTrace - Target[").append(targetHsmImpl.getShortName()).append("] Current State[").append(targetHsmImpl.getHsm().getState().getName()).append("] Handle State[").append(hsmState.getName()).append("] Event[").append(string).append("] STOP").log();
        }
    }

    public static void traceDab(int n, String string) {
        if (RadioDabTraceUtil.traceAllowed(n) && ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("[DAB] ").append(string).log();
        }
    }

    public static void DataPoolTraceDab(String string, String string2) {
        if ((mCurrentTrace & 0x10) > 0 && ServiceManager.logger.isTraceEnabled(256)) {
            LogMessage logMessage = ServiceManager.logger.trace(256);
            logMessage.append("[DAB] ").append("DatapoolTrace - ").append(string).append("[").append(string2).append("]").log();
        }
    }

    public static void DataPoolTraceDab(String string) {
        if ((mCurrentTrace & 0x10) > 0 && ServiceManager.logger.isTraceEnabled(256)) {
            LogMessage logMessage = ServiceManager.logger.trace(256);
            logMessage.append("[DAB] ").append("DatapoolTrace - ").append(string).log();
        }
    }

    public static void dumpFrequencyList(int n) {
        RadioUtil.line(256);
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("[DAB] ");
        RadioDabTraceUtil.traceDab(n, "---| FrequencyList: (Hz,BlockNo)");
        FrequencyInfo[] frequencyInfoArray = RadioData.getDabDatabase().mTunerState.getFrequencyList();
        if (frequencyInfoArray != null) {
            for (int i2 = 0; i2 < frequencyInfoArray.length; ++i2) {
                if (i2 % 7 == 0) {
                    stringBuffer.append("---|");
                } else {
                    stringBuffer.append("|");
                }
                if (frequencyInfoArray[i2] == null) continue;
                stringBuffer.append(LogUtil.fixLength(Long.toString(frequencyInfoArray[i2].frequency), 7, true));
                stringBuffer.append(" - ");
                stringBuffer.append(LogUtil.fixLength(frequencyInfoArray[i2].label, 6, true));
                if (i2 % 7 != 0) continue;
                stringBuffer.append("|");
                RadioDabTraceUtil.traceDab(n, stringBuffer.toString());
                stringBuffer.delete(0, stringBuffer.length());
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.append("|");
                RadioDabTraceUtil.traceDab(n, stringBuffer.toString());
            }
            RadioUtil.line(256);
        }
    }

    public static void dumpEnsembleList(int n) {
        RadioUtil.line(256);
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("[DAB] ");
        RadioDabTraceUtil.traceDab(n, "---| EnsembleList: (EnsId,EnsEcc,BlockNo,Full,Short)");
        EnsembleInfo[] ensembleInfoArray = RadioData.getDabDatabase().mTunerState.getEnsembleList();
        for (int i2 = 0; i2 < ensembleInfoArray.length; ++i2) {
            EnsembleInfo ensembleInfo = ensembleInfoArray[i2];
            if (null == ensembleInfo) continue;
            stringBuffer.append(LogUtil.fixLength(Integer.toHexString(ensembleInfo.ensID), 4, true));
            stringBuffer.append(" - ");
            stringBuffer.append(LogUtil.fixLength(Integer.toHexString(ensembleInfo.ensECC), 2, true));
            stringBuffer.append(" - ");
            stringBuffer.append(LogUtil.fixLength(ensembleInfo.frequencyLabel, 6, true));
            stringBuffer.append(" - ");
            stringBuffer.append(LogUtil.fixLength(ensembleInfo.fullName, 32, true));
            stringBuffer.append(" - ");
            stringBuffer.append(LogUtil.fixLength(ensembleInfo.shortName, 16, true));
            RadioDabTraceUtil.traceDab(n, stringBuffer.toString());
            stringBuffer.delete(0, stringBuffer.length());
        }
        RadioUtil.line(256);
    }

    public static void dumpServiceList(int n) {
        RadioUtil.line(256);
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("[DAB] ");
        RadioDabTraceUtil.traceDab(n, "---| ServiceList: (EnsId,EnsEcc,Sid,Full,Short,ComponentCount)");
        ServiceInfo[] serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServiceList();
        if (serviceInfoArray != null) {
            for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                stringBuffer.append("---|");
                ServiceInfo serviceInfo = serviceInfoArray[i2];
                if (serviceInfo == null) continue;
                stringBuffer.append(LogUtil.fixLength(Integer.toHexString(serviceInfo.ensID), 4, true));
                stringBuffer.append(" - ");
                stringBuffer.append(LogUtil.fixLength(Integer.toHexString(serviceInfo.ensECC), 2, true));
                stringBuffer.append(" - ");
                stringBuffer.append(LogUtil.fixLength(Long.toHexString(serviceInfo.sID), 6, true));
                stringBuffer.append(" - ");
                stringBuffer.append(LogUtil.fixLength(serviceInfo.fullName, 32, true));
                stringBuffer.append(" - ");
                stringBuffer.append(LogUtil.fixLength(serviceInfo.shortName, 16, true));
                stringBuffer.append(" - ");
                RadioDabTraceUtil.traceDab(n, stringBuffer.toString());
                stringBuffer.delete(0, stringBuffer.length());
            }
            RadioUtil.line(256);
        }
    }

    public static String forceLmModesToString(int n) {
        String string;
        switch (n) {
            case 2: {
                string = "DSIDABTuner.UPDATEMODE_ABORT";
                break;
            }
            case 3: {
                string = "DSIDABTuner.UPDATEMODE_DELETE_LEARNMEMORY";
                break;
            }
            case 1: {
                string = "DSIDABTuner.UPDATEMODE_START";
                break;
            }
            default: {
                string = "DSIDABTuner.UPDATEMODE_UNDEFINED";
            }
        }
        return string;
    }

    public static String selectServiceModeToString(int n) {
        String string;
        switch (n) {
            case 5: {
                string = "DSIDABTuner.SELECTSERVICEMODE_ABORT";
                break;
            }
            case 4: {
                string = "DSIDABTuner.SELECTSERVICEMODE_INDEX";
                break;
            }
            case 3: {
                string = "DSIDABTuner.SELECTSERVICEMODE_SCIDI";
                break;
            }
            case 1: {
                string = "DSIDABTuner.SELECTSERVICEMODE_SID";
                break;
            }
            case 2: {
                string = "DSIDABTuner.SELECTSERVICEMODE_SID_AND_ENSID";
                break;
            }
            case 6: {
                string = "DSIDABTuner.SELECTSERVICEMODE_SID_AND_FREQUENCY";
                break;
            }
            default: {
                string = "DSIDABTuner.SELECTSERVICEMODE_UNDEFINED";
            }
        }
        return string;
    }

    public static String selectServiceStatusToString(int n) {
        String string;
        switch (n) {
            case 2: {
                string = "DSIDABTuner.SELECTSERVICESTATUS_ABORTED";
                break;
            }
            case 7: {
                string = "DSIDABTuner.SELECTSERVICESTATUS_INDEX_INVALID";
                break;
            }
            case 3: {
                string = "DSIDABTuner.SELECTSERVICESTATUS_DONE";
                break;
            }
            case 6: {
                string = "DSIDABTuner.SELECTSERVICESTATUS_NO_ENSEMBLE_TUNED";
                break;
            }
            case 5: {
                string = "DSIDABTuner.SELECTSERVICESTATUS_NO_SERVICE";
                break;
            }
            case 1: {
                string = "DSIDABTuner.SELECTSERVICESTATUS_RUNNING";
                break;
            }
            case 4: {
                string = "DSIDABTuner.SELECTSERVICESTATUS_SERVICE_INVALID";
                break;
            }
            default: {
                string = "DSIDABTuner.SELECTSERVICESTATUS_UNDEFINED";
            }
        }
        return string;
    }

    public String tuneEnsembleStatusToString(int n) {
        String string;
        switch (n) {
            case 2: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_ABORTED";
                break;
            }
            case 6: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_FAILURE";
                break;
            }
            case 3: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_FINISHED";
                break;
            }
            case 1: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_RUNNING";
                break;
            }
            case 0: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_UNDEFINED";
                break;
            }
            case 4: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_WRONG_FREQUENCY";
                break;
            }
            case 5: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_WRONG_FREQUENCYLABEL";
                break;
            }
            default: {
                string = new StringBuffer().append("unknown status: ").append(n).toString();
            }
        }
        return string;
    }

    static {
        mCurrentTrace = (short)255;
    }
}

