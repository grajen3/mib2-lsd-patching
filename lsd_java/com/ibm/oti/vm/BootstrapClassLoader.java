/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.util.Msg;
import com.ibm.oti.vm.AbstractClassLoader;
import com.ibm.oti.vm.BootstrapClassLoader$FindClassLock;
import com.ibm.oti.vm.VM;
import java.util.Enumeration;
import java.util.Hashtable;

public final class BootstrapClassLoader
extends AbstractClassLoader {
    private static BootstrapClassLoader singleton;
    private static Object findClassLock;
    private Hashtable packages = new Hashtable();
    private volatile boolean defining = false;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;

    static {
        Class clazz;
        VM.initializeVM();
        Class clazz2 = class$0;
        if (clazz2 == null) {
            try {
                clazz2 = class$0 = Class.forName("java.lang.Integer");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        if ((clazz = class$1) == null) {
            try {
                clazz = class$1 = Class.forName("java.util.Arrays");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        findClassLock = new BootstrapClassLoader$FindClassLock();
    }

    private BootstrapClassLoader() {
        int n = VM.getClassPathCount();
        this.types = new int[n];
        this.cache = new Object[n];
        this.parsedPath = new String[n];
        VM.initializeClassLoader(this, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Class loadClass(String string) {
        Class clazz;
        Object object = findClassLock;
        synchronized (object) {
            clazz = VM.findClassOrNull(string, this);
        }
        if (clazz != null && (object = this.getPackageName(clazz)) != null && super.getPackage((String)object) == null) {
            int n = VM.getCPIndexImpl(clazz);
            this.addPackage((String)object, n);
        }
        return clazz;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addPackage(String string, int n) {
        Hashtable hashtable = this.packages;
        synchronized (hashtable) {
            if (!this.packages.containsKey(string)) {
                this.packages.put(string, new Integer(n));
            }
        }
    }

    public static ClassLoader singleton() {
        if (singleton != null) {
            throw new SecurityException(Msg.getString("K0084"));
        }
        singleton = new BootstrapClassLoader();
        return singleton;
    }

    @Override
    protected Package getPackage(String string) {
        if (this.packages.size() > 0) {
            this.definePackages();
        }
        return super.getPackage(string);
    }

    @Override
    protected Package[] getPackages() {
        if (this.packages.size() > 0) {
            this.definePackages();
        }
        return super.getPackages();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void definePackages() {
        if (this.defining) {
            return;
        }
        while (true) {
            Hashtable hashtable = null;
            Hashtable hashtable2 = this.packages;
            synchronized (hashtable2) {
                if (this.packages.size() == 0) {
                    return;
                }
                hashtable = (Hashtable)this.packages.clone();
                this.packages.clear();
            }
            if (hashtable == null) continue;
            this.defining = true;
            try {
                this.definePackages(hashtable);
                continue;
            }
            finally {
                this.defining = false;
                continue;
            }
            break;
        }
    }

    private void definePackages(Hashtable hashtable) {
        Enumeration enumeration = hashtable.keys();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            this.definePackage(string, (Integer)hashtable.get(string));
        }
    }
}

