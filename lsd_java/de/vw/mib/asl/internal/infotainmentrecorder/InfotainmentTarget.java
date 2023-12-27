/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.infotainmentrecorder;

import de.vw.mib.asl.api.infotainmentrecorder.ASLInfotainmentrecorderFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.infotainmentrecorder.InfotainmentRecorderServiceImpl;
import de.vw.mib.asl.internal.infotainmentrecorder.InfotainmentRecorderServiceManager;
import de.vw.mib.asl.internal.infotainmentrecorder.InfotainmentTarget$1;
import de.vw.mib.asl.internal.infotainmentrecorder.backuptrigger.BackupServiceImpl;
import de.vw.mib.asl.internal.infotainmentrecorder.backuptrigger.InfotainmentRecorderKeyListener;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.desktop.DesktopDiagnosticsNotificationReceiver;
import de.vw.mib.desktop.DesktopDiagnosticsProviderService;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public final class InfotainmentTarget
extends AbstractTarget {
    private static final int EVENT_NOTIFY_DDN_VIEWTREE_CHANGED;
    private static final int EVENT_NDVC_P0_ID_VIEWID_STRING;
    private DSIInfotainmentRecorder dsiInfotainmentRecorder;
    static /* synthetic */ Class class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder;
    static /* synthetic */ Class class$de$vw$mib$desktop$DesktopDiagnosticsProviderService;

    public InfotainmentTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public InfotainmentTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 7100;
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
            case 107: {
                this.processPowerOff();
                break;
            }
            case 100000: {
                this.processDdnViewTreeChanged(eventGeneric.getString(0));
                break;
            }
        }
    }

    private DesktopDiagnosticsNotificationReceiver createDesktopDiagnosticsNotificationReceiver(DesktopDiagnosticsProviderService desktopDiagnosticsProviderService) {
        return new InfotainmentTarget$1(this, desktopDiagnosticsProviderService);
    }

    private Object getOsgiService(BundleContext bundleContext, Class clazz) {
        ServiceReference serviceReference = bundleContext.getServiceReference(clazz.getName());
        return bundleContext.getService(serviceReference);
    }

    private void processDdnViewTreeChanged(String string) {
        if (this.dsiInfotainmentRecorder != null && !Util.isNullOrEmpty(string)) {
            this.dsiInfotainmentRecorder.logPanelName(string);
            InfotainmentRecorderServiceManager.INSTANCE.getModel().setCurrentViewName(string);
        }
    }

    private void processPowerOff() {
        this.dsiInfotainmentRecorder = null;
    }

    private void processPowerOn() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiInfotainmentRecorder = (DSIInfotainmentRecorder)dSIProxy.getService(this, class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder == null ? (class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder = InfotainmentTarget.class$("org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder")) : class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder);
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        DesktopDiagnosticsProviderService desktopDiagnosticsProviderService = (DesktopDiagnosticsProviderService)this.getOsgiService(bundleContext, class$de$vw$mib$desktop$DesktopDiagnosticsProviderService == null ? (class$de$vw$mib$desktop$DesktopDiagnosticsProviderService = InfotainmentTarget.class$("de.vw.mib.desktop.DesktopDiagnosticsProviderService")) : class$de$vw$mib$desktop$DesktopDiagnosticsProviderService);
        DesktopDiagnosticsNotificationReceiver desktopDiagnosticsNotificationReceiver = this.createDesktopDiagnosticsNotificationReceiver(desktopDiagnosticsProviderService);
        desktopDiagnosticsProviderService.addDesktopDiagnosticsNotificationReceiver(desktopDiagnosticsNotificationReceiver);
        this.setupBackupTrigger();
    }

    private void setupBackupTrigger() {
        Services services = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        ConfigurationManagerDiag configurationManagerDiag = services.getConfigurationManagerDiag();
        BackupServiceImpl backupServiceImpl = new BackupServiceImpl(this.dsiInfotainmentRecorder, services);
        InfotainmentRecorderKeyListener infotainmentRecorderKeyListener = new InfotainmentRecorderKeyListener(backupServiceImpl, configurationManagerDiag);
        ASLSystemFactory.getSystemApi().addKeyListener(5, infotainmentRecorderKeyListener);
        ASLSystemFactory.getSystemApi().addKeyListener(16, infotainmentRecorderKeyListener);
        InfotainmentRecorderServiceImpl infotainmentRecorderServiceImpl = (InfotainmentRecorderServiceImpl)ASLInfotainmentrecorderFactory.getInfotainmentrecorderApi().getInfotainmentRecorderService();
        infotainmentRecorderServiceImpl.installBackupService(backupServiceImpl);
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

