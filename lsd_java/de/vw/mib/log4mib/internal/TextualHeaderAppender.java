/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.internal.LogClassifierNames;
import de.vw.mib.log4mib.writer.LogMessageHeaderAppender;
import de.vw.mib.util.StringBuilder;

final class TextualHeaderAppender
implements LogMessageHeaderAppender {
    private static final String UNKNOWN;
    private final IntObjectMap classifierNamesMap;
    private final IntObjectMap subClassifierNamesMaps;
    private final IntObjectMap threadNames;

    TextualHeaderAppender(LogClassifierNames logClassifierNames) {
        this.classifierNamesMap = this.createClassifierNamesMap(logClassifierNames);
        this.subClassifierNamesMaps = this.createSubClassifierNamesMaps(logClassifierNames);
        this.threadNames = this.createThreadNamesMap();
    }

    @Override
    public StringBuilder appendHeader(long l, int n, int n2, int n3, int n4, StringBuilder stringBuilder) {
        stringBuilder.append(l).append(" ").append(this.getLevelName(n));
        stringBuilder.append(this.getThreadName(n4)).append("|");
        stringBuilder.append(this.getClassifierName(n2)).append(".").append(this.getSubClassifierName(n2, n3));
        stringBuilder.append("]");
        return stringBuilder;
    }

    private IntObjectMap createClassifierNamesMap(LogClassifierNames logClassifierNames) {
        int[] nArray = logClassifierNames.getClassifierIds();
        String[] stringArray = logClassifierNames.getClassifierNames();
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            String string = stringArray[i2];
            intObjectOptHashMap.put(n, string);
        }
        return intObjectOptHashMap;
    }

    private IntObjectMap createSubClassifierNamesMaps(LogClassifierNames logClassifierNames) {
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap();
        int[] nArray = logClassifierNames.getClassifierIds();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            String[] stringArray = logClassifierNames.getSubClassifierNames(n);
            IntObjectOptHashMap intObjectOptHashMap2 = new IntObjectOptHashMap();
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                int n2 = 1 << i3;
                String string = stringArray[i3];
                intObjectOptHashMap2.put(n2, string);
            }
            intObjectOptHashMap.put(n, intObjectOptHashMap2);
        }
        return intObjectOptHashMap;
    }

    private IntObjectMap createThreadNamesMap() {
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap();
        intObjectOptHashMap.put("MAIN_THREAD".hashCode(), "Main");
        intObjectOptHashMap.put("Timer-Thread".hashCode(), "Timer");
        intObjectOptHashMap.put("Startup-Thread".hashCode(), "Startup");
        intObjectOptHashMap.put("HSM_Task".hashCode(), "HSM");
        intObjectOptHashMap.put("Startup_Task".hashCode(), "HSM-Startup");
        intObjectOptHashMap.put("DynamicImageLoader".hashCode(), "DynamicImageLoader");
        intObjectOptHashMap.put("INITIAL_LSC".hashCode(), "LSC");
        intObjectOptHashMap.put("UI-Thread".hashCode(), "UI");
        intObjectOptHashMap.put("LATELOAD_BUNDLE_START_THREAD".hashCode(), "Lateload");
        intObjectOptHashMap.put("SWT-Thread".hashCode(), "SWT");
        intObjectOptHashMap.put("Speech-Analyzer-Thread".hashCode(), "Speech-Analyzer");
        intObjectOptHashMap.put("Logging-Thread".hashCode(), "Logging");
        intObjectOptHashMap.put("WATCHDOG".hashCode(), "WATCHDOG");
        intObjectOptHashMap.put("Logging-Heartbeat".hashCode(), "Heartbeat");
        return intObjectOptHashMap;
    }

    private String getClassifierName(int n) {
        String string = (String)this.classifierNamesMap.get(n);
        return string != null ? string : "UNKNOWN";
    }

    private String getLevelName(int n) {
        switch (n) {
            case 16: {
                return " TRACE [";
            }
            case 12: {
                return "NORMAL [";
            }
            case 8: {
                return "  INFO [";
            }
            case 4: {
                return "  WARN [";
            }
            case 2: {
                return " ERROR [";
            }
            case 1: {
                return " FATAL [";
            }
        }
        return "";
    }

    private String getSubClassifierName(int n, int n2) {
        IntObjectMap intObjectMap = (IntObjectMap)this.subClassifierNamesMaps.get(n);
        if (intObjectMap == null) {
            return "UNKNOWN";
        }
        String string = (String)intObjectMap.get(n2);
        return string != null ? string : "UNKNOWN";
    }

    private String getThreadName(int n) {
        String string = this.threadNames.containsKey(n) ? (String)this.threadNames.get(n) : (0 != n ? new StringBuffer().append("0x").append(Integer.toHexString(n)).toString() : "---");
        return string;
    }
}

