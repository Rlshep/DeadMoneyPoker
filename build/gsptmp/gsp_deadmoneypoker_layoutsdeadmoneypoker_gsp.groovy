import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_deadmoneypoker_layoutsdeadmoneypoker_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/deadmoneypoker.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',10,['default':("Dead Money Poker")],-1)
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(2)
invokeTag('javascript','asset',12,['src':("application.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',13,['src':("jquery-ui.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',14,['src':("jquery.dataTables.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',15,['src':("MonthPicker.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',16,['src':("date-en-US.js")],-1)
printHtmlPart(2)
invokeTag('stylesheet','asset',18,['src':("deadmoneypoker.dataTables.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',19,['src':("deadmoneypoker.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',20,['src':("MonthPicker.css")],-1)
printHtmlPart(3)
invokeTag('layoutHead','g',23,[:],-1)
printHtmlPart(1)
invokeTag('javascript','g',24,['library':("core")],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',25,[:],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',26,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('applyLayout','g',28,['name':("header")],-1)
printHtmlPart(4)
invokeTag('applyLayout','g',29,['name':("menu")],-1)
printHtmlPart(5)
invokeTag('image','asset',31,['src':("dm_head.png"),'id':("left-screen-background-image")],-1)
printHtmlPart(4)
invokeTag('image','asset',32,['src':("dm_middle.png"),'id':("middle-screen-background-image")],-1)
printHtmlPart(4)
invokeTag('image','asset',33,['src':("dm_suits.png"),'id':("right-screen-background-image")],-1)
printHtmlPart(6)
invokeTag('layoutBody','g',36,[:],-1)
printHtmlPart(7)
invokeTag('layoutResources','r',38,[:],-1)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',39,[:],1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1442459883202L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
