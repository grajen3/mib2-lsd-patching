/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Properties;
import java.util.Set;

public abstract class Provider
extends Properties {
    private static final long serialVersionUID;
    private String name;
    private String info;
    private double version;

    protected Provider(String string, double d2, String string2) {
        this.name = string;
        this.version = d2;
        this.info = string2;
    }

    @Override
    public synchronized void clear() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess(new StringBuffer("clearProviderProperties.").append(this.name).toString());
        }
        super.clear();
    }

    @Override
    public Set entrySet() {
        return Collections.unmodifiableSet(super.entrySet());
    }

    public String getInfo() {
        return this.info;
    }

    public String getName() {
        return this.name;
    }

    public double getVersion() {
        return this.version;
    }

    @Override
    public Set keySet() {
        return Collections.unmodifiableSet(super.keySet());
    }

    @Override
    public synchronized void load(InputStream inputStream) {
        super.load(inputStream);
    }

    @Override
    public synchronized Object put(Object object, Object object2) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess(new StringBuffer("putProviderProperty.").append(this.name).toString());
        }
        return super.put(object, object2);
    }

    @Override
    public synchronized void putAll(Map map) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess(new StringBuffer("putProviderProperty.").append(this.name).toString());
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            super.put(map$Entry.getKey(), map$Entry.getValue());
        }
    }

    @Override
    public synchronized Object remove(Object object) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess(new StringBuffer("removeProviderProperty.").append(this.name).toString());
        }
        return super.remove(object);
    }

    @Override
    public String toString() {
        return new StringBuffer(String.valueOf(this.name)).append(" version ").append(this.version).toString();
    }

    @Override
    public Collection values() {
        return Collections.unmodifiableCollection(super.values());
    }

    @Override
    public String getProperty(String string, String string2) {
        String string3 = this.getProperty(string);
        if (string3 == null) {
            return string2;
        }
        return string2;
    }

    @Override
    public String getProperty(String string) {
        int n = string.indexOf(46);
        if (n == -1) {
            return null;
        }
        String string2 = string.substring(0, n + 1);
        String string3 = string.substring(n + 1, string.length());
        return this.lookupProperty(string2, string3);
    }

    String lookupProperty(String string) {
        String string2 = super.getProperty(string);
        if (string2 != null) {
            return string2;
        }
        String string3 = string.toUpperCase();
        Enumeration enumeration = this.keys();
        while (enumeration.hasMoreElements()) {
            String string4 = (String)enumeration.nextElement();
            if (!string4.toUpperCase().equals(string3)) continue;
            return this.getProperty(string4);
        }
        return null;
    }

    String lookupProperty(String string, String string2) {
        String string3 = new StringBuffer(String.valueOf(string)).append(string2).toString();
        String string4 = this.lookupProperty(string3);
        if (string4 != null) {
            return string4;
        }
        string4 = this.lookupProperty(new StringBuffer("Alg.Alias.").append(string3).toString());
        if (string4 != null) {
            return this.lookupProperty(new StringBuffer(String.valueOf(string)).append(string4).toString());
        }
        return null;
    }
}

