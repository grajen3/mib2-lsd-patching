/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.asiainput;

import de.vw.mib.asia.ASLAsiaInput;
import de.vw.mib.asia.AsiaInputListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.internal.asiainput.AsiaInputConstants;
import de.vw.mib.asl.internal.asiainput.AslAsiaInputTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.asiainput.DSIAsiaInput;
import org.dsi.ifc.asiainput.DSIAsiaInputListener;
import org.dsi.ifc.asiainput.UserDefinedEntry;
import org.dsi.ifc.asiainput.WordDatabase;

public final class AslAsiaInputInternalTarget
extends AbstractASLTarget
implements ASLAsiaInput,
AsiaInputConstants,
DSIAsiaInputListener {
    private static final String LOGGING_DELIM;
    private DSIAsiaInput dsiAsiaInput;
    static /* synthetic */ Class class$org$dsi$ifc$asiainput$DSIAsiaInput;
    static /* synthetic */ Class class$org$dsi$ifc$asiainput$DSIAsiaInputListener;

    public AslAsiaInputInternalTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public AslAsiaInputInternalTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 64;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
            case 4300010: {
                this.processRevertSettings();
                break;
            }
            case 100001: {
                int n = eventGeneric.getInt(0);
                this.requestInitialize(n);
                break;
            }
            case 100002: {
                char c2 = eventGeneric.getChar(0);
                this.requestAddSymbol(c2);
                break;
            }
            case 100003: {
                String string = eventGeneric.getString(0);
                this.requestAddSymbols(string);
                break;
            }
            case 100004: {
                this.requestRemoveSymbol();
                break;
            }
            case 100005: {
                this.requestRemoveAllSymbols();
                break;
            }
            case 100006: {
                this.requestClear();
                break;
            }
            case 100007: {
                this.requestBuildCandidates();
                break;
            }
            case 100008: {
                this.requestGetSpelling();
                break;
            }
            case 100009: {
                int n = eventGeneric.getInt(0);
                this.requestGetCandidates(n);
                break;
            }
            case 100010: {
                int n = eventGeneric.getInt(0);
                this.requestSelectCandidate(n);
                break;
            }
            case 100016: {
                int n = eventGeneric.getInt(0);
                boolean bl = eventGeneric.getBoolean(1);
                this.requestSetBooleanParameter(n, bl);
                break;
            }
            case 100017: {
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getInt(1);
                this.requestSetIntParameter(n, n2);
                break;
            }
            case 100018: {
                int n = eventGeneric.getInt(0);
                String string = eventGeneric.getString(1);
                this.requestSetStringParameter(n, string);
                break;
            }
            case 100019: {
                int n = eventGeneric.getInt(0);
                this.requestGetBooleanParameter(n);
                break;
            }
            case 100020: {
                int n = eventGeneric.getInt(0);
                this.requestGetIntParameter(n);
                break;
            }
            case 100021: {
                int n = eventGeneric.getInt(0);
                this.requestGetStringParameter(n);
                break;
            }
            case 100023: {
                String string = eventGeneric.getString(0);
                this.requestSetPredictionContext(string);
                break;
            }
            case 100024: {
                this.requestClearPredictionContext();
                break;
            }
            case 100025: {
                UserDefinedEntry userDefinedEntry = (UserDefinedEntry)eventGeneric.getObject(0);
                this.requestAddUserDefinedEntry(userDefinedEntry);
                break;
            }
            case 100026: {
                WordDatabase[] wordDatabaseArray = (WordDatabase[])eventGeneric.getObject(0);
                this.requestSetAdditionalWordDatabases(wordDatabaseArray);
                break;
            }
            case 100027: {
                int n = eventGeneric.getInt(0);
                int n3 = eventGeneric.getInt(1);
                this.requestSetUserDatabaseState(n, n3);
                break;
            }
            case 100028: {
                String string = eventGeneric.getString(0);
                this.requestGetSegmentation(string);
                break;
            }
            case 8: 
            case 9: {
                break;
            }
            default: {
                this.warn().append("[AslAsiaInputInternalTarget] ").append("Unknown Event Id: ").append(eventGeneric.getReceiverEventId()).log();
            }
        }
    }

    private void processPowerOn() {
        DSIServiceLocator dSIServiceLocator = ServiceManager.dsiServiceLocator;
        this.dsiAsiaInput = (DSIAsiaInput)dSIServiceLocator.getService(this, class$org$dsi$ifc$asiainput$DSIAsiaInput == null ? (class$org$dsi$ifc$asiainput$DSIAsiaInput = AslAsiaInputInternalTarget.class$("org.dsi.ifc.asiainput.DSIAsiaInput")) : class$org$dsi$ifc$asiainput$DSIAsiaInput);
        dSIServiceLocator.addResponseListener(this, class$org$dsi$ifc$asiainput$DSIAsiaInputListener == null ? (class$org$dsi$ifc$asiainput$DSIAsiaInputListener = AslAsiaInputInternalTarget.class$("org.dsi.ifc.asiainput.DSIAsiaInputListener")) : class$org$dsi$ifc$asiainput$DSIAsiaInputListener, this);
        this.addObserver(-358858496);
    }

    private void processRevertSettings() {
        this.dsiAsiaInput.resetToFactorySettings();
    }

    @Override
    public void requestInitialize(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("initialize: ").append(n).log();
        }
        this.dsiAsiaInput.initialize(n);
    }

    @Override
    public void requestAddSymbol(char c2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("addSymbol: ").append(c2).log();
        }
        this.dsiAsiaInput.addSymbol(c2);
    }

    @Override
    public void requestAddSymbols(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("addSymbols: ").append(string).log();
        }
        this.dsiAsiaInput.addSymbols(string);
    }

    @Override
    public void requestRemoveSymbol() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("removeSymbol").log();
        }
        this.dsiAsiaInput.removeSymbol();
    }

    @Override
    public void requestRemoveAllSymbols() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("removeAllSymbols").log();
        }
        this.dsiAsiaInput.removeAllSymbols();
    }

    @Override
    public void requestClear() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("clear").log();
        }
        this.dsiAsiaInput.clear();
    }

    @Override
    public void requestBuildCandidates() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("buildCandidates").log();
        }
        this.dsiAsiaInput.buildCandidates();
    }

    @Override
    public void requestGetSpelling() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("getSpelling").log();
        }
        this.dsiAsiaInput.getSpelling();
    }

    @Override
    public void requestGetCandidates(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("getCandidates").log();
        }
        this.dsiAsiaInput.getCandidates(n);
    }

    @Override
    public void requestSelectCandidate(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("selectCandidate").log();
        }
        this.dsiAsiaInput.selectCandidate(n);
    }

    @Override
    public void requestSetBooleanParameter(int n, boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("setBooleanParameter: parameter: ").append(n).append(" value: ").append(bl).log();
        }
        this.dsiAsiaInput.setBooleanParameter(n, bl);
    }

    @Override
    public void requestSetIntParameter(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("setIntParameter: parameter: ").append(n).append(" value: ").append(n2).log();
        }
        this.dsiAsiaInput.setIntParameter(n, n2);
    }

    @Override
    public void requestSetStringParameter(int n, String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("setStringParameter: parameter: ").append(n).append(" value: ").append(string).log();
        }
        this.dsiAsiaInput.setStringParameter(n, string);
    }

    @Override
    public void requestGetBooleanParameter(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("getBooleanParameter: ").append(n).log();
        }
        this.dsiAsiaInput.getBooleanParameter(n);
    }

    @Override
    public void requestGetIntParameter(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("getIntParameter: ").append(n).log();
        }
        this.dsiAsiaInput.getIntParameter(n);
    }

    @Override
    public void requestGetStringParameter(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("getStringParameter: ").append(n).log();
        }
        this.dsiAsiaInput.getStringParameter(n);
    }

    @Override
    public void requestSetPredictionContext(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("setPredictionContext").log();
        }
        this.dsiAsiaInput.setPredictionContext(string);
    }

    @Override
    public void requestClearPredictionContext() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("clearPredictionContext").log();
        }
        this.dsiAsiaInput.clearPredictionContext();
    }

    @Override
    public void requestAddUserDefinedEntry(UserDefinedEntry userDefinedEntry) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("addUserDefinedEntry: ").append(userDefinedEntry).log();
        }
        this.dsiAsiaInput.addUserDefinedEntry(userDefinedEntry);
    }

    @Override
    public void requestSetAdditionalWordDatabases(WordDatabase[] wordDatabaseArray) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("setAdditionalWordDatabases").log();
        }
        this.dsiAsiaInput.setAdditionalWordDatabases(wordDatabaseArray);
    }

    @Override
    public void requestSetUserDatabaseState(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("setUserDatabaseState id").append(n).append(" state ").append(n2).log();
        }
        this.dsiAsiaInput.setUserDatabaseState(n, n2);
    }

    @Override
    public void requestGetSegmentation(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("getSegmentation phrase").append(string).log();
        }
        this.dsiAsiaInput.getSegmentation(string);
    }

    @Override
    public void addAsiaInputListener(AsiaInputListener asiaInputListener) {
    }

    @Override
    public void removeAsiaInputListener() {
    }

    private void errorListenerIsNull() {
        this.error().append("[AslAsiaInputInternalTarget] ").append("Listener is null!").log();
    }

    @Override
    public int getDefaultTargetId() {
        return 1627460096;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.warn().append("[AslAsiaInputInternalTarget] ").append("DSIAsiaInput-ASYNC:ErrorCode[").append(n).append("] Text:'").append(string).append("' RequestId[").append(n2).append("]").log();
        if (n == 8304) {
            if (AslAsiaInputTarget.asiaInputListener != null) {
                if (this.isTraceEnabled()) {
                    this.trace().append("[AslAsiaInputInternalTarget] ").append("asyncException, call AsiaInputListener.indicateTimeout()").log();
                }
                AslAsiaInputTarget.asiaInputListener.indicateTimeout();
            } else {
                this.errorListenerIsNull();
            }
        }
    }

    @Override
    public void initialized(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("initialized resultcode ").append(n).log();
        }
        if (n == 0) {
            if (AslAsiaInputTarget.asiaInputListener != null) {
                AslAsiaInputTarget.asiaInputListener.initialized();
            } else {
                this.errorListenerIsNull();
            }
        }
    }

    @Override
    public void getVersionInfo(String string, String string2) {
    }

    @Override
    public void builtCandidates(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("builtCandidates count ").append(n).log();
        }
        if (AslAsiaInputTarget.asiaInputListener != null) {
            AslAsiaInputTarget.asiaInputListener.builtCandidates(n);
        } else {
            this.errorListenerIsNull();
        }
    }

    @Override
    public void getSpelling(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("getSpelling spelling ").append(string).log();
        }
        if (AslAsiaInputTarget.asiaInputListener != null) {
            AslAsiaInputTarget.asiaInputListener.receivedSpelling(string);
        } else {
            this.errorListenerIsNull();
        }
    }

    @Override
    public void getCandidates(String[] stringArray) {
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace().append("[AslAsiaInputInternalTarget] ").append("getCandidates candidates:");
            if (stringArray != null) {
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    logMessage = logMessage.append(" ").append(stringArray[i2]);
                }
            }
            logMessage.log();
        }
        if (AslAsiaInputTarget.asiaInputListener != null) {
            AslAsiaInputTarget.asiaInputListener.receivedCandidates(stringArray);
        } else {
            this.errorListenerIsNull();
        }
    }

    @Override
    public void selectedCandidate(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("selectedCandidate index ").append(n).append(" resultcode ").append(n2).log();
        }
        if (n2 == 0) {
            if (AslAsiaInputTarget.asiaInputListener != null) {
                AslAsiaInputTarget.asiaInputListener.selectedCandidate(n);
            } else {
                this.errorListenerIsNull();
            }
        }
    }

    @Override
    public void indicateErrorStatus(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("indicateErrorStatus errorCode ").append(n).log();
        }
        if (AslAsiaInputTarget.asiaInputListener != null) {
            AslAsiaInputTarget.asiaInputListener.indicateErrorStatus(n);
        } else {
            this.errorListenerIsNull();
        }
    }

    @Override
    public void indicateDataInvalidated(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("indicateDataInvalidated invalidReason ").append(n).log();
        }
        if (AslAsiaInputTarget.asiaInputListener != null) {
            AslAsiaInputTarget.asiaInputListener.indicateDataInvalidated(n);
        } else {
            this.errorListenerIsNull();
        }
    }

    @Override
    public void getIntParameter(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("getIntParameter parameter ").append(n).append(" value ").append(n2).log();
        }
        if (AslAsiaInputTarget.asiaInputListener != null) {
            AslAsiaInputTarget.asiaInputListener.receivedIntParameter(n, n2);
        } else {
            this.errorListenerIsNull();
        }
    }

    @Override
    public void getBooleanParameter(int n, boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("getBooleanParameter parameter ").append(n).append(" value ").append(bl).log();
        }
        if (AslAsiaInputTarget.asiaInputListener != null) {
            AslAsiaInputTarget.asiaInputListener.receivedBooleanParameter(n, bl);
        } else {
            this.errorListenerIsNull();
        }
    }

    @Override
    public void setIntParameterResult(int n, int n2, int n3) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("setIntParameterResult parameter ").append(n).append(" value ").append(n2).append(" resultCode ").append(n3).log();
        }
        if (n3 == 0) {
            if (AslAsiaInputTarget.asiaInputListener != null) {
                AslAsiaInputTarget.asiaInputListener.setIntParameterResult(n);
            } else {
                this.errorListenerIsNull();
            }
        }
    }

    @Override
    public void setBooleanParameterResult(int n, boolean bl, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("setBooleanParameterResult parameter ").append(n).append(" value ").append(bl).append(" resultCode ").append(n2).log();
        }
        if (n2 == 0) {
            if (AslAsiaInputTarget.asiaInputListener != null) {
                AslAsiaInputTarget.asiaInputListener.setBooleanParameterResult(n);
            } else {
                this.errorListenerIsNull();
            }
        }
    }

    @Override
    public void setStringParameterResult(int n, String string, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("setStringParameterResult parameter ").append(n).append(" value ").append(string).append(" resultCode ").append(n2).log();
        }
        if (n2 == 0) {
            if (AslAsiaInputTarget.asiaInputListener != null) {
                AslAsiaInputTarget.asiaInputListener.setStringParameterResult(n);
            } else {
                this.errorListenerIsNull();
            }
        }
    }

    @Override
    public void getStringParameter(int n, String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("getStringParameter parameter ").append(n).append(" value ").append(string).log();
        }
        if (AslAsiaInputTarget.asiaInputListener != null) {
            AslAsiaInputTarget.asiaInputListener.receivedStringParameter(n, string);
        } else {
            this.errorListenerIsNull();
        }
    }

    @Override
    public void setAdditionalWordDatabasesResult(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("setAdditionalWordDatabasesResult resultCode ").append(n).log();
        }
        if (n == 0) {
            if (AslAsiaInputTarget.asiaInputListener != null) {
                AslAsiaInputTarget.asiaInputListener.setAdditionalWordDatabasesResult();
            } else {
                this.errorListenerIsNull();
            }
        }
    }

    @Override
    public void setUserDatabaseStateResult(int n, int n2, int n3) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("setUserDatabaseStateResult databaseId ").append(n).append(" databaseState ").append(n2).append(" resultCode ").append(n3).log();
        }
        if (n3 == 0) {
            if (AslAsiaInputTarget.asiaInputListener != null) {
                AslAsiaInputTarget.asiaInputListener.setUserDatabaseStateResult(n, n2);
            } else {
                this.errorListenerIsNull();
            }
        }
    }

    @Override
    public void resetToFactorySettingsResult(int n) {
        this.info().append("[AslAsiaInputInternalTarget] ").append("resetToFactorySettingsResult resultCode: ").append(n).log();
    }

    @Override
    public void getSegmentation(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslAsiaInputInternalTarget] ").append("getSegmentation phrases ").append(string).log();
        }
        if (AslAsiaInputTarget.asiaInputListener != null) {
            AslAsiaInputTarget.asiaInputListener.receivedSegmentation(string);
        } else {
            this.errorListenerIsNull();
        }
    }

    @Override
    public void responseSegmentationForTruffles(String string) {
        this.info().append("[AslAsiaInputInternalTarget] ").append("Unhandled response for truffle string segmentation: ").append(string).log();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

