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
import de.vw.mib.skin.internal.SkinAnimationPoolImpl;
import de.vw.mib.skin.internal.SkinAnimationPoolResDataAccess;
import java.io.File;
import java.io.IOException;

public class SkinAnimationPoolUpdaterImpl
implements SkinResourceUpdater {
    public static final String RES_FILE = new StringBuffer().append("view").append(File.separator).append("skinanim.res").toString();
    private static final int SIGNATURE;
    private static final int LOGGER_CONTEXT;
    private static final int LOGGER_CLASSIFIER;
    private final SkinAnimationPoolImpl skinAnimationPool;
    private final ConfigurationManager configurationManager;
    private final PerfService perfService;
    private final FileManager fileManager;
    private final Logger logger;
    private final int checksum;

    public SkinAnimationPoolUpdaterImpl(SkinAnimationPoolImpl skinAnimationPoolImpl, int n, ConfigurationManager configurationManager, FileManager fileManager, PerfService perfService, LoggerFactory loggerFactory) {
        this.skinAnimationPool = skinAnimationPoolImpl;
        this.configurationManager = configurationManager;
        this.checksum = n;
        this.perfService = perfService;
        this.fileManager = fileManager;
        this.logger = loggerFactory.getLogger(1024);
    }

    @Override
    public void onSkinChanged(int n) {
        try {
            this.updateAnimationData(n);
        }
        catch (IOException iOException) {
            throw new SkinUpdateFailException(new StringBuffer().append("Update animation data '").append(RES_FILE).append("' for skin ").append(n).append(" failed. Cause: ").append(iOException.getMessage()).toString(), iOException);
        }
    }

    private void updateAnimationData(int n) {
        this.logger.normal(4096).append("Update skin [id=").append(n).append("] resources: ").append("animation data ").log();
        File file = ResData.getSkinResFile(this.configurationManager, n, RES_FILE);
        SkinAnimationPoolResDataAccess skinAnimationPoolResDataAccess = this.load(file);
        this.update(skinAnimationPoolResDataAccess);
    }

    private SkinAnimationPoolResDataAccess load(File file) {
        this.performanceLog(2, 1);
        Object[] objectArray = ResData.loadAndCheck(this.fileManager, file, MagicNumber.SKINANIM_RES, this.checksum, -1365240007, this.logger, 4096);
        SkinAnimationPoolResDataAccess skinAnimationPoolResDataAccess = new SkinAnimationPoolResDataAccess(objectArray);
        this.performanceLog(2, 2);
        return skinAnimationPoolResDataAccess;
    }

    private void update(SkinAnimationPoolResDataAccess skinAnimationPoolResDataAccess) {
        this.performanceLog(1, 1);
        this.skinAnimationPool.updateData(skinAnimationPoolResDataAccess);
        this.performanceLog(1, 2);
    }

    private void performanceLog(int n, int n2) {
        this.perfService.performanceLogStartup(5, n, n2);
    }
}

