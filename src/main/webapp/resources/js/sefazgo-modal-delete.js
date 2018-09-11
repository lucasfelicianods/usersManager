$('#modalDeleteConfirmation').on('show.bs.modal',
	function(event) {
		var button = $(event.relatedTarget)
		var actionUrl = button.data('action-url')
		var recordId = button.data('record-id')
		var recordName = button.data('record-name')
		var modal = $(this)
		modal.find('.btn-primary').attr("onclick", "location.href='" + actionUrl + "/" + recordId + "'");
		modal.find('.modal-body').text("Are you sure to delete '" + recordName + "'?")
	}
)