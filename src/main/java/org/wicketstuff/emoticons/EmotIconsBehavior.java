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

	private HashMap<String,String[]> emoticonizeClassMap=new HashMap<String,String[]>();
	private HashMap<String,String[]> unEmoticonizeClassMap=new HashMap<String,String[]>();
	private HashMap<String,String[]> emoticonizeIdMap=new HashMap<String,String[]>();
	private HashMap<String,String[]> unEmoticonizeIdMap=new HashMap<String,String[]>();

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
		for(String key : emoticonizeClassMap.keySet()){
			if(emoticonizeClassMap.get(key)==null){
				response.write("\t\t\t$('."+key+"').emoticonize({\n"+
						"\t\t\t});\n");
			}
			else{
				String parmArr[]=emoticonizeClassMap.get(key);
				response.write("\t\t\t$('."+key+"').emoticonize({\n"+
						"\t\t\t\tdelay: "+parmArr[0]+",\n"+
						"\t\t\t\tanimate: "+parmArr[1]+",\n"+
						"\t\t\t\texclude: '"+parmArr[2]+"'\n"+
						"\t\t\t});\n");
			}
		}
		for(String key : unEmoticonizeClassMap.keySet()){
			if(unEmoticonizeClassMap.get(key)==null){
				response.write("\t\t\t$('."+key+"').unemoticonize({\n"+
						"\t\t\t});\n");
			}
			else{
				String parmArr[]=unEmoticonizeClassMap.get(key);
				response.write("\t\t\t$('."+key+"').unemoticonize({\n"+
						"\t\t\t\tdelay: "+parmArr[0]+",\n"+
						"\t\t\t\tanimate: "+parmArr[1]+",\n"+
						"\t\t\t\texclude: '"+parmArr[2]+"'\n"+
						"\t\t\t});\n");
			}
		}

		for(String key : emoticonizeIdMap.keySet()){
			if(emoticonizeIdMap.get(key)==null){
				response.write("\t\t\t$('#"+key+"').emoticonize({\n"+
						"\t\t\t});\n");
			}
			else{
				String parmArr[]=emoticonizeIdMap.get(key);
				response.write("\t\t\t$('#"+key+"').emoticonize({\n"+
						"\t\t\t\tdelay: "+parmArr[0]+",\n"+
						"\t\t\t\tanimate: "+parmArr[1]+",\n"+
						"\t\t\t\texclude: '"+parmArr[2]+"'\n"+
						"\t\t\t});\n");
			}
		}
		for(String key : unEmoticonizeIdMap.keySet()){
			if(unEmoticonizeIdMap.get(key)==null){
				response.write("\t\t\t$('#"+key+"').unemoticonize({\n"+
						"\t\t\t});\n");
			}
			else{
				String parmArr[]=unEmoticonizeIdMap.get(key);
				response.write("\t\t\t$('#"+key+"').unemoticonize({\n"+
						"\t\t\t\tdelay: "+parmArr[0]+",\n"+
						"\t\t\t\tanimate: "+parmArr[1]+",\n"+
						"\t\t\t\texclude: '"+parmArr[2]+"'\n"+
						"\t\t\t});\n");
			}
		}
		response.write("});\n");
		response.write("</script>\n");
	}

	public void addEmoticonizeClass(String tagClass){
		emoticonizeClassMap.put(tagClass,null);
	}

	public void addEmoticonizeClass(String tagClass, String delay, String animate, String exclude){
		String parmArr[]={delay,animate,exclude};
		emoticonizeClassMap.put(tagClass,parmArr);
	}

	public void addUnemoticonizeClass(String tagClass){
		unEmoticonizeClassMap.put(tagClass,null);
	}

	public void addUnemoticonizeClass(String tagClass, String delay, String animate, String exclude){
		String parmArr[]={delay,animate,exclude};
		unEmoticonizeClassMap.put(tagClass,parmArr);
	}

	public void addEmoticonizeId(String tagClass){
		emoticonizeIdMap.put(tagClass,null);
	}

	public void addEmoticonizeId(String tagClass, String delay, String animate, String exclude){
		String parmArr[]={delay,animate,exclude};
		emoticonizeIdMap.put(tagClass,parmArr);
	}

	public void addUnemoticonizeId(String tagClass){
		unEmoticonizeIdMap.put(tagClass,null);
	}

	public void addUnemoticonizeId(String tagClass, String delay, String animate, String exclude){
		String parmArr[]={delay,animate,exclude};
		unEmoticonizeIdMap.put(tagClass,parmArr);
	}
}