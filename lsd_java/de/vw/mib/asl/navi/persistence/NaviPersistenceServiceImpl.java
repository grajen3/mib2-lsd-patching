/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navi.persistence;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.navi.persistence.DsiNavigationAdapter;
import de.vw.mib.asl.navi.persistence.NaviPersistenceModule;
import de.vw.mib.asl.navi.persistence.NaviPersistenceService;
import de.vw.mib.asl.navi.persistence.Navigation;
import de.vw.mib.asl.navi.persistence.NavigationImpl;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;

public class NaviPersistenceServiceImpl
extends AbstractModulePersistenceService
implements NaviPersistenceService {
    private static NaviPersistenceServiceImpl instance;
    private static boolean registeredAdapter;
    private final NaviPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public NaviPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new NaviPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
        this.registerAdapter();
    }

    public static NaviPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new NaviPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public Navigation loadNavigation() {
        try {
            return (Navigation)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'Navigation' from module 'Navi'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'Navigation' from module 'Navi'", throwable);
        }
        return this.createNavigation();
    }

    @Override
    public Navigation createNavigation() {
        return new NavigationImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }

    private void registerAdapter() {
        if (!registeredAdapter) {
            GenericEvents genericEvents = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents();
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.persistenceApi.registerDsiAdapter(this.module, new DsiNavigationAdapter(genericEvents, dSIProxy));
            registeredAdapter = true;
        }
    }
}

