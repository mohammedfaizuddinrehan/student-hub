const button = document.getElementById("loginButton");

button.addEventListener("click", function () {

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const loginData = {
        email: email,
        password: password
    };

    fetch("http://localhost:8081/users/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        credentials: "include",
        body: JSON.stringify(loginData)
    })
        .then(response => response.text())
        .then(data => {

            console.log(data);

            if (data === "Login successful") {

                window.location.href = "./student-dashboard.html";

            } else {

                alert("Login failed");

            }

        });

});
