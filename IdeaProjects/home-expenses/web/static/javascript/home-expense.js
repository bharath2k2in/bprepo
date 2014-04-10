$(document).ready(function () {
    $("#amount").keypress(validateNumber);
});

function submitIncomeExpenseDetails() {

    var amountDiv = $("#amount");
    var descriptionDiv = $("#desc");
    var expenseCategoryDiv = $("#expenseCategory");
    var incomeCategoryDiv = $("#incomeCategory");

    var amount = parseFloat(amountDiv.val());
    var description = descriptionDiv.val();
    var amountType = $('input[name$="amountType"]:checked').val();

    var category;

    if (expenseCategoryDiv.is(':visible')) {
        category = expenseCategoryDiv.find('option:selected').text();
    } else if (incomeCategoryDiv.is(':visible')) {
        category = incomeCategoryDiv.find('option:selected').text();
    }

    if (isNaN(amount) || category === "Category" || description.trim() === "") {
        alert("Wrong input");
    } else {
        $.ajax({
            url: "http://localhost:8080/home-expenses/expense/add",
            type: "POST",
            data: JSON.stringify({amount: amount, description: description, category: category, amountType: amountType}),
            contentType: "application/json",
            dataType: "script",
            success: function (data) {
                clearInput();
            },
            error: function (e) {
                console.log(JSON.stringify(e));
            }
        });

        var clearInput = function() {
            amountDiv.val("");
            descriptionDiv.val("");
            if (expenseCategoryDiv.css("display") === "inline-block") {
                expenseCategoryDiv.find('option:first').attr('selected', 'selected');
            } else if (incomeCategoryDiv.css("display") === "inline-block") {
                incomeCategoryDiv.find('option:first').attr('selected', 'selected');
            }
        }
    }
}

function showIncomeCategories() {
    $("#incomeCategory").show();
    $("#expenseCategory").hide();
};

function showExpenseCategories() {
    $("#expenseCategory").show();
    $("#incomeCategory").hide();
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
    var amount = $("#amount").val();
    var regex = /^[-]?[0-9,]*[.]?[0-9]*$/;
    if (!regex.test(amount)) {
        $("#amount").addClass("amountError");
    } else {
        $("#amount").removeClass("amountError")
    }
};