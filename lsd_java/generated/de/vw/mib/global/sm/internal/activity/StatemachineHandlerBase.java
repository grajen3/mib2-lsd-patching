/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.sm.internal.activity;

import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.datapool.ExtendedListItemControl;
import de.vw.mib.event.IntegerValueEvent;
import de.vw.mib.event.ListItemEvent;
import de.vw.mib.event.PointEvent;
import de.vw.mib.event.SpellerValueEvent;
import de.vw.mib.event.StringValueEvent;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.sm.internal.CurrentHMIEvent;
import de.vw.mib.sm.internal.ServiceManagerStatemachine;
import org.dsi.ifc.global.ResourceLocator;

public abstract class StatemachineHandlerBase {
    protected static final AppDefinition ANY = null;
    protected static final AppDefinition BROADCAST = null;
    private final CellValue cellValue = new CellValue();
    static /* synthetic */ Class class$de$vw$mib$event$IntegerValueEvent;
    static /* synthetic */ Class class$de$vw$mib$event$ListItemEvent;
    static /* synthetic */ Class class$de$vw$mib$event$PointEvent;
    static /* synthetic */ Class class$de$vw$mib$event$SpellerValueEvent;
    static /* synthetic */ Class class$de$vw$mib$event$StringValueEvent;

    protected boolean getBoolean(int n) {
        return ServiceManagerCommon.modelDatapool.getBoolean(n);
    }

    protected void setBoolean(int n, boolean bl) {
        ServiceManagerCommon.modelDatapool.setBoolean(n, bl);
    }

    protected FixFormatterFieldData getFixFormatterFieldData(int n) {
        return ServiceManagerCommon.modelDatapool.getFixFormatterFieldData(n);
    }

    protected void setFixFormatterFieldData(int n, FixFormatterFieldData fixFormatterFieldData) {
        ServiceManagerCommon.modelDatapool.setFixFormatterFieldData(n, fixFormatterFieldData);
    }

    protected boolean[] getFlagVector(int n) {
        return ServiceManagerCommon.modelDatapool.getFlagVector(n);
    }

    protected void setFlagVector(int n, boolean[] blArray) {
        ServiceManagerCommon.modelDatapool.setFlagVector(n, blArray);
    }

    protected float getFloat(int n) {
        return ServiceManagerCommon.modelDatapool.getFloat(n);
    }

    protected void setFloat(int n, float f2) {
        ServiceManagerCommon.modelDatapool.setFloat(n, f2);
    }

    protected int getInteger(int n) {
        return ServiceManagerCommon.modelDatapool.getInteger(n);
    }

    protected void setInteger(int n, int n2) {
        ServiceManagerCommon.modelDatapool.setInteger(n, n2);
    }

    protected int[] getIntegerVector(int n) {
        return ServiceManagerCommon.modelDatapool.getIntegerVector(n);
    }

    protected void setIntegerVector(int n, int[] nArray) {
        ServiceManagerCommon.modelDatapool.setIntegerVector(n, nArray);
    }

    protected long getLong(int n) {
        return ServiceManagerCommon.modelDatapool.getLong(n);
    }

    protected void setLong(int n, long l) {
        ServiceManagerCommon.modelDatapool.setLong(n, l);
    }

    protected ResourceLocator getResourceLocator(int n) {
        return ServiceManagerCommon.modelDatapool.getResourceLocator(n);
    }

    protected void setResourceLocator(int n, ResourceLocator resourceLocator) {
        ServiceManagerCommon.modelDatapool.setResourceLocator(n, resourceLocator);
    }

    protected SpellerData getSpellerData(int n) {
        return ServiceManagerCommon.modelDatapool.getSpellerData(n);
    }

    protected void setSpellerData(int n, SpellerData spellerData) {
        ServiceManagerCommon.modelDatapool.setSpellerData(n, spellerData);
    }

    protected String getString(int n) {
        return ServiceManagerCommon.modelDatapool.getString(n);
    }

    protected void setString(int n, String string) {
        ServiceManagerCommon.modelDatapool.setString(n, string);
    }

    protected String[] getStringVector(int n) {
        return ServiceManagerCommon.modelDatapool.getStringVector(n);
    }

    protected void setStringVector(int n, String[] stringArray) {
        ServiceManagerCommon.modelDatapool.setStringVector(n, stringArray);
    }

