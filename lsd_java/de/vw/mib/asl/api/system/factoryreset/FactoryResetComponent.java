/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.factoryreset;

import java.util.HashSet;
import java.util.Set;

public final class FactoryResetComponent {
    private final Set children = new HashSet();
    private final String name;

    public static FactoryResetComponent createChild(FactoryResetComponent factoryResetComponent, String string) {
        FactoryResetComponent.checkArgument(factoryResetComponent != null, "Argument >parent< must not be null! Please use FactoryResetComponent.createRoot(String) instead.");
        return new FactoryResetComponent(factoryResetComponent, string);
    }

    public static FactoryResetComponent createRoot(String string) {
        return new FactoryResetComponent(null, string);
    }

    private static void checkArgument(boolean bl, String string) {
        if (!bl) {
            throw new IllegalArgumentException(string);
        }
    }

    private FactoryResetComponent(FactoryResetComponent factoryResetComponent, String string) {
        FactoryResetComponent.checkArgument(string != null, "Argument >name< must not be null!");
        FactoryResetComponent.checkArgument(!"".equals(string), "Argument >name< must not be empty!");
        this.name = string;
        this.registerThisOn(factoryResetComponent);
    }

    public FactoryResetComponent[] getChildren() {
        Object[] objectArray = new FactoryResetComponent[this.children.size()];
        return (FactoryResetComponent[])this.children.toArray(objectArray);
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return new StringBuffer().append("FactoryResetComponent >").append(this.name).append("< with ").append(this.children.size()).append(" children").toString();
    }

    private void registerThisOn(FactoryResetComponent factoryResetComponent) {
        if (factoryResetComponent != null) {
            factoryResetComponent.children.add(this);
        }
    }
}

