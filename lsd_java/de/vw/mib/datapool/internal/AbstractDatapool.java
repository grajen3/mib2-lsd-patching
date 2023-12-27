/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.collections.CollectionOverflowException;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.collections.ints.IntBooleanMap;
import de.vw.mib.collections.ints.IntFloatMap;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntLongMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.SyncIntBooleanOptHashMap;
import de.vw.mib.collections.ints.SyncIntFloatOptHashMap;
import de.vw.mib.collections.ints.SyncIntIntOptHashMap;
import de.vw.mib.collections.ints.SyncIntLongOptHashMap;
import de.vw.mib.collections.ints.SyncIntObjectOptHashMap;
import de.vw.mib.datapool.DatapoolException;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.datapool.ModelDatapoolObserver;
import de.vw.mib.datapool.diag.DatapoolValueConverter;
import de.vw.mib.datapool.diag.DebugDatapool;
import de.vw.mib.datapool.diag.DebugDatapoolObserver;
import de.vw.mib.datapool.internal.DatapoolWatchdog;
import de.vw.mib.datapool.internal.DatapoolWatchdogImpl;
import de.vw.mib.datapool.internal.DebugDatapoolObserverList;
import de.vw.mib.datapool.internal.ServiceManager;
import de.vw.mib.event.DatapoolUpdateEvent;
import de.vw.mib.event.consumer.DatapoolEventConsumer;
import de.vw.mib.graphics.Gradient;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractDatapool
implements DatapoolEventConsumer,
DebugDatapool,
ModelDatapool {
    static final String DATAPOOL_WATCHDOG_ENABLED;
    static final String DATAPOOL_WATCHDOG_TIMEOUT;
    private static Logger logger;
    private ModelDatapoolObserver datapoolUpdate = ModelDatapoolObserver.EMPTY_OBSERVER;
    private DatapoolWatchdog datapoolWatchdog = DatapoolWatchdog.EMPTY_DATAPOOL_WATCHDOG;
    private DebugDatapoolObserver debugObserver = DebugDatapoolObserver.EMPTY_OBSERVER;
    private DebugDatapoolObserverList debugObserverList;
    private final IntObjectMap observersMap = new IntObjectOptHashMap();
    private final IntBooleanMap booleanValues = new SyncIntBooleanOptHashMap(this.loadBooleanValues());
    private final IntFloatMap floatValues = new SyncIntFloatOptHashMap(this.loadFloatValues());
    private final IntIntMap integerValues = new SyncIntIntOptHashMap(this.loadIntValues());
    private final IntLongMap longValues = new SyncIntLongOptHashMap(this.loadLongValues());
    private final IntObjectMap objectValues = new SyncIntObjectOptHashMap(this.loadObjectValues());

    protected AbstractDatapool() {
        if (Boolean.getBoolean("de.vw.mib.datapool.watchdog.enabled")) {
            long l = Long.getLong("de.vw.mib.datapool.watchdog.timeout", 0);
            DatapoolWatchdogImpl datapoolWatchdogImpl = new DatapoolWatchdogImpl(this, l);
            datapoolWatchdogImpl.startWatchdog();
        }
    }

    @Override
    public final void consumeEvent(DatapoolUpdateEvent datapoolUpdateEvent) {
        switch (datapoolUpdateEvent.getType()) {
            case 0: {
                this.setInteger_internal(datapoolUpdateEvent.getPropertyId(), datapoolUpdateEvent.getIntegerValue());
                break;
            }
            case 1: {
                this.setBoolean_internal(datapoolUpdateEvent.getPropertyId(), datapoolUpdateEvent.getBooleanValue());
                break;
            }
            case 2: {
                this.setObjectValue_internal(datapoolUpdateEvent.getPropertyId(), datapoolUpdateEvent.getObjectValue());
                break;
            }
            case 3: {
                this.setLong_internal(datapoolUpdateEvent.getPropertyId(), datapoolUpdateEvent.getLongValue());
                break;
            }
            case 4: {
                this.setFloat_internal(datapoolUpdateEvent.getPropertyId(), datapoolUpdateEvent.getFloatValue());
                break;
            }
            default: {
                throw new IllegalStateException("unknown DatapoolUpdateEvent type!");
            }
        }
        this.fireUpdate(datapoolUpdateEvent.getPropertyId());
    }

    @Override
    public final boolean getBoolean(int n) {
        if (!this.booleanValues.containsKey(n)) {
            throw new DatapoolException(new StringBuffer().append("there is no boolean property with the id ").append(n).toString());
        }
        boolean bl = this.booleanValues.get(n);
        if (logger.isTraceEnabled(128) && (logger.isTraceEnabled(512) || logger.isTraceEnabled(1024) || logger.isTraceEnabled(4096))) {
            this.traceGetValue(n, "Boolean", DatapoolValueConverter.asValueString(bl));
        }
        return bl;
    }

    @Override
    public final IntBooleanMap getBooleanValues() {
        return this.booleanValues;
    }

    @Override
    public final FixFormatterFieldData getFixFormatterFieldData(int n) {
        return (FixFormatterFieldData)this.getObjectValue(n, "FixFormatterFieldData");
    }

    @Override
    public final boolean[] getFlagVector(int n) {
        return (boolean[])this.getObjectValue(n, "FlagVector");
    }

    @Override
    public final float getFloat(int n) {
        if (!this.floatValues.containsKey(n)) {
            throw new DatapoolException(new StringBuffer().append("there is no float property with the id ").append(n).toString());
        }
        float f2 = this.floatValues.get(n);
        if (logger.isTraceEnabled(128) && (logger.isTraceEnabled(512) || logger.isTraceEnabled(1024))) {
            this.traceGetValue(n, "Float", DatapoolValueConverter.asValueString(f2));
        }
        return f2;
    }

    @Override
    public final IntFloatMap getFloatValues() {
        return this.floatValues;
    }

    @Override
    public final Image[] getImageVector(int n) {
        return (Image[])this.getObjectValue(n, "ImageVector");
    }

    @Override
    public final int getInteger(int n) {
        if (!this.integerValues.containsKey(n)) {
            throw new DatapoolException(new StringBuffer().append("there is no integer property with the id ").append(n).toString());
        }
        int n2 = this.integerValues.get(n);
        if (logger.isTraceEnabled(128) && (logger.isTraceEnabled(512) || logger.isTraceEnabled(1024) || logger.isTraceEnabled(8192))) {
            this.traceGetValue(n, "Integer", DatapoolValueConverter.asValueString(n2));
        }
        return n2;
    }

    @Override
    public final int[] getIntegerArray(int n) {
        return (int[])this.getObjectValue(n, "IntegerArray");
    }

    @Override
    public final IntIntMap getIntegerValues() {
        return this.integerValues;
    }

    @Override
    public final int[] getIntegerVector(int n) {
        return (int[])this.getObjectValue(n, "IntegerVector");
    }

    @Override
    public final LabeledIconValue getLabeledIconValue(int n) {
        return (LabeledIconValue)this.getObjectValue(n, "LabeledIconValue");
    }

    @Override
    public final long getLong(int n) {
        if (!this.longValues.containsKey(n)) {
            throw new DatapoolException(new StringBuffer().append("there is no long property with the id ").append(n).toString());
        }
        long l = this.longValues.get(n);
        if (logger.isTraceEnabled(128) && (logger.isTraceEnabled(512) || logger.isTraceEnabled(1024))) {
            this.traceGetValue(n, "Long", DatapoolValueConverter.asValueString(l));
        }
        return l;
    }

    @Override
    public final IntLongMap getLongValues() {
        return this.longValues;
    }

    @Override
    public final IntObjectMap getObjectValues() {
        return this.objectValues;
    }

    @Override
    public final Object getRawObject(int n) {
        return this.getObjectValue(n, "RawObject");
    }

    @Override
    public final ResourceLocator getResourceLocator(int n) {
        return (ResourceLocator)this.getObjectValue(n, "ResourceLocator");
    }

    @Override
    public final SpellerData getSpellerData(int n) {
        return (SpellerData)this.getObjectValue(n, "SpellerData");
    }

    @Override
    public final Gradient getGradient(int n) {
        return (Gradient)this.getObjectValue(n, "Gradient");
    }

    @Override
    public final Gradient[] getGradientVector(int n) {
        return (Gradient[])this.getObjectValue(n, "GradientVector");
    }

    @Override
    public final String getString(int n) {
        return (String)this.getObjectValue(n, "String");
    }

    @Override
    public final String[] getStringVector(int n) {
        return (String[])this.getObjectValue(n, "StringVector");
    }

    @Override
    public final String getValueAsString(int n) {
        if (this.booleanValues.containsKey(n)) {
            return DatapoolValueConverter.asValueString(this.booleanValues.get(n));
        }
        if (this.integerValues.containsKey(n)) {
            return DatapoolValueConverter.asValueString(this.integerValues.get(n));
        }
        if (this.objectValues.containsKey(n)) {
            return DatapoolValueConverter.asValueString(this.objectValues.get(n));
        }
        if (this.longValues.containsKey(n)) {
            return DatapoolValueConverter.asValueString(this.longValues.get(n));
        }
        if (this.floatValues.containsKey(n)) {
            return DatapoolValueConverter.asValueString(this.floatValues.get(n));
        }
        return "\u0001unknown value\u0001";
    }

    @Override
    public final String getValueAsString(int n, int n2) {
        switch (n2) {
            case 0: {
                if (!this.booleanValues.containsKey(n)) break;
                return DatapoolValueConverter.asValueString(this.booleanValues.get(n));
            }
            case 17: {
                if (!this.integerValues.containsKey(n)) break;
                return DatapoolValueConverter.asValueString(this.integerValues.get(n));
            }
            case 23: {
                if (!this.longValues.containsKey(n)) break;
                return DatapoolValueConverter.asValueString(this.longValues.get(n));
            }
            case 7: {
                if (!this.floatValues.containsKey(n)) break;
                return DatapoolValueConverter.asValueString(this.floatValues.get(n));
            }
            default: {
                if (!this.objectValues.containsKey(n)) break;
                return DatapoolValueConverter.asValueString(this.objectValues.get(n));
            }
        }
        return "\u0001unknown value\u0001";
    }

    @Override
    public final void registerDatapoolUpdate(ModelDatapoolObserver modelDatapoolObserver) {
        this.datapoolUpdate = modelDatapoolObserver;
    }

    @Override
    public final void registerObserver(DebugDatapoolObserver debugDatapoolObserver) {
        if (this.debugObserver == DebugDatapoolObserver.EMPTY_OBSERVER) {
            this.debugObserver = debugDatapoolObserver;
        } else if (this.debugObserver == this.debugObserverList) {
            this.debugObserverList.addObserver(debugDatapoolObserver);
        } else {
            if (this.debugObserverList == null) {
                this.debugObserverList = new DebugDatapoolObserverList();
            }
            this.debugObserverList.addObserver(this.debugObserver);
            this.debugObserverList.addObserver(debugDatapoolObserver);
            this.debugObserver = this.debugObserverList;
        }
    }

    @Override
    public final synchronized void registerObserver(int n, ModelDatapoolObserver modelDatapoolObserver) {
        this.registerObserver(n, modelDatapoolObserver, true);
    }

    @Override
    public final synchronized void registerObserver(int n, ModelDatapoolObserver modelDatapoolObserver, boolean bl) {
        CowArray cowArray = (CowArray)this.observersMap.get(n);
        if (cowArray == null) {
            cowArray = new CowArray();
            this.observersMap.put(n, cowArray);
        }
        cowArray.add(modelDatapoolObserver);
        if (bl) {
            modelDatapoolObserver.datapoolValueChanged(n);
        }
    }

    @Override
    public final void setBoolean(int n, boolean bl) {
        if (logger.isTraceEnabled(256) && (logger.isTraceEnabled(512) || logger.isTraceEnabled(1024) || logger.isTraceEnabled(4096))) {
            this.traceSetValue(n, "Boolean", DatapoolValueConverter.asValueString(bl));
        }
        InvocationContext.getCurrentInvocationContext(null).createBranch();
        this.debugObserver.datapoolUpdate((byte)0, n, bl);
        ServiceManager.eventDispatcher.createAndSubmitDatapoolUpdateEvent(n, bl);
    }

    @Override
    public final void setFixFormatterFieldData(int n, FixFormatterFieldData fixFormatterFieldData) {
        this.setObjectValue(n, "FixFormatterFieldData", fixFormatterFieldData);
    }

    @Override
    public final void setFlagVector(int n, boolean[] blArray) {
        this.setObjectValue(n, "FlagVector", blArray);
    }

    @Override
    public final void setFloat(int n, float f2) {
        if (logger.isTraceEnabled(256) && (logger.isTraceEnabled(512) || logger.isTraceEnabled(1024))) {
            this.traceSetValue(n, "Float", DatapoolValueConverter.asValueString(f2));
        }
        InvocationContext.getCurrentInvocationContext(null).createBranch();
        this.debugObserver.datapoolUpdate((byte)0, n, f2);
        ServiceManager.eventDispatcher.createAndSubmitDatapoolUpdateEvent(n, f2);
    }

    @Override
    public final void setImageVector(int n, Image[] imageArray) {
        this.setObjectValue(n, "ImageVector", imageArray);
    }

    @Override
    public final void setInteger(int n, int n2) {
        if (logger.isTraceEnabled(256) && (logger.isTraceEnabled(512) || logger.isTraceEnabled(1024) || logger.isTraceEnabled(8192))) {
            this.traceSetValue(n, "Integer", DatapoolValueConverter.asValueString(n2));
        }
        InvocationContext.getCurrentInvocationContext(null).createBranch();
        this.debugObserver.datapoolUpdate((byte)0, n, n2);
        ServiceManager.eventDispatcher.createAndSubmitDatapoolUpdateEvent(n, n2);
    }

    @Override
    public final void setIntegerArray(int n, int[] nArray) {
        this.setObjectValue(n, "IntegerArray", nArray);
    }

    @Override
    public final void setIntegerVector(int n, int[] nArray) {
        this.setObjectValue(n, "IntegerVector", nArray);
    }

    @Override
    public final void setLabeledIconValue(int n, LabeledIconValue labeledIconValue) {
        this.setObjectValue(n, "LabeledIconValue", labeledIconValue);
    }

    @Override
    public final void setLong(int n, long l) {
        if (logger.isTraceEnabled(256) && (logger.isTraceEnabled(512) || logger.isTraceEnabled(1024))) {
            this.traceSetValue(n, "Long", DatapoolValueConverter.asValueString(l));
        }
        InvocationContext.getCurrentInvocationContext(null).createBranch();
        this.debugObserver.datapoolUpdate((byte)0, n, l);
        ServiceManager.eventDispatcher.createAndSubmitDatapoolUpdateEvent(n, l);
    }

    @Override
    public final void setRawObject(int n, Object object) {
        this.setObjectValue(n, "RawObject", object);
    }

    @Override
    public final void setResourceLocator(int n, ResourceLocator resourceLocator) {
        this.setObjectValue(n, "ResourceLocator", resourceLocator);
    }

    @Override
    public final void setSpellerData(int n, SpellerData spellerData) {
        this.setObjectValue(n, "SpellerData", spellerData);
    }

    @Override
    public final void setGradient(int n, Gradient gradient) {
        this.setObjectValue(n, "Gradient", gradient);
    }

    @Override
    public final void setGradientVector(int n, Gradient[] gradientArray) {
        this.setObjectValue(n, "GradientVector", gradientArray);
    }

    @Override
    public final void setString(int n, String string) {
        this.setObjectValue(n, "String", string);
    }

    @Override
    public final void setStringVector(int n, String[] stringArray) {
        this.setObjectValue(n, "StringVector", stringArray);
    }

    @Override
    public final void setValueFromString(int n, int n2, String string) {
        switch (n2) {
            case 0: {
                if (!this.booleanValues.containsKey(n)) {
                    throw new IllegalArgumentException(new StringBuffer().append("the specified property (").append(n).append(") does not match the specified type ").append(n2).toString());
                }
                this.setBoolean(n, DatapoolValueConverter.asBoolean(string));
                break;
            }
            case 17: {
                if (!this.integerValues.containsKey(n)) {
                    throw new IllegalArgumentException(new StringBuffer().append("the specified property (").append(n).append(") does not match the specified type ").append(n2).toString());
                }
                this.setInteger(n, DatapoolValueConverter.asInt(string));
                break;
            }
            case 23: {
                if (!this.longValues.containsKey(n)) {
                    throw new IllegalArgumentException(new StringBuffer().append("the specified property (").append(n).append(") does not match the specified type ").append(n2).toString());
                }
                this.setLong(n, DatapoolValueConverter.asLong(string));
                break;
            }
            case 7: {
                if (!this.floatValues.containsKey(n)) {
                    throw new IllegalArgumentException(new StringBuffer().append("the specified property (").append(n).append(") does not match the specified type ").append(n2).toString());
                }
                this.setFloat(n, DatapoolValueConverter.asFloat(string));
                break;
            }
            case 32: {
                if (!this.objectValues.containsKey(n)) {
                    throw new IllegalArgumentException(new StringBuffer().append("the specified property (").append(n).append(") does not match the specified type ").append(n2).toString());
                }
                this.setString(n, string);
                break;
            }
            default: {
                if (!this.objectValues.containsKey(n)) {
                    throw new IllegalArgumentException(new StringBuffer().append("the specified property (").append(n).append(") does not match the specified type ").append(n2).toString());
                }
                Object object = DatapoolValueConverter.asObject(string);
                Object object2 = this.getObjectValue(n, "ValueFromString");
                if (!object.getClass().equals(object2.getClass())) {
                    throw new IllegalArgumentException(new StringBuffer().append("the specified property (").append(n).append(") does not match the specified type ").append(n2).toString());
                }
                this.setObjectValue(n, "ValueFromString", object);
            }
        }
    }

    @Override
    public final void unregisterObserver(DebugDatapoolObserver debugDatapoolObserver) {
        if (this.debugObserver == debugDatapoolObserver) {
            this.debugObserver = DebugDatapoolObserver.EMPTY_OBSERVER;
        } else if (this.debugObserver == this.debugObserverList) {
            this.debugObserver = this.debugObserverList.removeObserver(debugDatapoolObserver);
        }
    }

    @Override
    public final synchronized void unregisterObserver(int n, ModelDatapoolObserver modelDatapoolObserver) {
        CowArray cowArray = (CowArray)this.observersMap.get(n);
        if (cowArray == null) {
            return;
        }
        cowArray.remove(modelDatapoolObserver);
        if (cowArray.size() == 0) {
            this.observersMap.remove(n);
        }
    }

    private synchronized void fireUpdate(int n) {
        this.datapoolUpdate.datapoolValueChanged(n);
        CowArray cowArray = (CowArray)this.observersMap.get(n);
        if (cowArray == null) {
            return;
        }
        Object[] objectArray = cowArray.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((ModelDatapoolObserver)objectArray[i2]).datapoolValueChanged(n);
        }
    }

    private Object getObjectValue(int n, String string) {
        if (!this.objectValues.containsKey(n)) {
            throw new DatapoolException(new StringBuffer().append("there is no property with the id ").append(n).toString());
        }
        Object object = this.objectValues.get(n);
        if (logger.isTraceEnabled(128) && (logger.isTraceEnabled(512) || logger.isTraceEnabled(2048))) {
            this.traceGetValue(n, string, DatapoolValueConverter.asValueString(object));
        }
        return object;
    }

    private synchronized boolean hasObservers(int n) {
        return this.observersMap.containsKey(n);
    }

    private void setObjectValue(int n, String string, Object object) {
        if (logger.isTraceEnabled(256) && (logger.isTraceEnabled(512) || logger.isTraceEnabled(2048))) {
            this.traceSetValue(n, string, DatapoolValueConverter.asValueString(object));
        }
        this.datapoolWatchdog.checkNewDatapoolValue(n, object);
        InvocationContext.getCurrentInvocationContext(null).createBranch();
        this.debugObserver.datapoolUpdate((byte)0, n, object);
        ServiceManager.eventDispatcher.createAndSubmitDatapoolUpdateEvent(n, object);
    }

    private void traceGetValue(int n, String string, String string2) {
        logger.trace(4).append("get").append(string).append("(").append(n).append(") : ").append(string2).log();
    }

    private void traceSetValue(int n, String string, String string2) {
        logger.trace(4).append("set").append(string).append("(").append(n).append(", ").append(string2).append(")").append(!this.hasObservers(n) ? " no observers" : "").log();
    }

    protected abstract IntBooleanMap loadBooleanValues() {
    }

    protected abstract IntFloatMap loadFloatValues() {
    }

    protected abstract IntIntMap loadIntValues() {
    }

    protected abstract IntLongMap loadLongValues() {
    }

    protected abstract IntObjectMap loadObjectValues() {
    }

    final boolean containsBoolean(int n) {
        return this.booleanValues.containsKey(n);
    }

    final boolean containsFloat(int n) {
        return this.floatValues.containsKey(n);
    }

    final boolean containsInteger(int n) {
        return this.integerValues.containsKey(n);
    }

    final boolean containsLong(int n) {
        return this.longValues.containsKey(n);
    }

    final boolean containsObject(int n) {
        return this.objectValues.containsKey(n);
    }

    final void registerDatapoolWatchdog(DatapoolWatchdog datapoolWatchdog) {
        this.datapoolWatchdog = datapoolWatchdog;
    }

    final void setBoolean_internal(int n, boolean bl) {
        try {
            this.booleanValues.put(n, bl);
            this.debugObserver.datapoolUpdate(this.hasObservers(n) ? (byte)1 : 2, n, bl);
        }
        catch (CollectionOverflowException collectionOverflowException) {
            logger.error(8, "datapool is full", collectionOverflowException);
        }
    }

    final void setFloat_internal(int n, float f2) {
        try {
            this.floatValues.put(n, f2);
            this.debugObserver.datapoolUpdate(this.hasObservers(n) ? (byte)1 : 2, n, f2);
        }
        catch (CollectionOverflowException collectionOverflowException) {
            logger.error(8, "datapool is full", collectionOverflowException);
        }
    }

    final void setInteger_internal(int n, int n2) {
        try {
            this.integerValues.put(n, n2);
            this.debugObserver.datapoolUpdate(this.hasObservers(n) ? (byte)1 : 2, n, n2);
        }
        catch (CollectionOverflowException collectionOverflowException) {
            logger.error(8, "datapool is full", collectionOverflowException);
        }
    }

    final void setLong_internal(int n, long l) {
        try {
            this.longValues.put(n, l);
            this.debugObserver.datapoolUpdate(this.hasObservers(n) ? (byte)1 : 2, n, l);
        }
        catch (CollectionOverflowException collectionOverflowException) {
            logger.error(8, "datapool is full", collectionOverflowException);
        }
    }

    final void setObjectValue_internal(int n, Object object) {
        try {
            this.objectValues.put(n, object);
            this.debugObserver.datapoolUpdate(this.hasObservers(n) ? (byte)1 : 2, n, object);
        }
        catch (CollectionOverflowException collectionOverflowException) {
            logger.error(8, "datapool is full", collectionOverflowException);
        }
    }

    final void unregisterDatapoolWatchdog() {
        if (this.datapoolWatchdog instanceof DatapoolWatchdogImpl) {
            ((DatapoolWatchdogImpl)this.datapoolWatchdog).stopWatchdog();
        }
        this.datapoolWatchdog = DatapoolWatchdog.EMPTY_DATAPOOL_WATCHDOG;
    }

    static {
        logger = ServiceManager.loggerFactory.getLogger(8);
    }
}

