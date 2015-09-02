function init() {
    load();
    initDatePicker();
};

function load() {
    $('#resultsTable').DataTable({
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
            url: location.pathname + "/load"
        },
        initComplete: function() {
            $('#datePicker').val($('#resultsTable').DataTable().row(0).data().datePlayed);
        }
    });
};

function initDatePicker() {
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
    	});
};

function setDatePickerEvent() {
    $("#datePicker").off("change");
    $("#datePicker").on("change", function() {
        reloadTable();
    });
};

function reloadTable() {
    var url = location.pathname + "/load?resultDate=" + $("#datePicker").val();
    $('#resultsTable').DataTable().ajax.url(url).load();
};