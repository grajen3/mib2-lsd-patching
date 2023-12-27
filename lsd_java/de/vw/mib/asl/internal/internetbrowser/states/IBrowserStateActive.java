/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.states;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.internetbrowser.IBrowserController;
import de.vw.mib.asl.internal.internetbrowser.common.EfiLinkHandler;
import de.vw.mib.asl.internal.internetbrowser.states.IBrowserTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import org.dsi.ifc.browser.HistoryEntry;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.browser.SelectionEntry;
import org.dsi.ifc.browser.TimePeriod;

public class IBrowserStateActive
extends AbstractHsmState {
    private final IBrowserTarget _target;
    private final String _classname = super.getClass().getName();
    private boolean showSpeedPopup = false;
    private static boolean _reloadUrl = false;

    public IBrowserStateActive(IBrowserTarget iBrowserTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = iBrowserTarget;
    }

    private IBrowserTarget getTarget() {
        return this._target;
    }

    private IBrowserController getController() {
        return this.getTarget().getController();
    }

    private EfiLinkHandler getEfiLinkHandler() {
        return this.getTarget().getEfiHandler();
    }

    public void setSpeedPopup(boolean bl) {
        this.showSpeedPopup = bl;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                break;
            }
            case 2: {
                break;
            }
            case 1073744187: {
                this.getController().handleNavigateTo(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getString(2));
                break;
            }
            case 4300082: {
                if (this.showSpeedPopup) break;
                boolean bl = eventGeneric.getBoolean(0);
                this.getController().sendHMIDisclaimerEvent(bl);
                if (!this.getTarget().isTraceEnabled()) break;
                LogMessage logMessage = this.getTarget().trace();
                logMessage.append(this._classname).append(".handle(BROWSER_THRESHOLD_EXCEEDED): ").append(bl).log();
                break;
            }
            case 1073744186: {
                int n = eventGeneric.getInt(0);
                boolean bl = eventGeneric.getBoolean(1);
                if (this.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = this.getTarget().trace();
                    logMessage.append(this._classname).append(new StringBuffer().append(".handle(SET_CONTEXT)-> Context : ").append(n).append(" Activate : ").append(bl).toString()).log();
                }
                if (_reloadUrl) {
                    this.getController().handleSetContext(n, bl);
                }
                if (!bl) break;
                this._target.getDSIBrowser().bringToFront();
                break;
            }
            case 1074341838: {
                _reloadUrl = eventGeneric.getBoolean(0);
                if (!this.getTarget().isTraceEnabled()) break;
                LogMessage logMessage = this.getTarget().trace();
                logMessage.append(this._classname).append(new StringBuffer().append(".handle(RELOAD_URL)->").append(_reloadUrl).toString()).log();
                break;
            }
            case 1074341839: {
                this.getController().reloadMainPage();
                if (!this.getTarget().isTraceEnabled()) break;
                LogMessage logMessage = this.getTarget().trace();
                logMessage.append(this._classname).append(new StringBuffer().append(".handle(RELOAD_MAIN_PAGE)->").append(_reloadUrl).toString()).log();
                break;
            }
            case 1073744191: {
                int n = eventGeneric.getInt(0);
                switch (n) {
                    case 0: {
                        this.getController().handleFocusLink(n);
                        break block0;
                    }
                    case 1: {
                        this.getController().handleFocusLink(n);
                        break block0;
                    }
                    case 2: {
                        this.getController().handleFocusLink(n);
                        break block0;
                    }
                }
                if (!this.getTarget().isTraceEnabled()) break;
                LogMessage logMessage = this._target.trace();
                logMessage.append(this._classname).append(".handle(EV_DIAG_RECEIVE_CODING_DATA)").append(n).append(") Unknown action").log();
                break;
            }
            case 1074341828: {
                this.getController().spellerOK();
                break;
            }
            case 1074341829: {
                this.getController().spellerCancel();
                break;
            }
            case 1074341827: {
                this.getController().spellerDeleteChar();
                break;
            }
            case 1074341826: {
                this.getController().spellerAddChar(eventGeneric.getString(0));
                break;
            }
            case 1074341830: {
                this.getController().spellerSetCursorPosition(eventGeneric.getInt(0));
                break;
            }
            case 4300087: {
                this.showSpeedPopup = eventGeneric.getBoolean(0);
                this.getController().showSpeedPopup(this.showSpeedPopup);
                if (this.showSpeedPopup) {
                    this.getController().sendHMIDisclaimerEvent(false);
                }
                if (!this.getTarget().isTraceEnabled()) break;
                LogMessage logMessage = this.getTarget().trace();
                logMessage.append(this._classname).append(".handle(BROWSER_SHOW_SPEED_POPUP): ").append(this.showSpeedPopup).log();
                break;
            }
            case 1074341837: {
                if (this.getEfiLinkHandler() != null) {
                    this.getEfiLinkHandler().getLocationAndSendToBE();
                    if (!this.getTarget().isTraceEnabled()) break;
                    LogMessage logMessage = this.getTarget().trace();
                    logMessage.append(this._classname).append(".handle(NAV_INPUT_FINISHED): ").log();
                    break;
                }
                if (!this.getTarget().isTraceEnabled()) break;
                LogMessage logMessage = this.getTarget().trace();
                logMessage.append(this._classname).append(".handle(NAV_INPUT_FINISHED): ").append(" -->EFI Link Handler is NULL ").log();
                break;
            }
            case 1074341836: {
                this.getController().speedPopupConfirmed(true);
                if (!this.getTarget().isTraceEnabled()) break;
                LogMessage logMessage = this.getTarget().trace();
                logMessage.append(this._classname).append(".handle(DISCLAIMER_UNDERSTOOD): OK ").log();
                break;
            }
            case 4300004: {
                if (!eventGeneric.getBoolean(0) || !this.showSpeedPopup) break;
                this.getController().showSpeedPopup(true);
                this.getController().speedPopupConfirmed(false);
                break;
            }
            case 100005: {
                if (!eventGeneric.getBoolean(-1501167360)) break;
                break;
            }
            case 1073744190: {
                this.getController().handleBrowserClicked(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getInt(2), eventGeneric.getInt(3), eventGeneric.getInt(4), eventGeneric.getInt(5), eventGeneric.getInt(6));
                if (0 == eventGeneric.getInt(6)) break;
                this.trans(this.getTarget()._stateActive);
                break;
            }
            case 40003: {
                Object object;
                String string = eventGeneric.getString(1);
                this.getController().handleLanguageUpdate(string);
                if (this.getTarget().isTraceEnabled()) {
                    object = this.getTarget().trace();
                    object.append(this._classname).append(" LSC change to ").append(string).log();
                }
                object = ServiceManager.mGenericEventFactory.newEvent(1151074304);
                ((EventGeneric)object).setInt(0, eventGeneric.getInt(0));
                ((EventGeneric)object).setBoolean(1, true);
                ((EventGeneric)object).setString(2, string);
                this.getTarget().send((EventGeneric)object);
                break;
            }
            case 2200003: {
                int n = eventGeneric.getInt(0);
                if (this.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = this.getTarget().trace();
                    logMessage.append(this._classname).append(".handle(ASL_CONNECTIVITY_GSM_CONNECTION_TYPE: )").append(n).log();
                }
                switch (n) {
                    case 0: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-632420096, 0);
                        break block0;
                    }
                    case 1: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-632420096, 1);
                        break block0;
                    }
                    case 2: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-632420096, 2);
                        break block0;
                    }
                    case 3: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-632420096, 4);
                        break block0;
                    }
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(-632420096, 0);
                break;
            }
            case 2200006: {
                if (this.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = this.getTarget().trace();
                    logMessage.append(this._classname).append(".handle(ASL_CONNECTIVITY_GSM_ROAMING_ACTIVE)").log();
                }
                ServiceManager.aslPropertyManager.valueChangedBoolean(-582088448, eventGeneric.getBoolean(0));
                break;
            }
            case 2200004: {
                int n = eventGeneric.getInt(0);
                if (this.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = this.getTarget().trace();
                    logMessage.append(this._classname).append(".handle(ASL_CONNECTIVITY_GSM_SIGNAL_STRENGTH: )").append(n).log();
                }
                switch (n) {
                    case 0: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-665974528, 0);
                        break block0;
                    }
                    case 1: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-665974528, 1);
                        break block0;
                    }
                    case 2: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-665974528, 2);
                        break block0;
                    }
                    case 3: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-665974528, 3);
                        break block0;
                    }
                    case 4: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-665974528, 4);
                        break block0;
                    }
                    case 5: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-665974528, 5);
                        break block0;
                    }
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(-665974528, 0);
                break;
            }
            case 2200007: {
                int n = eventGeneric.getInt(0);
                if (this.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = this.getTarget().trace();
                    logMessage.append(this._classname).append(".handle(ASL_CONNECTIVITY_WLAN_SIGNAL_STRENGTH: )").append(n).log();
                }
                switch (n) {
                    case 0: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-649197312, 0);
                        break block0;
                    }
                    case 1: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-649197312, 1);
                        break block0;
                    }
                    case 2: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-649197312, 2);
                        break block0;
                    }
                    case 3: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-649197312, 3);
                        break block0;
                    }
                    case 4: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-649197312, 4);
                        break block0;
                    }
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(-649197312, 0);
                break;
            }
            case 2800007: {
                this.getController().handleScrollbar(eventGeneric.getInt(0), 0);
                if (!this.getTarget().isTraceEnabled()) break;
                LogMessage logMessage = this._target.trace();
                logMessage.append(this._classname).append(".handle(SCROLLBAR_VALUE_CHANGE_X) ").append(eventGeneric.getInt(0)).log();
                break;
            }
            case 1074341834: {
                this.getController().handleScrollbar(eventGeneric.getInt(0), 0);
                if (!this.getTarget().isTraceEnabled()) break;
                LogMessage logMessage = this._target.trace();
                logMessage.append(this._classname).append(".handle(SCROLLBAR_VALUE_CHANGE_X) ").append(eventGeneric.getInt(0)).log();
                break;
            }
            case 2800008: {
                this.getController().handleScrollbar(0, eventGeneric.getInt(0));
                if (!this.getTarget().isTraceEnabled()) break;
                LogMessage logMessage = this._target.trace();
                logMessage.append(this._classname).append(".handle(SCROLLBAR_VALUE_CHANGE_Y) ").append(eventGeneric.getInt(0)).log();
                break;
            }
            case 1074341835: {
                this.getController().handleScrollbar(0, eventGeneric.getInt(0));
                if (!this.getTarget().isTraceEnabled()) break;
                LogMessage logMessage = this._target.trace();
                logMessage.append(this._classname).append(".handle(SCROLLBAR_VALUE_CHANGE_Y) ").append(eventGeneric.getInt(0)).log();
                break;
            }
            case 2200005: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(-565311232, eventGeneric.getBoolean(0));
                break;
            }
            case 2200001: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(-615642880, false);
                ServiceManager.aslPropertyManager.valueChangedBoolean(-598865664, false);
                break;
            }
            case 2200002: {
                int n = eventGeneric.getInt(0);
                if (this.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = this.getTarget().trace();
                    logMessage.append(this._classname).append(".handle(ASL_CONNECTIVITY_ONLINE_CONNECTION_MODE: )").append(n).log();
                }
                switch (n) {
                    case 0: {
                        break block0;
                    }
                    case 1: {
                        ServiceManager.aslPropertyManager.valueChangedBoolean(-615642880, false);
                        ServiceManager.aslPropertyManager.valueChangedBoolean(-598865664, true);
                        break block0;
                    }
                    case 2: {
                        ServiceManager.aslPropertyManager.valueChangedBoolean(-615642880, false);
                        ServiceManager.aslPropertyManager.valueChangedBoolean(-598865664, true);
                        break block0;
                    }
                    case 3: {
                        ServiceManager.aslPropertyManager.valueChangedBoolean(-615642880, true);
                        ServiceManager.aslPropertyManager.valueChangedBoolean(-598865664, false);
                        break block0;
                    }
                    case 4: {
                        break block0;
                    }
                }
                ServiceManager.aslPropertyManager.valueChangedBoolean(-615642880, false);
                break;
            }
            case 2800000: {
                this.getController().registerEfiLinkConsumer(eventGeneric);
                break;
            }
            case 2800001: {
                this.getController().unregisterEfiLinkConsumer(eventGeneric);
                break;
            }
            case 2100016: {
                String string = eventGeneric.getString(0);
                if (Util.isNullOrEmpty(string)) break;
                this.getTarget().setVINNumber(string);
                break;
            }
            case 4: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiBrowserIndicateEfiUrl(String string) {
        this.getController().reportEfiLink(string);
    }

    public void dsiBrowserUpdateBrowserState(int n, int n2) {
        this.getController().handleUpdateBrowserState(n);
    }

    public void dsiBrowserUpdatePageTitle(String string, int n) {
        this.getController().handleUpdatePageTitle(string);
    }

    public void dsiBrowserUpdateActiveUrl(String string, int n) {
        this.getController().handleUpdateActiveUrl(string);
    }

    public void dsiBrowserUpdateZoomFactor(int n, int n2) {
        this.getController().handleUpdateZoomFactor(n);
    }

    public void dsiBrowserUpdateVirtualKeyboardStatus(boolean bl, int n) {
        this.getController().handleUpdateVirtualKeyboardStatus(bl);
    }

    public void dsiBrowserUpdateEncryption(boolean bl, int n) {
        this.getController().handleUpdateEncryption(bl);
    }

    public void dsiBrowserUpdateHasFocus(boolean bl, int n) {
        this.getController().handleUpdateHasFocus(bl);
    }

    public void dsiBrowserUpdateButtonState(int n, int n2, int n3) {
        this.getController().handleUpdateButtonState(n, n2);
    }

    public void dsiBrowserUpdateProgress(int n, int n2) {
        this.getController().handleUpdateProgress(n);
    }

    public void dsiBrowserUpdateScrollbarX(int n, int n2, int n3, int n4) {
        this.getController().handleUpdateScrollbarX(n, n2, n3);
    }

    public void dsiBrowserUpdateScrollbarY(int n, int n2, int n3, int n4) {
        this.getController().handleUpdateScrollbarY(n, n2, n3);
    }

    public void dsiBrowserUpdateKeyboardDisplay(boolean bl, KeyboardInfo keyboardInfo, int n) {
        this.getController().handleUpdateKeyboardDisplay(bl, keyboardInfo);
    }

    public void dsiBrowserGetPreferenceResult(int n, int n2, String string) {
        this.getController().handleGetPreferenceResult(n, n2, string);
    }

    public void dsiBrowserJavascriptAlert(String string) {
        this.getController().handleJavascriptAlert(string);
    }

    public void dsiBrowserJavascriptConfirm(String string) {
        this.getController().handleJavascriptConfirm(string);
    }

    public void dsiBrowserJavascriptPrompt(String string, String string2) {
        this.getController().handleJavascriptPrompt(string, string2);
    }

    public void dsiBrowserUpdateSelectionListContent(SelectionEntry[] selectionEntryArray, boolean bl, int n) {
        this.getController().handleUpdateSelectionListContent(selectionEntryArray, bl);
    }

    public void dsiBrowserExportBrowserDataResult(int n) {
        this.getController().handleExportBrowserDataResult(n);
    }

    public void dsiBrowserImportBrowserDataResult(int n) {
        this.getController().handleImportBrowserDataResult(n);
    }

    public void dsiBrowserGetHistoryResult(TimePeriod timePeriod, HistoryEntry[] historyEntryArray, int n) {
        this.getController().handleGetHistoryResult(timePeriod, historyEntryArray, n);
    }

    public void dsiBrowserAsyncException(int n, String string, int n2) {
        this.getController().handleAsyncException(n, string, n2);
    }

    public long getTimeout() {
        return 0L;
    }
}

