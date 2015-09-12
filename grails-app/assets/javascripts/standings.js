var standingsHeaders = [];

function init() {
    loadHeaders(function() { load(); });
//    initDatePicker();
};

//function initDatePicker() {
//    $.ajax({
//		  url: location.pathname + "/loadDateRange",
//		  dataType: "json",
//		  cache: false
//		}).done(function(data) {
//            $('#datePicker').MonthPicker({
//                ShowIcon: true,
//                MinDate: new Date(data.lowDate.slice(3, 7), parseInt(data.lowDate.slice(0, 2)) - 1, 1, 0, 0, 0, 0),
//                MaxDate: new Date(data.highDate.slice(3, 7), parseInt(data.highDate.slice(0, 2)) - 1, 1, 0, 0, 0, 0)
//             });
//
//             setDatePickerEvent();
//    	});
//};

function load() {
    var columns = getColumns();

    $('#standingsTable').DataTable({
        columns: columns,
        destroy: true,
        paging: false,
        searching: false,
        scrollCollapse: true,
        responsive: true,
        autoWidth: true,
        order: [[columns.length-1, 'desc']],
        ajax: {
            url: location.pathname + "/load"
        },
        initComplete: function() {
//            $('#datePicker').val($('#standingsTable').DataTable().row(0).data().datePlayed);
        }
    });
};

function loadHeaders(callback) {
    $.ajax({
		  url: location.pathname + "/loadHeaders",
		  dataType: "json",
		  cache: false
		}).done(function(data) {
		    standingsHeaders = data.data;
            callback();
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