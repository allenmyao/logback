/**
 * Logback: the generic, reliable, fast and flexible logging framework.
 * 
 * Copyright (C) 1999-2006, QOS.ch
 * 
 * This library is free software, you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation.
 */
package ch.qos.logback.core.pattern.parser;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.ContextBase;
import ch.qos.logback.core.pattern.PatternLayoutBase;


public class SamplePatternLayoutTest extends AbstractPatternLayoutBaseTest {

  Context context = new ContextBase();
  public SamplePatternLayoutTest(String arg) {
    super(arg);
  }
  

  public PatternLayoutBase<Object> getPatternLayoutBase() {
    return new SamplePatternLayout<Object>();
  }

  public Object getEventObject() {
    return new Object();
  }
  
  public void testOK() {
    PatternLayoutBase<Object> plb = getPatternLayoutBase();
    Context context = new ContextBase();
    plb.setContext(context);
    plb.setPattern("x%OTT");
    plb.start();
    String s = plb.doLayout(new Object());
    //System.out.println(s);

    //StatusManager sm = context.getStatusManager();
    //StatusPrinter.print(sm);
    assertEquals("x123", s);

  }

  @Override
  public Context getContext() {
    return  context;
  }
}
