/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.internal.ServiceFilter$Condition;
import de.vw.mib.osgi.internal.ServiceFilter$Parser;
import de.vw.mib.osgi.internal.ServiceInfo;
import java.util.Dictionary;
import java.util.HashSet;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;

final class ServiceFilter
implements Filter {
    private ServiceFilter$Condition condition;
    private String filterString;
    private String[] svcInterfaces;

    ServiceFilter(String string) {
        if (string == null) {
            throw new NullPointerException("filter string must not be null");
        }
        this.filterString = string;
        HashSet hashSet = new HashSet();
        this.condition = new ServiceFilter$Parser().parse(this.filterString, hashSet);
        int n = hashSet.size();
        this.svcInterfaces = new String[n];
        if (n > 0) {
            hashSet.toArray(this.svcInterfaces);
        }
    }

    public String[] getServiceInterfaces() {
        return this.svcInterfaces;
    }

    public boolean isServiceInterfaceList() {
        return this.condition.isServiceInterfaceList();
    }

    @Override
    public boolean match(Dictionary dictionary) {
        return this.condition.isFulfilled(dictionary);
    }

    @Override
    public boolean match(ServiceReference serviceReference) {
        return this.match(((ServiceInfo)serviceReference).getProperties());
    }

    @Override
    public String toString() {
        return this.filterString;
    }
}

