/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.file.internal;

import de.vw.mib.file.internal.FileManagerImpl;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringUtil;
import java.io.File;

class PreloadResFile
implements Runnable {
    private static final int DEFAULT_THREAD_PRIO;
    private static final String PRELOAD_THREAD_PRIO_PARAM_NAME;
    private static final String PRELOAD_PARAM_NAME;
    private static final String PRELOAD_FILES_STRING;
    private static final int PRELOAD_THREAD_PRIO;
    private final FileManagerImpl fileManager;
    private final Logger logger;

    private PreloadResFile(Logger logger, FileManagerImpl fileManagerImpl) {
        this.logger = logger;
        this.fileManager = fileManagerImpl;
    }

    static void startResFilePreloader(Logger logger, FileManagerImpl fileManagerImpl) {
        if (PRELOAD_FILES_STRING == null || PRELOAD_FILES_STRING.length() == 0) {
            return;
        }
        Thread thread = new Thread(new PreloadResFile(logger, fileManagerImpl));
        thread.setPriority(PRELOAD_THREAD_PRIO);
        thread.start();
    }

    @Override
    public void run() {
        String[] stringArray = this.parseFilesString(PRELOAD_FILES_STRING);
        this.loadAllFiles(stringArray);
    }

    private void loadAllFiles(String[] stringArray) {
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            File file = new File(stringArray[i2]);
            try {
                this.fileManager.addPreloadedResFile(file, this.doPreloadResFile(file));
                continue;
            }
            catch (Throwable throwable) {
                this.logger.info(2).append(new StringBuffer().append("Unable to preload res file ").append(file.getName()).toString());
            }
        }
    }

    private String[] parseFilesString(String string) {
        return StringUtil.split(string, new String[]{",", ", ", ";", "; "});
    }

    private Object[] doPreloadResFile(File file) {
        return this.fileManager.readDataFromObjectSwapperFile(file);
    }

    static {
        PRELOAD_FILES_STRING = System.getProperty("de.vw.mib.file.preloadresfiles");
        PRELOAD_THREAD_PRIO = Integer.getInteger("de.vw.mib.file.preloadresfiles.threadprio", 9);
    }
}

