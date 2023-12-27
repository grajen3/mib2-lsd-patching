/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.target;

import de.vw.mib.asl.api.bap.observer.BAPObserverRegistry;
import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.asl.internal.ocu.common.HsmContextDelegate;
import de.vw.mib.asl.internal.ocu.common.functions.BAPOcuFunctionController;
import de.vw.mib.asl.internal.ocu.common.functions.BAPOcuFunctionControllerDelegate;
import de.vw.mib.asl.internal.ocu.eni.functions.ActiveMonitorings;
import de.vw.mib.asl.internal.ocu.eni.functions.ActiveTrip;
import de.vw.mib.asl.internal.ocu.eni.functions.AlertList;
import de.vw.mib.asl.internal.ocu.eni.functions.BAPConfig;
import de.vw.mib.asl.internal.ocu.eni.functions.ChallengeData;
import de.vw.mib.asl.internal.ocu.eni.functions.ConnectionState;
import de.vw.mib.asl.internal.ocu.eni.functions.CurrentOnlineUpdateState;
import de.vw.mib.asl.internal.ocu.eni.functions.DestinationList;
import de.vw.mib.asl.internal.ocu.eni.functions.DestinationListAsgCapacity;
import de.vw.mib.asl.internal.ocu.eni.functions.FSGControl;
import de.vw.mib.asl.internal.ocu.eni.functions.FSGOperationState;
import de.vw.mib.asl.internal.ocu.eni.functions.FSGSetup;
import de.vw.mib.asl.internal.ocu.eni.functions.FoDList;
import de.vw.mib.asl.internal.ocu.eni.functions.FoDState;
import de.vw.mib.asl.internal.ocu.eni.functions.FunctionList;
import de.vw.mib.asl.internal.ocu.eni.functions.MobileDeviceKeyCount;
import de.vw.mib.asl.internal.ocu.eni.functions.OLBSettings;
import de.vw.mib.asl.internal.ocu.eni.functions.OLBTripList;
import de.vw.mib.asl.internal.ocu.eni.functions.OnlineUpdateList;
import de.vw.mib.asl.internal.ocu.eni.functions.PrivacySetup;
import de.vw.mib.asl.internal.ocu.eni.functions.RemoteProcessCommands;
import de.vw.mib.asl.internal.ocu.eni.functions.RemoteProcessState;
import de.vw.mib.asl.internal.ocu.eni.functions.ServiceList;
import de.vw.mib.asl.internal.ocu.eni.functions.TriggerRemoteProcess;
import de.vw.mib.asl.internal.ocu.eni.functions.UserList;
import de.vw.mib.asl.internal.ocu.eni.functions.VTANDataEncrypted;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPConfigVersionCheck;
import de.vw.mib.bap.functions.BAPFunctionController;
import de.vw.mib.bap.functions.BAPFunctionList;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.BAPOperationState;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.marshalling.BAPFunctionListenerRegistry;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.Iterator;

