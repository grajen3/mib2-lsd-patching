/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car;

import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.widgets.car.RawConfigDataProxy;
import de.vw.mib.widgets.internal.ServiceManager;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public abstract class AbstractConfigData {
    private static final int DEFAULT_CONFIG_FILE_LENGTH;
    protected static final Logger LOGGER;
    private static final short MAGIC_NUMBER;
    private static final int OFFSET_MAGIC_NUMBER;
    private static final int OFFSET_VERSION;
    protected static final int SIZE_SHORT;
    private InputStream configFile;
    private int configFileLength;
    private final String configFileName;
    private short configFileVersion;
    private boolean deserialized = false;
    private final short expectedConfigFileVersion;
    private short minimalExpectedConfigFileVersion;
    private boolean configFileNotAvailable = false;

    protected AbstractConfigData(String string, short s) {
        this(string, s, 4);
    }

    protected AbstractConfigData(String string, short s, short s2, int n) {
        this(string, s, n);
        this.minimalExpectedConfigFileVersion = s2;
    }

    protected AbstractConfigData(String string, short s, int n) {
        this.configFileName = string;
        this.expectedConfigFileVersion = this.minimalExpectedConfigFileVersion = s;
        this.configFileLength = n;
    }

    public void init() {
        if (!this.deserialized && !this.configFileNotAvailable) {
            this.deserialize();
        }
    }

    public void init(RawConfigDataProxy rawConfigDataProxy) {
        if (this.deserialized || this.configFileNotAvailable) {
            return;
        }
        if (rawConfigDataProxy == null) {
            this.deserialize();
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(rawConfigDataProxy.rawConfigData);
            this.deserializeStream(byteArrayInputStream);
        }
    }

    public void deInit() {
        this.deserialized = false;
    }

    protected void deserializeStream(InputStream inputStream) {
        this.configFile = inputStream;
        this.markStream(inputStream, this.configFileLength);
        try {
            if (this.configFile != null && this.hasValidMagicNumber(this.configFile, (short)-310) && this.hasExpectedVersion(this.configFile, this.expectedConfigFileVersion, this.minimalExpectedConfigFileVersion)) {
                this.deserialize(this.configFile);
                this.deserialized = true;
            } else {
                this.configFileNotAvailable = true;
            }
        }
        catch (IOException iOException) {
            LOGGER.error(128).append(super.getClass().getName()).append(iOException).log();
            this.configFileNotAvailable = true;
        }
    }

    protected int determineOptimalBufferSize(int n) {
        int n2 = n;
        int n3 = n % 1024;
        if (n3 > 0) {
            n2 += 1024 - n3;
        }
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void deserialize() {
        boolean bl = LOGGER.isTraceEnabled(128);
        long l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        this.configFile = this.initializeStream(this.configFileName, this.configFileLength);
        try {
            if (this.configFile != null && this.hasValidMagicNumber(this.configFile, (short)-310) && this.hasExpectedVersion(this.configFile, this.expectedConfigFileVersion, this.minimalExpectedConfigFileVersion)) {
                this.deserialize(this.configFile);
                this.deserialized = true;
            } else {
                this.configFileNotAvailable = true;
            }
        }
        catch (IOException iOException) {
            LOGGER.error(128).append(super.getClass().getName()).append(iOException).log();
            this.configFileNotAvailable = true;
        }
        finally {
            this.closeStream(this.configFile);
            this.configFile = null;
        }
        if (bl) {
            long l2 = ServiceManager.timerManager.getSystemTimeMicros();
            if (LOGGER.isTraceEnabled(128)) {
                LOGGER.trace(128).append(super.getClass().getName()).append(" de-serialization took ").append(l2 - l).append(" \u00b5s").append(".").log();
            }
        }
    }

    protected abstract void deserialize(InputStream inputStream) {
    }

    public final String getConfigFileName() {
        return this.configFileName;
    }

    public final short getConfigFileVersion() {
        return this.configFileVersion;
    }

    public final boolean isDeserialized() {
        return this.deserialized;
    }

    public final short getShort(InputStream inputStream) {
        try {
            byte[] byArray = new byte[2];
            inputStream.read(byArray);
            return (short)((byArray[1] & 0xFF) << 8 | byArray[0] & 0xFF);
        }
        catch (IOException iOException) {
            LOGGER.error(128).append(super.getClass().getName()).append(iOException).log();
            return 0;
        }
    }

    protected final short getShort(InputStream inputStream, int n) {
        try {
            inputStream.reset();
            inputStream.skip(n);
            return this.getShort(inputStream);
        }
        catch (IOException iOException) {
            return 0;
        }
    }

    private InputStream initializeStream(String string, int n) {
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(string), Math.max(2048, this.determineOptimalBufferSize(n)));
            if (((InputStream)bufferedInputStream).markSupported()) {
                ((InputStream)bufferedInputStream).mark(n);
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            LOGGER.error(128).append("[").append(super.getClass().getName()).append("]: Unable to open car config file! [fileName='").append(string).append("']").log();
        }
        return bufferedInputStream;
    }

    private void markStream(InputStream inputStream, int n) {
        if (inputStream.markSupported()) {
            inputStream.mark(n);
        }
    }

    private void closeStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            }
            catch (IOException iOException) {
                LOGGER.error(128).append(super.getClass().getName()).append(iOException).log();
            }
        }
    }

    protected final void onConfigFileLengthChanged(int n) {
        if (this.configFile != null && this.configFile.markSupported()) {
            try {
                this.configFile.reset();
                this.configFile.mark(n);
            }
            catch (IOException iOException) {
                LOGGER.error(128).append(super.getClass().getName()).append(iOException).log();
            }
        }
    }

    protected final void fillArray(InputStream inputStream, short[] sArray, int n) {
        try {
            inputStream.reset();
            inputStream.skip(n);
        }
        catch (IOException iOException) {
            Arrays.fill(sArray, (short)0);
            return;
        }
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            sArray[i2] = this.getShort(inputStream);
        }
    }

    protected final void fillArray(InputStream inputStream, short[][] sArray, int n) {
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            if (i2 > 0) {
                n += sArray[i2].length * 2;
            }
            this.fillArray(inputStream, sArray[i2], n);
        }
    }

    protected final void fillArray(InputStream inputStream, short[] sArray) {
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            sArray[i2] = this.getShort(inputStream);
        }
    }

    public final void fillArray(InputStream inputStream, short[][] sArray) {
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            this.fillArray(inputStream, sArray[i2]);
        }
    }

    protected final void fillMultimap(IntIntMap intIntMap, int n, short[] sArray) {
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            intIntMap.put(n, sArray[i2]);
        }
    }

    protected final void fillMultimap(IntIntMap intIntMap, short[][] sArray) {
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            this.fillMultimap(intIntMap, i2, sArray[i2]);
        }
    }

    private boolean hasExpectedVersion(InputStream inputStream, short s, short s2) {
        this.configFileVersion = this.getShort(inputStream, 2);
        if (this.configFileVersion < s2 || this.configFileVersion > s) {
            LOGGER.warn(128).append(super.getClass().getName()).append(" The configuration file version [").append(this.configFileVersion).append("] is not the expected [min. v").append(s2).append("; max. v").append(s).append("]!").log();
            return false;
        }
        return true;
    }

    private boolean hasValidMagicNumber(InputStream inputStream, short s) {
        short s2 = this.getShort(inputStream, 0);
        if (s2 != s) {
            LOGGER.warn(128).append(super.getClass().getName()).append(" The configuration file magic number [").append(s2).append("] is not the expetced!").log();
            return false;
        }
        return true;
    }

    static {
        LOGGER = ServiceManager.loggerFactory.getLogger(2048);
    }
}

