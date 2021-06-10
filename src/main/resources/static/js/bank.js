$('document').ready(function () {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');  // == /countries/findbyId/?id=1  url and id of the clicked button

        $.get(href, function (bank, status) {
            $('#idEdit').val(bank.id);
            $('#nameEdit').val(bank.bankName);
            $('#userNameEdit').val(bank.userName);
            $('#passwordEdit').val(bank.password);
            $('#emailEdit').val(bank.email);
            $('#login_URLEdit').val(bank.login_URL);
            // $('#createdByEdit').val(bank.createdBy);
            // $('#createdDateEdit').val(bank.createdDate.substr(0, 19).replace("T", " "));
        });
        $('#editModal').modal();
    });

    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $('#confirmDeleteButton').attr('href', href);

        $('#deleteModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (bank, status) {
            $('#idDetails').val(bank.id);
            $('#bankNameDetails').val(bank.bankName);
            $('#userNameDetails').val(bank.userName);
            $('#passwordDetails').val(bank.password);
            $('#emailDetails').val(bank.email);
            $('#login_URLDetails').val(bank.login_URL);
            $('#bankLastModifiedByDetails').val(bank.lastModifiedBy);
            $('#bankLastModifiedDateDetails').val(bank.lastModifiedDate.substr(0, 19).replace("T", " "));
            $('#bankCreatedByDetails').val(bank.createdBy);
            $('#BankCreatedDateDetails').val(bank.createdDate.substr(0, 19).replace("T", " "));
        });
        $('#detailsModal').modal();
    });

});