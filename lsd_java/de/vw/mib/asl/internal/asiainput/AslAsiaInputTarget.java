/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.asiainput;

import de.vw.mib.asia.ASLAsiaInput;
import de.vw.mib.asia.AsiaInputListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.asiainput.AsiaInputConstants;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.asiainput.UserDefinedEntry;
import org.dsi.ifc.asiainput.WordDatabase;

public final class AslAsiaInputTarget
extends AbstractASLTarget
implements ASLAsiaInput,
AsiaInputConstants {
    private static final String LOGGING_DELIM;
    static AsiaInputListener asiaInputListener;
    private boolean powerOnReceived = false;
    static /* synthetic */ Class class$de$vw$mib$asia$ASLAsiaInput;

    public AslAsiaInputTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.trace().append("[AslAsiaInputTarget] ").append("Register myself as an OSGI Service: ASLAsiaInput").log();
        ServiceManager.bundleContext.registerService((class$de$vw$mib$asia$ASLAsiaInput == null ? (class$de$vw$mib$asia$ASLAsiaInput = AslAsiaInputTarget.class$("de.vw.mib.asia.ASLAsiaInput")) : class$de$vw$mib$asia$ASLAsiaInput).getName(), (Object)this, null);
    }

    public AslAsiaInputTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.trace().append("[AslAsiaInputTarget] ").append("Register myself as an OSGI Service").log();
        ServiceManager.bundleContext.registerService((class$de$vw$mib$asia$ASLAsiaInput == null ? (class$de$vw$mib$asia$ASLAsiaInput = AslAsiaInputTarget.class$("de.vw.mib.asia.ASLAsiaInput")) : class$de$vw$mib$asia$ASLAsiaInput).getName(), (Object)this, null);
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
        if (eventGeneric.getReceiverEventId() == 106) {
            this.powerOnReceived = true;
        }
    }

    private void sendToInternalAslTarget(EventGeneric eventGeneric, int n) {
        if (this.powerOnReceived) {
            int n2 = this.getTargetId();
            eventGeneric.setReceiverEventId(n);
            eventGeneric.setSenderTargetId(n2);
            eventGeneric.setReceiverTargetId(1627460096);
            try {
                this.send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                this.error(genericEventException);
            }
        }
    }

    private void sendToInternalAslTargetWithoutParameter(int n) {
        if (this.powerOnReceived) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            this.sendToInternalAslTarget(eventGeneric, n);
        }
    }

    @Override
    public void requestInitialize(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        this.sendToInternalAslTarget(eventGeneric, -1585053440);
    }

    @Override
    public void requestAddSymbol(char c2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setChar(0, c2);
        this.sendToInternalAslTarget(eventGeneric, -1568276224);
    }

    @Override
    public void requestAddSymbols(String string) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setString(0, string);
        this.sendToInternalAslTarget(eventGeneric, -1551499008);
    }

    @Override
    public void requestRemoveSymbol() {
        this.sendToInternalAslTargetWithoutParameter(-1534721792);
    }

    @Override
    public void requestRemoveAllSymbols() {
        this.sendToInternalAslTargetWithoutParameter(-1517944576);
    }

    @Override
    public void requestClear() {
        this.sendToInternalAslTargetWithoutParameter(-1501167360);
    }

    @Override
    public void requestBuildCandidates() {
        this.sendToInternalAslTargetWithoutParameter(-1484390144);
    }

    @Override
    public void requestGetSpelling() {
        this.sendToInternalAslTargetWithoutParameter(-1467612928);
    }

    @Override
    public void requestGetCandidates(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        this.sendToInternalAslTarget(eventGeneric, -1450835712);
    }

    @Override
    public void requestSelectCandidate(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        this.sendToInternalAslTarget(eventGeneric, -1434058496);
    }

    @Override
    public void requestSetBooleanParameter(int n, boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, bl);
        this.sendToInternalAslTarget(eventGeneric, -1333395200);
    }

    @Override
    public void requestSetIntParameter(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        this.sendToInternalAslTarget(eventGeneric, -1316617984);
    }

    @Override
    public void requestSetStringParameter(int n, String string) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setString(1, string);
        this.sendToInternalAslTarget(eventGeneric, -1299840768);
    }

    @Override
    public void requestGetBooleanParameter(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        this.sendToInternalAslTarget(eventGeneric, -1283063552);
    }

    @Override
    public void requestGetIntParameter(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        this.sendToInternalAslTarget(eventGeneric, -1266286336);
    }

    @Override
    public void requestGetStringParameter(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        this.sendToInternalAslTarget(eventGeneric, -1249509120);
    }

    @Override
    public void requestSetPredictionContext(String string) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setString(0, string);
        this.sendToInternalAslTarget(eventGeneric, -1215954688);
    }

    @Override
    public void requestClearPredictionContext() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        this.sendToInternalAslTarget(eventGeneric, -1199177472);
    }

    @Override
    public void requestAddUserDefinedEntry(UserDefinedEntry userDefinedEntry) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, userDefinedEntry);
        this.sendToInternalAslTarget(eventGeneric, -1182400256);
    }

    @Override
    public void requestSetAdditionalWordDatabases(WordDatabase[] wordDatabaseArray) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, wordDatabaseArray);
        this.sendToInternalAslTarget(eventGeneric, -1165623040);
    }

    @Override
    public void requestSetUserDatabaseState(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        this.sendToInternalAslTarget(eventGeneric, -1148845824);
    }

    @Override
    public void requestGetSegmentation(String string) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setString(0, string);
        this.sendToInternalAslTarget(eventGeneric, -1132068608);
    }

    @Override
    public void addAsiaInputListener(AsiaInputListener asiaInputListener) {
        this.trace().append("[AslAsiaInputTarget] ").append("addAsiaInputListener").log();
        AslAsiaInputTarget.asiaInputListener = asiaInputListener;
    }

    @Override
    public void removeAsiaInputListener() {
        this.trace().append("[AslAsiaInputTarget] ").append("removeAsiaInputListener").log();
        asiaInputListener = null;
    }

    @Override
    public int getDefaultTargetId() {
        return 1610682880;
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
        asiaInputListener = null;
    }
}

