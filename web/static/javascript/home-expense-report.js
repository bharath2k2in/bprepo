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
                    $.each(JSON.parse(data), function (key, value) {
                        var rowClass = "expense";
                        if (value.categoryType === "Income") {
                            rowClass = "income";
                        }
                        var row = $("<tr><td>" + value.transactionDate + "</td><td>" + value.description + "</td><td>" + value.categoryName + "</td><td class='amount'>" + value.amount + "</td></tr>").addClass(rowClass);
                        $("#report-table-entry").append(row);
                    });

                    var table = $('#reportTable').DataTable({
                        "bAutoWidth": false,
                        "aoColumns" : [
                            { sWidth: '20px' },
                            { sWidth: '100px' },
                            { sWidth: '40px' },
                            { sWidth: '20px' }
                        ]
                    });

                    $("#reportTable tfoot th").each(function (i) {
                        var select = $('<select><option value=""></option></select>')
                            .appendTo($(this).empty())
                            .on('change', function () {
                                table.column(i)
                                    .search($(this).val())
                                    .draw();
                            });

                        table.column(i).data().unique().sort().each(function (d, j) {
                            select.append('<option value="' + d + '">' + d + '</option>')
                        });
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
