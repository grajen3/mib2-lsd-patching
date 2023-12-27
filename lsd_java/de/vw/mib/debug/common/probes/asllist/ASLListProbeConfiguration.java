/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.asllist;

import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.probes.configuration.AbstractDebugProbeConfiguration;
import de.vw.mib.debug.common.probes.configuration.CSVParser;
import java.util.Properties;

public final class ASLListProbeConfiguration
extends AbstractDebugProbeConfiguration {
    private static final String ID_LIST;
    private static final int[] ALL_OFF;
    private int[] asllistids = ALL_OFF;

    public int[] getAslListIds() {
        return this.asllistids;
    }

    @Override
    public byte getCodecVersion() {
        return -6;
    }

    @Override
    public String getDebugProbeName() {
        return "ASLLIST";
    }

    @Override
    public void load(Properties properties) {
        this.asllistids = CSVParser.parseToArrayIDs(properties, "asllist.ids");
    }

    public void setAslListIds(int[] nArray) {
        this.asllistids = nArray;
    }

    @Override
    public Properties storeToProperties() {
        Properties properties = new Properties();
        if (this.asllistids != null) {
            properties.setProperty("asllist.ids", CSVParser.createIntCSV(this.asllistids));
        }
        return properties;
    }

    @Override
    protected synchronized void readBinaryConfiguration(ByteArrayReader byteArrayReader) {
        int n = byteArrayReader.readInt();
        this.asllistids = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            this.asllistids[i2] = byteArrayReader.readInt();
        }
    }

    @Override
    protected synchronized void writeBinaryConfiguration() {
        if (this.asllistids == null) {
            this.writeInt(0);
            return;
        }
        this.writeInt(this.asllistids.length);
        for (int i2 = 0; i2 < this.asllistids.length; ++i2) {
            this.writeInt(this.asllistids[i2]);
        }
    }

    static {
        ALL_OFF = new int[0];
    }
}

