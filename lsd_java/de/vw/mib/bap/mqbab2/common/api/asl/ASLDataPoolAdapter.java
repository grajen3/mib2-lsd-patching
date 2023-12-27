/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.asl;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListDataUpdateListener;
import de.vw.mib.bap.mqbab2.common.api.APIFactory;
import de.vw.mib.bap.mqbab2.common.api.asl.ASLDataPoolAdapter$1;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.datapool.ASLDatapoolObserver;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;

public abstract class ASLDataPoolAdapter
implements ASLDatapoolObserver,
ASLListDataUpdateListener {
    private ASLDatapool _dataPool;
    private IntObjectOptHashMap _registeredDelegates;

    public ASLDataPoolAdapter(ASLDatapool aSLDatapool) {
        this._dataPool = aSLDatapool;
        this.register();
    }

    protected ASLDatapool getDataPool() {
        return this._dataPool;
    }

    protected static String getStringListValue(int n, int n2) {
        ASLList aSLList = ListManager.getASLList(n);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getString(n2, object);
    }

    protected static long getLongListValue(int n, int n2) {
        ASLList aSLList = ListManager.getASLList(n);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getLong(n2, object);
    }

    protected static int getIntegerListValue(int n, int n2) {
        ASLList aSLList = ListManager.getASLList(n);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(n2, object);
    }

    protected static boolean getBooleanListValue(int n, int n2) {
        ASLList aSLList = ListManager.getASLList(n);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getBoolean(n2, object);
    }

    protected static ResourceLocator getResourceLocatorListValue(int n, int n2) {
        ASLList aSLList = ListManager.getASLList(n);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getResourceLocator(n2, object);
    }

    protected static int[] getIntegerListColumn(int n, int n2) {
        ASLList aSLList = ListManager.getASLList(n);
        int[] nArray = new int[aSLList.getSize()];
        int n3 = aSLList.getSize();
        for (int i2 = 0; i2 < n3; ++i2) {
            nArray[i2] = aSLList.getListTransformer().getInt(n2, aSLList.getRowItem(i2));
        }
        return nArray;
    }

    protected static ResourceLocator[] getResourceLocatorListColumn(int n, int n2) {
        ASLList aSLList = ListManager.getASLList(n);
        ResourceLocator[] resourceLocatorArray = new ResourceLocator[aSLList.getSize()];
        int n3 = aSLList.getSize();
        for (int i2 = 0; i2 < n3; ++i2) {
            resourceLocatorArray[i2] = aSLList.getListTransformer().getResourceLocator(n2, aSLList.getRowItem(i2));
        }
        return resourceLocatorArray;
    }

    private IntObjectOptHashMap getRegisteredDelegates() {
        if (this._registeredDelegates == null) {
            this._registeredDelegates = new IntObjectOptHashMap();
        }
        return this._registeredDelegates;
    }

    protected final List getRegisteredServiceDelegates(int n) {
        return (List)this.getRegisteredDelegates().get(n);
    }

    private void registerProperties(int[] nArray) {
        if (nArray != null) {
            int n = nArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                this.getDataPool().registerObserver(nArray[i2], this);
            }
        }
    }

    private void registerLists(int[] nArray) {
        if (nArray != null) {
            int n = nArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                ListManager.getASLList(nArray[i2]).addASLListDataUpdateListener(this);
            }
        }
    }

    public void unregister() {
        int[] nArray;
        int n;
        int[] nArray2 = this.getPropertyIds();
        if (nArray2 != null) {
            n = nArray2.length;
            for (int i2 = 0; i2 < n; ++i2) {
                this.getDataPool().unregisterObserver(nArray2[i2], this);
            }
        }
        if ((nArray = this.getListIds()) != null) {
            int n2 = nArray.length;
            for (n = 0; n < n2; ++n) {
                ListManager.getASLList(nArray[n]).removeASLListDataUpdateListener(this);
            }
        }
    }

    public void register() {
        this.registerProperties(this.getPropertyIds());
        this.registerLists(this.getListIds());
    }

    protected abstract int[] getPropertyIds() {
    }

    protected abstract int[] getListIds() {
    }

    protected void registerServiceListener(Object object, int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list == null) {
            list = new ArrayList();
            this.getRegisteredDelegates().put(n, list);
            list.add(object);
        } else if (list != null && !list.contains(object)) {
            list.add(object);
        }
    }

    protected void unregisterServiceListener(Object object, int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            list.remove(object);
        }
    }

    public void registerServiceListener(Object object, int[] nArray) {
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.registerServiceListener(object, nArray[i2]);
        }
    }

    public void removeServiceListener(Object object, int[] nArray) {
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.unregisterServiceListener(object, nArray[i2]);
        }
    }

    protected static void sendSafe(EventGeneric eventGeneric) {
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    protected abstract void listValueChanged(int n) {
    }

    @Override
    public void notifyListDataUpdated(ASLList aSLList) {
        ThreadSwitchingTarget threadSwitchingTarget = APIFactory.getAPIFactory().getThreadSwitchingService();
        if (threadSwitchingTarget.isThreadChangeNecessary()) {
            threadSwitchingTarget.enqueue(new ASLDataPoolAdapter$1(this, aSLList));
        } else {
            this.listValueChanged(aSLList.getListId());
        }
    }
}

