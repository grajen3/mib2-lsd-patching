/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.adapter;

import de.vw.mib.asl.api.bap.observer.BAPObserverRegistry;
import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.asl.api.bap.timer.Timer;
import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPConfigVersionCheck;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.BAPFunctionController;
import de.vw.mib.bap.functions.BAPFunctionList;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.BAPOperationState;
import de.vw.mib.bap.functions.FSGOperationState;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.marshalling.BAPFunctionListenerRegistry;
import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPIndicationMarshaller;
import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.common.HsmContextDelegate;
import de.vw.mib.bap.mqbpq.common.api.adapter.AbstractBAPDataPool$AllFunctions;
import de.vw.mib.bap.mqbpq.common.api.adapter.AbstractBAPDataPool$SendbufferFunctionRegistryListenerAdapter;
import de.vw.mib.bap.mqbpq.common.api.adapter.BAPDataPoolValueAdapter;
import de.vw.mib.bap.mqbpq.common.api.adapter.BAPValueObserverableAdapter;
import de.vw.mib.bap.mqbpq.common.api.adapter.LanguageUtil;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.BooleanIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.IntegerIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.LongIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.StringIterator;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageObserver;
import de.vw.mib.bap.mqbpq.common.marshalling.FunctionRegistryListenerAdapter;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractBAPDataPool
implements BAPStageInitializer,
BAPStageContext,
BAPObserverRegistry,
BAPFunctionRegistry,
BAPFunctionListenerRegistry {
    private final HsmContextDelegate _hsmContextDelegate;
    private IntObjectOptHashMap dataPool;
    private IntObjectOptHashMap bapStages;
    private ArrayList bapStageObservers;
    private IntObjectOptHashMap _bapPropertyObservers;
    private static final int INTIAL_MAP_SIZE;
    private FunctionRegistryListenerAdapter _cachedTransmissionfunctionRegistryListenerAdapter;
    private FunctionRegistryListenerAdapter _functionRegistryListenerAdapter;

    public AbstractBAPDataPool(HsmContextDelegate hsmContextDelegate) {
        this._hsmContextDelegate = hsmContextDelegate;
        this.dataPool = new IntObjectOptHashMap(32);
        this.bapStages = new IntObjectOptHashMap(32);
        this.bapStageObservers = new ArrayList(32);
    }

    private HsmContextDelegate getContextDelegate() {
        return this._hsmContextDelegate;
    }

    @Override
    public void observeAslPropertiesAndLists(BAPStage bAPStage, int[] nArray, int[] nArray2, int n) {
        BAPStageObserver bAPStageObserver = new BAPStageObserver(bAPStage, this.getLogicalControlUnitID(), n);
        if (nArray != null) {
            bAPStageObserver.registerProperties(nArray);
        }
        if (nArray2 != null) {
            bAPStageObserver.registerListItemControls(nArray2);
        }
        this.bapStageObservers.add(bAPStageObserver);
    }

    @Override
    public void observeHMIEvents(BAPStage bAPStage, int[] nArray) {
        ServiceManager.serviceManager.bapDispatcher.observeHMIEvents(this.getLogicalControlUnitID(), bAPStage.getFunctionId(), nArray);
    }

    @Override
    public void registerForPersistenceAvailability(BAPStage bAPStage) {
        ServiceManager.serviceManager.bapDispatcher.registerForPersistenceAvailability(this.getLogicalControlUnitID(), bAPStage.getFunctionId());
    }

    @Override
    public Timer createTimer(BAPStage bAPStage, TimerNotifier timerNotifier, long l, int n) {
        return ServiceManager.serviceManager.bapDispatcher.createTimer(timerNotifier, this.getLogicalControlUnitID(), bAPStage.getFunctionId(), n, l);
    }

    @Override
    public LanguageUtil createLanguageUtil(BAPStage bAPStage) {
        return new LanguageUtil(bAPStage, this.getLogicalControlUnitID());
    }

    static boolean updateValueAdapterWithNewValue(BAPDataPoolValueAdapter bAPDataPoolValueAdapter, BAPEntity bAPEntity, boolean bl) {
        boolean bl2;
        BAPEntity bAPEntity2 = bAPDataPoolValueAdapter.getLastValidValue();
        if (!bl && bAPDataPoolValueAdapter.getFctType() == 1 && (bAPEntity2 == bAPEntity || bAPEntity2 != null && bAPEntity2.equalTo(bAPEntity))) {
            if (bAPDataPoolValueAdapter.getQueuedValue() == null && bAPEntity2 != bAPEntity) {
                bAPDataPoolValueAdapter.setQueuedValue(bAPEntity);
            }
            bl2 = false;
        } else {
            bAPDataPoolValueAdapter.setCurrentValue(bAPEntity);
            bl2 = true;
        }
        return bl2;
    }

    public final void bapValueTransmitted(int n) {
        BAPDataPoolValueAdapter bAPDataPoolValueAdapter = this.get(n);
        if (bAPDataPoolValueAdapter != null && bAPDataPoolValueAdapter.getFctType() == 1) {
            BAPEntity bAPEntity = bAPDataPoolValueAdapter.getLastValidValue();
            BAPValueObserverableAdapter bAPValueObserverableAdapter = (BAPValueObserverableAdapter)this.getBapPropertyObservers().get(bAPDataPoolValueAdapter.getFctID());
            if (bAPValueObserverableAdapter != null && bAPEntity != null) {
                bAPValueObserverableAdapter.didChangeValue(bAPEntity, bAPDataPoolValueAdapter.getQueuedValue());
            }
        }
    }

    @Override
    public final void updateStages(BAPStage bAPStage, int[] nArray, Object object) {
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            BAPStage bAPStage2 = this.getStage(nArray[i2]);
            bAPStage2.setFunctionData(bAPStage, object);
        }
    }

    @Override
    public BAPEntity dequeueBAPEntity(BAPStage bAPStage, Class clazz) {
        BAPDataPoolValueAdapter bAPDataPoolValueAdapter = (BAPDataPoolValueAdapter)this.dataPool.get(bAPStage.getFunctionId());
        BAPEntity bAPEntity = bAPDataPoolValueAdapter.getQueuedValue();
        if (bAPEntity == null) {
            try {
                bAPEntity = (BAPEntity)clazz.newInstance();
            }
            catch (Exception exception) {
                this.logError(exception, "Exception during creating a instance of BAP entity.");
            }
        } else {
            bAPEntity.reset();
        }
        return bAPEntity;
    }

    @Override
    public boolean getBoolean(int n, boolean bl) {
        return ServiceManager.serviceManager.dataPool.getBoolean(n, bl);
    }

    @Override
    public int getInteger(int n, int n2) {
        return ServiceManager.serviceManager.dataPool.getInteger(n, n2);
    }

    @Override
    public String getString(int n, String string) {
        return ServiceManager.serviceManager.dataPool.getString(n, string);
    }

    @Override
    public LongIterator getLongListIterator(int n, int n2) {
        return new LongIterator(n, n2);
    }

    @Override
    public IntegerIterator getIntegerListIterator(int n, int n2) {
        return new IntegerIterator(n, n2);
    }

    @Override
    public BooleanIterator getBooleanListIterator(int n, int n2) {
        return new BooleanIterator(n, n2);
    }

    @Override
    public StringIterator getStringListIterator(int n, int n2) {
        return new StringIterator(n, n2);
    }

    @Override
    public long getLongListValue(int n, int n2) {
        return LongIterator.getValue(n, n2);
    }

    @Override
    public int getIntegerListValue(int n, int n2) {
        return IntegerIterator.getValue(n, n2);
    }

    @Override
    public boolean getBooleanListValue(int n, int n2) {
        return BooleanIterator.getValue(n, n2);
    }

    @Override
    public String getStringListValue(int n, int n2) {
        return StringIterator.getValue(n, n2);
    }

    @Override
    public int getLogicalControlUnitID() {
        return this.getContextDelegate().getLogicalControlUnit().getLogicalControlUnitID();
    }

    public final void requestValidValues() {
        ServiceManager.serviceManager.bapDispatcher.informThatAllBapDatapoolValuesAreValid(this.getLogicalControlUnitID());
    }

    protected void addStage(BAPStage bAPStage, int n, int n2, String string) {
        if (bAPStage != null) {
            bAPStage.setDelegate(this);
            int n3 = bAPStage.getFunctionId();
            this.bapStages.put(n3, bAPStage);
            this.dataPool.put(n3, new BAPDataPoolValueAdapter(n3, n, n2, string));
        }
    }

    protected final void logError(String string) {
        ServiceManager.serviceManager.logger.error(4, string);
    }

    protected final void logError(Throwable throwable, String string) {
        ServiceManager.serviceManager.logger.error(4).append(string).attachThrowable(throwable).log();
    }

    public void initialize() {
        Iterator iterator = this.dataPoolIterator();
        try {
            while (iterator.hasNext()) {
                BAPDataPoolValueAdapter bAPDataPoolValueAdapter = (BAPDataPoolValueAdapter)iterator.next();
                BAPStage bAPStage = this.getStage(bAPDataPoolValueAdapter.getFctID());
                BAPEntity bAPEntity = bAPStage.init(this);
                if (bAPEntity == null) continue;
                bAPDataPoolValueAdapter.setInitData(bAPDataPoolValueAdapter.nativeDataValue(bAPEntity));
            }
        }
        catch (Exception exception) {
            this.logError(exception, "Exception during initialization of bindings.");
        }
    }

    public void reinitialize() {
        Iterator iterator = this.stagesIterator();
        while (iterator.hasNext()) {
            BAPStage bAPStage = (BAPStage)iterator.next();
            bAPStage.initialize(true);
        }
    }

    public void uninitialize() {
        Object object;
        Iterator iterator = this.stagesIterator();
        while (iterator.hasNext()) {
            object = (BAPStage)iterator.next();
            object.uninitialize();
        }
        iterator = this.bapStageObservers.iterator();
        while (iterator.hasNext()) {
            object = (BAPStageObserver)iterator.next();
            ((BAPStageObserver)object).unregister();
        }
        this.bapStages.clear();
        this.dataPool.clear();
        this.bapStageObservers.clear();
        ServiceManager.serviceManager.bapDispatcher.uninitialize(this.getLogicalControlUnitID());
    }

    private void initializeBAPFunction(Object object, BAPDataPoolValueAdapter bAPDataPoolValueAdapter) {
        if (object != null) {
            if (bAPDataPoolValueAdapter.getFctType() == 2) {
                this.getContextDelegate().getLogicalControlUnit().getService().requestByteSequence(this.getContextDelegate().getLogicalControlUnit().getLogicalControlUnitID(), bAPDataPoolValueAdapter.getFctID(), 10, (byte[])object);
            } else if (bAPDataPoolValueAdapter.getDataType() == 3) {
                this.getContextDelegate().getLogicalControlUnit().getService().requestByteSequence(this.getContextDelegate().getLogicalControlUnit().getLogicalControlUnitID(), bAPDataPoolValueAdapter.getFctID(), 7, (byte[])object);
            } else {
                this.getContextDelegate().getLogicalControlUnit().getService().request(this.getContextDelegate().getLogicalControlUnit().getLogicalControlUnitID(), bAPDataPoolValueAdapter.getFctID(), bAPDataPoolValueAdapter.getDataType(), 7, (Integer)object);
            }
        }
    }

    public final boolean initializeFunctionList() {
        boolean bl;
        BAPDataPoolValueAdapter bAPDataPoolValueAdapter = this.get(3);
        Object object = this.computeNativeInitializerData(bAPDataPoolValueAdapter, false);
        boolean bl2 = bl = object != null;
        if (bl) {
            this.initializeBAPFunction(object, bAPDataPoolValueAdapter);
        }
        return bl;
    }

    public final void clearFunctionListInitializerData() {
        BAPDataPoolValueAdapter bAPDataPoolValueAdapter = this.get(3);
        bAPDataPoolValueAdapter.clearInitializer();
    }

    private Object computeNativeInitializerData(BAPDataPoolValueAdapter bAPDataPoolValueAdapter, boolean bl) {
        Object object;
        if (bAPDataPoolValueAdapter.getFctType() == 2) {
            object = bAPDataPoolValueAdapter.getInitData();
        } else {
            BAPEntity bAPEntity = bAPDataPoolValueAdapter.getValueToTransmit();
            if (bAPEntity != null) {
                object = bAPDataPoolValueAdapter.nativeDataValue(bAPEntity);
            } else if (!bl) {
                object = bAPDataPoolValueAdapter.getInitData();
                if (object == null && this.getContextDelegate().getLogger().isTraceEnabled(this.getContextDelegate().getSubClassifier())) {
                    this.getContextDelegate().getLogger().trace(this.getContextDelegate().getSubClassifier()).append(bAPDataPoolValueAdapter.getValueName()).append(" is not initialized").log();
                }
            } else {
                object = null;
            }
        }
        return object;
    }

    public final void initializeSendbuffers(boolean bl) {
        Iterator iterator = this.dataPoolIterator();
        while (iterator.hasNext()) {
            BAPDataPoolValueAdapter bAPDataPoolValueAdapter = (BAPDataPoolValueAdapter)iterator.next();
            Object object = this.computeNativeInitializerData(bAPDataPoolValueAdapter, bl);
            this.initializeBAPFunction(object, bAPDataPoolValueAdapter);
        }
    }

    public final void clearNativeInitializer() {
        Iterator iterator = this.dataPoolIterator();
        while (iterator.hasNext()) {
            BAPDataPoolValueAdapter bAPDataPoolValueAdapter = (BAPDataPoolValueAdapter)iterator.next();
            if (bAPDataPoolValueAdapter.getFctType() == 2) continue;
            bAPDataPoolValueAdapter.clearInitializer();
        }
    }

    public final void flushAllInitializerData() {
        this.clearFunctionListInitializerData();
        this.initializeSendbuffers(false);
        this.clearNativeInitializer();
    }

    public final BAPDataPoolValueAdapter get(int n) {
        return (BAPDataPoolValueAdapter)this.dataPool.get(n);
    }

    public final Iterator dataPoolIterator() {
        return this.dataPool.values().iterator();
    }

    public final Iterator stagesIterator() {
        return this.bapStages.values().iterator();
    }

    public final BAPStage getStage(int n) {
        return (BAPStage)this.bapStages.get(n);
    }

    public final BAPFunction getFunction(int n) {
        return (BAPFunction)this.bapStages.get(n);
    }

    private IntObjectOptHashMap getBapPropertyObservers() {
        if (this._bapPropertyObservers == null) {
            this._bapPropertyObservers = new IntObjectOptHashMap(32);
        }
        return this._bapPropertyObservers;
    }

    @Override
    public BAPValueObserverable getBapValueObservable(int n) {
        BAPValueObserverableAdapter bAPValueObserverableAdapter = (BAPValueObserverableAdapter)this.getBapPropertyObservers().get(n);
        if (bAPValueObserverableAdapter == null) {
            bAPValueObserverableAdapter = new BAPValueObserverableAdapter();
            this.getBapPropertyObservers().put(n, bAPValueObserverableAdapter);
        }
        return bAPValueObserverableAdapter;
    }

    @Override
    public void flushAllBapValueObserverables() {
        IntIterator intIterator = this.getBapPropertyObservers().keyIterator();
        while (intIterator.hasNext()) {
            this.bapValueTransmitted(intIterator.next());
        }
    }

    private FunctionRegistryListenerAdapter getCachedTransmissionRegistryListenerAdapter() {
        if (this._cachedTransmissionfunctionRegistryListenerAdapter == null) {
            this._cachedTransmissionfunctionRegistryListenerAdapter = new AbstractBAPDataPool$SendbufferFunctionRegistryListenerAdapter(this, this.getLogicalControlUnitID(), ServiceManager.serviceManager.bapDispatcher, true);
        }
        return this._cachedTransmissionfunctionRegistryListenerAdapter;
    }

    private FunctionRegistryListenerAdapter getFunctionRegistryListenerAdapter() {
        if (this._functionRegistryListenerAdapter == null) {
            this._functionRegistryListenerAdapter = new AbstractBAPDataPool$SendbufferFunctionRegistryListenerAdapter(this, this.getLogicalControlUnitID(), ServiceManager.serviceManager.bapDispatcher, false);
        }
        return this._functionRegistryListenerAdapter;
    }

    public boolean transmitDataToMarshaller(BAPIndicationMarshaller bAPIndicationMarshaller, int n, int n2, Object object) {
        boolean bl;
        BAPDataPoolValueAdapter bAPDataPoolValueAdapter;
        BAPEntity bAPEntity;
        Object object2 = FunctionRegistryListenerAdapter.isReportOperationCode(n2) ? ((bAPEntity = (bAPDataPoolValueAdapter = this.get(n)).getValueToTransmit()) != null ? bAPEntity : null) : object;
        if (object2 != null) {
            bl = FunctionRegistryListenerAdapter.demarshallTransmitData(bAPIndicationMarshaller, n, n2, object2);
            if (bl) {
                this.bapValueTransmitted(n);
            }
        } else {
            bl = object != null;
        }
        return bl;
    }

    public boolean restoreLastValidValue(int n) {
        boolean bl;
        BAPDataPoolValueAdapter bAPDataPoolValueAdapter = this.get(n);
        if (bAPDataPoolValueAdapter != null) {
            bAPDataPoolValueAdapter.restoreLastValue();
            bl = true;
        } else {
            bl = false;
        }
        return bl;
    }

    @Override
    public ArrayListener getArrayListener(BAPFunctionController bAPFunctionController) {
        return this.getCachedTransmissionRegistryListenerAdapter().getFunctionRegistryListenerAdapter(bAPFunctionController.getFunctionId());
    }

    @Override
    public MethodListener getMethodListener(BAPFunctionController bAPFunctionController) {
        return this.getCachedTransmissionRegistryListenerAdapter().getFunctionRegistryListenerAdapter(bAPFunctionController.getFunctionId());
    }

    @Override
    public PropertyListener getPropertyListener(BAPFunctionController bAPFunctionController) {
        return this.getCachedTransmissionRegistryListenerAdapter().getFunctionRegistryListenerAdapter(bAPFunctionController.getFunctionId());
    }

    @Override
    public BAPFunction getBAPFunction(int n) {
        BAPFunction bAPFunction = (BAPFunction)this.bapStages.get(n);
        if (bAPFunction == null) {
            bAPFunction = new AbstractBAPDataPool$AllFunctions(n, this.getContextDelegate());
        }
        return bAPFunction;
    }

    @Override
    public final Property getProperty(int n) {
        return (Property)this.getBAPFunction(n);
    }

    @Override
    public final Method getMethod(int n) {
        return (Method)this.getBAPFunction(n);
    }

    @Override
    public final Array getArray(int n) {
        return (Array)this.getBAPFunction(n);
    }

    @Override
    public FSGOperationState getBapFSGOperationStateFunction() {
        return (FSGOperationState)((Object)this.getBAPFunction(15));
    }

    @Override
    public BAPFunctionListener getBAPFunctionListener(int n) {
        return this.getFunctionRegistryListenerAdapter().getFunctionRegistryListenerAdapter(n);
    }

    @Override
    public ArrayListener getArrayListener(int n) {
        return this.getFunctionRegistryListenerAdapter().getFunctionRegistryListenerAdapter(n);
    }

    @Override
    public MethodListener getMethodListener(int n) {
        return this.getFunctionRegistryListenerAdapter().getFunctionRegistryListenerAdapter(n);
    }

    @Override
    public PropertyListener getPropertyListener(int n) {
        return this.getFunctionRegistryListenerAdapter().getFunctionRegistryListenerAdapter(n);
    }

    @Override
    public BAPFunctionController getFunctionController(int n) {
        return this.getStage(n);
    }

    @Override
    public BAPConfigVersionCheck getBapConfigVersionCheckFunction() {
        return (BAPConfigVersionCheck)((Object)this.getStage(2));
    }

    @Override
    public BAPFunctionList getFunctionList() {
        return (BAPFunctionList)((Object)this.getStage(3));
    }

    @Override
    public BAPOperationState getOperationState() {
        return (BAPOperationState)((Object)this.getStage(15));
    }
}

