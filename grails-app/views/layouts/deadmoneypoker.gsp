<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Dead Money Poker"/></title>

    <asset:javascript src="application.js"/>
    <asset:javascript src="jquery-ui.js"/>
    <asset:javascript src="jquery.dataTables.js"/>
    <!--<asset:javascript src="jquery.maskedinput.min.js"/>-->
    <asset:javascript src="MonthPicker.js"/>
    <asset:javascript src="date-en-US.js"/>
    <asset:javascript src="deadmoneypoker.js"/>

    <!--<asset:stylesheet src="jquery-ui.css"/>-->
    <asset:stylesheet src="deadmoneypoker.dataTables.css"/>
    <asset:stylesheet src="deadmoneypoker.css"/>
    <asset:stylesheet src="MonthPicker.css"/>
    <link href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" media="all" rel="stylesheet" type="text/css" />

    <g:layoutHead/>
    <g:javascript library="core"/>
    <r:layoutResources />
</head>
<body>
<g:applyLayout name="header"/>

<!--<asset:image src="dm_background.jpg" id="background-screen-background-image"/>-->
<asset:image src="dm_head.png" id="left-screen-background-image"/>
<asset:image src="dm_middle.png" id="middle-screen-background-image"/>
<asset:image src="dm_suits.png" id="right-screen-background-image"/>
<div id="wrapper">
    <g:layoutBody/>
</div>
<r:layoutResources />
</body>
</html>
