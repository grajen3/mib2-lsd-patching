/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.target.tester;

import de.vw.mib.debuginterface.internal.ServiceManager;
import de.vw.mib.debuginterface.target.tester.WidgetFunctions$SpellerButtonSearchListener;
import de.vw.mib.widgets.AbstractSpeller;
import de.vw.mib.widgets.View;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.WidgetListModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.speller.Alphabet;
import de.vw.mib.widgets.speller.SpellerElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WidgetFunctions {
    public int xOffset;
    public int yOffset;
    private final Object[] NO_PARAMETERS = null;
    private static String[] SUPPORTED_SPELLER_FUNCTIONS = new String[]{"", "FUNC_DEL", "FUNC_OK", "FUNC_ALT_0", "FUNC_ALT_1", "FUNC_ALT_2", "FUNC_LANG"};

    private WidgetModel parseViewByWidgetId(boolean bl, List list, int n, int n2) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ListItemModel listItemModel;
            Object[] objectArray;
            WidgetModel widgetModel = (WidgetModel)iterator.next();
            if (widgetModel.get_targetId() == n2) {
                this.xOffset = widgetModel.getAbsX();
                this.yOffset = widgetModel.getAbsY();
                return widgetModel;
            }
            if (!(bl && widgetModel instanceof WidgetListModel ? (objectArray = (Object[])widgetModel).get_itemCount() > n && (widgetModel = this.parseViewByWidgetId(bl, Arrays.asList((listItemModel = objectArray.getItem(n)).getChildren()), n, n2)) != null : widgetModel instanceof ContainerModel && (widgetModel = this.parseViewByWidgetId(bl, Arrays.asList(objectArray = ((ContainerModel)widgetModel).getChildren()), n, n2)) != null)) continue;
            return widgetModel;
        }
        return null;
    }

    public void findSpellerButton(int n, WidgetFunctions$SpellerButtonSearchListener widgetFunctions$SpellerButtonSearchListener) {
        View[] viewArray = ServiceManager.viewManager.getCurrentViewStack();
        for (int i2 = 0; i2 < viewArray.length; ++i2) {
            if (!this.findSpellerButtonInView(Arrays.asList(viewArray[i2].getChildren()), n, widgetFunctions$SpellerButtonSearchListener)) continue;
            return;
        }
        if (widgetFunctions$SpellerButtonSearchListener != null) {
            widgetFunctions$SpellerButtonSearchListener.error("No speller opend.");
        }
    }

    private boolean findSpellerButtonInView(List list, int n, WidgetFunctions$SpellerButtonSearchListener widgetFunctions$SpellerButtonSearchListener) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object[] objectArray;
            WidgetModel widgetModel = (WidgetModel)iterator.next();
            if (widgetModel instanceof AbstractSpeller) {
                this.findRightButton((AbstractSpeller)widgetModel, n, widgetFunctions$SpellerButtonSearchListener);
                return true;
            }
            if (widgetModel instanceof WidgetListModel) {
                objectArray = (Object[])widgetModel;
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < objectArray.get_itemCount(); ++i2) {
                    arrayList.add(objectArray.getItem(i2));
                }
                if (!this.findSpellerButtonInView(arrayList, n, widgetFunctions$SpellerButtonSearchListener)) continue;
                return true;
            }
            if (!(widgetModel instanceof ContainerModel) || !this.findSpellerButtonInView(Arrays.asList(objectArray = ((ContainerModel)widgetModel).getChildren()), n, widgetFunctions$SpellerButtonSearchListener)) continue;
            return true;
        }
        return false;
    }

    private void findRightButton(AbstractSpeller abstractSpeller, int n, WidgetFunctions$SpellerButtonSearchListener widgetFunctions$SpellerButtonSearchListener) {
        block4: {
            try {
                Alphabet alphabet = abstractSpeller.getCurrentAlphabet();
                if (alphabet == null) {
                    widgetFunctions$SpellerButtonSearchListener.error("Button list not found in speller widget");
                    return;
                }
                if (!this.findCharInClonedButtons(alphabet, abstractSpeller, n, widgetFunctions$SpellerButtonSearchListener) && widgetFunctions$SpellerButtonSearchListener != null) {
                    widgetFunctions$SpellerButtonSearchListener.error("Speller button not found.");
                }
            }
            catch (Exception exception) {
                if (widgetFunctions$SpellerButtonSearchListener == null) break block4;
                widgetFunctions$SpellerButtonSearchListener.error(new StringBuffer().append("Exception while finding right speller button ").append(exception.getMessage()).toString());
            }
        }
    }

    private boolean findCharInClonedButtons(Alphabet alphabet, AbstractSpeller abstractSpeller, int n, WidgetFunctions$SpellerButtonSearchListener widgetFunctions$SpellerButtonSearchListener) {
        if (n <= 0) {
            return this.checkFunctionMatch(alphabet, abstractSpeller, n, widgetFunctions$SpellerButtonSearchListener);
        }
        return this.checkTextMatch(alphabet, abstractSpeller, n, widgetFunctions$SpellerButtonSearchListener);
    }

    private boolean checkFunctionMatch(Alphabet alphabet, AbstractSpeller abstractSpeller, int n, WidgetFunctions$SpellerButtonSearchListener widgetFunctions$SpellerButtonSearchListener) {
        int n2 = n * -1;
        if (n2 <= 0 && n2 >= SUPPORTED_SPELLER_FUNCTIONS.length) {
            widgetFunctions$SpellerButtonSearchListener.error("Function not supported.");
            return true;
        }
        String string = SUPPORTED_SPELLER_FUNCTIONS[n2];
        for (int i2 = 0; i2 < alphabet.getElementCount(); ++i2) {
            SpellerElement spellerElement = alphabet.getElement(i2);
            String string2 = spellerElement.getReturnFunction();
            if (!string.equals(string2)) continue;
            this.fillSendBackForSpeller(spellerElement, null, null, widgetFunctions$SpellerButtonSearchListener);
            return true;
        }
        return false;
    }

    private boolean checkTextMatch(Alphabet alphabet, AbstractSpeller abstractSpeller, int n, WidgetFunctions$SpellerButtonSearchListener widgetFunctions$SpellerButtonSearchListener) {
        for (int i2 = 0; i2 < alphabet.getElementCount(); ++i2) {
            SpellerElement spellerElement = alphabet.getElement(i2);
            String string = spellerElement.getReturnValue();
            String string2 = Character.toString((char)n);
            if (spellerElement.hasSubSpellerElement()) {
                string = spellerElement.getSubSpellerElement().getReturnValue();
                continue;
            }
            if (string2.equals(" ")) {
                if (!string.equalsIgnoreCase(string2) || !spellerElement.getReturnFunction().equals("FUNC_NONE")) continue;
                this.keyFound(alphabet, abstractSpeller, widgetFunctions$SpellerButtonSearchListener, spellerElement, string, string2);
                return true;
            }
            if (string.equalsIgnoreCase(string2)) {
                this.keyFound(alphabet, abstractSpeller, widgetFunctions$SpellerButtonSearchListener, spellerElement, string, string2);
                return true;
            }
            Alphabet alphabet2 = spellerElement.getSubAlphabet();
            if (alphabet2 == null) continue;
            for (int i3 = 0; i3 < alphabet2.getElementCount(); ++i3) {
                SpellerElement spellerElement2 = alphabet2.getElement(i3);
                String string3 = spellerElement2.getReturnValue();
                if (!string3.equalsIgnoreCase(string2)) continue;
                Alphabet alphabet3 = abstractSpeller.getSubAlphabet();
                if (alphabet3 != null && alphabet3.equals(alphabet2)) {
                    this.keyFound(alphabet, abstractSpeller, widgetFunctions$SpellerButtonSearchListener, spellerElement2, string3, string2);
                } else if (abstractSpeller.getSpellerElementStates().isEnabled(spellerElement2) && abstractSpeller.getSpellerElementStates().isEnabled(spellerElement)) {
                    this.fillSendBackForSpeller(spellerElement2, spellerElement, string3.equals(string2) ? null : this.findUpperLowerCaseButton(alphabet), widgetFunctions$SpellerButtonSearchListener);
                } else {
                    this.spellerNotReadyNow(widgetFunctions$SpellerButtonSearchListener);
                }
                return true;
            }
        }
        return false;
    }

    private void keyFound(Alphabet alphabet, AbstractSpeller abstractSpeller, WidgetFunctions$SpellerButtonSearchListener widgetFunctions$SpellerButtonSearchListener, SpellerElement spellerElement, String string, String string2) {
        if (abstractSpeller.getSpellerElementStates().isEnabled(spellerElement)) {
            this.fillSendBackForSpeller(spellerElement, null, string.equals(string2) ? null : this.findUpperLowerCaseButton(alphabet), widgetFunctions$SpellerButtonSearchListener);
        } else {
            this.spellerNotReadyNow(widgetFunctions$SpellerButtonSearchListener);
        }
    }

    private SpellerElement findUpperLowerCaseButton(Alphabet alphabet) {
        SpellerElement spellerElement = null;
        char c2 = '\u2191';
        for (int i2 = 0; i2 < alphabet.getElementCount(); ++i2) {
            SpellerElement spellerElement2 = alphabet.getElement(i2);
            char c3 = spellerElement2.getReturnValue().charAt(0);
            if (c3 != c2) continue;
            spellerElement = spellerElement2;
        }
        return spellerElement;
    }

    private void spellerNotReadyNow(WidgetFunctions$SpellerButtonSearchListener widgetFunctions$SpellerButtonSearchListener) {
        widgetFunctions$SpellerButtonSearchListener.notReadyNow();
    }

    private void fillSendBackForSpeller(SpellerElement spellerElement, SpellerElement spellerElement2, SpellerElement spellerElement3, WidgetFunctions$SpellerButtonSearchListener widgetFunctions$SpellerButtonSearchListener) {
        if (widgetFunctions$SpellerButtonSearchListener == null) {
            return;
        }
        widgetFunctions$SpellerButtonSearchListener.foundSpellerElement(spellerElement, spellerElement2, spellerElement3);
    }

    public WidgetModel findWidgetByID(boolean bl, int n, int n2, int[] nArray) {
        WidgetModel widgetModel = this.findWidgetByID(bl, n, n2);
        if (widgetModel != null) {
            if (widgetModel instanceof WidgetListModel) {
                this.xOffset += ((WidgetListModel)widgetModel).getItemX(n2);
                this.yOffset += ((WidgetListModel)widgetModel).getItemY(n2);
                nArray[0] = this.xOffset;
                nArray[1] = this.yOffset;
                nArray[2] = ((WidgetListModel)widgetModel).getItemWidth(n2);
                nArray[3] = ((WidgetListModel)widgetModel).getItemHeight(n2);
            } else {
                nArray[0] = this.xOffset;
                nArray[1] = this.yOffset;
                nArray[2] = widgetModel.get_width();
                nArray[3] = widgetModel.get_height();
            }
        }
        return widgetModel;
    }

    public WidgetModel findWidgetByID(boolean bl, int n, int n2) {
        View[] viewArray = ServiceManager.viewManager.getCurrentViewStack();
        WidgetModel widgetModel = null;
        for (int i2 = 0; i2 < viewArray.length; ++i2) {
            this.xOffset = 0;
            this.yOffset = 0;
            if (viewArray[i2].get_targetId() == n) {
                return viewArray[i2];
            }
            widgetModel = this.parseViewByWidgetId(bl, Arrays.asList(viewArray[i2].getChildren()), n2, n);
            if (widgetModel != null) break;
        }
        return widgetModel;
    }

    public Object invokeWidgetMethod(WidgetModel widgetModel, String string) {
        Method method = null;
        Class clazz = Class.forName(super.getClass().getName());
        method = clazz.getMethod(string, null);
        return method.invoke(widgetModel, this.NO_PARAMETERS);
    }

    public WidgetModel findTouchedWidget(int n, int n2, ContainerModel containerModel) {
        ArrayList arrayList = new ArrayList();
        containerModel.findTouchEventConsumingWidgets(arrayList, n, n2);
        if (arrayList.size() > 0) {
            return (WidgetModel)arrayList.get(0);
        }
        return null;
    }
}

