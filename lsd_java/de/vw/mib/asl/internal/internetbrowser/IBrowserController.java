/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser;

import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.ASLOnlineServiceCallback1;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.internetbrowser.common.EfiLinkHandler;
import de.vw.mib.asl.internal.internetbrowser.common.InputSpellerHelper;
import de.vw.mib.asl.internal.internetbrowser.consumer.EfiLinkRegistration;
import de.vw.mib.asl.internal.internetbrowser.notifier.IBrowserHmiNotifier;
import de.vw.mib.asl.internal.internetbrowser.states.IBrowserTarget;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.HistoryEntry;
import org.dsi.ifc.browser.ImportReport;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.browser.PathInfo;
import org.dsi.ifc.browser.SelectionEntry;
import org.dsi.ifc.browser.TimePeriod;
import org.dsi.ifc.global.ResourceLocator;

public final class IBrowserController
extends AbstractFactoryResetParticipant
implements ASLOnlineServiceCallback1 {
    private static final int Y_OFFSET_UPPER_LEFT_CORNER;
    private static final String EFI_CONST_PATH_MENU_VARIABLE;
    private static final String EFI_CONST_PATH_MENU_SLASH;
    private static final String EFI_CONST_PATH_DISCLAIMER_SLASH;
    private static final String EFI_CONST_PATH_MENU;
    private static final String EFI_CONST_PATH_DISCLAIMER;
    private static final String EFI_CONST_PATH_REGISTER;
    private static final String EFI_CONST_PATH_LOGIN;
    private String menuURL = "";
    private String activeURL = "";
    private String navInputURL = "";
    private String disclaimerURL = "";
    private String _ICEUrl;
    IBrowserTarget _target;
    private final IBrowserHmiNotifier _notifier = new IBrowserHmiNotifier(this.getTarget());
    private final EfiLinkRegistration _consumer = new EfiLinkRegistration();
    private EfiLinkHandler _efiHandler = new EfiLinkHandler();
    private InputSpellerHelper _spellerHandler;
    private String _currentLanguage;
    private boolean motionlessTouching = false;
    private final boolean recoveryInProgress;
    final String _classname = super.getClass().getName();
    private boolean speedPopupCoded = false;
    private boolean speedPopupConfirmed = false;
    private int tmpPosX = 0;
    private String pageTitle2Set = null;
    private int counter = 0;
    private int tmpScrollX = 0;
    private int tmpScrollY = 0;
    private boolean queueingPageTitle = false;
    private int scrollPosition4x = 0;
    private int scrollPosition4y = 0;
    private int currentBrowserState = 1;
    private boolean htmlCompleteWasSend = false;
    private static IBrowserController browserController;
    private FactoryResetCallback callback;
    private boolean _initialTextSetForKeyboard;
    private boolean mPendingTouchScroll = false;
    private int mPendingTouchScrollX = 0;
    private int mPendingTouchScrollY = 0;

    private IBrowserController() {
        this.recoveryInProgress = false;
    }

    public static IBrowserController initializeController() {
        if (browserController == null) {
            browserController = new IBrowserController();
        }
        return browserController;
    }

    public void setTarget(IBrowserTarget iBrowserTarget) {
        this._target = iBrowserTarget;
    }

    IBrowserTarget getTarget() {
        return this._target;
    }

    private EfiLinkHandler getEfiHandler() {
        if (this._efiHandler == null) {
            this._efiHandler = new EfiLinkHandler();
        }
        return this._efiHandler;
    }

    private InputSpellerHelper getSpellerHandler() {
        if (this._spellerHandler == null) {
            this._spellerHandler = new InputSpellerHelper();
        }
        return this._spellerHandler;
    }

    public IBrowserHmiNotifier getHMINotifier() {
        return this._notifier;
    }

    private void reset() {
        this.getHMINotifier().reset();
        if (this._target.getDSIBrowser() == null) {
            LogMessage logMessage = this._target.info();
            logMessage.append(this._classname).append(".reset() DSI Browser not available").log();
        } else {
            this._target.getDSIBrowser().deleteCache();
            this._target.getDSIBrowser().deleteCookies();
            this._target.getDSIBrowser().deleteHistory();
            this._target.getDSIBrowser().deletePasswords();
            this._target.getDSIBrowser().resetToFactoryDefaults();
        }
    }

    public void initializeSettings() {
        if (this._notifier != null) {
            this._notifier.reset();
        }
        if (this._target.getDSIBrowser() == null) {
            LogMessage logMessage = this._target.info();
            logMessage.append(this._classname).append(".reset() DSI Browser not available").log();
        }
    }

    public void registerEfiLinkConsumer(EventGeneric eventGeneric) {
        if (eventGeneric.getResult() != 0) {
            LogMessage logMessage = this._target.info();
            logMessage.append(this._classname).append(".registerEfiLinkConsumer() Event result=").append(eventGeneric.getResult()).append("").log();
        } else {
            String string = eventGeneric.getString(0);
            if (Util.isNullOrEmpty(string)) {
                LogMessage logMessage = this._target.info();
                logMessage.append(this._classname).append(".registerEfiLinkConsumer() Invalid action parameter").log();
            } else {
                if (this.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = this._target.trace();
                    logMessage.append(this._classname).append(".registerEfiLinkConsumer() Register consumer [TargetID=").append(eventGeneric.getSenderTargetId()).append("] for action '").append(string).append("'").log();
                }
                boolean bl = this._consumer.registerConsumer(eventGeneric.getSenderTargetId(), string);
                eventGeneric.setResult(0);
                eventGeneric.setBoolean(0, bl);
            }
        }
    }

    public void unregisterEfiLinkConsumer(EventGeneric eventGeneric) {
        if (eventGeneric.getResult() != 0) {
            LogMessage logMessage = this._target.info();
            logMessage.append(this._classname).append(".unregisterEfiLinkConsumer() Event result=").append(eventGeneric.getResult()).append("").log();
        } else {
            LogMessage logMessage;
            String string = eventGeneric.getString(0);
            if (Util.isNullOrEmpty(string)) {
                if (this.getTarget().isTraceEnabled()) {
                    logMessage = this._target.trace();
                    logMessage.append(this._classname).append(".unregisterEfiLinkConsumer() Unregister consumer [TargetID=").append(eventGeneric.getSenderTargetId()).append("] for all actions").log();
                }
            } else if (this.getTarget().isTraceEnabled()) {
                logMessage = this._target.trace();
                logMessage.append(this._classname).append(".unregisterEfiLinkConsumer() Unregister consumer [TargetID=").append(eventGeneric.getSenderTargetId()).append("] for action '").append(string).append("'").log();
            }
            boolean bl = this._consumer.unregisterConsumer(eventGeneric.getSenderTargetId(), string);
            eventGeneric.setResult(0);
            eventGeneric.setBoolean(0, bl);
        }
    }

    public void reportEfiLink(String string) {
        this._efiHandler.reportEfiLink(string);
        String string2 = string.substring(string.indexOf(":") + 1, string.indexOf("?"));
        IntArrayList intArrayList = this._consumer.getConsumerForAction(string2);
        if (intArrayList != null && !intArrayList.isEmpty()) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setSenderTargetId(this._target.getTargetId());
            eventGeneric.setSenderEventId(-2101794304);
            eventGeneric.setReceiverEventId(-2101794304);
            eventGeneric.setObject(0, string);
            int n = intArrayList.size();
            for (int i2 = 0; i2 < n; ++i2) {
                eventGeneric.setReceiverTargetId(intArrayList.get(i2));
                try {
                    this._target.send(eventGeneric);
                    continue;
                }
                catch (GenericEventException genericEventException) {
                    if (!this.getTarget().isTraceEnabled()) continue;
                    LogMessage logMessage = this._target.info();
                    logMessage.append(this._classname).append(".send event to registered efi consumer: ").append(eventGeneric.toString()).log();
                }
            }
        }
    }

    public void handleUpdateBrowserState(int n) {
        LogMessage logMessage;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        this._target.triggerObserver(-2068239872, eventGeneric);
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this._target.trace();
            logMessage.append(this._classname).append(".handleUpdateBrowserState(").append(n).append(")").log();
        }
        this.setCurrentBrowserState(n);
        switch (n) {
            case 0: {
                this.getHMINotifier().setCurrentPageLoadingState(0, "handleUpdateBrowserState:LOADING");
                break;
            }
            case 1: {
                this.getHMINotifier().setCurrentPageLoadingState(1, "handleUpdateBrowserState:IDLE");
                break;
            }
            case 2: {
                this._target.sendHMIEvent(490);
                this.getHMINotifier().setCurrentPageLoadingState(2, "handleUpdateBrowserState:NOT_FOUND");
                break;
            }
            case 3: {
                this.getHMINotifier().setCurrentPageLoadingState(3, "handleUpdateBrowserState:SUSPENDED");
                break;
            }
            case 6: {
                this.htmlCompleteWasSend = true;
                if (this.getEfiHandler().isFrameTypeSwitchingPending()) {
                    if (this.getEfiHandler().getFrameType2Set().equals("MOS_MAIN_PAGE")) {
                        this.notifyHMIIsCurrentPageHome(true);
                        this.notifyHMICurrentFrameType(0);
                    } else if (this.getEfiHandler().getFrameType2Set().equals("MOS_MAIN_PAGE_MODELED_FRAME")) {
                        this.notifyHMIIsCurrentPageHome(false);
                        this.notifyHMICurrentFrameType(1);
                    } else if (this.getEfiHandler().getFrameType2Set().equals("MOS_WIZARD_PAGE")) {
                        this.notifyHMIIsCurrentPageHome(false);
                        this.notifyHMICurrentFrameType(2);
                    } else if (this.getEfiHandler().getFrameType2Set().equals("MOS_WIZARD_PAGE_WITH_HTML_FOOTER")) {
                        this.notifyHMIIsCurrentPageHome(false);
                        this.notifyHMICurrentFrameType(3);
                    } else if (this.getTarget().isTraceEnabled()) {
                        logMessage = this._target.info();
                        logMessage.append(this._classname).append(" setFrameType failed due to unknown FRAME TYPE: ").append(this.getEfiHandler().getFrameType2Set()).log();
                    }
                }
                if (this.queueingPageTitle) {
                    this.getHMINotifier().setCurrentPageTitle(this.pageTitle2Set);
                }
                this.getEfiHandler().setFrameTypeSwitchingQueue(false);
                this.queueingPageTitle = false;
                break;
            }
            case 4: {
                if (!this.htmlCompleteWasSend) {
                    if (this.getEfiHandler().isFrameTypeSwitchingPending()) {
                        if (this.getEfiHandler().getFrameType2Set().equals("MOS_MAIN_PAGE")) {
                            this.notifyHMIIsCurrentPageHome(true);
                            this.notifyHMICurrentFrameType(0);
                        } else if (this.getEfiHandler().getFrameType2Set().equals("MOS_MAIN_PAGE_MODELED_FRAME")) {
                            this.notifyHMIIsCurrentPageHome(false);
                            this.notifyHMICurrentFrameType(1);
                        } else if (this.getEfiHandler().getFrameType2Set().equals("MOS_WIZARD_PAGE")) {
                            this.notifyHMIIsCurrentPageHome(false);
                            this.notifyHMICurrentFrameType(2);
                        } else if (this.getEfiHandler().getFrameType2Set().equals("MOS_WIZARD_PAGE_WITH_HTML_FOOTER")) {
                            this.notifyHMIIsCurrentPageHome(false);
                            this.notifyHMICurrentFrameType(3);
                        } else {
                            logMessage = this._target.info();
                            logMessage.append(this._classname).append(" setFrameType failed due to unknown FRAME TYPE: ").append(this.getEfiHandler().getFrameType2Set()).log();
                        }
                    }
                    if (this.queueingPageTitle) {
                        this.getHMINotifier().setCurrentPageTitle(this.pageTitle2Set);
                    }
                    this.getEfiHandler().setFrameTypeSwitchingQueue(false);
                    this.queueingPageTitle = false;
                }
                this.getHMINotifier().setCurrentPageLoadingState(4, "handleUpdateBrowserState:COMPLETE");
                this.htmlCompleteWasSend = false;
                break;
            }
            case 5: {
                this._target.sendHMIEvent(490);
                this.getHMINotifier().setCurrentPageLoadingState(5, "handleUpdateBrowserState:OUT_OF_MEMORY");
                break;
            }
            default: {
                logMessage = this._target.error();
                logMessage.append(this._classname).append(".handleUpdateBrowserState(").append(n).append(") Unknown browser state").log();
                break;
            }
        }
    }

    public void handleUpdatePageTitle(String string) {
        if (this.currentBrowserState == 0) {
            this.queueingPageTitle = true;
            this.pageTitle2Set = string;
        } else {
            this.queueingPageTitle = false;
            this.getHMINotifier().setCurrentPageTitle(string);
        }
    }

    public void handleUpdateActiveUrl(String string) {
        this.activeURL = string;
    }

    public void handleUpdateZoomFactor(int n) {
    }

    public void handleUpdateVirtualKeyboardStatus(boolean bl) {
        if (bl) {
            this._target.sendHMIEvent(-783415040);
            this.getSpellerHandler().spellerEntered();
        }
    }

    public void handleUpdateKeyboardDisplay(boolean bl, KeyboardInfo keyboardInfo) {
        if (bl && keyboardInfo != null) {
            if (keyboardInfo.getType() == 0) {
                this._target.sendHMIEvent(-783415040);
                this.getSpellerHandler().spellerEntered();
                this.getSpellerHandler().setInitialText(keyboardInfo.getInitialText());
                if (!Util.isNullOrEmpty(keyboardInfo.getInitialText())) {
                    this._initialTextSetForKeyboard = true;
                }
                this.getSpellerHandler().spellerSetCursorPosition(0);
                if (keyboardInfo.isSensitive()) {
                    // empty if block
                }
            } else if (keyboardInfo.getType() == 2 || keyboardInfo.getType() == 1) {
                // empty if block
            }
        }
    }

    public void spellerOK() {
        this.getSpellerHandler().spellerOK();
        this._target.getDSIBrowser().keyboardInput(this.getSpellerHandler().getSpellerData());
    }

    public void spellerDeleteChar() {
        this.getSpellerHandler().spellerDeleteChar();
    }

    public void spellerSetCursorPosition(int n) {
        this.getSpellerHandler().spellerSetCursorPosition(n);
    }

    public void spellerAddChar(String string) {
        if (this._initialTextSetForKeyboard) {
            this.getSpellerHandler().setInitialText("");
            this._initialTextSetForKeyboard = false;
        }
        this.getSpellerHandler().spellerAddChar(string);
    }

    public void spellerCancel() {
        this.getSpellerHandler().spellerCancel();
        this._target.getDSIBrowser().keyboardInput(this.getSpellerHandler().getSpellerData());
    }

    public void spellerEntered() {
        this.getSpellerHandler().spellerEntered();
    }

    public void handleUpdateEncryption(boolean bl) {
    }

    public void handleUpdateHasFocus(boolean bl) {
    }

    public void handleUpdateButtonState(int n, int n2) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this._target.trace();
            logMessage.append(this._classname).append(".handleUpdateButtonState(").append(n).append(", ").append(n2).append(")").log();
        }
        switch (n) {
            case 0: {
                break;
            }
            case 3: {
                break;
            }
            case 1: {
                this.getHMINotifier().setNavigateForwardAvailable(n2 == 0);
                break;
            }
            case 2: {
                break;
            }
            case 4: {
                break;
            }
            default: {
                if (!this.getTarget().isTraceEnabled()) break;
                logMessage = this._target.info();
                logMessage.append(this._classname).append(".handleUpdateButtonState(").append(n).append(", ").append(n2).append(") Unknwon button").log();
            }
        }
    }

    public void handleUpdateProgress(int n) {
        int n2 = n / 10;
        this.getHMINotifier().setCurrentPageProgress(n2);
    }

    private void debounceTouchScroll(int n, int n2) {
        if (!this._target.isTouchScrollWindowTimerActive()) {
            this.mPendingTouchScrollX = 0;
            this.mPendingTouchScrollY = 0;
            this.mPendingTouchScroll = false;
            this._target.getDSIBrowser().touchScroll(n, n2);
            this._target.startTouchScrollWindowTimer();
        } else {
            this.mPendingTouchScroll = true;
            this.mPendingTouchScrollX += n;
            this.mPendingTouchScrollY += n2;
        }
    }

    private void touchScrollAnswerReceived() {
        if (this._target.isTouchScrollWindowTimerActive()) {
            this._target.stopTouchScrollWindowTimer();
        }
        this.touchScrollWindowTimeout();
    }

    public void touchScrollWindowTimeout() {
        if (this.mPendingTouchScroll) {
            this.debounceTouchScroll(this.mPendingTouchScrollX, this.mPendingTouchScrollY);
        }
    }

    public void handleUpdateScrollbarX(int n, int n2, int n3) {
        this.scrollPosition4x = n3;
        ServiceManager.aslPropertyManager.valueChangedInteger(-716306176, n - n2);
        ServiceManager.aslPropertyManager.valueChangedInteger(-699528960, 0);
        ServiceManager.aslPropertyManager.valueChangedInteger(-733083392, n3);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        this._target.triggerObserver(-2051462656, eventGeneric);
        this.touchScrollAnswerReceived();
    }

    public void handleUpdateScrollbarY(int n, int n2, int n3) {
        this.scrollPosition4y = n3;
        ServiceManager.aslPropertyManager.valueChangedInteger(-766637824, n - n2);
        ServiceManager.aslPropertyManager.valueChangedInteger(-749860608, 0);
        ServiceManager.aslPropertyManager.valueChangedInteger(-783415040, n3);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        this._target.triggerObserver(-2034685440, eventGeneric);
        this.touchScrollAnswerReceived();
    }

    public void handleGetPreferenceResult(int n, int n2, String string) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this._target.trace();
            logMessage.append(this._classname).append(".handleGetPreferenceResult(").append(n).append(", ").append(n2).append(string).append(")").log();
        }
        if (n == 144) {
            this.getTarget().getHASHandler().retryUpdateSkinInfo();
        }
        if (n == 145) {
            this.getTarget().getHASHandler().retryUpdateAmbientLight();
        }
    }

    void setMenuDisclaimerPath(String string) {
        if (!Util.isNullOrEmpty(string)) {
            if (string.endsWith("$(service)")) {
                this.menuURL = new StringBuffer().append(string.substring(0, string.indexOf("?service=$(service)"))).append("?service=mainmenu").toString();
                this.disclaimerURL = new StringBuffer().append(string).append("?service=disclaimer").toString();
            } else if (string.charAt(string.length() - 1) == '/') {
                this.menuURL = new StringBuffer().append(string).append("?service=mainmenu").toString();
                this.disclaimerURL = new StringBuffer().append(string).append("?service=disclaimer").toString();
            } else {
                this.menuURL = new StringBuffer().append(string).append("/?service=mainmenu").toString();
                this.disclaimerURL = new StringBuffer().append(string).append("/?service=disclaimer").toString();
            }
            if (this.getTarget().isTraceEnabled()) {
                LogMessage logMessage = this._target.trace();
                logMessage.append(this._classname).append(".setMenuDisclaimerPath: ").append("BASEURL is empty use Service URL").append(string).append(new StringBuffer().append(" SURL: ").append(string).toString()).log();
            }
            this.getTarget().getDSIBrowser().loadUrl(this.menuURL);
        } else {
            this.menuURL = string;
            if (this.getTarget().isTraceEnabled()) {
                LogMessage logMessage = this._target.trace();
                logMessage.append(this._classname).append(".setMenuDisclaimerPath: ").append("BASEURL AND Service URL are EMPTY").log();
            }
        }
    }

    public void handleJavascriptAlert(String string) {
        this._target.getDSIBrowser().javaScriptAlertAck();
    }

    public void handleJavascriptConfirm(String string) {
        this._target.getDSIBrowser().javaScriptConfirmAck(true);
    }

    public void handleJavascriptPrompt(String string, String string2) {
        this._target.getDSIBrowser().javaScriptPromptAck("", true);
    }

    public void handleUpdateSelectionListContent(SelectionEntry[] selectionEntryArray, boolean bl) {
    }

    public void handleExportBrowserDataResult(int n) {
    }

    public void handleImportBrowserDataResult(int n) {
    }

    public void handleGetHistoryResult(TimePeriod timePeriod, HistoryEntry[] historyEntryArray, int n) {
    }

    public void handleListBookmarksResult(String string, Bookmark[] bookmarkArray, int n) {
    }

    public void handleBookmarkListInvalid() {
    }

    public void handleAddBookmarkResult(Bookmark bookmark, int n) {
    }

    public void handleEditBookmarkResult(Bookmark bookmark, int n) {
    }

    public void handleDeleteBookmarkResult(Bookmark bookmark, int n) {
    }

    public void handleCreateFolderResult(Bookmark bookmark, int n) {
    }

    public void handleDeleteFolderResult(String string, int n) {
    }

    public void handleRenameFolderResult(String string, int n) {
    }

    public void handleExportBookmarksResult(PathInfo pathInfo, int n) {
    }

    public void handleUpdateExportBookmarksProgress(PathInfo pathInfo, int n) {
    }

    public void handleImportBookmarksResult(PathInfo pathInfo, ImportReport importReport, int n) {
    }

    public void handleUpdateImportBookmarksProgress(PathInfo pathInfo, int n) {
    }

    public void handleGetQuotaInformationResult(int n, int n2, int n3) {
    }

    public void handleAsyncException(int n, String string, int n2) {
        LogMessage logMessage = this._target.error();
        logMessage.append(this._classname).append(".handleAsyncException(").append(n).append(", ").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(", ").append(n2).append(")").log();
    }

    public void handleSetContext(int n, boolean bl) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this._target.trace();
            logMessage.append(this._classname).append(".handleSetContext(").append(n).append(", ").append(bl).append(")").log();
        }
        if (bl) {
            this._target.getDSIBrowser().bringToFront();
        }
        this.getHMINotifier().setNavigateBackwardAvailable(true);
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                if (bl && this.speedPopupCoded && !this.speedPopupConfirmed) {
                    this._target.sendHMIEvent(-733083392);
                }
                if (this.getTarget().isTraceEnabled()) {
                    logMessage = this._target.trace();
                    logMessage.append(this._classname).append(" EnterBrowser: ").append(bl).append(" speedPopupCoded: ").append(this.speedPopupCoded).append(" PopupConfirmed: ").append(this.speedPopupConfirmed).log();
                }
                if (!bl) break;
                this.notifyHMIIsCurrentPageHome(true);
                this.getHMINotifier().setCurrentPageLoadingState(0, "setContext:ONLINE_SERVICES.enter()");
                this._target.sendHMIEvent(-766637824);
                this._target.sendHMIEvent(-749860608);
                ASLOnlineFactory.getOnlineCoreServices().getServiceURL(ASLOnlineFactory.getOnlineCoreServices().getServiceIDWithNumericServiceID(15), this);
                break;
            }
            case 2: {
                this.getHMINotifier().setCurrentPageLoadingState(0, "setContext:NAVI_POI_DETAIL_VIEW.enter()");
                if (this.getTarget().isTraceEnabled()) {
                    logMessage = this._target.trace();
                    logMessage.append(this._classname).append(" Enter POI Detail View").append(this.menuURL).log();
                }
                if (bl) break;
                this._target.sendHMIEvent(-766637824);
                this._target.sendHMIEvent(-749860608);
                break;
            }
            case 3: {
                if (!bl) break;
                this._ICEUrl = "login";
                this.notifyHMIIsCurrentPageHome(true);
                this.getHMINotifier().setCurrentPageLoadingState(0, "setContext:IN_CAR_ENROLLMENT_VIEW.enter()");
                this._target.sendHMIEvent(-766637824);
                this._target.sendHMIEvent(-749860608);
                ASLOnlineFactory.getOnlineCoreServices().getServiceURL(ASLOnlineFactory.getOnlineCoreServices().getServiceIDWithNumericServiceID(44), this);
                break;
            }
            case 4: {
                if (bl) {
                    this._ICEUrl = "register";
                    this.notifyHMIIsCurrentPageHome(true);
                    this.getHMINotifier().setCurrentPageLoadingState(0, "setContext:IN_CAR_ENROLLMENT_VIEW.enter()");
                    this._target.sendHMIEvent(-766637824);
                    this._target.sendHMIEvent(-749860608);
                    ASLOnlineFactory.getOnlineCoreServices().getServiceURL(ASLOnlineFactory.getOnlineCoreServices().getServiceIDWithNumericServiceID(44), this);
                }
            }
            default: {
                logMessage = this._target.info();
                logMessage.append(this._classname).append(".handleSetContext(").append(n).append(", ").append(bl).append(") Unknwon context").log();
                break;
            }
        }
    }

    public void handleEventDeleteHistory() {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this._target.trace();
            logMessage.append(this._classname).append(".handleEventDeleteHistory()").log();
        }
        if (this._target.getDSIBrowser() == null) {
            logMessage = this._target.info();
            logMessage.append(this._classname).append(".handleEventDeleteHistory() DSI Browser not available").log();
        } else {
            this._target.getDSIBrowser().deleteHistory();
            this._target.getDSIBrowser().stopBrowser();
            this._target.getDSIBrowser().gotoHomeUrl();
        }
    }

    public void handleNavigateTo(int n, int n2, String string) {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this._target.trace();
            object.append(this._classname).append(".handleNavigateTo(").append(n).append(", ").append(n2).append(", ").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(")").log();
        }
        switch (n) {
            case 0: {
                if (this._target.getDSIBrowser() == null) {
                    object = this._target.info();
                    object.append(this._classname).append(".handleNavigateTo(").append(n).append(", ").append(n2).append(", ").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(") DSI Browser not available").log();
                    break;
                }
                this.getHMINotifier().setNavigateBackwardAvailable(true);
                this.predictHomePageLoading();
                this._target.getDSIBrowser().loadUrl(this.menuURL);
                break;
            }
            case 1: {
                if (!this.getTarget().isTraceEnabled()) break;
                object = this._target.info();
                object.append(this._classname).append(".handleNavigateTo(").append(n).append(", ").append(n2).append(", ").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(") Unhandled destination").log();
                break;
            }
            case 2: {
                if (this._target.getDSIBrowser() == null) {
                    if (!this.getTarget().isTraceEnabled()) break;
                    object = this._target.info();
                    object.append(this._classname).append(".handleNavigateTo(").append(n).append(", ").append(n2).append(", ").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(") DSI Browser not available").log();
                    break;
                }
                object = this.getEfiHandler().getBackURI();
                if (!Util.isNullOrEmpty((String)object)) {
                    this.getTarget().info(new StringBuffer().append("isHomepage = backURL(").append((String)object).append(") startsWith menuURL(").append(this.menuURL).append(")").toString());
                    if (((String)object).indexOf("menu/v2/?service=mainmenu") != -1) {
                        this.predictHomePageLoading();
                    }
                    this._target.getDSIBrowser().loadUrl((String)object);
                    break;
                }
                this._target.getDSIBrowser().goBack();
                break;
            }
            case 3: {
                if (this._target.getDSIBrowser() == null) {
                    if (!this.getTarget().isTraceEnabled()) break;
                    object = this._target.info();
                    object.append(this._classname).append(".handleNavigateTo(").append(n).append(", ").append(n2).append(", ").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(") DSI Browser not available").log();
                    break;
                }
                this._target.getDSIBrowser().goForward();
                break;
            }
            case 4: {
                if (!this.getTarget().isTraceEnabled()) break;
                object = this._target.info();
                object.append(this._classname).append(".handleNavigateTo(").append(n).append(", ").append(n2).append(", ").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(") Unhandled destination").log();
                break;
            }
            case 5: {
                if (Util.isNullOrEmpty(string)) {
                    if (!this.getTarget().isTraceEnabled()) break;
                    object = this._target.info();
                    object.append(this._classname).append(".handleNavigateTo(").append(n).append(", ").append(n2).append(", ").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(") Invalid url").log();
                    break;
                }
                if (this._target.getDSIBrowser() == null) {
                    if (!this.getTarget().isTraceEnabled()) break;
                    object = this._target.info();
                    object.append(this._classname).append(".handleNavigateTo(").append(n).append(", ").append(n2).append(", ").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(") DSI Browser not available").log();
                    break;
                }
                this._target.getDSIBrowser().loadUrl(string);
                break;
            }
            case 6: {
                if (this.getTarget().isTraceEnabled()) {
                    object = this._target.info();
                    object.append(this._classname).append(".handleNavigateTo(").append(n).append(", ").append(n2).append(", ").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(") Unhandled destination").log();
                }
                if (this._target.getDSIBrowser() == null) {
                    if (!this.getTarget().isTraceEnabled()) break;
                    object = this._target.info();
                    object.append(this._classname).append(".handleNavigateTo(").append(n).append(", ").append(n2).append(", ").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(") DSI Browser not available").log();
                    break;
                }
                this._target.getDSIBrowser().loadUrl(this.disclaimerURL);
                break;
            }
            case 7: {
                break;
            }
            default: {
                if (!this.getTarget().isTraceEnabled()) break;
                object = this._target.info();
                object.append(this._classname).append(".handleNavigateTo(").append(n).append(", ").append(n2).append(", ").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(") Unknown destination").log();
            }
        }
    }

    private void predictHomePageLoading() {
        this.getHMINotifier().setCurrentPageLoadingState(0, "Home:predicted LOADING1");
        this.notifyHMIIsCurrentPageHome(true);
        this.getHMINotifier().setCurrentPageLoadingState(0, "Home:predicted LOADING2");
    }

    public void handleCancelLoading() {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this._target.trace();
            logMessage.append(this._classname).append(".handleCancelLoading()").log();
        }
        if (this._target.getDSIBrowser() == null) {
            if (this.getTarget().isTraceEnabled()) {
                logMessage = this._target.info();
                logMessage.append(this._classname).append(".handleCancelLoading() DSI Browser not available").log();
            }
        } else {
            this._target.getDSIBrowser().cancelLoading();
        }
    }

    public void handleCheckBookmark(int n, int n2) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this._target.trace();
            logMessage.append(this._classname).append(".handleCheckBookmark(").append(n).append(", ").append(n2).append(")").log();
        }
        switch (n) {
            case 0: {
                if (!this.getTarget().isTraceEnabled()) break;
                logMessage = this._target.info();
                logMessage.append(this._classname).append(".handleCheckBookmark(").append(n).append(", ").append(n2).append(") Unhandled action").log();
                break;
            }
            case 1: {
                if (!this.getTarget().isTraceEnabled()) break;
                logMessage = this._target.info();
                logMessage.append(this._classname).append(".handleCheckBookmark(").append(n).append(", ").append(n2).append(") Unhandled action").log();
                break;
            }
            case 2: {
                if (!this.getTarget().isTraceEnabled()) break;
                logMessage = this._target.info();
                logMessage.append(this._classname).append(".handleCheckBookmark(").append(n).append(", ").append(n2).append(") Unhandled action").log();
                break;
            }
            case 3: {
                if (!this.getTarget().isTraceEnabled()) break;
                logMessage = this._target.info();
                logMessage.append(this._classname).append(".handleCheckBookmark(").append(n).append(", ").append(n2).append(") Unhandled action").log();
                break;
            }
            default: {
                if (!this.getTarget().isTraceEnabled()) break;
                logMessage = this._target.info();
                logMessage.append(this._classname).append(".handleCheckBookmark(").append(n).append(", ").append(n2).append(") Unknown action").log();
            }
        }
    }

    public void handleBrowserClicked(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this._target.trace();
            logMessage.append(this._classname).append(".handleBrowserClicked(").append(n).append(", ").append(n2).append(", ").append(n3).append(", ").append(n4).append(", ").append(n5).append(", ").append(n6).append(", ").append(n7).append(")").log();
        }
        switch (n7) {
            case 0: {
                this.counter = 0;
                this.tmpScrollX = 0;
                this.tmpScrollY = 0;
                this.motionlessTouching = true;
                this.tmpPosX = n;
                break;
            }
            case 1: {
                this.counter = 0;
                this.tmpScrollX = 0;
                this.tmpScrollY = 0;
                if (!this.motionlessTouching) break;
                if (this._target.getDSIBrowser() == null) {
                    if (!this.getTarget().isTraceEnabled()) break;
                    logMessage = this._target.info();
                    logMessage.append(this._classname).append(".handleBrowserClicked(").append(n).append(", ").append(n2).append(", ").append(n3).append(", ").append(n4).append(", ").append(n5).append(", ").append(n6).append(", ").append(n7).append(") DSI Browser not available").log();
                    break;
                }
                this.getHMINotifier().setCurrentPageLoadingState(4, "exit endless loading");
                this._target.getDSIBrowser().clickOnPosition(n, n2, false);
                this.motionlessTouching = false;
                break;
            }
            case 2: {
                this.motionlessTouching = false;
                if (this._target.getDSIBrowser() == null) {
                    if (!this.getTarget().isTraceEnabled()) break;
                    logMessage = this._target.info();
                    logMessage.append(this._classname).append(".handleBrowserClicked(").append(n).append(", ").append(n2).append(", ").append(n3).append(", ").append(n4).append(", ").append(n5).append(", ").append(n6).append(", ").append(n7).append(") DSI Browser not available").log();
                    break;
                }
                this._target.getDSIBrowser().scroll(12, 0);
                this._target.getDSIBrowser().clickOnPosition(this.tmpPosX, n2 - 0, false);
                this.tmpPosX = 0;
                break;
            }
            case 3: {
                this.motionlessTouching = false;
                if (this._target.getDSIBrowser() == null) {
                    if (!this.getTarget().isTraceEnabled()) break;
                    logMessage = this._target.info();
                    logMessage.append(this._classname).append(".handleBrowserClicked(").append(n).append(", ").append(n2).append(", ").append(n3).append(", ").append(n4).append(", ").append(n5).append(", ").append(n6).append(", ").append(n7).append(") DSI Browser not available").log();
                    break;
                }
                this.debounceTouchScroll(-n3, -n4);
                break;
            }
            case 4: {
                break;
            }
            default: {
                if (!this.getTarget().isTraceEnabled()) break;
                logMessage = this._target.info();
                logMessage.append(this._classname).append(".handleBrowserClicked(").append(n).append(", ").append(n2).append(", ").append(n3).append(", ").append(n4).append(", ").append(n5).append(", ").append(n6).append(", ").append(n7).append(") Unknown touch gesture").log();
            }
        }
    }

    public void handleFocusLink(int n) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this._target.trace();
            logMessage.append(this._classname).append(".handleFocusLink(").append(n).append(")").log();
        }
        this.counter = 0;
        switch (n) {
            case 0: {
                if (this._target.getDSIBrowser() == null) {
                    if (!this.getTarget().isTraceEnabled()) break;
                    logMessage = this._target.info();
                    logMessage.append(this._classname).append(".handleFocusLink(").append(n).append(") DSI Browser not available").log();
                    break;
                }
                this.debounceTouchScroll(0, 40);
                break;
            }
            case 1: {
                if (this._target.getDSIBrowser() == null) {
                    if (!this.getTarget().isTraceEnabled()) break;
                    logMessage = this._target.info();
                    logMessage.append(this._classname).append(".handleFocusLink(").append(n).append(") DSI Browser not available").log();
                    break;
                }
                this.debounceTouchScroll(0, -40);
                break;
            }
            case 2: {
                break;
            }
            default: {
                if (!this.getTarget().isTraceEnabled()) break;
                logMessage = this._target.trace();
                logMessage.append(this._classname).append(".handleFocusLink(").append(n).append(") Unknown action").log();
            }
        }
    }

    public void handleCodingValues(Coding coding) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append(this._classname).append(".handleCodingValues() Parameter ").append(coding == null ? "invalid" : "valid").log();
        }
        if (coding != null) {
            // empty if block
        }
    }

    public void handleAdaptationValues(Adaptation adaptation) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append(this._classname).append(".handleAdaptationValues() Parameter ").append(adaptation == null ? "invalid" : "valid").log();
        }
        if (adaptation != null) {
            // empty if block
        }
    }

    public void handleResetSettings(FactoryResetCallback factoryResetCallback, int n) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append(this._classname).append(".handleResetSettings()").log();
        }
        this.reset();
        this.callback = factoryResetCallback;
        this.notifyResetDone();
    }

    public void handleLanguageUpdate(String string) {
        if (Util.isNullOrEmpty(string)) {
            LogMessage logMessage = this._target.info();
            logMessage.append(this._classname).append(".handleLanguageUpdate(").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(") Invalid language parameter").log();
        } else if (this._target.getDSIBrowser() == null) {
            LogMessage logMessage = this._target.info();
            logMessage.append(this._classname).append(".handleLanguageUpdate(").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(") DSI Browser not available").log();
        } else {
            if (this.getTarget().isTraceEnabled()) {
                LogMessage logMessage = this._target.trace();
                logMessage.append(this._classname).append(".handleEventLanguageUpdate(").append(Util.isNullOrEmpty(string) ? "<null>" : string).append(")").log();
            }
            this._target.getDSIBrowser().setLanguage(string);
            this._target.getDSIBrowser().deleteCache();
            this.setCurrentLanguage(string);
        }
    }

    public void handleAmbientLightUpdate(String string) {
        this._target.getDSIBrowser().setPreference(145, 0, string);
        this._target.getDSIBrowser().deleteCache();
        LogMessage logMessage = this._target.info();
        logMessage.append(this._classname).append(".handleAmbientLightUpdate(").append(Util.isNullOrEmpty(string)).log();
    }

    public void notifyHMIIsCurrentPageHome(boolean bl) {
        this.getHMINotifier().setCurrentPageHome(bl);
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this._target.info();
            logMessage.append(this._classname).append(" setCurrentPageHome to: ").append(bl).log();
        }
    }

    public void notifyHMICurrentFrameType(int n) {
        this.getHMINotifier().setCurrentPageFrameType(n);
    }

    public void handleScrollbar(int n, int n2) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this._target.trace();
            logMessage.append(this._classname).append(" xPos ").append(n).append(" yPos ").append(n2).log();
        }
        if (this.counter != 0) {
            this.tmpScrollY = n2 - this.tmpScrollY;
            this.tmpScrollX = n - this.tmpScrollX;
        } else {
            this.tmpScrollY = n2 - this.scrollPosition4y;
            this.tmpScrollX = this.scrollPosition4x - n;
        }
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this._target.trace();
            logMessage.append(this._classname).append(" ScrollPositionX ").append(this.scrollPosition4x).append(" ScrollPositionY ").append(this.scrollPosition4y).log();
        }
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this._target.trace();
            logMessage.append(this._classname).append(" tmpScrollX ").append(this.tmpScrollX).append(" tmpScrollY ").append(this.tmpScrollY).log();
        }
        if (n == 0) {
            this.tmpScrollX = 0;
        } else if (n2 == 0) {
            this.tmpScrollY = 0;
        }
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this._target.trace();
            logMessage.append(this._classname).append(" counter ").append(this.counter).log();
        }
        ++this.counter;
        this.debounceTouchScroll(this.tmpScrollX, this.tmpScrollY);
        this.tmpScrollY = n2;
    }

    public void showSpeedPopup(boolean bl) {
        this.speedPopupCoded = bl;
        if (this.speedPopupCoded) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-531756800, false);
        }
    }

    public void sendHMIDisclaimerEvent(boolean bl) {
        if (!this.speedPopupCoded) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-531756800, bl);
        }
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this._target.trace();
            logMessage.append(this._classname).append(" Show Disclaimer with flags: ").append(bl).append(" Popup Coded: ").append(this.speedPopupCoded).append(" Confirmed: ").append(this.speedPopupConfirmed).log();
        }
    }

    public void speedPopupConfirmed(boolean bl) {
        this.speedPopupConfirmed = bl;
    }

    public void importContactResult(int n) {
    }

    public void updateServiceAvailable(boolean bl) {
    }

    public void updateContactCapacity(int n) {
    }

    public void updateGuidanceActive(boolean bl) {
    }

    public void notifyResetDone() {
        this.callback.notifyResetDone();
    }

    public String getActiveURL() {
        return this.activeURL;
    }

    public void reloadMainPage() {
        this._target.getDSIBrowser().loadUrl(this.menuURL);
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.handleResetSettings(factoryResetCallback, n);
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    public int getCurrentBrowserState() {
        return this.currentBrowserState;
    }

    public void setCurrentBrowserState(int n) {
        this.currentBrowserState = n;
    }

    public String getNavInputURL() {
        return this.navInputURL;
    }

    public void setNavInputURL(String string) {
        this.navInputURL = string;
    }

    @Override
    public void updateImageInfo(ResourceLocator resourceLocator) {
    }

    @Override
    public void getServiceURLResponse(String string, String string2) {
        if (!Util.isNullOrEmpty(string)) {
            if (string.equals(ASLOnlineFactory.getOnlineCoreServices().getServiceIDWithNumericServiceID(15))) {
                this.setMenuDisclaimerPath(string2);
            }
            if (!Util.isNullOrEmpty(string2)) {
                LogMessage logMessage;
                if (string.equals(ASLOnlineFactory.getOnlineCoreServices().getServiceIDWithNumericServiceID(44))) {
                    if (Util.isNullOrEmpty(this._ICEUrl)) {
                        logMessage = this._target.info();
                        logMessage.append(this._classname).append(" TYPE of ICE URL is missing --> Register or login").log();
                    } else {
                        this.getTarget().getDSIBrowser().loadUrl(new StringBuffer().append(string2).append(this._ICEUrl).toString());
                    }
                }
                if (this.getTarget().isTraceEnabled()) {
                    logMessage = this._target.trace();
                    logMessage.append(this._classname).append(" getServiceURL: ").append(string2).log();
                }
            } else {
                this.getHMINotifier().setCurrentPageLoadingState(2, "NOT_FOUND");
                if (this.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = this._target.trace();
                    logMessage.append(this._classname).append(" NO SERVICE URL AVAILABLE").log();
                }
            }
        }
    }

    @Override
    public void updateImageInfo(int n, ResourceLocator resourceLocator) {
    }

    public String getCurrentLanguage() {
        return this._currentLanguage;
    }

    public void setCurrentLanguage(String string) {
        this._currentLanguage = string;
    }
}

