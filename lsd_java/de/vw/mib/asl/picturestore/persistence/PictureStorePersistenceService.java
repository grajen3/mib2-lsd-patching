/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.picturestore.persistence;

import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;
import de.vw.mib.asl.picturestore.persistence.PictureStore;
import de.vw.mib.asl.picturestore.persistence.StoredPicture;

public interface PictureStorePersistenceService
extends ModulePersistenceService {
    default public PictureStore loadPictureStore() {
    }

    default public StoredPicture createStoredPicture() {
    }

    default public PictureStore createPictureStore() {
    }
}

