/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.widgets.AbstractTemplateList;
import de.vw.mib.widgets.list.DefaultListControl;
import de.vw.mib.widgets.list.ListControl;

public class ListControlCache {
    private final IntObjectMap cache = new IntObjectOptHashMap();

    public void attachListControl(AbstractTemplateList abstractTemplateList, boolean bl) {
        ListControl listControl = this.selectListControl(abstractTemplateList, bl);
        abstractTemplateList.setListControl(listControl);
    }

    private ListControl selectListControl(AbstractTemplateList abstractTemplateList, boolean bl) {
        if (abstractTemplateList.is_listControlEnabled()) {
            ListControl listControl = this.getOrCreateCachedListControl(abstractTemplateList);
            if (bl) {
                listControl.reset();
            }
            return listControl;
        }
        return new DefaultListControl();
    }

    ListControl getOrCreateCachedListControl(AbstractTemplateList abstractTemplateList) {
        ListControl listControl = (ListControl)this.cache.get(ListControlCache.cacheKey(abstractTemplateList));
        if (listControl == null) {
            listControl = new DefaultListControl();
            this.setCachedListControl(abstractTemplateList, listControl);
        }
        return listControl;
    }

    void setCachedListControl(AbstractTemplateList abstractTemplateList, ListControl listControl) {
        this.cache.put(ListControlCache.cacheKey(abstractTemplateList), listControl);
    }

    private static int cacheKey(AbstractTemplateList abstractTemplateList) {
        return abstractTemplateList.get_targetId();
    }
}

