/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.speller;

import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerFactory;
import de.vw.mib.asl.framework.internal.framework.speller.ASLAPISpellerBindingImpl;

public class ASLAPISpellerFactoryImpl
implements ASLAPISpellerFactory {
    @Override
    public ASLAPISpellerBinding createSimple(int n, int n2, int n3) {
        return new ASLAPISpellerBindingImpl(n, n2, n3, -1);
    }

    @Override
    public ASLAPISpellerBinding createSimpleCursor(int n, int n2, int n3, int n4) {
        return new ASLAPISpellerBindingImpl(n, n2, n3, n4);
    }

    @Override
    public ASLAPISpellerBinding createBlockAware(int n, int n2, int n3, int n4, int n5) {
        return new ASLAPISpellerBindingImpl(n, n2, n3, n4, n5, -1);
    }

    @Override
    public ASLAPISpellerBinding createBlockAwareCursor(int n, int n2, int n3, int n4, int n5, int n6) {
        return new ASLAPISpellerBindingImpl(n, n2, n3, n4, n5, n6);
    }
}

