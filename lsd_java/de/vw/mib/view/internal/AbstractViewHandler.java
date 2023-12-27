/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.animation.control.AnimatedPropertiesAccessor;
import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.datapool.I18nListener;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.datapool.ModelDatapoolObserver;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.view.internal.AnimationAdapters;
import de.vw.mib.view.internal.AnimationTriggers;
import de.vw.mib.view.internal.CloneData;
import de.vw.mib.view.internal.CommonViewHandler;
import de.vw.mib.view.internal.ViewHandlerAppServices;
import de.vw.mib.view.internal.ViewHandlerServices;
import de.vw.mib.view.internal.WidgetAnimator;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.interfaces.WidgetCloneData;
import de.vw.mib.widgets.interfaces.WidgetCloneFactory;
import de.vw.mib.widgets.interfaces.WidgetCloneFactoryRegister;
import de.vw.mib.widgets.interfaces.WidgetCloneable;
import de.vw.mib.widgets.list.ListItemTransfer;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.ScreenAreaModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;

public abstract class AbstractViewHandler
implements CommonViewHandler,
WidgetCloneFactory,
I18nListener,
AnimatedPropertiesAccessor,
PropertyChangedListener,
ModelDatapoolObserver,
ListItemTransfer {
    static final int LIFECYCLE_CTOR;
    static final int LIFECYCLE_NULL;
    static final int LIFECYCLE_CREATED;
    static final int LIFECYCLE_PREINITIALIZED;
    static final int LIFECYCLE_INITIALIZED;
    static final int LIFECYCLE_ACTIVATED;
    private static final ScreenAreaModel[] EMPTY_SCREEN_AREA_MODEL_ARRAY;
    protected static final CloneData CD0;
    private boolean activated = false;
    private int lifeCycle = -1;
    protected ViewHandlerServices services;
    protected ViewHandlerAppServices appServices;
    protected Logger logger;
    protected CellValue cellValue;
    protected short[][] uiTypes;
    protected CloneData cd0;
    protected AnimationTriggers animationTriggers = AnimationTriggers.NONE;
    protected AnimationAdapters animationAdapters = AnimationAdapters.NONE;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$view$internal$AbstractViewHandler;

    protected AbstractViewHandler() {
    }

    @Override
    public void postConstructor(ViewHandlerServices viewHandlerServices, ViewHandlerAppServices viewHandlerAppServices) {
        this.checkAndChangeLifeCycle(-1, 0);
        this.services = viewHandlerServices;
        this.appServices = viewHandlerAppServices;
        this.logger = this.services.getLoggerFactory().getLogger(1024);
        this.cellValue = new CellValue();
    }

    private void checkAndChangeLifeCycle(int n, int n2) {
        if (this.lifeCycle != n) {
            String string = new StringBuffer().append("Invalid lifecycle change indicated in ").append(this.getName()).append(". From ").append(this.lifeCycle).append(" to ").append(n2).append(".").toString();
            this.fatalError(new IllegalStateException(string));
        }
        this.lifeCycle = n2;
    }

    void assertLifeCycleAt(int n) {
        Preconditions.checkState(this.lifeCycle == n, new StringBuffer().append("Invalid lifecycle in ").append(this.getName()).append(". Expect at ").append(n).append(" but was ").append(this.lifeCycle).append(".").toString());
    }

    private void assertLifeCycleAtLeast(int n) {
        Preconditions.checkState(this.lifeCycle >= n, new StringBuffer().append("Invalid lifecycle in ").append(this.getName()).append(". Expect at least ").append(n).append(" but was ").append(this.lifeCycle).append(".").toString());
    }

    protected AnimationAdapters getAnimationAdapters(WidgetAnimator widgetAnimator) {
        return AnimationAdapters.NONE;
    }

    protected AnimationTriggers getAnimationTriggers(AnimationAdapters animationAdapters, ModelDatapool modelDatapool) {
        return AnimationTriggers.NONE;
    }

    protected abstract int getInternalViewId() {
    }

    @Override
    public void reInit(boolean bl) {
    }

    @Override
    public void gainFocus() {
    }

    @Override
    public void loseFocus() {
    }

    @Override
    public void suspend() {
    }

    @Override
    public void resume() {
    }

    @Override
    public final AppDefinition getAppDefinition() {
        return this.appServices.getAppDefinition();
    }

    @Override
    public final ViewModel getView() {
        return (ViewModel)this.cd0.widgets[0];
    }

    @Override
    public final ScreenAreaModel[] getScreenAreas() {
        this.assertLifeCycleAtLeast(1);
        return this.getScreenAreaModels();
    }

    protected ScreenAreaModel[] getScreenAreaModels() {
        return EMPTY_SCREEN_AREA_MODEL_ARRAY;
    }

    @Override
    public final void create() {
        this.checkAndChangeLifeCycle(0, 1);
        try {
            this.lifeCycleCreate();
        }
        catch (RuntimeException runtimeException) {
            this.fatalError(runtimeException);
            throw runtimeException;
        }
    }

    @Override
    public final void destroy() {
        this.checkAndChangeLifeCycle(1, 0);
        try {
            this.lifeCycleDestroy();
        }
        catch (RuntimeException runtimeException) {
            this.fatalError(runtimeException);
        }
    }

    protected void lifeCycleCreate() {
        this.createSkinValues();
        this.createListItemControls();
        this.uiTypes = this.getUITypes();
        this.cd0 = this.createWidgetTree();
        this.assignCloneMasters();
        this.services.getWidgetTreeBuilder().createViewSignalisation();
        this.animationAdapters = this.getAnimationAdapters(this.services.getWidgetAnimator());
        this.animationTriggers = this.getAnimationTriggers(this.animationAdapters, this.services.getModelDatapool());
    }

    protected void lifeCycleDestroy() {
        this.destroyWidgetTree();
        this.destroyListItemControls();
        this.destroySkinValues();
    }

    private CloneData createWidgetTree() {
        CloneData cloneData = this.services.getWidgetTreeBuilder().createFullWidgetTree(this.getInternalViewId(), this.uiTypes);
        return cloneData;
    }

    private void destroyWidgetTree() {
        this.services.getWidgetTreeBuilder().destroyWidgetTree(this.getInternalViewId(), this.cd0, this.uiTypes);
    }

    protected void createListItemControls() {
    }

    protected void destroyListItemControls() {
    }

    protected void createSkinValues() {
    }

    protected void destroySkinValues() {
    }

    protected abstract short[][] getUITypes() {
    }

    @Override
    public final void setup() {
        this.checkAndChangeLifeCycle(1, 2);
        try {
            this.openSkinDataContainer();
            this.initWidgetTree();
        }
        catch (RuntimeException runtimeException) {
            this.fatalError(runtimeException);
            throw runtimeException;
        }
    }

    @Override
    public final void init(boolean bl) {
        this.checkAndChangeLifeCycle(2, 3);
        try {
            this.registerListItemControlOnInit();
            this.attachListControls(bl);
            this.getView().setViewEventDispatcher(this.appServices.getViewEventDispatcher());
            this.getView().init();
            this.performInitialUpdateForExternalLists();
            this.registerWidgetPropertyListener(CD0);
            this.initScripts();
            this.registerDpPropertyListenerOnInit();
            this.animationTriggers.registerDpPropertyTriggers();
        }
        catch (RuntimeException runtimeException) {
            this.fatalError(runtimeException);
            throw runtimeException;
        }
    }

    private void initWidgetTree() {
        this.initWidgets();
        this.initWidgetsPostStep(this.cd0.widgets);
    }

    private void initWidgetsPostStep(WidgetModel[] widgetModelArray) {
        for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
            WidgetModel widgetModel = widgetModelArray[i2];
            if (widgetModel instanceof TemplateListModel) {
                ((TemplateListModel)widgetModel).setListItemTransfer(this);
            }
            if (widgetModel instanceof WidgetCloneFactoryRegister) {
                ((WidgetCloneFactoryRegister)((Object)widgetModel)).setWidgetCloneFactory(this);
            }
            if (!(widgetModel instanceof WidgetCloneable)) continue;
            CloneData cloneData = this.cdMasterOf((WidgetCloneable)((Object)widgetModel));
            this.initCloneData(cloneData);
        }
    }

    protected void openSkinDataContainer() {
    }

    protected abstract void initWidgets() {
    }

    protected void initScripts() {
    }

    protected void registerWidgetPropertyListener(CloneData cloneData) {
    }

    protected void registerDpPropertyListenerOnInit() {
    }

    protected void registerListItemControlOnInit() {
    }

    protected void performInitialUpdateForExternalLists() {
    }

    protected void registerListItemControlOnActivate() {
    }

    @Override
    public void updateI18n() {
    }

    @Override
    public final void activate() {
        this.checkAndChangeLifeCycle(3, 4);
        try {
            this.setActivated(true);
            this.registerListItemControlOnActivate();
            this.registerDpPropertyListenerOnActivate();
            this.registerI18nListener();
            this.registerOutEvents();
            this.getView().activate();
        }
        catch (RuntimeException runtimeException) {
            this.fatalError(runtimeException);
            throw runtimeException;
        }
    }

    protected void registerDpPropertyListenerOnActivate() {
    }

    protected void registerI18nListener() {
        this.services.getI18nDatapool().registerI18nListener(this);
    }

    protected void registerOutEvents() {
    }

    @Override
    public boolean transferData(ListItemModel listItemModel, int n, int n2) {
        return false;
    }

    @Override
    public final WidgetCloneable createWidgetCloneable(WidgetCloneable widgetCloneable) {
        this.assertLifeCycleAtLeast(3);
        CloneData cloneData = (CloneData)widgetCloneable.getCloneData();
        CloneData cloneData2 = this.cloneCloneData(cloneData.master);
        if (!$assertionsDisabled && cloneData2.master != cloneData.master) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && cloneData2 == cloneData2.master) {
            throw new AssertionError();
        }
        return (WidgetCloneable)((Object)cloneData2.widgets[0]);
    }

    @Override
    public final void destroyWidgetCloneable(WidgetCloneable widgetCloneable) {
        this.assertLifeCycleAtLeast(3);
        CloneData cloneData = (CloneData)widgetCloneable.getCloneData();
        if (!$assertionsDisabled && cloneData == cloneData.master) {
            throw new AssertionError();
        }
        Preconditions.checkArgument(cloneData != cloneData.master, "Widget cloneable was not created with createWidgetCloneable.");
        if (this.isActivated()) {
            this.deactivateCloneData(cloneData);
        }
        this.deinitCloneData(cloneData);
        this.services.getWidgetTreeBuilder().destroyWidgetTree(this.getInternalViewId(), cloneData, this.uiTypes);
    }

    protected void assignCloneMasters() {
    }

    private CloneData cloneCloneData(CloneData cloneData) {
        CloneData cloneData2 = this.services.getWidgetTreeBuilder().cloneSubWidgetTree(this.getInternalViewId(), cloneData, this.uiTypes);
        this.initCloneData(cloneData2);
        this.transferScriptResults(cloneData2);
        if (this.isActivated()) {
            this.activateCloneData(cloneData2);
        }
        return cloneData2;
    }

    protected void initCloneData(CloneData cloneData) {
        throw this.invalidCloneDataException(cloneData);
    }

    protected final void deinitCloneData(CloneData cloneData) {
        cloneData.widgets[0].deInit();
        this.deregisterWidgetPropertyListener(cloneData);
    }

    protected void transferScriptResults(CloneData cloneData) {
        throw this.invalidCloneDataException(cloneData);
    }

    protected void activateCloneData(CloneData cloneData) {
        throw this.invalidCloneDataException(cloneData);
    }

    protected void deactivateCloneData(CloneData cloneData) {
        throw this.invalidCloneDataException(cloneData);
    }

    protected CloneData cdMasterAtRootLevelIndex(int n) {
        WidgetCloneable widgetCloneable = (WidgetCloneable)((Object)this.cd0.widgets[n]);
        return this.cdMasterOf(widgetCloneable);
    }

    private CloneData cdMasterOf(WidgetCloneable widgetCloneable) {
        WidgetCloneData widgetCloneData = widgetCloneable.getCloneData();
        CloneData cloneData = (CloneData)widgetCloneData;
        if (!$assertionsDisabled && cloneData.master != cloneData) {
            throw new AssertionError();
        }
        return cloneData;
    }

    protected final IllegalArgumentException invalidCloneDataException(CloneData cloneData) {
        throw new IllegalArgumentException("Cloneable not of this view handler.");
    }

    @Override
    public final void deactivate() {
        try {
            this.getView().deActivate();
            this.deregisterOutEvents();
            this.deregisterI18nListener();
            this.deregisterDpPropertyListenerOnDeactivate();
            this.deregisterListItemControlOnDeactivate();
            this.setActivated(false);
        }
        catch (RuntimeException runtimeException) {
            this.fatalError(runtimeException);
        }
        this.checkAndChangeLifeCycle(4, 3);
    }

    protected void deregisterOutEvents() {
    }

    protected void deregisterI18nListener() {
        this.services.getI18nDatapool().deregisterI18nListener(this);
    }

    @Override
    public final void deinit() {
        try {
            this.getView().deInit();
            this.getView().setViewEventDispatcher(null);
            this.animationTriggers.deregisterDpPropertyTriggers();
            this.deregisterListItemControlOnDeinit();
            this.deregisterDpPropertyListenerOnDeinit();
            this.deregisterWidgetPropertyListener(CD0);
            this.deinitCloneWidgetsAndDestroyClones();
        }
        catch (RuntimeException runtimeException) {
            this.fatalError(runtimeException);
        }
        this.checkAndChangeLifeCycle(3, 2);
    }

    protected void deregisterListItemControlOnDeactivate() {
    }

    protected void deregisterListItemControlOnDeinit() {
    }

    protected void deregisterDpPropertyListenerOnDeactivate() {
    }

    protected void deregisterDpPropertyListenerOnDeinit() {
    }

    protected void deregisterWidgetPropertyListener(CloneData cloneData) {
    }

    protected void deinitCloneWidgetsAndDestroyClones() {
    }

    protected void closeSkinDataContainer() {
    }

    @Override
    public final void teardown() {
        try {
            this.closeSkinDataContainer();
        }
        catch (RuntimeException runtimeException) {
            this.fatalError(runtimeException);
            throw runtimeException;
        }
        this.checkAndChangeLifeCycle(2, 1);
    }

    protected boolean forwardInEvent(HMIEvent hMIEvent) {
        return false;
    }

    @Override
    public final boolean consumeEvent(HMIEvent hMIEvent) {
        if (this.acceptReceiver(hMIEvent)) {
            boolean bl = this.forwardInEvent(hMIEvent);
            hMIEvent.setConsumed(bl);
            return bl;
        }
        return false;
    }

    private boolean acceptReceiver(HMIEvent hMIEvent) {
        AppDefinition appDefinition = hMIEvent.getReceiver();
        return appDefinition == null || appDefinition == this.getAppDefinition();
    }

    @Override
    public final boolean consumeEvent(TouchEvent touchEvent) {
        ViewModel viewModel = this.getView();
        boolean bl = viewModel.consumeTouchEvent(touchEvent);
        return bl;
    }

    protected final void refresh() {
    }

    protected void onAslListChanged(int n) {
    }

    protected void onAppAdapterListChanged(int n) {
    }

    protected void attachListControls(boolean bl) {
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        this.widgetPropertyChanged(widgetModel.get_targetId(), n);
    }

    protected void widgetPropertyChanged(int n, int n2) {
    }

    private LogMessage fatalMsg() {
        return this.logger.fatal(2);
    }

    protected LogMessage error() {
        return this.logger.error(2);
    }

    protected void fatalError(RuntimeException runtimeException) {
        LogMessage logMessage = this.fatalMsg();
        logMessage.append("View:fatal error in view: ");
        logMessage.append(this.cd0 != null && this.getView() != null ? this.getView().get_name() : "???");
        logMessage.append(runtimeException.getMessage());
        logMessage.attachThrowable(runtimeException);
        logMessage.log();
    }

    public void setActivated(boolean bl) {
        this.activated = bl;
    }

    public boolean isActivated() {
        return this.activated;
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
        $assertionsDisabled = !(class$de$vw$mib$view$internal$AbstractViewHandler == null ? (class$de$vw$mib$view$internal$AbstractViewHandler = AbstractViewHandler.class$("de.vw.mib.view.internal.AbstractViewHandler")) : class$de$vw$mib$view$internal$AbstractViewHandler).desiredAssertionStatus();
        EMPTY_SCREEN_AREA_MODEL_ARRAY = new ScreenAreaModel[0];
        CD0 = null;
    }
}

