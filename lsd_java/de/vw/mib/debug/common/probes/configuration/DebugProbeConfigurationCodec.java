/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.configuration;

import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.probes.configuration.DebugProbeConfigurationDecoderListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Properties;

public final class DebugProbeConfigurationCodec {
    public static final String BEGIN;
    public static final String COMMENT;
    public static final String END;
    public static final String LINEFEED;
    private static StringBuffer BUFFER;
    private static String currentProbeName;
    private static boolean readingPropertiesLines;

    public static Map loadConfiguration(InputStream inputStream) {
        HashMap hashMap = new HashMap();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String string = bufferedReader.readLine();
        while (string != null) {
            if (string.length() != 0) {
                if (readingPropertiesLines) {
                    DebugProbeConfigurationCodec.parsePropertiesLine(string.trim(), hashMap);
                } else {
                    DebugProbeConfigurationCodec.searchingForPropertiesLines(string.trim());
                }
            }
            string = bufferedReader.readLine();
        }
        return hashMap;
    }

    public static void writeConfiguration(Map map, PrintWriter printWriter) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            String string = (String)map$Entry.getKey();
            Properties properties = (Properties)map$Entry.getValue();
            printWriter.print("BEGIN ");
            printWriter.println(string);
            printWriter.println();
            Enumeration enumeration = properties.keys();
            while (enumeration.hasMoreElements()) {
                String string2 = (String)enumeration.nextElement();
                printWriter.print(string2);
                printWriter.print(" = ");
                String string3 = (String)properties.get(string2);
                printWriter.println(string3);
            }
            printWriter.println();
            printWriter.print("END ");
            printWriter.println(string);
            printWriter.println();
            printWriter.println();
        }
    }

    private static Properties createProperties(String string) {
        Properties properties = new Properties();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string.getBytes());
        properties.load(byteArrayInputStream);
        return properties;
    }

    private static void parsePropertiesLine(String string, HashMap hashMap) {
        if (string.startsWith("BEGIN")) {
            throw new IOException("unexpected BEGIN tag found!");
        }
        if (string.startsWith("END")) {
            String string2 = string.substring("END".length() + 1);
            if (!currentProbeName.equals(string2)) {
                throw new IOException("wrong end tag found!");
            }
            String string3 = BUFFER.toString();
            if (string3 != null) {
                hashMap.put(currentProbeName, DebugProbeConfigurationCodec.createProperties(string3));
            }
            readingPropertiesLines = false;
        } else {
            BUFFER.append(string);
            BUFFER.append(LINEFEED);
        }
    }

    private static void searchingForPropertiesLines(String string) {
        if (string.startsWith("BEGIN")) {
            String string2 = string.substring("BEGIN".length() + 1);
            BUFFER = new StringBuffer(256);
            currentProbeName = string2;
            readingPropertiesLines = true;
        } else if (string.startsWith("END")) {
            throw new IOException("unexpected END tag found!");
        }
    }

    public void decode(byte by, ByteArrayReader byteArrayReader, DebugProbeConfigurationDecoderListener debugProbeConfigurationDecoderListener) {
        switch (by) {
            case 0: {
                String string = byteArrayReader.readString();
                byte[] byArray = byteArrayReader.readByteArray();
                debugProbeConfigurationDecoderListener.probeConfigurationBinaryDecoded(string, byArray);
                break;
            }
            case 1: {
                byte[] byArray = byteArrayReader.readByteArray();
                debugProbeConfigurationDecoderListener.probeConfigurationPropertiesDecoded(byArray);
                break;
            }
            case 2: {
                String string = byteArrayReader.readString();
                debugProbeConfigurationDecoderListener.requestConfigurationDecoded(string);
                break;
            }
            case 4: {
                byte[] byArray = byteArrayReader.readByteArray();
                debugProbeConfigurationDecoderListener.probeConfigurationPropertiesDecoded(byArray);
                break;
            }
            case 5: {
                debugProbeConfigurationDecoderListener.probeRequestProbemanagerActiveDecoded();
                break;
            }
            default: {
                throw new IOException("unknown type!");
            }
        }
    }

    static {
        LINEFEED = System.getProperty("line.separator");
        currentProbeName = null;
        readingPropertiesLines = false;
    }
}

