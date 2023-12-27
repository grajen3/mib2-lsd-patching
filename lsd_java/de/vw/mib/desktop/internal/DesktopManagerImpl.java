/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.desktop.DesktopDiagnosticsNotificationReceiver;
import de.vw.mib.desktop.DesktopDiagnosticsProviderService;
import de.vw.mib.desktop.DesktopInformationReceiver;
import de.vw.mib.desktop.DesktopManager;
import de.vw.mib.desktop.ViewHandlerProvider;
import de.vw.mib.desktop.internal.DesktopManagerConfiguration;
import de.vw.mib.desktop.internal.DesktopManagerImpl$1;
import de.vw.mib.desktop.internal.DesktopManagerImpl$2;
import de.vw.mib.desktop.internal.DesktopManagerImpl$3;
import de.vw.mib.desktop.internal.DesktopManagerImpl$4;
import de.vw.mib.desktop.internal.DesktopManagerImpl$5;
import de.vw.mib.desktop.internal.DesktopManagerImpl$6;
import de.vw.mib.desktop.internal.ScreenAreaDude;
import de.vw.mib.desktop.internal.common.DiagViewList;
import de.vw.mib.desktop.internal.common.ServiceManager;
import de.vw.mib.desktop.internal.screenarea.ScreenAreaNode;
import de.vw.mib.desktop.internal.screenarea.ScreenTree;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;
import de.vw.mib.driverdistractionprevention.DriverDistractionPreventionHandler;
import de.vw.mib.event.DisplayEvent;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.PopupViewEvent;
import de.vw.mib.event.ProximityEvent;
import de.vw.mib.event.StartupEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.event.ViewChangeEvent;
import de.vw.mib.event.consumer.GestureEventConsumer;
import de.vw.mib.event.consumer.ViewManagerEventConsumer;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.repaint.Paintable;
import de.vw.mib.skin.ViewLanguageSkinChanger;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.viewmanager.DesktopDiag;
import de.vw.mib.viewmanager.internal.ViewHandler;
import de.vw.mib.widgets.View;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.ScreenAreaModel;
import de.vw.mib.widgets.models.ScreenModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.speller.SpellerManager;
import edu.emory.mathcs.backport.java.util.concurrent.CountDownLatch;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class DesktopManagerImpl
implements DesktopManager,
DesktopDiag,
Paintable,
GestureEventConsumer,
ViewManagerEventConsumer,
ViewLanguageSkinChanger,
DriverDistractionPreventionHandler,
DesktopDiagnosticsProviderService,
ServiceTrackerCustomizer {
    private static final boolean VISUALIZE;
    private static final boolean VISUALIZE2;
    private static final ArrayList EMPTY_VIEWLIST;
    private static final int DDP_ANIMATION_BLOCKING_GROUP_ID;
    private final Logger logger;
    private ArrayList screenList;
    private SmartViewHandler screenViewHandler;
    private ScreenModel screen;
    private Map screenAreaDudes = new HashMap();
    private Map viewName2screenAreaDude = new HashMap();
    private ArrayList preInitMemoryScreenAreaPath = new ArrayList();
    private ArrayList preInitMemorySmartViewHandlers = new ArrayList();
    private ScreenAreaDude popupScreenAreaDude;
    private boolean firstViewShown = false;
    private boolean repaintEnabled = true;
    private SmartViewHandler darkFaderIndicatorViewHandler = SmartViewHandler.EMPTY_SMART_VIEWHANDLER;
    private static final Color4b PANIC_COLOR;
    private boolean panic = false;
    private String panicMessage = null;
    private Throwable panicThrowable = null;
    private ViewModel currentView;
    private ArrayList currentViewList = new ArrayList(5);
    private List screenAreaOrder;
    private boolean displayOn = true;
    protected CountDownLatch releaseLatch;
    protected boolean skinIsChanging = false;
    protected String currentViewTreeString = "()";
    CowList desktopDiagnosticsNotificationReceivers = CowList.EMPTY;
    private Map screenAreaPathString2shortViewName = new HashMap();
    private ArrayList ignoreLeavePathStrings = new ArrayList();
    List releasedScreenAreaNames;
    private boolean evaluatingPopupStack = false;
    private boolean vipPresent;
    private static ArrayList currentViewNameList;
    private boolean driverDistractionPreventionPopupIsDisplayed = false;
    private boolean driverDistractionThresholdExceeded = false;
    private int driverDistractionPreventionGroupId = 0;

    public DesktopManagerImpl(LoggerFactory loggerFactory) {
        this.logger = loggerFactory.getLogger(1024);
        this.screenAreaOrder = new ArrayList(11);
        this.screenAreaOrder.add("ScreenAreaParticleBackground");
        this.screenAreaOrder.add("ScreenAreaMenu");
        this.screenAreaOrder.add("ScreenAreaStatus");
        this.screenAreaOrder.add("ScreenAreaCar");
        this.screenAreaOrder.add("ScreenAreaClimate");
        this.screenAreaOrder.add("ScreenAreaClimateSetup");
        this.screenAreaOrder.add("ScreenAreaStage");
        this.screenAreaOrder.add("ScreenAreaDisplayOffClock");
        this.screenAreaOrder.add("ScreenAreaSpeech");
        this.screenAreaOrder.add("ScreenAreaPopup");
        this.screenAreaOrder.add("ScreenAreaParking");
        this.screenAreaOrder.add("ScreenAreaCleanUp");
    }

    private void initScreen(ScreenModel screenModel) {
        this.logger.info(1024).append("init screen").append(screenModel).log();
        this.screen = screenModel;
        this.screenList = new ArrayList(1);
        screenModel.setAnimationBlockingEnabled(this.isAnimationBlockedEnabled());
        this.screenList.add(screenModel);
        this.popupScreenAreaDude = this.getScreenAreaDude("ScreenAreaPopup");
        ServiceManager.repaintManager.repaint();
    }

    private void setPreInitViews() {
        for (int i2 = 0; i2 < this.preInitMemoryScreenAreaPath.size(); ++i2) {
            String string = (String)this.preInitMemoryScreenAreaPath.get(i2);
            SmartViewHandler smartViewHandler = (SmartViewHandler)this.preInitMemorySmartViewHandlers.get(i2);
            ScreenAreaDude screenAreaDude = this.getScreenAreaDude(string);
            screenAreaDude.enterView(smartViewHandler);
        }
        this.preInitMemoryScreenAreaPath.clear();
        this.preInitMemoryScreenAreaPath = null;
        this.preInitMemorySmartViewHandlers.clear();
        this.preInitMemorySmartViewHandlers = null;
    }

    public ScreenAreaDude getScreenAreaDude(String string) {
        ScreenAreaDude screenAreaDude = (ScreenAreaDude)this.screenAreaDudes.get(string);
        if (screenAreaDude == null) {
            if (this.logger.isTraceEnabled(1024)) {
                this.logger.trace(1024).append("create dude for screen area ").append(string).log();
            }
            screenAreaDude = new ScreenAreaDude(this, string);
            this.screenAreaDudes.put(string, screenAreaDude);
        }
        return screenAreaDude;
    }

    private ScreenAreaDude getScreenAreaDudeByViewName(String string) {
        ScreenAreaDude screenAreaDude = (ScreenAreaDude)this.viewName2screenAreaDude.get(string);
        return screenAreaDude;
    }

    public SmartViewHandler getScreenViewHandler() {
        return this.screenViewHandler;
    }

    public SmartViewHandler getDominantViewHandlerOfScreenArea(String string) {
        SmartViewHandler smartViewHandler = null;
        if ("".equals(string)) {
            smartViewHandler = this.screenViewHandler;
        } else {
            ScreenAreaDude screenAreaDude = (ScreenAreaDude)this.screenAreaDudes.get(string);
            if (screenAreaDude == null) {
                this.logger.error(2).append("DM getDominantViewHandlerOfScreenArea(").append(string).append(") ").append("ScreenAreaDude not found!").log();
                return null;
            }
            smartViewHandler = screenAreaDude.getDominantViewHandler();
        }
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("DM getDominantViewHandlerOfScreenArea(\"").append(string).append("\") => [").append(smartViewHandler != null ? smartViewHandler.getShortViewHandlerName() : "").append("]").log();
        }
        return smartViewHandler;
    }

    public List getViewHandlersOfScreenArea(String string) {
        if ("".equals(string)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.screenViewHandler);
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("DM getViewHandlersOfScreenArea(\"").append(string).append("\") => [").append(this.screenViewHandler.getShortViewHandlerName()).append("]").log();
            }
            return arrayList;
        }
        ScreenAreaDude screenAreaDude = (ScreenAreaDude)this.screenAreaDudes.get(string);
        if (screenAreaDude == null) {
            this.logger.error(2).append("DM getViewHandlersOfScreenArea(").append(string).append(") ").append("ScreenAreaDude not found!").log();
            return null;
        }
        List list = screenAreaDude.getViewHandlers();
        if (this.logger.isTraceEnabled(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (int i2 = 0; i2 < list.size(); ++i2) {
                if (i2 > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((SmartViewHandler)list.get(i2)).getShortViewHandlerName());
            }
            stringBuilder.append("]");
            this.logger.trace(2).append("DM getViewHandlersOfScreenArea(\"").append(string).append("\") => ").append(stringBuilder.toString()).log();
        }
        return list;
    }

    @Override
    public void enterView(AppDefinition appDefinition, ViewHandlerProvider viewHandlerProvider, String string, String[] stringArray, boolean bl, int n) {
        if (stringArray[0] == null) {
            stringArray = new String[]{};
        }
        String string2 = this.screenAreaPathToString(stringArray);
        if (this.skinIsChanging) {
            this.logger.info(2).append("DM I enterView('").append(string).append("', '").append(string2).append("', ").append(bl).append(", ").append(n).append(") IGNORED: skin is changing!").log();
            return;
        }
        this.logger.info(2).append("DM I enterView('").append(string).append("', '").append(string2).append("', ").append(bl).append(", ").append(n).append(")").log();
        this.screenAreaPathString2shortViewName.put(string2, string);
        this.doEnterView(viewHandlerProvider, string, string2, bl, n);
    }

    private void doEnterView(ViewHandlerProvider viewHandlerProvider, String string, String string2, boolean bl, int n) {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("DM doEnterView('").append(string).append("', '").append(string2).append("', ").append(bl).append(", ").append(n).append(")").log();
        }
        this.abortLeaveAnimation(string, string2);
        try {
            SmartViewHandler smartViewHandler = ServiceManager.smartViewHandlerProvider.getViewHandler(viewHandlerProvider, string, true);
            smartViewHandler.setAnimationBlockingEnabled(this.isAnimationBlockedEnabled());
            smartViewHandler.setResetView(bl);
            if ("ScreenAreaStage".equals(string2)) {
                this.setDriverDistractionPreventionGroupId(n);
                this.updateViewNameList(smartViewHandler);
            }
            if (this.screen == null) {
                ViewModel viewModel = smartViewHandler.getView();
                if (viewModel instanceof ScreenModel) {
                    smartViewHandler.linkToScreenTree('a');
                    smartViewHandler.init();
                    ServiceManager.screenAreaTree = new ScreenTree(smartViewHandler);
                    this.screenViewHandler = smartViewHandler;
                    this.initScreen((ScreenModel)viewModel);
                    smartViewHandler.activate(true);
                    this.setPreInitViews();
                } else {
                    this.preInitMemoryScreenAreaPath.add(string2);
                    this.preInitMemorySmartViewHandlers.add(smartViewHandler);
                }
                return;
            }
            ScreenAreaDude screenAreaDude = this.getScreenAreaDude(string2);
            screenAreaDude.setAnimationBlockingEnabled(this.isAnimationBlockedEnabled());
            if (string2.indexOf(46) >= 0) {
                this.viewName2screenAreaDude.put(string, screenAreaDude);
                screenAreaDude.enterView(smartViewHandler);
                return;
            }
            screenAreaDude.enterView(smartViewHandler);
            if (this.panic) {
                this.resetPanic();
            }
        }
        catch (Throwable throwable) {
            this.setPanic(throwable);
            this.updateDisplay();
        }
    }

    private void abortLeaveAnimation(String string, String string2) {
        ScreenAreaDude screenAreaDude;
        Iterator iterator = this.screenAreaDudes.values().iterator();
        while (iterator.hasNext() && !(screenAreaDude = (ScreenAreaDude)iterator.next()).abortLeaveAnimation(string)) {
        }
    }

    private void handleDisplayEvent(DisplayEvent displayEvent) {
        boolean bl;
        boolean bl2 = bl = displayEvent.getState() == 1;
        if (bl != this.displayOn) {
            this.displayOn = bl;
            ServiceManager.repaintManager.repaint();
        }
    }

    private String screenAreaPathToString(String[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (i2 != 0) {
                stringBuilder.append('.');
            }
            stringBuilder.append(stringArray[i2]);
        }
        String string = stringBuilder.toString();
        return string;
    }

    void removeProvidedScreenAreas(String string, ScreenAreaModel[] screenAreaModelArray) {
    }

    @Override
    public void leaveView(String string, String[] stringArray, int n, boolean bl) {
        String string2 = this.screenAreaPathToString(stringArray);
        this.logger.info(2).append("DM I leaveView('").append(string).append("', '").append(string2).append("', ").append(bl).append(")").log();
        if (this.ignoreLeavePathStrings.contains(string2)) {
            this.ignoreLeavePathStrings.remove(string2);
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("DM leaveView('").append(string).append("', '").append(string2).append("', ").append(bl).append(") ignored and removed from ignore list!").log();
            }
            return;
        }
        if (this.skinIsChanging) {
            this.logger.info(2).append("DM I leaveView('").append(string).append("', '").append(string2).append("', ").append(bl).append(") IGNORED: skin is changing!").log();
            return;
        }
        Iterator iterator = this.screenAreaPathString2shortViewName.keySet().iterator();
        ArrayList arrayList = new ArrayList();
        while (iterator.hasNext()) {
            String string3 = (String)iterator.next();
            if (string3.equals(string2)) {
                iterator.remove();
                continue;
            }
            if (!string3.startsWith(string2)) continue;
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("DM #SA '").append(string3).append("' added to ignore leave list! ").log();
            }
            this.ignoreLeavePathStrings.add(string3);
            arrayList.add(string3);
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, new DesktopManagerImpl$1(this));
        }
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            String string4 = (String)arrayList.get(i2);
            String string5 = (String)this.screenAreaPathString2shortViewName.get(string4);
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("DM GENERATE leaveView #SA '").append(string4).append("' #VSN '").append(string5).append("'").log();
            }
            this.doLeaveView(string5, string4, n, false);
        }
        this.doLeaveView(string, string2, n, bl);
    }

    private void doLeaveView(String string, String string2, int n, boolean bl) {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("DM doLeaveView('").append(string).append("', '").append(string2).append("', ").append(bl).append(")").log();
        }
        if (string2.indexOf(46) < 0) {
            ScreenAreaDude screenAreaDude = this.getScreenAreaDude(string2);
            if (screenAreaDude != null) {
                screenAreaDude.deactivateView(string, n, bl);
            }
        } else {
            ScreenAreaDude screenAreaDude = this.getScreenAreaDudeByViewName(string);
            screenAreaDude.deactivateView(string, n, false);
        }
    }

    @Override
    public void clearScreenArea(String[] stringArray) {
        String string = this.screenAreaPathToString(stringArray);
        this.logger.info(2).append("DM I clearScreenArea('").append(string).append("')").log();
        this.onClearScreenArea(string);
    }

    private void onClearScreenArea(String string) {
        Object object;
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("DM onClearScreenArea('").append(string).append("')").log();
        }
        Iterator iterator = this.screenAreaPathString2shortViewName.keySet().iterator();
        ArrayList arrayList = new ArrayList();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            if (string2.equals(string) || !string2.startsWith(string)) continue;
            object = this.getScreenAreaDude(string2);
            if (object != null && !((ScreenAreaDude)object).isLeft()) {
                if (this.logger.isTraceEnabled(2)) {
                    this.logger.trace(2).append("DM #SA '").append(string2).append("' added to ignore leave list! ").log();
                }
                this.ignoreLeavePathStrings.add(string2);
            }
            arrayList.add(string2);
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, new DesktopManagerImpl$2(this));
        }
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            object = (String)arrayList.get(i2);
            if (((String)object).equals(string)) continue;
            ScreenAreaDude screenAreaDude = this.getScreenAreaDude((String)object);
            if (screenAreaDude != null && !screenAreaDude.isLeft()) {
                String string3 = (String)this.screenAreaPathString2shortViewName.get(object);
                if (this.logger.isTraceEnabled(2)) {
                    this.logger.trace(2).append("DM GENERATE leaveView #SA '").append((String)object).append("' #VSN '").append(string3).append("'").log();
                }
                this.doLeaveView(string3, (String)object, 0, false);
            }
            this.screenAreaPathString2shortViewName.remove(object);
            this.onClearScreenArea((String)object);
        }
        this.doClearScreenArea(string);
    }

    public void doClearScreenArea(String string) {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("DM doClearScreenArea('").append(string).append("')").log();
        }
        ScreenAreaDude screenAreaDude = this.getScreenAreaDude(string);
        this.viewName2screenAreaDude.remove(screenAreaDude.getCurrentViewName());
        if (screenAreaDude != null) {
            screenAreaDude.enterView(null);
        }
    }

    @Override
    public void openPopup(ViewHandler viewHandler, String[] stringArray) {
    }

    @Override
    public void closePopup(ViewHandler viewHandler, String[] stringArray) {
    }

    private void visualize(String string) {
        System.out.println(new StringBuffer().append("|  ").append(string).toString());
    }

    private void visualize(List list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DM SV ");
        if (list.size() == 0) {
            stringBuilder.append("-");
        } else {
            ViewModel viewModel = (ViewModel)list.get(0);
            this.append(stringBuilder, viewModel);
        }
        this.logger.info(2048).append(stringBuilder.toString()).log();
    }

    private void append(StringBuilder stringBuilder, ViewModel viewModel) {
        this.appendWidgetInfo(stringBuilder, viewModel);
        this.searchScreenAreas(stringBuilder, viewModel);
        stringBuilder.append(");");
    }

    private void searchScreenAreas(StringBuilder stringBuilder, ContainerModel containerModel) {
        WidgetModel[] widgetModelArray = containerModel.getChildren();
        for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
            WidgetModel widgetModel = widgetModelArray[i2];
            if (widgetModel instanceof ScreenAreaModel) {
                ScreenAreaModel screenAreaModel = (ScreenAreaModel)widgetModel;
                this.appendWidgetInfo(stringBuilder, screenAreaModel);
                WidgetModel[] widgetModelArray2 = screenAreaModel.getChildren();
                for (int i3 = 0; i3 < widgetModelArray2.length; ++i3) {
                    this.append(stringBuilder, (ViewModel)widgetModelArray2[i3]);
                }
                stringBuilder.append(");");
                continue;
            }
            if (!(widgetModel instanceof ContainerModel)) continue;
            this.searchScreenAreas(stringBuilder, (ContainerModel)widgetModel);
        }
    }

    private void appendWidgetInfo(StringBuilder stringBuilder, WidgetModel widgetModel) {
        stringBuilder.append(widgetModel.get_name()).append(':').append(widgetModel.is_visible() ? (char)'V' : 'v').append(widgetModel.is_activated() ? (char)'A' : 'a').append(':').append(widgetModel.get_width()).append('x').append(widgetModel.get_height()).append('@').append(widgetModel.getAbsX()).append(',').append(widgetModel.getAbsY()).append('(');
    }

    private void addViewTreeView(SmartViewHandler smartViewHandler, String string, StringBuilder stringBuilder) {
        int n;
        stringBuilder.append(smartViewHandler.getShortViewHandlerName());
        boolean bl = false;
        ArrayList arrayList = new ArrayList(8);
        ArrayList arrayList2 = new ArrayList(8);
        ScreenAreaModel[] screenAreaModelArray = smartViewHandler.getScreenAreas();
        for (n = 0; n < screenAreaModelArray.length; ++n) {
            String string2 = new StringBuffer().append(string).append("".equals(string) ? screenAreaModelArray[n].get_name() : new StringBuffer().append(".").append(screenAreaModelArray[n].get_name()).toString()).toString();
            ScreenAreaDude screenAreaDude = (ScreenAreaDude)this.screenAreaDudes.get(string2);
            if (screenAreaDude == null) continue;
            List list = screenAreaDude.getViewHandlers();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                SmartViewHandler smartViewHandler2 = (SmartViewHandler)list.get(i2);
                if (!smartViewHandler2.is_visible()) continue;
                arrayList.add(smartViewHandler2);
                arrayList2.add(string2);
            }
        }
        for (n = 0; n < arrayList.size(); ++n) {
            if (!bl) {
                stringBuilder.append("(");
                bl = true;
            } else {
                stringBuilder.append(";");
            }
            this.addViewTreeView((SmartViewHandler)arrayList.get(n), (String)arrayList2.get(n), stringBuilder);
        }
        if (bl) {
            stringBuilder.append(")");
        }
    }

    private String getViewTreeString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        this.addViewTreeView(this.screenViewHandler, "", stringBuilder);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override
    public void repaint() {
        if (this.repaintEnabled) {
            try {
                if (this.doPrePaintHandling()) {
                    if (this.logger.isTraceEnabled(512)) {
                        this.logger.trace(512).append("DM repaint()").log();
                    }
                    ServiceManager.viewCompositor.repaintViews(this.displayOn ? this.screenList : EMPTY_VIEWLIST);
                    this.doPostPaintHandling();
                }
            }
            catch (Exception exception) {
                this.logger.error(1024, "Error while repainting screen!", exception);
            }
        }
    }

    @Override
    public void consumeEvent(DisplayEvent displayEvent) {
        this.handleDisplayEvent(displayEvent);
    }

    @Override
    public boolean consumeEvent(HMIEvent hMIEvent) {
        if (!this.skinIsChanging) {
            boolean bl;
            boolean bl2 = bl = this.darkFaderIndicatorViewHandler.consumeEvent(hMIEvent) || ServiceManager.popupStackManager.consumeEvent(hMIEvent);
            if (bl) {
                this.logger.info(1024).append("hmi event ").append(hMIEvent).append(" consumed by popup").append(" in ").append(this.popupScreenAreaDude).log();
                return bl;
            }
            for (int i2 = this.screenAreaOrder.size() - 1; i2 >= 0; --i2) {
                String string = (String)this.screenAreaOrder.get(i2);
                ScreenAreaDude screenAreaDude = (ScreenAreaDude)this.screenAreaDudes.get(string);
                if (screenAreaDude == null || screenAreaDude == this.popupScreenAreaDude || !screenAreaDude.consumeEvent(hMIEvent, ServiceManager.screenAreaTree.getScreenAreaNode(string))) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public void consumeEvent(PopupViewEvent popupViewEvent) {
        if (this.popupScreenAreaDude == null) {
            return;
        }
        ServiceManager.popupStackManager.consumeEvent(popupViewEvent);
        this.evaluatePopupStack();
    }

    public void evaluatePopupStack() {
        if (this.evaluatingPopupStack) {
            return;
        }
        this.evaluatingPopupStack = true;
        ArrayList arrayList = ServiceManager.popupStackManager.getPopupViewHandlers(this.darkFaderIndicatorViewHandler != SmartViewHandler.EMPTY_SMART_VIEWHANDLER ? this.darkFaderIndicatorViewHandler : null);
        this.popupScreenAreaDude.setAnimationBlockingEnabled(this.isAnimationBlockedEnabled());
        this.popupScreenAreaDude.updatePopupStack(arrayList);
        ServiceManager.popupStackManager.updatePopupInfo();
        this.evaluatingPopupStack = false;
    }

    @Override
    public void consumeEvent(StartupEvent startupEvent) {
        if (startupEvent.getEventId() == 2) {
            // empty if block
        }
    }

    @Override
    public void consumeEvent(ProximityEvent proximityEvent) {
        this.screen.consumeProximityEvent(proximityEvent);
    }

    @Override
    public void consumeEvent(TouchEvent touchEvent) {
        if (this.darkFaderIndicatorViewHandler.consumeEvent(touchEvent)) {
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2).append("The DarkFaderIndicatorViewHandler consumed the TouchEvent '").append(touchEvent.getType()).append("'. It will not be passed on.").log();
            }
        } else {
            ServiceManager.popupStackManager.consumeEvent(touchEvent);
            if (this.screen != null) {
                this.screen.consumeTouchEvent(touchEvent);
            }
        }
    }

    @Override
    public void consumeEvent(ViewChangeEvent viewChangeEvent) {
        if (viewChangeEvent.getCommand() != 1) {
            return;
        }
        String string = viewChangeEvent.getFollowingView();
        this.logger.info(1024).append("show view ").append(string).log();
        ViewHandler viewHandler = ServiceManager.viewHandlerFactory.createViewHandler(string);
        viewHandler.create();
        viewHandler.setup();
        viewHandler.init(false);
        viewHandler.activate();
        this.currentView = viewHandler.getView();
        this.screenList.clear();
        this.screenList.add(this.currentView);
        try {
            ServiceManager.viewCompositor.repaintViews(this.screenList);
        }
        catch (Exception exception) {
            this.logger.error(1024, "couldn't show view", exception);
        }
        ServiceManager.diagViewListListener.notifyNewMainViewActive(string);
    }

    @Override
    public String getCurrentViewName() {
        for (int i2 = this.screenAreaOrder.size() - 1; i2 >= 0; --i2) {
            String string;
            ScreenAreaDude screenAreaDude = (ScreenAreaDude)this.screenAreaDudes.get(this.screenAreaOrder.get(i2));
            if (screenAreaDude == null || screenAreaDude == this.popupScreenAreaDude || (string = screenAreaDude.getCurrentViewName()) == null) continue;
            return string;
        }
        return null;
    }

    private void fillCurrentViewList() {
        this.currentViewList.clear();
        if (this.screen != null) {
            ViewModel viewModel = null;
            ViewHandler viewHandler = this.getCurrentViewHandler();
            if (viewHandler != null && (viewModel = viewHandler.getView()) != null) {
                this.currentViewList.add(viewModel);
            }
            ScreenAreaModel[] screenAreaModelArray = this.screenViewHandler.getScreenAreas();
            for (int i2 = screenAreaModelArray.length - 1; i2 >= 0; --i2) {
                WidgetModel[] widgetModelArray = screenAreaModelArray[i2].getChildren();
                if (widgetModelArray == null) continue;
                for (int i3 = 0; i3 < widgetModelArray.length; ++i3) {
                    if (!(widgetModelArray[i3] instanceof ViewModel) || widgetModelArray[i3] == viewModel) continue;
                    this.currentViewList.add(widgetModelArray[i3]);
                }
            }
        }
    }

    @Override
    public View[] getCurrentViews() {
        this.fillCurrentViewList();
        View[] viewArray = new View[this.currentViewList.size()];
        int n = 0;
        for (int i2 = this.currentViewList.size() - 1; i2 >= 0; --i2) {
            viewArray[n++] = (View)this.currentViewList.get(i2);
        }
        return viewArray;
    }

    public ScreenModel getScreen() {
        return this.screen;
    }

    @Override
    public ViewHandler getCurrentViewHandler() {
        for (int i2 = this.screenAreaOrder.size() - 1; i2 >= 0; --i2) {
            SmartViewHandler smartViewHandler;
            ScreenAreaDude screenAreaDude = (ScreenAreaDude)this.screenAreaDudes.get(this.screenAreaOrder.get(i2));
            if (screenAreaDude == null || screenAreaDude == this.popupScreenAreaDude || (smartViewHandler = screenAreaDude.getCurrentViewHandler()) == null) continue;
            return smartViewHandler.getViewHandler();
        }
        return null;
    }

    @Override
    public WidgetModel findWidgetAt(int n, int n2) {
        return null;
    }

    private boolean doPrePaintHandling() {
        if (!this.firstViewShown) {
            this.initializeDarkFaderIndicator();
            this.evaluatePopupStack();
        }
        if (this.panic) {
            if (this.panicThrowable != null) {
                ServiceManager.viewCompositor.drawPanicMessage(this.panicThrowable, PANIC_COLOR);
            } else if (this.panicMessage != null) {
                ServiceManager.viewCompositor.drawPanicMessage(this.panicMessage, PANIC_COLOR);
            } else {
                ServiceManager.viewCompositor.drawPanicMessage(new StringBuffer().append("Impossible error #1 in ").append(super.getClass().getName()).append("!").toString(), PANIC_COLOR);
            }
            return false;
        }
        if (this.screenList == null) {
            return false;
        }
        if (!this.firstViewShown) {
            this.logger.info(1, "First view start");
            if (ServiceManager.perfService != null) {
                ServiceManager.perfService.performanceLogMsgByID(22);
            }
        }
        if (this.vipPresent != ServiceManager.popupStackManager.isVipPresent()) {
            boolean bl = this.vipPresent = !this.vipPresent;
            if (this.vipPresent) {
                ServiceManager.statemachineManager.veryImportantPopup(1);
            } else {
                ServiceManager.statemachineManager.veryImportantPopup(0);
            }
        }
        boolean bl = true;
        boolean bl2 = false;
        for (int i2 = this.screenAreaOrder.size() - 1; i2 >= 0; --i2) {
            String string = (String)this.screenAreaOrder.get(i2);
            ScreenAreaDude screenAreaDude = (ScreenAreaDude)this.screenAreaDudes.get(string);
            if (screenAreaDude == null) continue;
            if ("ScreenAreaPopup".equals(string) || "ScreenAreaSpeech".equals(string) || "ScreenAreaStage".equals(string) || "ScreenAreaClimateSetup".equals(string) || "ScreenAreaParticleBackground".equals(string) || "ScreenAreaDisplayOffClock".equals(string) || "ScreenAreaParking".equals(string)) {
                if (screenAreaDude.isCovered() != bl2) {
                    screenAreaDude.setCovered(bl2);
                }
                if (screenAreaDude.getDominantViewHandler() != null) {
                    bl2 = true;
                }
                if (screenAreaDude.isVisible() != bl) {
                    screenAreaDude.setVisible(bl);
                }
                if (screenAreaDude.isOpaque()) {
                    bl = false;
                }
            }
            List list = screenAreaDude.getViewHandlers();
            for (int i3 = 0; i3 < list.size(); ++i3) {
                SmartViewHandler smartViewHandler = (SmartViewHandler)list.get(i3);
                if (smartViewHandler.isInitialized()) continue;
                this.logger.error(2).append("DM View '").append(smartViewHandler.getNameForTraces()).append("' is not initialized!").log();
            }
        }
        if (ServiceManager.viewTreeIsDirty) {
            String string = this.getViewTreeString();
            if (!string.equals(this.currentViewTreeString)) {
                this.currentViewTreeString = string;
                this.notifyDesktopDiagnosticsNotificationReceivers(1);
                ServiceManager.viewCompositor.setViewNames(this.convertViewTreeStringToStringList(this.currentViewTreeString));
            }
            ServiceManager.viewTreeIsDirty = false;
        }
        return true;
    }

    private void doPostPaintHandling() {
        ArrayList arrayList = new ArrayList();
        DiagViewList.clear();
        for (int i2 = 0; i2 < this.screenAreaOrder.size(); ++i2) {
            ScreenAreaDude screenAreaDude = (ScreenAreaDude)this.screenAreaDudes.get(this.screenAreaOrder.get(i2));
            if (screenAreaDude == null) continue;
            List list = screenAreaDude.getViewHandlers();
            for (int i3 = 0; i3 < list.size(); ++i3) {
                SmartViewHandler smartViewHandler = (SmartViewHandler)list.get(i3);
                arrayList.add(smartViewHandler.getShortViewHandlerName());
                DiagViewList.addViewAndVisibility(smartViewHandler.getName(), smartViewHandler.getPrettyName(), smartViewHandler.is_visible());
            }
        }
        DiagViewList.sendIfNeeded(true);
        if (ServiceManager.infotainmentRecorderInfoDirty) {
            this.evaluatePopupStack();
            ServiceManager.infotainmentRecorderInfoDirty = false;
        }
        if (!this.firstViewShown) {
            this.logger.info(1, "First view shown");
            if (ServiceManager.perfService != null) {
                ServiceManager.perfService.performanceLogMsgByID(23);
            }
            ServiceManager.eventDispatcher.createAndSubmitStartupEvent(8);
            this.firstViewShown = true;
        }
    }

    private synchronized void initializeDarkFaderIndicator() {
        this.darkFaderIndicatorViewHandler = ServiceManager.smartViewHandlerProvider.getDarkFaderIndicatorViewHandler();
        this.darkFaderIndicatorViewHandler.init();
        this.darkFaderIndicatorViewHandler.activate(true);
    }

    private List convertViewTreeStringToStringList(String string) {
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        int n = -1;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 == '(' || c2 == ')' || c2 == ';') {
                if (stringBuilder.length() > 0) {
                    StringBuilder stringBuilder2 = new StringBuilder(2 * n);
                    for (int i3 = 0; i3 < n; ++i3) {
                        stringBuilder2.append("    ");
                    }
                    arrayList.add(new StringBuffer().append(stringBuilder2.toString()).append(ServiceManager.smartViewHandlerProvider.getGuideName(stringBuilder.toString())).toString());
                    stringBuilder = new StringBuilder();
                }
                switch (c2) {
                    case '(': {
                        ++n;
                        break;
                    }
                    case ')': {
                        --n;
                        break;
                    }
                }
                continue;
            }
            stringBuilder.append(c2);
        }
        return arrayList;
    }

    public void free(SmartViewHandler smartViewHandler) {
        ServiceManager.smartViewHandlerProvider.free(smartViewHandler.getShortViewHandlerName());
    }

    private void updateViewNameList(SmartViewHandler smartViewHandler) {
        String string = (String)currentViewNameList.get(0);
        String string2 = smartViewHandler.getName();
        if (!string2.equals(string)) {
            currentViewNameList.set(0, string2);
            Object[] objectArray = ServiceManager.desktopInformationReceiverServiceTracker.getServices();
            if (objectArray != null) {
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    ((DesktopInformationReceiver)objectArray[i2]).receiveViewNameList(currentViewNameList);
                }
            }
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        DesktopInformationReceiver desktopInformationReceiver = (DesktopInformationReceiver)ServiceManager.bundleContext.getService(serviceReference);
        desktopInformationReceiver.receiveViewNameList(DiagViewList.getVisibleGuideViewNameList());
        return desktopInformationReceiver;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    public void updateDisplay() {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2, "Update display.");
        }
        ServiceManager.repaintManager.repaint();
    }

    private void setPanic(Throwable throwable) {
        if (DesktopManagerConfiguration.PANIC_ENABLED) {
            this.panic = true;
        }
        this.panicThrowable = throwable;
        this.panicMessage = null;
        this.logPanic();
        this.errorHandlePanic(throwable);
    }

    public void setPanic(String string) {
        if (DesktopManagerConfiguration.PANIC_ENABLED) {
            this.panic = true;
        }
        this.panicThrowable = null;
        this.panicMessage = string;
        this.logPanic();
        this.errorHandlePanic(new Exception(string));
    }

    private void resetPanic() {
        this.panic = false;
        this.panicThrowable = null;
        this.panicMessage = null;
    }

    private void logPanic() {
        LogMessage logMessage = this.logger.error(2);
        logMessage.append("Panic Screen: ");
        if (this.panicMessage != null) {
            logMessage.append(this.panicMessage);
        }
        if (this.panicThrowable != null) {
            logMessage.attachThrowable(this.panicThrowable);
        }
        logMessage.log();
    }

    private void errorHandlePanic(Throwable throwable) {
        ServiceManager.errorHandler.handleViewCreationError(throwable, !DesktopManagerConfiguration.PANIC_ENABLED);
    }

    public void deactivateMainViewHandler() {
    }

    public void activateMainViewHandler() {
    }

    public void signalClosingOpaquePopup() {
    }

    @Override
    public void propagateSkinMode(int n) {
        ServiceManager.eventDispatcher.invoke(new DesktopManagerImpl$3(this, n));
    }

    protected void doPropagateSkinMode(int n) {
        Color.setDayNightMode(n);
        Image.setDayNightMode(n);
        ServiceManager.popupStackManager.propagateSkinMode();
        if (this.darkFaderIndicatorViewHandler != null) {
            this.darkFaderIndicatorViewHandler.invalidate();
        }
    }

    @Override
    public void releaseResourcesForSkinChange() {
        if (this.firstViewShown) {
            this.repaintEnabled = false;
            this.releaseLatch = new CountDownLatch(1);
            ServiceManager.eventDispatcher.invoke(new DesktopManagerImpl$4(this));
            try {
                if (!this.releaseLatch.await(1L, TimeUnit.SECONDS)) {
                    this.doReleaseResourcesForSkinChange();
                }
            }
            catch (InterruptedException interruptedException) {
                this.doReleaseResourcesForSkinChange();
            }
        }
    }

    protected synchronized void doReleaseResourcesForSkinChange() {
        if (this.releaseLatch.getCount() == 0L) {
            return;
        }
        this.logger.info(2).append("DM doReleaseResourcesForSkinChange(): START").log();
        this.skinIsChanging = true;
        ServiceManager.popupStackManager.releaseResourcesForSkinChange();
        if (this.darkFaderIndicatorViewHandler != SmartViewHandler.EMPTY_SMART_VIEWHANDLER) {
            this.darkFaderIndicatorViewHandler.release();
        }
        this.releasedScreenAreaNames = this.getSortedScreenAreaNames();
        for (int i2 = 0; i2 < this.releasedScreenAreaNames.size(); ++i2) {
            ScreenAreaDude screenAreaDude = (ScreenAreaDude)this.screenAreaDudes.get(this.releasedScreenAreaNames.get(i2));
            screenAreaDude.releaseResourcesForSkinChange();
        }
        this.screenViewHandler.release();
        ServiceManager.smartViewHandlerProvider.clear();
        this.logger.info(2).append("DM doReleaseResourcesForSkinChange(): STOP").log();
        this.releaseLatch.countDown();
    }

    @Override
    public void restoreResourcesForSkinChange() {
        if (!this.firstViewShown) {
            this.repaintEnabled = true;
            return;
        }
        this.doRestoreResourcesForSkinChange();
    }

    protected synchronized void doRestoreResourcesForSkinChange() {
        try {
            this.logger.info(2).append("DM doRestoreResourcesForSkinChange(): START").log();
            SpellerManager.clearCache();
            this.screenViewHandler.reload();
            this.screen = (ScreenModel)this.screenViewHandler.getView();
            this.screenList.set(0, this.screen);
            this.screenViewHandler.linkToScreenTree('b');
            this.screenViewHandler.restore();
            this.popupScreenAreaDude.prepareRestoreResourcesForSkinChange();
            ServiceManager.popupStackManager.restoreResourcesForSkinChange(this.darkFaderIndicatorViewHandler == SmartViewHandler.EMPTY_SMART_VIEWHANDLER ? null : this.darkFaderIndicatorViewHandler);
            for (int i2 = this.releasedScreenAreaNames.size() - 1; i2 >= 0; --i2) {
                ScreenAreaDude screenAreaDude = (ScreenAreaDude)this.screenAreaDudes.get(this.releasedScreenAreaNames.get(i2));
                screenAreaDude.restoreResourcesForSkinChange();
            }
        }
        catch (Throwable throwable) {
            this.setPanic(throwable);
        }
        this.repaintEnabled = true;
        this.logger.info(2).append("DM doRestoreResourcesForSkinChange(): STOP").log();
        this.skinIsChanging = false;
    }

    private List getSortedScreenAreaNames() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.screenAreaDudes.keySet().iterator();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, new DesktopManagerImpl$5(this));
        }
        return arrayList;
    }

    private void setDriverDistractionPreventionGroupId(int n) {
        this.driverDistractionPreventionGroupId = n;
        this.updateAnimationBlockingState();
        this.processDriverDistractionPreventionPopup();
    }

    @Override
    public void onThresholdExceeded() {
        this.driverDistractionThresholdExceeded = true;
        this.updateAnimationBlockingState();
        this.processDriverDistractionPreventionPopup();
    }

    @Override
    public void onThresholdClear() {
        this.driverDistractionThresholdExceeded = false;
        this.updateAnimationBlockingState();
        this.processDriverDistractionPreventionPopup();
    }

    private void processDriverDistractionPreventionPopup() {
        boolean bl;
        boolean bl2 = bl = this.driverDistractionThresholdExceeded && ServiceManager.configurationManager.isStateGroupBlockable(this.driverDistractionPreventionGroupId);
        if (bl != this.driverDistractionPreventionPopupIsDisplayed) {
            ServiceManager.statemachineManager.setDriverDistractionPrevention(bl ? 1 : 0);
            this.driverDistractionPreventionPopupIsDisplayed = bl;
        }
    }

    @Override
    public boolean isShowDebugOverlayEnabled() {
        if (this.screen != null) {
            return this.screen.isDrawDebugOverlayEnabled();
        }
        return false;
    }

    @Override
    public void setShowDebugOverlayEnabled(boolean bl) {
        if (this.screen != null) {
            this.screen.setDrawDebugOverlayEnabled(bl);
        }
    }

    @Override
    public boolean isShowBoundingBoxesEnabled() {
        if (this.screen != null) {
            return this.screen.isDrawBoundingBoxesEnabled();
        }
        return false;
    }

    @Override
    public void setShowBoundingBoxesEnabled(boolean bl) {
        if (this.screen != null) {
            this.screen.setDrawBoundingBoxesEnabled(bl);
        }
    }

    private void notifyDesktopDiagnosticsNotificationReceivers(int n) {
        for (CowList cowList = this.desktopDiagnosticsNotificationReceivers; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            ((DesktopDiagnosticsNotificationReceiver)cowList.head()).receiveDesktopDiagnosticsNotification(n);
        }
    }

    @Override
    public void addDesktopDiagnosticsNotificationReceiver(DesktopDiagnosticsNotificationReceiver desktopDiagnosticsNotificationReceiver) {
        this.desktopDiagnosticsNotificationReceivers = this.desktopDiagnosticsNotificationReceivers.add(desktopDiagnosticsNotificationReceiver);
    }

    @Override
    public String getViewTreeAsShortString() {
        return this.currentViewTreeString;
    }

    public void leaveHostedScreenAreas(String string, SmartViewHandler smartViewHandler) {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("DM leaveHostedScreenAreas(\"").append(string).append("\")").log();
        }
        if (string.length() > 0) {
            string = new StringBuffer().append(string).append(".").toString();
        }
        Iterator iterator = this.screenAreaDudes.entrySet().iterator();
        ArrayList arrayList = new ArrayList();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            if (!((String)map$Entry.getKey()).startsWith(string)) continue;
            arrayList.add(map$Entry);
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, new DesktopManagerImpl$6(this));
        }
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            Map$Entry map$Entry = (Map$Entry)arrayList.get(i2);
            ScreenAreaDude screenAreaDude = (ScreenAreaDude)map$Entry.getValue();
            ScreenAreaNode screenAreaNode = ServiceManager.screenAreaTree.getScreenAreaNode(screenAreaDude.getScreenAreaPathString());
            if (screenAreaNode == null) continue;
            screenAreaDude.leave();
        }
    }

    public void removeSubScreenAreas(String string, SmartViewHandler smartViewHandler) {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("DM removeSubScreenAreas(\"").append(string).append("\", \"").append(smartViewHandler.getNameForTraces()).append("\")").log();
        }
        if (string.length() > 0) {
            string = new StringBuffer().append(string).append(".").toString();
        }
        Iterator iterator = this.screenAreaDudes.entrySet().iterator();
        while (iterator.hasNext()) {
            ScreenAreaDude screenAreaDude;
            ScreenAreaNode screenAreaNode;
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            if (!((String)map$Entry.getKey()).startsWith(string) || (screenAreaNode = ServiceManager.screenAreaTree.getScreenAreaNode((screenAreaDude = (ScreenAreaDude)map$Entry.getValue()).getScreenAreaPathString())) == null || !screenAreaNode.getParent().getViewHandler().equals(smartViewHandler)) continue;
            screenAreaDude.clear();
            Iterator iterator2 = this.screenAreaPathString2shortViewName.keySet().iterator();
            while (iterator2.hasNext()) {
                String string2 = (String)iterator2.next();
                if (!string2.startsWith(screenAreaDude.getScreenAreaPathString())) continue;
                iterator2.remove();
            }
        }
    }

    public boolean isSkinChanging() {
        return this.skinIsChanging;
    }

    public void removeHostedScreenAreasFromViewHandler(SmartViewHandler smartViewHandler) {
    }

    private void updateAnimationBlockingState() {
        boolean bl = this.isAnimationBlockedEnabled();
        if (this.currentView != null) {
            this.currentView.setAnimationBlockingEnabled(bl);
        }
        if (this.screenList == null) {
            this.logger.warn(2, "Animation blocking deferred, screenList is null, since initScreen has not been called, yet.");
            return;
        }
        Iterator iterator = this.screenList.iterator();
        while (iterator.hasNext()) {
            ScreenModel screenModel = (ScreenModel)iterator.next();
            screenModel.setAnimationBlockingEnabled(bl);
        }
    }

    private boolean isAnimationBlockedEnabled() {
        boolean bl = ServiceManager.configurationManager.isStateGroupBlockable(141);
        return bl && this.driverDistractionThresholdExceeded;
    }

    static {
        EMPTY_VIEWLIST = new ArrayList();
        PANIC_COLOR = new Color4b(255, 0, 0, 128);
        currentViewNameList = new ArrayList(1);
        currentViewNameList.add("");
    }
}

