<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="deadmoneypoker"/>
		<title>Dead Money Poker - Standings</title>
        <asset:javascript src="standings.js"/>
	</head>
	<body>
      <div id="tableContainer">
        <div class="nowrap titleHead"><span id="tableTitle">Standings for </span> <input type="text" id="datePicker" readonly></div>
  		<table id="standingsTable" class="display compact"></table>

      </div>
        <g:javascript>
            $(document).ready(function(){
                init();
            });
        </g:javascript>
	</body>
</html>