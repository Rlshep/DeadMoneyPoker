function init() {
    load();
};

function load() {
    dataTable = $('#roundTable').DataTable({
        destroy: true,
        paging: false,
        searching: false,
        scrollCollapse: true,
        responsive: true,
        autoWidth: true,
        ordering: false,
        info: false
    });
};
