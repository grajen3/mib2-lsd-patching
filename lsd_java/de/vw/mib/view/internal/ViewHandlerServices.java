/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.datapool.DynamicListItemControlManager;
import de.vw.mib.datapool.GlobalExpressionEvaluator;
import de.vw.mib.datapool.I18nDatapool;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.format.FixFormat;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.skin.SkinAnimationPool;
import de.vw.mib.skin.SkinImagePool;
import de.vw.mib.view.internal.ListControlCache;
import de.vw.mib.view.internal.WidgetAnimator;
import de.vw.mib.view.internal.treebuilder.WidgetTreeBuilder;

public interface ViewHandlerServices {
    default public FixFormat getFixFormat() {
    }

    default public GlobalExpressionEvaluator getGlobalExpressionEvaluator() {
    }

    default public I18nDatapool getI18nDatapool() {
    }

    default public ListControlCache getListControlCache() {
    }

    default public DynamicListItemControlManager getDynamicListItemControlManager() {
    }

    default public LoggerFactory getLoggerFactory() {
    }

    default public ModelDatapool getModelDatapool() {
    }

    default public SkinAnimationPool getSkinAnimationPool() {
    }

    default public SkinImagePool getSkinImagePool() {
    }

    default public WidgetAnimator getWidgetAnimator() {
    }

    default public WidgetTreeBuilder getWidgetTreeBuilder() {
    }
}

