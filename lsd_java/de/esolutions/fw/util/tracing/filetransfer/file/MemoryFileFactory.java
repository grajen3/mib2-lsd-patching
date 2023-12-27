/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.file;

import de.esolutions.fw.util.tracing.filetransfer.file.IFile;
import de.esolutions.fw.util.tracing.filetransfer.file.IFileFactory;
import de.esolutions.fw.util.tracing.filetransfer.file.MemoryTransferFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MemoryFileFactory
implements IFileFactory {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IFile createFile(String string) {
        MemoryTransferFile memoryTransferFile = new MemoryTransferFile(string);
        memoryTransferFile.open(true);
        byte[] byArray = null;
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(new File(string), "rw");
        }
        catch (FileNotFoundException fileNotFoundException) {
            randomAccessFile = null;
        }
        if (randomAccessFile != null) {
            try {
                byArray = new byte[(int)randomAccessFile.length()];
                randomAccessFile.read(byArray);
            }
            catch (IOException iOException) {
                byArray = null;
            }
            finally {
                try {
                    randomAccessFile.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
        if (byArray != null) {
            memoryTransferFile.write(byArray);
        }
        memoryTransferFile.close();
        return memoryTransferFile;
    }
}

