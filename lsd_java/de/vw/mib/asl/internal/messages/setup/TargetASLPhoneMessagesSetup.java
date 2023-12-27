/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.setup;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.messages.AbstractASLMessagesTarget;
import de.vw.mib.asl.internal.messages.setup.TargetASLPhoneMessagesSetup$Reset;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingServiceConfiguration;

public class TargetASLPhoneMessagesSetup
extends AbstractASLMessagesTarget {
    public static final String[] NEEDED_PHONE_DSIS = new String[]{RuntimeGeneratedConstants.SERVICE_TS_NS[72]};
    protected DSIMessagingServiceConfiguration dsiMessagingServiceConfiguration;
    protected DSIListener dsiMessagingServiceConfigurationListener;
    private SpellerData spellerServiceNumberData = new SpellerData();
    private boolean automaticAccount = false;
    private boolean alreadyRegistered = false;
    private FactoryResetCallback factoryResetCallback = null;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener;

    public TargetASLPhoneMessagesSetup(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5275;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiMessagingServiceConfiguration = (DSIMessagingServiceConfiguration)dSIProxy.getService(this, class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration == null ? (class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration = TargetASLPhoneMessagesSetup.class$("org.dsi.ifc.messaging.DSIMessagingServiceConfiguration")) : class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration);
            this.dsiMessagingServiceConfigurationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener == null ? (class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener = TargetASLPhoneMessagesSetup.class$("org.dsi.ifc.messaging.DSIMessagingServiceConfigurationListener")) : class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener == null ? (class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener = TargetASLPhoneMessagesSetup.class$("org.dsi.ifc.messaging.DSIMessagingServiceConfigurationListener")) : class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener, this.dsiMessagingServiceConfigurationListener);
            this.addObserver(-1744764864);
            this.addObserver(-1727987648);
            this.addObserver(-1711210432);
            this.addObserver(-1694433216);
            this.addObserver(-1677656000);
            this.addObserver(-1644101568);
            this.addObserver(-1895759808);
            this.addObserver(-1845428160);
            this.addObserver(-1878982592);
            this.addObserver(-1862205376);
        }
        this.alreadyRegistered = true;
    }

    private void setNotification() {
        this.dsiMessagingServiceConfiguration.setNotification(new int[]{4, 1, 2, 3}, this.dsiMessagingServiceConfigurationListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.init();
                this.setNotification();
                this.automaticAccount = ASLPhoneFactory.getPhoneApi().getPersistence().isAutomaticMessagingAccount();
                TargetASLPhoneMessagesSetup.writeBooleanToDatapool(474, this.automaticAccount);
                FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
                factoryResetService.addParticipant(new TargetASLPhoneMessagesSetup$Reset(this, null), FactoryResetComponents.PHONE);
                break;
            }
            case 1073742232: {
                break;
            }
            case 1073742234: {
                this.spellerServiceNumberData.setEnteredText("");
                TargetASLPhoneMessagesSetup.writeSpellerDataToDatapool(482, this.spellerServiceNumberData);
                break;
            }
            case 1073742235: {
                String string = eventGeneric.getString(0);
                this.spellerServiceNumberData.setEnteredText(string);
                this.spellerServiceNumberData.setCursorPosition(this.spellerServiceNumberData.getEnteredText().length());
                TargetASLPhoneMessagesSetup.writeSpellerDataToDatapool(482, this.spellerServiceNumberData);
                break;
            }
            case 1073742238: {
                String string = this.spellerServiceNumberData.getEnteredText();
                if (string.equals("")) break;
                this.dsiMessagingServiceConfiguration.setSMSCNumberRequest(string);
                TargetASLPhoneMessagesSetup.writeStringToDatapool(481, string);
                break;
            }
            case 1073742236: {
                String string = eventGeneric.getString(0);
                this.handleNumberSpellerSetCharacter(string);
                break;
            }
            case 1073742233: {
                if (Util.isNullOrEmpty(this.spellerServiceNumberData.getEnteredText())) break;
                this.spellerServiceNumberData.setEnteredText(this.spellerServiceNumberData.getEnteredText().substring(0, this.spellerServiceNumberData.getEnteredText().length() - 1));
                this.spellerServiceNumberData.setCursorPosition(this.spellerServiceNumberData.getEnteredText().length());
                TargetASLPhoneMessagesSetup.writeSpellerDataToDatapool(482, this.spellerServiceNumberData);
                break;
            }
            case 1073742223: {
                this.automaticAccount = !this.automaticAccount;
                ASLPhoneFactory.getPhoneApi().getPersistence().setAutomaticMessagingAccount(this.automaticAccount);
                TargetASLPhoneMessagesSetup.writeBooleanToDatapool(474, this.automaticAccount);
                break;
            }
            case 1073742226: {
                int n = eventGeneric.getInt(0);
                int n2 = this.convertValidityPeriodASL2DSI(n);
                if (n2 == -1) break;
                this.dsiMessagingServiceConfiguration.setShortMessageValidityPeriodRequest(n2);
                break;
            }
            case 1073742224: {
                boolean bl = eventGeneric.getBoolean(0);
                this.dsiMessagingServiceConfiguration.activateSmsDeliveryReportRequest(bl);
                break;
            }
            case 1073742225: {
                boolean bl = eventGeneric.getBoolean(0);
                this.dsiMessagingServiceConfiguration.activateStoreSmsOnSentRequest(bl);
                break;
            }
        }
    }

    private int convertValidityPeriodASL2DSI(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 4;
            }
            case 4: {
                return 5;
            }
            case 5: {
                return 6;
            }
        }
        return -1;
    }

    private int convertValidityPeriodDSI2ASL(int n) {
        switch (n) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 5;
            }
        }
        return 0;
    }

    private void handleNumberSpellerSetCharacter(String string) {
        this.spellerServiceNumberData.setEnteredText(new StringBuffer().append(this.spellerServiceNumberData.getEnteredText()).append(string).toString());
        this.spellerServiceNumberData.setCursorPosition(this.spellerServiceNumberData.getEnteredText().length());
        TargetASLPhoneMessagesSetup.writeSpellerDataToDatapool(482, this.spellerServiceNumberData);
    }

    public void dsiMessagingServiceConfigurationUpdateStoreSmsOnSent(boolean bl, int n) {
        TargetASLPhoneMessagesSetup.writeBooleanToDatapool(476, bl);
    }

    public void dsiMessagingServiceConfigurationUpdateShortMessageValidityPeriod(int n, int n2) {
        int n3 = this.convertValidityPeriodDSI2ASL(n);
        TargetASLPhoneMessagesSetup.writeIntegerToDatapool(473, n3);
    }

    public void dsiMessagingServiceConfigurationUpdateSMSCNumber(String string, int n) {
        TargetASLPhoneMessagesSetup.writeStringToDatapool(481, string);
    }

    public void dsiMessagingServiceConfigurationUpdateSmsDeliveryReport(boolean bl, int n) {
        TargetASLPhoneMessagesSetup.writeBooleanToDatapool(475, bl);
    }

    public void dsiMessagingServiceConfigurationRestoreFactorySettingsResponse(int n) {
        if (this.factoryResetCallback != null) {
            this.factoryResetCallback.notifyResetDone();
            this.factoryResetCallback = null;
        }
    }

    public void dsiMessagingServiceConfigurationAsyncException(int n, String string, int n2) {
        switch (n2) {
            case 1010: {
                if (this.factoryResetCallback == null) break;
                this.factoryResetCallback.notifyResetDone();
                this.factoryResetCallback = null;
                break;
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ FactoryResetCallback access$102(TargetASLPhoneMessagesSetup targetASLPhoneMessagesSetup, FactoryResetCallback factoryResetCallback) {
        targetASLPhoneMessagesSetup.factoryResetCallback = factoryResetCallback;
        return targetASLPhoneMessagesSetup.factoryResetCallback;
    }
}