    protected static void changeSdFeatureCollection(int n, int n2) {
        ServiceManagerStatemachine.sdFeatureCollectionManager.changeSdFeatureCollection(n, n2);
    }

    protected static void pushSdFeatureCollection(int n, int n2) {
        ServiceManagerStatemachine.sdFeatureCollectionManager.pushSdFeatureCollection(n, n2);
    }

    protected static void popSdFeatureCollection(int n) {
        ServiceManagerStatemachine.sdFeatureCollectionManager.popSdFeatureCollection(n);
    }

    protected String getI18nString(int n) {
        return ServiceManagerCommon.i18nDatapool.getString(n);
    }

    protected String[] getI18nStrings(int n) {
        return ServiceManagerCommon.i18nDatapool.getStrings(n);
    }

    protected int getLicValue(int n, int n2, int n3, int n4) {
        return ServiceManagerCommon.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultInt(n4), n, n3, n2).asInt();
    }

    protected boolean getLicValue(int n, int n2, int n3, boolean bl) {
        return ServiceManagerCommon.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultBoolean(bl), n, n3, n2).asBoolean();
    }

    protected long getLicValue(int n, int n2, int n3, long l) {
        return ServiceManagerCommon.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultLong(l), n, n3, n2).asLong();
    }

    protected String getLicValue(int n, int n2, int n3, String string) {
        return ServiceManagerCommon.dynamicListItemControlManager.getCellValue(this.cellValue.withDefaultString(string), n, n3, n2).asString();
    }

    protected ExtendedListItemControl getListItemControl(int n, boolean bl) {
        return ServiceManagerCommon.dynamicListItemControlManager.getListItemControl(n);
    }

    protected void triggerObserver(int n, EventGeneric eventGeneric) {
        StatemachineHandlerBase.getServiceRegister().triggerObserver(n, eventGeneric);
    }

    protected void triggerObserver(int n) {
        StatemachineHandlerBase.getServiceRegister().triggerObserver(n);
    }

    protected static void fireDynamicStateEvent(int n, int n2, int n3) {
        ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitDynamicStateEvent(n, n2, n3);
    }

    protected static void changeContext(String string) {
        ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitContextChangeEvent(string);
    }

    protected static void fireHMIEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n) {
        if (n != -1) {
            ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitHMIEvent(appDefinition, appDefinition2, n);
        }
    }

    protected static void fireIntegerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2) {
        if (n != -1) {
            ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitIntegerValueEvent(appDefinition, appDefinition2, n, n2);
        }
    }

    protected static void fireStringValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string) {
        if (n != -1) {
            ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitStringValueEvent(appDefinition, appDefinition2, n, string);
        }
    }

    protected static void fireListItemEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5, String string, long l) {
        if (n != -1) {
            ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitListItemEvent(appDefinition, appDefinition2, n, n2, n3, n4, n5, string, l);
        }
    }

    protected static void firePointEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5) {
        if (n != -1) {
            ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitPointEvent(appDefinition, appDefinition2, n, n2, n3, n4, n5);
        }
    }

    protected static void fireSpellerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string, int n2, int n3, int n4) {
        if (n != -1) {
            ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitSpellerValueEvent(appDefinition, appDefinition2, n, string, n2, n3, n4);
        }
    }

    protected static EventGeneric newEvent() {
        return ServiceManagerStatemachine.eventFactory.newEvent();
    }

    protected static ServiceRegister getServiceRegister() {
        return ServiceManagerStatemachine.genericEvents.getServiceRegister();
    }

    protected static int evIntegerValueValue() {
        IntegerValueEvent integerValueEvent = (IntegerValueEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$IntegerValueEvent == null ? (class$de$vw$mib$event$IntegerValueEvent = StatemachineHandlerBase.class$("de.vw.mib.event.IntegerValueEvent")) : class$de$vw$mib$event$IntegerValueEvent);
        if (integerValueEvent == null) {
            StatemachineHandlerBase.errorEventParameter("Value of IntegerValueEvent");
            return 0;
        }
        return integerValueEvent.getValue();
    }

    protected static int evListItemActionIndex() {
        ListItemEvent listItemEvent = (ListItemEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$ListItemEvent == null ? (class$de$vw$mib$event$ListItemEvent = StatemachineHandlerBase.class$("de.vw.mib.event.ListItemEvent")) : class$de$vw$mib$event$ListItemEvent);
        if (listItemEvent == null) {
            StatemachineHandlerBase.errorEventParameter("ActionIndex of ListItemEvent");
            return 0;
        }
        return listItemEvent.getActionIndex();
    }

    protected static int evListItemAbsoluteIndex() {
        ListItemEvent listItemEvent = (ListItemEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$ListItemEvent == null ? (class$de$vw$mib$event$ListItemEvent = StatemachineHandlerBase.class$("de.vw.mib.event.ListItemEvent")) : class$de$vw$mib$event$ListItemEvent);
        if (listItemEvent == null) {
            StatemachineHandlerBase.errorEventParameter("AbsoluteIndex of ListItemEvent");
            return 0;
        }
        return listItemEvent.getAbsoluteIndex();
    }

    protected static String evListItemEventSender() {
        ListItemEvent listItemEvent = (ListItemEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$ListItemEvent == null ? (class$de$vw$mib$event$ListItemEvent = StatemachineHandlerBase.class$("de.vw.mib.event.ListItemEvent")) : class$de$vw$mib$event$ListItemEvent);
        if (listItemEvent == null) {
            StatemachineHandlerBase.errorEventParameter("EventSender of ListItemEvent");
            return "GenericEventSender";
        }
        return listItemEvent.getEventSender();
    }

    protected static long evListItemObjectId() {
        ListItemEvent listItemEvent = (ListItemEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$ListItemEvent == null ? (class$de$vw$mib$event$ListItemEvent = StatemachineHandlerBase.class$("de.vw.mib.event.ListItemEvent")) : class$de$vw$mib$event$ListItemEvent);
        if (listItemEvent == null) {
            StatemachineHandlerBase.errorEventParameter("ObjectId of ListItemEvent");
            return 0L;
        }
        return listItemEvent.getObjectId();
    }

    protected static int evListItemDestinationIndex() {
        ListItemEvent listItemEvent = (ListItemEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$ListItemEvent == null ? (class$de$vw$mib$event$ListItemEvent = StatemachineHandlerBase.class$("de.vw.mib.event.ListItemEvent")) : class$de$vw$mib$event$ListItemEvent);
        if (listItemEvent == null) {
            StatemachineHandlerBase.errorEventParameter("DestinationIndex of ListItemEvent");
            return 0;
        }
        return listItemEvent.getDestinationIndex();
    }

    protected static int evPointX() {
        PointEvent pointEvent = (PointEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$PointEvent == null ? (class$de$vw$mib$event$PointEvent = StatemachineHandlerBase.class$("de.vw.mib.event.PointEvent")) : class$de$vw$mib$event$PointEvent);
        if (pointEvent == null) {
            StatemachineHandlerBase.errorEventParameter("X of PointEvent");
            return 0;
        }
        return pointEvent.getX();
    }

    protected static int evPointY() {
        PointEvent pointEvent = (PointEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$PointEvent == null ? (class$de$vw$mib$event$PointEvent = StatemachineHandlerBase.class$("de.vw.mib.event.PointEvent")) : class$de$vw$mib$event$PointEvent);
        if (pointEvent == null) {
            StatemachineHandlerBase.errorEventParameter("Y of PointEvent");
            return 0;
        }
        return pointEvent.getY();
    }

    protected static int evPointGestureParam1() {
        PointEvent pointEvent = (PointEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$PointEvent == null ? (class$de$vw$mib$event$PointEvent = StatemachineHandlerBase.class$("de.vw.mib.event.PointEvent")) : class$de$vw$mib$event$PointEvent);
        if (pointEvent == null) {
            StatemachineHandlerBase.errorEventParameter("GestureParam1 of PointEvent");
            return 0;
        }
        return pointEvent.getGestureParam1();
    }

    protected static int evPointGestureParam2() {
        PointEvent pointEvent = (PointEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$PointEvent == null ? (class$de$vw$mib$event$PointEvent = StatemachineHandlerBase.class$("de.vw.mib.event.PointEvent")) : class$de$vw$mib$event$PointEvent);
        if (pointEvent == null) {
            StatemachineHandlerBase.errorEventParameter("GestureParam2 of PointEvent");
            return 0;
        }
        return pointEvent.getGestureParam2();
    }

    protected static String evSpellerValuePressedChar() {
        SpellerValueEvent spellerValueEvent = (SpellerValueEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$SpellerValueEvent == null ? (class$de$vw$mib$event$SpellerValueEvent = StatemachineHandlerBase.class$("de.vw.mib.event.SpellerValueEvent")) : class$de$vw$mib$event$SpellerValueEvent);
        if (spellerValueEvent == null) {
            StatemachineHandlerBase.errorEventParameter("PressedChar of SpellerValueEvent");
            return "A";
        }
        return spellerValueEvent.getPressedChar();
    }

    protected static int evSpellerValueCursorPosition() {
        SpellerValueEvent spellerValueEvent = (SpellerValueEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$SpellerValueEvent == null ? (class$de$vw$mib$event$SpellerValueEvent = StatemachineHandlerBase.class$("de.vw.mib.event.SpellerValueEvent")) : class$de$vw$mib$event$SpellerValueEvent);
        if (spellerValueEvent == null) {
            StatemachineHandlerBase.errorEventParameter("CursorPosition of SpellerValueEvent");
            return 0;
        }
        return spellerValueEvent.getCursorPosition();
    }

    protected static int evSpellerValueSelectionStart() {
        SpellerValueEvent spellerValueEvent = (SpellerValueEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$SpellerValueEvent == null ? (class$de$vw$mib$event$SpellerValueEvent = StatemachineHandlerBase.class$("de.vw.mib.event.SpellerValueEvent")) : class$de$vw$mib$event$SpellerValueEvent);
        if (spellerValueEvent == null) {
            StatemachineHandlerBase.errorEventParameter("SelectionStart of SpellerValueEvent");
            return 0;
        }
        return spellerValueEvent.getSelectionStart();
    }

    protected static int evSpellerValueSelectionEnd() {
        SpellerValueEvent spellerValueEvent = (SpellerValueEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$SpellerValueEvent == null ? (class$de$vw$mib$event$SpellerValueEvent = StatemachineHandlerBase.class$("de.vw.mib.event.SpellerValueEvent")) : class$de$vw$mib$event$SpellerValueEvent);
        if (spellerValueEvent == null) {
            StatemachineHandlerBase.errorEventParameter("SelectionEnd of SpellerValueEvent");
            return 0;
        }
        return spellerValueEvent.getSelectionEnd();
    }

    protected static String evStringValueValue() {
        StringValueEvent stringValueEvent = (StringValueEvent)CurrentHMIEvent.getEventAs(class$de$vw$mib$event$StringValueEvent == null ? (class$de$vw$mib$event$StringValueEvent = StatemachineHandlerBase.class$("de.vw.mib.event.StringValueEvent")) : class$de$vw$mib$event$StringValueEvent);
        if (stringValueEvent == null) {
            StatemachineHandlerBase.errorEventParameter("Value of StringValueEvent");
            return "";
        }
        return stringValueEvent.getValue();
    }

    private static void errorEventParameter(String string) {
        LogMessage logMessage = ServiceManagerCommon.loggerFactory.getLogger(0x800000).fatal(4);
        logMessage.append("Try to access ").append(string).append(" but event ").append(CurrentHMIEvent.publicId()).append(" is ").append(CurrentHMIEvent.className()).log();
    }

    protected static boolean isCurrentEventConsumed() {
        return CurrentHMIEvent.isConsumed();
    }

    protected Image[] getImageArray(int n) {
        return ServiceManagerCommon.skinImagePool.getImageArray(n);
    }

    protected Image getImage(int n) {
        return ServiceManagerCommon.skinImagePool.getImage(n);
    }

    protected void handleGlobalAction(int n) {
        ServiceManagerStatemachine.globalActionHandler.handleGlobalAction(n);
    }

    protected boolean evalBoolean(int n) {
        return ServiceManagerCommon.globalExpressionEvaluator.evalBoolean(n);
    }

    protected short evalShort(int n) {
        return ServiceManagerCommon.globalExpressionEvaluator.evalShort(n);
    }

    protected int evalInt(int n) {
        return ServiceManagerCommon.globalExpressionEvaluator.evalInt(n);
    }

    protected long evalLong(int n) {
        return ServiceManagerCommon.globalExpressionEvaluator.evalLong(n);
    }

    protected float evalFloat(int n) {
        return ServiceManagerCommon.globalExpressionEvaluator.evalFloat(n);
    }

    protected double evalDouble(int n) {
        return ServiceManagerCommon.globalExpressionEvaluator.evalDouble(n);
    }

    protected String evalString(int n) {
        return ServiceManagerCommon.globalExpressionEvaluator.evalString(n);
    }

    protected Object evalObject(int n) {
        return ServiceManagerCommon.globalExpressionEvaluator.evalObject(n);
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

