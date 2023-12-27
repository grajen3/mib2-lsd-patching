/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup.call;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.setup.call.transformer.PhoneSetupCallCallForwardingsCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.phone.setup.call.transformer.PhoneSetupCallCallSettingsCollector;
import org.dsi.ifc.telephoneng.CFRequestData;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;

public class TargetASLPhoneCallSetup
extends TripleMobileEquipment {
    private ASLAPISpellerBinding spellerHsmCallSettings;
    private int cfListId;
    private int cfState;
    private int cfCondition;
    private int cfTime;
    private boolean triggerRequestCLIR;
    private boolean isCallForwardRequesting = false;
    private boolean alreadyRegistered = false;
    private CFRequestData[] cfRequestDataArray;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener;

    public TargetASLPhoneCallSetup(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5265;
    }

    @Override
    protected void powerOn() {
        if (!this.alreadyRegistered) {
            this.addObserver(-335347648);
            this.addObserver(-318570432);
            this.addObserver(-150798272);
            this.addObserver(-167575488);
            this.addObserver(-134021056);
            this.addObserver(-251461568);
            this.addObserver(-1034152640);
            this.addObserver(-301793216);
            this.addObserver(-217907136);
            this.addObserver(-665053888);
            this.addObserver(-184352704);
            this.addObserver(-100466624);
            this.spellerHsmCallSettings = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(1206, -665053888, -184352704, -100466624);
            Object[] objectArray = (PhoneSetupCallCallSettingsCollector[])ListManager.getGenericASLList(1211).getDSIObjects();
            if (objectArray.length == 0) {
                objectArray = new PhoneSetupCallCallSettingsCollector[]{new PhoneSetupCallCallSettingsCollector()};
            }
            objectArray[0].phone_setup_call_call_setting_automatic_accept_call_active = false;
            objectArray[0].phone_setup_call_call_setting_state_call_waiting = 0;
            objectArray[0].phone_setup_call_call_setting_state_send_calling_id__1 = 0;
            ListManager.getGenericASLList(1211).updateList(objectArray);
            ListManager.getGenericASLList(1210).updateList(new PhoneSetupCallCallForwardingsCollector[]{new PhoneSetupCallCallForwardingsCollector(0, "", 0), new PhoneSetupCallCallForwardingsCollector(1, "", 0), new PhoneSetupCallCallForwardingsCollector(2, "", 0), new PhoneSetupCallCallForwardingsCollector(3, "", 0)});
        }
        this.alreadyRegistered = true;
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        return new int[]{10};
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742828: {
                if (this.isCallForwardRequesting) break;
                this.isCallForwardRequesting = true;
                CFRequestData cFRequestData = new CFRequestData(2, 0, "", 1, 0);
                CFRequestData cFRequestData2 = new CFRequestData(2, 1, "", 1, 0);
                CFRequestData cFRequestData3 = new CFRequestData(2, 3, "", 1, 0);
                CFRequestData cFRequestData4 = new CFRequestData(2, 2, "", 1, 0);
                this.cfRequestDataArray = new CFRequestData[]{cFRequestData, cFRequestData2, cFRequestData3, cFRequestData4};
                this.getPrimary().requestCallForward(this.cfRequestDataArray);
                PhoneUtil.updateCFStatusRequesting(this.cfRequestDataArray);
                break;
            }
            case 1073742829: {
                this.triggerRequestCLIR = true;
                this.getPrimary().requestCallWaiting(2);
                PhoneUtil.updateCWStatusRequesting();
                PhoneUtil.updateCLIRStatusRequesting();
                break;
            }
            case 1073742833: {
                int n = -1;
                switch (eventGeneric.getInt(0)) {
                    case 0: {
                        n = 2;
                        PhoneSetupCallCallSettingsCollector phoneSetupCallCallSettingsCollector = (PhoneSetupCallCallSettingsCollector)ListManager.getGenericASLList(1211).getRowItem(0);
                        phoneSetupCallCallSettingsCollector.phone_setup_call_call_setting_state_call_waiting = 1;
                        ListManager.getGenericASLList(1211).updateList(new PhoneSetupCallCallSettingsCollector[]{phoneSetupCallCallSettingsCollector});
                        break;
                    }
                    case 1: {
                        n = 1;
                        break;
                    }
                    case 2: {
                        n = 0;
                        break;
                    }
                }
                if (n == -1) break;
                this.getPrimary().requestCallWaiting(n);
                PhoneUtil.updateCWStatusRequesting();
                break;
            }
            case 1073742830: {
                this.cfListId = eventGeneric.getInt(0);
                this.cfState = eventGeneric.getInt(1);
                int n = -1;
                this.cfCondition = -1;
                this.cfTime = 0;
                switch (this.cfState) {
                    case 0: {
                        n = 2;
                        PhoneSetupCallCallForwardingsCollector phoneSetupCallCallForwardingsCollector = (PhoneSetupCallCallForwardingsCollector)ListManager.getGenericASLList(1210).getRowItem(this.cfListId);
                        phoneSetupCallCallForwardingsCollector.state = 1;
                        ListManager.getGenericASLList(1210).updateListItem(this.cfListId, phoneSetupCallCallForwardingsCollector);
                        break;
                    }
                    case 1: {
                        break;
                    }
                    case 2: {
                        n = 4;
                        break;
                    }
                }
                switch (this.cfListId) {
                    case 0: {
                        this.cfCondition = 0;
                        break;
                    }
                    case 1: {
                        this.cfCondition = 1;
                        break;
                    }
                    case 2: {
                        this.cfCondition = 3;
                        break;
                    }
                    case 3: {
                        this.cfCondition = 2;
                        this.cfTime = 20;
                        break;
                    }
                }
                if (n == -1 || this.cfCondition == -1) break;
                this.cfRequestDataArray = new CFRequestData[]{new CFRequestData(n, this.cfCondition, "", 1, (short)this.cfTime)};
                this.isCallForwardRequesting = true;
                this.getPrimary().requestCallForward(this.cfRequestDataArray);
                PhoneUtil.updateCFStatusRequesting(this.cfRequestDataArray);
                break;
            }
            case 1075141826: {
                int n = -1;
                switch (eventGeneric.getInt(0)) {
                    case 0: {
                        n = 3;
                        PhoneSetupCallCallSettingsCollector phoneSetupCallCallSettingsCollector = (PhoneSetupCallCallSettingsCollector)ListManager.getGenericASLList(1211).getRowItem(0);
                        phoneSetupCallCallSettingsCollector.phone_setup_call_call_setting_state_send_calling_id__1 = 1;
                        ListManager.getGenericASLList(1211).updateList(new PhoneSetupCallCallSettingsCollector[]{phoneSetupCallCallSettingsCollector});
                        break;
                    }
                    case 1: {
                        n = 2;
                        break;
                    }
                    case 2: {
                        n = 1;
                        break;
                    }
                    case 3: {
                        n = 0;
                        break;
                    }
                }
                if (n == -1) break;
                this.getPrimary().requestCLIR(n);
                PhoneUtil.updateCLIRStatusRequesting();
                break;
            }
            case 1073742838: 
            case 1073742839: {
                this.spellerHsmCallSettings.initSpeller(eventGeneric.getString(0));
                break;
            }
            case 1073742840: {
                this.cfRequestDataArray = new CFRequestData[]{new CFRequestData(3, this.cfCondition, this.spellerHsmCallSettings.getSpellerData().getEnteredText(), 1, (short)this.cfTime)};
                this.isCallForwardRequesting = true;
                this.getPrimary().requestCallForward(this.cfRequestDataArray);
                PhoneUtil.updateCFStatusRequesting(this.cfRequestDataArray);
                break;
            }
            case 1073742835: {
                this.getPrimary().requestSetCDMAThreeWayCallingSetting(eventGeneric.getBoolean(0));
                break;
            }
            case 1073742837: 
            case 1073742842: 
            case 1075141848: {
                this.spellerHsmCallSettings.handleEvent(eventGeneric);
                break;
            }
        }
    }

    public void dsiMobileEquipmentResponseCallWaiting(int n, int n2) {
        if (n2 == 0) {
            PhoneUtil.updateCWStatus(n);
        } else {
            PhoneUtil.updateCWStatus(-1);
        }
        if (this.triggerRequestCLIR) {
            this.getPrimary().requestCLIR(3);
            this.triggerRequestCLIR = false;
        }
    }

    public void dsiMobileEquipmentResponseCallForward(CFResponseData[] cFResponseDataArray, int n) {
        this.isCallForwardRequesting = false;
        PhoneUtil.updateCFStatus(cFResponseDataArray, this.cfRequestDataArray);
    }

    public void dsiMobileEquipmentResponseCLIR(int n, int n2, int n3) {
        if (n3 == 0) {
            PhoneUtil.updateCLIRStatus(n, n2);
        } else {
            PhoneUtil.updateCLIRStatus(-1, -1);
        }
    }

    public void dsiMobileEquipmentUpdateCDMAThreeWayCallingSetting(boolean bl, int n) {
        ASLPhoneData.getInstance().isThreewaySettingEnabled = bl;
        TargetASLPhoneCallSetup.writeBooleanToDatapool(1209, bl);
    }

    public void dsiMobileEquipmentAsyncException(int n, String string, int n2) {
        if (n2 == 1012) {
            PhoneSetupCallCallForwardingsCollector[] phoneSetupCallCallForwardingsCollectorArray = (PhoneSetupCallCallForwardingsCollector[])ListManager.getGenericASLList(1210).getDSIObjects();
            for (int i2 = 0; i2 < phoneSetupCallCallForwardingsCollectorArray.length; ++i2) {
                phoneSetupCallCallForwardingsCollectorArray[i2].state = 0;
                phoneSetupCallCallForwardingsCollectorArray[i2].number = "";
            }
            this.isCallForwardRequesting = false;
        } else if (n2 == 1013 && this.triggerRequestCLIR) {
            this.getPrimary().requestCLIR(3);
            this.triggerRequestCLIR = false;
        }
    }

    @Override
    protected DSIMobileEquipmentListener createPrimaryListener() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        return (DSIMobileEquipmentListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener = TargetASLPhoneCallSetup.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener);
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

