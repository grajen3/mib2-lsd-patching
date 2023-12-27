/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots;

class SlotDefinitionImpl$InstanceID_ViewType {
    private int instanceID;
    private String viewTypeID;
    private int viewTypeIDNum;

    public SlotDefinitionImpl$InstanceID_ViewType(int n, String string, int n2) {
        this.instanceID = n;
        this.viewTypeID = string;
        this.viewTypeIDNum = n2;
    }

    public int getInstanceID() {
        return this.instanceID;
    }

    public String getViewTypeID() {
        return this.viewTypeID;
    }

    public int getViewTypeIDNum() {
        return this.viewTypeIDNum;
    }
}

