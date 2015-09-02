<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="deadmoneypoker"/>
		<title>Dead Money Poker - Results</title>
	</head>
	<body>
      <div id="tableContainer">
        <div class="nowrap titleHead"><span id="tableTitle">Results for </span> <input type="text" id="datePicker" readonly></div>
  		<table id="resultsTable" class="display compact">
            <thead id="tableHeader">
                <tr>
                    <th>Rank</th>
                    <th>Player Name</th>
                    <th>Points</th>
                    <th>Hits</th>
                    <th>Round Out</th>
                    <th>Time Out</th>
                    <th>Hitman</th>
                    <th>Winnings</th>
                </tr>
            </thead>
        </table>

      </div>
        <g:javascript>
            $(document).ready(function(){
                init();
            });
        </g:javascript>
	</body>
</html>