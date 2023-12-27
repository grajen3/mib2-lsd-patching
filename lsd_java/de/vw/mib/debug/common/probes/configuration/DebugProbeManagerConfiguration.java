/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.configuration;

import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.core.ByteArrayWriter;
import de.vw.mib.debug.common.core.WrongCodecVersionException;
import de.vw.mib.debug.common.probes.configuration.FilterFlagsHelper;
import java.util.Arrays;
import java.util.Properties;
import java.util.StringTokenizer;

public final class DebugProbeManagerConfiguration
extends ByteArrayWriter {
    public static final byte CODEC_VERSION;
    public static final String NAME;
    private static final String KEY_PROBES;
    private static final String KEY_SINKS;
    private static final String KEY_FORCED_PROBES;
    private static final String SINK_FILE;
    private static final String SINK_SERIAL;
    private static final String SINK_TCP;
    private static final String[] NO_PROBES;
    private String[] probes;
    private boolean isForcedProbes;
    private boolean fileSinkEnabled;
    private boolean serialSinkEnabled;
    private boolean tcpSinkEnabled;
    private ByteArrayReader defaultReader;
    private int filters;

    public DebugProbeManagerConfiguration() {
        this.setForcedDebugProbes();
    }

    private void setForcedDebugProbes() {
        String string = System.getProperty("debugprobes.config.force.probes");
        if (string == null || string.trim().length() < 1) {
            this.probes = NO_PROBES;
        } else {
            this.extractProbes(string);
        }
        this.isForcedProbes = string != null;
    }

    private void extractProbes(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
        this.probes = new String[stringTokenizer.countTokens()];
        for (int i2 = 0; i2 < this.probes.length; ++i2) {
            this.probes[i2] = stringTokenizer.nextToken().trim();
        }
    }

    public void load(byte[] byArray) {
        if (this.defaultReader == null) {
            this.defaultReader = new ByteArrayReader(byArray);
        } else {
            this.defaultReader.reset(byArray);
        }
        byte by = this.defaultReader.readByte();
        if (by != -1) {
            throw new WrongCodecVersionException(by, -1, super.getClass());
        }
        byte by2 = this.defaultReader.readByte();
        int n = 0;
        if ((by2 & 1) != 0) {
            this.fileSinkEnabled = true;
            ++n;
        }
        if ((by2 & 2) != 0) {
            this.serialSinkEnabled = true;
            ++n;
        }
        if ((by2 & 4) != 0) {
            this.tcpSinkEnabled = true;
            ++n;
        }
        if (n > 0) {
            if ((by2 & 1) == 0) {
                this.fileSinkEnabled = false;
            }
            if ((by2 & 2) == 0) {
                this.serialSinkEnabled = false;
            }
            if ((by2 & 4) == 0) {
                this.tcpSinkEnabled = false;
            }
        }
        int n2 = this.defaultReader.readInt();
        if (!this.isForcedProbes) {
            this.probes = new String[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                this.probes[i2] = this.defaultReader.readString();
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                this.defaultReader.skipBytes(this.defaultReader.readInt());
            }
        }
        this.setFilters(this.defaultReader.readInt());
    }

    public byte[] storeToByteArray() {
        this.reset();
        this.writeByte(-1);
        int n = 0;
        if (this.fileSinkEnabled) {
            n |= 1;
        }
        if (this.serialSinkEnabled) {
            n |= 2;
        }
        if (this.tcpSinkEnabled) {
            n |= 4;
        }
        this.writeByte((byte)n);
        this.writeInt(this.probes.length);
        for (int i2 = 0; i2 < this.probes.length; ++i2) {
            this.writeString(this.probes[i2]);
        }
        this.writeInt(this.filters);
        return this.toByteArray();
    }

    public String[] getActiveDebugProbes() {
        return this.probes;
    }

    public boolean isDebugProbeActive(String string) {
        for (int i2 = this.probes.length - 1; i2 >= 0; --i2) {
            if (!this.probes[i2].equals(string)) continue;
            return true;
        }
        return false;
    }

    public boolean isFileSinkEnabled() {
        return this.fileSinkEnabled;
    }

    public boolean isSerialSinkEnabled() {
        return this.serialSinkEnabled;
    }

    public boolean isTcpSinkEnabled() {
        return this.tcpSinkEnabled;
    }

    public void load(Properties properties) {
        String string = properties.getProperty("sinks");
        this.fileSinkEnabled = (string = string.toLowerCase()).indexOf("file") > -1;
        this.serialSinkEnabled = string.indexOf("serial") > -1;
        boolean bl = this.tcpSinkEnabled = string.indexOf("tcp") > -1;
        if (!this.isForcedProbes) {
            this.extractProbes(properties.getProperty("probes"));
        }
    }

    public Properties storeToProperties() {
        Properties properties = new Properties();
        String string = new String();
        if (this.fileSinkEnabled) {
            string = "FILE";
        }
        if (this.serialSinkEnabled) {
            string = string.length() > 0 ? new StringBuffer().append(string).append(", ").append("SERIAL").toString() : "SERIAL";
        }
        if (this.tcpSinkEnabled) {
            string = string.length() > 0 ? new StringBuffer().append(string).append(", ").append("TCP").toString() : "TCP";
        }
        properties.setProperty("sinks", string);
        String string2 = new String();
        if (this.probes.length > 0) {
            string2 = this.probes[0];
        }
        for (int i2 = 1; i2 < this.probes.length; ++i2) {
            string2 = new StringBuffer().append(string2).append(", ").append(this.probes[i2]).toString();
        }
        properties.setProperty("probes", string2);
        return properties;
    }

    public void setActiveDebugProbes(String[] stringArray) {
        if (!this.isForcedProbes) {
            this.probes = stringArray;
        }
    }

    public void setFileSinkEnabled(boolean bl) {
        this.fileSinkEnabled = bl;
    }

    public void setSerialSinkEnabled(boolean bl) {
        this.serialSinkEnabled = bl;
    }

    public void setTcpSinkEnabled(boolean bl) {
        this.tcpSinkEnabled = bl;
    }

    public void setFilters(int n) {
        this.filters = n;
    }

    public void clearFilters() {
        this.setFilters(0);
    }

    public int getFilters() {
        return this.filters;
    }

    public void addFilter(String string) {
        this.setFilters(this.getFilters() | FilterFlagsHelper.getFilterFlags(string));
    }

    public void removeFilter(String string) {
        this.setFilters(this.getFilters() & ~FilterFlagsHelper.getFilterFlags(string));
    }

    public boolean hasFilter(String string) {
        int n = FilterFlagsHelper.getFilterFlags(string);
        return (this.getFilters() & n) == n;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (this.fileSinkEnabled ? 1231 : 1237);
        n2 = 31 * n2 + this.filters;
        n2 = 31 * n2 + DebugProbeManagerConfiguration.hashCode(this.probes);
        n2 = 31 * n2 + (this.serialSinkEnabled ? 1231 : 1237);
        n2 = 31 * n2 + (this.tcpSinkEnabled ? 1231 : 1237);
        return n2;
    }

    private static int hashCode(Object[] objectArray) {
        int n = 31;
        if (objectArray == null) {
            return 0;
        }
        int n2 = 1;
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            n2 = n * n2 + (objectArray[i2] == null ? 0 : objectArray[i2].hashCode());
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        DebugProbeManagerConfiguration debugProbeManagerConfiguration = (DebugProbeManagerConfiguration)object;
        if (this.defaultReader == null ? debugProbeManagerConfiguration.defaultReader != null : !this.defaultReader.equals(debugProbeManagerConfiguration.defaultReader)) {
            return false;
        }
        if (this.fileSinkEnabled != debugProbeManagerConfiguration.fileSinkEnabled) {
            return false;
        }
        if (this.filters != debugProbeManagerConfiguration.filters) {
            return false;
        }
        if (!Arrays.equals(this.probes, debugProbeManagerConfiguration.probes)) {
            return false;
        }
        if (this.serialSinkEnabled != debugProbeManagerConfiguration.serialSinkEnabled) {
            return false;
        }
        return this.tcpSinkEnabled == debugProbeManagerConfiguration.tcpSinkEnabled;
    }

    public String toString() {
        return new StringBuffer().append("DebugProbeManagerConfiguration [probes=").append(this.probes != null ? Arrays.asList(this.probes) : null).append(", fileSinkEnabled=").append(this.fileSinkEnabled).append(", serialSinkEnabled=").append(this.serialSinkEnabled).append(", tcpSinkEnabled=").append(this.tcpSinkEnabled).append(", filters=").append(this.filters).append("]").toString();
    }

    public String getDebugProbeName() {
        return "PROBE_MANAGER";
    }

    static {
        NO_PROBES = new String[0];
    }
}

