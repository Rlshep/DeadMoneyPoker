var standingsHeaders;

function init() {
    $({}).queue(loadDropDown)
        .queue(handleDifferentSeason)
        .queue(setChampionshipLink)
        .queue(loadHeaders)
        .queue(load);

    setDropDownEvent();
};

function loadDropDown(next) {
    $.ajax({
		  url: location.pathname + "/getSeasonNames",
		  dataType: "json",
		  cache: false
		}).done(function(data) {
		    for (var i=0; i<data.length; i++) {
                var itemval= '<option value="' + data[i].name + '">'+ data[i].name + '</option>';
                $('#seasons').append(itemval);
            }

            next();
    	});
}

function handleDifferentSeason (next) {
    var name = getUrlParameter('seasonName');

    if (name) {
        $('#seasons').val(name);
    }

    next();
};

function loadHeaders(next) {
    $.ajax({
		  url: location.pathname + "/loadHeaders?seasonName=" + $('#seasons').val(),
		  dataType: "json",
		  cache: false
		}).done(function(data) {
            standingsHeaders = data.data;
            next();
    	});
};

function load(next) {
    var columns = getColumns(standingsHeaders);

    $('#standingsTable').DataTable({
        columns: columns,
        destroy: true,
        paging: false,
        searching: false,
        scrollCollapse: true,
        responsive: true,
        autoWidth: true,
        scrollX: true,
        order: [[columns.length-1, 'desc']],
        ajax: {
            url: location.pathname + "/load?seasonName=" + $('#seasons').val()
        },
        initComplete: function() {
            next();
        }
    });
};

function getColumns() {
    var columns = [];
    var title;

    if (undefined != standingsHeaders) {
        for (var i=0; i<standingsHeaders.length; i++) {

            if (i != 0 && i != (standingsHeaders.length-1)) {
                var titleDate = Date.parse(standingsHeaders[i]);
                title = titleDate.toString('MMM yyyy');
            } else {
                title = standingsHeaders[i];
            }

            columns.push({
                'title' : title,
                'data' : standingsHeaders[i]
            });
        }
   }

    return columns;
};

function setDropDownEvent() {
    $('#seasons').off("change");
    $('#seasons').on("change", function() {
        window.location.href = location.pathname + "?seasonName=" + $('#seasons').val();
    });
};

function setChampionshipLink(next) {
    $.ajax({
	    url: location.pathname + "/getChampionshipResult?seasonName=" + $('#seasons').val(),
		dataType: "json",
		cache: false
	}).done(function(data) {
	    var result = data.data;
        if (result && result.datePlayed) {
            $('#championshipLink').html("<a href='" + "/results?datePlayed=" + result.datePlayed + "'>&nbsp;Championship Result</a>");
        }

        next();
    });
};
