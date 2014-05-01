var amountDiv;
var descriptionDiv;
var categoryDiv;
var addBtn;
var clearBtn;
var dateDiv;
var validInput = true;

$(document).ready(function () {
        amountDiv = $("#amount");
        descriptionDiv = $("#desc");
        addBtn = $("#add");
        clearBtn = $("#clear");
        dateDiv = $("#datePicker");
        categoryDiv = $("#category");

        amountDiv.keypress(validateNumber);
        amountDiv.blur(validateAmount);

        $("input[name$='categoryType']").click(showCategories);
        dateDiv.datepicker({
                dateFormat: 'yy-mm-dd',
                maxDate: new Date()
            }
        );

        addBtn.click(submitIncomeExpenseDetails);
        clearBtn.click(clearFields);
        
        updateIncomeExpenseReport();
    }
);

function updateIncomeExpenseReport() {
	fillIncomeAndExpense("current");
    fillIncomeAndExpense("previous");
};

function fillIncomeAndExpense(currentOrPrevious) {
	$.ajax({
        url: "http://localhost:8080/home-expenses/income-expense/retrieve",
        type: "POST",
        data: currentOrPrevious,
        contentType: "text/plain",
        success: function (data) {
            $("#" + currentOrPrevious + "MonthIncome").text(data.income);
            $("#" + currentOrPrevious + "MonthExpense").text(data.expense);
            $("#" + currentOrPrevious + "MonthBalance").text(data.difference);
        },
        error: function (e) {
            $("#resultMessage").css('color', 'red').text("Error occurred while retrieving income and expense details");
        }
    })
	
};

function clearFields() {
    clearInput();
    amountDiv.removeClass("amountError");
    $("#resultMessage").css('display', 'block').text("");
};

function showCategories() {
    var categoryType = $("input[name$='categoryType']:checked").val();
    $.ajax({
        url: "http://localhost:8080/home-expenses/category",
        type: "POST",
        data: categoryType,
        contentType: "text/plain",
        success: function (data) {
            categoryDiv.empty();
            $.each(data, function (key, value) {
                categoryDiv.append($('<option></option>').val(value.categoryName).text(value.categoryName));
            });
        },
        error: function (e) {
            $("#resultMessage").css('color', 'red').text("Error occurred while retrieving categories");
        }
    })
};

function submitIncomeExpenseDetails() {

    $("#resultMessage").css('display', 'block').text("");

    var amount = parseFloat(amountDiv.val());
    var description = descriptionDiv.val();
    var categoryType = $("input[name$='categoryType']:checked").val();
    var transactionDate = dateDiv.val();

    var categoryName = categoryDiv.find('option:selected').text();

    if (isNaN(amount) || categoryName === "Category" || description.trim() === "" || !validInput) {
        $("#resultMessage").css('color', 'red').text("Wrong Input");
    } else {
        $.ajax({
                url: "http://localhost:8080/home-expenses/income-expense/add",
                type: "POST",
                data: JSON.stringify({amount: amount, description: description, categoryName: categoryName, categoryType: categoryType, transactionDate: transactionDate}),
                contentType: "application/json",
                dataType: "script",
                success: function (data) {
                    clearInput();
                    $("#resultMessage").css('color', 'green').text("Record added successfully");
                    $("#resultMessage").fadeOut(3000);
                    setTimeout(updateIncomeExpenseReport, 3000);
                },
                error: function (e) {
                    $("#resultMessage").css('color', 'red').text("Error occurred while adding record");
                }
            }
        );
    }
};

function clearInput() {
    amountDiv.val("");
    $("input[name$='categoryType']:checked").each(function(){
        $(this).prop('checked', false);
    });
    descriptionDiv.val("");
    categoryDiv.empty();
    dateDiv.val("");
};

function validateNumber(event) {
    var key = window.event ? event.keyCode : event.which;

    if (event.keyCode == 44 || event.keyCode == 45 || event.keyCode == 46) {
        return true;
    } else if (key < 48 || key > 57) {
        return false;
    } else return true;
};

function validateAmount() {
    var amount = amountDiv.val();
    var regex = /^[-]?[0-9,]*[.]?[0-9]*$/;
    if (!regex.test(amount)) {
        amountDiv.addClass("amountError");
        validInput = false;
    } else {
        amountDiv.removeClass("amountError");
        validInput = true;
    }
};

