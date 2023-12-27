/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.api.vicsetc.ASLVICSETCFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.vicsetc.EtcTarget$1;
import de.vw.mib.asl.internal.vicsetc.api.impl.ASLVICSETCAPIImpl;
import de.vw.mib.asl.internal.vicsetc.datapool.ASLVicsEtcDatapool;
import de.vw.mib.asl.internal.vicsetc.factoryReset.VicsEtcFactoryReset;
import de.vw.mib.asl.internal.vicsetc.tollcollect.transformer.VICSETCTollCollectETCPaymentHistoryCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.vicsetc.setup.transformer.VICSETCSetupCardReaderInformationCollector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.tollcollect.DSITollCollect;
import org.dsi.ifc.tollcollect.TCCardDateInformation;
import org.dsi.ifc.tollcollect.TCCardError;
import org.dsi.ifc.tollcollect.TCHardwareInformation;
import org.dsi.ifc.tollcollect.TCPaymentInfo;
import org.dsi.ifc.tollcollect.TCPaymentInfoDetails;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class EtcTarget
extends AbstractASLTarget
implements DSIServiceStateListener {
    private static final int[] OBSERVER = new int[]{208885056, 225662272, 426988864, 460543296, 443766080, 192107840, 175330624, 242439488, 1134297088, -459521792, 295326976};
    private static final DSIProxy DSI_PROXY = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    private DSITollCollect dsiTollCollect;
    private DSIListener dsiTollCollectListener;
    private boolean isServiceStateListenerAdded = false;
    private boolean isSpeechPromptEngineReady = false;
    private ASLVicsEtcDatapool vicsEtcDP;
    private int cardState;
    private TCCardError cardError;
    private HashMap idToPaymentInfo = new HashMap();
    private int paymentHistoryDetailsCounter = 0;
    private static final double CURRENCY_DIVIDER;
    private static final int UPPER_TOLL_BOUND;
    private static final int LOWER_TOLL_BOUND;
    private static final int NO_MESSAGE_SELECTED;
    private static final int NO_POPUP_TYPE_SELECTED;
    private String m_language = "";
    private String newLanguage;
    private int transactionId;
    private boolean clamp15On;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$PromptEngine;
    static /* synthetic */ Class class$org$dsi$ifc$tollcollect$DSITollCollect;
    static /* synthetic */ Class class$org$dsi$ifc$tollcollect$DSITollCollectListener;

    public EtcTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.vicsEtcDP = ASLVicsEtcDatapool.getInstance();
        this.vicsEtcDP.initASLDatapool();
        this.cardState = 0;
        this.cardError = new TCCardError(0, "");
        this.initFactoryReset();
        ((ASLVICSETCAPIImpl)ASLVICSETCFactory.getVICSETCApi()).setEtcTarget(this);
    }

    private void initSpeechEngine() {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        ServiceTracker serviceTracker = new ServiceTracker(bundleContext, (class$de$vw$mib$asl$api$speechengine$PromptEngine == null ? (class$de$vw$mib$asl$api$speechengine$PromptEngine = EtcTarget.class$("de.vw.mib.asl.api.speechengine.PromptEngine")) : class$de$vw$mib$asl$api$speechengine$PromptEngine).getName(), (ServiceTrackerCustomizer)new EtcTarget$1(this, bundleContext));
        serviceTracker.open();
    }

    private void initFactoryReset() {
        FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        factoryResetService.addParticipant(new VicsEtcFactoryReset(), FactoryResetComponents.VICS_ETC);
    }

    @Override
    public void registered(String string, int n) {
        this.traceMsg("Electronic Toll Collect Target tries to register");
        String string2 = string.intern();
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[143]) {
            this.dsiTollCollect = (DSITollCollect)DSI_PROXY.getService(this, class$org$dsi$ifc$tollcollect$DSITollCollect == null ? (class$org$dsi$ifc$tollcollect$DSITollCollect = EtcTarget.class$("org.dsi.ifc.tollcollect.DSITollCollect")) : class$org$dsi$ifc$tollcollect$DSITollCollect);
            this.dsiTollCollectListener = DSI_PROXY.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$tollcollect$DSITollCollectListener == null ? (class$org$dsi$ifc$tollcollect$DSITollCollectListener = EtcTarget.class$("org.dsi.ifc.tollcollect.DSITollCollectListener")) : class$org$dsi$ifc$tollcollect$DSITollCollectListener);
            DSI_PROXY.addResponseListener(this, class$org$dsi$ifc$tollcollect$DSITollCollectListener == null ? (class$org$dsi$ifc$tollcollect$DSITollCollectListener = EtcTarget.class$("org.dsi.ifc.tollcollect.DSITollCollectListener")) : class$org$dsi$ifc$tollcollect$DSITollCollectListener, this.dsiTollCollectListener);
            this.dsiTollCollect.setNotification(this.dsiTollCollectListener);
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.traceMsg(new StringBuffer().append("Electronic Toll Collect Target tries to unregister from ").append(string).append("...").toString());
        }
        try {
            if (DSI_PROXY == null) {
                this.traceMsg("DSIProxy was null!");
                return;
            }
            String string2 = string.intern();
            if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[143]) {
                this.unregisterDsiTollCollect(string, DSI_PROXY);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiTollCollect(String string, DSIProxy dSIProxy) {
        if (this.dsiTollCollectListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$tollcollect$DSITollCollectListener == null ? (class$org$dsi$ifc$tollcollect$DSITollCollectListener = EtcTarget.class$("org.dsi.ifc.tollcollect.DSITollCollectListener")) : class$org$dsi$ifc$tollcollect$DSITollCollectListener, this.dsiTollCollectListener);
            if (this.dsiTollCollectListener != null) {
                this.dsiTollCollectListener = null;
            }
            this.traceMsg(new StringBuffer().append("Electronic Toll Collect unregistered from ").append(string).toString());
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.traceMsg("EtcTarget: power_on");
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$tollcollect$DSITollCollect == null ? (class$org$dsi$ifc$tollcollect$DSITollCollect = EtcTarget.class$("org.dsi.ifc.tollcollect.DSITollCollect")) : class$org$dsi$ifc$tollcollect$DSITollCollect, this);
                }
                this.initSpeechEngine();
                this.addObservers(OBSERVER);
                this.notifyLscRegisterNavi();
                break;
            }
            case 107: {
                this.traceMsg("EtcTarget: power_off");
                this.notifyLscDeregisterNavi();
                break;
            }
            case 4300004: {
                boolean bl;
                this.clamp15On = eventGeneric.getBoolean(0);
                this.traceMsg(new StringBuffer().append("Clamp 15 state was set to ").append(this.clamp15On ? "ON" : "OFF").toString());
                boolean bl2 = this.cardState == 2 && this.cardError.cardError == 1;
                boolean bl3 = bl = this.cardState == 4 && this.cardError.cardError == 1;
                if (this.clamp15On || !this.vicsEtcDP.isEtcCardReminderChecked() || !bl2 && !bl) break;
                this.sendHMIEvent(379213056);
                break;
            }
            case 1079341838: {
                this.traceMsg("EtcTarget: ETC Context entered");
                this.dsiTollCollect.requestPaymentHistoryList();
                EtcTarget.writeIntegerToDatapool(513430784, 1);
                EtcTarget.writeBooleanToDatapool(496653568, false);
                break;
            }
            case 5610001: {
                this.traceMsg("EtcTarget: Speech prompt engine ready!");
                this.isSpeechPromptEngineReady = true;
                if (this.cardState != 3 && this.cardState != 1) break;
                this.showLastRecentErrorPopup();
                break;
            }
            case 1079341836: {
                this.vicsEtcDP.setEtcCardNotInsertedChecked(!this.vicsEtcDP.isEtcCardNotInsertedChecked());
                break;
            }
            case 1079341837: {
                this.vicsEtcDP.setEtcCardReminderChecked(!this.vicsEtcDP.isEtcCardReminderChecked());
                break;
            }
            case 1079341835: {
                this.vicsEtcDP.setTollFeeAnnouncementChecked(!this.vicsEtcDP.isTollFeeAnnouncementChecked());
                break;
            }
            case 1079341834: {
                this.vicsEtcDP.setTollFeePopupChecked(!this.vicsEtcDP.isTollFeePopupChecked());
                break;
            }
            case 40003: {
                this.traceMsg("Target Handle-LSC entered LSCTNG_CHANGE_LANGUAGE.");
                this.transactionId = eventGeneric.getInt(0);
                this.newLanguage = eventGeneric.getString(1);
                this.handleLscRequest(this.newLanguage);
                break;
            }
            default: {
                this.traceMsg("EtcTarget: default event");
            }
        }
    }

    private void handleLscRequest(String string) {
        this.dsiTollCollect.setLanguage(string);
    }

    public void dsiTollCollectUpdateCardState(int n, int n2) {
        if (n2 != 1) {
            this.traceMsg("dsiTollCollectUpdateCardState: no valid flag received");
            this.cardState = 0;
            this.updateStatusLineCardState();
            return;
        }
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                this.cardState = n;
                this.traceMsg(new StringBuffer().append("dsiTollCollectUpdateCardState: ").append(this.cardState).toString());
                break;
            }
            default: {
                ServiceManager.logger.error(16, "[ETC Target] DSI card state undefined");
            }
        }
        this.updateStatusLineCardState();
    }

    public void dsiTollCollectUpdateCardError(TCCardError tCCardError, int n) {
        if (n != 1) {
            this.traceMsg("dsiTollCollectUpdateCardError no valid flag");
            return;
        }
        this.cardError = tCCardError;
        this.traceMsg(new StringBuffer().append("dsiTollCollectUpdateCardError: ").append(this.cardError).toString());
        this.updateStatusLineCardState();
        if (this.isSpeechPromptEngineReady) {
            this.showLastRecentErrorPopup();
        }
    }

    private void showLastRecentErrorPopup() {
        int n = this.cardError.getCardError();
        String string = this.cardError.getErrorCode();
        int n2 = 563762432;
        int n3 = -1;
        int n4 = 328881408;
        switch (n) {
            case 10: {
                n2 = 580539648;
                n3 = 3;
                this.traceMsg(new StringBuffer().append("A card error occured. ").append(n3).toString());
                AbstractASLTarget.writeIntegerToDatapool(n2, n3);
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(345658624);
                return;
            }
            case 9: {
                n2 = 580539648;
                n3 = 0;
                this.traceMsg(new StringBuffer().append("A card error occured. ").append(n3).toString());
                AbstractASLTarget.writeIntegerToDatapool(n2, n3);
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(345658624);
                return;
            }
        }
        if (this.cardState == 1) {
            boolean bl;
            this.traceMsg("Checking if conditions are met to trigger no card inserted PO");
            boolean bl2 = bl = n == 1;
            if (this.clamp15On && this.vicsEtcDP.isEtcCardNotInsertedChecked() && bl) {
                this.traceMsg("Trigger no card inserted PO");
                this.sendHMIEvent(395990272);
            }
        }
        if (this.cardState == 3) {
            switch (n) {
                case 6: {
                    if (string.equals("02H")) {
                        n3 = 0;
                    }
                    if (!string.equals("05H")) break;
                    n3 = 1;
                    break;
                }
                case 2: 
                case 14: {
                    n3 = 4;
                    break;
                }
                case 3: {
                    n3 = 5;
                    break;
                }
                case 7: {
                    n3 = 2;
                    break;
                }
                case 4: {
                    n3 = 6;
                    break;
                }
                case 8: {
                    n3 = 3;
                    break;
                }
                case 5: {
                    n3 = 7;
                    break;
                }
                case 11: {
                    n4 = 312104192;
                    break;
                }
                case 12: 
                case 13: {
                    n3 = 8;
                    break;
                }
                case 0: {
                    n4 = -1;
                    this.traceMsg("An unknown card error occured");
                    break;
                }
                case 1: {
                    n4 = -1;
                    this.traceMsg("No error occured");
                    break;
                }
                default: {
                    n4 = -1;
                    this.traceMsg("Received unimplemented error code!");
                }
            }
            if (n3 != -1) {
                AbstractASLTarget.writeIntegerToDatapool(n2, n3);
                this.traceMsg(new StringBuffer().append("A card error occured. ").append(n3).toString());
            }
            if (n4 != -1) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n4);
            }
        }
    }

    public void dsiTollCollectUpdateCardDateInformation(TCCardDateInformation tCCardDateInformation, int n) {
    }

    public void dsiTollCollectUpdateHardwareInformation(TCHardwareInformation[] tCHardwareInformationArray, int n) {
        int n2;
        if (n != 1) {
            return;
        }
        int n3 = 530208000;
        GenericASLList genericASLList = ListManager.getGenericASLList(n3);
        Object[] objectArray = new VICSETCSetupCardReaderInformationCollector[]{new VICSETCSetupCardReaderInformationCollector()};
        block7: for (n2 = 0; n2 < tCHardwareInformationArray.length; ++n2) {
            TCHardwareInformation tCHardwareInformation = tCHardwareInformationArray[n2];
            String string = tCHardwareInformation.getValue();
            switch (tCHardwareInformation.getKey()) {
                case 2: {
                    ((VICSETCSetupCardReaderInformationCollector)objectArray[0]).vicsetc_setup_card_reader_information_identification_number = string;
                    continue block7;
                }
                case 1: {
                    ((VICSETCSetupCardReaderInformationCollector)objectArray[0]).vicsetc_setup_card_reader_information_message_manufacturer_name = string;
                    continue block7;
                }
                case 0: {
                    ((VICSETCSetupCardReaderInformationCollector)objectArray[0]).vicsetc_setup_card_reader_information_message_type_name = string;
                    continue block7;
                }
                case 3: {
                    ((VICSETCSetupCardReaderInformationCollector)objectArray[0]).vicsetc_setup_card_reader_information_message_registered_name = string;
                    continue block7;
                }
                case 4: {
                    ((VICSETCSetupCardReaderInformationCollector)objectArray[0]).vicsetc_setup_card_reader_information_message_serial_production_number = string;
                    continue block7;
                }
                default: {
                    ServiceManager.logger.error(16, "Received implemented hardware information!");
                    continue block7;
                }
            }
        }
        genericASLList.updateList(objectArray);
        n2 = 479876352;
        if (tCHardwareInformationArray.length > 0) {
            EtcTarget.writeBooleanToDatapool(n2, true);
        } else {
            EtcTarget.writeBooleanToDatapool(n2, false);
        }
    }

    public void dsiTollCollectUpdateCurrentTollPayment(NavPriceInfo navPriceInfo, int n) {
        if (n != 1 && !this.vicsEtcDP.isTollFeePopupChecked()) {
            this.traceMsg("dsiTollCollectUpdateCurrentTollPayment received an invalid flag");
            return;
        }
        int n2 = 362435840;
        int n3 = 597316864;
        int n4 = 0;
        int n5 = -2137369344;
        int n6 = 614094080;
        int n7 = this.convertDsiTollAmountToHmiAmount(navPriceInfo);
        this.traceMsg(new StringBuffer().append("updateCurrentTollPayment: raw ").append(navPriceInfo.getAmount()).append(" converted ").append(n7).toString());
        if (0 <= n7) {
            if (n7 <= -1601830656) {
                n4 = 0;
                EtcTarget.writeStringToDatapool(n6, Integer.toString(n7));
                this.traceMsg("dsiTollCollectUpdateCurrentTollPayment: preparing normal toll PO");
            } else {
                n4 = 1;
                EtcTarget.writeStringToDatapool(n6, Integer.toString(-1601830656));
                this.traceMsg("dsiTollCollectUpdateCurrentTollPayment: preparing larger than upper bound toll PO");
            }
        } else if (1618607871 <= n7) {
            n4 = 2;
            EtcTarget.writeStringToDatapool(n6, Integer.toString(Math.abs(n7)));
            this.traceMsg("dsiTollCollectUpdateCurrentTollPayment: preparing normal refund toll PO");
        } else {
            n4 = 3;
            EtcTarget.writeStringToDatapool(n6, Integer.toString(Math.abs(1618607871)));
            this.traceMsg("dsiTollCollectUpdateCurrentTollPayment: preparing smaller than lower bound toll PO");
        }
        EtcTarget.writeIntegerToDatapool(n3, n4);
        EtcTarget.writeIntegerToDatapool(n5, Math.abs(navPriceInfo.getAmount()));
        this.updateStatusLineTollAmount(navPriceInfo.getAmount());
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n2);
        this.traceMsg("dsiTollCollectUpdateCurrentTollPayment: PO triggered");
    }

    private int convertDsiTollAmountToHmiAmount(NavPriceInfo navPriceInfo) {
        if (navPriceInfo == null) {
            return 0;
        }
        int n = navPriceInfo.getAmount();
        switch (navPriceInfo.getCurrency()) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                n = (int)((double)n / 1000.0);
                break;
            }
            case 0: {
                n = 0;
                this.traceMsg("DSITollCollect sent an invalid currency! Setting toll payment to 0.");
                break;
            }
            default: {
                n = 0;
                ServiceManager.logger.error(16, "DSITollCollect sent a currency that is not yet supported!");
            }
        }
        return n;
    }

    public void dsiTollCollectRequestPaymentHistoryListResult(TCPaymentInfo[] tCPaymentInfoArray) {
        EtcTarget.writeIntegerToDatapool(513430784, 1);
        EtcTarget.writeBooleanToDatapool(496653568, false);
        this.idToPaymentInfo.clear();
        if (tCPaymentInfoArray == null || tCPaymentInfoArray.length == 0) {
            EtcTarget.writeIntegerToDatapool(513430784, 0);
            EtcTarget.writeBooleanToDatapool(496653568, false);
            return;
        }
        for (int i2 = 0; i2 < tCPaymentInfoArray.length; ++i2) {
            TCPaymentInfo tCPaymentInfo = tCPaymentInfoArray[i2];
            if (tCPaymentInfo == null) continue;
            VICSETCTollCollectETCPaymentHistoryCollector vICSETCTollCollectETCPaymentHistoryCollector = new VICSETCTollCollectETCPaymentHistoryCollector();
            DateTime dateTime = tCPaymentInfo.getTimeStamp() == null ? new DateTime() : tCPaymentInfo.getTimeStamp();
            Date date = new Date(dateTime.getTime());
            vICSETCTollCollectETCPaymentHistoryCollector.setMinute(Integer.parseInt(new SimpleDateFormat("mm").format(date)));
            vICSETCTollCollectETCPaymentHistoryCollector.setHour(Integer.parseInt(new SimpleDateFormat("HH").format(date)));
            vICSETCTollCollectETCPaymentHistoryCollector.setDay(Integer.parseInt(new SimpleDateFormat("dd").format(date)));
            vICSETCTollCollectETCPaymentHistoryCollector.setMonth(Integer.parseInt(new SimpleDateFormat("MM").format(date)));
            vICSETCTollCollectETCPaymentHistoryCollector.setYear(Integer.parseInt(new SimpleDateFormat("yyyy").format(date)));
            vICSETCTollCollectETCPaymentHistoryCollector.setGateCost(tCPaymentInfo.getTollAmount().getAmount());
            int n = this.convertDsiTollAmountToHmiAmount(tCPaymentInfoArray[i2].getTollAmount());
            vICSETCTollCollectETCPaymentHistoryCollector.setInformationGateCost(Integer.toString(n));
            this.traceMsg(new StringBuffer().append("Payment info #").append(i2).append(".tollAmount: ").append(n).toString());
            this.idToPaymentInfo.put(new Integer(tCPaymentInfo.getPaymentInfoID()), vICSETCTollCollectETCPaymentHistoryCollector);
            this.dsiTollCollect.requestPaymentHistoryDetails(tCPaymentInfo.getPaymentInfoID());
        }
    }

    public void dsiTollCollectRequestPaymentHistoryDetailsResult(int n, TCPaymentInfoDetails tCPaymentInfoDetails) {
        int n2 = 546985216;
        GenericASLList genericASLList = ServiceManager.listManager.getGenericASLList(n2);
        VICSETCTollCollectETCPaymentHistoryCollector vICSETCTollCollectETCPaymentHistoryCollector = (VICSETCTollCollectETCPaymentHistoryCollector)this.idToPaymentInfo.get(new Integer(n));
        String string = tCPaymentInfoDetails.getEntranceIC() == null ? "" : tCPaymentInfoDetails.getEntranceIC();
        String string2 = tCPaymentInfoDetails.getExitIC() == null ? "" : tCPaymentInfoDetails.getExitIC();
        this.traceMsg(new StringBuffer().append("TollCollectRequestPaymentHistoryDetailsResult: From ").append(string).append(" To ").append(string2).toString());
        if (vICSETCTollCollectETCPaymentHistoryCollector != null) {
            vICSETCTollCollectETCPaymentHistoryCollector.setEntranceIC(string);
            vICSETCTollCollectETCPaymentHistoryCollector.setExitIC(string2);
            this.traceMsg(new StringBuffer().append("dsiTollCollectRequestPaymentHistoryDetailsResult: paymentInfoID= ").append(n).append(" EntranceIC= ").append(string).append(" ExitIC= ").append(string2).toString());
        }
        ++this.paymentHistoryDetailsCounter;
        if (this.idToPaymentInfo.size() <= this.paymentHistoryDetailsCounter) {
            this.traceMsg("All payment info collected: Sending collectors to Model");
            genericASLList.updateList(this.idToPaymentInfo.values().toArray(new VICSETCTollCollectETCPaymentHistoryCollector[0]));
            EtcTarget.writeIntegerToDatapool(513430784, 0);
            EtcTarget.writeBooleanToDatapool(496653568, true);
            this.paymentHistoryDetailsCounter = 0;
        }
    }

    public void dsiTollCollectSetLanguageResponse(boolean bl) {
        if (bl) {
            this.traceMsg("DSITollCollect setLanguageResponse was successfull");
            try {
                this.finishManualLanguageChange(true);
            }
            catch (GenericEventException genericEventException) {
                ServiceManager.logger.error(16, genericEventException.getMessage());
            }
        } else {
            this.traceMsg("DSITollCollect setLanguageResponse was unsuccessfull");
            try {
                this.finishManualLanguageChange(false);
            }
            catch (GenericEventException genericEventException) {
                ServiceManager.logger.error(16, genericEventException.getMessage());
            }
        }
    }

    private void updateStatusLineCardState() {
        int n = 4;
        switch (this.cardState) {
            case 3: {
                n = 2;
                break;
            }
            case 2: 
            case 4: {
                n = 1;
                break;
            }
            case 0: 
            case 1: {
                n = 0;
                break;
            }
            default: {
                ServiceManager.logger.error(16, "EtcTarget.updateStatusLine: Received DSITollCollect cardstate unknown");
            }
        }
        this.traceMsg(new StringBuffer().append("updateStatusLineCardState: state=").append(n).toString());
        ASLVICSETCAPIImpl.notifyEtcCardStateAndPaymentAmount(n, 0);
    }

    private void updateStatusLineTollAmount(int n) {
        this.traceMsg(new StringBuffer().append("updateStatusLineTollAmount: ").append(n).toString());
        ASLVICSETCAPIImpl.notifyEtcCardStateAndPaymentAmount(3, n);
    }

    private void notifyLscRegisterNavi() {
        this.traceMsg("Notifying Bullhorn(LSC), that we are ready.");
        try {
            EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(this.getTargetId(), 5150, 1083965440);
            eventGeneric.setInt(0, 606673664);
            eventGeneric.setInt(1, 0);
            eventGeneric.setString(2, this.m_language);
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.warn("Target Navigation - failed to notify LSC that navigation context is up.");
        }
    }

    private void notifyLscDeregisterNavi() {
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(this.getTargetId(), 5150, 1117519872);
        eventGeneric.setInt(0, 606673664);
        this.send(eventGeneric);
    }

    private void finishManualLanguageChange(boolean bl) {
        this.traceMsg(new StringBuffer().append("Language Changed: Finishing manual language change. Success: ").append(new Boolean(bl).toString()).toString());
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(this.getTargetId(), 5150, 1151074304);
        eventGeneric.setInt(0, this.transactionId);
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setString(2, this.newLanguage);
        this.send(eventGeneric);
    }

    @Override
    public int getSubClassifier() {
        return 16;
    }

    private void traceMsg(String string) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("EtcTarget: ").append(string).toString());
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

    static /* synthetic */ void access$000(EtcTarget etcTarget, String string) {
        etcTarget.traceMsg(string);
    }
}

