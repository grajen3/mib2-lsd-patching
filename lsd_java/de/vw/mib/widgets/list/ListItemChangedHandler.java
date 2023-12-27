/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.list.ListItemChangedListener;
import de.vw.mib.widgets.list.ListValidationControl;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.TemplateListModel;

public class ListItemChangedHandler
implements ListItemChangedListener {
    protected static final Logger LOGGER = ServiceManager.loggerFactory.getLogger(2048);
    private final TemplateListModel list;
    private final ListValidationControl listValidationControl;

    public ListItemChangedHandler(TemplateListModel templateListModel, ListValidationControl listValidationControl) {
        this.list = templateListModel;
        this.listValidationControl = listValidationControl;
    }

    @Override
    public void listItemChanged(ListItemModel listItemModel, int n, int n2, int n3) {
        switch (n) {
            case 0: 
            case 1: {
                this.updateAll(listItemModel, n2, n3);
                break;
            }
            case 2: 
            case 7: {
                this.updateContent(listItemModel, n2, n3);
                break;
            }
            case 3: {
                this.updateActivationHMI(listItemModel, n2, n3);
                break;
            }
            case 4: {
                this.updateActivationAPI(listItemModel, n2, n3);
                break;
            }
            case 5: {
                this.updateSelectiveItem(listItemModel, n2, n3);
                break;
            }
            case 6: {
                this.updateSelectiveItem(listItemModel, n2, -n3);
                break;
            }
            case 8: {
                this.updateStringIndex(listItemModel, n2, n3);
                break;
            }
            case 9: {
                this.updateItemDimension(listItemModel, n2, n3, false);
                break;
            }
            case 10: {
                this.updateItemDimension(listItemModel, n2, n3, true);
                break;
            }
            default: {
                this.updateAll(listItemModel, n2, n3);
            }
        }
    }

    private void updateAll(ListItemModel listItemModel, int n, int n2) {
        boolean bl;
        boolean bl2 = n2 == 0 && !listItemModel.isSubItem();
        boolean bl3 = bl = this.list.is_dynamicItemSize() || bl2;
        if (bl) {
            this.listValidationControl.validateListImmediately(1182794240);
        } else {
            this.listValidationControl.invalidateList(1988102656);
        }
        if (bl2) {
            this.list.setFocusedIndex(-1);
            this.list.resetListView();
        }
        if (this.isTraceEnabled()) {
            this.trace().append("Full update performed for list item '").append(listItemModel).append("'").append(" - itemCount: ").append(listItemModel.getItemCount()).append(" - reset: ").append(bl2).log();
        }
    }

    private void updateContent(ListItemModel listItemModel, int n, int n2) {
        listItemModel.setDataInvalidAll(true);
        if (this.list.is_dynamicItemSize()) {
            this.list.freeze();
            this.list.performLayout();
            this.listValidationControl.validateListImmediately(1024);
            this.list.unfreeze();
        }
        this.listValidationControl.invalidateList(192);
        this.list.repaint();
        if (this.isTraceEnabled()) {
            this.trace().append("Content update performed for item '").append(listItemModel).append("'").log();
        }
    }

    private void updateActivationHMI(ListItemModel listItemModel, int n, int n2) {
        if (listItemModel.hasActivatedSubItem()) {
            this.listValidationControl.resetListInvalidation();
            this.listValidationControl.validateListImmediately(1024, listItemModel);
        }
        this.listValidationControl.invalidateList(16);
        this.list.setActivatedIndex(this.list.getAbsIndexByListItemDynamicIndex(listItemModel, listItemModel.get_activatedIndex()));
        if (this.isTraceEnabled()) {
            this.trace().append("Activated index (HMI) updated for item '").append(listItemModel).append("' - activatedIndex: ").append(listItemModel.get_activatedIndex()).log();
        }
    }

    private void updateActivationAPI(ListItemModel listItemModel, int n, int n2) {
        this.listValidationControl.invalidateList(16);
        if (this.isTraceEnabled()) {
            this.trace().append("Activated index (API) updated for item '").append(listItemModel).append("'").log();
        }
    }

    private void updateSelectiveItem(ListItemModel listItemModel, int n, int n2) {
        this.listValidationControl.validateListImmediately(256, listItemModel, n, n2);
        if (this.isTraceEnabled()) {
            if (n2 < 0) {
                this.trace().append("Items removed for list item '").append(listItemModel).append("' - itemCount: ").append(-listItemModel.getItemCount()).log();
            } else {
                this.trace().append("Items inserted for list item '").append(listItemModel).append("' - itemCount: ").append(listItemModel.getItemCount()).log();
            }
        }
    }

    private void updateStringIndex(ListItemModel listItemModel, int n, int n2) {
        this.listValidationControl.invalidateList();
        if (this.isTraceEnabled()) {
            this.trace().append("String index allocation changed '").append(listItemModel).append("'").log();
        }
    }

    private void updateItemDimension(ListItemModel listItemModel, int n, int n2, boolean bl) {
        boolean bl2 = this.list.isVertical();
        boolean bl3 = this.list.isMultiColumn();
        if (bl3 || bl2 && !bl || !bl2 && bl) {
            this.listValidationControl.invalidateList();
        } else if (this.list.is_dynamicItemSize()) {
            if (listItemModel.get_dynamicResizeDirection() == 0) {
                listItemModel.setDataInvalidAll(true);
            } else {
                listItemModel.performDynamicResizeAll();
            }
            this.list.performLayout();
        }
        if (this.isTraceEnabled()) {
            if (bl) {
                this.trace().append("': Item dimension changed '").append(listItemModel).append("'").append(" - width: ").append(listItemModel.get_width()).log();
            } else {
                this.trace().append("': Item dimension changed '").append(listItemModel).append("'").append(" - height: ").append(listItemModel.get_height()).log();
            }
        }
    }

    private LogMessage trace() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AbstractTemplateList '").append(this.list.getQualifiedName()).append("': ");
        return this.trace(stringBuilder.toString());
    }

    private LogMessage trace(String string) {
        return LOGGER.trace(32).append(string);
    }

    private boolean isTraceEnabled() {
        return LOGGER.isTraceEnabled(32);
    }
}

