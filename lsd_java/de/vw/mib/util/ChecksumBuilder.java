/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.util;

import java.util.zip.Checksum;

public interface ChecksumBuilder
extends Checksum {
    default public Checksum append(byte by) {
    }

    default public Checksum append(int n) {
    }

    default public Checksum append(long l) {
    }

    default public Checksum append(byte[] byArray, int n, int n2) {
    }

    default public Checksum append(byte[] byArray) {
    }

    default public long calcChecksum(byte[] byArray) {
    }
}

