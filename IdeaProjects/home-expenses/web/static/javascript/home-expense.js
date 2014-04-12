var amountDiv;
var descriptionDiv;
var expenseCategoryDiv;
var incomeCategoryDiv;
var addBtn;
var clearBtn;
var resultMessage;

$(document).ready(function () {
    amountDiv = $("#amount");
    descriptionDiv = $("#desc");
    expenseCategoryDiv = $("#expenseCategory");
    incomeCategoryDiv = $("#incomeCategory");
    addBtn = $("#add");
    clearBtn = $("#clear");
    resultMessage = $("#showResultMessage");

    amountDiv.keypress(validateNumber);
    amountDiv.blur(validateAmount);

    $("input[name$='amountType']").click(showCategories);

    addBtn.click(submitIncomeExpenseDetails);
    clearBtn.click(clearInput);
});

function showCategories() {
    var amountType = $("input[name$='amountType']:checked").val();
    if (amountType === "Income") {
        showIncomeCategories();
    } else if (amountType === "Expense") {
        showExpenseCategories()
    }
}

function submitIncomeExpenseDetails() {

    var amount = parseFloat(amountDiv.val());
    var description = descriptionDiv.val();
    var amountType = $("input[name$='amountType']:checked").val();

    var category;

    if (expenseCategoryDiv.is(':visible')) {
        category = expenseCategoryDiv.find('option:selected').text();
    } else if (incomeCategoryDiv.is(':visible')) {
        category = incomeCategoryDiv.find('option:selected').text();
    }

    if (isNaN(amount) || category === "Category" || description.trim() === "") {
        alert("Wrong Input");
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
                alert("Error occurred while adding : " + JSON.stringify(e));
            }
        });
    }
}

function clearInput() {
    amountDiv.val("");
    descriptionDiv.val("");
    if (expenseCategoryDiv.css("display") === "inline-block") {
        expenseCategoryDiv.find('option:first').attr('selected', 'selected');
    } else if (incomeCategoryDiv.css("display") === "inline-block") {
        incomeCategoryDiv.find('option:first').attr('selected', 'selected');
    }
}

function showIncomeCategories() {
    incomeCategoryDiv.show();
    expenseCategoryDiv.hide();
};

function showExpenseCategories() {
    expenseCategoryDiv.show();
    incomeCategoryDiv.hide();
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
    } else {
        amountDiv.removeClass("amountError")
    }
};

