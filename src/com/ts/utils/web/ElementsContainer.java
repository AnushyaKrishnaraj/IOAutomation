package com.ts.utils.web;

import java.util.Collection;

/**
 * Created by svelupula on 8/8/2015.
 */
public interface ElementsContainer {

    HtmlElement findElement(String locator);

    Collection<HtmlElement> findElements(String locator);

    String getDescription();
}
