/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.mcf;

import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.collections.ObjectIntReadOnlyMap;
import de.vw.mib.file.FileManager;
import de.vw.mib.mcf.MultiObjectSwapperReader;
import java.io.File;
import java.util.Set;

public class MultiObjectSwapperReaderImpl
implements MultiObjectSwapperReader {
    private final FileManager fileManager;
    private ObjectIntMap keyToObjectArrayIdMapping;
    private int contentFileId = 0;

    public MultiObjectSwapperReaderImpl(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void open(File file, boolean bl) {
        this.contentFileId = this.fileManager.openContentFile(file.getAbsolutePath(), 1, bl);
        Object[] objectArray = this.fileManager.loadObjectArrayFromContentFile(this.contentFileId, 0);
        this.dispatchHeader(objectArray);
    }

    @Override
    public void close() {
        this.fileManager.closeContentFile(this.contentFileId);
    }

    @Override
    public int getId(String string) {
        return this.keyToObjectArrayIdMapping.get(string);
    }

    @Override
    public Object[] getFromId(int n) {
        return this.fileManager.loadObjectArrayFromContentFile(this.contentFileId, n);
    }

    @Override
    public Object[] getFromKey(String string) {
        int n = this.getId(string);
        if (n == 0) {
            return null;
        }
        return this.getFromId(n);
    }

    @Override
    public Set getAllAvailableKeys() {
        return this.keyToObjectArrayIdMapping.keySet();
    }

    private void dispatchHeader(Object[] objectArray) {
        int[] nArray = (int[])objectArray[1];
        String[] stringArray = (String[])objectArray[2];
        ObjectIntOptHashMap objectIntOptHashMap = new ObjectIntOptHashMap(nArray.length);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            objectIntOptHashMap.put(stringArray[i2], nArray[i2]);
        }
        this.keyToObjectArrayIdMapping = new ObjectIntReadOnlyMap(objectIntOptHashMap);
    }
}

