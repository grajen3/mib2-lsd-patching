/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.notifier;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.internetbrowser.states.IBrowserTarget;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.internetbrowser.transformer.InternetbrowserCurrentPageStatusCollector;

public final class IBrowserHmiNotifier {
    InternetbrowserCurrentPageStatusCollector[] collector = new InternetbrowserCurrentPageStatusCollector[1];

    public IBrowserHmiNotifier(IBrowserTarget iBrowserTarget) {
        this.collector[0] = new InternetbrowserCurrentPageStatusCollector();
        this.collector[0].internetbrowser_current_page_bookmarked = false;
        this.collector[0].internetbrowser_current_page_status_loading = 0;
        this.collector[0].internetbrowser_current_page_title = "";
        this.collector[0].internetbrowser_current_page_home = false;
        this.collector[0].internetbrowser_current_page_frame_type = 0;
        this.getCurrentPageStatusList().updateList(this.collector);
    }

    private GenericASLList getCurrentPageStatusList() {
        return ListManager.getGenericASLList(3344);
    }

    public void reset() {
        this.setNavigateBackwardAvailable(false);
        this.setNavigateForwardAvailable(false);
        this.setCurrentPageBookmarked(false);
        this.setCurrentPageLoadingState(0, "reset");
        this.setCurrentPageTitle("");
        this.setCurrentPageFrameType(0);
    }

    public boolean setCurrentPageFrameType(int n) {
        Object object;
        boolean bl = false;
        GenericASLList genericASLList = this.getCurrentPageStatusList();
        if (genericASLList.isValidItem(object = genericASLList.getRowItem(0))) {
            ServiceManager.aslPropertyManager.valueChangedInteger(4, n);
            this.collector[0].internetbrowser_current_page_frame_type = n;
            this.getCurrentPageStatusList().updateList(this.collector);
            bl = true;
        }
        return bl;
    }

    public void setNavigateBackwardAvailable(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3341, bl);
    }

    public void setNavigateForwardAvailable(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3342, bl);
    }

    public boolean setCurrentPageBookmarked(boolean bl) {
        Object object;
        boolean bl2 = false;
        GenericASLList genericASLList = this.getCurrentPageStatusList();
        if (genericASLList.isValidItem(object = genericASLList.getRowItem(0))) {
            this.collector[0].internetbrowser_current_page_bookmarked = bl;
            this.getCurrentPageStatusList().updateList(this.collector);
            bl2 = true;
        }
        return bl2;
    }

    public boolean setCurrentPageHome(boolean bl) {
        Object object;
        boolean bl2 = false;
        GenericASLList genericASLList = this.getCurrentPageStatusList();
        if (genericASLList.isValidItem(object = genericASLList.getRowItem(0))) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(3, bl);
            this.collector[0].internetbrowser_current_page_home = bl;
            this.getCurrentPageStatusList().updateList(this.collector);
            bl2 = true;
        }
        return bl2;
    }

    public boolean setCurrentPageLoadingState(int n, String string) {
        Object object;
        boolean bl = false;
        GenericASLList genericASLList = this.getCurrentPageStatusList();
        if (genericASLList.isValidItem(object = genericASLList.getRowItem(0))) {
            this.collector[0].internetbrowser_current_page_status_loading = n;
            this.getCurrentPageStatusList().updateList(this.collector);
            ServiceManager.logger2.info(512, new StringBuffer().append("pageStatus: ").append(IBrowserHmiNotifier.getStateStr(n)).append(" (set by '").append(string).append("')").toString());
            bl = true;
        }
        return bl;
    }

    private static String getStateStr(int n) {
        switch (n) {
            case 0: {
                return "LOADING";
            }
            case 1: {
                return "IDLE";
            }
            case 2: {
                return "NOT_FOUND";
            }
            case 3: {
                return "SUSPENDED";
            }
            case 4: {
                return "COMPLETE";
            }
            case 5: {
                return "OUT_OF_MEMORY";
            }
        }
        return "unknown";
    }

    public boolean setCurrentPageTitle(String string) {
        Object object;
        boolean bl = false;
        GenericASLList genericASLList = this.getCurrentPageStatusList();
        if (genericASLList.isValidItem(object = genericASLList.getRowItem(0))) {
            this.collector[0].internetbrowser_current_page_title = Util.isNullOrEmpty(string) ? "" : string;
            this.getCurrentPageStatusList().updateList(this.collector);
            bl = true;
        }
        return bl;
    }

    public boolean setCurrentPageProgress(int n) {
        boolean bl = false;
        return false;
    }

    public void sendWizardStatus(boolean bl) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(bl ? 1580466944 : 1563689728);
    }
}

