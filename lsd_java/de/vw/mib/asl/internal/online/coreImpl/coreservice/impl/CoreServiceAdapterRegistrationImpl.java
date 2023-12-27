/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.impl;

import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.impl.CoreServiceAdapterRegistrationImpl$AdapterCollector;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapter;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterRegistration;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.Iterator;

public class CoreServiceAdapterRegistrationImpl
implements CoreServiceAdapterRegistration {
    private IntObjectMap _adapterList;
    private CoreServiceAdapter _mainAdapter;
    private int _currentPriority;
    private int _mainAdapterID;

    private IntObjectMap getAdapterMap() {
        if (this._adapterList == null) {
            this._adapterList = new IntObjectOptHashMap();
        }
        return this._adapterList;
    }

    @Override
    public void registerAdapter(int n, int n2, CoreServiceAdapter coreServiceAdapter) {
        if (coreServiceAdapter != null && n > 0) {
            coreServiceAdapter.addUpdateListener(CoreServiceImplFactory.getAdapterUpdateListener());
            CoreServiceAdapterRegistrationImpl$AdapterCollector coreServiceAdapterRegistrationImpl$AdapterCollector = new CoreServiceAdapterRegistrationImpl$AdapterCollector(this);
            coreServiceAdapterRegistrationImpl$AdapterCollector.setAdapterID(n);
            coreServiceAdapterRegistrationImpl$AdapterCollector.setAdapter(coreServiceAdapter);
            coreServiceAdapterRegistrationImpl$AdapterCollector.setPriority(n2);
            coreServiceAdapterRegistrationImpl$AdapterCollector.setAdapterUsable(false);
            coreServiceAdapterRegistrationImpl$AdapterCollector.getPriority();
            this.getAdapterMap().put(n, coreServiceAdapterRegistrationImpl$AdapterCollector);
            if (this._mainAdapter == null || this._currentPriority > n2) {
                this._mainAdapter = coreServiceAdapter;
                this._mainAdapterID = n;
                this._currentPriority = n2;
            }
        }
    }

    @Override
    public void unRegisterAdapter(int n) {
        if (this.getAdapterMap().containsKey(n)) {
            this.getAdapterMap().remove(n);
        }
    }

    @Override
    public CoreServiceAdapter[] getAdapterList() {
        if (!this.getAdapterMap().isEmpty()) {
            int n = this.getAdapterMap().size();
            CoreServiceAdapter[] coreServiceAdapterArray = new CoreServiceAdapter[n];
            int n2 = 0;
            Iterator iterator = this.getAdapterMap().valueIterator();
            while (iterator.hasNext()) {
                CoreServiceAdapterRegistrationImpl$AdapterCollector coreServiceAdapterRegistrationImpl$AdapterCollector = (CoreServiceAdapterRegistrationImpl$AdapterCollector)iterator.next();
                coreServiceAdapterArray[n2] = coreServiceAdapterRegistrationImpl$AdapterCollector.getAdapter();
                ++n2;
            }
            return coreServiceAdapterArray;
        }
        return null;
    }

    @Override
    public CoreServiceAdapter getMainAdapter() {
        return this._mainAdapter;
    }

    @Override
    public int getMainAdapterID() {
        return this._mainAdapterID;
    }

    @Override
    public CoreServiceAdapter getAdapterWithID(int n) {
        CoreServiceAdapterRegistrationImpl$AdapterCollector coreServiceAdapterRegistrationImpl$AdapterCollector;
        if (!this.getAdapterMap().isEmpty() && (coreServiceAdapterRegistrationImpl$AdapterCollector = (CoreServiceAdapterRegistrationImpl$AdapterCollector)this.getAdapterMap().get(n)) != null && coreServiceAdapterRegistrationImpl$AdapterCollector.getAdapterID() == n) {
            return coreServiceAdapterRegistrationImpl$AdapterCollector.getAdapter();
        }
        return null;
    }

    @Override
    public void isReady(int n) {
        CoreServiceAdapterRegistrationImpl$AdapterCollector coreServiceAdapterRegistrationImpl$AdapterCollector;
        CoreServiceImplFactory.getCoreServiceNotifier().updateDeviceReadyForUse(n);
        if (this.getAdapterMap().containsKey(n) && (coreServiceAdapterRegistrationImpl$AdapterCollector = (CoreServiceAdapterRegistrationImpl$AdapterCollector)this.getAdapterMap().get(n)) != null && !coreServiceAdapterRegistrationImpl$AdapterCollector.isAdapterUsable()) {
            coreServiceAdapterRegistrationImpl$AdapterCollector.setAdapterUsable(true);
            this.getAdapterMap().put(n, coreServiceAdapterRegistrationImpl$AdapterCollector);
        }
    }

    @Override
    public CoreServiceAdapter[] getAdapterListWithSupportedMethod(int n) {
        if (!this.getAdapterMap().isEmpty()) {
            CoreServiceAdapter[] coreServiceAdapterArray;
            int n2 = 0;
            Iterator iterator = this.getAdapterMap().valueIterator();
            while (iterator.hasNext()) {
                coreServiceAdapterArray = (CoreServiceAdapter[])iterator.next();
                if (!coreServiceAdapterArray.getAdapter().isFuntionSupported(n)) continue;
                ++n2;
            }
            if (n2 > 0) {
                coreServiceAdapterArray = new CoreServiceAdapter[n2];
                int n3 = 0;
                Iterator iterator2 = this.getAdapterMap().valueIterator();
                while (iterator2.hasNext()) {
                    CoreServiceAdapterRegistrationImpl$AdapterCollector coreServiceAdapterRegistrationImpl$AdapterCollector = (CoreServiceAdapterRegistrationImpl$AdapterCollector)iterator2.next();
                    if (!coreServiceAdapterRegistrationImpl$AdapterCollector.getAdapter().isFuntionSupported(n)) continue;
                    coreServiceAdapterArray[n3] = coreServiceAdapterRegistrationImpl$AdapterCollector.getAdapter();
                    ++n3;
                }
                return coreServiceAdapterArray;
            }
        }
        return null;
    }
}

