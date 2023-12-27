/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result.model;

import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.model.ResultItemIdentifier;
import de.vw.mib.asl.internal.speechengine.result.model.ResultItemIdentifierImpl;
import org.dsi.ifc.speechrec.NBestListEntry;
import org.dsi.ifc.speechrec.NBestSlot;

public class ResultItemImpl
implements ResultItem {
    private NBestListEntry model;
    private int itemId;
    private int groupId;
    private String groupText;
    private int groupSize;

    public ResultItemImpl(int n, NBestListEntry nBestListEntry) {
        this.groupId = nBestListEntry.getGraphemicGroupIndex();
        this.itemId = n;
        this.model = nBestListEntry;
    }

    public ResultItemImpl(int n, String string, int n2) {
        this.groupId = n;
        this.groupText = string;
        this.groupSize = n2;
    }

    @Override
    public String getText() {
        return this.isGroup() ? this.groupText : this.model.getRecognizedString();
    }

    @Override
    public int getSize() {
        return this.isGroup() ? this.groupSize : 0;
    }

    @Override
    public int getGroupIndex() {
        return this.groupId;
    }

    @Override
    public int getItemIndex() {
        return this.itemId;
    }

    @Override
    public int getGroupId() {
        return this.isGroup() ? this.getGroupIndex() : this.model.getGraphemicGroupIndex();
    }

    @Override
    public boolean isGroup() {
        return this.model == null;
    }

    @Override
    public boolean hasGroup() {
        return this.model != null && this.model.getGraphemicGroupIndex() >= 0;
    }

    @Override
    public String getTag() {
        return this.model != null ? this.model.getRecognizedTag() : "-1";
    }

    @Override
    public ResultItemIdentifier getIdentifier() {
        return this.getIdentifier(0);
    }

    @Override
    public ResultItemIdentifier getIdentifier(int n) {
        if (this.model.getSlots() != null && 0 <= n && n <= this.model.getSlots().length - 1) {
            NBestSlot nBestSlot = this.model.getSlots()[n];
            return new ResultItemIdentifierImpl(nBestSlot);
        }
        return new ResultItemIdentifierImpl(new NBestSlot());
    }
}

