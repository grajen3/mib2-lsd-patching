/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile;

import de.vw.mib.asl.api.navinfotile.ASLNavInfoTileGuidanceListener;
import de.vw.mib.asl.api.navinfotile.ASLNavInfoTilePersistenceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.navinfotile.persistence.NavInfoTile;
import de.vw.mib.asl.navinfotile.persistence.NavInfoTilePersistenceService;
import de.vw.mib.asl.navinfotile.persistence.NavInfoTilePersistenceServiceImpl;
import de.vw.mib.log4mib.LogMessage;
import java.util.ArrayList;

public final class NavInfoTileDatapool {
    private int currentGuidanceState = 0;
    private int currentGuidanceMode = 0;
    private NavInfoTile navInfoTilePersistence;
    private final ArrayList persistenceListeners = new ArrayList();
    private ArrayList guidanceListeners = new ArrayList();
    private static NavInfoTileDatapool DATAPOOL = null;
    private boolean isPersistenceInitialized = false;
    private static final int INVALID_PERSISTED_PAGE;

    public static NavInfoTileDatapool getInstance() {
        if (DATAPOOL == null) {
            DATAPOOL = new NavInfoTileDatapool();
        }
        return DATAPOOL;
    }

    private NavInfoTileDatapool() {
    }

    public void traceState(String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    public int getSubClassifier() {
        return 32;
    }

    void initPersistence() {
        this.traceState("going to init persistance");
        if (this.navInfoTilePersistence == null) {
            try {
                this.traceState("trying to load");
                this.navInfoTilePersistence = this.getPersistenceServices().loadNavInfoTile();
                this.notifyPersistenceListeners();
            }
            catch (Exception exception) {
                this.traceState("trying to create");
                this.navInfoTilePersistence = this.getPersistenceServices().createNavInfoTile();
                this.notifyPersistenceListeners();
            }
        }
        this.isPersistenceInitialized = true;
    }

    public NavInfoTilePersistenceService getPersistenceServices() {
        return NavInfoTilePersistenceServiceImpl.getInstance();
    }

    void setCurrentGuidanceState(int n) {
        this.currentGuidanceState = n;
        this.notifyGuidanceListeners();
    }

    void setCurrentGuidanceMode(int n) {
        this.currentGuidanceMode = n;
        this.notifyGuidanceListeners();
    }

    void notifyPersistenceListeners() {
        for (int i2 = 0; i2 < this.persistenceListeners.size(); ++i2) {
            try {
                ASLNavInfoTilePersistenceListener aSLNavInfoTilePersistenceListener = (ASLNavInfoTilePersistenceListener)this.persistenceListeners.get(i2);
                aSLNavInfoTilePersistenceListener.updatePersistentPage(this.getPersistedPage());
                this.traceState(new StringBuffer().append("updated value from persistence: ").append(this.getPersistedPage()).toString());
                continue;
            }
            catch (Throwable throwable) {
                ServiceManager.errorHandler.handleError(throwable);
            }
        }
    }

    void notifyGuidanceListeners() {
        for (int i2 = 0; i2 < this.guidanceListeners.size(); ++i2) {
            try {
                ASLNavInfoTileGuidanceListener aSLNavInfoTileGuidanceListener = (ASLNavInfoTileGuidanceListener)this.guidanceListeners.get(i2);
                aSLNavInfoTileGuidanceListener.updateGuidanceMode(this.currentGuidanceMode);
                aSLNavInfoTileGuidanceListener.updateGuidanceState(this.currentGuidanceState);
                continue;
            }
            catch (Throwable throwable) {
                ServiceManager.errorHandler.handleError(throwable);
            }
        }
    }

    public int getPersistedPage() {
        if (this.isPersistenceInitialized) {
            return this.navInfoTilePersistence.getPageIndex();
        }
        this.traceState("persistence not available -> invalid value");
        return 255;
    }

    public void setPersistedPage(int n) {
        this.traceState(new StringBuffer().append("setPersistedPage: ").append(n).toString());
        if (this.isPersistenceInitialized) {
            if (n != this.getPersistedPage()) {
                this.navInfoTilePersistence.setPageIndex(n);
                this.traceState(new StringBuffer().append(n).append(" persisted").toString());
                this.notifyPersistenceListeners();
            }
        } else {
            this.traceState(new StringBuffer().append("avoid persisting same value again: ").append(n).toString());
        }
    }

    public void addPersistenceListener(ASLNavInfoTilePersistenceListener aSLNavInfoTilePersistenceListener) {
        this.traceState("persistence listener added");
        this.persistenceListeners.add(aSLNavInfoTilePersistenceListener);
        this.notifyPersistenceListeners();
    }

    public void addGuidanceListener(ASLNavInfoTileGuidanceListener aSLNavInfoTileGuidanceListener) {
        this.guidanceListeners.add(aSLNavInfoTileGuidanceListener);
        this.notifyGuidanceListeners();
    }
}

