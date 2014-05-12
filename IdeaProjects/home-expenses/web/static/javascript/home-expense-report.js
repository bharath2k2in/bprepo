var submitPeriodBtn;

$(document).ready(function () {
        submitPeriodBtn = $("#submitPeriod");
        submitPeriodBtn.click(getMonthlyReport);
    }
);

function getMonthlyReport() {
    $.ajax({
            url: "http://localhost:8080/home-expenses/income-expense/monthly-report",
            type: "POST",
            data: JSON.stringify({month: "05", year: "2014"}),
            contentType: "application/json",
            dataType: "script",
            success: function (data) {
                $.each(JSON.parse(data), function (key, value) {
                    var row = $("<tr><td>" + value.transactionDate + "</td><td>" + value.description + "</td><td>" + value.categoryName + "</td><td>" + value.amount + "</td><td/><td/></tr>");
                    $("#reportTable").append(row);
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('error: ' + textStatus + ': ' + errorThrown);
            }
        }
    );
}
