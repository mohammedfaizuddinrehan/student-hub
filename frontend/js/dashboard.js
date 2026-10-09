fetch("http://localhost:8081/users/me", {
    credentials: "include"
})
    .then(response => response.text())
    .then(data => {

        console.log("Current user:", data);

        document.querySelector(".welcome").textContent =
            "Welcome, " + data + " 👋";
    });