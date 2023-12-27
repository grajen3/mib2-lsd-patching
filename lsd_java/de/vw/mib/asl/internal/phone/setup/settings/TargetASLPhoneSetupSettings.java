/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup.settings;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.api.impl.PhoneServiceImpl;
import de.vw.mib.asl.internal.phone.setup.settings.TargetASLPhoneSetupSettings$NadListener;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;

public class TargetASLPhoneSetupSettings
extends TripleMobileEquipment {
    private ASLAPISpellerBinding spellerHsmMobilbox;
    ValetParkingListener valetParkingListener;
    ValetParkingCallback valetParkingCallback;
    private boolean enableNADInitiated = false;
    private boolean alreadyRegistered = false;
    private boolean phoneModuleToBeRestored;
    private boolean enableBtAfterNadOn;
    private ActivationStateStruct nadActivationState;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener;

    public TargetASLPhoneSetupSettings(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5263;
    }

    @Override
    protected void powerOn() {
        if (!this.alreadyRegistered) {
            this.addObserver(621019200);
            this.addObserver(637796416);
            this.addObserver(822345792);
            this.addObserver(0x34040040);
            this.addObserver(889454656);
            this.addObserver(923009088);
            this.addObserver(956563520);
            this.addObserver(-816048832);
            this.addObserver(0x33040040);
            this.addObserver(587464768);
            this.addObserver(-581167808);
            this.addObserver(839123008);
            this.addObserver(939786304);
            this.addObserver(-2064763392);
            this.addObserver(-1561446912);
            this.addObserver(-1326565888);
            this.addObserver(513622272);
            this.spellerHsmMobilbox = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createBlockAwareCursor(1249, -581167808, 839123008, -2064763392, 0x33040040, 939786304);
        }
        this.alreadyRegistered = true;
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return new int[]{15, 17, 4};
        }
        return ASLPhoneData.EMPTY_NOTIFICATION;
    }

    @Override
    protected int[] getMobileEquipmentHfpOnlyNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return ASLPhoneData.EMPTY_NOTIFICATION;
        }
        return new int[]{15, 17};
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 4300062: {
                break;
            }
            case 3600034: {
                boolean bl = eventGeneric.getBoolean(0);
                if (!bl) break;
                this.switchPhoneFunctionalityOn();
                break;
            }
            case 3600048: {
                this.switchPhoneFunctionalityOff();
                break;
            }
            case 1073742885: {
                boolean bl = eventGeneric.getBoolean(0);
                this.switchNadState(bl);
                break;
            }
            case 1073742886: {
                boolean bl = eventGeneric.getBoolean(0);
                this.getPrimary().requestSetPrivacyMode(bl);
                break;
            }
            case 1073742897: {
                break;
            }
            case 0x40000434: {
                this.spellerHsmMobilbox.resetSpellerData();
                break;
            }
            case 1073742901: {
                String string = eventGeneric.getString(0);
                this.spellerHsmMobilbox.initSpeller(string);
                break;
            }
            case 1075141839: {
                boolean bl = eventGeneric.getBoolean(0);
                AbstractASLHsmTarget.writeBooleanToDatapool(1127358464, bl);
                break;
            }
            case 1073742903: {
                String string = PhoneUtil.trimNumber(eventGeneric.getString(0));
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-2064763392);
                eventGeneric2.setString(0, string);
                this.send(eventGeneric2);
                break;
            }
            case 1073742905: {
                String string = this.spellerHsmMobilbox.getSpellerData().getEnteredText();
                MailboxDialingNumber mailboxDialingNumber = new MailboxDialingNumber();
                mailboxDialingNumber.alphaIdentifierValid = false;
                mailboxDialingNumber.extConfCapValid = false;
                mailboxDialingNumber.extInfoValid = false;
                mailboxDialingNumber.mailboxIdentifier = 0;
                mailboxDialingNumber.mailboxNumber = string;
                mailboxDialingNumber.tonNpiValid = false;
                this.getPrimary().requestSetMailboxContent(new MailboxDialingNumber[]{mailboxDialingNumber});
                break;
            }
            case 1073742883: {
                boolean bl = eventGeneric.getBoolean(0);
                this.getPrimary().requestSetAutomaticEmergencyCallActive(bl);
                break;
            }
            case 3600004: 
            case 1073742898: 
            case 0x40000433: 
            case 1073742904: 
            case 1075141853: {
                this.spellerHsmMobilbox.handleEvent(eventGeneric);
                break;
            }
        }
    }

    private void switchPhoneFunctionalityOn() {
        if (ASLPhoneData.getInstance().nadState != 6 && ASLPhoneData.getInstance().nadState != 0 && ASLPhoneData.getInstance().nadState != 5 && ASLPhoneData.getInstance().nadState != 4 && ASLPhoneData.getInstance().nadState != 1) {
            if (this.phoneModuleToBeRestored && (ASLPhoneData.getInstance().nadState == 3 || ASLPhoneData.getInstance().nadState == 8)) {
                this.switchNadState(true);
                this.phoneModuleToBeRestored = false;
                this.enableBtAfterNadOn = true;
            } else {
                this.enableBT();
            }
        }
    }

    private void switchPhoneFunctionalityOff() {
        if (ASLPhoneData.getInstance().nadState == 2 || ASLPhoneData.getInstance().nadState == 7) {
            this.switchNadState(false);
            this.phoneModuleToBeRestored = true;
        }
    }

    private void enableBT() {
        this.triggerObserver(-1343343104, null);
    }

    private void switchNadState(boolean bl) {
        this.enableNADInitiated = bl;
        this.getNad().requestTelPower(this.enableNADInitiated ? 1 : 0);
    }

    public void dsiMobileEquipmentUpdateMailboxContent(MailboxDialingNumber[] mailboxDialingNumberArray, int n) {
        if (!Util.isNullOrEmpty(mailboxDialingNumberArray)) {
            TargetASLPhoneSetupSettings.writeStringToDatapool(1248, mailboxDialingNumberArray[0].mailboxNumber);
            ASLPhoneData.getInstance().mailboxNumber = mailboxDialingNumberArray[0].mailboxNumber;
            PhoneServiceImpl.getInstance().getSpecialNumbersUpdater().updateMailboxNumbers(mailboxDialingNumberArray[0].mailboxNumber);
        } else {
            TargetASLPhoneSetupSettings.writeStringToDatapool(1248, "");
            ASLPhoneData.getInstance().mailboxNumber = "";
            PhoneServiceImpl.getInstance().getSpecialNumbersUpdater().updateMailboxNumbers("");
        }
        this.send(ServiceManager.mGenericEventFactory.newEvent(5263, 5255, -1880214016));
        this.send(ServiceManager.mGenericEventFactory.newEvent(5263, 5272, -1880214016));
    }

    public void dsiMobileEquipmentResponseSetPrivacyMode(int n) {
        if (n == 0) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
            eventGeneric.setInt(0, 106);
            this.send(eventGeneric);
        }
    }

    @Override
    protected DSIMobileEquipmentListener createPrimaryListener() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        return (DSIMobileEquipmentListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener = TargetASLPhoneSetupSettings.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener);
    }

    @Override
    protected DSIMobileEquipmentListener createNadListener() {
        return new TargetASLPhoneSetupSettings$NadListener(this, null);
    }

    static /* synthetic */ ActivationStateStruct access$000(TargetASLPhoneSetupSettings targetASLPhoneSetupSettings) {
        return targetASLPhoneSetupSettings.nadActivationState;
    }

    static /* synthetic */ void access$100(TargetASLPhoneSetupSettings targetASLPhoneSetupSettings, boolean bl) {
        targetASLPhoneSetupSettings.switchNadState(bl);
    }

    static /* synthetic */ boolean access$200(TargetASLPhoneSetupSettings targetASLPhoneSetupSettings) {
        return targetASLPhoneSetupSettings.enableNADInitiated;
    }

    static /* synthetic */ boolean access$300(TargetASLPhoneSetupSettings targetASLPhoneSetupSettings) {
        return targetASLPhoneSetupSettings.enableBtAfterNadOn;
    }

    static /* synthetic */ void access$400(TargetASLPhoneSetupSettings targetASLPhoneSetupSettings) {
        targetASLPhoneSetupSettings.enableBT();
    }

    static /* synthetic */ boolean access$302(TargetASLPhoneSetupSettings targetASLPhoneSetupSettings, boolean bl) {
        targetASLPhoneSetupSettings.enableBtAfterNadOn = bl;
        return targetASLPhoneSetupSettings.enableBtAfterNadOn;
    }

    static /* synthetic */ ActivationStateStruct access$002(TargetASLPhoneSetupSettings targetASLPhoneSetupSettings, ActivationStateStruct activationStateStruct) {
        targetASLPhoneSetupSettings.nadActivationState = activationStateStruct;
        return targetASLPhoneSetupSettings.nadActivationState;
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

