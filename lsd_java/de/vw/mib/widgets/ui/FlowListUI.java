/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.FlowListModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.ui.AbstractTemplateListUI;

public final class FlowListUI
extends AbstractTemplateListUI {
    private final Rectangle childBounds = new Rectangle();

    @Override
    public void paintItems(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        int n;
        int n2;
        boolean bl;
        FlowListModel flowListModel = (FlowListModel)templateListModel;
        boolean bl2 = bl = flowListModel.get_outline() == 13;
        if (bl) {
            this.enableClipping(graphics3D, rectangle, new Rectangle(0, 0, flowListModel.get_width(), flowListModel.get_height()), rectangle2);
        }
        flowListModel.validateLayout();
        int n3 = flowListModel.getVisibleItemCount();
        boolean bl3 = viewModel.is_renderBoundingBoxes();
        for (n2 = n3 - 1; n2 >= 0; --n2) {
            n = flowListModel.getChildIndex(n2);
            ListItemModel listItemModel = flowListModel.getItem(flowListModel.getRealIndex(n2));
            if (listItemModel == null) continue;
            flowListModel.transferData(listItemModel, n, flowListModel.getItemIndex(n));
        }
        n2 = flowListModel.get_outline();
        if (n2 == 11 || n2 == 12 || n2 == 10) {
            for (n = 0; n < n3; ++n) {
                this.paintFlowListItem(graphics3D, viewModel, rectangle, bl3, f2, flowListModel, rectangle2, n, 0);
            }
        } else {
            graphics3D.setStencilTestEnabled(true);
            graphics3D.setStencilBufferEnabled(1);
            graphics3D.clearStencilBuffer(0);
            graphics3D.setStencilTest(7, 1, 1);
            graphics3D.setStencilOperation(2, 2, 2);
            graphics3D.setAlphaTestEnabled(true);
            graphics3D.setAlphaTest(4, 0.0f);
            for (n = 0; n < n3; ++n) {
                this.paintFlowListItem(graphics3D, viewModel, rectangle, bl3, f2, flowListModel, rectangle2, n, 1);
            }
            graphics3D.setStencilTest(6, 1, 1);
            for (n = n3 - 1; n >= 0; --n) {
                this.paintFlowListItem(graphics3D, viewModel, rectangle, bl3, f2, flowListModel, rectangle2, n, 2);
            }
            graphics3D.setStencilTestEnabled(false);
            graphics3D.setAlphaTestEnabled(false);
        }
        n = flowListModel.getEnabledItemCount();
        for (int i2 = 0; i2 < Math.min(n, FlowListModel.PREFETCH_ITEM_COUNT); ++i2) {
            int n4 = flowListModel.getAbsIndexByEnabledIndex(flowListModel.getFirstVisibleIndex() + i2);
            ListItemModel listItemModel = flowListModel.getItem(n4);
            if (listItemModel != null) {
                flowListModel.transferData(listItemModel, n4, flowListModel.getItemIndex(n4));
            }
            if ((listItemModel = flowListModel.getItem(n4 = flowListModel.getAbsIndexByEnabledIndex(flowListModel.getLastVisibleIndex() - i2))) == null) continue;
            flowListModel.transferData(listItemModel, n4, flowListModel.getItemIndex(n4));
        }
        if (bl) {
            this.disableClipping(graphics3D);
        }
    }

    private void paintFlowListItem(Graphics3D graphics3D, ViewModel viewModel, Rectangle rectangle, boolean bl, float f2, FlowListModel flowListModel, Rectangle rectangle2, int n, int n2) {
        int n3 = flowListModel.getRealIndex(n);
        ListItemModel listItemModel = flowListModel.getItem(n3);
        if (listItemModel != null) {
            int n4 = flowListModel.getChildIndex(n);
            int n5 = flowListModel.getItemIndex(n4);
            if (listItemModel.get_dynamicIndex() != n5) {
                listItemModel.setDataInvalid(true);
            }
            flowListModel.transferData(listItemModel, n4, n5);
            flowListModel.transferStates(listItemModel, flowListModel.getEnabledIndexByAbsIndex(n3), n5);
            listItemModel.setReflectionRenderMode(n2);
            flowListModel.disableAnimations();
            listItemModel.set_x(flowListModel.getItemX(n) - (listItemModel.get_width() >> 1));
            listItemModel.set_y(flowListModel.getItemY(n) - (listItemModel.get_height() >> 1));
            listItemModel.set_z(flowListModel.getItemZ(n) >> 6);
            listItemModel.set_rotationY(flowListModel.getItemRotation(n));
            flowListModel.enableAnimations();
            listItemModel.getBounds(this.childBounds);
            this.childBounds.x += rectangle2.x;
            this.childBounds.y += rectangle2.y;
            super.paintChild(graphics3D, viewModel, listItemModel, rectangle, this.childBounds, rectangle2, f2, bl);
        }
    }

    @Override
    protected void paintDragIndicator(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
    }

    @Override
    protected void paintDropIndicator(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2) {
    }
}

