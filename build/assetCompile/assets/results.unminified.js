var dataTable;

function init() {
    $({}).queue(initDatePicker)
        .queue(handleDateFromParam)
        .queue(load);
};

function handleDateFromParam (next) {
    var date = getUrlParameter('datePlayed');

    if (date) {
        $('#datePicker').val(date);
    }

    next();
};

function load() {
    dataTable = $('#resultsTable').DataTable({
        columns: [
            {"data" : "rank" },
            {"data" : "playerName"},
            {"data" : "points"},
            {"data" : "hits"},
            {"data" : "roundOut"},
            {"data" : "timeOut"},
            {"data" : "hitmanName"},
            {"data" : "winnings",
             "render" : function(val, type, row, meta) {
                return "<div class='alignRight'> " + val.toFixed(2) + "</div>";
             }},
            {"data" : "datePlayed",
             "visible" : false}
        ],
        destroy: true,
        paging: false,
        searching: false,
        scrollCollapse: true,
        responsive: true,
        autoWidth: true,
        ajax: {
            url: location.pathname + "/load?selectedDate=" + $("#datePicker").val()
        },
        initComplete: function() {
            $('#datePicker').val($('#resultsTable').DataTable().row(0).data().datePlayed);
        }
    });
};
function initDatePicker(next) {
    $.ajax({
		  url: location.pathname + "/loadDateRange",
		  dataType: "json",
		  cache: false
		}).done(function(data) {
            $('#datePicker').MonthPicker({
                ShowIcon: true,
                MinDate: new Date(data.lowDate.slice(3, 7), parseInt(data.lowDate.slice(0, 2)) - 1, 1, 0, 0, 0, 0),
                MaxDate: new Date(data.highDate.slice(3, 7), parseInt(data.highDate.slice(0, 2)) - 1, 1, 0, 0, 0, 0)
             });

             setDatePickerEvent();
             next();
    	});
};

function setDatePickerEvent() {
    $("#datePicker").off("change");
    $("#datePicker").on("change", function() {
        reloadTable(dataTable);
    });
};

function reloadTable(dataTable) {
    var url = location.pathname + "/load?selectedDate=" + $("#datePicker").val();
    dataTable.ajax.url(url).load();
};
