/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceLogger;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.RawPersistenceIdsDataProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.objectswapper.ObjectSwapperReader;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.file.FileManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class RawPersistenceIdsDataProviderImpl
implements RawPersistenceIdsDataProvider {
    private static final String CLASSPATH_FILE_NAME;
    private static final String CONFIG_FILE_NAME;
    private final ConfigurationManager configurationManager;
    private final FileManager fileManager;
    private final ClassLoader classLoader;
    private final PersistenceLogger logger;

    public RawPersistenceIdsDataProviderImpl(ConfigurationManager configurationManager, FileManager fileManager, ClassLoader classLoader, PersistenceLogger persistenceLogger) {
        this.configurationManager = configurationManager;
        this.fileManager = fileManager;
        this.classLoader = classLoader;
        this.logger = persistenceLogger;
    }

    @Override
    public Object[] retrieveRawData() {
        InputStream inputStream = this.classLoader.getResourceAsStream("tmpPersistenceIds.res");
        boolean bl = inputStream != null;
        Object[] objectArray = null;
        if (bl) {
            this.logger.warning("Found persistence id definition in classpath. Using this instead of the one placed in the config folder. This should only happen for local development builds!");
            objectArray = this.readDataFromClassPath(inputStream);
        }
        if (objectArray == null) {
            objectArray = this.readDataFromConfigFile();
        }
        return objectArray;
    }

    private Object[] readDataFromConfigFile() {
        String string = this.configurationManager.getConfigurationResourceFilePath("persistenceIds.res");
        Object[] objectArray = this.fileManager.readDataFromObjectSwapperFile(new File(string));
        return objectArray;
    }

    private Object[] readDataFromClassPath(InputStream inputStream) {
        Object[] objectArray = null;
        try {
            ObjectSwapperReader objectSwapperReader = new ObjectSwapperReader();
            objectSwapperReader.open(inputStream);
            objectArray = objectSwapperReader.linkAll();
            objectSwapperReader.close();
        }
        catch (IOException iOException) {
            this.logger.error("Could not read persistence id data from class path, falling back to config file", iOException);
        }
        catch (RuntimeException runtimeException) {
            this.logger.error("Could not read persistence id data from class path, falling back to config file", runtimeException);
        }
        return objectArray;
    }
}

