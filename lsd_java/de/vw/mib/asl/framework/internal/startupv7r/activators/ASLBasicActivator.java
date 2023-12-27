/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.activators;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.proxy.DSIProxyTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.skeleton.DSISkeletonTarget;
import de.vw.mib.asl.framework.internal.framework.reflection.util.StartupUtil;
import de.vw.mib.asl.framework.internal.startupv7r.AslTargetStartup;
import de.vw.mib.asl.framework.internal.startupv7r.activators.ASLBasicActivator$1;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.StartupServicesProvider;
import de.vw.mib.asl.internal.ASLDatapoolManager;
import de.vw.mib.collections.ints.IntBooleanOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.format.FixFormat4Asl;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.TaskInterface;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.graphics.image.ImageManager;
import de.vw.mib.log4mib.LogManagerDiag;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.timer.TimerManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class ASLBasicActivator
implements BundleActivatorExtension,
ServiceListener {
    private static final IntObjectMap TARGETID2CLASSNAME_MATCHING = new IntObjectOptHashMap(50);
    protected TaskInterface hsmTask = null;
    final ASLDatapoolManager datapoolManager;
    private static IntBooleanOptHashMap alreadyInstantiatedTargetsMap;
    static /* synthetic */ Class class$de$vw$mib$genericevents$GenericEvents;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LogManagerDiag;
    static /* synthetic */ Class class$de$vw$mib$error$ErrorHandler;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$SystemEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$format$FixFormat4Asl;
    static /* synthetic */ Class class$de$vw$mib$genericevents$EventFactory;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$StartupEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$error$ShowErrorPopupExecutor;
    static /* synthetic */ Class class$de$vw$mib$error$RebootExecutor;
    static /* synthetic */ Class class$de$vw$mib$error$SwitchToMenuExecutor;
    static /* synthetic */ Class class$de$vw$mib$perf$service$PerfService;
    static /* synthetic */ Class class$de$vw$mib$datapool$ASLDatapool;
    static /* synthetic */ Class class$de$vw$mib$graphics$image$ImageManager;

    public ASLBasicActivator() {
        if (null == ServiceManager.aslPropertyManager) {
            this.datapoolManager = new ASLDatapoolManager();
            ServiceManager.aslPropertyManager = this.datapoolManager;
        } else {
            this.datapoolManager = null;
        }
    }

    public static void fillTargetId2ClassNameMatchingTable(int n, String string) {
        TARGETID2CLASSNAME_MATCHING.put(n, new StringBuffer().append("de.vw.mib.").append(string).toString());
    }

    public static Object startTargetByTID(int n) {
        if (alreadyInstantiatedTargetsMap.containsKey(n)) {
            return null;
        }
        String string = (String)TARGETID2CLASSNAME_MATCHING.get(n);
        try {
            Class clazz = Class.forName(string);
            try {
                Class[] classArray = new Class[]{class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = ASLBasicActivator.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents, class$java$lang$String == null ? (class$java$lang$String = ASLBasicActivator.class$("java.lang.String")) : class$java$lang$String};
                Constructor constructor = clazz.getConstructor(classArray);
                return constructor.newInstance(new Object[]{ServiceManager.eventMain, "hsmtask"});
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Class[] classArray = new Class[]{class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = ASLBasicActivator.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents, Integer.TYPE, class$java$lang$String == null ? (class$java$lang$String = ASLBasicActivator.class$("java.lang.String")) : class$java$lang$String};
                Constructor constructor = clazz.getConstructor(classArray);
                return constructor.newInstance(new Object[]{ServiceManager.eventMain, new Integer(n), "hsmtask"});
            }
        }
        catch (InvocationTargetException invocationTargetException) {
            ServiceManager.logger.error(1).append("Could not create instance of  target class ").append(string).attachThrowable(invocationTargetException).log();
        }
        catch (Throwable throwable) {
            ServiceManager.logger.error(1).append("Could not create instance of  target class ").append(string).attachThrowable(throwable).log();
        }
        return null;
    }

    @Override
    public void preload(BundleContext bundleContext) {
        StartupEventDispatcher startupEventDispatcher;
        ServiceManager.bundleContext = bundleContext;
        ASLFactoryBase.bundleContext = bundleContext;
        ASLFactoryBase.logger = ServiceManager.logger = ((LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = ASLBasicActivator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()))).getLogger(1);
        ASLFactoryBase.logger2 = ServiceManager.logger2 = ((LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = ASLBasicActivator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()))).getLogger(32768);
        ServiceManager.logManagerDiag = (LogManagerDiag)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LogManagerDiag == null ? (class$de$vw$mib$log4mib$LogManagerDiag = ASLBasicActivator.class$("de.vw.mib.log4mib.LogManagerDiag")) : class$de$vw$mib$log4mib$LogManagerDiag).getName()));
        ServiceManager.errorHandler = (ErrorHandler)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$error$ErrorHandler == null ? (class$de$vw$mib$error$ErrorHandler = ASLBasicActivator.class$("de.vw.mib.error.ErrorHandler")) : class$de$vw$mib$error$ErrorHandler).getName()));
        ServiceManager.eventDispatcher = (SystemEventDispatcher)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$event$dispatcher$SystemEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$SystemEventDispatcher = ASLBasicActivator.class$("de.vw.mib.event.dispatcher.SystemEventDispatcher")) : class$de$vw$mib$event$dispatcher$SystemEventDispatcher).getName()));
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$format$FixFormat4Asl == null ? (class$de$vw$mib$format$FixFormat4Asl = ASLBasicActivator.class$("de.vw.mib.format.FixFormat4Asl")) : class$de$vw$mib$format$FixFormat4Asl).getName());
        if (null != serviceReference) {
            ServiceManager.fixFormat4Asl = (FixFormat4Asl)bundleContext.getService(serviceReference);
        }
        ServiceManager.eventMain = (GenericEvents)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = ASLBasicActivator.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents).getName()));
        ServiceManager.mGenericEventFactory = (EventFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$genericevents$EventFactory == null ? (class$de$vw$mib$genericevents$EventFactory = ASLBasicActivator.class$("de.vw.mib.genericevents.EventFactory")) : class$de$vw$mib$genericevents$EventFactory).getName()));
        ServiceManager.dsiTraceLogger = ((LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = ASLBasicActivator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()))).getLogger(16);
        StartupUtil.initialize();
        DSISkeletonTarget dSISkeletonTarget = new DSISkeletonTarget(bundleContext, ServiceManager.eventMain);
        DSIProxyTarget dSIProxyTarget = new DSIProxyTarget(dSISkeletonTarget);
        dSISkeletonTarget.startPeer();
        dSIProxyTarget.startPeer();
        ServiceManager.dsiServiceLocator = new DSIServiceLocator(dSISkeletonTarget, dSIProxyTarget, bundleContext);
        ServiceManager.timerManager = (TimerManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = ASLBasicActivator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()));
        ServiceManager.persistence = ASLPersistenceFactory.getPersistenceApi().createPersistenceInstance(ServiceManager.eventMain, 5120, "hsmtask");
        alreadyInstantiatedTargetsMap.put(5120, true);
        ServiceManager.startupEventDispatcher = startupEventDispatcher = (StartupEventDispatcher)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$event$dispatcher$StartupEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$StartupEventDispatcher = ASLBasicActivator.class$("de.vw.mib.event.dispatcher.StartupEventDispatcher")) : class$de$vw$mib$event$dispatcher$StartupEventDispatcher).getName()));
        AslTargetStartup aslTargetStartup = new AslTargetStartup(ServiceManager.eventMain, 5900, "hsmtask", StartupServicesProvider.getStartupServices());
        ServiceManager.bundleContext.registerService(new String[]{(class$de$vw$mib$error$ShowErrorPopupExecutor == null ? (class$de$vw$mib$error$ShowErrorPopupExecutor = ASLBasicActivator.class$("de.vw.mib.error.ShowErrorPopupExecutor")) : class$de$vw$mib$error$ShowErrorPopupExecutor).getName(), (class$de$vw$mib$error$RebootExecutor == null ? (class$de$vw$mib$error$RebootExecutor = ASLBasicActivator.class$("de.vw.mib.error.RebootExecutor")) : class$de$vw$mib$error$RebootExecutor).getName(), (class$de$vw$mib$error$SwitchToMenuExecutor == null ? (class$de$vw$mib$error$SwitchToMenuExecutor = ASLBasicActivator.class$("de.vw.mib.error.SwitchToMenuExecutor")) : class$de$vw$mib$error$SwitchToMenuExecutor).getName()}, (Object)aslTargetStartup, null);
        this.registerServiceListener(bundleContext);
    }

    public static Object startTargetByNameOnNonPreloadTarget(String string, int n) {
        alreadyInstantiatedTargetsMap.put(n, true);
        return ASLBasicActivator.startTargetByName(string, n);
    }

    public static Object startTargetByName(String string, int n) {
        Class clazz = Class.forName(string);
        try {
            Class[] classArray = new Class[]{class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = ASLBasicActivator.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents, class$java$lang$String == null ? (class$java$lang$String = ASLBasicActivator.class$("java.lang.String")) : class$java$lang$String};
            Constructor constructor = clazz.getConstructor(classArray);
            return constructor.newInstance(new Object[]{ServiceManager.eventMain, "hsmtask"});
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Class[] classArray = new Class[]{class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = ASLBasicActivator.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents, Integer.TYPE, class$java$lang$String == null ? (class$java$lang$String = ASLBasicActivator.class$("java.lang.String")) : class$java$lang$String};
            Constructor constructor = clazz.getConstructor(classArray);
            return constructor.newInstance(new Object[]{ServiceManager.eventMain, new Integer(n), "hsmtask"});
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        ServiceManager.perfService = (PerfService)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$perf$service$PerfService == null ? (class$de$vw$mib$perf$service$PerfService = ASLBasicActivator.class$("de.vw.mib.perf.service.PerfService")) : class$de$vw$mib$perf$service$PerfService).getName()));
        ServiceManager.eventMain.getEventDispatcher().send(ServiceManager.mGenericEventFactory.newEvent(0, 5900, 106));
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void registerServiceListener(BundleContext bundleContext) {
        StringBuffer stringBuffer = new StringBuffer(98);
        stringBuffer.append("(|");
        if (null != this.datapoolManager) {
            stringBuffer.append("(").append("objectClass").append("=").append((class$de$vw$mib$datapool$ASLDatapool == null ? (class$de$vw$mib$datapool$ASLDatapool = ASLBasicActivator.class$("de.vw.mib.datapool.ASLDatapool")) : class$de$vw$mib$datapool$ASLDatapool).getName()).append(")");
        }
        stringBuffer.append("(").append("objectClass").append("=").append((class$de$vw$mib$graphics$image$ImageManager == null ? (class$de$vw$mib$graphics$image$ImageManager = ASLBasicActivator.class$("de.vw.mib.graphics.image.ImageManager")) : class$de$vw$mib$graphics$image$ImageManager).getName()).append(")");
        stringBuffer.append("(").append("objectClass").append("=").append((class$de$vw$mib$format$FixFormat4Asl == null ? (class$de$vw$mib$format$FixFormat4Asl = ASLBasicActivator.class$("de.vw.mib.format.FixFormat4Asl")) : class$de$vw$mib$format$FixFormat4Asl).getName()).append(")");
        stringBuffer.append(")");
        String string = stringBuffer.toString();
        bundleContext.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = bundleContext.getServiceReferences(null, string);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        switch (serviceEvent.getType()) {
            case 1: {
                Object object = ServiceManager.bundleContext.getService(serviceEvent.getServiceReference());
                if (object instanceof ImageManager) {
                    ServiceManager.imageManager = (ImageManager)object;
                    break;
                }
                if (object instanceof ASLDatapool) {
                    if (null == this.datapoolManager) break;
                    this.applyDatapool((ASLDatapool)object);
                    break;
                }
                if (!(object instanceof FixFormat4Asl)) break;
                ServiceManager.fixFormat4Asl = (FixFormat4Asl)object;
                break;
            }
        }
    }

    private void applyDatapool(ASLDatapool aSLDatapool) {
        ThreadSwitchingTarget threadSwitchingTarget = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLThreadSwitch();
        threadSwitchingTarget.enqueue(new ASLBasicActivator$1(this, aSLDatapool));
    }

    public static IntObjectMap getTargetid2classnameMatching() {
        return TARGETID2CLASSNAME_MATCHING;
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
        TARGETID2CLASSNAME_MATCHING.put(7800, "de.vw.mib.asl.internal.connectivity.HsmTargetWLAN");
        TARGETID2CLASSNAME_MATCHING.put(7801, "de.vw.mib.asl.internal.connectivity.TargetASLNetworking");
        TARGETID2CLASSNAME_MATCHING.put(5281, "de.vw.mib.asl.internal.phone.TargetASLPhoneHAS");
        TARGETID2CLASSNAME_MATCHING.put(5257, "de.vw.mib.asl.internal.phone.bluetooth.HsmPhoneBluetoothInquiry");
        TARGETID2CLASSNAME_MATCHING.put(5266, "de.vw.mib.asl.internal.phone.bluetooth.TargetASLPhoneBluetoothObex");
        TARGETID2CLASSNAME_MATCHING.put(5258, "de.vw.mib.asl.internal.phone.bluetooth.TargetASLPhoneBluetoothPasskey");
        TARGETID2CLASSNAME_MATCHING.put(5259, "de.vw.mib.asl.internal.phone.bluetooth.HsmPhoneBluetoothServiceConnect");
        TARGETID2CLASSNAME_MATCHING.put(5267, "de.vw.mib.asl.internal.phone.bluetooth.TargetASLPhoneBluetoothObjectPush");
        TARGETID2CLASSNAME_MATCHING.put(5254, "de.vw.mib.asl.internal.phone.call.HsmPhoneCallHandling");
        TARGETID2CLASSNAME_MATCHING.put(5255, "de.vw.mib.asl.internal.phone.callstacks.TargetASLPhoneCallStacks");
        TARGETID2CLASSNAME_MATCHING.put(5261, "de.vw.mib.asl.internal.phone.contacts.HsmPhoneContactsHandling");
        TARGETID2CLASSNAME_MATCHING.put(5268, "de.vw.mib.asl.internal.phone.contacts.HsmPhoneContactsSearchHandling");
        TARGETID2CLASSNAME_MATCHING.put(5271, "de.vw.mib.asl.internal.phone.contacts.HsmPhoneContactsEditHandling");
        TARGETID2CLASSNAME_MATCHING.put(5264, "de.vw.mib.asl.internal.phone.presets.HsmPhonePresetsHandling");
        TARGETID2CLASSNAME_MATCHING.put(5256, "de.vw.mib.asl.internal.phone.selection.TargetASLPhoneSelection");
        TARGETID2CLASSNAME_MATCHING.put(5260, "de.vw.mib.asl.internal.phone.setup.bluetooth.TargetASLPhoneBluetoothSetup");
        TARGETID2CLASSNAME_MATCHING.put(5265, "de.vw.mib.asl.internal.phone.setup.call.TargetASLPhoneCallSetup");
        TARGETID2CLASSNAME_MATCHING.put(5269, "de.vw.mib.asl.internal.phone.setup.call.HsmPhoneSetupQueryNetworkHandling");
        TARGETID2CLASSNAME_MATCHING.put(5263, "de.vw.mib.asl.internal.phone.setup.settings.TargetASLPhoneSetupSettings");
        TARGETID2CLASSNAME_MATCHING.put(5262, "de.vw.mib.asl.internal.phone.setup.HsmPhoneRingtoneHandling");
        TARGETID2CLASSNAME_MATCHING.put(5253, "de.vw.mib.asl.internal.phone.setup.TargetASLPhoneSetup");
        TARGETID2CLASSNAME_MATCHING.put(5250, "de.vw.mib.asl.internal.phone.TargetASLPhoneGetter");
        TARGETID2CLASSNAME_MATCHING.put(5251, "de.vw.mib.asl.internal.phone.HsmPhonePhoneAvailability");
        TARGETID2CLASSNAME_MATCHING.put(5252, "de.vw.mib.asl.internal.phone.TargetASLPhoneSetter");
        TARGETID2CLASSNAME_MATCHING.put(5270, "de.vw.mib.asl.internal.phone.HsmPhoneGetEntryHelper");
        TARGETID2CLASSNAME_MATCHING.put(5272, "de.vw.mib.asl.internal.phone.bap.TargetASLPhoneBAP");
        TARGETID2CLASSNAME_MATCHING.put(5273, "de.vw.mib.asl.internal.messages.HsmPhoneSMSHandling");
        TARGETID2CLASSNAME_MATCHING.put(5279, "de.vw.mib.asl.internal.messages.contacts.TargetASLMessagingContactsHandling");
        TARGETID2CLASSNAME_MATCHING.put(5282, "de.vw.mib.asl.internal.messages.contacts.HsmMessagingContactsSearchHandling");
        TARGETID2CLASSNAME_MATCHING.put(5275, "de.vw.mib.asl.internal.messages.setup.TargetASLPhoneMessagesSetup");
        TARGETID2CLASSNAME_MATCHING.put(567677696, "de.vw.mib.asl.internal.messages.TargetASLMessagesService");
        TARGETID2CLASSNAME_MATCHING.put(5276, "de.vw.mib.asl.internal.phone.speech.TargetASLPhoneSpeech");
        TARGETID2CLASSNAME_MATCHING.put(5278, "de.vw.mib.asl.internal.phone.setup.profiles.TargetASLPhoneProfileSetup");
        TARGETID2CLASSNAME_MATCHING.put(5280, "de.vw.mib.asl.internal.phone.TargetPhoneStartup");
        TARGETID2CLASSNAME_MATCHING.put(1922634752, "de.vw.mib.asl.internal.phone.call.CallHandling");
        alreadyInstantiatedTargetsMap = new IntBooleanOptHashMap(100);
    }
}

