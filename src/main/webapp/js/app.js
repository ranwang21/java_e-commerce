// form validation
const validate_form = () => {
    const email = document.getElementById("signup_email").value;
    const password = document.getElementById("signup_password").value;
    const confirm_password = document.getElementById("signup_confirm_password").value;

    if (email == null || email == "" || password == null || password == "") {
        $.alert("Email or password should not be empty");
        return false;
    } else if (password !== confirm_password) {
        $.alert("You should enter the same password twice");
        return false;
        // call the email validate function below to validate email
    } else if (validate_email(email) === false) {
        $.alert("Invalide email adress");
        return false;
    }
    return true;
}

// validate email
const validate_email = (email) => {
    const regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return regex.test(String(email).toLowerCase());
}