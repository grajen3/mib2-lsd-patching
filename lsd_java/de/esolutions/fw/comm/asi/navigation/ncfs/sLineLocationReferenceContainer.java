/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

import de.esolutions.fw.comm.asi.navigation.ncfs.sOLRLocationReference;
import de.esolutions.fw.comm.asi.navigation.ncfs.sTmcLocationReference;

public class sLineLocationReferenceContainer {
    public int validLocationReference;
    public sOLRLocationReference OLRLocation;
    public sTmcLocationReference TMCLocation;

    public int getValidLocationReference() {
        return this.validLocationReference;
    }

    public void setValidLocationReference(int n) {
        this.validLocationReference = n;
    }

    public sOLRLocationReference getOLRLocation() {
        return this.OLRLocation;
    }

    public void setOLRLocation(sOLRLocationReference sOLRLocationReference2) {
        this.OLRLocation = sOLRLocationReference2;
    }

    public sTmcLocationReference getTMCLocation() {
        return this.TMCLocation;
    }

    public void setTMCLocation(sTmcLocationReference sTmcLocationReference2) {
        this.TMCLocation = sTmcLocationReference2;
    }

    public sLineLocationReferenceContainer() {
        this.OLRLocation = null;
        this.TMCLocation = null;
    }

    public sLineLocationReferenceContainer(int n, sOLRLocationReference sOLRLocationReference2, sTmcLocationReference sTmcLocationReference2) {
        this.validLocationReference = n;
        this.OLRLocation = sOLRLocationReference2;
        this.TMCLocation = sTmcLocationReference2;
    }

    public String toString() {
        return new StringBuffer("sLineLocationReferenceContainer{").append("validLocationReference=").append(this.validLocationReference).append(", OLRLocation=").append(this.OLRLocation).append(", TMCLocation=").append(this.TMCLocation).append("}").toString();
    }
}

