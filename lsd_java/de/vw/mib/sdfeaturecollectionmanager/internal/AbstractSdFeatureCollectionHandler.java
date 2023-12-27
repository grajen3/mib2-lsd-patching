/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sdfeaturecollectionmanager.internal;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.api.speechengine.features.GenericTargetFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexCommandFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexHelpPromptsFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexInitialPromptsFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexTeleprompterDataFeature;
import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.api.speechengine.features.model.DynamicString;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.datapool.ModelDatapoolObserver;
import de.vw.mib.datapool.ScaledI18nDatapool;
import de.vw.mib.datapool.ScaledI18nListener;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.list.ListItemControl;
import de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionHandler;
import de.vw.mib.sdfeaturecollectionmanager.internal.AbstractSdFeatureCollectionHandler$SdCommandData;
import de.vw.mib.sdfeaturecollectionmanager.internal.AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener;
import de.vw.mib.sdfeaturecollectionmanager.internal.ServiceManagerSdFeatureCollection;
import java.util.Iterator;

public abstract class AbstractSdFeatureCollectionHandler
implements SdFeatureCollectionHandler,
ModelDatapoolObserver,
ScaledI18nListener {
    protected static final int ANY_CONDITION;
    private SdFeatureCollectionHandler parent;
    protected int speechClientId = 1234;
    protected int sdFeatColId = 1234;
    protected boolean isInheritingCommands = true;
    protected int commandFeatureIndex = -1;
    protected AbstractSdFeatureCollectionHandler$SdCommandData[] sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[0];
    protected int[] dpProperties = new int[0];
    protected ListItemControl[] listItemControls = new ListItemControl[0];
    protected AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener[] listItemControlListeners = new AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener[0];
    protected boolean[] conditions = new boolean[0];
    protected static final int IS_INACTIVE;
    protected static final int SUPPORTS_RUNTIME_UPDATE;
    protected static final int SUPPORTS_SCALE_I18N_UPDATE;
    protected static final int IS_ACTIVE;
    protected int[] featureData = EMPTY_INT_ARRAY;
    protected boolean[] featuresToUpdate = new boolean[0];
    private int amountOfActiveFeatures = 0;
    private boolean isCurrentlyObservingListsAndProperties = false;
    private static final int[] EMPTY_INT_ARRAY;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$sdfeaturecollectionmanager$internal$AbstractSdFeatureCollectionHandler;

    public abstract void init(int n, int n2) {
    }

    @Override
    public final Feature[] collectFeaturesAndActivateConditionObservation() {
        IntObjectOptHashMap intObjectOptHashMap = AbstractSdFeatureCollectionHandler.createNewHashMap();
        this.tryToAddAllFeaturesToMapAndUpdateFeatureActivity(intObjectOptHashMap);
        Object[] objectArray = new Feature[intObjectOptHashMap.size()];
        intObjectOptHashMap.valuesToArray(objectArray);
        return objectArray;
    }

    @Override
    public final void tryToAddAllFeaturesToMapAndUpdateFeatureActivity(IntObjectOptHashMap intObjectOptHashMap) {
        this.evaluateAllConditionsInitially();
        for (int i2 = 0; i2 < this.getTotalAmountOfFeatures(); ++i2) {
            this.tryToAddFeatureToMapAndUpdateFeatureActivity(i2, intObjectOptHashMap);
        }
        this.setObservation(this.amountOfActiveFeatures > 0);
        if (this.hasParent()) {
            this.getParent().tryToAddAllFeaturesToMapAndUpdateFeatureActivity(intObjectOptHashMap);
        }
    }

    @Override
    public final void evaluateAllConditionsInitially() {
        for (int i2 = 0; i2 < this.conditions.length; ++i2) {
            this.conditions[i2] = this.evaluateCondition(i2);
        }
        if (this.hasParent()) {
            this.getParent().evaluateAllConditionsInitially();
        }
    }

    private void tryToAddFeatureToMapAndUpdateFeatureActivity(int n, IntObjectOptHashMap intObjectOptHashMap) {
        Feature feature = this.createFeatureInstance(n);
        int n2 = feature.getFeatureType();
        if (intObjectOptHashMap.containsKey(n2)) {
            if (n2 != 302) {
                this.setFeatureActivity(n, false);
            }
            this.discardFeatureInstance(feature);
        } else {
            intObjectOptHashMap.put(n2, feature);
            this.setFeatureActivity(n, true);
        }
    }

    private boolean getFeatureBooleanData(int n, int n2) {
        return (this.featureData[n] & n2) != 0;
    }

    protected boolean hasFeatureRuntimeUpdate(int n) {
        return this.getFeatureBooleanData(n, 1);
    }

    protected boolean hasFeatureScaledI18nUpdate(int n) {
        return this.getFeatureBooleanData(n, 2);
    }

    protected boolean isFeatureActive(int n) {
        return this.getFeatureBooleanData(n, 4096);
    }

    private void setFeatureActivity(int n, boolean bl) {
        if (this.isFeatureActive(n) != bl) {
            int n2 = n;
            this.featureData[n2] = this.featureData[n2] ^ 0x1000;
            this.amountOfActiveFeatures = bl ? ++this.amountOfActiveFeatures : --this.amountOfActiveFeatures;
        }
    }

    private void setObservation(boolean bl) {
        if (bl == this.isCurrentlyObservingListsAndProperties) {
            return;
        }
        if (bl) {
            this.registerScaledI18nDatapoolObservers();
            this.registerDpPropertyObservers();
            this.registerListObservers();
        } else {
            this.deregisterListObservers();
            this.deregisterDpPropertyObservers();
            this.deregisterScaledI18nDatapoolObservers();
        }
        this.isCurrentlyObservingListsAndProperties = bl;
    }

    private int getTotalAmountOfFeatures() {
        return this.featureData.length;
    }

    protected abstract Feature createFeatureInstance(int n) {
    }

    private void discardFeatureInstance(Feature feature) {
    }

    @Override
    public final void setSpeechClientId(int n) {
        this.speechClientId = n;
    }

    @Override
    public final void setParent(SdFeatureCollectionHandler sdFeatureCollectionHandler) {
        this.parent = sdFeatureCollectionHandler;
    }

    private SdFeatureCollectionHandler getParent() {
        return this.parent;
    }

    private boolean isInheritingCommands() {
        return this.isInheritingCommands;
    }

    @Override
    public final void destroy() {
        this.setObservation(false);
    }

    private void registerScaledI18nDatapoolObservers() {
        if (this.useScaledI18n()) {
            ServiceManagerCommon.scaledI18nDatapool.addListener(this);
        }
    }

    private void deregisterScaledI18nDatapoolObservers() {
        if (this.useScaledI18n()) {
            ServiceManagerCommon.scaledI18nDatapool.removeListener(this);
        }
    }

    @Override
    public void onUpdateScaledI18n(ScaledI18nDatapool scaledI18nDatapool) {
        for (int i2 = 0; i2 < this.getTotalAmountOfFeatures(); ++i2) {
            if (!this.hasFeatureScaledI18nUpdate(i2)) continue;
            this.updateFeature(i2);
        }
    }

    private boolean useScaledI18n() {
        for (int i2 = 0; i2 < this.getTotalAmountOfFeatures(); ++i2) {
            if (!this.hasFeatureScaledI18nUpdate(i2)) continue;
            return true;
        }
        return false;
    }

    private void registerDpPropertyObservers() {
        for (int i2 = 0; i2 < this.dpProperties.length; ++i2) {
            ServiceManagerCommon.modelDatapool.registerObserver(this.dpProperties[i2], this, false);
        }
    }

    private void deregisterDpPropertyObservers() {
        for (int i2 = 0; i2 < this.dpProperties.length; ++i2) {
            ServiceManagerCommon.modelDatapool.unregisterObserver(this.dpProperties[i2], this);
        }
    }

    @Override
    public final void datapoolValueChanged(int n) {
        int[] nArray = this.getConditionsAffectedByProperty(n);
        this.reevaluateConditions(nArray);
        this.updateAffectedFeature(n);
    }

    private void reevaluateConditions(int[] nArray) {
        int n;
        this.resetFeaturesToUpdate();
        for (n = 0; n < nArray.length; ++n) {
            int n2 = nArray[n];
            this.reevaluateCondition(n2);
        }
        for (n = 0; n < this.featuresToUpdate.length; ++n) {
            if (!this.featuresToUpdate[n]) continue;
            this.updateFeature(n);
        }
    }

    private void reevaluateCondition(int n) {
        boolean bl = this.conditions[n];
        boolean bl2 = this.evaluateCondition(n);
        if (bl2 != bl) {
            this.conditions[n] = bl2;
            int[] nArray = this.getAffectedFeatures(n);
            this.handleChangedCondition(n, nArray);
        }
    }

    private void handleChangedCondition(int n, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2 = nArray[i2];
            if (n2 == this.commandFeatureIndex) {
                this.updateCommandFeature(n);
                continue;
            }
            this.featuresToUpdate[n2] = true;
        }
    }

    private boolean[] resetFeaturesToUpdate() {
        for (int i2 = 0; i2 < this.featuresToUpdate.length; ++i2) {
            this.featuresToUpdate[i2] = false;
        }
        return this.featuresToUpdate;
    }

    protected void updateAffectedFeature(int n) {
    }

    protected int[] getConditionsAffectedByProperty(int n) {
        return EMPTY_INT_ARRAY;
    }

    protected int[] getAffectedFeatures(int n) {
        return EMPTY_INT_ARRAY;
    }

    private void registerListObservers() {
        this.assertLengthOfListItemControlsEqualsLengthOfListItemControlListeners();
        for (int i2 = 0; i2 < this.listItemControls.length; ++i2) {
            this.listItemControls[i2].addListItemControlListener(this.listItemControlListeners[i2]);
        }
    }

    private void deregisterListObservers() {
        this.assertLengthOfListItemControlsEqualsLengthOfListItemControlListeners();
        for (int i2 = 0; i2 < this.listItemControls.length; ++i2) {
            this.listItemControls[i2].removeListItemControlListener(this.listItemControlListeners[i2]);
        }
    }

    protected final void onListChanged(int n) {
        int[] nArray = this.getConditionsAffectedByList(n);
        this.reevaluateConditions(nArray);
    }

    protected int[] getConditionsAffectedByList(int n) {
        return EMPTY_INT_ARRAY;
    }

    private void assertLengthOfListItemControlsEqualsLengthOfListItemControlListeners() {
        if (!$assertionsDisabled && this.listItemControls.length != this.listItemControlListeners.length) {
            throw new AssertionError((Object)"Ensured by generated derived classes.");
        }
    }

    protected void collectAllUnconditionalCommands(ObjectArrayList objectArrayList) {
    }

    private void collectAllConditionalCommands(ObjectArrayList objectArrayList) {
        for (int i2 = 0; i2 < this.conditions.length; ++i2) {
            if (!this.conditions[i2]) continue;
            this.collectAllCommandsGuardedByOneCondition(objectArrayList, i2);
        }
    }

    protected void collectAllCommandsGuardedByOneCondition(ObjectArrayList objectArrayList, int n) {
    }

    protected boolean evaluateCondition(int n) {
        return false;
    }

    protected ComplexHelpPromptsFeature createHelpPromptsFeature() {
        return ServiceManagerSdFeatureCollection.featureFactory.createHelpPromptsFeature();
    }

    protected ComplexInitialPromptsFeature createInitialPromptsFeature() {
        return ServiceManagerSdFeatureCollection.featureFactory.createInitialPromptsFeature();
    }

    protected ComplexTeleprompterDataFeature createTeleprompterDataFeature() {
        return ServiceManagerSdFeatureCollection.featureFactory.createTeleprompterDataFeature();
    }

    protected GenericTargetFeature createGenericFeature(int n) {
        return ServiceManagerSdFeatureCollection.featureFactory.createFeature(n);
    }

    protected OrderedPrompts createOrderedPrompts(int[] nArray, int n) {
        return ServiceManagerSdFeatureCollection.featureFactory.createOrderedPrompts(nArray, n);
    }

    protected DynamicString createDynamicString(String string, boolean bl) {
        return ServiceManagerSdFeatureCollection.featureFactory.createDynamicString(string, bl);
    }

    protected final Command createSingleCommand(int n) {
        return this.createCommand(this.speechClientId, this.sdCommandData[n].id, this.sdCommandData[n].eventId, this.sdCommandData[n].ruleMode, true, this.sdCommandData[n].hasSpeeableReferences, this.sdCommandData[n].isNLU);
    }

    protected final ComplexCommandFeature createCommandFeatureAndFillItWithCommandsToLoad() {
        ObjectArrayList objectArrayList = AbstractSdFeatureCollectionHandler.createNewArrayList();
        this.collectAllCommandsToLoad(objectArrayList);
        Command[] commandArray = this.arrayListToCommandArray(objectArrayList);
        ComplexCommandFeature complexCommandFeature = this.createCommandFeature();
        complexCommandFeature.setCommandsToLoad(commandArray);
        return complexCommandFeature;
    }

    @Override
    public final void collectAllCommandsToLoad(ObjectArrayList objectArrayList) {
        this.collectAllUnconditionalCommands(objectArrayList);
        this.collectAllConditionalCommands(objectArrayList);
        this.setCommandFeatureActivity(true);
        if (this.hasParent()) {
            if (this.isInheritingCommands()) {
                this.getParent().collectAllCommandsToLoad(objectArrayList);
            } else {
                this.getParent().setCommandFeatureActivity(false);
            }
        }
    }

    @Override
    public final void setCommandFeatureActivity(boolean bl) {
        if (this.commandFeatureIndex >= 0) {
            this.setFeatureActivity(this.commandFeatureIndex, bl);
        }
        if (this.hasParent() && !bl) {
            this.getParent().setCommandFeatureActivity(false);
        }
    }

    private void updateCommandFeature(int n) {
        if (!this.isFeatureActive(this.commandFeatureIndex)) {
            return;
        }
        ComplexCommandFeature complexCommandFeature = this.createCommandFeature();
        if (n != -1) {
            ObjectArrayList objectArrayList = AbstractSdFeatureCollectionHandler.createNewArrayList();
            this.collectAllCommandsGuardedByOneCondition(objectArrayList, n);
            Command[] commandArray = this.arrayListToCommandArray(objectArrayList);
            if (this.conditions[n]) {
                complexCommandFeature.setCommandsToLoad(commandArray);
            } else {
                complexCommandFeature.setCommandsToUnload(commandArray);
            }
        }
        this.updateFeatures(this.speechClientId, new Feature[]{complexCommandFeature});
    }

    protected final void updateFeature(int n) {
        if (!this.isFeatureActive(n)) {
            return;
        }
        this.updateFeatures(this.speechClientId, new Feature[]{this.createFeatureInstance(n)});
    }

    private void updateFeatures(int n, Feature[] featureArray) {
        ServiceManagerSdFeatureCollection.speechProxy.updateFeatures(n, featureArray);
    }

    private ComplexCommandFeature createCommandFeature() {
        return ServiceManagerSdFeatureCollection.featureFactory.createCommandFeature();
    }

    private Command createCommand(int n, int n2, int n3, int n4, boolean bl, boolean bl2, boolean bl3) {
        return ServiceManagerSdFeatureCollection.featureFactory.createCommand(n, n2, n3, n4, bl, bl2, bl3);
    }

    private Command[] arrayListToCommandArray(ObjectArrayList objectArrayList) {
        Command[] commandArray = new Command[objectArrayList.size()];
        Iterator iterator = objectArrayList.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            commandArray[n++] = (Command)iterator.next();
        }
        return commandArray;
    }

    private static ObjectArrayList createNewArrayList() {
        return new ObjectArrayList();
    }

    private static IntObjectOptHashMap createNewHashMap() {
        return IntObjectOptHashMap.createSlowlyGrowingHashmap(3, 63, 63);
    }

    protected final Event createEvent(int n) {
        return ServiceManagerSdFeatureCollection.featureFactory.createEvent(n);
    }

    private boolean hasParent() {
        return this.getParent() != null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$sdfeaturecollectionmanager$internal$AbstractSdFeatureCollectionHandler == null ? (class$de$vw$mib$sdfeaturecollectionmanager$internal$AbstractSdFeatureCollectionHandler = AbstractSdFeatureCollectionHandler.class$("de.vw.mib.sdfeaturecollectionmanager.internal.AbstractSdFeatureCollectionHandler")) : class$de$vw$mib$sdfeaturecollectionmanager$internal$AbstractSdFeatureCollectionHandler).desiredAssertionStatus();
        EMPTY_INT_ARRAY = new int[0];
    }
}

