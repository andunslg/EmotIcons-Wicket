package org.wiketstuff.emoticons;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class EmotIconsBehavior extends Behavior{
	private String tagClass;
	private static final JavaScriptResourceReference JS1=new JavaScriptResourceReference(HomePage.class,"jquery.cssemoticons.js");
	private static final JavaScriptResourceReference JS2=new JavaScriptResourceReference(HomePage.class,"jquery-1.4.2.min.js");
	private static final CssResourceReference CSS1=new CssResourceReference(HomePage.class,"jquery.cssemoticons.css");

	public EmotIconsBehavior(String tagClass){
		this.tagClass=tagClass;
	}

	@Override
	public void renderHead(Component component, IHeaderResponse response){
		response.render(JavaScriptReferenceHeaderItem.forReference(JS1));
		response.render(JavaScriptReferenceHeaderItem.forReference(JS2));
		response.render(CssReferenceHeaderItem.forReference(CSS1));
		onRendered(component);
	}

	public void onRendered(Component component){
		Response response=component.getResponse();

		response.write("<script type=\"text/javascript\">");
		response.write("$(document).ready(function(){"+
				"$('."+tagClass+"').emoticonize({"+
				"});"+
				"});");
		response.write("</script>");
	}
}