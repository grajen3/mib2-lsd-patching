/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.datapool.DynamicListItemControlManager;
import de.vw.mib.datapool.GlobalExpressionEvaluator;
import de.vw.mib.datapool.I18nDatapool;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.format.FixFormat;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.skin.SkinAnimationPool;
import de.vw.mib.skin.SkinImagePool;
import de.vw.mib.view.internal.ListControlCache;
import de.vw.mib.view.internal.ViewHandlerServices;
import de.vw.mib.view.internal.WidgetAnimator;
import de.vw.mib.view.internal.treebuilder.WidgetTreeBuilder;

public class ViewHandlerServicesImpl
implements ViewHandlerServices {
    private final FixFormat fixFormat;
    private final GlobalExpressionEvaluator globalExpressionEvaluator;
    private final I18nDatapool i18nDatapool;
    private final ListControlCache listControlCache;
    private final DynamicListItemControlManager dynamicListItemControlManager;
    private final LoggerFactory loggerFactory;
    private final ModelDatapool modelDatapool;
    private final SkinAnimationPool skinAnimationPool;
    private final SkinImagePool skinImagePool;
    private final WidgetAnimator widgetAnimator;
    private final WidgetTreeBuilder widgetTreeBuilder;
    static /* synthetic */ Class class$de$vw$mib$format$FixFormat;
    static /* synthetic */ Class class$de$vw$mib$datapool$GlobalExpressionEvaluator;
    static /* synthetic */ Class class$de$vw$mib$datapool$I18nDatapool;
    static /* synthetic */ Class class$de$vw$mib$view$internal$ListControlCache;
    static /* synthetic */ Class class$de$vw$mib$datapool$DynamicListItemControlManager;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$datapool$ModelDatapool;
    static /* synthetic */ Class class$de$vw$mib$skin$SkinAnimationPool;
    static /* synthetic */ Class class$de$vw$mib$skin$SkinImagePool;
    static /* synthetic */ Class class$de$vw$mib$view$internal$WidgetAnimator;
    static /* synthetic */ Class class$de$vw$mib$view$internal$treebuilder$WidgetTreeBuilder;

    public ViewHandlerServicesImpl(FixFormat fixFormat, GlobalExpressionEvaluator globalExpressionEvaluator, I18nDatapool i18nDatapool, ListControlCache listControlCache, DynamicListItemControlManager dynamicListItemControlManager, LoggerFactory loggerFactory, ModelDatapool modelDatapool, SkinAnimationPool skinAnimationPool, SkinImagePool skinImagePool, WidgetAnimator widgetAnimator, WidgetTreeBuilder widgetTreeBuilder) {
        this.fixFormat = fixFormat;
        ViewHandlerServicesImpl.checkNotNull(this.fixFormat, class$de$vw$mib$format$FixFormat == null ? (class$de$vw$mib$format$FixFormat = ViewHandlerServicesImpl.class$("de.vw.mib.format.FixFormat")) : class$de$vw$mib$format$FixFormat);
        this.globalExpressionEvaluator = globalExpressionEvaluator;
        ViewHandlerServicesImpl.checkNotNull(this.globalExpressionEvaluator, class$de$vw$mib$datapool$GlobalExpressionEvaluator == null ? (class$de$vw$mib$datapool$GlobalExpressionEvaluator = ViewHandlerServicesImpl.class$("de.vw.mib.datapool.GlobalExpressionEvaluator")) : class$de$vw$mib$datapool$GlobalExpressionEvaluator);
        this.i18nDatapool = i18nDatapool;
        ViewHandlerServicesImpl.checkNotNull(this.i18nDatapool, class$de$vw$mib$datapool$I18nDatapool == null ? (class$de$vw$mib$datapool$I18nDatapool = ViewHandlerServicesImpl.class$("de.vw.mib.datapool.I18nDatapool")) : class$de$vw$mib$datapool$I18nDatapool);
        this.listControlCache = listControlCache;
        ViewHandlerServicesImpl.checkNotNull(this.listControlCache, class$de$vw$mib$view$internal$ListControlCache == null ? (class$de$vw$mib$view$internal$ListControlCache = ViewHandlerServicesImpl.class$("de.vw.mib.view.internal.ListControlCache")) : class$de$vw$mib$view$internal$ListControlCache);
        this.dynamicListItemControlManager = dynamicListItemControlManager;
        ViewHandlerServicesImpl.checkNotNull(this.dynamicListItemControlManager, class$de$vw$mib$datapool$DynamicListItemControlManager == null ? (class$de$vw$mib$datapool$DynamicListItemControlManager = ViewHandlerServicesImpl.class$("de.vw.mib.datapool.DynamicListItemControlManager")) : class$de$vw$mib$datapool$DynamicListItemControlManager);
        this.loggerFactory = loggerFactory;
        ViewHandlerServicesImpl.checkNotNull(this.loggerFactory, class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = ViewHandlerServicesImpl.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
        this.modelDatapool = modelDatapool;
        ViewHandlerServicesImpl.checkNotNull(this.modelDatapool, class$de$vw$mib$datapool$ModelDatapool == null ? (class$de$vw$mib$datapool$ModelDatapool = ViewHandlerServicesImpl.class$("de.vw.mib.datapool.ModelDatapool")) : class$de$vw$mib$datapool$ModelDatapool);
        this.skinAnimationPool = skinAnimationPool;
        ViewHandlerServicesImpl.checkNotNull(this.skinAnimationPool, class$de$vw$mib$skin$SkinAnimationPool == null ? (class$de$vw$mib$skin$SkinAnimationPool = ViewHandlerServicesImpl.class$("de.vw.mib.skin.SkinAnimationPool")) : class$de$vw$mib$skin$SkinAnimationPool);
        this.skinImagePool = skinImagePool;
        ViewHandlerServicesImpl.checkNotNull(this.skinImagePool, class$de$vw$mib$skin$SkinImagePool == null ? (class$de$vw$mib$skin$SkinImagePool = ViewHandlerServicesImpl.class$("de.vw.mib.skin.SkinImagePool")) : class$de$vw$mib$skin$SkinImagePool);
        this.widgetAnimator = widgetAnimator;
        ViewHandlerServicesImpl.checkNotNull(this.widgetAnimator, class$de$vw$mib$view$internal$WidgetAnimator == null ? (class$de$vw$mib$view$internal$WidgetAnimator = ViewHandlerServicesImpl.class$("de.vw.mib.view.internal.WidgetAnimator")) : class$de$vw$mib$view$internal$WidgetAnimator);
        this.widgetTreeBuilder = widgetTreeBuilder;
        ViewHandlerServicesImpl.checkNotNull(this.widgetTreeBuilder, class$de$vw$mib$view$internal$treebuilder$WidgetTreeBuilder == null ? (class$de$vw$mib$view$internal$treebuilder$WidgetTreeBuilder = ViewHandlerServicesImpl.class$("de.vw.mib.view.internal.treebuilder.WidgetTreeBuilder")) : class$de$vw$mib$view$internal$treebuilder$WidgetTreeBuilder);
    }

    private static void checkNotNull(Object object, Class clazz) {
        Preconditions.checkNotNull(object, "%s service", clazz.getName());
    }

    @Override
    public FixFormat getFixFormat() {
        return this.fixFormat;
    }

    @Override
    public GlobalExpressionEvaluator getGlobalExpressionEvaluator() {
        return this.globalExpressionEvaluator;
    }

    @Override
    public I18nDatapool getI18nDatapool() {
        return this.i18nDatapool;
    }

    @Override
    public ListControlCache getListControlCache() {
        return this.listControlCache;
    }

    @Override
    public DynamicListItemControlManager getDynamicListItemControlManager() {
        return this.dynamicListItemControlManager;
    }

    @Override
    public LoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }

    @Override
    public ModelDatapool getModelDatapool() {
        return this.modelDatapool;
    }

    @Override
    public SkinAnimationPool getSkinAnimationPool() {
        return this.skinAnimationPool;
    }

    @Override
    public SkinImagePool getSkinImagePool() {
        return this.skinImagePool;
    }

    @Override
    public WidgetAnimator getWidgetAnimator() {
        return this.widgetAnimator;
    }

    @Override
    public WidgetTreeBuilder getWidgetTreeBuilder() {
        return this.widgetTreeBuilder;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

