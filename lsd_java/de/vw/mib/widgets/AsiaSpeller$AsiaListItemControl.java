/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.EmptyListItemControl;
import de.vw.mib.list.ListItemControlListener;
import de.vw.mib.widgets.AsiaSpeller$AsiaListItemControl$EmptyDynamicListData;

abstract class AsiaSpeller$AsiaListItemControl
extends EmptyListItemControl {
    private static final DynamicListData DUMMY_ASL_LIST = new AsiaSpeller$AsiaListItemControl$EmptyDynamicListData();
    private String[] characters;
    private CowList listItemControlListeners = CowList.EMPTY;
    private int listItemLimitation;
    private boolean listItemNotification;

    protected AsiaSpeller$AsiaListItemControl() {
        this(-129, true);
    }

    protected AsiaSpeller$AsiaListItemControl(int n, boolean bl) {
        this.listItemLimitation = n;
        this.listItemNotification = bl;
    }

    @Override
    public final void addListItemControlListener(ListItemControlListener listItemControlListener) {
        this.listItemControlListeners = this.listItemControlListeners.addIfAbsent(listItemControlListener);
    }

    @Override
    public final void removeListItemControlListener(ListItemControlListener listItemControlListener) {
        this.listItemControlListeners = this.listItemControlListeners.remove(listItemControlListener);
    }

    protected final void notifyListItemControlListener() {
        for (CowList cowList = this.listItemControlListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            ListItemControlListener listItemControlListener = (ListItemControlListener)cowList.head();
            listItemControlListener.listChanged(0);
            listItemControlListener.listChanged(this.getItemCount());
        }
    }

    @Override
    public final DynamicListData getASLList() {
        return DUMMY_ASL_LIST;
    }

    public final String getCharacter(int n) {
        if (this.characters == null || n < 0 || n >= this.characters.length || n >= this.listItemLimitation) {
            return null;
        }
        return this.characters[n];
    }

    protected final void setCharacters(String[] stringArray) {
        this.characters = stringArray;
        if (this.listItemNotification) {
            this.notifyListItemControlListener();
        }
    }

    public final void setListItemLimitation(int n) {
        this.listItemLimitation = n;
        if (this.listItemNotification) {
            this.notifyListItemControlListener();
        }
    }

    public final void setListItemNotification(boolean bl) {
        this.listItemNotification = bl;
    }

    @Override
    public final int getItemCount() {
        if (this.characters == null) {
            return 0;
        }
        if (this.characters.length <= this.listItemLimitation) {
            return this.characters.length;
        }
        return this.listItemLimitation;
    }
}

