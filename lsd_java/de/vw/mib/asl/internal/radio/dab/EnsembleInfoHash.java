/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import org.dsi.ifc.radio.EnsembleInfo;

public class EnsembleInfoHash {
    public int ensID;
    public int ensECC;

    public EnsembleInfoHash(EnsembleInfo ensembleInfo) {
        this.ensID = ensembleInfo.ensID;
        this.ensECC = ensembleInfo.ensECC;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.ensECC;
        n2 = 31 * n2 + this.ensID;
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
        EnsembleInfoHash ensembleInfoHash = (EnsembleInfoHash)object;
        if (this.ensECC != ensembleInfoHash.ensECC) {
            return false;
        }
        return this.ensID == ensembleInfoHash.ensID;
    }
}

