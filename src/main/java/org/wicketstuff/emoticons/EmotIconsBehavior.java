package org.wicketstuff.emoticons;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.resource.JQueryPluginResourceReference;
import org.apache.wicket.resource.JQueryResourceReference;

import java.util.HashMap;

public class EmotIconsBehavior extends Behavior{

	private HashMap<String,String[]> emoticonize=new HashMap<String,String[]>();
	private HashMap<String,String[]> unEmoticonize=new HashMap<String,String[]>();

	private static final JQueryPluginResourceReference JS1=new JQueryPluginResourceReference(EmotIconsBehavior.class,"jquery.cssemoticons.js");
	private static final CssResourceReference CSS1=new CssResourceReference(EmotIconsBehavior.class,"jquery.cssemoticons.css");


	@Override
	public void renderHead(Component component, IHeaderResponse response){
		response.render(JavaScriptReferenceHeaderItem.forReference(JQueryResourceReference.get(),"jquery"));
		response.render(JavaScriptReferenceHeaderItem.forReference(JS1));
		response.render(CssReferenceHeaderItem.forReference(CSS1));
	}


	@Override
	public void afterRender(Component component){
		Response response=component.getResponse();

		response.write("<script type=\"text/javascript\">\n");
		response.write("$(document).ready(function(){\n");
		for(String key : emoticonize.keySet()){
			if(emoticonize.get(key)==null){
				response.write("\t\t\t$('"+key+"').emoticonize({\n"+
						"\t\t\t});\n");
			}
			else{
				String parmArr[]=emoticonize.get(key);
				response.write("\t\t\t$('"+key+"').emoticonize({\n"+
						"\t\t\t\tdelay: "+parmArr[0]+",\n"+
						"\t\t\t\tanimate: "+parmArr[1]+",\n"+
						"\t\t\t\texclude: '"+parmArr[2]+"'\n"+
						"\t\t\t});\n");
			}
		}
		for(String key : unEmoticonize.keySet()){
			if(unEmoticonize.get(key)==null){
				response.write("\t\t\t$('"+key+"').unemoticonize({\n"+
						"\t\t\t});\n");
			}
			else{
				String parmArr[]=unEmoticonize.get(key);
				response.write("\t\t\t$('"+key+"').unemoticonize({\n"+
						"\t\t\t\tdelay: "+parmArr[0]+",\n"+
						"\t\t\t\tanimate: "+parmArr[1]+",\n"+
						"\t\t\t\texclude: '"+parmArr[2]+"'\n"+
						"\t\t\t});\n");
			}
		}


		response.write("});\n");
		response.write("</script>\n");
	}

	public void addEmoticonize(String id){
		emoticonize.put(id,null);
	}

	public void addEmoticonize(String id, String delay, String animate, String exclude){
		String parmArr[]={delay,animate,exclude};
		emoticonize.put(id,parmArr);
	}

	public void addUnemoticonize(String id){
		unEmoticonize.put(id,null);
	}

	public void addUnemoticonize(String id, String delay, String animate, String exclude){
		String parmArr[]={delay,animate,exclude};
		unEmoticonize.put(id,parmArr);
	}


}