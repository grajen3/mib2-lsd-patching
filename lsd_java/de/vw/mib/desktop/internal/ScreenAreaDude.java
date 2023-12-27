/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal;

import de.vw.mib.desktop.internal.DesktopManagerConfiguration;
import de.vw.mib.desktop.internal.DesktopManagerImpl;
import de.vw.mib.desktop.internal.ScreenAreaDude$1;
import de.vw.mib.desktop.internal.common.ServiceManager;
import de.vw.mib.desktop.internal.screenarea.ScreenAreaNode;
import de.vw.mib.desktop.internal.screenarea.ViewNode;
import de.vw.mib.desktop.internal.view2view.TransitionListener;
import de.vw.mib.desktop.internal.view2view.TransitionManager;
import de.vw.mib.desktop.internal.view2view.TransitionManagerConcurrentImpl;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Timer;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.models.ScreenAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.ArrayList;
import java.util.List;

public class ScreenAreaDude
implements TransitionListener {
    private static final boolean ENABLE_ZOOM_IN;
    private static final boolean ENABLE_ZOOM_OUT;
    private static final int ZOOM_NONE;
    private static final int ZOOM_IN;
    private static final int ZOOM_OUT;
    private static final WidgetModel[] EMPTY_ARRAY_OF_WIDGETMODEL;
    protected final Logger logger;
    private final DesktopManagerImpl desktopManager;
    private ScreenAreaModel previousScreenArea = null;
    private String previousScreenAreaName = null;
    private ScreenAreaModel screenArea = null;
    private final String screenAreaPath;
    protected SmartViewHandler currentViewHandler;
    private String currentViewName = "";
    private SmartViewHandler previousViewHandler = SmartViewHandler.EMPTY_SMART_VIEWHANDLER;
    private SmartViewHandler enterViewHandler = null;
    private SmartViewHandler leaveViewHandler = null;
    private int zoomState = 0;
    private ScreenAreaModel animationScreenArea;
    private final TransitionManager transitionManager;
    private ArrayList previousViewHandlerList = new ArrayList();
    private ArrayList viewHandlerList = new ArrayList();
    private final ArrayList popupViewHandlerList = new ArrayList();
    private final ArrayList viewHandlerListForScreenAreaSearch = new ArrayList();
    private Timer timerLeaveTimeout;
    private final Runnable leaveTimeoutRunner;
    private boolean isLeft;
    private boolean opaque;
    private boolean covered;
    private SmartViewHandler protectedViewHandler;
    private boolean animationBlockingEnabled = false;

    ScreenAreaDude(DesktopManagerImpl desktopManagerImpl, String string) {
        this.logger = ServiceManager.loggerFactory.getLogger(1024);
        this.desktopManager = desktopManagerImpl;
        this.screenAreaPath = string;
        this.isLeft = true;
        this.transitionManager = new TransitionManagerConcurrentImpl(string);
        this.leaveTimeoutRunner = new ScreenAreaDude$1(this);
        this.timerLeaveTimeout = ServiceManager.timerManager.createTimer("WaitStateTimer_long", ServiceManager.configurationManager.getViewManagerWaitStateTimeout2(), false, this.leaveTimeoutRunner, ServiceManager.eventDispatcher);
    }

    private ScreenAreaModel getScreenArea() {
        if (this.screenArea == null) {
            int n;
            List list;
            Object object;
            String string = "";
            int n2 = this.screenAreaPath.lastIndexOf(46);
            if (n2 >= 0) {
                string = this.screenAreaPath.substring(0, n2);
            }
            String string2 = this.screenAreaPath.substring(n2 + 1);
            if ("".equals(string)) {
                this.screenArea = this.findScreenArea(ServiceManager.desktopManager.getScreenViewHandler(), string2);
            } else {
                object = this.desktopManager.getScreenAreaDude(string);
                if (object != null) {
                    list = ((ScreenAreaDude)object).getViewHandlerListForScreenAreaSearch();
                    for (n = 0; n < list.size(); ++n) {
                        this.screenArea = this.findScreenArea((SmartViewHandler)list.get(n), string2);
                        if (this.screenArea != null) break;
                    }
                }
            }
            if (this.screenArea != null && this.previousScreenArea != null) {
                if (this.previousScreenArea.toString().equals(this.previousScreenAreaName)) {
                    object = this.getViewHandlers();
                    list = new ArrayList();
                    for (n = 0; n < object.size(); ++n) {
                        SmartViewHandler smartViewHandler = (SmartViewHandler)object.get(n);
                        smartViewHandler.deinit();
                        ((ArrayList)list).add(smartViewHandler.getView());
                    }
                    this.previousScreenArea.setChildren(EMPTY_ARRAY_OF_WIDGETMODEL);
                    if (this.logger.isTraceEnabled(2)) {
                        this.logger.trace(2).append("DM #SA '").append(this.previousScreenArea.toString()).append("': => []a").log();
                    }
                    this.previousScreenArea = null;
                    this.previousScreenAreaName = null;
                    this.screenArea.setChildren((WidgetModel[])((ArrayList)list).toArray(EMPTY_ARRAY_OF_WIDGETMODEL));
                    if (this.logger.isTraceEnabled(2)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i2 = 0; i2 < ((ArrayList)list).size(); ++i2) {
                            if (i2 > 0) {
                                stringBuilder.append(", ");
                            }
                            stringBuilder.append(((ViewModel)((ArrayList)list).get(i2)).get_name());
                        }
                        this.logger.trace(2).append("DM #SA '").append(this.screenArea.toString()).append("': => [").append(stringBuilder.toString()).append("]b").log();
                    }
                    for (int i3 = 0; i3 < object.size(); ++i3) {
                        SmartViewHandler smartViewHandler = (SmartViewHandler)object.get(i3);
                        smartViewHandler.linkToScreenTree('c');
                        smartViewHandler.init();
                    }
                } else {
                    this.previousScreenArea = null;
                    this.previousScreenAreaName = null;
                }
            }
        }
        return this.screenArea;
    }

    private ScreenAreaModel findScreenArea(SmartViewHandler smartViewHandler, String string) {
        ScreenAreaModel[] screenAreaModelArray = smartViewHandler.getScreenAreas();
        for (int i2 = 0; i2 < screenAreaModelArray.length; ++i2) {
            if (!string.equals(screenAreaModelArray[i2].get_name())) continue;
            return screenAreaModelArray[i2];
        }
        return null;
    }

    public boolean isLeft() {
        return this.isLeft;
    }

    boolean consumeEvent(HMIEvent hMIEvent, ScreenAreaNode screenAreaNode) {
        int n;
        if (this.currentViewHandler == null) {
            return false;
        }
        List list = screenAreaNode.getChildren();
        for (n = list.size() - 1; n >= 0; --n) {
            List list2 = ((ViewNode)list.get(n)).getChildren();
            for (int i2 = 0; i2 < list2.size(); ++i2) {
                ScreenAreaDude screenAreaDude;
                boolean bl;
                ScreenAreaNode screenAreaNode2 = (ScreenAreaNode)list2.get(i2);
                if (!screenAreaNode2.isActive() || !(bl = (screenAreaDude = this.desktopManager.getScreenAreaDude(screenAreaNode2.getScreenAreaPath())).consumeEvent(hMIEvent, screenAreaNode2))) continue;
                if (this.logger.isTraceEnabled(2)) {
                    this.logger.trace(2).append("hmi event ").append(hMIEvent).append(" consumed by ").append(this.currentViewHandler).append(" in ").append(this.screenAreaPath).log();
                }
                return true;
            }
        }
        n = this.currentViewHandler.consumeEvent(hMIEvent) ? 1 : 0;
        if (n != 0 && this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("hmi event ").append(hMIEvent).append(" consumed by ").append(this.currentViewHandler).append(" in ").append(this.screenAreaPath).log();
        }
        return n != 0;
    }

    void enterView(SmartViewHandler smartViewHandler) {
        int n;
        this.stopLeaveTimeout();
        ScreenAreaNode screenAreaNode = ServiceManager.screenAreaTree.getScreenAreaNode(this.screenAreaPath);
        ViewNode viewNode = screenAreaNode.getParent();
        ScreenAreaNode screenAreaNode2 = viewNode.getParent();
        List list = screenAreaNode2.getChildren();
        for (n = 0; n < list.size(); ++n) {
            ViewNode viewNode2 = (ViewNode)list.get(n);
            if (viewNode2.equals(viewNode)) continue;
            List list2 = viewNode2.getChildren();
            for (int i2 = 0; i2 < list2.size(); ++i2) {
                ScreenAreaNode screenAreaNode3 = (ScreenAreaNode)list2.get(i2);
                if (!screenAreaNode3.getScreenAreaPath().equals(this.screenAreaPath)) continue;
                this.screenArea = screenAreaNode3.getScreenArea();
                this.previousViewHandler = SmartViewHandler.EMPTY_SMART_VIEWHANDLER;
                List list3 = screenAreaNode3.getChildren();
                for (int i3 = 0; i3 < list3.size(); ++i3) {
                    SmartViewHandler smartViewHandler2 = ((ViewNode)list3.get(i3)).getViewHandler();
                    smartViewHandler2.unlinkFromScreenTree('b');
                    this.viewHandlerList.remove(smartViewHandler2);
                }
                this.screenArea.setChildren(EMPTY_ARRAY_OF_WIDGETMODEL);
                if (!this.logger.isTraceEnabled(2)) continue;
                this.logger.trace(2).append("DM SA Abandoning duplicate screen area ").append(this.screenAreaPath).append(" in ").append(viewNode2.getViewHandler().getNameForTraces()).log();
            }
        }
        this.screenArea = null;
        ServiceManager.screenAreaTree.setActive(this.screenAreaPath, smartViewHandler != null);
        if (smartViewHandler == null) {
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("DM remove view from ").append(this.screenAreaPath).log();
            }
            this.leave();
            return;
        }
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("enter view: ").append(smartViewHandler).append(" in ").append(this.screenAreaPath).log();
        }
        if (!smartViewHandler.getShortViewHandlerName().equals(this.previousViewHandler.getShortViewHandlerName())) {
            smartViewHandler.setup();
            ServiceManager.screenAreaTree.registerViewHandler(this.screenAreaPath, smartViewHandler);
            this.previousViewHandler = smartViewHandler;
            this.protectedViewHandler = smartViewHandler;
            this.transitionManager.abort();
            this.protectedViewHandler = null;
            this.enterViewHandler = smartViewHandler;
            if (this.currentViewHandler != null) {
                this.currentViewHandler.deactivate();
            }
            this.leaveViewHandler = this.currentViewHandler;
            if (this.enterViewHandler != null) {
                this.enterViewHandler.setAnimationBlockingEnabled(this.animationBlockingEnabled);
            }
            if (this.leaveViewHandler != null) {
                this.leaveViewHandler.setAnimationBlockingEnabled(this.animationBlockingEnabled);
            }
            if (!DesktopManagerConfiguration.DEACTIVATE_HERO_ANIMATION && this.leaveViewHandler != null && this.enterViewHandler != null) {
                if ("H_69BD".equals(this.leaveViewHandler.getShortViewHandlerName())) {
                    ScreenAreaModel[] screenAreaModelArray = this.leaveViewHandler.getScreenAreas();
                    this.animationScreenArea = null;
                    for (int i4 = 0; i4 < screenAreaModelArray.length; ++i4) {
                        if (!"ScreenAreaAnimation".equals(screenAreaModelArray[i4].get_name())) continue;
                        if (this.logger.isTraceEnabled(2)) {
                            this.logger.trace(2).append("DM #SA '").append(this.screenAreaPath).append("' hero animation HOMESCREEN -> ").append(this.enterViewHandler.getNameForTraces()).log();
                        }
                        this.animationScreenArea = screenAreaModelArray[i4];
                        this.zoomState = 1;
                        this.animationScreenArea.setChildren(new WidgetModel[]{this.enterViewHandler.getView()});
                        if (this.logger.isTraceEnabled(2)) {
                            this.logger.trace(2).append("DM #SA '").append(this.animationScreenArea.toString()).append("': => [").append(this.enterViewHandler.getView().get_name()).append("]g").log();
                        }
                        this.enterViewHandler.linkToScreenTree('d');
                        break;
                    }
                } else if ("H_69BD".equals(this.enterViewHandler.getShortViewHandlerName())) {
                    ScreenAreaModel[] screenAreaModelArray = this.enterViewHandler.getScreenAreas();
                    this.animationScreenArea = null;
                    for (int i5 = 0; i5 < screenAreaModelArray.length; ++i5) {
                        if (!"ScreenAreaAnimation".equals(screenAreaModelArray[i5].get_name())) continue;
                        if (this.logger.isTraceEnabled(2)) {
                            this.logger.trace(2).append("DM #SA '").append(this.screenAreaPath).append("' hero animation ").append(this.leaveViewHandler.getNameForTraces()).append(" -> HOMESCREEN").log();
                        }
                        this.animationScreenArea = screenAreaModelArray[i5];
                        this.zoomState = 2;
                        break;
                    }
                }
            }
            this.enterViewHandler.init();
            if (this.zoomState == 2) {
                this.previousViewHandlerList.remove(this.leaveViewHandler);
                this.previousViewHandlerList.add(this.enterViewHandler);
                this.leaveViewHandler.unlinkFromScreenTree('c');
                this.viewHandlerList.clear();
                this.previousViewHandlerList.clear();
                this.viewHandlerList.add(this.enterViewHandler);
                this.previousViewHandlerList.add(this.enterViewHandler);
                this.getScreenArea().setChildren(new WidgetModel[]{this.enterViewHandler.getView()});
                if (this.logger.isTraceEnabled(2)) {
                    this.logger.trace(2).append("DM #SA '").append(this.getScreenArea().toString()).append("': => [").append(this.enterViewHandler.getView().get_name()).append("]h").log();
                }
                this.enterViewHandler.linkToScreenTree('e');
                this.leaveViewHandler.init();
                this.animationScreenArea.setChildren(new WidgetModel[]{this.leaveViewHandler.getView()});
                if (this.logger.isTraceEnabled(2)) {
                    this.logger.trace(2).append("DM #SA '").append(this.animationScreenArea.toString()).append("': => [").append(this.leaveViewHandler.getView().get_name()).append("]k").log();
                }
                this.leaveViewHandler.linkToScreenTree('f');
            }
            this.desktopManager.leaveHostedScreenAreas(this.screenAreaPath, this.leaveViewHandler);
            if (this.animationBlockingEnabled) {
                this.finishViewChange();
                this.isLeft = false;
                return;
            }
            n = this.transitionManager.startTransition(this.leaveViewHandler, this.enterViewHandler, this);
            if (n <= 0) {
                this.finishViewChange();
            } else {
                if (n != 128) {
                    ServiceManager.popupStackManager.hideAll();
                }
                this.updateViewstack();
            }
        } else if (!this.transitionManager.isAnimationRunning() && this.currentViewHandler != null) {
            if (this.currentViewHandler.isActive()) {
                this.currentViewHandler.reactivate();
            } else {
                this.currentViewHandler.activate(this.isVisible());
            }
        }
        this.isLeft = false;
    }

    void leave() {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("DM #SA '").append(this.screenAreaPath).append("'.leave()").log();
        }
        this.isLeft = true;
        this.stopLeaveTimeout();
        if (this.previousViewHandler != SmartViewHandler.EMPTY_SMART_VIEWHANDLER) {
            this.previousViewHandler = SmartViewHandler.EMPTY_SMART_VIEWHANDLER;
            this.transitionManager.abort();
            this.enterViewHandler = null;
            if (this.currentViewHandler != null) {
                this.currentViewHandler.deactivate();
            }
            this.leaveViewHandler = this.currentViewHandler;
            if (this.animationBlockingEnabled) {
                this.finishViewChange();
                return;
            }
            int n = this.transitionManager.startTransition(this.leaveViewHandler, null, this);
            if (n <= 0) {
                this.finishViewChange();
            } else {
                this.updateViewstack();
            }
        }
    }

    void deactivateView(String string, int n, boolean bl) {
        ServiceManager.screenAreaTree.setActive(this.screenAreaPath, false);
        this.isLeft = true;
        if (this.currentViewHandler == null) {
            return;
        }
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("leave view: ").append(string).append(" in ").append(this.screenAreaPath).log();
        }
        if (!bl) {
            this.startLeaveTimeout(n);
        }
        if (!this.transitionManager.isAnimationRunning() && this.currentViewHandler != null && this.currentViewHandler != SmartViewHandler.EMPTY_SMART_VIEWHANDLER && this.currentViewHandler.isActive()) {
            try {
                this.currentViewHandler.deactivate();
            }
            catch (Exception exception) {
                this.logger.error(2, new StringBuffer().append("Error leaving view ").append(this.currentViewHandler.getNameForTraces()).toString(), exception);
            }
        }
    }

    public void releaseResourcesForSkinChange() {
        this.transitionManager.abort();
        if (this.currentViewHandler != null) {
            this.currentViewHandler.release();
        }
        if (this.screenArea != null) {
            this.screenArea.setChildren(EMPTY_ARRAY_OF_WIDGETMODEL);
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("DM #SA '").append(this.screenArea.toString()).append("': => []c").log();
            }
            this.screenArea = null;
        }
    }

    public void prepareRestoreResourcesForSkinChange() {
        this.viewHandlerList.clear();
    }

    void restoreResourcesForSkinChange() {
        if (this.currentViewHandler != null) {
            this.currentViewHandler.reload();
            this.updateViewstack();
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("View '").append(this.currentViewHandler.getNameForTraces()).append("' created after skin change.").log();
            }
            this.currentViewHandler.restore();
        }
    }

    private void startLeaveTimeout(int n) {
        this.timerLeaveTimeout.stop();
        this.timerLeaveTimeout.start(this.leaveTimeoutRunner);
    }

    private void stopLeaveTimeout() {
        this.timerLeaveTimeout.stop();
    }

    void updatePopupStack(ArrayList arrayList) {
        this.popupViewHandlerList.clear();
        this.popupViewHandlerList.addAll(arrayList);
        this.updateViewstack();
    }

    @Override
    public void activateEarly() {
        if (this.enterViewHandler == null || this.zoomState == 1) {
            return;
        }
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("activate early - ").append(this.enterViewHandler).log();
        }
        this.switchViews();
        this.enterViewHandler.activate(this.isVisible());
    }

    @Override
    public void finishViewChange() {
        this.switchViews();
        if (this.zoomState == 1) {
            this.enterViewHandler.setAnimationBlockingEnabled(this.animationBlockingEnabled);
            this.enterViewHandler.deinit();
            this.enterViewHandler.unlinkFromScreenTree('d');
            this.animationScreenArea.setChildren(EMPTY_ARRAY_OF_WIDGETMODEL);
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("DM #SA '").append(this.animationScreenArea.toString()).append("': => []l").log();
            }
            this.zoomState = 0;
        } else if (this.zoomState == 2) {
            if (this.leaveViewHandler != null) {
                this.leaveViewHandler.setAnimationBlockingEnabled(this.animationBlockingEnabled);
                this.leaveViewHandler.deinit();
                this.leaveViewHandler.unlinkFromScreenTree('e');
            }
            this.animationScreenArea.setChildren(EMPTY_ARRAY_OF_WIDGETMODEL);
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("DM #SA '").append(this.animationScreenArea.toString()).append("': => []m").log();
            }
            this.zoomState = 0;
        }
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("finishViewChange - ").append(this.screenAreaPath).append(" -> ").append(this.currentViewHandler == null ? "<none>" : this.currentViewHandler.toString()).log();
        }
        if (this.leaveViewHandler != null) {
            ServiceManager.desktopManager.removeSubScreenAreas(this.screenAreaPath, this.leaveViewHandler);
            if (!this.leaveViewHandler.equals(this.protectedViewHandler)) {
                this.leaveViewHandler.setAnimationBlockingEnabled(this.animationBlockingEnabled);
                this.leaveViewHandler.deinit();
                this.leaveViewHandler.teardown();
            }
        }
        if (this.currentViewHandler != null) {
            this.currentViewHandler.activate(this.isVisible());
            this.getScreenArea().setChildren(new WidgetModel[]{this.currentViewHandler.getView()});
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("DM #SA '").append(this.screenArea.toString()).append("': => [").append(this.currentViewHandler.getNameForTraces()).append("]d").log();
            }
        } else if (this.screenArea != null) {
            this.getScreenArea().setChildren(EMPTY_ARRAY_OF_WIDGETMODEL);
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("DM #SA '").append(this.screenArea.toString()).append("': => []e ").log();
            }
        }
        this.updateViewstack();
        if (ServiceManager.proximityInstaller != null && !this.screenAreaPath.equals("ScreenAreaDisplayOffClock")) {
            ServiceManager.proximityInstaller.processUserInteraction(1);
        }
        ServiceManager.repaintManager.repaint();
        if (!(this.leaveViewHandler == null || this.enterViewHandler != null && this.leaveViewHandler.getShortViewHandlerName().equals(this.enterViewHandler.getShortViewHandlerName()) || this.leaveViewHandler.equals(this.protectedViewHandler))) {
            ServiceManager.screenAreaTree.unregisterViewHandler(this.screenAreaPath, this.leaveViewHandler);
            this.desktopManager.free(this.leaveViewHandler);
        }
        ServiceManager.popupStackManager.showAll();
    }

    @Override
    public void setPaintingEnabled(boolean bl) {
    }

    public void switchViews() {
        this.currentViewHandler = this.enterViewHandler;
        this.currentViewName = this.currentViewHandler == null ? "" : this.currentViewHandler.getShortViewHandlerName();
    }

    public SmartViewHandler getCurrentViewHandler() {
        return this.currentViewHandler;
    }

    public String getCurrentViewName() {
        return this.currentViewName;
    }

    @Override
    public void updateViewstack() {
        if (this.enterViewHandler != null && !this.enterViewHandler.isInitialized()) {
            this.enterViewHandler.init();
        }
        ArrayList arrayList = new ArrayList(this.popupViewHandlerList.size() + 2);
        ArrayList arrayList2 = this.previousViewHandlerList;
        this.previousViewHandlerList = this.viewHandlerList;
        this.viewHandlerList = arrayList2;
        this.viewHandlerList.clear();
        if (this.transitionManager.isAnimationRunning()) {
            if (this.zoomState == 1) {
                if (this.leaveViewHandler != null) {
                    arrayList.add(this.leaveViewHandler.getView());
                    this.viewHandlerList.add(this.leaveViewHandler);
                }
            } else if (this.zoomState == 2) {
                if (this.enterViewHandler != null) {
                    arrayList.add(this.enterViewHandler.getView());
                    this.viewHandlerList.add(this.enterViewHandler);
                }
            } else if (this.transitionManager.isLeaveOverEnter()) {
                if (this.enterViewHandler != null) {
                    if (this.enterViewHandler.getView() != null) {
                        arrayList.add(this.enterViewHandler.getView());
                        this.viewHandlerList.add(this.enterViewHandler);
                    } else if (this.logger.isTraceEnabled(2)) {
                        this.logger.trace(2).append("DM #SA '").append(this.screenAreaPath).append("' #VSN '").append(this.enterViewHandler.getShortViewHandlerName()).append("' null view in enter viewhandler").log();
                    }
                }
                if (this.leaveViewHandler != null && this.transitionManager.isLeaveViewVisible()) {
                    if (this.leaveViewHandler.getView() != null) {
                        arrayList.add(this.leaveViewHandler.getView());
                        this.viewHandlerList.add(this.leaveViewHandler);
                    } else if (this.logger.isTraceEnabled(2)) {
                        this.logger.trace(2).append("DM #SA '").append(this.screenAreaPath).append("' #VSN '").append(this.enterViewHandler.getShortViewHandlerName()).append("' null view in leave viewhandler").log();
                    }
                }
            } else {
                if (this.leaveViewHandler != null && this.transitionManager.isLeaveViewVisible()) {
                    if (this.leaveViewHandler.getView() != null) {
                        arrayList.add(this.leaveViewHandler.getView());
                        this.viewHandlerList.add(this.leaveViewHandler);
                    } else if (this.logger.isTraceEnabled(2)) {
                        this.logger.trace(2).append("DM #SA '").append(this.screenAreaPath).append("' #VSN '").append(this.enterViewHandler.getShortViewHandlerName()).append("' null view in leave viewhandler").log();
                    }
                }
                if (this.enterViewHandler != null) {
                    if (this.enterViewHandler.getView() != null) {
                        arrayList.add(this.enterViewHandler.getView());
                        this.viewHandlerList.add(this.enterViewHandler);
                    } else if (this.logger.isTraceEnabled(2)) {
                        this.logger.trace(2).append("DM #SA '").append(this.screenAreaPath).append("' #VSN '").append(this.enterViewHandler.getShortViewHandlerName()).append("' null view in enter viewhandler").log();
                    }
                }
            }
        } else if (this.currentViewHandler != null) {
            if (this.currentViewHandler.getView() != null) {
                arrayList.add(this.currentViewHandler.getView());
                this.viewHandlerList.add(this.currentViewHandler);
            } else if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("DM #SA '").append(this.screenAreaPath).append("' #VSN '").append(this.currentViewHandler.getShortViewHandlerName()).append("' null view in current viewhandler").log();
            }
        }
        for (int i2 = this.popupViewHandlerList.size() - 1; i2 >= 0; --i2) {
            ViewModel viewModel = ((SmartViewHandler)this.popupViewHandlerList.get(i2)).getView();
            if (viewModel != null) {
                arrayList.add(viewModel);
                this.viewHandlerList.add(this.popupViewHandlerList.get(i2));
                continue;
            }
            if (!this.logger.isTraceEnabled(2)) continue;
            String string = "---null---";
            if (i2 < this.popupViewHandlerList.size() && this.popupViewHandlerList.get(i2) != null) {
                string = ((SmartViewHandler)this.popupViewHandlerList.get(i2)).getShortViewHandlerName();
            }
            this.logger.trace(2).append("DM #SA '").append(this.screenAreaPath).append("' #VSN '").append(string).append("' null view in popup stack viewhandler [").append(i2).append("]").log();
        }
        this.updateViewstack(arrayList);
    }

    private void updateViewstack(ArrayList arrayList) {
        int n;
        Object object;
        int n2;
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("DM #SA '").append(this.screenAreaPath).append("'.updateViewstack(...)").log();
        }
        this.opaque = false;
        for (n2 = 0; n2 < arrayList.size(); ++n2) {
            object = (ViewModel)arrayList.get(n2);
            boolean bl = this.opaque = object.is_opaque() && object.is_visible();
            if (this.opaque) break;
        }
        for (n2 = 0; n2 < this.previousViewHandlerList.size(); ++n2) {
            if (this.viewHandlerList.contains(this.previousViewHandlerList.get(n2))) continue;
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("DM #SA '").append(this.screenAreaPath).append("' LEAVE ").append(this.previousViewHandlerList.get(n2)).log();
            }
            object = (SmartViewHandler)this.previousViewHandlerList.get(n2);
            ServiceManager.desktopManager.removeHostedScreenAreasFromViewHandler((SmartViewHandler)object);
            ((SmartViewHandler)object).unlinkFromScreenTree('f');
        }
        if (this.isVisible() || arrayList.size() < 1) {
            this.getScreenArea().setChildren((WidgetModel[])arrayList.toArray(EMPTY_ARRAY_OF_WIDGETMODEL));
        }
        if (this.logger.isTraceEnabled(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                if (i2 > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((ViewModel)arrayList.get(i2)).get_name());
            }
            this.logger.trace(2).append("DM #SA '").append(this.screenArea.toString()).append("': => [").append(stringBuilder.toString()).append("]f").log();
        }
        for (n = 0; n < this.viewHandlerList.size(); ++n) {
            if (this.previousViewHandlerList.contains(this.viewHandlerList.get(n))) continue;
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("ENTER ").append(this.screenAreaPath).append(".").append(this.viewHandlerList.get(n)).log();
            }
            object = (SmartViewHandler)this.viewHandlerList.get(n);
            ((SmartViewHandler)object).setAnimationBlockingEnabled(this.animationBlockingEnabled);
            ((SmartViewHandler)object).linkToScreenTree('g');
        }
        if (this.previousViewHandlerList.size() != this.viewHandlerList.size()) {
            ServiceManager.viewTreeIsDirty = true;
        } else {
            for (n = 0; n < this.viewHandlerList.size(); ++n) {
                if (this.viewHandlerList.get(n).equals(this.previousViewHandlerList.get(n))) continue;
                ServiceManager.viewTreeIsDirty = true;
                break;
            }
        }
        ServiceManager.repaintManager.repaint();
    }

    public SmartViewHandler getDominantViewHandler() {
        SmartViewHandler smartViewHandler = null;
        if (this.enterViewHandler != null) {
            smartViewHandler = this.enterViewHandler;
        } else if (this.currentViewHandler != null) {
            smartViewHandler = this.currentViewHandler;
        }
        if (smartViewHandler == null && this.popupViewHandlerList.size() > 0) {
            smartViewHandler = (SmartViewHandler)this.popupViewHandlerList.get(0);
        }
        return smartViewHandler;
    }

    public List getViewHandlers() {
        return this.viewHandlerList;
    }

    public List getViewHandlerListForScreenAreaSearch() {
        this.viewHandlerListForScreenAreaSearch.clear();
        SmartViewHandler smartViewHandler = null;
        if (this.enterViewHandler != null) {
            smartViewHandler = this.enterViewHandler;
            this.viewHandlerListForScreenAreaSearch.add(smartViewHandler);
        }
        if (this.currentViewHandler != null && !this.currentViewHandler.equals(smartViewHandler)) {
            smartViewHandler = this.currentViewHandler;
            this.viewHandlerListForScreenAreaSearch.add(smartViewHandler);
        }
        if (this.leaveViewHandler != null && !this.leaveViewHandler.equals(smartViewHandler)) {
            smartViewHandler = this.leaveViewHandler;
            this.viewHandlerListForScreenAreaSearch.add(smartViewHandler);
        }
        if (this.viewHandlerListForScreenAreaSearch.size() < 1 && this.popupViewHandlerList.size() > 0) {
            this.viewHandlerListForScreenAreaSearch.addAll(this.popupViewHandlerList);
        }
        return this.viewHandlerListForScreenAreaSearch;
    }

    public boolean isOpaque() {
        return this.opaque;
    }

    public String toString() {
        return new StringBuffer().append("ScreenAreaDude [screenAreaPath=").append(this.screenAreaPath).append(", currentViewName=").append(this.currentViewName).append("]").toString();
    }

    public void clear() {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("DM #SA '").append(this.screenAreaPath).append("'.clear()").log();
        }
        this.previousScreenArea = this.screenArea;
        this.previousScreenAreaName = this.screenArea == null ? null : this.screenArea.toString();
        this.screenArea = null;
        this.previousViewHandler = SmartViewHandler.EMPTY_SMART_VIEWHANDLER;
        this.timerLeaveTimeout.stop();
        ServiceManager.screenAreaTree.setActive(this.screenAreaPath, false);
        this.transitionManager.abort();
        this.currentViewHandler = null;
    }

    public boolean isVisible() {
        ScreenAreaModel screenAreaModel = this.getScreenArea();
        return screenAreaModel != null ? screenAreaModel.is_visible() : false;
    }

    public void setVisible(boolean bl) {
        ScreenAreaModel screenAreaModel;
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("DM #SA '").append(this.screenAreaPath).append("' setVisible(").append(bl).append(")").log();
        }
        if ((screenAreaModel = this.getScreenArea()) != null) {
            SmartViewHandler smartViewHandler = this.getDominantViewHandler();
            if (!bl && smartViewHandler != null) {
                smartViewHandler.deactivate();
            }
            screenAreaModel.set_visible(bl);
            if (bl && smartViewHandler != null) {
                smartViewHandler.activate(true);
                if (ServiceManager.proximityInstaller != null && !this.screenAreaPath.equals("ScreenAreaDisplayOffClock")) {
                    ServiceManager.proximityInstaller.pauseProximity(2, false);
                    ServiceManager.proximityInstaller.resumeProximity(2);
                    ServiceManager.proximityInstaller.processUserInteraction(1);
                }
            }
            ServiceManager.viewTreeIsDirty = true;
        }
    }

    public boolean isCovered() {
        return this.covered;
    }

    public void setCovered(boolean bl) {
        SmartViewHandler smartViewHandler;
        ScreenAreaModel screenAreaModel = this.getScreenArea();
        if (screenAreaModel != null && (smartViewHandler = this.getDominantViewHandler()) != null) {
            if (bl) {
                smartViewHandler.onCover();
            } else {
                smartViewHandler.onUncover();
            }
            this.covered = bl;
        }
    }

    private void stopSubTransitions(List list) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ScreenAreaNode screenAreaNode = (ScreenAreaNode)list.get(i2);
            List list2 = screenAreaNode.getChildren();
            for (int i3 = 0; i3 < list2.size(); ++i3) {
                ViewNode viewNode = (ViewNode)list2.get(i3);
                List list3 = viewNode.getChildren();
                this.stopSubTransitions(list3);
            }
            ScreenAreaDude screenAreaDude = ServiceManager.desktopManager.getScreenAreaDude(screenAreaNode.getScreenAreaPath());
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("#SA '").append(screenAreaDude.getScreenAreaPathString()).append("' abortLeaveAnimation(null)").log();
            }
            screenAreaDude.abortLeaveAnimation();
        }
    }

    public void abortLeaveAnimation() {
        if (this.transitionManager != null) {
            SmartViewHandler smartViewHandler = this.leaveViewHandler;
            this.leaveViewHandler = null;
            if (this.transitionManager.abortLeaveAnimation(null)) {
                ServiceManager.screenAreaTree.unregisterViewHandler(this.screenAreaPath, smartViewHandler);
            }
        }
    }

    public boolean abortLeaveAnimation(String string) {
        if (this.transitionManager != null) {
            SmartViewHandler smartViewHandler = this.leaveViewHandler;
            this.leaveViewHandler = null;
            if (this.transitionManager.isLeaveAnimationRunning(string)) {
                ScreenAreaNode screenAreaNode = ServiceManager.screenAreaTree.getScreenAreaNode(this.screenAreaPath);
                List list = screenAreaNode.getChildren();
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    ViewNode viewNode = (ViewNode)list.get(i2);
                    List list2 = viewNode.getChildren();
                    this.stopSubTransitions(list2);
                }
            }
            if (this.transitionManager.abortLeaveAnimation(string)) {
                if (this.logger.isTraceEnabled(2)) {
                    this.logger.trace(2).append("#SA '").append(this.screenAreaPath).append("' abortLeaveAnimation('").append(string).append("')").log();
                }
                ServiceManager.screenAreaTree.unregisterViewHandler(this.screenAreaPath, smartViewHandler);
                return true;
            }
            this.leaveViewHandler = smartViewHandler;
        }
        return false;
    }

    public String getScreenAreaPathString() {
        return this.screenAreaPath;
    }

    public void setAnimationBlockingEnabled(boolean bl) {
        this.animationBlockingEnabled = bl;
    }

    static {
        EMPTY_ARRAY_OF_WIDGETMODEL = new WidgetModel[0];
    }
}

