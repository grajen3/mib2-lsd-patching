/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.file.internal;

import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.SyncObjectObjectOptHashMap;
import de.vw.mib.file.FileManager;
import de.vw.mib.file.internal.PreloadResFile;
import de.vw.mib.file.spi.ContentChunk;
import de.vw.mib.file.spi.FileSPI;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.spi.TimerSPI;
import java.io.File;
import java.net.URL;

class FileManagerImpl
implements FileManager {
    final Logger logger;
    private static final double MICRO;
    private final double cycleFactor_micros;
    private final FileSPI fileSPI;
    private final TimerSPI timerSPI;
    private final ObjectObjectMap preloadedResFiles;

    FileManagerImpl(LoggerFactory loggerFactory, FileSPI fileSPI, TimerSPI timerSPI) {
        this.logger = loggerFactory.getLogger(2048);
        this.fileSPI = fileSPI;
        this.timerSPI = timerSPI;
        this.cycleFactor_micros = 1000000.0 / (double)timerSPI.getSystemTimeFrequency();
        this.preloadedResFiles = new SyncObjectObjectOptHashMap(new ObjectObjectOptHashMap());
        PreloadResFile.startResFilePreloader(this.logger, this);
    }

    @Override
    public File getFileForRelativePath(String string) {
        File file = this.fileSPI.getFileForRelativePath(string);
        if (this.logger.isTraceEnabled(1)) {
            LogMessage logMessage = this.logger.trace(1);
            logMessage.append("getFileForRelativePath(relativePath=").append(string).append(") = ").append(file).log();
        }
        return file;
    }

    @Override
    public synchronized Object[] readDataFromObjectSwapperFile(File file) {
        long l;
        LogMessage logMessage = this.logger.isTraceEnabled(2) ? this.logger.trace(2) : null;
        boolean bl = logMessage != null && this.logger.isTraceEnabled(128);
        Object[] objectArray = (Object[])this.preloadedResFiles.get(file.getName());
        if (objectArray != null) {
            return objectArray;
        }
        long l2 = bl ? this.getSystemTimeMicros() : 0L;
        objectArray = this.fileSPI.readDataFromObjectSwapperFile(file);
        long l3 = l = bl ? this.getSystemTimeMicros() : 0L;
        if (logMessage != null) {
            logMessage.append("readDataFromObjectSwapperFile(file=").append(file).append(") = ").append(objectArray);
            if (bl) {
                logMessage.append(": ").append(l - l2).append("\u00b5s");
            }
            logMessage.log();
        }
        return objectArray;
    }

    @Override
    public ClassLoader createClassLoader(URL[] uRLArray) {
        ClassLoader classLoader = this.fileSPI.createClassLoader(uRLArray);
        if (this.logger.isTraceEnabled(4)) {
            LogMessage logMessage = this.logger.trace(4);
            logMessage.append("createClassLoader(classpath=").append(uRLArray).append(") = ").append(classLoader).log();
        }
        return classLoader;
    }

    @Override
    public void destroyClassloader(ClassLoader classLoader) {
        this.fileSPI.destroyClassloader(classLoader);
        if (this.logger.isTraceEnabled(4)) {
            LogMessage logMessage = this.logger.trace(4);
            logMessage.append("destroyClassloader(classloader=").append(classLoader).append(")").log();
        }
    }

    @Override
    public Class loadClass(ClassLoader classLoader, String string) {
        long l;
        LogMessage logMessage = this.logger.isTraceEnabled(4) ? this.logger.trace(4) : null;
        boolean bl = logMessage != null && this.logger.isTraceEnabled(128);
        Class clazz = null;
        long l2 = bl ? this.getSystemTimeMicros() : 0L;
        clazz = this.fileSPI.loadClass(classLoader, string);
        long l3 = l = bl ? this.getSystemTimeMicros() : 0L;
        if (logMessage != null) {
            logMessage.append("loadClass(classloader=").append(classLoader).append(",className=").append(string).append(") = ").append(clazz);
            if (bl) {
                logMessage.append(": ").append(l - l2).append("\u00b5s");
            }
            logMessage.log();
        }
        return clazz;
    }

    @Override
    public void loadXIPContainer(ClassLoader classLoader, String string) {
        long l;
        LogMessage logMessage = this.logger.isTraceEnabled(4) ? this.logger.trace(4) : null;
        boolean bl = logMessage != null && this.logger.isTraceEnabled(128);
        long l2 = bl ? this.getSystemTimeMicros() : 0L;
        this.fileSPI.loadXIPContainer(classLoader, string);
        long l3 = l = bl ? this.getSystemTimeMicros() : 0L;
        if (logMessage != null) {
            logMessage.append("loadXIPContainer(classloader=").append(classLoader).append(",xipContainerName=").append(string).append(")");
            if (bl) {
                logMessage.append(": ").append(l - l2).append("\u00b5s");
            }
            logMessage.log();
        }
    }

    @Override
    public void unloadXIPContainer(ClassLoader classLoader, String string) {
        long l;
        LogMessage logMessage = this.logger.isTraceEnabled(4) ? this.logger.trace(4) : null;
        boolean bl = logMessage != null && this.logger.isTraceEnabled(128);
        long l2 = bl ? this.getSystemTimeMicros() : 0L;
        this.fileSPI.unloadXIPContainer(classLoader, string);
        long l3 = l = bl ? this.getSystemTimeMicros() : 0L;
        if (logMessage != null) {
            logMessage.append("unloadXIPContainer(classloader=").append(classLoader).append(",xipContainerName=").append(string).append(")");
            if (bl) {
                logMessage.append(": ").append(l - l2).append("\u00b5s");
            }
            logMessage.log();
        }
    }

    @Override
    public String[] getLoadedXIPContainer(ClassLoader classLoader) {
        String[] stringArray = this.fileSPI.getLoadedXIPContainer(classLoader);
        if (this.logger.isTraceEnabled(4)) {
            LogMessage logMessage = this.logger.trace(4);
            logMessage.append("getLoadedXIPContainer(classloader=").append(classLoader).append(") = ").append(stringArray).log();
        }
        return stringArray;
    }

    @Override
    public int openContentFile(String string, int n, boolean bl) {
        long l;
        LogMessage logMessage = this.logger.isTraceEnabled(8) ? this.logger.trace(8) : null;
        boolean bl2 = logMessage != null && this.logger.isTraceEnabled(128);
        long l2 = bl2 ? this.getSystemTimeMicros() : 0L;
        int n2 = this.fileSPI.openContentFile(string, n, bl);
        long l3 = l = bl2 ? this.getSystemTimeMicros() : 0L;
        if (logMessage != null) {
            logMessage.append("openContentFile(filename=").append(string).append(",contentVersion=0x").append(Integer.toHexString(n)).append(",verifyChecksums=").append(bl).append(") = 0x").append(Integer.toHexString(n2));
            if (bl2) {
                logMessage.append(": ").append(l - l2).append("\u00b5s");
            }
            logMessage.log();
        }
        return n2;
    }

    @Override
    public void closeContentFile(int n) {
        long l;
        LogMessage logMessage = this.logger.isTraceEnabled(8) ? this.logger.trace(8) : null;
        boolean bl = logMessage != null && this.logger.isTraceEnabled(128);
        long l2 = bl ? this.getSystemTimeMicros() : 0L;
        this.fileSPI.closeContentFile(n);
        long l3 = l = bl ? this.getSystemTimeMicros() : 0L;
        if (logMessage != null) {
            logMessage.append("closeContentFile(contentFileID=0x").append(Integer.toHexString(n)).append(")");
            if (bl) {
                logMessage.append(": ").append(l - l2).append("\u00b5s");
            }
            logMessage.log();
        }
    }

    @Override
    public int[] getFilteredTOCFromContentFile(int n, int n2) {
        long l;
        LogMessage logMessage = this.logger.isTraceEnabled(8) ? this.logger.trace(8) : null;
        boolean bl = logMessage != null && this.logger.isTraceEnabled(128);
        int[] nArray = null;
        long l2 = bl ? this.getSystemTimeMicros() : 0L;
        nArray = this.fileSPI.getFilteredTOCFromContentFile(n, n2);
        long l3 = l = bl ? this.getSystemTimeMicros() : 0L;
        if (logMessage != null) {
            logMessage.append("getFilteredTOCFromContentFile(contentFileID=0x").append(Integer.toHexString(n)).append(",chunkType=0x").append(Integer.toHexString(n2)).append(") = ").append(nArray);
            if (bl) {
                logMessage.append(": ").append(l - l2).append("\u00b5s");
            }
            logMessage.log();
        }
        return nArray;
    }

    @Override
    public ContentChunk loadChunkFromContentFile(int n, int n2, int n3, boolean bl) {
        long l;
        LogMessage logMessage = this.logger.isTraceEnabled(8) ? this.logger.trace(8) : null;
        boolean bl2 = logMessage != null && this.logger.isTraceEnabled(128);
        ContentChunk contentChunk = null;
        long l2 = bl2 ? this.getSystemTimeMicros() : 0L;
        contentChunk = this.fileSPI.loadChunkFromContentFile(n, n2, n3, bl);
        long l3 = l = bl2 ? this.getSystemTimeMicros() : 0L;
        if (logMessage != null) {
            logMessage.append("loadChunkFromContentFile(contentFileID=0x").append(Integer.toHexString(n)).append(",chunkType=0x").append(Integer.toHexString(n2)).append(",chunkID=0x").append(Integer.toHexString(n3)).append(",direct=").append(bl).append(") = ").append(contentChunk);
            if (bl2) {
                logMessage.append(": ").append(l - l2).append("\u00b5s");
            }
            logMessage.log();
        }
        return contentChunk;
    }

    @Override
    public Object[] loadObjectArrayFromContentFile(int n, int n2) {
        long l;
        LogMessage logMessage = this.logger.isTraceEnabled(8) ? this.logger.trace(8) : null;
        boolean bl = logMessage != null && this.logger.isTraceEnabled(128);
        Object[] objectArray = null;
        long l2 = bl ? this.getSystemTimeMicros() : 0L;
        objectArray = this.fileSPI.loadObjectArrayFromContentFile(n, n2);
        long l3 = l = bl ? this.getSystemTimeMicros() : 0L;
        if (logMessage != null) {
            logMessage.append("loadObjectArrayFromContentFile(contentFileID=0x").append(Integer.toHexString(n)).append(",chunkID=0x").append(Integer.toHexString(n2)).append(") = ").append(objectArray);
            if (bl) {
                logMessage.append(": ").append(l - l2).append("\u00b5s");
            }
            logMessage.log();
        }
        return objectArray;
    }

    @Override
    public void releaseChunk(ContentChunk contentChunk) {
        this.fileSPI.releaseChunk(contentChunk);
        if (this.logger.isTraceEnabled(8)) {
            LogMessage logMessage = this.logger.trace(8);
            logMessage.append("releaseChunk(chunkType=0x").append(Integer.toHexString(contentChunk.getType())).append(",chunkID=0x").append(Integer.toHexString(contentChunk.getId())).append(")").log();
        }
    }

    void addPreloadedResFile(File file, Object[] objectArray) {
        this.preloadedResFiles.put(file.getName(), objectArray);
    }

    private long getSystemTimeMicros() {
        return (long)((double)this.timerSPI.getSystemTime() * this.cycleFactor_micros);
    }
}

