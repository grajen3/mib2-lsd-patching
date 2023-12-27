/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.admin;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.dsi.admin.DSIAdmin$AgentCustomizer;
import de.esolutions.fw.dsi.admin.IProviderService;
import de.esolutions.fw.dsi.admin.ProviderTracker;
import de.esolutions.fw.dsi.admin.ServiceStateMap;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import de.esolutions.fw.dsi.base.IProvider;
import de.esolutions.fw.dsi.base.IProviderStateListener;
import de.esolutions.fw.dsi.comm.DSIServiceWorker;
import de.esolutions.fw.dsi.comm.IDSIServiceWorker;
import de.esolutions.fw.dsi.comm.SimpleDSIServiceWorker;
import de.esolutions.fw.dsi.config.AdapterConfig;
import de.esolutions.fw.dsi.config.AdapterConfig$ServiceInfo;
import de.esolutions.fw.dsi.diag.AdapterDiagnosis;
import de.esolutions.fw.dsi.diag.DiagnosisReportGenerator;
import de.esolutions.fw.dsi.diag.IAdapterDiagnosis;
import de.esolutions.fw.dsi.tracing.Channels;
import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.commons.job.IDispatcherManager;
import de.esolutions.fw.util.tracing.TraceChannel;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.ServiceAdmin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class DSIAdmin
implements ServiceAdmin,
IProviderStateListener,
IProviderService {
    private BundleContext bundleContext;
    private Agent agent;
    private TraceChannel tracer;
    private final ServiceStateMap svcMap;
    private AdapterConfig$ServiceInfo[] serviceInfos;
    private IDispatcherManager dispatcherManager;
    private ServiceRegistration serviceAdminRegistration;
    private ServiceRegistration adminRegistration;
    private ServiceRegistration dsiBootRegistration;
    private static final String ADMIN_INSTANCE;
    private HashMap sharedServiceWorkers = new HashMap();
    private boolean useSimpleWorker;
    private List providerList = new ArrayList();
    private Map dispatcherMap = new HashMap();
    private String[] serviceBlacklist;
    private IAdapterDiagnosis diagnosis;
    static /* synthetic */ Class class$de$esolutions$fw$comm$agent$Agent;
    static /* synthetic */ Class class$org$osgi$framework$BundleContext;
    static /* synthetic */ Class class$de$esolutions$fw$dsi$base$IDispatcher;
    static /* synthetic */ Class class$org$dsi$ifc$base$ServiceAdmin;
    static /* synthetic */ Class class$org$dsi$ifc$admin$JDSIAdmin;
    static /* synthetic */ Class class$org$dsi$ifc$boot$DSIBoot;

    public DSIAdmin(BundleContext bundleContext, IDispatcherManager iDispatcherManager) {
        Object object;
        this.bundleContext = bundleContext;
        this.dispatcherManager = iDispatcherManager;
        this.svcMap = new ServiceStateMap();
        this.tracer = Channels.DSI_ADMIN;
        this.diagnosis = new AdapterDiagnosis(this);
        this.tracer.log((short)0, "DSIAdmin Starting.");
        try {
            object = AdapterConfig.getInstance();
            this.serviceInfos = ((AdapterConfig)object).getServiceInfos();
            this.useSimpleWorker = ((AdapterConfig)object).getUseSimplerWorker();
            this.serviceBlacklist = ((AdapterConfig)object).getServiceBlacklist();
        }
        catch (Exception exception) {
            this.tracer.log((short)4, "Couldn't load adapter properties: error=%1", (Object)exception.getMessage());
        }
        this.tracer.log((short)0, "Waiting for COMM Agent registration.");
        object = new ServiceTracker(bundleContext, (class$de$esolutions$fw$comm$agent$Agent == null ? (class$de$esolutions$fw$comm$agent$Agent = DSIAdmin.class$("de.esolutions.fw.comm.agent.Agent")) : class$de$esolutions$fw$comm$agent$Agent).getName(), (ServiceTrackerCustomizer)new DSIAdmin$AgentCustomizer(this, null));
        ((ServiceTracker)object).open();
    }

    public IDispatcher findDispatcher(String string) {
        IDispatcher iDispatcher = (IDispatcher)this.dispatcherMap.get(string);
        return iDispatcher;
    }

    public static String generateMapKey(String string, int n) {
        String string2 = new StringBuffer().append(string).append("+").append(n).toString();
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean startService(String string, int n) {
        boolean bl = false;
        if (this.agent == null) {
            this.tracer.log((short)4, "DSI Provider not created since COMM agent not available: name=%1, instance=%2", (Object)string, (Object)String.valueOf(n));
            return bl;
        }
        if (this.isServiceInBlacklist(string)) {
            Channels.BENCH_STARTUP.log((short)2, "DSIAdapter.startService(%1,%2) service is blacklisted, startService was ignored ", (Object)string, (Object)new Integer(n));
            return false;
        }
        Channels.BENCH_STARTUP.log((short)2, "DSIAdapter.startService(%1,%2)", (Object)string, (Object)new Integer(n));
        String string2 = this.getGeneratedClassName(string, "Provider");
        bl = this.svcMap.checkAndAddService(string2, n);
        if (!bl) {
            Channels.SERVICE_STATE.log((short)2, "Already addedService: name=%1, instance=%2, in_state=%3", (Object)string, (Object)String.valueOf(n), (Object)this.svcMap.getServiceState(string, n));
            this.tracer.log((short)2, "already started DSI Provider: name=%1, instance=%2", (Object)string, (Object)String.valueOf(n));
            return true;
        }
        Channels.SERVICE_STATE.log((short)2, "addedService: name=%1, instance=%2", (Object)string, (Object)String.valueOf(n));
        this.tracer.log((short)2, "starting DSI Provider: name=%1, instance=%2", (Object)string, (Object)String.valueOf(n));
        try {
            String string3 = AdapterConfig.getInstance().getDispatcherName(string, n);
            boolean bl2 = false;
            if (string3 == null) {
                string3 = this.getDefaultJobDispatcherName(string, n);
            } else {
                bl2 = true;
            }
            this.tracer.log((short)1, "associating job dispatcher \"%1\" with DSI service \"%2:%3\"", (Object)string3, (Object)string, (Object)String.valueOf(n));
            IDispatcher iDispatcher = this.createDispatcher(string, n);
            IProvider iProvider = this.createProvider(string, string2, n, iDispatcher);
            this.tracer.log((short)0, "get service worker for service \"%1:%2\"", (Object)string, (Object)String.valueOf(n));
            IDSIServiceWorker iDSIServiceWorker = this.getServiceWorker(string3, bl2);
            boolean bl3 = AdapterConfig.getInstance().isEarlyRegistrationService(string, n);
            this.tracer.log((short)0, "start provider for service \"%1:%2\"", (Object)string, (Object)String.valueOf(n));
            iProvider.addProviderStateListener(this);
            iProvider.startProvider(bl3, iDSIServiceWorker);
            this.tracer.log((short)2, "DSI Provider started and waiting for connection: name=%1, instance=%2", (Object)string, (Object)String.valueOf(n));
            return bl;
        }
        catch (ClassNotFoundException classNotFoundException) {
            this.tracer.log((short)4, "Could not start service since DSI Provider or Dispatcher class not found: className=%1", (Object)classNotFoundException.getMessage());
            this.svcMap.removeService(string2, n);
            return false;
        }
        catch (Exception exception) {
            this.tracer.log((short)4, "Error during service DSI Provider start: name=%1, instance=%2, error=%3", (Object)string, (Object)String.valueOf(n), (Object)exception.getMessage());
            this.tracer.log((short)4, "%1", exception);
            this.svcMap.removeService(string2, n);
            return false;
        }
    }

    private IProvider createProvider(String string, String string2, int n, IDispatcher iDispatcher) {
        this.tracer.log((short)0, "creating provider for service \"%1:%2\"", (Object)string, (Object)String.valueOf(n));
        Class clazz = Class.forName(string2);
        Constructor constructor = clazz.getConstructor(new Class[]{Integer.TYPE, class$org$osgi$framework$BundleContext == null ? (class$org$osgi$framework$BundleContext = DSIAdmin.class$("org.osgi.framework.BundleContext")) : class$org$osgi$framework$BundleContext, class$de$esolutions$fw$comm$agent$Agent == null ? (class$de$esolutions$fw$comm$agent$Agent = DSIAdmin.class$("de.esolutions.fw.comm.agent.Agent")) : class$de$esolutions$fw$comm$agent$Agent, class$de$esolutions$fw$dsi$base$IDispatcher == null ? (class$de$esolutions$fw$dsi$base$IDispatcher = DSIAdmin.class$("de.esolutions.fw.dsi.base.IDispatcher")) : class$de$esolutions$fw$dsi$base$IDispatcher});
        Object[] objectArray = new Object[]{new Integer(n), this.bundleContext, this.agent, iDispatcher};
        IProvider iProvider = (IProvider)constructor.newInstance(objectArray);
        ((AbstractProvider)iProvider).setErrorLog(this.diagnosis.getErrorLog());
        ((AbstractProvider)iProvider).setProviderService(this);
        ((AbstractProvider)iProvider).setClassName(string);
        this.providerList.add(iProvider);
        return iProvider;
    }

    private IDispatcher createDispatcher(String string, int n) {
        this.tracer.log((short)0, "creating dispatcher for service \"%1:%2\"", (Object)string, (Object)String.valueOf(n));
        String string2 = this.getGeneratedClassName(string, "Dispatcher");
        Class clazz = Class.forName(string2);
        Constructor constructor = clazz.getConstructor(new Class[]{Integer.TYPE});
        Object[] objectArray = new Object[]{new Integer(n)};
        IDispatcher iDispatcher = (IDispatcher)constructor.newInstance(objectArray);
        ((AbstractDispatcher)iDispatcher).setErrorLog(this.diagnosis.getErrorLog());
        String string3 = DSIAdmin.generateMapKey(string, n);
        this.dispatcherMap.put(string3, iDispatcher);
        return iDispatcher;
    }

    @Override
    public boolean stopService(String string, int n) {
        if (this.isServiceInBlacklist(string)) {
            Channels.BENCH_STARTUP.log((short)2, "DSIAdapter.stopService(%1,%2) service is blacklisted, stopService was ignored ", (Object)string, (Object)new Integer(n));
            return false;
        }
        boolean bl = false;
        String string2 = this.getGeneratedClassName(string, "Provider");
        Channels.BENCH_STARTUP.log((short)2, "DSIAdapter.stopService(%1,%2)", (Object)string, (Object)new Integer(n));
        Boolean bl2 = this.svcMap.checkAndSetStopFlag(string2, n);
        if (bl2 == null) {
            Channels.SERVICE_STATE.log((short)3, "No service for setStopFlag: name=%1 instance=%2", (Object)string2, (Object)new Integer(n));
        } else if (bl2.booleanValue()) {
            Channels.SERVICE_STATE.log((short)2, "setStopFlag: name=%1 instance=%2", (Object)string2, (Object)new Integer(n));
            this.tracer.log((short)1, "Stopping service \"%1.%2\"", (Object)string, (Object)String.valueOf(n));
            ServiceReference serviceReference = ProviderTracker.getInstance().getDSIProvider(string, (short)n);
            if (serviceReference != null) {
                DSIBase dSIBase = (DSIBase)this.bundleContext.getService(serviceReference);
                if (dSIBase != null) {
                    if (dSIBase instanceof IProvider) {
                        IProvider iProvider = (IProvider)((Object)dSIBase);
                        IDSIServiceWorker iDSIServiceWorker = iProvider.stopProvider();
                        this.stopServiceWorker(iDSIServiceWorker);
                        bl = true;
                        this.tracer.log((short)2, "DSI Provider stopped: className=%1, instance=%2", (Object)string, (Object)Integer.toString(n));
                    } else {
                        this.tracer.log((short)4, "DSI Provider Instance not an IProvider: className=%1, instance=%2", (Object)string, (Object)Integer.toString(n));
                    }
                    this.bundleContext.ungetService(serviceReference);
                } else {
                    this.tracer.log((short)4, "DSI Provider ServiceInstance not found: className=%1, instance=%2", (Object)string, (Object)Integer.toString(n));
                }
            } else {
                this.tracer.log((short)2, "DSI Provider ServiceRef not found: className=%1, instance=%2", (Object)string, (Object)Integer.toString(n));
            }
            if (!bl) {
                this.tracer.log((short)0, "DSI Provider not stopped since provider not available, stop flag set: className=%1, instance=%2", (Object)string, (Object)Integer.toString(n));
            }
        } else {
            Channels.SERVICE_STATE.log((short)2, "Already setStopFlag: name=%1 instance=%2", (Object)string2, (Object)new Integer(n));
        }
        return bl;
    }

    public boolean restartService(String string, int n) {
        this.stopService(string, n);
        return this.startService(string, n);
    }

    private void startEarlyProviders() {
        if (this.serviceInfos != null) {
            this.tracer.log((short)0, "Early starup of DSI Providers.");
            for (int i2 = 0; i2 < this.serviceInfos.length; ++i2) {
                if (!this.serviceInfos[i2].isEarlyStartup()) continue;
                String string = this.serviceInfos[i2].getInterfaceName();
                int n = this.serviceInfos[i2].getInstance();
                if (string != null) {
                    this.tracer.log((short)2, "Early DSI start of: name=%1, instance=%2", (Object)string, (Object)String.valueOf(n));
                    try {
                        this.startService(string, n);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    continue;
                }
                this.tracer.log((short)4, "Incorrect DSI service configuration: name=NULL, instance=%1", (Object)String.valueOf(n));
            }
        }
    }

    private final String baseNameFromFQCN(String string) {
        String[] stringArray = StringUtils.splitString(string, '.');
        String string2 = stringArray[stringArray.length - 1];
        if (string2.startsWith("DSI")) {
            return string2.substring(3);
        }
        return string2;
    }

    private String getGeneratedClassName(String string, String string2) {
        String string3;
        String string4 = "de.esolutions.fw";
        if (string.startsWith("org.dsi.ifc")) {
            String[] stringArray = StringUtils.splitString(string, '.');
            String string5 = stringArray[stringArray.length - 2];
            String string6 = stringArray[stringArray.length - 1].substring(3);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(string4).append('.');
            stringBuffer.append("dsi.").append(string5).append('.');
            stringBuffer.append("DSI").append(string6).append(string2);
            string3 = stringBuffer.toString();
        } else {
            string3 = new StringBuffer().append(string).append(string2).toString();
        }
        return string3;
    }

    private boolean isServiceInBlacklist(String string) {
        if (this.serviceBlacklist != null) {
            for (int i2 = 0; i2 < this.serviceBlacklist.length; ++i2) {
                if (!this.serviceBlacklist[i2].equals(string)) continue;
                return true;
            }
        }
        return false;
    }

    private final String getDefaultJobDispatcherName(String string, int n) {
        return new StringBuffer().append("dsi.").append(this.baseNameFromFQCN(string)).append(".").append(String.valueOf(n)).toString();
    }

    public String[] diagnoseGetSummaryReceivedStreams() {
        this.tracer.log((short)4, "Method 'diagnoseGetSummaryReceivedStreams' is not implemented yet.");
        return null;
    }

    private synchronized IDSIServiceWorker getServiceWorker(String string, boolean bl) {
        IDSIServiceWorker iDSIServiceWorker = null;
        if (bl) {
            iDSIServiceWorker = (IDSIServiceWorker)this.sharedServiceWorkers.get(string);
            if (iDSIServiceWorker == null) {
                iDSIServiceWorker = this.createServiceWorker(string);
                this.sharedServiceWorkers.put(string, iDSIServiceWorker);
            }
        } else {
            iDSIServiceWorker = this.createServiceWorker(string);
        }
        return iDSIServiceWorker;
    }

    private IDSIServiceWorker createServiceWorker(String string) {
        if (this.useSimpleWorker) {
            return new SimpleDSIServiceWorker(string);
        }
        return new DSIServiceWorker(string, this.dispatcherManager);
    }

    private void registerAdminService(BundleContext bundleContext) {
        String string = AdapterConfig.getInstance().getServiceManager();
        this.tracer.log((short)1, "registering the admin service \"%1\".", (Object)string);
        Properties properties = new Properties();
        if (string.equals("ServiceAdmin")) {
            properties.put("DEVICE_NAME", (class$org$dsi$ifc$base$ServiceAdmin == null ? (class$org$dsi$ifc$base$ServiceAdmin = DSIAdmin.class$("org.dsi.ifc.base.ServiceAdmin")) : class$org$dsi$ifc$base$ServiceAdmin).getName());
            properties.put("DEVICE_INSTANCE", "0");
            this.serviceAdminRegistration = bundleContext.registerService((class$org$dsi$ifc$base$ServiceAdmin == null ? (class$org$dsi$ifc$base$ServiceAdmin = DSIAdmin.class$("org.dsi.ifc.base.ServiceAdmin")) : class$org$dsi$ifc$base$ServiceAdmin).getName(), (Object)this, (Dictionary)properties);
            Channels.DSI_ADMIN.log((short)1, "DSI Adapter registered as ServiceAdmin OSGi service.");
        } else if (string.equals("JDSIAdmin")) {
            properties.put("DEVICE_NAME", (class$org$dsi$ifc$admin$JDSIAdmin == null ? (class$org$dsi$ifc$admin$JDSIAdmin = DSIAdmin.class$("org.dsi.ifc.admin.JDSIAdmin")) : class$org$dsi$ifc$admin$JDSIAdmin).getName());
            properties.put("DEVICE_INSTANCE", "0");
            this.adminRegistration = bundleContext.registerService((class$org$dsi$ifc$admin$JDSIAdmin == null ? (class$org$dsi$ifc$admin$JDSIAdmin = DSIAdmin.class$("org.dsi.ifc.admin.JDSIAdmin")) : class$org$dsi$ifc$admin$JDSIAdmin).getName(), (Object)this, (Dictionary)properties);
            Channels.DSI_ADMIN.log((short)1, "DSI Adapter registered as JDSIAdmin OSGi service.");
        } else if (string.equals("DSIBoot")) {
            properties.put("DEVICE_NAME", (class$org$dsi$ifc$boot$DSIBoot == null ? (class$org$dsi$ifc$boot$DSIBoot = DSIAdmin.class$("org.dsi.ifc.boot.DSIBoot")) : class$org$dsi$ifc$boot$DSIBoot).getName());
            properties.put("DEVICE_INSTANCE", "0");
            this.dsiBootRegistration = bundleContext.registerService((class$org$dsi$ifc$boot$DSIBoot == null ? (class$org$dsi$ifc$boot$DSIBoot = DSIAdmin.class$("org.dsi.ifc.boot.DSIBoot")) : class$org$dsi$ifc$boot$DSIBoot).getName(), (Object)this, (Dictionary)properties);
            Channels.DSI_ADMIN.log((short)1, "DSI Adapter registered as DSIBoot OSGi service.");
        } else {
            Channels.DSI_ADMIN.log((short)4, new StringBuffer().append("DSI Adapter not registered as OSGi service! Wrong service manager configuration: ").append(string).toString());
        }
    }

    public void stop(BundleContext bundleContext) {
        this.tracer.log((short)1, "unregistering the admin service.");
        if (this.serviceAdminRegistration != null) {
            this.serviceAdminRegistration.unregister();
        } else if (this.adminRegistration != null) {
            this.adminRegistration.unregister();
        } else if (this.dsiBootRegistration != null) {
            this.dsiBootRegistration.unregister();
        }
    }

    @Override
    public void onConnected(IProvider iProvider) {
        if (iProvider != null) {
            int n;
            String string = super.getClass().getName();
            if (this.svcMap.setServiceState(string, n = iProvider.getInstance(), 2)) {
                Channels.SERVICE_STATE.log((short)1, "CONNECTED: changedServiceState: name=%1 instance=%2 newState=PENDING", (Object)string, (Object)new Integer(n));
                this.svcMap.checkAndClearRestartFlag(string, n);
            } else {
                Channels.SERVICE_STATE.log((short)4, "CONNECTED: ERROR in changeServiceState: name=%1 instance=%2 newState=PENDING", (Object)string, (Object)new Integer(n));
            }
        }
    }

    @Override
    public void onDisconnected(IProvider iProvider) {
        if (iProvider != null) {
            String string = super.getClass().getName();
            int n = iProvider.getInstance();
            String string2 = ((AbstractProvider)iProvider).getClassName();
            this.providerList.remove(iProvider);
            IDispatcher iDispatcher = iProvider.getDispatcher();
            Boolean bl = this.svcMap.checkAndClearRestartFlag(string, n);
            if (iDispatcher != null) {
                String string3 = DSIAdmin.generateMapKey(string, n);
                this.dispatcherMap.remove(string3);
            }
            if (this.svcMap.removeService(string, n)) {
                Channels.SERVICE_STATE.log((short)1, "removedService: name=%1 instance=%2", (Object)string, (Object)new Integer(n));
            } else {
                Channels.SERVICE_STATE.log((short)4, "ERROR in removeServiceState: name=%1 instance=%2", (Object)string, (Object)new Integer(n));
            }
            Channels.DSI_ADMIN.log((short)2, "checkAndClearRestartFlag=%1", bl);
            if (bl != null && bl.booleanValue()) {
                this.startService(string2, n);
            }
        }
    }

    @Override
    public void onDisconnecting(IProvider iProvider) {
    }

    @Override
    public void onConnectionFailed(IProvider iProvider) {
    }

    @Override
    public void onConnectionLost(IProvider iProvider) {
        if (iProvider != null) {
            String string = super.getClass().getName();
            int n = iProvider.getInstance();
            this.svcMap.setServiceState(string, n, 0);
        }
    }

    @Override
    public void onConnecting(IProvider iProvider) {
    }

    public void writeDiagnosisReport(PrintStream printStream) {
        DiagnosisReportGenerator diagnosisReportGenerator = new DiagnosisReportGenerator(printStream, true);
        diagnosisReportGenerator.generateFullReport(this.diagnosis);
    }

    public List getProviderList() {
        return this.providerList;
    }

    public List getDispatcherList() {
        return new ArrayList(this.dispatcherMap.values());
    }

    public IAdapterDiagnosis getDiagnosis() {
        return this.diagnosis;
    }

    @Override
    public boolean checkAndClearStopFlag(String string, int n) {
        Boolean bl = this.svcMap.checkAndClearStopFlag(string, n);
        if (bl != null) {
            return bl;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void stopServiceWorker(IDSIServiceWorker iDSIServiceWorker) {
        if (iDSIServiceWorker != null && iDSIServiceWorker.getUseCount() == 0) {
            DSIAdmin dSIAdmin = this;
            synchronized (dSIAdmin) {
                Object object = this.sharedServiceWorkers.remove(iDSIServiceWorker.getName());
                if (object != null) {
                    this.tracer.log((short)1, "removed the shared service worker \"%1\"", (Object)iDSIServiceWorker.getName());
                }
            }
        }
    }

    static /* synthetic */ BundleContext access$000(DSIAdmin dSIAdmin) {
        return dSIAdmin.bundleContext;
    }

    static /* synthetic */ Agent access$102(DSIAdmin dSIAdmin, Agent agent) {
        dSIAdmin.agent = agent;
        return dSIAdmin.agent;
    }

    static /* synthetic */ TraceChannel access$200(DSIAdmin dSIAdmin) {
        return dSIAdmin.tracer;
    }

    static /* synthetic */ void access$300(DSIAdmin dSIAdmin, BundleContext bundleContext) {
        dSIAdmin.registerAdminService(bundleContext);
    }

    static /* synthetic */ void access$500(DSIAdmin dSIAdmin) {
        dSIAdmin.startEarlyProviders();
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

