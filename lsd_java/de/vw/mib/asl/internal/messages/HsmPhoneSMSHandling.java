/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.ASLNavigationServicesListener;
import de.vw.mib.asl.api.navigation.GuidanceInfo;
import de.vw.mib.asl.api.navigation.NavAddress;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.messages.ASLMessagingData;
import de.vw.mib.asl.internal.messages.AbstractASLHsmMessagesTarget;
import de.vw.mib.asl.internal.messages.HsmPhoneSMSHandling$1;
import de.vw.mib.asl.internal.messages.MessagesAvailableUpdater;
import de.vw.mib.asl.internal.messages.StateMessagingFirstSwitchToIncoming;
import de.vw.mib.asl.internal.messages.StateMessagingInit;
import de.vw.mib.asl.internal.messages.StateMessagingMessageHandling;
import de.vw.mib.asl.internal.messages.StateMessagingMessageResend;
import de.vw.mib.asl.internal.messages.StateMessagingSwitchToMandatoryFolder;
import de.vw.mib.asl.internal.messages.StateMessagingWaitForSynch;
import de.vw.mib.asl.internal.messages.util.MessagingUtil;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesEditedMessageCollector;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesMessageDisplayedFolderCollector;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesMessageSendErrorCollector;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesNavigationTemplateCollector;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesSelectedMessageCollector;
import java.util.HashMap;
import java.util.HashSet;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.DSIMessaging;
import org.dsi.ifc.messaging.DSIMessagingServiceConfiguration;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.RecipientList;
import org.dsi.ifc.organizer.DSIAdbDataResolution;
import org.dsi.ifc.organizer.DSIAdbVCardExchange;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class HsmPhoneSMSHandling
extends AbstractASLHsmMessagesTarget
implements ASLListElementFetcher,
ASLNavigationServicesListener {
    public static final String[] NEEDED_PHONE_DSIS = new String[]{RuntimeGeneratedConstants.SERVICE_TS_NS[71], RuntimeGeneratedConstants.SERVICE_TS_NS[72]};
    DSIMessaging dsiMessaging;
    DSIMessagingServiceConfiguration dsiMessagingServiceConfiguration;
    DSIAdbDataResolution dsiAdbDataResolution;
    DSIAdbVCardExchange dsiAdbVCardExchange;
    DSIListener dsiMessagingListener;
    DSIListener dsiMessagingServiceConfigurationListener;
    DSIListener dsiAdbDataResolutionListener;
    DSIListener dsiAdbVCardExchangeListener;
    MessagesAvailableUpdater messagesAvailable;
    protected static final int WINDOW_SIZE;
    protected final int DEFAULT_FOLDER_INVALID;
    protected final HsmState stateInit;
    protected final HsmState stateWaitForSynch;
    protected final HsmState stateMessageHandling;
    protected final HsmState stateSwitchToMandatoryFolder;
    protected final HsmState stateFirstSwitchToIncoming;
    protected final HsmState stateResend;
    protected ASLAPISpellerBinding spellerHsmNumber;
    protected ASLAPISpellerBinding spellerHsmWrite;
    protected final int ACTIVE_SPELLER_NONE;
    protected final int ACTIVE_SPELLER_NUMBER;
    protected final int ACTIVE_SPELLER_WRITE;
    protected int activeSpeller = 0;
    protected int smsAccountId = -1;
    int mandatoryFolder = 4;
    protected int mandatoryFolderType;
    boolean isSMSAvailable = false;
    protected int folderLevel = 0;
    protected int previousFolderLevel = 0;
    protected String[] folders = new String[]{"ROOT", "", "", "", ""};
    protected int currentFolder = -3;
    protected int currentFolderSwitching = -3;
    protected boolean isSameDeviceConnectedViaRSAPAndMAP = false;
    protected static final int EV_ASL_INT_RESP_GET_ENTRY_RESULT;
    protected boolean isChangeFolderPending = false;
    protected String currentlyOpenedMessage = "";
    private boolean navServicesAvailable;
    private ASLNavigationServices aslNavigationServices;
    private boolean guidanceActive;
    protected boolean isForwarding = false;
    protected int sentMessageCount = 0;
    BundleContext bundleContext = null;
    private Services aslServices;
    private boolean alreadyRegistered = false;
    protected String pimMacAddress = null;
    protected String associatedMacAddress = null;
    protected String associatedSimId = null;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessaging;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbDataResolution;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbVCardExchange;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessagingListener;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbDataResolutionListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$messages$services$available$MessageAvailableService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$PromptEngine;

    public HsmPhoneSMSHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.DEFAULT_FOLDER_INVALID = -3;
        this.ACTIVE_SPELLER_NONE = 0;
        this.ACTIVE_SPELLER_NUMBER = 1;
        this.ACTIVE_SPELLER_WRITE = 2;
        this.stateInit = new StateMessagingInit(this, genericEvents, this.hsm, "PhoneMessageHandlingTop", this.getWorkStateParent());
        this.stateWaitForSynch = new StateMessagingWaitForSynch(this, genericEvents, this.hsm, "PhoneMessageHandlingWaitForSynch", this.stateInit);
        this.stateMessageHandling = new StateMessagingMessageHandling(this, genericEvents, this.hsm, "PhoneMessageHandling", this.stateInit);
        this.stateSwitchToMandatoryFolder = new StateMessagingSwitchToMandatoryFolder(this, genericEvents, this.hsm, "PhoneMessageHandlingSwitchToMandatory", this.stateInit);
        this.stateFirstSwitchToIncoming = new StateMessagingFirstSwitchToIncoming(this, genericEvents, this.hsm, "PhoneMessageHandlingFirstSwitchToIncoming", this.stateMessageHandling);
        this.stateResend = new StateMessagingMessageResend(this, genericEvents, this.hsm, "PhoneMessageHandlingResend", this.stateMessageHandling);
    }

    @Override
    public int getDefaultTargetId() {
        return 5273;
    }

    protected void init() {
        Object object;
        if (!this.alreadyRegistered) {
            ListManager.getGenericASLList(463).enableWindowing(new ASLListItemSoftCacheImpl(), this, 6, 0);
            ListManager.getGenericASLList(463).setFetchTimeout(0);
            this.spellerHsmNumber = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(470, -1979645888, -2063531968, -1962868672);
            this.spellerHsmWrite = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(483, -1380250304, -1610547136, -1526661056);
            ListManager.getGenericASLList(465).updateList(new MessagesSelectedMessageCollector[]{new MessagesSelectedMessageCollector()});
            ListManager.getGenericASLList(4037).updateList(new MessagesEditedMessageCollector[]{new MessagesEditedMessageCollector()});
            ListManager.getGenericASLList(-1226699520).updateList(new MessagesNavigationTemplateCollector[]{new MessagesNavigationTemplateCollector()});
            ListManager.getGenericASLList(-1126036224).updateList(new MessagesMessageSendErrorCollector[]{new MessagesMessageSendErrorCollector()});
            ListManager.getGenericASLList(1188).setColumn4ObjectId(1);
            ListManager.getGenericASLList(460).setColumn4ObjectId(2);
            object = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiMessaging = (DSIMessaging)object.getService(this, class$org$dsi$ifc$messaging$DSIMessaging == null ? (class$org$dsi$ifc$messaging$DSIMessaging = HsmPhoneSMSHandling.class$("org.dsi.ifc.messaging.DSIMessaging")) : class$org$dsi$ifc$messaging$DSIMessaging);
            this.dsiMessagingServiceConfiguration = (DSIMessagingServiceConfiguration)object.getService(this, class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration == null ? (class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration = HsmPhoneSMSHandling.class$("org.dsi.ifc.messaging.DSIMessagingServiceConfiguration")) : class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration);
            this.dsiAdbDataResolution = (DSIAdbDataResolution)object.getService(this, class$org$dsi$ifc$organizer$DSIAdbDataResolution == null ? (class$org$dsi$ifc$organizer$DSIAdbDataResolution = HsmPhoneSMSHandling.class$("org.dsi.ifc.organizer.DSIAdbDataResolution")) : class$org$dsi$ifc$organizer$DSIAdbDataResolution);
            this.dsiAdbVCardExchange = (DSIAdbVCardExchange)object.getService(this, class$org$dsi$ifc$organizer$DSIAdbVCardExchange == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchange = HsmPhoneSMSHandling.class$("org.dsi.ifc.organizer.DSIAdbVCardExchange")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchange);
            this.dsiMessagingListener = object.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$messaging$DSIMessagingListener == null ? (class$org$dsi$ifc$messaging$DSIMessagingListener = HsmPhoneSMSHandling.class$("org.dsi.ifc.messaging.DSIMessagingListener")) : class$org$dsi$ifc$messaging$DSIMessagingListener);
            this.dsiMessagingServiceConfigurationListener = object.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener == null ? (class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener = HsmPhoneSMSHandling.class$("org.dsi.ifc.messaging.DSIMessagingServiceConfigurationListener")) : class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener);
            this.dsiAdbDataResolutionListener = object.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbDataResolutionListener == null ? (class$org$dsi$ifc$organizer$DSIAdbDataResolutionListener = HsmPhoneSMSHandling.class$("org.dsi.ifc.organizer.DSIAdbDataResolutionListener")) : class$org$dsi$ifc$organizer$DSIAdbDataResolutionListener);
            this.dsiAdbVCardExchangeListener = object.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener = HsmPhoneSMSHandling.class$("org.dsi.ifc.organizer.DSIAdbVCardExchangeListener")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener);
            object.addResponseListener(this, class$org$dsi$ifc$messaging$DSIMessagingListener == null ? (class$org$dsi$ifc$messaging$DSIMessagingListener = HsmPhoneSMSHandling.class$("org.dsi.ifc.messaging.DSIMessagingListener")) : class$org$dsi$ifc$messaging$DSIMessagingListener, this.dsiMessagingListener);
            object.addResponseListener(this, class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener == null ? (class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener = HsmPhoneSMSHandling.class$("org.dsi.ifc.messaging.DSIMessagingServiceConfigurationListener")) : class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener, this.dsiMessagingServiceConfigurationListener);
            object.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbDataResolutionListener == null ? (class$org$dsi$ifc$organizer$DSIAdbDataResolutionListener = HsmPhoneSMSHandling.class$("org.dsi.ifc.organizer.DSIAdbDataResolutionListener")) : class$org$dsi$ifc$organizer$DSIAdbDataResolutionListener, this.dsiAdbDataResolutionListener);
            object.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener = HsmPhoneSMSHandling.class$("org.dsi.ifc.organizer.DSIAdbVCardExchangeListener")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener, this.dsiAdbVCardExchangeListener);
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(173)) {
                this.aslNavigationServices = ASLNavigationFactory.getNavigationApi().getASLNavigationServices(this);
                if (this.aslNavigationServices.isServiceAvailable()) {
                    this.updateGuidanceActive(this.aslNavigationServices.isGuidanceActive());
                }
            }
            this.messagesAvailable = new MessagesAvailableUpdater();
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$messages$services$available$MessageAvailableService == null ? (class$de$vw$mib$asl$api$messages$services$available$MessageAvailableService = HsmPhoneSMSHandling.class$("de.vw.mib.asl.api.messages.services.available.MessageAvailableService")) : class$de$vw$mib$asl$api$messages$services$available$MessageAvailableService, this.messagesAvailable);
        }
        this.alreadyRegistered = true;
        this.aslServices = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        this.bundleContext = this.aslServices.getBundleContext();
        object = new ServiceTracker(this.bundleContext, (class$de$vw$mib$asl$api$speechengine$PromptEngine == null ? (class$de$vw$mib$asl$api$speechengine$PromptEngine = HsmPhoneSMSHandling.class$("de.vw.mib.asl.api.speechengine.PromptEngine")) : class$de$vw$mib$asl$api$speechengine$PromptEngine).getName(), (ServiceTrackerCustomizer)new HsmPhoneSMSHandling$1(this));
        ((ServiceTracker)object).open();
    }

    protected void setNotification() {
        this.dsiMessaging.setNotification(new int[]{4, 5}, this.dsiMessagingListener);
    }

    protected void handleChangeFolder(int n, ListEntry listEntry, boolean bl) {
        if (this.smsAccountId != -1 && n != this.currentFolder && !this.isChangeFolderPending || bl) {
            this.previousFolderLevel = this.folderLevel--;
            this.dsiMessaging.changeFolderRequest(n, 1, this.smsAccountId, 4, 2);
            this.isChangeFolderPending = true;
            switch (n) {
                case -2: {
                    break;
                }
                case -1: {
                    this.folderLevel = 0;
                    break;
                }
                default: {
                    ++this.folderLevel;
                    if (listEntry == null || listEntry.getType() != 1) break;
                    this.folders[this.folderLevel] = listEntry.getFolderEntry().getFolderName();
                }
            }
            Object[] objectArray = (MessagesMessageDisplayedFolderCollector[])ListManager.getGenericASLList(462).getDSIObjects();
            objectArray[0].messages_displayed_folder_level = this.folderLevel;
            objectArray[0].messages_displayed_folder_name = this.folders[this.folderLevel];
            objectArray[0].messages_displayed_folder_type__1 = this.folderLevel == 1 ? this.mandatoryFolderType : 5;
            objectArray[0].messages_displayed_folder_updated = false;
            ListManager.getGenericASLList(462).updateList(objectArray);
            this.currentFolderSwitching = n;
        }
    }

    protected void handleGetSortingFolder(int n) {
        switch (n) {
            case 1: {
                this.mandatoryFolderType = 0;
                break;
            }
            case 2: {
                this.mandatoryFolderType = 1;
                break;
            }
            case 4: {
                this.mandatoryFolderType = 2;
                break;
            }
            case 3: {
                this.mandatoryFolderType = 3;
                break;
            }
            case 7: {
                this.mandatoryFolderType = 4;
                break;
            }
            default: {
                this.mandatoryFolderType = 5;
            }
        }
    }

    protected void handleSendMessage(int n, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n2) {
        if (n2 != -1) {
            String string3 = string2 != null ? string2 : this.spellerHsmWrite.getSpellerData().getEnteredText();
            int n3 = string3.indexOf("\\n");
            int n4 = 0;
            if (n3 != -1) {
                StringBuilder stringBuilder = new StringBuilder(string3.length());
                while (n3 != -1) {
                    stringBuilder.append(string3.substring(n4, n3)).append("\n");
                    n4 = n3 + 2;
                    n3 = string3.indexOf("\\n", n4);
                }
                stringBuilder.append(string3.substring(n4));
                this.dsiMessaging.sendMessageRequest(-1, n, recipientList, string, stringBuilder.toString(), attachmentInformationArray, n2);
            } else {
                this.dsiMessaging.sendMessageRequest(-1, n, recipientList, string, string3, attachmentInformationArray, n2);
            }
            HsmPhoneSMSHandling.writeBooleanToDatapool(-1042150144, true);
            this.sentMessageCount = recipientList.to.length;
            MessagingUtil.clearMessageRecipients();
            MessagingUtil.setTemporarySaved(false);
        }
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (!this.isChangeFolderPending) {
            this.dsiMessaging.listEntriesRequest(0, n, n2);
        }
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        if (!this.isChangeFolderPending) {
            this.dsiMessaging.listEntriesRequest(0, n, n2);
        }
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        if (!this.isChangeFolderPending) {
            this.dsiMessaging.listEntriesRequest(0, n, n2);
        }
    }

    protected HashSet getAccountNewMessageSet(int n) {
        MessagingAccount[] messagingAccountArray = ASLMessagingData.getMessagingAccounts();
        for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
            if (n != messagingAccountArray[i2].getAccountID()) continue;
            switch (messagingAccountArray[i2].getAccountType()) {
                case 2: {
                    return ASLMessagingData.newMessagesSetExternal;
                }
                case 1: {
                    return ASLMessagingData.newMessagesSetInternal;
                }
                case 3: {
                    return ASLMessagingData.newMessagesSetInternal;
                }
            }
            this.error("can't return newMessageSet as the currently used account has no proper accounttype set");
            return null;
        }
        this.error("can't return newMessageSet as the current accountId does not match any of the accounts: ", n);
        return null;
    }

    protected HashSet getCurrentAccountNewMessageSet() {
        if (this.smsAccountId != -1) {
            MessagingAccount[] messagingAccountArray = ASLMessagingData.getMessagingAccounts();
            for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
                if (this.smsAccountId != messagingAccountArray[i2].getAccountID()) continue;
                switch (messagingAccountArray[i2].getAccountType()) {
                    case 2: {
                        return ASLMessagingData.newMessagesSetExternal;
                    }
                    case 1: {
                        return ASLMessagingData.newMessagesSetInternal;
                    }
                    case 3: {
                        return ASLMessagingData.newMessagesSetInternal;
                    }
                }
                this.error("can't return newMessageSet as the currently used account has no proper accounttype set");
                return null;
            }
            this.error("can't return newMessageSet as the current smsAccountId does not match any of the accounts");
            return null;
        }
        this.error("can't return newMessageSet as there is no currently selected account");
        return null;
    }

    protected void setListToLoading(boolean bl) {
        Object[] objectArray = (MessagesMessageDisplayedFolderCollector[])ListManager.getGenericASLList(462).getDSIObjects();
        objectArray[0].messages_displayed_folder_updated = !bl;
        ListManager.getGenericASLList(462).updateList(objectArray);
    }

    @Override
    public void importContactResult(int n) {
    }

    @Override
    public void updateContactCapacity(int n) {
    }

    @Override
    public void updateGuidanceActive(boolean bl) {
        this.guidanceActive = bl;
        if (bl) {
            this.fillModelGetterForNaviTemplates();
        }
    }

    void fillModelGetterForNaviTemplates() {
        Object object;
        HashMap hashMap;
        NavAddress navAddress = null;
        GuidanceInfo[] guidanceInfoArray = null;
        if (this.navServicesAvailable && null != this.aslNavigationServices) {
            navAddress = this.aslNavigationServices.getCurrentCarPosition();
            if (this.guidanceActive) {
                guidanceInfoArray = this.aslNavigationServices.getGuidanceInfo();
            }
        }
        Object[] objectArray = (MessagesNavigationTemplateCollector[])ListManager.getGenericASLList(-1226699520).getDSIObjects();
        if (navAddress != null) {
            hashMap = new HashMap();
            hashMap.put("City", navAddress.getCity());
            hashMap.put("Street", navAddress.getStreet());
            object = ServiceManager.fixFormat4Asl.getRulesetBasedFormattedString(500, hashMap);
            ((MessagesNavigationTemplateCollector)objectArray[0]).messages_current_street_available = !Util.isNullOrEmpty((String)object);
            ((MessagesNavigationTemplateCollector)objectArray[0]).messages_current_street = object;
        } else {
            objectArray[0].messages_current_street_available = false;
        }
        if (guidanceInfoArray != null && guidanceInfoArray.length > 1 && guidanceInfoArray[1] != null) {
            hashMap = new HashMap();
            object = guidanceInfoArray[1];
            NavAddress navAddress2 = ((GuidanceInfo)object).getAddress();
            if (null == navAddress2 || null == navAddress2.getLatitudeDegMinSec() || null == navAddress2.getLongitudeDegMinSec()) {
                ((MessagesNavigationTemplateCollector)objectArray[0]).messages_destination_city_available = false;
            } else {
                hashMap.put("City", navAddress2.getCity());
                hashMap.put("Street", navAddress2.getStreet());
                hashMap.put("Housenumber", navAddress2.getHousenumber());
                hashMap.put("PostalCode", navAddress2.getZip());
                hashMap.put("Crossing", navAddress2.getCrossing());
                double[] dArray = navAddress2.getLatitudeDegMinSec();
                hashMap.put("LatitudeDegrees", new StringBuffer().append("").append((int)dArray[0]).toString());
                hashMap.put("LatitudeMinutes", new StringBuffer().append("").append((int)dArray[1]).toString());
                hashMap.put("LatitudeSeconds", new StringBuffer().append("").append((int)(dArray[2] * 10.0)).toString());
                double[] dArray2 = navAddress2.getLongitudeDegMinSec();
                hashMap.put("LongitudeDegrees", new StringBuffer().append("").append((int)dArray2[0]).toString());
                hashMap.put("LongitudeMinutes", new StringBuffer().append("").append((int)dArray2[1]).toString());
                hashMap.put("LongitudeSeconds", new StringBuffer().append("").append((int)(dArray2[2] * 10.0)).toString());
                hashMap.put("isCityCenter", Util.isNullOrEmpty(navAddress2.getStreet()) ? "true" : "");
                hashMap.put("isPostalCodeSpelled", Util.isNullOrEmpty(navAddress2.getZip()) ? "" : "true");
                String string = ServiceManager.fixFormat4Asl.getRulesetBasedFormattedString(10, hashMap);
                ((MessagesNavigationTemplateCollector)objectArray[0]).messages_destination_city_available = !Util.isNullOrEmpty(string);
                ((MessagesNavigationTemplateCollector)objectArray[0]).messages_destination_city = string;
                ((MessagesNavigationTemplateCollector)objectArray[0]).messages_destination_etad = ((GuidanceInfo)object).getEtaDays();
                ((MessagesNavigationTemplateCollector)objectArray[0]).messages_destination_etah = ((GuidanceInfo)object).getEtaHours();
                ((MessagesNavigationTemplateCollector)objectArray[0]).messages_destination_etam = ((GuidanceInfo)object).getEtaMinutes();
                ((MessagesNavigationTemplateCollector)objectArray[0]).messages_destination_eta_available = ((GuidanceInfo)object).getEtaDays() != 0 || ((GuidanceInfo)object).getEtaHours() != 0 || ((GuidanceInfo)object).getEtaMinutes() != 0;
            }
        } else {
            objectArray[0].messages_destination_city_available = false;
        }
        ListManager.getGenericASLList(-1226699520).updateList(objectArray);
    }

    @Override
    public void updateServiceAvailable(boolean bl) {
        this.navServicesAvailable = bl;
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

