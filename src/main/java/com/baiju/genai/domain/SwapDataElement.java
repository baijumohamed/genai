package com.baiju.genai.domain;

public class SwapDataElement {
    private String elementName;
    private String elementValue;

    public SwapDataElement(String elementName, String elementValue) {
        this.elementName = elementName;
        this.elementValue = elementValue;
    }

    public String getElementName() {
        return elementName;
    }

    public String getElementValue() {
        return elementValue;
    }

    @Override
    public String toString() {
        return "SwapDataElement{" +
                "elementName='" + elementName + '\'' +
                ", elementValue='" + elementValue + '\'' +
                '}';
    }
}
