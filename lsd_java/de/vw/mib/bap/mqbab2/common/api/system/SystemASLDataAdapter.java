/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.system;

import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.HMIRelevantASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Iterator;
import java.util.List;

public class SystemASLDataAdapter
extends HMIRelevantASLDataPoolAdapter
implements SystemService {
    private APIFactoryInterface apiFactory;
    private static final int[] SYSTEM_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[]{1584, 1632, 1602, 1643, 1676, 1680, 1645, 1691, 335, 334, 1612, 1652, 3568};
    private static final int[] SYSTEM_ASL_LIST_ITEM_IDS_TO_LISTEN_TO = new int[0];
    private static final int[] SYSTEM_HMI_EVENT_IDS_TO_LISTEN_TO = new int[]{401, 389, 407, 404, 402, 415, 416, 417, 418, 366, 367, 368, 369, 383, 381, 382, 380, 547, 545, 546, 544, 406, 376, 393};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$api$system$SystemService;

    public SystemASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
        this.apiFactory.getHMIEventService().addHMIEventListener(this, SYSTEM_HMI_EVENT_IDS_TO_LISTEN_TO);
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$bap$mqbab2$common$api$system$SystemService == null ? (class$de$vw$mib$bap$mqbab2$common$api$system$SystemService = SystemASLDataAdapter.class$("de.vw.mib.bap.mqbab2.common.api.system.SystemService")) : class$de$vw$mib$bap$mqbab2$common$api$system$SystemService;
    }

    @Override
    public int getCurrentDistanceUnit() {
        return this.getDataPool().getInteger(1584, 0);
    }

    @Override
    public int getSystemOnOffState() {
        return this.getDataPool().getInteger(1632, 5);
    }

    @Override
    public int getDayAndNightMode() {
        return this.getDataPool().getInteger(1602, 2);
    }

    @Override
    public int getSystemTimeFormat() {
        return this.getDataPool().getInteger(1643, 1);
    }

    @Override
    public int getNavigationDomainAvailable() {
        return this.getDataPool().getInteger(1676, 0);
    }

    @Override
    public int getPhoneDomainAvailable() {
        return this.getDataPool().getInteger(1680, 0);
    }

    @Override
    public int getAddressbookDomainAvailable() {
        return this.getDataPool().getInteger(1645, 0);
    }

    @Override
    public int getSpeechDomainAvailable() {
        return this.getDataPool().getInteger(1691, 0);
    }

    @Override
    public boolean isDABAvailable() {
        return this.getDataPool().getBoolean(335, false);
    }

    @Override
    public boolean isAMAvailable() {
        return this.getDataPool().getBoolean(334, false);
    }

    @Override
    public int getCurrentMainContext() {
        return this.getDataPool().getInteger(1612, 0);
    }

    @Override
    public int isComponentProtectionActive() {
        return this.getDataPool().getInteger(1652, 0);
    }

    @Override
    public boolean isArabicVariant() {
        return this.getDataPool().getBoolean(3568, false);
    }

    @Override
    public void setDayAndNightMode(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(872742976, eventGeneric);
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
                SystemServiceListener systemServiceListener = (SystemServiceListener)iterator.next();
                systemServiceListener.updateSystemData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return SYSTEM_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return SYSTEM_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void addSystemServiceListener(SystemServiceListener systemServiceListener, int[] nArray) {
        this.registerServiceListener((Object)systemServiceListener, nArray);
    }

    @Override
    public void removeSystemServiceListener(SystemServiceListener systemServiceListener, int[] nArray) {
        this.removeServiceListener(systemServiceListener, nArray);
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

