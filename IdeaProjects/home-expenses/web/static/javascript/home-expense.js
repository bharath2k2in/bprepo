$(document).ready(function () {
    $("#amount").keypress(validateNumber);
});

function submitIncomeExpenseDetails() {

    var amount = parseFloat($("#amount").val());
    var description = $("#desc").val();
    var amountType = $('input[name$="amountType"]:checked').val();

    var category;
    if ($("#expenseCategory").css("display") === "inline-block") {
        category = $("#expenseCategory option:selected").text();
    } else if ($("#incomeCategory").css("display") === "inline-block") {
        category = $("#incomeCategory option:selected").text();
    }

    $.ajax({
        url: "http://localhost:8080/home-expenses/expense/add",
        type: "POST",
        data: JSON.stringify({amount: amount, description: description, category: category, amountType: amountType}),
        contentType: "application/json",
        dataType: "script",
        success: function (data) {
        },
        error: function (e) {
            console.log(JSON.stringify(e));
        }
    });

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