/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.file.FileManager;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.hmi.utils.MagicNumber;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InvalidObjectException;

public class ResData {
    public static final int IGNORE_SIGNATURE;
    public static final int IGNORE_CHECKSUM;
    public static final int HEADER_ARRAY_INDEX;
    public static final int HEADER_MAGIC_NUMBER_INDEX;
    public static final int HEADER_CHECKSUM_INDEX;
    public static final int HEADER_SIGNATURE_INDEX;

    public static File getResFile(ConfigurationManager configurationManager, String string) {
        String string2 = configurationManager.getConfigurationResourceFilePath(string);
        return new File(string2);
    }

    public static File getSkinResFile(ConfigurationManager configurationManager, int n, String string) {
        String string2 = configurationManager.getSkinPath(n);
        return new File(string2, string);
    }

    public static Object[] loadAndCheck(File file, MagicNumber magicNumber, int n, int n2, Logger logger, int n3) {
        return ResData.loadAndCheck(ServiceManagerCommon.fileManager, file, magicNumber, n, n2, logger, n3);
    }

    public static Object[] loadAndCheck(FileManager fileManager, File file, MagicNumber magicNumber, int n, int n2, Logger logger, int n3) {
        Object[] objectArray;
        if (logger.isTraceEnabled(n3)) {
            objectArray = logger.trace(n3);
            objectArray.append("Loading ").append(magicNumber.getDescription()).append(": ");
            objectArray.append(file.getAbsolutePath());
            objectArray.log();
        }
        objectArray = ResData.loadResData(fileManager, file, magicNumber, logger, n3);
        ResData.checkHeader(file, objectArray, magicNumber, n, n2, logger, n3);
        return objectArray;
    }

    private static Object[] loadResData(FileManager fileManager, File file, MagicNumber magicNumber, Logger logger, int n) {
        if (!file.isFile()) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException(new StringBuffer().append("Res-file not found: ").append(magicNumber.getDescription()).append(".").toString());
            LogMessage logMessage = logger.error(n);
            logMessage.append("Loading ").append(magicNumber.getDescription()).append(" aborted. Resource not found: ");
            logMessage.append(file.getAbsolutePath());
            logMessage.attachThrowable(fileNotFoundException);
            logMessage.log();
            throw fileNotFoundException;
        }
        Object[] objectArray = fileManager.readDataFromObjectSwapperFile(file);
        return objectArray;
    }

    private static void checkHeader(File file, Object[] objectArray, MagicNumber magicNumber, int n, int n2, Logger logger, int n3) {
        if (objectArray == null || objectArray.length == 0) {
            InvalidObjectException invalidObjectException = new InvalidObjectException(new StringBuffer().append("Res-file not correctly loaded: ").append(magicNumber.getDescription()).append(".").toString());
            LogMessage logMessage = logger.error(n3);
            logMessage.append("Loading ");
            logMessage.append(magicNumber.getDescription());
            logMessage.append(" aborted. Inputstream contains no data: ");
            logMessage.append(file.getPath());
            logMessage.attachThrowable(invalidObjectException);
            logMessage.log();
            throw invalidObjectException;
        }
        int n4 = ResData.getHeaderInfo(objectArray, 0, 0);
        if (n4 != magicNumber.getIntValue() && magicNumber.getIntValue() != 0) {
            InvalidObjectException invalidObjectException = new InvalidObjectException(new StringBuffer().append("Res-file not a valid: ").append(magicNumber.getDescription()).append(".").toString());
            LogMessage logMessage = logger.error(n3);
            logMessage.append("Loading ");
            logMessage.append(magicNumber.getDescription());
            logMessage.append(" aborted. Inputstream-magic is not a valid (expected ");
            logMessage.append(magicNumber.getFourLetters());
            logMessage.append("): ");
            logMessage.append(file.getPath());
            logMessage.attachThrowable(invalidObjectException);
            logMessage.log();
            throw invalidObjectException;
        }
        int n5 = ResData.getHeaderInfo(objectArray, 1, 0);
        if (n5 != n && n != 0) {
            InvalidObjectException invalidObjectException = new InvalidObjectException(new StringBuffer().append("Res-file not compatible: ").append(magicNumber.getDescription()).append(".").toString());
            LogMessage logMessage = logger.error(n3);
            logMessage.append("Loading ");
            logMessage.append(magicNumber.getDescription());
            logMessage.append(" aborted. Inputstream-checksum is invalid (expected ");
            logMessage.append(n);
            logMessage.append("): ");
            logMessage.append(file.getPath());
            logMessage.attachThrowable(invalidObjectException);
            logMessage.log();
            throw invalidObjectException;
        }
        int n6 = ResData.getHeaderInfo(objectArray, 2, 0);
        if (n6 != n2 && n2 != 0) {
            InvalidObjectException invalidObjectException = new InvalidObjectException(new StringBuffer().append("Res-file signature not compatible: ").append(magicNumber.getDescription()).append(".").toString());
            LogMessage logMessage = logger.error(n3);
            logMessage.append("Loading ");
            logMessage.append(magicNumber.getDescription());
            logMessage.append(" aborted. Inputstream-signature is invalid (expected ");
            logMessage.append(n2);
            logMessage.append("): ");
            logMessage.append(file.getPath());
            logMessage.attachThrowable(invalidObjectException);
            logMessage.log();
            throw invalidObjectException;
        }
    }

    public static int getHeaderInfo(Object[] objectArray, int n, int n2) {
        try {
            int[] nArray = (int[])objectArray[0];
            return nArray[n];
        }
        catch (Exception exception) {
            return n2;
        }
    }
}

