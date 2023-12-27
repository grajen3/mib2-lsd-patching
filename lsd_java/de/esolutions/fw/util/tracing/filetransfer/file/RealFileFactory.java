/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.file;

import de.esolutions.fw.util.tracing.filetransfer.file.IFile;
import de.esolutions.fw.util.tracing.filetransfer.file.IFileFactory;
import de.esolutions.fw.util.tracing.filetransfer.file.RealTransferFile;

public class RealFileFactory
implements IFileFactory {
    @Override
    public IFile createFile(String string) {
        RealTransferFile realTransferFile = new RealTransferFile(string);
        return realTransferFile;
    }
}

