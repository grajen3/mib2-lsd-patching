/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.impl;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.jar.Attributes;
import java.util.jar.Attributes$Name;
import java.util.jar.Manifest;

final class ProxyManifest {
    private static final ProxyManifest EMPTY = new ProxyManifest(new String[0], null);
    private static final String NULL_VALUE = null;
    private final String[] keys;
    private final String[] values;

    public static ProxyManifest empty() {
        return EMPTY;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ProxyManifest load(URL uRL) {
        InputStream inputStream = uRL.openStream();
        try {
            Manifest manifest = new Manifest(inputStream);
            Attributes attributes = manifest.getMainAttributes();
            Object[] objectArray = new String[attributes.size()];
            String[] stringArray = new String[attributes.size()];
            int n = 0;
            Iterator iterator = attributes.keySet().iterator();
            while (iterator.hasNext()) {
                String string = ((Attributes$Name)iterator.next()).toString();
                objectArray[n++] = string;
            }
            Arrays.sort(objectArray);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                stringArray[i2] = attributes.getValue((String)objectArray[i2]).trim();
                objectArray[i2] = ((String)objectArray[i2]).trim();
            }
            ProxyManifest proxyManifest = new ProxyManifest((String[])objectArray, stringArray);
            return proxyManifest;
        }
        finally {
            inputStream.close();
        }
    }

    private ProxyManifest(String[] stringArray, String[] stringArray2) {
        this.keys = stringArray;
        this.values = stringArray2;
    }

    public String getAttribute(String string) {
        int n = Arrays.binarySearch(this.keys, string);
        return n >= 0 ? this.values[n] : NULL_VALUE;
    }
}