class ENIFunctionListenerRegistry
implements BAPFunctionListenerRegistry,
BAPOcuFunctionControllerDelegate,
BAPObserverRegistry {
    private final HsmContextDelegate _contextDelegate;
    private static final int FUNCTION_LISTENER_MIN_CAPACITY;
    private IntObjectOptHashMap _functionListener;
    private boolean _finallyInitialized;
    private boolean _initialized;
    static /* synthetic */ Class class$de$vw$mib$log4mib$Logger;

    public ENIFunctionListenerRegistry(HsmContextDelegate hsmContextDelegate) {
        this._contextDelegate = hsmContextDelegate;
    }

    private IntObjectOptHashMap getFunctionListener() {
        if (this._functionListener == null) {
            this._functionListener = new IntObjectOptHashMap(10);
        }
        return this._functionListener;
    }

    private HsmContextDelegate getContextDelegate() {
        return this._contextDelegate;
    }

    private boolean isFinallyInitialized() {
        return this._finallyInitialized;
    }

    private void setFinallyInitialized() {
        this._finallyInitialized = true;
    }

    private void addFunction(IntObjectOptHashMap intObjectOptHashMap, BAPOcuFunctionController bAPOcuFunctionController) {
        intObjectOptHashMap.put(bAPOcuFunctionController.getFunctionId(), bAPOcuFunctionController);
        bAPOcuFunctionController.setDelegate(this);
    }

    public void initialize() {
        IntObjectOptHashMap intObjectOptHashMap = this.getFunctionListener();
        this.addFunction(intObjectOptHashMap, new BAPConfig());
        this.addFunction(intObjectOptHashMap, new FunctionList());
        this.addFunction(intObjectOptHashMap, new FSGControl());
        this.addFunction(intObjectOptHashMap, new FSGSetup());
        this.addFunction(intObjectOptHashMap, new FSGOperationState());
        this.addFunction(intObjectOptHashMap, new DestinationList());
        this.addFunction(intObjectOptHashMap, new DestinationListAsgCapacity());
        this.addFunction(intObjectOptHashMap, new TriggerRemoteProcess());
        this.addFunction(intObjectOptHashMap, new RemoteProcessCommands());
        this.addFunction(intObjectOptHashMap, new RemoteProcessState());
        this.addFunction(intObjectOptHashMap, new UserList());
        this.addFunction(intObjectOptHashMap, new ServiceList());
        this.addFunction(intObjectOptHashMap, new ActiveMonitorings());
        this.addFunction(intObjectOptHashMap, new PrivacySetup());
        this.addFunction(intObjectOptHashMap, new CurrentOnlineUpdateState());
        this.addFunction(intObjectOptHashMap, new OnlineUpdateList());
        this.addFunction(intObjectOptHashMap, new ChallengeData());
        this.addFunction(intObjectOptHashMap, new AlertList());
        this.addFunction(intObjectOptHashMap, new MobileDeviceKeyCount());
        this.addFunction(intObjectOptHashMap, new VTANDataEncrypted());
        this.addFunction(intObjectOptHashMap, new ConnectionState());
        this.addFunction(intObjectOptHashMap, new FoDList());
        this.addFunction(intObjectOptHashMap, new FoDState());
        this.addFunction(intObjectOptHashMap, new ActiveTrip());
        this.addFunction(intObjectOptHashMap, new OLBSettings());
        this.addFunction(intObjectOptHashMap, new OLBTripList());
    }

    private void _inititialize(boolean bl) {
        IntObjectOptHashMap intObjectOptHashMap = this.getFunctionListener();
        Iterator iterator = intObjectOptHashMap.values().iterator();
        BAPFunctionList bAPFunctionList = this.getFunctionList();
        while (iterator.hasNext()) {
            BAPFunctionController bAPFunctionController = (BAPFunctionController)iterator.next();
            if (!bAPFunctionList.containsFunction(bAPFunctionController.getFunctionId())) continue;
            bAPFunctionController.initialize(bl);
        }
    }

    public void reinitialize() {
        if (!this.isFinallyInitialized()) {
            this.setFinallyInitialized();
            this._inititialize(false);
        }
        this._initialized = true;
        this._inititialize(true);
    }

    public void uninitialize() {
        IntObjectOptHashMap intObjectOptHashMap = this.getFunctionListener();
        Iterator iterator = intObjectOptHashMap.values().iterator();
        this._initialized = false;
        while (iterator.hasNext()) {
            BAPFunctionController bAPFunctionController = (BAPFunctionController)iterator.next();
            bAPFunctionController.uninitialize();
        }
    }

    @Override
    public BAPFunctionListener getBAPFunctionListener(int n) {
        return (BAPFunctionListener)this.getFunctionListener().get(n);
    }

    @Override
    public ArrayListener getArrayListener(int n) {
        return (ArrayListener)this.getFunctionListener().get(n);
    }

    @Override
    public MethodListener getMethodListener(int n) {
        return (MethodListener)this.getFunctionListener().get(n);
    }

    @Override
    public PropertyListener getPropertyListener(int n) {
        return (PropertyListener)this.getFunctionListener().get(n);
    }

    @Override
    public BAPFunctionController getFunctionController(int n) {
        return (BAPFunctionController)this.getFunctionListener().get(n);
    }

    @Override
    public BAPConfigVersionCheck getBapConfigVersionCheckFunction() {
        return (BAPConfigVersionCheck)((Object)this.getBAPFunctionListener(2));
    }

    @Override
    public BAPFunctionList getFunctionList() {
        return (BAPFunctionList)((Object)this.getBAPFunctionListener(3));
    }

    @Override
    public BAPOperationState getOperationState() {
        return (BAPOperationState)((Object)this.getBAPFunctionListener(15));
    }

    @Override
    public Array getArray(BAPFunctionController bAPFunctionController) {
        return this.getContextDelegate().getLogicalControlUnit().getFunctionRegistry().getArray(bAPFunctionController.getFunctionId());
    }

    @Override
    public Method getMethod(BAPFunctionController bAPFunctionController) {
        return this.getContextDelegate().getLogicalControlUnit().getFunctionRegistry().getMethod(bAPFunctionController.getFunctionId());
    }

    @Override
    public Property getProperty(BAPFunctionController bAPFunctionController) {
        return this.getContextDelegate().getLogicalControlUnit().getFunctionRegistry().getProperty(bAPFunctionController.getFunctionId());
    }

    @Override
    public void registerServiceListener(BAPFunctionController bAPFunctionController, Class clazz, int[] nArray) {
        this.getContextDelegate().getOCUServiceProxy().registerServiceListener(clazz, nArray);
        this.getContextDelegate().registerServiceReceiver(bAPFunctionController, clazz, nArray);
    }

    @Override
    public void unregisterServiceListener(BAPFunctionController bAPFunctionController, Class clazz, int[] nArray) {
        this.getContextDelegate().getOCUServiceProxy().unregisterServiceListener(clazz, nArray);
        this.getContextDelegate().unregisterServiceReceiver(bAPFunctionController, clazz, nArray);
    }

    @Override
    public void registerServiceProvider(BAPFunctionController bAPFunctionController, Class clazz, int[] nArray) {
        this.getContextDelegate().getOCUServiceProxy().registerServiceListener(clazz, nArray);
        this.getContextDelegate().registerServiceProvider(bAPFunctionController, clazz, nArray);
    }

    @Override
    public void unRegisterServiceProvider(BAPFunctionController bAPFunctionController, Class clazz, int[] nArray) {
        this.getContextDelegate().getOCUServiceProxy().unregisterServiceListener(clazz, nArray);
        this.getContextDelegate().unRegisterServiceProvider(bAPFunctionController, clazz, nArray);
    }

    @Override
    public void registerServiceProviderListener(BAPFunctionController bAPFunctionController, Class clazz, int[] nArray) {
        this.getContextDelegate().getOCUServiceProxy().registerServiceListener(clazz, nArray);
        this.getContextDelegate().registerServiceProviderListener(bAPFunctionController, clazz, nArray);
    }

    @Override
    public void unRegisterServiceProviderListener(BAPFunctionController bAPFunctionController, Class clazz, int[] nArray) {
        this.getContextDelegate().getOCUServiceProxy().unregisterServiceListener(clazz, nArray);
        this.getContextDelegate().unRegisterServiceProviderListener(bAPFunctionController, clazz, nArray);
    }

    @Override
    public Object getService(Class clazz) {
        Object object = clazz == (class$de$vw$mib$log4mib$Logger == null ? (class$de$vw$mib$log4mib$Logger = ENIFunctionListenerRegistry.class$("de.vw.mib.log4mib.Logger")) : class$de$vw$mib$log4mib$Logger) ? this.getContextDelegate().getLogger() : this.getContextDelegate().getOCUServiceProxy().getService(clazz);
        return object;
    }

    @Override
    public boolean isInitialized(BAPFunctionController bAPFunctionController) {
        return this._initialized && this.isFinallyInitialized();
    }

    @Override
    public BAPValueObserverable getBapValueObservable(int n) {
        return (BAPValueObserverable)this.getFunctionListener().get(n);
    }

    @Override
    public void flushAllBapValueObserverables() {
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

