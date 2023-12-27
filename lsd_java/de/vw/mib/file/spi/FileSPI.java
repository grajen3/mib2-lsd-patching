/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.file.spi;

import de.vw.mib.file.spi.ContentChunk;
import java.io.File;
import java.net.URL;

public interface FileSPI {
    default public File getFileForRelativePath(String string) {
    }

    default public Object[] readDataFromObjectSwapperFile(File file) {
    }

    default public ClassLoader createClassLoader(URL[] uRLArray) {
    }

    default public void destroyClassloader(ClassLoader classLoader) {
    }

    default public Class loadClass(ClassLoader classLoader, String string) {
    }

    default public void loadXIPContainer(ClassLoader classLoader, String string) {
    }

    default public void unloadXIPContainer(ClassLoader classLoader, String string) {
    }

    default public String[] getLoadedXIPContainer(ClassLoader classLoader) {
    }

    default public int openContentFile(String string, int n, boolean bl) {
    }

    default public void closeContentFile(int n) {
    }

    default public int[] getFilteredTOCFromContentFile(int n, int n2) {
    }

    default public ContentChunk loadChunkFromContentFile(int n, int n2, int n3, boolean bl) {
    }

    default public Object[] loadObjectArrayFromContentFile(int n, int n2) {
    }

    default public void releaseChunk(ContentChunk contentChunk) {
    }
}

