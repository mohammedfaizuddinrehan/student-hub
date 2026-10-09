alert("JavaScript is working!");
const button = document.getElementById("addStudent");

button.addEventListener("click", function () {

    const name = document.getElementById("name").value;
    const rollNo = document.getElementById("rollNo").value;
    const email = document.getElementById("email").value;

    const student = {
        name: name,
        rollNo: rollNo,
        email: email
    };

    fetch("http://localhost:8081/students", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            alert("Student added successfully!");
        });
    fetch("http://localhost:8081/students")
        .then(response => response.json())
        .then(data => {

            const studentsDiv = document.getElementById("students");

            data.forEach(student => {

                studentsDiv.innerHTML += `
            <p>
                ${student.id}. ${student.name}
                - ${student.rollNo}
                - ${student.email}
            </p>
        `;

            });

        });

});