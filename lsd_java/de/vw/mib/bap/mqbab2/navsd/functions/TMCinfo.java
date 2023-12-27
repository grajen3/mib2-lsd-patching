/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.elements.NavigationTMCInfoElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.TMCinfo_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.TMCinfo_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;
import de.vw.mib.bap.mqbab2.navsd.functions.TMCinfo$1;
import de.vw.mib.collections.ints.IntLongOptHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public final class TMCinfo
extends Function
implements Property,
ASLNavSDConstants,
NavigationServiceListener,
SystemServiceListener {
    private TMCinfo_Status currentTMCInfoMessage = new TMCinfo_Status();
    private long currentTMCInfoMessageID;
    private static int INVALID_MESSAGE_ID = -1;
    private static final int NUMBER_OF_VALUES;
    private LinkedHashMap waitingForConfirmationTMCInfoMessages;
    private static final LinkedHashMap CONFIRMED_TMC_MESSAGES;
    private static final int CONFIRMED_MESSAGES_MAX_SIZE;
    private IntLongOptHashMap messageIDMap;
    private int nextMessageID;
    private static final int MAX_MESSAGE_ID;
    private static final int MIN_MESSAGE_ID;
    private static final int RESERVED_MESSAGE_ID;
    private boolean confimingTMCMessage;
    private boolean messageTransmissionGoingOn;
    protected static final int[] NAVIGATION_LISTENER_IDS;
    protected static final int[] NAVIGATION_LISTENER__HMI_EVENT_IDS;
    protected static final int[] SYSTEM_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$TMCinfo_Status;

    public TMCinfo() {
        this.currentTMCInfoMessage.messageId = INVALID_MESSAGE_ID;
        this.currentTMCInfoMessage.tmcinfo.length_Unit = 255;
        this.currentTMCInfoMessageID = INVALID_MESSAGE_ID;
        this.waitingForConfirmationTMCInfoMessages = new LinkedHashMap();
        this.confimingTMCMessage = false;
        this.messageTransmissionGoingOn = false;
        this.nextMessageID = 0;
        this.messageIDMap = new IntLongOptHashMap(15);
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getNavigationService().addHMIEventListener(this, NAVIGATION_LISTENER__HMI_EVENT_IDS);
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        return this.checkQueuedTMCInfoMessages(this.queueCurrentTMCInfoMessages());
    }

    protected TMCinfo_Status dequeueBAPEntity() {
        return (TMCinfo_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$TMCinfo_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$TMCinfo_Status = TMCinfo.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.TMCinfo_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$TMCinfo_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 25;
    }

    @Override
    public void process(int n) {
        TMCinfo_Status tMCinfo_Status = this.checkQueuedTMCInfoMessages(this.queueCurrentTMCInfoMessages());
        if (tMCinfo_Status != null) {
            this.sendTMCInfoStatus(tMCinfo_Status, null);
        }
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
        this.messageTransmissionGoingOn = false;
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getNavigationService().removeNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getNavigationService().removeHMIEventListener(this, NAVIGATION_LISTENER__HMI_EVENT_IDS);
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        TMCinfo_SetGet tMCinfo_SetGet = (TMCinfo_SetGet)bAPEntity;
        if (TMCinfo.inputParametersValid(tMCinfo_SetGet)) {
            if (this.confirmTMCMessageInternal(tMCinfo_SetGet, propertyListener)) {
                this.confimingTMCMessage = true;
            }
        } else {
            propertyListener.requestError(65, this);
        }
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    private static boolean inputParametersValid(TMCinfo_SetGet tMCinfo_SetGet) {
        boolean bl;
        switch (tMCinfo_SetGet.messageStatus) {
            case 0: 
            case 1: 
            case 3: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private int nextMessageID() {
        return this.nextMessageID++ % 15 + 0;
    }

    private void setNextCurrentTMCinfoMessage() {
        Long l = (Long)this.waitingForConfirmationTMCInfoMessages.keySet().iterator().next();
        this.currentTMCInfoMessage = (TMCinfo_Status)this.waitingForConfirmationTMCInfoMessages.get(l);
        this.currentTMCInfoMessageID = l;
        this.waitingForConfirmationTMCInfoMessages.remove(l);
    }

    private void setNextCurrentEmptyTMCinfoMessage() {
        this.currentTMCInfoMessage.reset();
        this.currentTMCInfoMessage.messageId = INVALID_MESSAGE_ID;
        this.currentTMCInfoMessage.tmcinfo.length_Unit = 255;
        this.currentTMCInfoMessageID = INVALID_MESSAGE_ID;
    }

    private boolean confirmTMCMessageInternal(TMCinfo_SetGet tMCinfo_SetGet, PropertyListener propertyListener) {
        boolean bl;
        TMCinfo_Status tMCinfo_Status = this.dequeueBAPEntity();
        if (this.currentTMCInfoMessage.messageId == tMCinfo_SetGet.messageId && this.currentTMCInfoMessage.messageId != INVALID_MESSAGE_ID) {
            CONFIRMED_TMC_MESSAGES.put(new Long(this.messageIDMap.get(this.currentTMCInfoMessage.messageId)), this.currentTMCInfoMessage);
            if (this.waitingForConfirmationTMCInfoMessages.size() != 0) {
                this.setNextCurrentTMCinfoMessage();
                this.currentTMCInfoMessage.messageStatus = 1;
                this.currentTMCInfoMessage.messageWaitingIndication = this.waitingForConfirmationTMCInfoMessages.size() > 1 ? 2 : 1;
            } else {
                this.setNextCurrentEmptyTMCinfoMessage();
            }
            bl = true;
        } else {
            bl = false;
        }
        TMCinfo.copyTmcMessageFrom(this.currentTMCInfoMessage, tMCinfo_Status);
        this.sendTMCInfoStatus(tMCinfo_Status, propertyListener);
        return bl;
    }

    private static void copyTmcMessageFrom(TMCinfo_Status tMCinfo_Status, TMCinfo_Status tMCinfo_Status2) {
        tMCinfo_Status2.messageId = tMCinfo_Status.messageId;
        tMCinfo_Status2.messageStatus = tMCinfo_Status.messageStatus;
        tMCinfo_Status2.messageWaitingIndication = tMCinfo_Status.messageWaitingIndication;
        tMCinfo_Status2.tmcinfo.infotext.setContent(tMCinfo_Status.tmcinfo.infotext);
        tMCinfo_Status2.tmcinfo.length_Unit = tMCinfo_Status.tmcinfo.length_Unit;
        tMCinfo_Status2.tmcinfo.length_Validity.lengthValid = tMCinfo_Status.tmcinfo.length_Validity.lengthValid;
        tMCinfo_Status2.tmcinfo.length_Value = tMCinfo_Status.tmcinfo.length_Value;
        tMCinfo_Status2.tmcinfo.location.setContent(tMCinfo_Status.tmcinfo.location);
        tMCinfo_Status2.tmcinfo.priority = tMCinfo_Status.tmcinfo.priority;
        tMCinfo_Status2.tmcinfo.streetName.setContent(tMCinfo_Status.tmcinfo.streetName);
    }

    private void sendTMCInfoStatus(TMCinfo_Status tMCinfo_Status, PropertyListener propertyListener) {
        this.messageTransmissionGoingOn = true;
        if (propertyListener != null) {
            propertyListener.statusProperty(tMCinfo_Status, this);
        } else {
            this.getDelegate().getPropertyListener(this).statusProperty(tMCinfo_Status, this);
        }
    }

    private boolean queueCurrentTMCInfoMessages() {
        Iterator iterator = this.getNavigationService().getTMCInfos();
        this.waitingForConfirmationTMCInfoMessages.clear();
        boolean bl = true;
        while (iterator.hasNext()) {
            NavigationTMCInfoElement navigationTMCInfoElement = (NavigationTMCInfoElement)iterator.next();
            long l = navigationTMCInfoElement.getMessageId();
            Long l2 = new Long(l);
            TMCinfo_Status tMCinfo_Status = new TMCinfo_Status();
            tMCinfo_Status.tmcinfo.priority = navigationTMCInfoElement.getPriority();
            tMCinfo_Status.tmcinfo.streetName.setContent(navigationTMCInfoElement.getStreetName());
            tMCinfo_Status.tmcinfo.location.setContent(navigationTMCInfoElement.getLocation());
            tMCinfo_Status.tmcinfo.infotext.setContent(navigationTMCInfoElement.getText());
            int[] nArray = new int[2];
            switch (this.getSystemService().getCurrentDistanceUnit()) {
                case 1: {
                    this.getFixFormatter().cnv2Distance1Miles(navigationTMCInfoElement.getLength(), nArray);
                    break;
                }
                default: {
                    this.getFixFormatter().cnv2Distance1Kilometers(navigationTMCInfoElement.getLength(), nArray);
                }
            }
            tMCinfo_Status.tmcinfo.length_Unit = nArray[1];
            tMCinfo_Status.tmcinfo.length_Value = nArray[0];
            boolean bl2 = tMCinfo_Status.tmcinfo.length_Validity.lengthValid = tMCinfo_Status.tmcinfo.length_Value != 0;
            if (!CONFIRMED_TMC_MESSAGES.containsKey(l2)) {
                int n;
                tMCinfo_Status.messageId = n = this.nextMessageID();
                this.waitingForConfirmationTMCInfoMessages.put(l2, tMCinfo_Status);
                this.messageIDMap.put(n, l);
                continue;
            }
            if (this.currentTMCInfoMessageID != l || this.currentTMCInfoMessageID == (long)INVALID_MESSAGE_ID) continue;
            bl = false;
        }
        return bl;
    }

    private TMCinfo_Status checkQueuedTMCInfoMessages(boolean bl) {
        TMCinfo_Status tMCinfo_Status = this.dequeueBAPEntity();
        if (this.waitingForConfirmationTMCInfoMessages.size() == 0) {
            if (bl) {
                tMCinfo_Status.messageId = 15;
                tMCinfo_Status.messageStatus = 0;
                tMCinfo_Status.messageWaitingIndication = 0;
                tMCinfo_Status.tmcinfo.length_Unit = 255;
                this.setNextCurrentEmptyTMCinfoMessage();
            } else {
                tMCinfo_Status = null;
            }
        } else if (this.currentTMCInfoMessageID == (long)INVALID_MESSAGE_ID) {
            this.setNextCurrentTMCinfoMessage();
            this.currentTMCInfoMessage.messageStatus = 1;
            this.currentTMCInfoMessage.messageWaitingIndication = this.waitingForConfirmationTMCInfoMessages.size() > 1 ? 2 : 1;
            TMCinfo.copyTmcMessageFrom(this.currentTMCInfoMessage, tMCinfo_Status);
        } else if (this.messageTransmissionGoingOn) {
            TMCinfo.copyTmcMessageFrom(this.currentTMCInfoMessage, tMCinfo_Status);
            tMCinfo_Status.messageWaitingIndication = this.waitingForConfirmationTMCInfoMessages.size() > 1 ? 2 : 1;
        } else {
            tMCinfo_Status.messageId = 15;
            tMCinfo_Status.messageStatus = 1;
            tMCinfo_Status.messageWaitingIndication = 2;
            tMCinfo_Status.tmcinfo.length_Unit = 255;
        }
        return tMCinfo_Status;
    }

    protected void naviTmcXUrgentMsgConfirmed() {
        if (this.currentTMCInfoMessage.messageId != INVALID_MESSAGE_ID && !this.confimingTMCMessage) {
            TMCinfo_SetGet tMCinfo_SetGet = new TMCinfo_SetGet();
            tMCinfo_SetGet.messageId = this.currentTMCInfoMessage.messageId;
            this.confirmTMCMessageInternal(tMCinfo_SetGet, null);
        }
        this.confimingTMCMessage = false;
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 73: {
                this.naviTmcXUrgentMsgConfirmed();
                break;
            }
        }
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
        this.process(-1);
    }

    @Override
    public void updateNavigationData(NavigationService navigationService, int n) {
        this.process(-1);
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
        CONFIRMED_TMC_MESSAGES = new TMCinfo$1();
        NAVIGATION_LISTENER_IDS = new int[]{743};
        NAVIGATION_LISTENER__HMI_EVENT_IDS = new int[]{73};
        SYSTEM_LISTENER_IDS = new int[]{1584};
    }
}

