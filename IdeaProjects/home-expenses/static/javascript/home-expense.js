$(document).ready(function () {
    $("#amount").keypress(validateNumber);
});

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
    var regex = /^[-]?[0-9,]+[.]?[0-9]+$/;
    if (!regex.test(amount)) {
        $("#amount").addClass("amountError");
    } else {
        $("#amount").removeClass("amountError")
    }
}