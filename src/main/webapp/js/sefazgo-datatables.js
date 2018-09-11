$(document).ready(function() {
	var datatables = $("[id^=dataTables]");
	var databable;
	for (i = 0; i < datatables.length; i++) {
		$(datatables[i]).DataTable({
			responsive : true
		});
	}
});

$(document).ready(function() {
    $('#datatable').DataTable({
        responsive: true
    });
});