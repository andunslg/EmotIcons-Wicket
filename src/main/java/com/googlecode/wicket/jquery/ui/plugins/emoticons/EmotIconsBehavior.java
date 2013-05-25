package com.googlecode.wicket.jquery.ui.plugins.emoticons;

import com.googlecode.wicket.jquery.core.JQueryBehavior;
import com.googlecode.wicket.jquery.core.Options;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.resource.JQueryPluginResourceReference;
import org.apache.wicket.resource.JQueryResourceReference;

import java.util.HashMap;

public class EmotIconsBehavior extends JQueryBehavior{


	private static final JavaScriptResourceReference JS1=new JavaScriptResourceReference(EmotIconsBehavior.class,"jquery.cssemoticons.js");
	private static final CssResourceReference CSS1=new CssResourceReference(EmotIconsBehavior.class,"jquery.cssemoticons.css");

	public EmotIconsBehavior(String selector, String method){
		super(selector,method);
		this.add(JS1);
		this.add(CSS1);
	}

	public EmotIconsBehavior(String selector, String method, Options options){
		super(selector,method,options);
		this.add(JS1);
		this.add(CSS1);
	}

}