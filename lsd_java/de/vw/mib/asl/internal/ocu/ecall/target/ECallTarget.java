/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.target;

import de.vw.mib.asl.api.ocu.ecall.ECallServiceProvider;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.ocu.common.api.BAPDisplayControlUnit;
import de.vw.mib.asl.internal.ocu.common.api.OCUService;
import de.vw.mib.asl.internal.ocu.common.api.OcuServiceProxy;
import de.vw.mib.asl.internal.ocu.ecall.states.ECallHsmContext;
import de.vw.mib.asl.internal.ocu.ecall.states.ECallHsmContextDelegate;
import de.vw.mib.asl.internal.ocu.ecall.target.ECallControlUnit;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.List;

public class ECallTarget
extends AbstractASLHsmTarget
implements ECallHsmContextDelegate {
    private ECallHsmContext _hsmContext;
    private BAPDisplayControlUnit _displayLogicalControlUnit;
    private ObjectObjectOptHashMap _serviceReceiverRegistry;

    public ECallTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    private ECallHsmContext getHsmContext() {
        if (this._hsmContext == null) {
            this._hsmContext = new ECallHsmContext(this.getHsm(), this.getWorkStateParent());
            this._hsmContext.setDelegate(this);
        }
        return this._hsmContext;
    }

    private ObjectObjectOptHashMap getServiceReceiverRegistry() {
        if (this._serviceReceiverRegistry == null) {
            this._serviceReceiverRegistry = new ObjectObjectOptHashMap();
        }
        return this._serviceReceiverRegistry;
    }

    private void _registerService(Object object, Class clazz) {
        ObjectObjectOptHashMap objectObjectOptHashMap = this.getServiceReceiverRegistry();
        ArrayList arrayList = (ArrayList)objectObjectOptHashMap.get(clazz);
        if (arrayList == null) {
            arrayList = new ArrayList();
            objectObjectOptHashMap.put(clazz, arrayList);
        }
        arrayList.add(object);
    }

    private void _unregisterService(Object object, Class clazz) {
        ObjectObjectOptHashMap objectObjectOptHashMap = this.getServiceReceiverRegistry();
        ArrayList arrayList = (ArrayList)objectObjectOptHashMap.get(clazz);
        if (arrayList != null) {
            arrayList.remove(object);
        }
    }

    @Override
    public int getClassifier() {
        return 2;
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.getHsmContext().getStartState();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Event received: ").append(eventGeneric.getReceiverEventId()).append(" arguments: ").append(eventGeneric.getParamString()).log();
        }
        super.gotEvent(eventGeneric);
    }

    @Override
    public Logger getLogger() {
        return this.getTextLogger();
    }

    @Override
    public BAPDisplayControlUnit getLogicalControlUnit() {
        if (this._displayLogicalControlUnit == null) {
            this._displayLogicalControlUnit = new ECallControlUnit(this);
        }
        return this._displayLogicalControlUnit;
    }

    @Override
    public OcuServiceProxy getOCUServiceProxy() {
        return (OcuServiceProxy)((Object)ECallServiceProvider.getECallService(ECallServiceProvider.ECALL_SERVICE_VERSION_1_0));
    }

    @Override
    public OCUService getOCUService() {
        return (OCUService)((Object)ECallServiceProvider.getECallService(ECallServiceProvider.ECALL_SERVICE_VERSION_1_0));
    }

    @Override
    public void registerObservers() {
    }

    @Override
    public void registerServiceReceiver(Object object, Class clazz, int[] nArray) {
        this._registerService(object, clazz);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = nArray[i2];
            if (n2 <= -193 || n2 >= -129 || this.getServiceRegister().existService(n2)) continue;
            this.registerService(n2);
        }
        this.addObservers(nArray);
    }

    @Override
    public void unregisterServiceReceiver(Object object, Class clazz, int[] nArray) {
        this._unregisterService(object, clazz);
        this.removeObservers(nArray);
    }

    @Override
    public void registerServiceProvider(Object object, Class clazz, int[] nArray) {
        this._registerService(object, clazz);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.registerService(nArray[i2], true);
        }
    }

    @Override
    public void unRegisterServiceProvider(Object object, Class clazz, int[] nArray) {
        this._unregisterService(object, clazz);
        this.getServiceRegister().unregisterServices(nArray);
    }

    @Override
    public void registerServiceProviderListener(Object object, Class clazz, int[] nArray) {
        this._registerService(object, clazz);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.getServiceRegister().addServiceMonitor(nArray[i2], 0, this.getTargetId());
        }
    }

    @Override
    public void unRegisterServiceProviderListener(Object object, Class clazz, int[] nArray) {
        this._unregisterService(object, clazz);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.getServiceRegister().removeServiceMonitor(nArray[i2], 0, this.getTargetId());
        }
    }

    @Override
    public List getRegisteredServiceListeners(Class clazz) {
        return (List)this.getServiceReceiverRegistry().get(clazz);
    }
}

