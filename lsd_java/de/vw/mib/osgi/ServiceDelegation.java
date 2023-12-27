/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi;

import java.util.Dictionary;

public final class ServiceDelegation {
    protected Object service;
    protected String[] interfaces;
    protected Dictionary properties;

    public ServiceDelegation(String[] stringArray, Object object, Dictionary dictionary) {
        this.service = object;
        this.interfaces = stringArray;
        this.properties = dictionary;
    }

    public void take(ServiceDelegation serviceDelegation) {
        this.service = serviceDelegation.service;
        this.interfaces = serviceDelegation.interfaces;
        this.properties = serviceDelegation.properties;
    }

    public Object getService() {
        return this.service;
    }

    public String[] getInterfaces() {
        return this.interfaces;
    }

    public Dictionary getProperties() {
        return this.properties;
    }

    public void setService(Object object) {
        this.service = object;
    }

    public void setInterfaces(String[] stringArray) {
        this.interfaces = stringArray;
    }

    public void setProperties(Dictionary dictionary) {
        this.properties = dictionary;
    }
}

