/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.controller;

import de.vw.mib.asl.internal.itunes.database.ITunesDatabaseCollector;
import de.vw.mib.asl.internal.itunes.model.ITunesModelController;
import de.vw.mib.asl.internal.itunes.persistence.ITunesInfoPersistence;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class ITunesManager {
    private static IntObjectOptHashMap databaseInstances = new IntObjectOptHashMap();
    private static ITunesModelController modelController;
    private static ITunesInfoPersistence infoPersistence;
    private static ITunesDatabaseCollector databaseCollector;

    protected ITunesModelController getModelController() {
        if (modelController == null) {
            modelController = new ITunesModelController();
        }
        return modelController;
    }

    protected ITunesDatabaseCollector getDatabaseCollector() {
        if (databaseCollector == null) {
            databaseCollector = new ITunesDatabaseCollector();
        }
        return databaseCollector;
    }

    protected ITunesInfoPersistence getInfoPersistence() {
        if (infoPersistence == null) {
            infoPersistence = new ITunesInfoPersistence();
        }
        return infoPersistence;
    }

    public void deinitialize() {
        modelController = null;
        databaseInstances.clear();
        databaseCollector = null;
    }
}

