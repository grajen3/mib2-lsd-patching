/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.viewmanager.script;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.viewmanager.script.ScriptWidgetListener;

public abstract class AbstractScriptWidget {
    public boolean inBoolean1;
    public boolean inBoolean2;
    public boolean inBoolean3;
    public boolean inBoolean4;
    public boolean inBoolean5;
    public int inInt1;
    public int inInt2;
    public int inInt3;
    public int inInt4;
    public int inInt5;
    public String inString1;
    public String inString2;
    public String inString3;
    public String inString4;
    public String inString5;
    public int tempint;
    public Font tempFont;
    public boolean tempboolean;
    public String tempString;
    public Color tempColor;
    public Image tempDimensionedImage;
    public Rectangle tempRectangle;
    public Insets tempInsets;
    public LayoutAttribs tempStandardLayout;
    public boolean[] tempbooleanArray;
    public Color[] tempColorArray;
    public Font[] tempFontArray;
    public Image[] tempDimensionedImageArray;
    public Insets[] tempInsetsArray;
    public int[] tempintArray;
    public LayoutAttribs[] tempStandardLayoutArray;
    public Rectangle[] tempRectangleArray;
    public String[] tempStringArray;
    ScriptWidgetListener scriptWidgetListener;
    int sid;

    protected AbstractScriptWidget(ScriptWidgetListener scriptWidgetListener, int n) {
        this.scriptWidgetListener = scriptWidgetListener;
        this.sid = n;
    }

    public void runScript() {
    }

    public void set_inBoolean1(boolean bl) {
        this.inBoolean1 = bl;
    }

    public void set_inBoolean2(boolean bl) {
        this.inBoolean2 = bl;
    }

    public void set_inBoolean3(boolean bl) {
        this.inBoolean3 = bl;
    }

    public void set_inBoolean4(boolean bl) {
        this.inBoolean4 = bl;
    }

    public void set_inBoolean5(boolean bl) {
        this.inBoolean5 = bl;
    }

    public void set_inInt1(int n) {
        this.inInt1 = n;
    }

    public void set_inInt2(int n) {
        this.inInt2 = n;
    }

    public void set_inInt3(int n) {
        this.inInt3 = n;
    }

    public void set_inInt4(int n) {
        this.inInt4 = n;
    }

    public void set_inInt5(int n) {
        this.inInt5 = n;
    }

    public void set_inString1(String string) {
        this.inString1 = string;
    }

    public void set_inString2(String string) {
        this.inString2 = string;
    }

    public void set_inString3(String string) {
        this.inString3 = string;
    }

    public void set_inString4(String string) {
        this.inString4 = string;
    }

    public void set_inString5(String string) {
        this.inString5 = string;
    }

    public boolean getInBoolean1() {
        return this.inBoolean1;
    }

    public boolean getInBoolean2() {
        return this.inBoolean2;
    }

    public boolean getInBoolean3() {
        return this.inBoolean3;
    }

    public boolean getInBoolean4() {
        return this.inBoolean4;
    }

    public boolean getInBoolean5() {
        return this.inBoolean5;
    }

    public int getInInt1() {
        return this.inInt1;
    }

    public int getInInt2() {
        return this.inInt2;
    }

    public int getInInt3() {
        return this.inInt3;
    }

    public int getInInt4() {
        return this.inInt4;
    }

    public int getInInt5() {
        return this.inInt5;
    }

    public String getInString1() {
        return this.inString1;
    }

    public String getInString2() {
        return this.inString2;
    }

    public String getInString3() {
        return this.inString3;
    }

    public String getInString4() {
        return this.inString4;
    }

    public String getInString5() {
        return this.inString5;
    }

    public void setBooleanArrayToOut(int n, boolean[] blArray) {
        this.tempbooleanArray = blArray;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setFlagVectorToOut(int n, boolean[] blArray) {
        this.tempbooleanArray = blArray;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setBooleanToOut(int n, boolean bl) {
        this.tempboolean = bl;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setColorArrayToOut(int n, Color[] colorArray) {
        this.tempColorArray = colorArray;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setColorToOut(int n, Color color) {
        this.tempColor = color;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setFontArrayToOut(int n, Font[] fontArray) {
        this.tempFontArray = fontArray;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setFontToOut(int n, Font font) {
        this.tempFont = font;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setImageArrayToOut(int n, Image[] imageArray) {
        this.tempDimensionedImageArray = imageArray;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setImageToOut(int n, Image image) {
        this.tempDimensionedImage = image;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setInsetsArrayToOut(int n, Insets[] insetsArray) {
        this.tempInsetsArray = insetsArray;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setInsetsToOut(int n, Insets insets) {
        this.tempInsets = insets;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setIntArrayToOut(int n, int[] nArray) {
        this.tempintArray = nArray;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setIntToOut(int n, int n2) {
        this.tempint = n2;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setLayoutArrayToOut(int n, LayoutAttribs[] layoutAttribsArray) {
        this.tempStandardLayoutArray = layoutAttribsArray;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setLayoutToOut(int n, LayoutAttribs layoutAttribs) {
        this.tempStandardLayout = layoutAttribs;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setRectangleArrayToOut(int n, Rectangle[] rectangleArray) {
        this.tempRectangleArray = rectangleArray;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setRectangleToOut(int n, Rectangle rectangle) {
        this.tempRectangle = rectangle;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setStringArrayToOut(int n, String[] stringArray) {
        this.tempStringArray = stringArray;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }

    public void setStringToOut(int n, String string) {
        this.tempString = string;
        this.scriptWidgetListener.setWidgetPropertyByScript(this.sid, n);
    }
}

