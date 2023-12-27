/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.reflection.impl;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class GeneratorArea {
    private static final String PUBLIC_MAO = (class$de$vw$mib$reflection$MethodAccessibleObject == null ? (class$de$vw$mib$reflection$MethodAccessibleObject = GeneratorArea.class$("de.vw.mib.reflection.MethodAccessibleObject")) : class$de$vw$mib$reflection$MethodAccessibleObject).getName();
    private static final int PUBLIC_MAO_ID;
    private static final String PUBLIC_MMAO;
    private static final int PUBLIC_MMAO_ID;
    private static final String PUBLIC_CAO;
    private static final int PUBLIC_CAO_ID;
    private static final String PUBLIC_MCAO;
    private static final int PUBLIC_MCAO_ID;
    private static final String PROXY_J;
    private static final int PROXY_J_ID;
    public static final GeneratorArea PUBLIC_MAO_AREA;
    public static final GeneratorArea PUBLIC_MMAO_AREA;
    public static final GeneratorArea PUBLIC_CAO_AREA;
    public static final GeneratorArea PUBLIC_MCAO_AREA;
    public static final GeneratorArea PROXY_J_AREA;
    private final String name;
    private final int id;
    private final Map classNameCache;
    private final Map classCache;
    static /* synthetic */ Class class$de$vw$mib$reflection$MethodAccessibleObject;
    static /* synthetic */ Class class$de$vw$mib$reflection$MultipleMethodAccessibleObject;
    static /* synthetic */ Class class$de$vw$mib$reflection$ConstructorAccessibleObject;
    static /* synthetic */ Class class$de$vw$mib$reflection$MultipleConstructorAccessibleObject;
    static /* synthetic */ Class class$de$vw$mib$reflection$InvocationHandler;

    private GeneratorArea(String string, int n) {
        this.name = string;
        this.id = n;
        this.classNameCache = new HashMap(1);
        this.classCache = new HashMap(1);
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public Set getClassNameCache(ClassLoader classLoader) {
        Set set = (Set)this.classNameCache.get(classLoader);
        if (set == null) {
            set = new HashSet();
            this.classNameCache.put(classLoader, set);
        }
        return set;
    }

    public IntObjectMap getClassCache(ClassLoader classLoader) {
        IntObjectMap intObjectMap = (IntObjectMap)this.classCache.get(classLoader);
        if (intObjectMap == null) {
            intObjectMap = new IntObjectOptHashMap();
            this.classCache.put(classLoader, intObjectMap);
        }
        return intObjectMap;
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
        return this.id == ((GeneratorArea)object).id;
    }

    public int hashCode() {
        return this.id;
    }

    public String toString() {
        return new StringBuffer().append("area: ").append(this.name).toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        PUBLIC_MMAO = (class$de$vw$mib$reflection$MultipleMethodAccessibleObject == null ? (class$de$vw$mib$reflection$MultipleMethodAccessibleObject = GeneratorArea.class$("de.vw.mib.reflection.MultipleMethodAccessibleObject")) : class$de$vw$mib$reflection$MultipleMethodAccessibleObject).getName();
        PUBLIC_CAO = (class$de$vw$mib$reflection$ConstructorAccessibleObject == null ? (class$de$vw$mib$reflection$ConstructorAccessibleObject = GeneratorArea.class$("de.vw.mib.reflection.ConstructorAccessibleObject")) : class$de$vw$mib$reflection$ConstructorAccessibleObject).getName();
        PUBLIC_MCAO = (class$de$vw$mib$reflection$MultipleConstructorAccessibleObject == null ? (class$de$vw$mib$reflection$MultipleConstructorAccessibleObject = GeneratorArea.class$("de.vw.mib.reflection.MultipleConstructorAccessibleObject")) : class$de$vw$mib$reflection$MultipleConstructorAccessibleObject).getName();
        PROXY_J = (class$de$vw$mib$reflection$InvocationHandler == null ? (class$de$vw$mib$reflection$InvocationHandler = GeneratorArea.class$("de.vw.mib.reflection.InvocationHandler")) : class$de$vw$mib$reflection$InvocationHandler).getName();
        PUBLIC_MAO_AREA = new GeneratorArea(PUBLIC_MAO, 1);
        PUBLIC_MMAO_AREA = new GeneratorArea(PUBLIC_MMAO, 2);
        PUBLIC_CAO_AREA = new GeneratorArea(PUBLIC_CAO, 3);
        PUBLIC_MCAO_AREA = new GeneratorArea(PUBLIC_MCAO, 4);
        PROXY_J_AREA = new GeneratorArea(PROXY_J, 5);
    }
}

