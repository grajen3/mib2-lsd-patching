/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

public final class FeatureDataLocation {
    private static final boolean HAS_DATA;
    private static final boolean NO_DATA;
    private final boolean hasData;
    private final int namespace;
    private final int key;

    private FeatureDataLocation(boolean bl, int n, int n2) {
        this.hasData = bl;
        this.namespace = n;
        this.key = n2;
    }

    public static FeatureDataLocation createNoDataLocation() {
        return new FeatureDataLocation(false, 0, 0);
    }

    public static FeatureDataLocation createLocation(int n, int n2) {
        return new FeatureDataLocation(true, n, n2);
    }

    public boolean hasData() {
        return this.hasData;
    }

    public int getNamespace() {
        return this.namespace;
    }

    public int getKey() {
        return this.key;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (this.hasData ? 1231 : 1237);
        n2 = 31 * n2 + this.key;
        n2 = 31 * n2 + this.namespace;
        return n2;
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
        FeatureDataLocation featureDataLocation = (FeatureDataLocation)object;
        if (this.hasData != featureDataLocation.hasData) {
            return false;
        }
        if (this.key != featureDataLocation.key) {
            return false;
        }
        return this.namespace == featureDataLocation.namespace;
    }
}

