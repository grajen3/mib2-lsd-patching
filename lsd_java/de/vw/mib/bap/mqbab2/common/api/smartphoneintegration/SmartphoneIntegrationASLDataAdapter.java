/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.smartphoneintegration;

import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.ASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationService;
import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationServiceListener;
import de.vw.mib.datapool.ASLDatapool;
import java.util.Iterator;
import java.util.List;

public class SmartphoneIntegrationASLDataAdapter
extends ASLDataPoolAdapter
implements SmartphoneIntegrationService {
    private APIFactoryInterface apiFactory;
    private static final int[] SMARTPHONE_INTEGRATION_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[]{1114057728};
    private static final int[] SMARTPHONE_INTEGRATION_ASL_LIST_ITEM_IDS_TO_LISTEN_TO = new int[0];
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$api$smartphoneintegration$SmartphoneIntegrationService;

    public SmartphoneIntegrationASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$bap$mqbab2$common$api$smartphoneintegration$SmartphoneIntegrationService == null ? (class$de$vw$mib$bap$mqbab2$common$api$smartphoneintegration$SmartphoneIntegrationService = SmartphoneIntegrationASLDataAdapter.class$("de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationService")) : class$de$vw$mib$bap$mqbab2$common$api$smartphoneintegration$SmartphoneIntegrationService;
    }

    @Override
    public int getSmarphoneIntegrationActiveConnectionType() {
        return this.getDataPool().getInteger(1114057728, 0);
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                SmartphoneIntegrationServiceListener smartphoneIntegrationServiceListener = (SmartphoneIntegrationServiceListener)iterator.next();
                smartphoneIntegrationServiceListener.updateSmartphoneIntegrationData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return SMARTPHONE_INTEGRATION_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return SMARTPHONE_INTEGRATION_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void addSmartphoneIntegrationServiceListener(SmartphoneIntegrationServiceListener smartphoneIntegrationServiceListener, int[] nArray) {
        this.registerServiceListener((Object)smartphoneIntegrationServiceListener, nArray);
    }

    @Override
    public void removeSmartphoneIntegrationServiceListener(SmartphoneIntegrationServiceListener smartphoneIntegrationServiceListener, int[] nArray) {
        this.removeServiceListener(smartphoneIntegrationServiceListener, nArray);
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

