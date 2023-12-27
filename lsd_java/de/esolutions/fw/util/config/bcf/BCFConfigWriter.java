/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.bcf;

import de.esolutions.fw.util.commons.miniser.BEMiniIntSerializer;
import de.esolutions.fw.util.commons.miniser.IMiniIntSerializer;
import de.esolutions.fw.util.commons.miniser.LEMiniIntSerializer;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.bcf.BCFConfigWriterCounter;
import de.esolutions.fw.util.config.bcf.BCFConfigWriterElements;
import de.esolutions.fw.util.config.bcf.BCFStringPool;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import de.esolutions.fw.util.config.writer.IConfigWriter;
import de.esolutions.fw.util.config.writer.WriteConfigException;
import java.io.IOException;
import java.io.OutputStream;

public class BCFConfigWriter
implements IConfigWriter {
    private boolean littleEndian = false;
    private boolean bits32 = false;
    private int version = 1;
    private IMiniIntSerializer serializer;

    private void writeHeader(OutputStream outputStream, int n, int n2, int n3) {
        byte[] byArray = new byte[16];
        byArray[0] = -27;
        byArray[1] = 11;
        byArray[2] = -49;
        byArray[3] = 0;
        if (this.littleEndian) {
            byArray[3] = (byte)(byArray[3] | 1);
        }
        if (this.bits32) {
            byArray[3] = (byte)(byArray[3] | 2);
        }
        byArray[3] = (byte)(byArray[3] | (this.version & 0xF) << 4);
        this.serializer.storeInt(n, byArray, 4);
        this.serializer.storeInt(n2, byArray, 8);
        this.serializer.storeInt(n3, byArray, 12);
        outputStream.write(byArray);
    }

    private void parseParams(ConfigDictionary configDictionary) {
        ConfigPathQuery configPathQuery = new ConfigPathQuery(configDictionary);
        this.littleEndian = configPathQuery.getBooleanValue("littleEndian", this.littleEndian);
        this.bits32 = configPathQuery.getBooleanValue("bits32", this.bits32);
        this.version = configPathQuery.getIntegerValue("version", this.version);
    }

    @Override
    public void writeToOutputStream(OutputStream outputStream, ConfigValue configValue, ConfigDictionary configDictionary) {
        int n;
        int n2;
        this.parseParams(configDictionary);
        this.serializer = this.littleEndian ? new LEMiniIntSerializer() : new BEMiniIntSerializer();
        BCFStringPool bCFStringPool = new BCFStringPool();
        BCFConfigWriterCounter bCFConfigWriterCounter = new BCFConfigWriterCounter(this.bits32, bCFStringPool);
        configValue.export(bCFConfigWriterCounter);
        int n3 = bCFConfigWriterCounter.getNumElementsPairs();
        int n4 = bCFConfigWriterCounter.getNumElementDatas();
        int n5 = n2 = bCFConfigWriterCounter.size();
        n5 = this.bits32 ? (n5 *= 4) : (n5 *= 2);
        byte[] byArray = bCFStringPool.buildTable();
        int n6 = byArray.length;
        BCFConfigWriterElements bCFConfigWriterElements = new BCFConfigWriterElements(n3, n4, bCFStringPool, this.bits32);
        configValue.export(bCFConfigWriterElements);
        if (!bCFConfigWriterElements.checkEnd()) {
            throw new WriteConfigException("FATAL: checking created elements failed!");
        }
        int[] nArray = bCFConfigWriterElements.getTotalElements();
        byte[] byArray2 = new byte[n5];
        if (this.bits32) {
            n = 0;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.serializer.storeInt(nArray[i2], byArray2, n);
                n += 4;
            }
        } else {
            n = 0;
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                this.serializer.storeShort((short)nArray[i3], byArray2, n);
                n += 2;
            }
        }
        try {
            this.writeHeader(outputStream, n3, n5, n6);
            outputStream.write(byArray2);
            outputStream.write(byArray);
        }
        catch (IOException iOException) {
            throw new WriteConfigException(new StringBuffer().append("IO: ").append(iOException.getMessage()).toString());
        }
    }
}

