/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.reflection.impl;

class Constants$1 {
    static /* synthetic */ Class class$de$vw$mib$reflection$LightReflection;

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

