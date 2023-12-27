/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.testmode;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.infotainmentrecorder.ASLInfotainmentrecorderFactory;
import de.vw.mib.asl.api.infotainmentrecorder.InfotainmentRecorderService;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.testmode.TestModeServices;
import de.vw.mib.desktop.DesktopManager;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;
import org.osgi.framework.ServiceReference;

public class TestModeServicesImpl
implements TestModeServices {
    private final Logger logger;
    private final ServiceRegister serviceRegister;
    private final InfotainmentRecorderService infotainmentRecorderService;
    private final ASLListManager aslListManager;
    private final DesktopManager desktopManager;
    private final ASLSystemAPI systemApi;
    private GenericEvents genericEvents;
    private ASLPropertyManager propertyManager;
    static /* synthetic */ Class class$de$vw$mib$desktop$DesktopManager;

    public TestModeServicesImpl() {
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        Services services = aSLFrameworkAPI.getServices();
        ServiceReference serviceReference = services.getBundleContext().getServiceReference((class$de$vw$mib$desktop$DesktopManager == null ? (class$de$vw$mib$desktop$DesktopManager = TestModeServicesImpl.class$("de.vw.mib.desktop.DesktopManager")) : class$de$vw$mib$desktop$DesktopManager).getName());
        this.systemApi = ASLSystemFactory.getSystemApi();
        this.desktopManager = (DesktopManager)services.getBundleContext().getService(serviceReference);
        this.logger = aSLFrameworkAPI.getASLLogger();
        this.serviceRegister = services.getGenericEvents().getServiceRegister();
        this.aslListManager = services.getASLListManager();
        this.infotainmentRecorderService = ASLInfotainmentrecorderFactory.getInfotainmentrecorderApi().getInfotainmentRecorderService();
        this.genericEvents = services.getGenericEvents();
        this.propertyManager = services.getASLPropertyManager();
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public ServiceRegister getServiceRegister() {
        return this.serviceRegister;
    }

    @Override
    public InfotainmentRecorderService getInfotainmentRecorderService() {
        return this.infotainmentRecorderService;
    }

    @Override
    public ASLListManager getAslListManager() {
        return this.aslListManager;
    }

    @Override
    public DesktopManager getDesktopManager() {
        return this.desktopManager;
    }

    @Override
    public ASLSystemAPI getSystemApi() {
        return this.systemApi;
    }

    @Override
    public GenericEvents getGenericEvents() {
        return this.genericEvents;
    }

    @Override
    public ASLPropertyManager getAslPropertyManager() {
        return this.propertyManager;
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

