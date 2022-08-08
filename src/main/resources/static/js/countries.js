var buttonLoad;
var dropDownCountries;
var buttonAdd;
var countryName;

$(document).ready(function() {
    buttonLoad = $("#countryListButton");
    dropDownCountries = $("#dropDownCountries");
    buttonAdd = $("#addButton");
    countryName = $("#countryName");


    buttonLoad.click(function() {
        loadCountries();
    });

    buttonAdd.click(function() {
        addCountry();
    })
});

function loadCountries() {
    url = "/api/countries";

    $.get(url, function(responseJson) {
        dropDownCountries.empty();

        $.each(responseJson, function(index, country) {
            $("<option>").val(country.id).text(country.name).appendTo(dropDownCountries);
        });

    }).done(function() {
    }).fail(function() {
    });
}

function addCountry() {
    url = "/api/countries";
    countryNameValue = countryName.val();
    jsonData = {name : countryNameValue};

    $.ajax({
        type: "POST",
        url: url,
        data: JSON.stringify(jsonData),
        contentType: "application/json"
    }).done(function(countryId) {
    }).fail(function() {
    });
}

