/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots;

import de.vw.mib.asl.api.speechengine.slotdef.SlotDefinition;
import de.vw.mib.asl.internal.speechengine.slots.SlotDefinitionImpl$InstanceID_ViewType;

public class SlotDefinitionImpl
implements de.vw.mib.asl.api.speechengine.slots.SlotDefinition,
SlotDefinition {
    private String slotName;
    private int slotId;
    private int type;
    private boolean nBest;
    private boolean spellable;
    private String description;
    private boolean needUpdateGrammarState;
    private int recognitionResultIDType;
    private boolean deprecated;
    private SlotDefinitionImpl$InstanceID_ViewType instanceID_ViewType;

    public SlotDefinitionImpl(String string, boolean bl, int n, int n2, boolean bl2, boolean bl3, boolean bl4, int n3, String string2, int n4, String string3, int n5) {
        this.slotName = string;
        this.slotId = n;
        this.type = n2;
        this.nBest = bl2;
        this.spellable = bl3;
        this.needUpdateGrammarState = bl4;
        this.recognitionResultIDType = n3;
        this.description = string2;
        this.deprecated = bl;
        this.instanceID_ViewType = new SlotDefinitionImpl$InstanceID_ViewType(n4, string3, n5);
    }

    public SlotDefinitionImpl(String string, boolean bl, int n, int n2, boolean bl2, boolean bl3, boolean bl4, int n3, String string2) {
        this.slotName = string;
        this.slotId = n;
        this.type = n2;
        this.nBest = bl2;
        this.spellable = bl3;
        this.needUpdateGrammarState = bl4;
        this.recognitionResultIDType = n3;
        this.description = string2;
        this.deprecated = bl;
        this.instanceID_ViewType = null;
    }

    public SlotDefinitionImpl(String string, int n, int n2, boolean bl, boolean bl2, boolean bl3, int n3, String string2, int n4, String string3, int n5) {
        this(string, false, n, n2, bl, bl2, bl3, n3, string2, n4, string3, n5);
    }

    public SlotDefinitionImpl(String string, int n, int n2, boolean bl, boolean bl2, boolean bl3, int n3, String string2) {
        this(string, false, n, n2, bl, bl2, bl3, n3, string2);
    }

    @Override
    public String getSlotName() {
        return this.slotName;
    }

    @Override
    public int getSlotId() {
        return this.slotId;
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public boolean isNBest() {
        return this.nBest;
    }

    @Override
    public boolean isSpellable() {
        return this.spellable;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean isNeedUpdateGrammarState() {
        return this.needUpdateGrammarState;
    }

    @Override
    public int getRecognitionResultIDType() {
        return this.recognitionResultIDType;
    }

    @Override
    public boolean isDeprecated() {
        return this.deprecated;
    }

    @Override
    public Integer getInstanceId() {
        if (this.instanceID_ViewType == null) {
            return null;
        }
        return new Integer(this.instanceID_ViewType.getInstanceID());
    }

    @Override
    public String getViewType() {
        if (this.instanceID_ViewType == null) {
            return null;
        }
        return this.instanceID_ViewType.getViewTypeID();
    }

    @Override
    public Integer getViewTypeNum() {
        if (this.instanceID_ViewType == null) {
            return null;
        }
        return new Integer(this.instanceID_ViewType.getViewTypeIDNum());
    }
}

