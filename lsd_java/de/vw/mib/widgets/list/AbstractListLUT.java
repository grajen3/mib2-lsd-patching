/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.list.StringIndex;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.ListItem;
import de.vw.mib.widgets.interfaces.WidgetCloneFactory;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.layout.Layoutable;
import de.vw.mib.widgets.list.ListLUT;
import de.vw.mib.widgets.models.ListItemModel;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractListLUT
implements ListLUT {
    private static final int LETTER_SCROLLING_BLOCK_SIZE;
    private static final int LETTER_SCROLLING_MIN_INDICES;
    protected ListItemModel[] listItems;
    protected int[] lutCloneIDs;
    protected int[] letterScrollingIndices;
    protected int[] letterScrollingLayoutValues;
    protected String[] letterScrollingTexts;
    protected int letterScrollingLayoutValueNumber;
    protected Layoutable layoutable;
    protected int layoutValueCount = 0;
    protected int itemCount;
    protected int firstVisibleIndexOld = -1;
    protected int lastVisibleIndexOld = -1;
    protected boolean clonesFullRefresh = true;
    protected boolean orderInverted = false;
    protected static Logger LOGGER;

    public AbstractListLUT() {
        if (null == LOGGER) {
            LOGGER = ServiceManager.loggerFactory.getLogger(2048);
        }
        this.initLUT();
    }

    protected void initLUT() {
        this.lutCloneIDs = null;
    }

    @Override
    public void dispose() {
        this.layoutable = null;
        this.listItems = null;
    }

    @Override
    public int getItemCount() {
        return this.itemCount;
    }

    @Override
    public int getCloneID(int n) {
        int n2 = n - this.firstVisibleIndexOld;
        if (this.lutCloneIDs != null && n2 >= 0 && n2 < this.lutCloneIDs.length) {
            return this.lutCloneIDs[n2];
        }
        return -1;
    }

    @Override
    public void setLayoutValueCount(int n) {
        this.layoutValueCount = n;
    }

    @Override
    public void setLetterScrollingLayoutValueNumber(int n) {
        this.letterScrollingLayoutValueNumber = n;
    }

    @Override
    public int findLayoutValueItemIndex(int n, int n2, int n3, boolean bl) {
        int n4 = n3;
        int n5 = Math.abs(n - this.getItemLayoutValue(n4, n2));
        boolean bl2 = false;
        if (bl) {
            while (!bl2) {
                int n6 = n5;
                n5 = Math.abs(n - this.getItemLayoutValue(n4, n2));
                if (n5 > n6) {
                    --n4;
                    bl2 = true;
                    continue;
                }
                if (n4 >= this.itemCount - 1) {
                    bl2 = true;
                    continue;
                }
                ++n4;
            }
        } else {
            while (!bl2) {
                int n7 = n5;
                n5 = Math.abs(n - this.getItemLayoutValue(n4, n2));
                if (n5 > n7) {
                    ++n4;
                    bl2 = true;
                    continue;
                }
                if (n4 <= 0) {
                    bl2 = true;
                    continue;
                }
                --n4;
            }
        }
        return n4;
    }

    @Override
    public void setLayoutable(Layoutable layoutable) {
        this.layoutable = layoutable;
    }

    @Override
    public int getLayoutIndexFirst() {
        return 0;
    }

    @Override
    public int getLayoutIndexLast() {
        return this.itemCount - 1;
    }

    @Override
    public void update(ListItemModel[] listItemModelArray, boolean bl, boolean bl2) {
        this.listItems = listItemModelArray;
        this.orderInverted = bl2;
        this.letterScrollingIndices = null;
        this.letterScrollingTexts = null;
        this.letterScrollingLayoutValues = null;
        this.updateItemCount();
        this.initLUT();
        this.updateItemLUT();
        this.updateItemActivation();
        if (bl) {
            this.updateLetterIndices();
        }
    }

    @Override
    public void validateClones(WidgetCloneFactory widgetCloneFactory, int n, int n2, boolean bl) {
        int n3 = n;
        int n4 = this.lutCloneIDs == null ? Util.clamp(n2 + 1, 0, this.itemCount - 1) : n2;
        int[] nArray = this.getCloneConfiguration(n3, n4);
        int n5 = n2 - n + 1;
        if (this.lutCloneIDs == null || this.lutCloneIDs.length != n5) {
            this.lutCloneIDs = this.initLUT(n5, -1);
        }
        if (widgetCloneFactory != null && nArray != null) {
            Object object;
            int n6;
            for (n6 = 0; n6 < this.listItems.length; ++n6) {
                ListItemModel listItemModel = this.listItems[n6];
                object = listItemModel.getItemClones();
                if (object.size() == 0) {
                    object.add(listItemModel);
                }
                while (object.size() < nArray[n6]) {
                    object.add(this.createClone(widgetCloneFactory, listItemModel));
                    this.clonesFullRefresh = true;
                }
                if (listItemModel.getDragItemClone() == listItemModel && bl) {
                    listItemModel.setDragItemClone(this.createClone(widgetCloneFactory, listItemModel));
                }
                if (listItemModel.getHelperItemClone() == listItemModel) {
                    listItemModel.setHelperItemClone(this.createClone(widgetCloneFactory, listItemModel));
                }
                listItemModel.setAssignedAll(false);
            }
            for (n6 = n; n6 <= n2; ++n6) {
                int n7 = this.getItemID(n6);
                object = this.listItems[n7];
                int n8 = object.isSubItem() && object.hasSubSlider() ? this.getRelativeIndex(n6 - 1) : this.getRelativeIndex(n6);
                int n9 = n8 % object.getItemClones().size();
                if (n9 != -1) {
                    object = (ListItemModel)object.getItemClones().get(n9);
                }
                boolean bl2 = object.isDataInvalid() || this.clonesFullRefresh || n6 < this.firstVisibleIndexOld || n6 > this.lastVisibleIndexOld;
                object.setDataInvalid(bl2);
                if (bl2) {
                    object.setAbsoluteIndex(-1);
                }
                object.setItemNumber(-2);
                object.setAssigned(true);
                this.lutCloneIDs[n6 - n] = n9;
            }
        }
        this.firstVisibleIndexOld = n;
        this.lastVisibleIndexOld = n2;
        this.clonesFullRefresh = false;
    }

    @Override
    public void destroyClones(WidgetCloneFactory widgetCloneFactory, ListItemModel[] listItemModelArray) {
        if (widgetCloneFactory != null && listItemModelArray != null) {
            for (int i2 = 0; i2 < listItemModelArray.length; ++i2) {
                ListItemModel listItemModel = listItemModelArray[i2];
                List list = listItemModel.getItemClones();
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    ListItemModel listItemModel2 = (ListItemModel)iterator.next();
                    if (listItemModel == listItemModel2) continue;
                    this.destroyClone(widgetCloneFactory, listItemModel2);
                }
                list.clear();
                if (listItemModel.getDragItemClone() != null && listItemModel.getDragItemClone() != listItemModel) {
                    this.destroyClone(widgetCloneFactory, listItemModel.getDragItemClone());
                }
                listItemModel.setDragItemClone(null);
                if (listItemModel.getHelperItemClone() != null && listItemModel.getHelperItemClone() != listItemModel) {
                    this.destroyClone(widgetCloneFactory, listItemModel.getHelperItemClone());
                }
                listItemModel.setHelperItemClone(null);
            }
        }
        this.lutCloneIDs = null;
    }

    @Override
    public boolean isLetterScrollingSupported() {
        return this.letterScrollingIndices != null;
    }

    @Override
    public int getLetterScrollingCount() {
        return this.letterScrollingIndices != null ? this.letterScrollingIndices.length : 0;
    }

    @Override
    public int getLetterScrollingAbsIndex(int n) {
        int n2 = -1;
        if (this.letterScrollingIndices != null && this.letterScrollingIndices.length > n && n >= 0) {
            n2 = this.letterScrollingIndices[n];
        }
        return n2;
    }

    @Override
    public String getLetterScrollingText(int n) {
        String string = null;
        if (this.letterScrollingTexts != null && this.letterScrollingTexts.length > n && n >= 0) {
            string = this.letterScrollingTexts[n];
        }
        return string;
    }

    @Override
    public int getLetterScrollingIndexByAbsIndex(int n) {
        int n2;
        if (this.letterScrollingIndices != null) {
            for (n2 = 0; n2 < this.letterScrollingIndices.length - 1 && this.getItemIndex(n) > this.letterScrollingIndices[n2]; ++n2) {
            }
        }
        return n2;
    }

    @Override
    public int getLetterScrollingIndexByLayoutValue(int n) {
        int n2;
        if (this.letterScrollingLayoutValues != null) {
            for (n2 = 0; n2 < this.letterScrollingLayoutValues.length - 1 && n > this.letterScrollingLayoutValues[n2]; ++n2) {
            }
        }
        return n2;
    }

    private ListItemModel createClone(WidgetCloneFactory widgetCloneFactory, ListItemModel listItemModel) {
        ListItem listItem = (ListItem)widgetCloneFactory.createWidgetCloneable(listItemModel);
        listItem.setParent((AbstractWidget)listItemModel.getParent());
        listItem.set_visible(listItemModel.is_visible());
        listItem.setSubItem(listItemModel.isSubItem());
        listItem.init(listItemModel.getView());
        listItem.activate();
        return listItem;
    }

    private void destroyClone(WidgetCloneFactory widgetCloneFactory, ListItemModel listItemModel) {
        listItemModel.deActivate();
        listItemModel.stopInternalAnimations();
        listItemModel.deInit();
        widgetCloneFactory.destroyWidgetCloneable(listItemModel);
    }

    protected void updateItemLUT() {
        if (this.listItems == null) {
            return;
        }
        int n = 0;
        if (this.orderInverted) {
            for (int i2 = this.listItems.length - 1; i2 >= 0; --i2) {
                n = this.updateItemLUT(i2, n);
            }
        } else {
            for (int i3 = 0; i3 < this.listItems.length; ++i3) {
                n = this.updateItemLUT(i3, n);
            }
        }
        this.clonesFullRefresh = true;
    }

    private int updateItemLUT(int n, int n2) {
        ListItemModel listItemModel = this.listItems[n];
        int n3 = listItemModel.getExistenceItemCount();
        if (!listItemModel.isSubItem() && n3 > 0) {
            if (listItemModel.hasActivatedSubItem()) {
                int n4 = Util.clamp(listItemModel.getRelativeItemIndex(listItemModel.get_activatedIndex()), -1, n3 - 1);
                int n5 = Util.clamp(listItemModel.getRelativeItemIndex(listItemModel.getActivatedIndexPrev()), -1, n3 - 1);
                int n6 = Math.min(n4, n5);
                int n7 = Math.max(n4, n5);
                int n8 = 0;
                if (n6 != -1) {
                    n2 = this.addItemBlock(n, n2, n8, n6);
                    n2 = this.addSubItemBlock(n, n2);
                    n8 = n6 + 1;
                }
                if (n7 != -1) {
                    n2 = this.addItemBlock(n, n2, n8, n7);
                    n2 = this.addSubItemBlock(n, n2);
                    n8 = n7 + 1;
                }
                n2 = this.addItemBlock(n, n2, n8, listItemModel.getExistenceItemCount() - 1);
            } else {
                n2 = this.addItemBlock(n, n2);
            }
        }
        return n2;
    }

    private void updateItemCount() {
        int n = 0;
        if (this.listItems != null) {
            for (int i2 = 0; i2 < this.listItems.length; ++i2) {
                ListItemModel listItemModel = this.listItems[i2];
                if (listItemModel.isSubItem() || listItemModel.getExistenceItemCount() <= 0) continue;
                n += listItemModel.getExistenceItemCount();
                if (!listItemModel.hasActivatedSubItem()) continue;
                for (int i3 = 0; i3 < listItemModel.get_subItemRefs().length; ++i3) {
                    ListItemModel listItemModel2 = listItemModel.get_subItemRefs()[i3];
                    if (listItemModel2 == null || !listItemModel2.is_visible()) continue;
                    n += this.hasMultiActivation(listItemModel) ? 2 * listItemModel2.getExistenceItemCount() : listItemModel2.getExistenceItemCount();
                }
            }
        }
        this.itemCount = n;
    }

    private void updateItemActivation() {
        if (this.listItems != null) {
            for (int i2 = 0; i2 < this.listItems.length; ++i2) {
                ListItemModel listItemModel = this.listItems[i2];
                if (listItemModel.isSubItem()) continue;
                listItemModel.setActive(listItemModel.getExistenceItemCount() > 0);
                if (!listItemModel.hasSubItem()) continue;
                for (int i3 = 0; i3 < listItemModel.get_subItemRefs().length; ++i3) {
                    ListItemModel listItemModel2 = listItemModel.get_subItemRefs()[i3];
                    if (listItemModel2 == null) continue;
                    listItemModel2.setActive(listItemModel.hasActivatedSubItem());
                }
            }
        }
    }

    private void updateLetterIndices() {
        if (this.listItems != null) {
            boolean bl = false;
            for (int i2 = 0; i2 < this.listItems.length && !bl; ++i2) {
                ListItemModel listItemModel = this.listItems[i2];
                listItemModel.freeze();
                if (listItemModel.isStringIndexSupported() && listItemModel.getItemCount() > 0) {
                    this.prepareLetterIndices(listItemModel);
                    bl = true;
                }
                listItemModel.unfreeze();
            }
        }
    }

    private void prepareLetterIndices(ListItemModel listItemModel) {
        StringIndex stringIndex = listItemModel.getStringIndex();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        IntArrayList intArrayList = new IntArrayList();
        int n = listItemModel.getItemCount();
        if (stringIndex.getRowIndexes() != null && stringIndex.getStringIndexes() != null) {
            String[] stringArray = stringIndex.getStringIndexes();
            int[] nArray = stringIndex.getRowIndexes();
            int n2 = stringIndex.getStringIndexes().length;
            for (int i2 = 0; i2 < n2; ++i2) {
                String string = stringArray[i2];
                int n3 = nArray[i2];
                int n4 = i2 < n2 - 1 ? nArray[i2 + 1] : n - 1;
                for (int i3 = n3; i3 < n4; i3 += 50) {
                    objectArrayList.add(string);
                    intArrayList.add(i3);
                }
            }
            this.letterScrollingTexts = new String[objectArrayList.size()];
            this.letterScrollingIndices = new int[intArrayList.size()];
            this.letterScrollingLayoutValues = new int[this.letterScrollingIndices.length];
            objectArrayList.toArray(this.letterScrollingTexts);
            intArrayList.toArray(this.letterScrollingIndices);
            this.translateLetterIndices(listItemModel);
            if (LOGGER.isTraceEnabled(32)) {
                int n5;
                LOGGER.trace(32).append("AbstractListLUT#prepareLetterIndices for item '").append(listItemModel).append("'").log();
                LogMessage logMessage = LOGGER.trace(32);
                logMessage.append("RAW-Mapping: ");
                for (n5 = 0; n5 < stringArray.length; ++n5) {
                    logMessage.append(stringArray[n5]).append(":").append(nArray[n5]).append(" ");
                }
                logMessage.log();
                logMessage = LOGGER.trace(32);
                logMessage.append("GUI-Mapping: ");
                for (n5 = 0; n5 < this.letterScrollingIndices.length; ++n5) {
                    logMessage.append(this.letterScrollingTexts[n5]).append(":").append(this.letterScrollingIndices[n5]).append("@").append(this.letterScrollingLayoutValues[n5]).append(" ");
                }
                logMessage.log();
            }
            if (intArrayList.size() < 5) {
                LOGGER.warn(32).append("AbstractListLUT#prepareLetterIndices for item '").append(listItemModel).append("': Minimum number of letter indices not reached (<").append(5).append("). Feature disabled.").log();
                this.letterScrollingIndices = null;
                this.letterScrollingTexts = null;
                return;
            }
            if (nArray[n2 - 1] >= n) {
                LOGGER.warn(32).append("AbstractListLUT#prepareLetterIndices for item '").append(listItemModel).append("': Letter index range exceeds item count (").append(listItemModel.getItemCount()).append("). Feature disabled.").log();
                this.letterScrollingIndices = null;
                this.letterScrollingTexts = null;
                return;
            }
        }
    }

    private void translateLetterIndices(ListItemModel listItemModel) {
        if (this.letterScrollingIndices != null && this.letterScrollingIndices.length > 0) {
            int n = listItemModel.getItemCount();
            this.letterScrollingIndices[0] = 0;
            this.letterScrollingIndices[this.letterScrollingIndices.length - 1] = n - 1;
            for (int i2 = 1; i2 < this.letterScrollingIndices.length - 1; ++i2) {
                this.letterScrollingIndices[i2] = this.getAbsIndexByListItemDynamicIndex(listItemModel, Util.clamp(this.letterScrollingIndices[i2], 0, n - 1));
                this.letterScrollingLayoutValues[i2] = this.getItemLayoutValue(this.letterScrollingIndices[i2], this.letterScrollingLayoutValueNumber);
            }
        }
    }

    private int[] getCloneConfiguration(int n, int n2) {
        int[] nArray = null;
        if (this.listItems != null && this.listItems.length > 0 && n >= 0 && n2 < this.itemCount) {
            int n3;
            nArray = new int[this.listItems.length];
            for (n3 = n; n3 <= n2; ++n3) {
                int n4 = this.getItemID(n3);
                nArray[n4] = nArray[n4] + 1;
            }
            for (n3 = 0; n3 < this.listItems.length; ++n3) {
                int n5;
                ListItemModel listItemModel = this.listItems[n3];
                if (!listItemModel.isSubItem() || !listItemModel.hasSubSlider() || (n5 = this.getMainItemIDForSubItem(listItemModel)) < 0) continue;
                nArray[n3] = Math.max(nArray[n3], nArray[n5]);
            }
        }
        return nArray;
    }

    private boolean hasMultiActivation(ListItemModel listItemModel) {
        return listItemModel.get_activatedIndex() != -1 && listItemModel.getActivatedIndexPrev() != -1;
    }

    private int getMainItemIDForSubItem(ListItemModel listItemModel) {
        if (this.listItems != null) {
            for (int i2 = 0; i2 < this.listItems.length; ++i2) {
                ListItemModel listItemModel2 = this.listItems[i2];
                if (!listItemModel2.hasSubItem()) continue;
                ListItemModel[] listItemModelArray = listItemModel2.get_subItemRefs();
                for (int i3 = 0; i3 < listItemModelArray.length; ++i3) {
                    if (listItemModelArray[i3] != listItemModel) continue;
                    return i2;
                }
            }
        }
        return -1;
    }

    protected int[] initLUT(int n, int n2) {
        int[] nArray = new int[n >= 0 ? n : 0];
        for (int i2 = 0; i2 < n; ++i2) {
            nArray[i2] = n2;
        }
        return nArray;
    }

    protected int[][] initLUT(int n, int n2, int n3) {
        int[][] nArray = new int[n][n2];
        for (int i2 = 0; i2 < n; ++i2) {
            nArray[i2] = this.initLUT(n2, n3);
        }
        return nArray;
    }

    protected abstract void addItem(int n, int n2, int n3) {
    }

    protected abstract int addItemBlock(int n, int n2) {
    }

    protected abstract int addItemBlock(int n, int n2, int n3, int n4) {
    }

    protected int addSubItemBlock(int n, int n2) {
        ListItemModel listItemModel = this.listItems[n];
        int n3 = n2;
        for (int i2 = 0; i2 < listItemModel.get_subItemRefs().length; ++i2) {
            int n4;
            if (listItemModel.get_subItemRefs()[i2] == null || (n4 = this.getListItemID(listItemModel.get_subItemRefs()[i2])) == -1) continue;
            n3 = this.addItemBlock(n4, n3);
        }
        return n3;
    }

    private int getListItemID(ListItemModel listItemModel) {
        for (int i2 = 0; i2 < this.listItems.length; ++i2) {
            if (this.listItems[i2] != listItemModel) continue;
            return i2;
        }
        return -1;
    }

    protected abstract int getRelativeIndex(int n) {
    }
}

