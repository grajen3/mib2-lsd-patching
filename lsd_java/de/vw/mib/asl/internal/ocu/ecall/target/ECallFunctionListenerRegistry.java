/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.target;

import de.vw.mib.asl.api.bap.observer.BAPObserverRegistry;
import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.asl.internal.ocu.common.HsmContextDelegate;
import de.vw.mib.asl.internal.ocu.common.functions.BAPOcuFunctionController;
import de.vw.mib.asl.internal.ocu.common.functions.BAPOcuFunctionControllerDelegate;
import de.vw.mib.asl.internal.ocu.ecall.functions.AcceptCall;
import de.vw.mib.asl.internal.ocu.ecall.functions.AudioState;
import de.vw.mib.asl.internal.ocu.ecall.functions.BAPConfig;
import de.vw.mib.asl.internal.ocu.ecall.functions.CallState;
import de.vw.mib.asl.internal.ocu.ecall.functions.DisconnectReason;
import de.vw.mib.asl.internal.ocu.ecall.functions.FSGControl;
import de.vw.mib.asl.internal.ocu.ecall.functions.FSGOperationState;
import de.vw.mib.asl.internal.ocu.ecall.functions.FSGSetup;
import de.vw.mib.asl.internal.ocu.ecall.functions.FunctionList;
import de.vw.mib.asl.internal.ocu.ecall.functions.HangupCall;
import de.vw.mib.asl.internal.ocu.ecall.functions.NetworkProvider;
import de.vw.mib.asl.internal.ocu.ecall.functions.RegisterState;
import de.vw.mib.asl.internal.ocu.ecall.functions.ServiceControl;
import de.vw.mib.asl.internal.ocu.ecall.functions.ServiceRequest;
import de.vw.mib.asl.internal.ocu.ecall.functions.ServiceState;
import de.vw.mib.asl.internal.ocu.ecall.functions.SignalQuality;
import de.vw.mib.asl.internal.ocu.ecall.functions.SupportedServices;
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

class ECallFunctionListenerRegistry
implements BAPFunctionListenerRegistry,
BAPOcuFunctionControllerDelegate,
BAPObserverRegistry {
    private final HsmContextDelegate _contextDelegate;
    private static final int FUNCTION_LISTENER_MIN_CAPACITY;
    private IntObjectOptHashMap _functionListener;
    private boolean _initialized;
    static /* synthetic */ Class class$de$vw$mib$log4mib$Logger;

    public ECallFunctionListenerRegistry(HsmContextDelegate hsmContextDelegate) {
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

    private boolean isInitialized() {
        return this._initialized;
    }

    private void setInitialized() {
        this._initialized = true;
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
        this.addFunction(intObjectOptHashMap, new AudioState());
        this.addFunction(intObjectOptHashMap, new CallState());
        this.addFunction(intObjectOptHashMap, new HangupCall());
        this.addFunction(intObjectOptHashMap, new AcceptCall());
        this.addFunction(intObjectOptHashMap, new DisconnectReason());
        this.addFunction(intObjectOptHashMap, new RegisterState());
        this.addFunction(intObjectOptHashMap, new NetworkProvider());
        this.addFunction(intObjectOptHashMap, new SignalQuality());
        this.addFunction(intObjectOptHashMap, new ServiceRequest());
        this.addFunction(intObjectOptHashMap, new ServiceControl());
        this.addFunction(intObjectOptHashMap, new ServiceState());
        this.addFunction(intObjectOptHashMap, new SupportedServices());
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
        if (!this.isInitialized()) {
            this.setInitialized();
            this._inititialize(false);
        }
        this._inititialize(true);
    }

    public void uninitialize() {
        IntObjectOptHashMap intObjectOptHashMap = this.getFunctionListener();
        Iterator iterator = intObjectOptHashMap.values().iterator();
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
        Object object = clazz == (class$de$vw$mib$log4mib$Logger == null ? (class$de$vw$mib$log4mib$Logger = ECallFunctionListenerRegistry.class$("de.vw.mib.log4mib.Logger")) : class$de$vw$mib$log4mib$Logger) ? this.getContextDelegate().getLogger() : this.getContextDelegate().getOCUServiceProxy().getService(clazz);
        return object;
    }

    @Override
    public BAPValueObserverable getBapValueObservable(int n) {
        return (BAPValueObserverable)this.getFunctionListener().get(n);
    }

    @Override
    public void flushAllBapValueObserverables() {
    }

    @Override
    public boolean isInitialized(BAPFunctionController bAPFunctionController) {
        return false;
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

