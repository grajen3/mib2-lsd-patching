/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.framework.speller;

import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;

public interface ASLAPISpellerFactory {
    default public ASLAPISpellerBinding createSimple(int n, int n2, int n3) {
    }

    default public ASLAPISpellerBinding createSimpleCursor(int n, int n2, int n3, int n4) {
    }

    default public ASLAPISpellerBinding createBlockAware(int n, int n2, int n3, int n4, int n5) {
    }

    default public ASLAPISpellerBinding createBlockAwareCursor(int n, int n2, int n3, int n4, int n5, int n6) {
    }
}

