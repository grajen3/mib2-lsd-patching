/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import edu.emory.mathcs.backport.java.util.Arrays;

public final class PersistableLsc
extends AbstractSharedPersistable {
    private static PersistableLsc myInstance = new PersistableLsc();
    private byte[] data = new byte[22];

    private PersistableLsc() {
        super(1101, 0, false, false);
        this.clear();
    }

    @Override
    public void clear() {
        Arrays.fill(this.data, (byte)32);
    }

    public static PersistableLsc getInstance() {
        return myInstance;
    }

    public byte[] getData() {
        return this.data;
    }

    public boolean containsValidLscData() {
        return this.data[0] != 0;
    }

    public String getPersistantLanguage() {
        return new StringBuffer().append("").append((char)this.data[0]).append((char)this.data[1]).append((char)this.data[2]).append((char)this.data[3]).append((char)this.data[4]).toString();
    }

    public synchronized void setPersistantLanguage(String string) {
        char[] cArray = string.toCharArray();
        this.data[0] = (byte)cArray[0];
        this.data[1] = (byte)cArray[1];
        this.data[2] = (byte)cArray[2];
        this.data[3] = (byte)cArray[3];
        this.data[4] = (byte)cArray[4];
        this.markDirty(true);
    }

    public int getVoice() {
        return this.data[5];
    }

    public synchronized void setVoice(int n) {
        this.data[5] = (byte)n;
        this.markDirty(true);
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        try {
            persistenceInputStream.read(this.data, 0, 22);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.write(this.data, 0, 22);
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public short[] getSupportedVersions() {
        return NO_SUPPORTED_VERSION;
    }

    @Override
    public short getVersion() {
        return 0;
    }
}

