/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.logmanager;

import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.probes.configuration.AbstractDebugProbeConfiguration;
import de.vw.mib.debug.common.probes.logmanager.LogClassifierNames;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Properties;
import java.util.Set;

public class LogManagerProbeConfiguration
extends AbstractDebugProbeConfiguration {
    private static final String KEY_SUBCLASSIFIER_MASK;
    private static final int LENGTH_OF_PROPERTIES_KEY_PREFIX;
    private static final String TRUE;
    private static final String LOGGING_SETTINGS_PREFIX;
    private static final String SEPERATOR;
    private static final int INVALID_ID;
    private boolean override;
    private Map subClassifierMasks = new HashMap();
    private LogClassifierNames classifierNames = new LogClassifierNames();

    public int getClassifierMask() {
        return -1;
    }

    @Override
    public byte getCodecVersion() {
        return -1;
    }

    @Override
    public String getDebugProbeName() {
        return "LOGMANAGER";
    }

    public Map getSubClassifierMasks() {
        return this.subClassifierMasks;
    }

    public boolean isOverride() {
        return true;
    }

    @Override
    public void load(Properties properties) {
        if (properties == null || properties.size() == 0) {
            this.setOverride(true);
            this.setSubClassifierMasks(new HashMap());
        }
        this.subClassifierMasks = new HashMap();
        this.buildSubClassifierMask(properties);
    }

    private void buildSubClassifierMask(Properties properties) {
        Iterator iterator = properties.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            String string = (String)map$Entry.getKey();
            String string2 = (String)map$Entry.getValue();
            if (string.startsWith("logging.subclassifier.mask.")) {
                int n = this.readInt(string.substring(LENGTH_OF_PROPERTIES_KEY_PREFIX));
                this.subClassifierMasks.put(new Integer(n), new Integer(this.readInt(string2)));
                continue;
            }
            if (!"true".equals(string2) || string.startsWith("logging.") || string.startsWith("override.settings")) continue;
            this.activateTrace(string);
        }
    }

    private void activateTrace(String string) {
        int n = string.indexOf(".");
        Integer n2 = new Integer(this.getClassifier(string.substring(0, n)));
        Integer n3 = new Integer(this.getSubClassifier(n2, string.substring(n + 1)));
        Integer n4 = (Integer)this.subClassifierMasks.get(n2);
        Integer n5 = new Integer(n4 == null ? n3 : n4 + n3);
        this.subClassifierMasks.put(n2, n5);
    }

    private int getClassifier(String string) {
        int[] nArray = this.classifierNames.getClassifierIds();
        String[] stringArray = this.classifierNames.getClassifierNames();
        for (int i2 = stringArray.length - 1; i2 >= 0; --i2) {
            if (!string.equals(stringArray[i2])) continue;
            return nArray[i2];
        }
        return -1;
    }

    private int getSubClassifier(int n, String string) {
        String[] stringArray = this.classifierNames.getSubClassifierNames(n);
        for (int i2 = stringArray.length - 1; i2 >= 0; --i2) {
            if (!string.equals(stringArray[i2])) continue;
            return 1 << i2;
        }
        return -1;
    }

    @Override
    public Properties storeToProperties() {
        Properties properties = new Properties();
        Iterator iterator = this.subClassifierMasks.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            int n = (Integer)map$Entry.getKey();
            int n2 = this.getClassifierIdx(n);
            if (n2 == -1) continue;
            String string = this.classifierNames.getClassifierNames()[n2];
            int[] nArray = this.classifierNames.getSubClassifierIds(n);
            String[] stringArray = this.classifierNames.getSubClassifierNames(n);
            int n3 = (Integer)map$Entry.getValue();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int n4 = nArray[i2];
                if ((n3 & n4) == 0) continue;
                properties.setProperty(new StringBuffer().append(string).append(".").append(stringArray[i2]).toString(), "true");
            }
        }
        return properties;
    }

    private int getClassifierIdx(int n) {
        for (int i2 = 0; i2 < this.classifierNames.getClassifierIds().length; ++i2) {
            if (this.classifierNames.getClassifierIds()[i2] != n) continue;
            return i2;
        }
        return -1;
    }

    public void setClassifierMask(int n) {
    }

    public void setOverride(boolean bl) {
    }

    public void setSubClassifierMasks(Map map) {
        this.subClassifierMasks = map;
    }

    @Override
    protected void readBinaryConfiguration(ByteArrayReader byteArrayReader) {
        byteArrayReader.readInt();
        this.subClassifierMasks = new HashMap();
        int n = byteArrayReader.readInt();
        for (int i2 = 0; i2 < n; ++i2) {
            this.subClassifierMasks.put(new Integer(byteArrayReader.readInt()), new Integer(byteArrayReader.readInt()));
        }
        this.override = byteArrayReader.readBoolean();
    }

    @Override
    protected void writeBinaryConfiguration() {
        this.writeInt(-1);
        Set set = this.subClassifierMasks.entrySet();
        this.writeInt(set.size());
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            this.writeInt((Integer)map$Entry.getKey());
            this.writeInt((Integer)map$Entry.getValue());
        }
        this.writeBoolean(this.override);
    }

    static {
        LENGTH_OF_PROPERTIES_KEY_PREFIX = "logging.subclassifier.mask.".length();
    }
}

