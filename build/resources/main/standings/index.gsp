<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="deadmoneypoker" />
    <title>Dead Money Poker - Standings</title>
    <asset:javascript src="standings.js" />
</head>

<body>
<div id="tableContainer">
    <div class="nowrap titleHead">
        <span id="tableTitle" class="tableHeader">Standings for </span>
        <select id="seasons"></select>
        <span id="championshipLink" class="tableHeader"></span>
    </div>
    <table id="standingsTable" class="display compact"></table>
</div>
<g:javascript>
    $(document).ready(function(){ init(); });
</g:javascript>
</body>

</html>