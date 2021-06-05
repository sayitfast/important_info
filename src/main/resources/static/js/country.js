$('document').ready(function () {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');  // == /countries/findbyId/?id=1  url and id of the clicked button

        $.get(href, function (country, status) {
            $('#idEdit').val(country.id);
            $('#descriptionEdit').val(country.description);
            $('#capitalEdit').val(country.capital);
            $('#codeEdit').val(country.code);
            $('#continentEdit').val(country.continent);
            $('#nationalityEdit').val(country.nationality);
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
        $.get(href, function (country, status) {
            $('#idDetails').val(country.id);
            $('#descriptionDetails').val(country.description);
            $('#codeDetails').val(country.code);
            $('#capitalDetails').val(country.capital);
            $('#continentDetails').val(country.continent);
            $('#nationalityDetails').val(country.nationality);
            $('#lastModifiedByDetails').val(country.lastModifiedBy);
            $('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0, 19).replace("T", " "));
            $('#createdByDetails').val(country.createdBy);
            $('#createdDateDetails').val(country.createdDate.substr(0, 19).replace("T", " "));
        });
        $('#detailsModal').modal();
    });

});