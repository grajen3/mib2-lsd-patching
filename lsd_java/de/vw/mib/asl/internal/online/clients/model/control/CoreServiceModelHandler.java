/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.control;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.online.clients.model.CoreServiceModelFactory;
import de.vw.mib.asl.internal.online.clients.model.common.OnlineServicePackage;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineTrackingService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlineServiceInfoCollector;
import org.dsi.ifc.global.ResourceLocator;

public class CoreServiceModelHandler {
    private int _status = 0;
    private boolean _trackingPopupActivated;

    public void setPropertyBoolean(int n, boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(n, bl);
    }

    public void setPropertyInteger(int n, int n2) {
        ServiceManager.aslPropertyManager.valueChangedInteger(n, n2);
    }

    public void setPropertyLong(int n, long l) {
        ServiceManager.aslPropertyManager.valueChangedLong(n, l);
    }

    public void setPropertyString(int n, String string) {
        ServiceManager.aslPropertyManager.valueChangedString(n, string);
    }

    public void setPropertyResourceLocator(int n, ResourceLocator resourceLocator) {
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(n, resourceLocator);
    }

    public void sendSystemEvent(int n) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n);
    }

    public void sendOnlineServiceGroupList(OnlineServicePackage[] onlineServicePackageArray) {
        this.getOnlineServicePackageList().updateList(onlineServicePackageArray);
    }

    public void sendOnlineServiceList(OnlineService[] onlineServiceArray) {
        ListManager.getGenericASLList(1560089344).updateList(onlineServiceArray);
    }

    public void sendOnlineServiceTrackingList(OnlineTrackingService[] onlineTrackingServiceArray) {
        ListManager.getGenericASLList(1744638720).updateList(onlineTrackingServiceArray);
        this._trackingPopupActivated = true;
    }

    public void sendOnlineServiceDetailInfo(OnlineOnlineServiceInfoCollector[] onlineOnlineServiceInfoCollectorArray) {
        ListManager.getGenericASLList(1576866560).updateList(onlineOnlineServiceInfoCollectorArray);
    }

    public GenericASLList getOnlineServicePackage() {
        return ListManager.getGenericASLList(1560089344);
    }

    public void setCategoryFilter(int n) {
    }

    public OnlineService getOnlineServiceWithSubIndex(int n) {
        if (this.getOnlineServicePackage() != null) {
            return (OnlineService)this.getOnlineServicePackage().getRowItem(n);
        }
        return null;
    }

    public GenericASLList getOnlineServicePackageList() {
        return ListManager.getGenericASLList(1543312128);
    }

    public GenericASLList getOnlineServiceTrackingList() {
        return ListManager.getGenericASLList(1744638720);
    }

    public OnlineServicePackage getOnlineServicePackageWithIndex(int n) {
        if (this.getOnlineServicePackage() != null) {
            return (OnlineServicePackage)this.getOnlineServicePackageList().getRowItem(n);
        }
        return null;
    }

    public int getPackageIndexWithPackageID(int n) {
        if (this.getOnlineServicePackage() != null) {
            int n2 = this.getOnlineServicePackageList().getItemCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                OnlineServicePackage onlineServicePackage = (OnlineServicePackage)this.getOnlineServicePackageList().getRowItem(i2);
                if (onlineServicePackage == null || n != onlineServicePackage.getPackageID()) continue;
                return i2;
            }
        }
        return -1;
    }

    public void setMainUser(OnlineUser onlineUser) {
        String string = "";
        if (onlineUser != null) {
            string = onlineUser.getUserName();
        }
        this.setPropertyString(1274876672, string);
    }

    public void setRequestedOnlineServiceActive(boolean bl) {
        this.setPropertyBoolean(1023218432, bl);
    }

    public void setActivationListLoading(boolean bl) {
        this.setPropertyBoolean(1056772864, bl);
    }

    public void setAuthenticationSuccessful(boolean bl) {
        this.setPropertyBoolean(1190990592, bl);
    }

    public void setIfCarIsMoving(boolean bl) {
        this.setPropertyBoolean(1207767808, bl);
    }

    public void setCarNetRegistrationState(int n) {
        this.setPropertyInteger(1308431104, n);
    }

    public void setOCUAvailability(boolean bl) {
        this.setPropertyBoolean(1392317184, bl);
    }

    public void setOCURuntimeStatus(int n) {
        switch (n) {
            case 1: {
                this._status = 4;
                break;
            }
            case 2: {
                this._status = 2;
                break;
            }
            case 3: {
                this._status = 3;
                break;
            }
            case 0: {
                this._status = 1;
                break;
            }
        }
        this.setPropertyInteger(1442648832, this._status);
    }

    public int getOCURuntimeStatus() {
        return this._status;
    }

    public void callToStartWizard(boolean bl) {
        if (!bl) {
            switch (CoreServiceModelFactory.getPropertyManager().getRegistrationState()) {
                case 2: {
                    CoreServiceModelFactory.getPropertyManager().setWizardStartUp(true);
                    break;
                }
            }
        }
    }

    public void deactivateWizard(int n) {
        this.setPropertyInteger(1425871616, n);
    }

    public void setOnlineServiceConfiguredForAPN2(boolean bl) {
        this.setPropertyBoolean(1593643776, bl);
    }

    public void setPrivacyModeState(boolean bl) {
        this.setPropertyBoolean(1526534912, bl);
    }

    public void setInternalPrecheckStatus(int n) {
        this.setPropertyInteger(1761415936, n);
    }

    public void setTrackingServicesPackageIndex(int n) {
        this.setPropertyInteger(1610420992, n);
    }

    public boolean getTrackingPopupStatus() {
        return this._trackingPopupActivated;
    }

    public void setTrackingPopupStatus(boolean bl) {
        this._trackingPopupActivated = bl;
    }

    public void sendServiceListStatus(int n) {
        this.setPropertyInteger(1794970368, n);
    }
}

