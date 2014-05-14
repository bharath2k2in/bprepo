var submitPeriodBtn;
var noRecordsBtn;

$(document).ready(function () {
        submitPeriodBtn = $("#submitPeriod");
        noRecordsBtn = $("#no-records");
        submitPeriodBtn.click(getMonthlyReport);
        noRecordsBtn.click(closePopup);
    }
);

function closePopup() {
    $("#no-records-message").hide();
}

function getMonthlyReport() {
    var month = $("#month").find('option:selected').val();
    var year = $("#year").find('option:selected').val();
    $.ajax({
            url: "http://localhost:8080/home-expenses/income-expense/monthly-report",
            type: "POST",
            data: JSON.stringify({month: month, year: year}),
            contentType: "application/json",
            dataType: "script",
            success: function (data) {
                if (JSON.parse(data).length > 0) {
                    $("#report-table-entry").empty();
                    var count = 1;
                    $.each(JSON.parse(data), function (key, value) {
                        var rowClass = "odd";
                        if(count % 2 === 0) {
                            rowClass = "even";
                        }
                        if (value.categoryType === "Income") {
                            rowClass = rowClass + " income";
                        }
                        var row = $("<tr><td>" + value.transactionDate + "</td><td>" + value.description + "</td><td>" + value.categoryName + "</td><td class='amount'>" + value.amount + "</td></tr>").addClass(rowClass);
                        $("#report-table-entry").append(row);
                        count++;
                    });
                    $(".expense-report").show();
                } else {
                    $(".expense-report").hide();
                    $("#no-records-message").show();
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('error: ' + textStatus + ': ' + errorThrown);
            }
        }
    );
}
