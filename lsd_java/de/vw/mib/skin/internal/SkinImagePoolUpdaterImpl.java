/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.skin.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.file.FileManager;
import de.vw.mib.hmi.utils.MagicNumber;
import de.vw.mib.hmi.utils.ResData;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.lsctng.SkinUpdateFailException;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.skin.SkinResourceUpdater;
import de.vw.mib.skin.internal.SkinImagePoolImpl;
import java.io.File;
import java.io.IOException;

public class SkinImagePoolUpdaterImpl
implements SkinResourceUpdater {
    public static final String RES_FILE;
    private static final int LOGGER_CONTEXT;
    private static final int LOGGER_CLASSIFIER;
    private static final int RES_UID;
    private static final int RES_INSETS;
    private static final int RES_SCALEIMAGES;
    private static final int RES_IMAGEARRAYS;
    private static final int RES_IMAGEARRAYREFS;
    private static int CURRENT_UID;
    private final SkinImagePoolImpl skinImagePool;
    private final ConfigurationManager configurationManager;
    private final PerfService perfService;
    private final FileManager fileManager;
    private final Logger logger;

    public SkinImagePoolUpdaterImpl(SkinImagePoolImpl skinImagePoolImpl, ConfigurationManager configurationManager, FileManager fileManager, PerfService perfService, LoggerFactory loggerFactory) {
        this.skinImagePool = skinImagePoolImpl;
        this.configurationManager = configurationManager;
        this.perfService = perfService;
        this.fileManager = fileManager;
        this.logger = loggerFactory.getLogger(1024);
    }

    public int getUid() {
        return CURRENT_UID;
    }

    @Override
    public void onSkinChanged(int n) {
        try {
            this.updateImageData(n);
        }
        catch (IOException iOException) {
            throw new SkinUpdateFailException(new StringBuffer().append("Update animation data 'images.res' for skin ").append(n).append(" failed. Cause: ").append(iOException.getMessage()).toString(), iOException);
        }
    }

    private void updateImageData(int n) {
        this.logger.normal(4096).append("Update skin [id=").append(n).append("] resources: ").append("image data ").log();
        File file = ResData.getSkinResFile(this.configurationManager, n, "images.res");
        Object[] objectArray = this.load(file);
        this.update(objectArray);
    }

    private Object[] load(File file) {
        this.performanceLog(2, 1);
        Object[] objectArray = ResData.loadAndCheck(this.fileManager, file, MagicNumber.IMAGES_RES, 0, 0, this.logger, 4096);
        this.performanceLog(2, 2);
        return objectArray;
    }

    private void update(Object[] objectArray) {
        this.performanceLog(1, 1);
        this.updateSkinImagePool(objectArray);
        this.performanceLog(1, 2);
    }

    private void updateSkinImagePool(Object[] objectArray) {
        this.updateUID((int[])objectArray[0]);
        this.skinImagePool.detectFormat((int[])objectArray[2], (int[])objectArray[4]);
        this.skinImagePool.setInsetsData((int[])objectArray[1]);
        this.skinImagePool.setScaleImageData((int[])objectArray[2]);
        this.skinImagePool.setImageArrayData((int[])objectArray[3], (int[])objectArray[4]);
    }

    private void updateUID(int[] nArray) {
        CURRENT_UID = nArray[0];
    }

    private void performanceLog(int n, int n2) {
        this.perfService.performanceLogStartup(6, n, n2);
    }

    static {
        CURRENT_UID = -1;
    }
}

