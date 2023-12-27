/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.hmi.internal;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.datapool.DatapoolActivator;
import de.vw.mib.datapool.diag.DiagnoseDatapool;
import de.vw.mib.datapool.internal.ASLDatapoolImpl;
import de.vw.mib.datapool.internal.DynamicListItemControlManagerImpl;
import de.vw.mib.datapool.internal.I18nDatapoolImpl;
import de.vw.mib.datapool.internal.I18nTableDecoderImpl;
import de.vw.mib.datapool.internal.ScaledI18nDatapoolImpl;
import de.vw.mib.datapool.internal.ScaledI18nDatapoolUpdater;
import de.vw.mib.event.SystemEventIdMap;
import de.vw.mib.event.dispatcher.DatapoolEventDispatcher;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.file.FileManager;
import de.vw.mib.format.FixFormat;
import de.vw.mib.hmi.HmiEventIdMap;
import de.vw.mib.hmi.internal.DiagnoseDatapoolDispatcher;
import de.vw.mib.hmi.internal.PublicIdMapImpl;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.list.DynamicListManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.skin.internal.SkinAnimationPoolImpl;
import de.vw.mib.skin.internal.SkinAnimationPoolUpdaterImpl;
import de.vw.mib.skin.internal.SkinImagePoolImpl;
import de.vw.mib.skin.internal.SkinImagePoolUpdaterImpl;
import de.vw.mib.skin.internal.SkinResourceUpdaterRegisterImpl;
import de.vw.mib.startup.StartupManagerService;
import de.vw.mib.timer.TimerManager;
import generated.de.vw.mib.global.datapool.internal.DataPoolUpdate;
import generated.de.vw.mib.global.datapool.internal.DataPoolUpdateSetup;
import generated.de.vw.mib.global.datapool.internal.GlobalExpressionEvaluatorImpl;
import generated.de.vw.mib.global.datapool.internal.ModelDataPoolImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class Activator
extends DatapoolActivator
implements BundleActivatorExtension,
ServiceListener {
    public static final int HMI_CHECKSUM;
    private BundleContext bundleContext;
    private static final int DIRECT;
    private static final int INDIRECT;
    private int preloaded = 0;
    private int waitingListeners = 1;
    private ASLDatapool asldatapool;
    private DiagnoseDatapool diagnoseDatapool;
    private HmiEventIdMap hmiEventIdMap;
    private SkinResourceUpdaterRegisterImpl skinResourceUpdaterRegisterImpl;
    private SystemEventIdMap systemEventIdMap;
    private DataPoolUpdate dataPoolUpdate = null;
    static /* synthetic */ Class class$de$vw$mib$i18n$I18nTableDecoder;
    static /* synthetic */ Class class$de$vw$mib$hmi$HmiEventIdMap;
    static /* synthetic */ Class class$de$vw$mib$event$SystemEventIdMap;
    static /* synthetic */ Class class$de$vw$mib$datapool$I18nDatapool;
    static /* synthetic */ Class class$de$vw$mib$i18n$I18nGuiUpdater;
    static /* synthetic */ Class class$de$vw$mib$datapool$ModelDatapool;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$DatapoolEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$datapool$ASLDatapool;
    static /* synthetic */ Class class$de$vw$mib$datapool$DynamicListItemControlManager;
    static /* synthetic */ Class class$de$vw$mib$skin$SkinAnimationPool;
    static /* synthetic */ Class class$de$vw$mib$skin$SkinImagePool;
    static /* synthetic */ Class class$de$vw$mib$skin$SkinImagePoolUpdater;
    static /* synthetic */ Class class$de$vw$mib$skin$SkinResourceUpdaterRegister;
    static /* synthetic */ Class class$de$vw$mib$datapool$GlobalExpressionEvaluator;
    static /* synthetic */ Class class$de$vw$mib$datapool$diag$DiagnoseDatapool;

    @Override
    public void preload(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        this.preloaded = this.preloaded == 2 ? 2 : 1;
        ServiceManagerCommon.loggerFactory = (LoggerFactory)this.getService("de.vw.mib.log4mib.LoggerFactory");
        ServiceManagerCommon.fixFormat = (FixFormat)this.getService("de.vw.mib.format.FixFormat");
        ServiceManagerCommon.statemachineEventDispatcher = (StatemachineEventDispatcher)this.getService("de.vw.mib.event.dispatcher.StatemachineEventDispatcher");
        ServiceManagerCommon.startupManagerService = (StartupManagerService)this.getService("de.vw.mib.startup.StartupManagerService");
        ServiceManagerCommon.configurationManager = (ConfigurationManager)this.getService("de.vw.mib.configuration.ConfigurationManager");
        ServiceManagerCommon.fileManager = (FileManager)this.getService("de.vw.mib.file.FileManager");
        ServiceManagerCommon.perfService = (PerfService)this.getService("de.vw.mib.perf.service.PerfService");
        ServiceManagerCommon.datapoolEventDispatcher = (DatapoolEventDispatcher)this.getService("de.vw.mib.event.dispatcher.DatapoolEventDispatcher");
        ServiceManagerCommon.timerManager = (TimerManager)this.getService("de.vw.mib.timer.TimerManager");
        this.preloadSetup();
        this.bundleContext.registerService((class$de$vw$mib$i18n$I18nTableDecoder == null ? (class$de$vw$mib$i18n$I18nTableDecoder = Activator.class$("de.vw.mib.i18n.I18nTableDecoder")) : class$de$vw$mib$i18n$I18nTableDecoder).getName(), (Object)ServiceManagerCommon.i18nTableDecoder, null);
        this.bundleContext.registerService((class$de$vw$mib$hmi$HmiEventIdMap == null ? (class$de$vw$mib$hmi$HmiEventIdMap = Activator.class$("de.vw.mib.hmi.HmiEventIdMap")) : class$de$vw$mib$hmi$HmiEventIdMap).getName(), (Object)this.hmiEventIdMap, null);
        this.bundleContext.registerService((class$de$vw$mib$event$SystemEventIdMap == null ? (class$de$vw$mib$event$SystemEventIdMap = Activator.class$("de.vw.mib.event.SystemEventIdMap")) : class$de$vw$mib$event$SystemEventIdMap).getName(), (Object)this.systemEventIdMap, null);
        this.bundleContext.registerService(new String[]{(class$de$vw$mib$datapool$I18nDatapool == null ? (class$de$vw$mib$datapool$I18nDatapool = Activator.class$("de.vw.mib.datapool.I18nDatapool")) : class$de$vw$mib$datapool$I18nDatapool).getName(), (class$de$vw$mib$i18n$I18nGuiUpdater == null ? (class$de$vw$mib$i18n$I18nGuiUpdater = Activator.class$("de.vw.mib.i18n.I18nGuiUpdater")) : class$de$vw$mib$i18n$I18nGuiUpdater).getName()}, (Object)ServiceManagerCommon.i18nDatapool, null);
        this.bundleContext.registerService(new String[]{(class$de$vw$mib$datapool$ModelDatapool == null ? (class$de$vw$mib$datapool$ModelDatapool = Activator.class$("de.vw.mib.datapool.ModelDatapool")) : class$de$vw$mib$datapool$ModelDatapool).getName(), (class$de$vw$mib$event$consumer$DatapoolEventConsumer == null ? (class$de$vw$mib$event$consumer$DatapoolEventConsumer = Activator.class$("de.vw.mib.event.consumer.DatapoolEventConsumer")) : class$de$vw$mib$event$consumer$DatapoolEventConsumer).getName()}, (Object)ServiceManagerCommon.modelDatapool, null);
        this.bundleContext.registerService((class$de$vw$mib$datapool$ASLDatapool == null ? (class$de$vw$mib$datapool$ASLDatapool = Activator.class$("de.vw.mib.datapool.ASLDatapool")) : class$de$vw$mib$datapool$ASLDatapool).getName(), (Object)this.asldatapool, null);
        this.bundleContext.registerService((class$de$vw$mib$datapool$DynamicListItemControlManager == null ? (class$de$vw$mib$datapool$DynamicListItemControlManager = Activator.class$("de.vw.mib.datapool.DynamicListItemControlManager")) : class$de$vw$mib$datapool$DynamicListItemControlManager).getName(), (Object)ServiceManagerCommon.dynamicListItemControlManager, null);
        this.bundleContext.registerService((class$de$vw$mib$skin$SkinAnimationPool == null ? (class$de$vw$mib$skin$SkinAnimationPool = Activator.class$("de.vw.mib.skin.SkinAnimationPool")) : class$de$vw$mib$skin$SkinAnimationPool).getName(), (Object)ServiceManagerCommon.skinAnimationPool, null);
        this.bundleContext.registerService((class$de$vw$mib$skin$SkinImagePool == null ? (class$de$vw$mib$skin$SkinImagePool = Activator.class$("de.vw.mib.skin.SkinImagePool")) : class$de$vw$mib$skin$SkinImagePool).getName(), (Object)ServiceManagerCommon.skinImagePool, null);
        this.bundleContext.registerService(new String[]{(class$de$vw$mib$skin$SkinImagePoolUpdater == null ? (class$de$vw$mib$skin$SkinImagePoolUpdater = Activator.class$("de.vw.mib.skin.SkinImagePoolUpdater")) : class$de$vw$mib$skin$SkinImagePoolUpdater).getName(), (class$de$vw$mib$skin$SkinResourceUpdaterRegister == null ? (class$de$vw$mib$skin$SkinResourceUpdaterRegister = Activator.class$("de.vw.mib.skin.SkinResourceUpdaterRegister")) : class$de$vw$mib$skin$SkinResourceUpdaterRegister).getName()}, (Object)this.skinResourceUpdaterRegisterImpl, null);
        this.bundleContext.registerService((class$de$vw$mib$datapool$GlobalExpressionEvaluator == null ? (class$de$vw$mib$datapool$GlobalExpressionEvaluator = Activator.class$("de.vw.mib.datapool.GlobalExpressionEvaluator")) : class$de$vw$mib$datapool$GlobalExpressionEvaluator).getName(), (Object)ServiceManagerCommon.globalExpressionEvaluator, null);
        this.bundleContext.registerService((class$de$vw$mib$datapool$diag$DiagnoseDatapool == null ? (class$de$vw$mib$datapool$diag$DiagnoseDatapool = Activator.class$("de.vw.mib.datapool.diag.DiagnoseDatapool")) : class$de$vw$mib$datapool$diag$DiagnoseDatapool).getName(), (Object)this.diagnoseDatapool, null);
        String string = "(objectClass=de.vw.mib.list.DynamicListManager)";
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
        if (1 == serviceEvent.getType() && (object = this.bundleContext.getService(serviceEvent.getServiceReference())) instanceof DynamicListManager && ServiceManagerCommon.dynamicListManager == null) {
            ServiceManagerCommon.dynamicListManager = (DynamicListManager)object;
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
        this.setupDatapoolServiceManager(ServiceManagerCommon.loggerFactory, ServiceManagerCommon.datapoolEventDispatcher, ServiceManagerCommon.timerManager);
        ServiceManagerCommon.hmiChecksum = -819427125;
        ServiceManagerCommon.i18nTableDecoder = new I18nTableDecoderImpl(-1350234209, ServiceManagerCommon.fileManager, ServiceManagerCommon.loggerFactory, ServiceManagerCommon.perfService);
        ServiceManagerCommon.i18nDatapool = new I18nDatapoolImpl(ServiceManagerCommon.loggerFactory);
        ScaledI18nDatapoolImpl scaledI18nDatapoolImpl = new ScaledI18nDatapoolImpl(ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.loggerFactory);
        ScaledI18nDatapoolUpdater scaledI18nDatapoolUpdater = new ScaledI18nDatapoolUpdater(scaledI18nDatapoolImpl, ServiceManagerCommon.configurationManager, ServiceManagerCommon.i18nTableDecoder, ServiceManagerCommon.loggerFactory);
        scaledI18nDatapoolUpdater.startListening();
        scaledI18nDatapoolUpdater.updateLanguage();
        ServiceManagerCommon.scaledI18nDatapool = scaledI18nDatapoolImpl;
        PublicIdMapImpl publicIdMapImpl = new PublicIdMapImpl();
        this.hmiEventIdMap = publicIdMapImpl;
        this.systemEventIdMap = publicIdMapImpl;
        ServiceManagerCommon.perfService.performanceLogStartup(2, 1, 1);
        ModelDataPoolImpl modelDataPoolImpl = new ModelDataPoolImpl();
        ServiceManagerCommon.modelDatapool = modelDataPoolImpl;
        ServiceManagerCommon.perfService.performanceLogStartup(2, 1, 2);
        this.asldatapool = new ASLDatapoolImpl(modelDataPoolImpl, publicIdMapImpl);
        ServiceManagerCommon.dynamicListItemControlManager = new DynamicListItemControlManagerImpl();
        ServiceManagerCommon.skinAnimationPool = new SkinAnimationPoolImpl();
        ServiceManagerCommon.skinImagePool = new SkinImagePoolImpl();
        this.skinResourceUpdaterRegisterImpl = new SkinResourceUpdaterRegisterImpl();
        SkinImagePoolUpdaterImpl skinImagePoolUpdaterImpl = new SkinImagePoolUpdaterImpl((SkinImagePoolImpl)ServiceManagerCommon.skinImagePool, ServiceManagerCommon.configurationManager, ServiceManagerCommon.fileManager, ServiceManagerCommon.perfService, ServiceManagerCommon.loggerFactory);
        this.skinResourceUpdaterRegisterImpl.add(skinImagePoolUpdaterImpl);
        SkinAnimationPoolUpdaterImpl skinAnimationPoolUpdaterImpl = new SkinAnimationPoolUpdaterImpl((SkinAnimationPoolImpl)ServiceManagerCommon.skinAnimationPool, -819427125, ServiceManagerCommon.configurationManager, ServiceManagerCommon.fileManager, ServiceManagerCommon.perfService, ServiceManagerCommon.loggerFactory);
        this.skinResourceUpdaterRegisterImpl.add(skinAnimationPoolUpdaterImpl);
        ServiceManagerCommon.globalExpressionEvaluator = new GlobalExpressionEvaluatorImpl();
        ServiceManagerCommon.hmiThreadInvoker = ServiceManagerCommon.datapoolEventDispatcher;
        this.diagnoseDatapool = new DiagnoseDatapoolDispatcher();
    }

    private void listenerPartialSetup(boolean bl) {
        if (ServiceManagerCommon.dynamicListManager != null) {
            this.setupDatapoolServiceManager(ServiceManagerCommon.dynamicListManager);
        }
        if (this.dataPoolUpdate == null && ServiceManagerCommon.dynamicListManager != null) {
            this.dataPoolUpdate = new DataPoolUpdate();
            DataPoolUpdateSetup.bind(this.dataPoolUpdate);
        }
    }

    private void startSetup() {
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

