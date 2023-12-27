/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.view.internal;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.cio.framework.ScriptWidgetCioService;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.datapool.DynamicListItemControlManager;
import de.vw.mib.datapool.GlobalExpressionEvaluator;
import de.vw.mib.datapool.I18nDatapool;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.file.FileManager;
import de.vw.mib.format.FixFormat;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.skin.SkinAnimationPool;
import de.vw.mib.skin.SkinAnimationUpdater;
import de.vw.mib.skin.SkinImagePool;
import de.vw.mib.skin.SkinResourceUpdaterRegister;
import de.vw.mib.view.internal.ListControlCache;
import de.vw.mib.view.internal.PopupInformationTableImpl;
import de.vw.mib.view.internal.SkinAnimationUpdaterImpl;
import de.vw.mib.view.internal.View2ViewAnimations;
import de.vw.mib.view.internal.View2ViewAnimationsUpdaterImpl;
import de.vw.mib.view.internal.ViewHandlerServicesImpl;
import de.vw.mib.view.internal.script.AbstractScriptWidget;
import de.vw.mib.view.internal.treebuilder.WidgetTreeBuilderImpl;
import de.vw.mib.viewmanager.internal.popup.PopupInformationTable;
import generated.de.vw.mib.global.view.internal.GlobalViewHandlerFactoryImpl;
import generated.de.vw.mib.global.view.internal.WidgetAnimatorImpl;
import generated.de.vw.mib.global.view.internal.WidgetTreeBuilderFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class Activator
implements BundleActivatorExtension,
ServiceListener {
    private final int HMI_CHECKSUM;
    private BundleContext bundleContext;
    private static final int DIRECT;
    private static final int INDIRECT;
    private int preloaded = 0;
    private int waitingListeners = 1;
    private ConfigurationManager configurationManager;
    private DynamicListItemControlManager dynamicListItemControlManager;
    private FileManager fileManager;
    private FixFormat fixFormat;
    private GlobalExpressionEvaluator globalExpressionEvaluator;
    private I18nDatapool i18nDatapool;
    private LoggerFactory loggerFactory;
    private ModelDatapool modelDatapool;
    private PerfService perfService;
    private ScriptWidgetCioService scriptWidgetCioService;
    private SkinAnimationPool skinAnimationPool;
    private SkinImagePool skinImagePool;
    private SkinResourceUpdaterRegister skinResourceUpdaterRegister;
    private GlobalViewHandlerFactoryImpl globalViewHandlerFactoryImpl;
    private PopupInformationTable popupInformationTable;
    private SkinAnimationUpdater skinAnimationUpdater;
    private View2ViewAnimations view2ViewAnimations;
    private ViewHandlerServicesImpl viewHandlerServicesImpl;
    static /* synthetic */ Class class$de$vw$mib$viewmanager$internal$popup$PopupInformationTable;
    static /* synthetic */ Class class$de$vw$mib$view$internal$ViewHandlerServices;
    static /* synthetic */ Class class$de$vw$mib$skin$SkinAnimationUpdater;
    static /* synthetic */ Class class$de$vw$mib$skin$V2vAnimationIndexProvider;
    static /* synthetic */ Class class$de$vw$mib$viewmanager$internal$ViewHandlerFactory;
    static /* synthetic */ Class class$de$vw$mib$view$internal$GlobalViewHandlerRegister;

    public Activator() {
        this.HMI_CHECKSUM = -819427125;
    }

    @Override
    public void preload(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        this.preloaded = this.preloaded == 2 ? 2 : 1;
        this.loggerFactory = (LoggerFactory)this.getService("de.vw.mib.log4mib.LoggerFactory");
        this.perfService = (PerfService)this.getService("de.vw.mib.perf.service.PerfService");
        this.configurationManager = (ConfigurationManager)this.getService("de.vw.mib.configuration.ConfigurationManager");
        this.fileManager = (FileManager)this.getService("de.vw.mib.file.FileManager");
        this.fixFormat = (FixFormat)this.getService("de.vw.mib.format.FixFormat");
        this.i18nDatapool = (I18nDatapool)this.getService("de.vw.mib.datapool.I18nDatapool");
        this.modelDatapool = (ModelDatapool)this.getService("de.vw.mib.datapool.ModelDatapool");
        this.skinAnimationPool = (SkinAnimationPool)this.getService("de.vw.mib.skin.SkinAnimationPool");
        this.skinImagePool = (SkinImagePool)this.getService("de.vw.mib.skin.SkinImagePool");
        this.dynamicListItemControlManager = (DynamicListItemControlManager)this.getService("de.vw.mib.datapool.DynamicListItemControlManager");
        this.globalExpressionEvaluator = (GlobalExpressionEvaluator)this.getService("de.vw.mib.datapool.GlobalExpressionEvaluator");
        this.skinResourceUpdaterRegister = (SkinResourceUpdaterRegister)this.getService("de.vw.mib.skin.SkinResourceUpdaterRegister");
        this.preloadSetup();
        this.bundleContext.registerService((class$de$vw$mib$viewmanager$internal$popup$PopupInformationTable == null ? (class$de$vw$mib$viewmanager$internal$popup$PopupInformationTable = Activator.class$("de.vw.mib.viewmanager.internal.popup.PopupInformationTable")) : class$de$vw$mib$viewmanager$internal$popup$PopupInformationTable).getName(), (Object)this.popupInformationTable, null);
        this.bundleContext.registerService((class$de$vw$mib$view$internal$ViewHandlerServices == null ? (class$de$vw$mib$view$internal$ViewHandlerServices = Activator.class$("de.vw.mib.view.internal.ViewHandlerServices")) : class$de$vw$mib$view$internal$ViewHandlerServices).getName(), (Object)this.viewHandlerServicesImpl, null);
        this.bundleContext.registerService((class$de$vw$mib$skin$SkinAnimationUpdater == null ? (class$de$vw$mib$skin$SkinAnimationUpdater = Activator.class$("de.vw.mib.skin.SkinAnimationUpdater")) : class$de$vw$mib$skin$SkinAnimationUpdater).getName(), (Object)this.skinAnimationUpdater, null);
        this.bundleContext.registerService((class$de$vw$mib$skin$V2vAnimationIndexProvider == null ? (class$de$vw$mib$skin$V2vAnimationIndexProvider = Activator.class$("de.vw.mib.skin.V2vAnimationIndexProvider")) : class$de$vw$mib$skin$V2vAnimationIndexProvider).getName(), (Object)this.view2ViewAnimations, null);
        this.bundleContext.registerService(new String[]{(class$de$vw$mib$viewmanager$internal$ViewHandlerFactory == null ? (class$de$vw$mib$viewmanager$internal$ViewHandlerFactory = Activator.class$("de.vw.mib.viewmanager.internal.ViewHandlerFactory")) : class$de$vw$mib$viewmanager$internal$ViewHandlerFactory).getName(), (class$de$vw$mib$view$internal$GlobalViewHandlerRegister == null ? (class$de$vw$mib$view$internal$GlobalViewHandlerRegister = Activator.class$("de.vw.mib.view.internal.GlobalViewHandlerRegister")) : class$de$vw$mib$view$internal$GlobalViewHandlerRegister).getName()}, (Object)this.globalViewHandlerFactoryImpl, null);
        String string = "(objectClass=de.vw.mib.cio.framework.ScriptWidgetCioService)";
        this.bundleContext.addServiceListener(this, string);
        String string2 = null;
        ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences(string2, string);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        Object object;
        if (1 == serviceEvent.getType() && (object = this.bundleContext.getService(serviceEvent.getServiceReference())) instanceof ScriptWidgetCioService && this.scriptWidgetCioService == null) {
            this.scriptWidgetCioService = (ScriptWidgetCioService)object;
            --this.waitingListeners;
            this.listenerPartialSetup(this.waitingListeners == 0);
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        if (this.preloaded == 0) {
            this.preloaded = 2;
            this.preload(bundleContext);
        }
        this.startSetup();
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void preloadSetup() {
        this.popupInformationTable = new PopupInformationTableImpl(-819427125, this.loggerFactory);
        this.view2ViewAnimations = new View2ViewAnimations(this.loggerFactory);
        View2ViewAnimationsUpdaterImpl view2ViewAnimationsUpdaterImpl = new View2ViewAnimationsUpdaterImpl(this.view2ViewAnimations, -819427125, this.configurationManager, this.fileManager, this.perfService, this.loggerFactory);
        this.skinResourceUpdaterRegister.add(view2ViewAnimationsUpdaterImpl);
        this.skinAnimationUpdater = new SkinAnimationUpdaterImpl();
        ListControlCache listControlCache = new ListControlCache();
        WidgetAnimatorImpl widgetAnimatorImpl = new WidgetAnimatorImpl();
        boolean bl = this.preloaded == 1;
        WidgetTreeBuilderImpl widgetTreeBuilderImpl = WidgetTreeBuilderFactory.createBuilder(bl, this.configurationManager, this.fileManager, this.loggerFactory);
        this.viewHandlerServicesImpl = new ViewHandlerServicesImpl(this.fixFormat, this.globalExpressionEvaluator, this.i18nDatapool, listControlCache, this.dynamicListItemControlManager, this.loggerFactory, this.modelDatapool, this.skinAnimationPool, this.skinImagePool, widgetAnimatorImpl, widgetTreeBuilderImpl);
        this.globalViewHandlerFactoryImpl = new GlobalViewHandlerFactoryImpl(this.loggerFactory);
    }

    private void startSetup() {
    }

    private void listenerPartialSetup(boolean bl) {
        if (bl) {
            AbstractScriptWidget.setup(this.fixFormat, this.scriptWidgetCioService, this.loggerFactory);
        }
    }

    private Object getService(String string) {
        Object object;
        ServiceReference serviceReference = this.bundleContext.getServiceReference(string);
        if (serviceReference == null) {
            this.missingService(string);
        }
        if ((object = this.bundleContext.getService(serviceReference)) == null) {
            this.missingService(string);
        }
        return object;
    }

    private void missingService(String string) {
        throw new IllegalStateException(new StringBuffer().append("Service '").append(string).append("' not available.").toString());
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

