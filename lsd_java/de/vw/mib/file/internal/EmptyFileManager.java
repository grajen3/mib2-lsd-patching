/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.file.internal;

import de.vw.mib.file.FileManager;
import de.vw.mib.file.spi.ContentChunk;
import java.io.File;
import java.net.URL;

public class EmptyFileManager
implements FileManager {
    @Override
    public File getFileForRelativePath(String string) {
        return new File(string);
    }

    @Override
    public Object[] readDataFromObjectSwapperFile(File file) {
        return new Object[0];
    }

    @Override
    public ClassLoader createClassLoader(URL[] uRLArray) {
        return null;
    }

    @Override
    public void destroyClassloader(ClassLoader classLoader) {
    }

    @Override
    public Class loadClass(ClassLoader classLoader, String string) {
        return null;
    }

    @Override
    public void loadXIPContainer(ClassLoader classLoader, String string) {
    }

    @Override
    public void unloadXIPContainer(ClassLoader classLoader, String string) {
    }

    @Override
    public String[] getLoadedXIPContainer(ClassLoader classLoader) {
        return null;
    }

    @Override
    public int openContentFile(String string, int n, boolean bl) {
        return 0;
    }

    @Override
    public void closeContentFile(int n) {
    }

    @Override
    public int[] getFilteredTOCFromContentFile(int n, int n2) {
        return null;
    }

    @Override
    public ContentChunk loadChunkFromContentFile(int n, int n2, int n3, boolean bl) {
        return null;
    }

    @Override
    public Object[] loadObjectArrayFromContentFile(int n, int n2) {
        return null;
    }

    @Override
    public void releaseChunk(ContentChunk contentChunk) {
    }
}

