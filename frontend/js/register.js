const button = document.getElementById("registerButton");

button.addEventListener("click", function () {

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const user = {
        email: email,
        password: password,
        role: "STUDENT"
    };

    fetch("http://localhost:8081/users/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    })
        .then(response => response.json())
        .then(data => {

            console.log(data);

            alert("Registration successful!");

        });

});